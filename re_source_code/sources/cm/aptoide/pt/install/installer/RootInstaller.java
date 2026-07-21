package cm.aptoide.pt.install.installer;

import cm.aptoide.pt.database.room.RoomFileToDownload;
import cm.aptoide.pt.install.InstallerAnalytics;
import cm.aptoide.pt.install.exception.InstallationException;
import cm.aptoide.pt.logger.Logger;
import java.io.File;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class RootInstaller implements rx.e.a<Void> {
    private static final String TAG = "RootInstaller";
    private final InstallerAnalytics analytics;
    private Installation installation;
    private final String packageName;
    private Root root = new Root();

    public RootInstaller(String str, InstallerAnalytics installerAnalytics, Installation installation) {
        this.packageName = str;
        this.analytics = installerAnalytics;
        this.installation = installation;
    }

    private int getFilesSize(Installation installation) {
        int length = 0;
        for (RoomFileToDownload roomFileToDownload : installation.getFiles()) {
            length = (int) (((long) length) + new File(roomFileToDownload.getPath() + roomFileToDownload.getFileName()).length());
        }
        return length;
    }

    @Override // rx.m.b
    public void call(rx.j<? super Void> jVar) {
        Logger.getInstance().d(TAG, "call: start with installation package name: " + this.installation.getPackageName());
        this.analytics.rootInstallStart();
        if (this.root.isTerminated() || !this.root.isAcquired()) {
            Root.requestRoot();
            if (!this.root.isAcquired()) {
                Logger.getInstance().d(TAG, "root is not available");
                jVar.onError(new InstallationException("No root permissions"));
                return;
            }
        }
        String strExec = this.root.exec(String.format(Locale.getDefault(), "pm install-create -i " + this.packageName + " --user %s -r -S %d", "0", Integer.valueOf(getFilesSize(this.installation))));
        if (strExec == null || strExec.length() == 0) {
            InstallationException installationException = new InstallationException(this.root.readError());
            this.analytics.rootInstallFail(installationException);
            jVar.onError(installationException);
            return;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(strExec);
        matcher.find();
        int i2 = Integer.parseInt(matcher.group(1));
        for (RoomFileToDownload roomFileToDownload : this.installation.getFiles()) {
            Logger.getInstance().d(TAG, "started instalation of file: " + roomFileToDownload.getFileName());
            File file = new File(roomFileToDownload.getPath() + roomFileToDownload.getFileName());
            String strExec2 = this.root.exec(String.format(Locale.getDefault(), "cat \"%s\" | pm install-write -S %d %d \"%s\"", file.getAbsolutePath(), Long.valueOf(file.length()), Integer.valueOf(i2), file.getName()));
            if (strExec2 == null || strExec2.length() == 0) {
                InstallationException installationException2 = new InstallationException(this.root.readError());
                this.analytics.rootInstallFail(installationException2);
                jVar.onError(installationException2);
                return;
            }
        }
        String strExec3 = this.root.exec(String.format(Locale.getDefault(), "pm install-commit %d ", Integer.valueOf(i2)));
        if (strExec3 == null || strExec3.length() == 0) {
            InstallationException installationException3 = new InstallationException(this.root.readError());
            this.analytics.rootInstallFail(installationException3);
            jVar.onError(installationException3);
        } else if (!strExec3.toLowerCase().contains(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
            InstallationException installationException4 = new InstallationException(this.root.readError());
            this.analytics.rootInstallFail(installationException4);
            jVar.onError(installationException4);
        } else {
            if (jVar.isUnsubscribed()) {
                return;
            }
            this.analytics.rootInstallCompleted(0);
            jVar.onCompleted();
        }
    }
}
