package cm.aptoide.pt.notification.view;

import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.notification.AptoideNotification;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.notification.NotificationCenter;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InboxPresenter implements Presenter {
    private final int NUMBER_OF_NOTIFICATIONS = 50;
    private final NotificationAnalytics analytics;
    private final CrashReport crashReport;
    private final NavigationTracker navigationTracker;
    private final NotificationCenter notificationCenter;
    private final InboxView view;
    private final rx.h viewScheduler;

    public InboxPresenter(InboxView inboxView, NotificationCenter notificationCenter, CrashReport crashReport, NavigationTracker navigationTracker, NotificationAnalytics notificationAnalytics, rx.h hVar) {
        this.view = inboxView;
        this.notificationCenter = notificationCenter;
        this.crashReport = crashReport;
        this.navigationTracker = navigationTracker;
        this.analytics = notificationAnalytics;
        this.viewScheduler = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(View.LifecycleEvent lifecycleEvent) {
        return this.notificationCenter.getInboxNotifications(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(View.LifecycleEvent lifecycleEvent) {
        return this.notificationCenter.setAllNotificationsRead();
    }

    static /* synthetic */ void lambda$present$12(View.LifecycleEvent lifecycleEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(List list) {
        if (list.isEmpty()) {
            this.view.showEmptyState();
        } else {
            this.view.showNotifications(list);
        }
    }

    static /* synthetic */ void lambda$present$3(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(View.LifecycleEvent lifecycleEvent) {
        return this.view.notificationSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(AptoideNotification aptoideNotification) {
        this.analytics.sendNotificationTouchEvent(aptoideNotification.getNotificationCenterUrlTrack());
        this.navigationTracker.registerScreen(ScreenTagHistory.Builder.build(getClass().getSimpleName()));
    }

    static /* synthetic */ void lambda$present$8(AptoideNotification aptoideNotification) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$present$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        rx.e eVarX = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.notification.view.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.view.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6798f.a((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.notification.view.f
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6800f.d((List) obj);
            }
        });
        InboxView inboxView = this.view;
        View.LifecycleEvent lifecycleEvent = View.LifecycleEvent.DESTROY;
        eVarX.f(inboxView.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.view.g
            @Override // rx.m.b
            public final void call(Object obj) {
                InboxPresenter.lambda$present$3((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.view.n
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6808f.e((Throwable) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.notification.view.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.view.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6807f.f((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.notification.view.l
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6806f.g((AptoideNotification) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.view.c
            @Override // rx.m.b
            public final void call(Object obj) {
                InboxPresenter.lambda$present$8((AptoideNotification) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.view.j
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6804f.h((Throwable) obj);
            }
        });
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.notification.view.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.view.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6795f.b((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(lifecycleEvent)).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.view.h
            @Override // rx.m.b
            public final void call(Object obj) {
                InboxPresenter.lambda$present$12((View.LifecycleEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.view.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6803f.c((Throwable) obj);
            }
        });
    }
}
