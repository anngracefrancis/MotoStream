package cm.aptoide.pt.install;

import android.os.Build;
import cm.aptoide.pt.AppInBackgroundTracker;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.notification.AptoideNotification;
import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import cm.aptoide.pt.presenter.Presenter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class DownloadsNotificationsPresenter implements Presenter {
    private static final String TAG = "DownloadsNotificationsPresenter";
    private AppInBackgroundTracker appInBackgroundTracker;
    private InstallManager installManager;
    private NotificationProvider notificationProvider;
    private DownloadsNotification service;
    private rx.t.b subscriptions = new rx.t.b();

    public DownloadsNotificationsPresenter(DownloadsNotification downloadsNotification, InstallManager installManager, AppInBackgroundTracker appInBackgroundTracker, NotificationProvider notificationProvider) {
        this.service = downloadsNotification;
        this.installManager = installManager;
        this.appInBackgroundTracker = appInBackgroundTracker;
        this.notificationProvider = notificationProvider;
    }

    private void handleCurrentInstallation() {
        this.subscriptions.a(this.installManager.getCurrentInstallation().w(new rx.m.b() { // from class: cm.aptoide.pt.install.r
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadsNotificationsPresenter.lambda$handleCurrentInstallation$0((Throwable) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.install.x
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6599f.a((Install) obj);
            }
        }).u(new rx.m.e() { // from class: cm.aptoide.pt.install.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((Install) obj).getState();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.install.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6581f.b((Install) obj);
            }
        }).u(new rx.m.e() { // from class: cm.aptoide.pt.install.k3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Integer.valueOf(((RoomDownload) obj).getOverallDownloadStatus());
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.install.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6577f.e((RoomDownload) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.install.w
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadsNotificationsPresenter.lambda$handleCurrentInstallation$6((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.y
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6604f.f((Throwable) obj);
            }
        }));
    }

    private Single<Boolean> hasNextDownload() {
        return this.installManager.hasNextDownload();
    }

    static /* synthetic */ void lambda$handleCurrentInstallation$0(Throwable th) {
        th.printStackTrace();
        Logger.getInstance().d(TAG, "error on getCurrentInstallation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCurrentInstallation$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Install install) {
        if (install.isIndeterminate()) {
            return;
        }
        this.service.setupProgressNotification(install.getMd5(), install.getAppName(), install.getProgress(), install.isIndeterminate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCurrentInstallation$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(Install install) {
        return this.installManager.getDownload(install.getMd5()).A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCurrentInstallation$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(RoomDownload roomDownload, Boolean bool) {
        return saveReadyToInstallNotification(roomDownload.getOverallDownloadStatus(), roomDownload.getIcon(), roomDownload.getAppName(), roomDownload.getPackageName(), roomDownload.getStoreName()).c(Single.m(bool));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCurrentInstallation$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(Boolean bool) {
        Logger.getInstance().d(TAG, "Has next downloads: " + bool);
        if (bool.booleanValue()) {
            return;
        }
        this.service.removeProgressNotificationAndStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCurrentInstallation$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single e(final RoomDownload roomDownload) {
        Install.InstallationStatus installationStatusMapDownloadState = this.installManager.i(roomDownload);
        Logger.getInstance().d(TAG, "Received the state " + installationStatusMapDownloadState);
        return (installationStatusMapDownloadState == Install.InstallationStatus.DOWNLOADING || roomDownload.getOverallDownloadStatus() == 15) ? Single.m(null) : hasNextDownload().i(new rx.m.e() { // from class: cm.aptoide.pt.install.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6589f.c(roomDownload, (Boolean) obj);
            }
        }).g(new rx.m.b() { // from class: cm.aptoide.pt.install.u
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6585f.d((Boolean) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleCurrentInstallation$6(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCurrentInstallation$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.service.removeProgressNotificationAndStop();
        th.printStackTrace();
    }

    private rx.b saveReadyToInstallNotification(int i2, String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT < 29 || !this.appInBackgroundTracker.getIsAppInBackground() || i2 != 1) {
            return rx.b.e();
        }
        return this.notificationProvider.save(new AptoideNotification(str, str2, "aptoideinstall://package=" + str3 + "&store=" + str4 + "&open_type=open_and_install&origin=" + ReadyToInstallNotificationManager.ORIGIN, str, 9));
    }

    public void onDestroy() {
        this.subscriptions.unsubscribe();
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleCurrentInstallation();
    }
}
