package cm.aptoide.pt;

import android.app.NotificationManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.notification.NotificationIdsMapper;
import cm.aptoide.pt.notification.NotificationInfo;
import cm.aptoide.pt.notification.SystemNotificationShower;
import cm.aptoide.pt.presenter.NotificationView;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;

/* JADX INFO: loaded from: classes.dex */
public class NotificationApplicationView extends AptoideApplication implements NotificationView {
    private rx.s.a<View.LifecycleEvent> lifecycleEventBehaviorSubject;
    private SystemNotificationShower systemNotificationShower;

    @Override // cm.aptoide.pt.presenter.View
    public void attachPresenter(Presenter presenter) {
        presenter.present();
    }

    @Override // cm.aptoide.pt.presenter.View
    public <T> com.trello.rxlifecycle.b<T> bindUntilEvent(View.LifecycleEvent lifecycleEvent) {
        return com.trello.rxlifecycle.c.b(getLifecycleEvent(), lifecycleEvent);
    }

    @Override // cm.aptoide.pt.presenter.NotificationView
    public rx.e<NotificationInfo> getActionBootCompleted() {
        return getNotificationsPublishRelay().D(new rx.m.e() { // from class: cm.aptoide.pt.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((NotificationInfo) obj).getAction().equals("android.intent.action.BOOT_COMPLETED"));
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.View
    public rx.e<View.LifecycleEvent> getLifecycleEvent() {
        return this.lifecycleEventBehaviorSubject;
    }

    @Override // cm.aptoide.pt.presenter.NotificationView
    public rx.e<NotificationInfo> getNotificationClick() {
        return getNotificationsPublishRelay().D(new rx.m.e() { // from class: cm.aptoide.pt.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((NotificationInfo) obj).getAction().equals(SystemNotificationShower.NOTIFICATION_PRESSED_ACTION));
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.NotificationView
    public rx.e<NotificationInfo> getNotificationDismissed() {
        return getNotificationsPublishRelay().D(new rx.m.e() { // from class: cm.aptoide.pt.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((NotificationInfo) obj).getAction().equals(SystemNotificationShower.NOTIFICATION_DISMISSED_ACTION));
            }
        });
    }

    @Override // cm.aptoide.pt.AptoideApplication
    protected SystemNotificationShower getSystemNotificationShower() {
        if (this.systemNotificationShower == null) {
            this.systemNotificationShower = new SystemNotificationShower(this, (NotificationManager) getSystemService("notification"), new NotificationIdsMapper(), getNotificationCenter(), getNotificationAnalytics(), CrashReport.getInstance(), getNotificationProvider(), this, new rx.t.b(), getNavigationTracker(), getNewFeatureManager(), getThemeAnalytics(), getReadyToInstallNotificationManager());
        }
        return this.systemNotificationShower;
    }

    @Override // cm.aptoide.pt.AptoideApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        rx.s.a<View.LifecycleEvent> aVarG1 = rx.s.a.g1();
        this.lifecycleEventBehaviorSubject = aVarG1;
        aVarG1.onNext(View.LifecycleEvent.CREATE);
        attachPresenter(getSystemNotificationShower());
    }
}
