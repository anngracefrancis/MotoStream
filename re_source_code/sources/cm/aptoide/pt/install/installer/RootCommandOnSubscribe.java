package cm.aptoide.pt.install.installer;

import cm.aptoide.pt.install.InstallerAnalytics;
import cm.aptoide.pt.install.RootCommandTimeoutException;
import cm.aptoide.pt.install.exception.InstallationException;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.root.RootShell;
import cm.aptoide.pt.root.exceptions.RootDeniedException;
import cm.aptoide.pt.root.execution.Command;
import cm.aptoide.pt.root.execution.Shell;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class RootCommandOnSubscribe implements rx.e.a<Void> {
    public static final String SUCCESS_OUTPUT_CONFIRMATION = "success";
    private static final String TAG = "RootCommandOnSubscribe";
    public static final String TIMEOUT_EXCEPTION = "Timeout Exception";
    private InstallerAnalytics analytics;
    private String command;
    private final int installId;
    private boolean success = false;

    public RootCommandOnSubscribe(int i2, String str, InstallerAnalytics installerAnalytics) {
        this.installId = i2;
        this.command = str;
        this.analytics = installerAnalytics;
    }

    static /* synthetic */ void lambda$call$0(Shell shell) {
        try {
            shell.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // rx.m.b
    public void call(final rx.j<? super Void> jVar) {
        Logger logger = Logger.getInstance();
        String str = TAG;
        logger.d(str, "call: start with installation id: " + this.installId);
        try {
            final Shell shell = RootShell.getShell(true);
            if (!RootShell.isRootAvailable()) {
                jVar.onError(new InstallationException("No root permissions"));
                Logger.getInstance().d(str, "call: root not available");
            } else {
                this.analytics.rootInstallStart();
                Command command = new Command(this.installId, new String[]{this.command}) { // from class: cm.aptoide.pt.install.installer.RootCommandOnSubscribe.1
                    @Override // cm.aptoide.pt.root.execution.Command
                    public void commandCompleted(int i2, int i3) {
                        Logger.getInstance().d(RootCommandOnSubscribe.TAG, "commandCompleted: " + i3);
                        if (!jVar.isUnsubscribed() && RootCommandOnSubscribe.this.installId == i2) {
                            if (RootCommandOnSubscribe.this.success || i3 == 0) {
                                jVar.onCompleted();
                                RootCommandOnSubscribe.this.analytics.rootInstallCompleted(i3);
                            } else {
                                IllegalStateException illegalStateException = new IllegalStateException("success message wasn't received. Exit code: " + i3);
                                RootCommandOnSubscribe.this.analytics.rootInstallFail(illegalStateException);
                                jVar.onError(illegalStateException);
                            }
                        }
                        super.commandCompleted(i2, i3);
                    }

                    @Override // cm.aptoide.pt.root.execution.Command
                    public void commandOutput(int i2, String str2) {
                        Logger.getInstance().d(RootCommandOnSubscribe.TAG, "commandOutput: " + str2);
                        if (i2 == RootCommandOnSubscribe.this.installId && str2.toLowerCase().equals(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
                            RootCommandOnSubscribe.this.success = true;
                        }
                        super.commandOutput(i2, str2);
                    }

                    @Override // cm.aptoide.pt.root.execution.Command
                    public void commandTerminated(int i2, String str2) {
                        Logger.getInstance().d(RootCommandOnSubscribe.TAG, "commandTerminated: " + str2);
                        super.commandTerminated(i2, str2);
                        if (RootCommandOnSubscribe.this.installId == i2) {
                            if (str2.equals(RootCommandOnSubscribe.TIMEOUT_EXCEPTION)) {
                                RootCommandOnSubscribe.this.analytics.rootInstallTimeout();
                                jVar.onError(new RootCommandTimeoutException());
                            } else {
                                if (jVar.isUnsubscribed()) {
                                    return;
                                }
                                IllegalStateException illegalStateException = new IllegalStateException(str2);
                                RootCommandOnSubscribe.this.analytics.rootInstallFail(illegalStateException);
                                jVar.onError(illegalStateException);
                            }
                        }
                    }
                };
                jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.install.installer.n0
                    @Override // rx.m.a
                    public final void call() {
                        RootCommandOnSubscribe.lambda$call$0(shell);
                    }
                }));
                shell.add(command);
            }
        } catch (RootDeniedException | IOException | TimeoutException e2) {
            if (e2 instanceof RootDeniedException) {
                this.analytics.rootInstallCancelled();
                jVar.onError(new InstallationException("User didn't accept root permissions"));
            } else if (!(e2 instanceof TimeoutException)) {
                this.analytics.rootInstallFail(e2);
                jVar.onError(e2);
            } else {
                jVar.onError(new RootCommandTimeoutException());
                this.analytics.rootInstallTimeout();
                Logger.getInstance().d(TAG, "call: timeout reached");
            }
        }
    }
}
