package cm.aptoide.pt.install;

import cm.aptoide.pt.packageinstaller.InstallStatus;

/* JADX INFO: loaded from: classes.dex */
public class AppInstallerStatusReceiver {
    private rx.s.b<InstallStatus> installStatusPublishSubject;

    public AppInstallerStatusReceiver(rx.s.b<InstallStatus> bVar) {
        this.installStatusPublishSubject = bVar;
    }

    public rx.e<InstallStatus> getInstallerInstallStatus() {
        return this.installStatusPublishSubject;
    }

    public void onStatusReceived(InstallStatus installStatus) {
        this.installStatusPublishSubject.onNext(installStatus);
    }
}
