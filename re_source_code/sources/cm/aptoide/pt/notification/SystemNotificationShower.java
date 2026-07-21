package cm.aptoide.pt.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.NotificationApplicationView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.install.installer.RootInstallErrorNotification;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.themes.NewFeatureManager;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.view.MainActivity;
import java.util.Arrays;
import java.util.concurrent.Callable;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class SystemNotificationShower implements Presenter {
    public static final String ANDROID_NOTIFICATION_CHANNEL_ID = "AndroidNotification";
    public static final String LOCAL_NOTIFICATION_CHANNEL_ID = "LocalNotification";
    public static final String NEW_FEATURE_NOTIFICATION_CHANNEL_ID = "NewFeatureNotification";
    public static final String NOTIFICATION_DISMISSED_ACTION = "PUSH_NOTIFICATION_DISMISSED";
    public static final String NOTIFICATION_NOTIFICATION_ID = "PUSH_NOTIFICATION_NOTIFICATION_ID";
    public static final String NOTIFICATION_PRESSED_ACTION = "NOTIFICATION_PRESSED_ACTION";
    public static final String NOTIFICATION_TARGET_URL = "PUSH_NOTIFICATION_TARGET_URL";
    public static final String NOTIFICATION_TRACK_URL = "PUSH_NOTIFICATION_TRACK_URL";
    private Context context;
    private CrashReport crashReport;
    private final NavigationTracker navigationTracker;
    private NewFeatureManager newFeatureManager;
    private NotificationAnalytics notificationAnalytics;
    private NotificationCenter notificationCenter;
    private NotificationIdsMapper notificationIdsMapper;
    private NotificationManager notificationManager;
    private NotificationProvider notificationProvider;
    private ReadyToInstallNotificationManager readyToInstallNotificationManager;
    private rx.t.b subscriptions;
    private ThemeAnalytics themeAnalytics;
    private NotificationApplicationView view;

    public SystemNotificationShower(Context context, NotificationManager notificationManager, NotificationIdsMapper notificationIdsMapper, NotificationCenter notificationCenter, NotificationAnalytics notificationAnalytics, CrashReport crashReport, NotificationProvider notificationProvider, NotificationApplicationView notificationApplicationView, rx.t.b bVar, NavigationTracker navigationTracker, NewFeatureManager newFeatureManager, ThemeAnalytics themeAnalytics, ReadyToInstallNotificationManager readyToInstallNotificationManager) {
        this.context = context;
        this.notificationManager = notificationManager;
        this.notificationIdsMapper = notificationIdsMapper;
        this.notificationCenter = notificationCenter;
        this.notificationAnalytics = notificationAnalytics;
        this.crashReport = crashReport;
        this.notificationProvider = notificationProvider;
        this.subscriptions = bVar;
        this.view = notificationApplicationView;
        this.navigationTracker = navigationTracker;
        this.newFeatureManager = newFeatureManager;
        this.themeAnalytics = themeAnalytics;
        this.readyToInstallNotificationManager = readyToInstallNotificationManager;
    }

    private Single<Notification> buildLocalNotification(final Context context, final String str, final String str2, final String str3, final PendingIntent pendingIntent, final PendingIntent pendingIntent2) {
        return Single.l(new Callable() { // from class: cm.aptoide.pt.notification.m1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = context;
                String str4 = str;
                String str5 = str2;
                return new androidx.core.app.i.e(context2, SystemNotificationShower.LOCAL_NOTIFICATION_CHANNEL_ID).y(R.drawable.ic_stat_aptoide_notification).i(androidx.core.content.a.d(context2, R.color.default_orange_gradient_end)).l(str4).k(str5).a(0, context2.getResources().getString(R.string.promo_update2appc_notification_dismiss_button), pendingIntent2).a(0, context2.getResources().getString(R.string.promo_update2appc_notification_claim_button), pendingIntent).p(com.bumptech.glide.c.t(context2).b().K0(str3).O0().get()).c();
            }
        }).v(Schedulers.computation()).p(rx.l.c.a.b());
    }

    private Single<Notification> buildNewFeatureNotification(final Context context, final String str, final String str2, final int i2, final PendingIntent pendingIntent, final PendingIntent pendingIntent2) {
        return Single.l(new Callable() { // from class: cm.aptoide.pt.notification.l1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = context;
                PendingIntent pendingIntent3 = pendingIntent;
                String str3 = str;
                return new androidx.core.app.i.e(context2, SystemNotificationShower.NEW_FEATURE_NOTIFICATION_CHANNEL_ID).j(pendingIntent3).y(R.drawable.ic_stat_aptoide_notification).i(androidx.core.content.a.d(context2, R.color.default_orange_gradient_end)).l(str3).k(str2).a(0, context2.getResources().getString(R.string.updates_notification_dismiss_button), pendingIntent2).a(0, context2.getResources().getString(i2), pendingIntent3).c();
            }
        }).v(Schedulers.computation()).p(rx.l.c.a.b());
    }

    private Single<Notification> buildNotification(final Context context, final String str, final String str2, final String str3, final PendingIntent pendingIntent, final PendingIntent pendingIntent2) {
        return Single.l(new Callable() { // from class: cm.aptoide.pt.notification.j2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = context;
                PendingIntent pendingIntent3 = pendingIntent;
                String str4 = str3;
                String str5 = str;
                String str6 = str2;
                return new androidx.core.app.i.e(context2, SystemNotificationShower.ANDROID_NOTIFICATION_CHANNEL_ID).j(pendingIntent3).t(false).u(true).y(R.drawable.ic_stat_aptoide_notification).p(ImageLoader.with(context2).loadBitmap(str4)).l(str5).k(str6).n(pendingIntent2).A(new androidx.core.app.i.c().h(str6)).c();
            }
        }).v(Schedulers.computation()).p(rx.l.c.a.b());
    }

    private void callDeepLink(Context context, NotificationInfo notificationInfo) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(notificationInfo.getNotificationUrl()));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            this.crashReport.log(e2);
        }
    }

    private rx.b dismissNotificationAfterAction(final int i2) {
        return rx.b.i(new rx.m.d() { // from class: cm.aptoide.pt.notification.g1
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f6710f.a(i2);
            }
        });
    }

    private NotificationChannel getAndroidNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(ANDROID_NOTIFICATION_CHANNEL_ID, "Aptoide Android System notifications", 3);
        notificationChannel.setDescription("Aptoide android notifications");
        return notificationChannel;
    }

    private NotificationChannel getLocalNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(LOCAL_NOTIFICATION_CHANNEL_ID, "Local Aptoide System notifications", 3);
        notificationChannel.setDescription("Aptoide notifications");
        return notificationChannel;
    }

    private NotificationChannel getNewFeatureNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(NEW_FEATURE_NOTIFICATION_CHANNEL_ID, "Aptoide New Feature System notifications", 3);
        notificationChannel.setDescription("Aptoide new feature notifications");
        return notificationChannel;
    }

    private Single<PendingIntent> getPressIntentAction(final String str, final String str2, final int i2, final Context context) {
        return Single.l(new Callable() { // from class: cm.aptoide.pt.notification.i2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SystemNotificationShower.lambda$getPressIntentAction$8(context, i2, str, str2);
            }
        }).v(Schedulers.computation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$dismissNotificationAfterAction$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(int i2) {
        try {
            return this.notificationCenter.notificationDismissed(this.notificationIdsMapper.getNotificationType(i2));
        } catch (RuntimeException e2) {
            return rx.b.s(e2);
        }
    }

    static /* synthetic */ PendingIntent lambda$getPressIntentAction$8(Context context, int i2, String str, String str2) throws Exception {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction(NOTIFICATION_PRESSED_ACTION);
        intent.setFlags(0);
        intent.putExtra(NOTIFICATION_NOTIFICATION_ID, i2);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(NOTIFICATION_TRACK_URL, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra(NOTIFICATION_TARGET_URL, str2);
        }
        return PendingIntent.getActivity(context, i2, intent, 167772160);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$mapLocalToAndroidNotification$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(Notification notification) {
        this.readyToInstallNotificationManager.setIsNotificationDisplayed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$mapLocalToAndroidNotification$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(AptoideNotification aptoideNotification, int i2, PendingIntent pendingIntent) {
        if (aptoideNotification.getType() != 8) {
            return aptoideNotification.getType() == 9 ? this.readyToInstallNotificationManager.buildNotification(aptoideNotification, this.context).g(new rx.m.b() { // from class: cm.aptoide.pt.notification.q1
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f6776f.b((Notification) obj);
                }
            }) : buildLocalNotification(this.context, aptoideNotification.getTitle(), aptoideNotification.getBody(), aptoideNotification.getImg(), pendingIntent, getOnDismissAction(i2));
        }
        this.newFeatureManager.setFeatureAsShown();
        return buildNewFeatureNotification(this.context, aptoideNotification.getTitle(), aptoideNotification.getBody(), aptoideNotification.getActionStringRes(), pendingIntent, getOnDismissAction(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$mapToAndroidNotification$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single d(AptoideNotification aptoideNotification, int i2, PendingIntent pendingIntent) {
        return buildNotification(this.context, aptoideNotification.getTitle(), aptoideNotification.getBody(), aptoideNotification.getImg(), pendingIntent, getOnDismissAction(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationBootCompletedSubscribe$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(NotificationInfo notificationInfo) {
        this.notificationCenter.setup();
    }

    static /* synthetic */ void lambda$setNotificationBootCompletedSubscribe$14(NotificationInfo notificationInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationBootCompletedSubscribe$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationDismissSubscribe$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(NotificationInfo notificationInfo) {
        if (this.notificationIdsMapper.getNotificationType(notificationInfo.getNotificationType())[0].equals(8)) {
            this.themeAnalytics.sendDarkThemeDismissClickEvent("Notification");
        }
        if (this.notificationIdsMapper.getNotificationType(notificationInfo.getNotificationType())[0].equals(9)) {
            this.readyToInstallNotificationManager.setIsNotificationDisplayed(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationDismissSubscribe$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b h(NotificationInfo notificationInfo) {
        return dismissNotificationAfterAction(notificationInfo.getNotificationType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationDismissSubscribe$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean i(NotificationInfo notificationInfo) {
        return Boolean.valueOf(this.notificationIdsMapper.getNotificationType(notificationInfo.getNotificationType())[0].equals(7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationDismissSubscribe$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b j(NotificationInfo notificationInfo) {
        return this.notificationProvider.deleteAllForType(7);
    }

    static /* synthetic */ void lambda$setNotificationDismissSubscribe$21() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationDismissSubscribe$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(NotificationInfo notificationInfo, RoomNotification roomNotification) {
        if (roomNotification.getType() != 7 && roomNotification.getType() != 8 && roomNotification.getType() != 9) {
            this.notificationAnalytics.sendPushNotificationPressedEvent(roomNotification.getType(), roomNotification.getAbTestingGroup(), roomNotification.getCampaignId(), roomNotification.getUrl());
            this.notificationAnalytics.sendNotificationTouchEvent(notificationInfo.getNotificationTrackUrl(), notificationInfo.getNotificationType(), notificationInfo.getNotificationUrl(), roomNotification.getCampaignId(), roomNotification.getAbTestingGroup());
        }
        if (roomNotification.getType() == 8) {
            this.themeAnalytics.sendDarkThemeDialogTurnItOnClickEvent("Notification");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(RoomNotification roomNotification) {
        this.navigationTracker.registerScreen(ScreenTagHistory.Builder.build("Notification"));
    }

    static /* synthetic */ NotificationInfo lambda$setNotificationPressSubscribe$25(NotificationInfo notificationInfo, RoomNotification roomNotification) {
        return notificationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single n(final NotificationInfo notificationInfo) {
        return this.notificationProvider.getLastShowed(this.notificationIdsMapper.getNotificationType(notificationInfo.getNotificationType())).g(new rx.m.b() { // from class: cm.aptoide.pt.notification.w1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6813f.l(notificationInfo, (RoomNotification) obj);
            }
        }).g(new rx.m.b() { // from class: cm.aptoide.pt.notification.b2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6685f.m((RoomNotification) obj);
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.notification.y1
            @Override // rx.m.e
            public final Object call(Object obj) {
                NotificationInfo notificationInfo2 = notificationInfo;
                SystemNotificationShower.lambda$setNotificationPressSubscribe$25(notificationInfo2, (RoomNotification) obj);
                return notificationInfo2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b o(NotificationInfo notificationInfo) {
        callDeepLink(this.context, notificationInfo);
        return dismissNotificationAfterAction(notificationInfo.getNotificationType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean p(NotificationInfo notificationInfo) {
        return Boolean.valueOf(this.notificationIdsMapper.getNotificationType(notificationInfo.getNotificationType())[0].equals(7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b q(NotificationInfo notificationInfo) {
        return this.notificationProvider.deleteAllForType(7);
    }

    static /* synthetic */ void lambda$setNotificationPressSubscribe$30() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setNotificationPressSubscribe$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showNewNotification$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(int i2, Notification notification) {
        this.notificationManager.notify(i2, notification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showNewNotification$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t(int i2, Notification notification) {
        this.notificationManager.notify(i2, notification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showNewNotification$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b u(AptoideNotification aptoideNotification) {
        setupChannels();
        final int notificationId = this.notificationIdsMapper.getNotificationId(aptoideNotification.getType());
        if (aptoideNotification.getType() == 7 || aptoideNotification.getType() == 8 || aptoideNotification.getType() == 9) {
            return mapLocalToAndroidNotification(aptoideNotification, notificationId).g(new rx.m.b() { // from class: cm.aptoide.pt.notification.d2
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f6696f.t(notificationId, (Notification) obj);
                }
            }).z();
        }
        this.notificationAnalytics.sendPushNotficationImpressionEvent(aptoideNotification.getType(), aptoideNotification.getAbTestingGroup(), aptoideNotification.getCampaignId(), aptoideNotification.getUrl());
        return mapToAndroidNotification(aptoideNotification, notificationId).g(new rx.m.b() { // from class: cm.aptoide.pt.notification.f2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6706f.s(notificationId, (Notification) obj);
            }
        }).z();
    }

    static /* synthetic */ void lambda$showNewNotification$3(AptoideNotification aptoideNotification) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showNewNotification$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Throwable th) {
        this.crashReport.log(th);
    }

    private Single<Notification> mapLocalToAndroidNotification(final AptoideNotification aptoideNotification, final int i2) {
        return getPressIntentAction(aptoideNotification.getUrlTrack(), aptoideNotification.getUrl(), i2, this.context).i(new rx.m.e() { // from class: cm.aptoide.pt.notification.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6674f.c(aptoideNotification, i2, (PendingIntent) obj);
            }
        });
    }

    private Single<Notification> mapToAndroidNotification(final AptoideNotification aptoideNotification, final int i2) {
        return getPressIntentAction(aptoideNotification.getUrlTrack(), aptoideNotification.getUrl(), i2, this.context).i(new rx.m.e() { // from class: cm.aptoide.pt.notification.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6690f.d(aptoideNotification, i2, (PendingIntent) obj);
            }
        });
    }

    private void setNotificationBootCompletedSubscribe() {
        this.view.getActionBootCompleted().x(new rx.m.b() { // from class: cm.aptoide.pt.notification.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6701f.e((NotificationInfo) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.i1
            @Override // rx.m.b
            public final void call(Object obj) {
                SystemNotificationShower.lambda$setNotificationBootCompletedSubscribe$14((NotificationInfo) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.r1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6780f.f((Throwable) obj);
            }
        });
    }

    private void setNotificationDismissSubscribe() {
        this.view.getNotificationDismissed().D(new rx.m.e() { // from class: cm.aptoide.pt.notification.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((NotificationInfo) obj).getNotificationType() < 9);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.notification.h2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6716f.g((NotificationInfo) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.g2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6712f.h((NotificationInfo) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.notification.u1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6790f.i((NotificationInfo) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.z1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6827f.j((NotificationInfo) obj);
            }
        }).X0().I(new rx.m.a() { // from class: cm.aptoide.pt.notification.n1
            @Override // rx.m.a
            public final void call() {
                SystemNotificationShower.lambda$setNotificationDismissSubscribe$21();
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.j1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6726f.k((Throwable) obj);
            }
        });
    }

    private void setNotificationPressSubscribe() {
        this.view.getNotificationClick().L(new rx.m.e() { // from class: cm.aptoide.pt.notification.f1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6705f.n((NotificationInfo) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.o1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6763f.o((NotificationInfo) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.notification.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6735f.p((NotificationInfo) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6783f.q((NotificationInfo) obj);
            }
        }).X0().I(new rx.m.a() { // from class: cm.aptoide.pt.notification.x1
            @Override // rx.m.a
            public final void call() {
                SystemNotificationShower.lambda$setNotificationPressSubscribe$30();
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.h1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6715f.r((Throwable) obj);
            }
        });
    }

    private void setupChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.notificationManager.createNotificationChannels(Arrays.asList(getLocalNotificationChannel(), getAndroidNotificationChannel(), getNewFeatureNotificationChannel(), this.readyToInstallNotificationManager.getNotificationChannel()));
        }
    }

    private void showNewNotification() {
        this.subscriptions.a(this.notificationCenter.getNewNotifications().H(new rx.m.e() { // from class: cm.aptoide.pt.notification.p1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6767f.u((AptoideNotification) obj);
            }
        }).s0().H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.e1
            @Override // rx.m.b
            public final void call(Object obj) {
                SystemNotificationShower.lambda$showNewNotification$3((AptoideNotification) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.v1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6794f.v((Throwable) obj);
            }
        }));
    }

    public void dismissNotification(int i2) {
        this.notificationManager.cancel(i2);
    }

    public PendingIntent getOnDismissAction(int i2) {
        Intent intent = new Intent(this.context, (Class<?>) MainActivity.class);
        intent.setAction(NOTIFICATION_DISMISSED_ACTION);
        intent.putExtra(NOTIFICATION_NOTIFICATION_ID, i2);
        return PendingIntent.getActivity(this.context, i2, intent, 167772160);
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        setNotificationPressSubscribe();
        setNotificationDismissSubscribe();
        setNotificationBootCompletedSubscribe();
        showNewNotification();
    }

    public void showNotification(Context context, RootInstallErrorNotification rootInstallErrorNotification) {
        this.notificationManager.notify(rootInstallErrorNotification.getNotificationId(), mapToAndroidNotification(context, rootInstallErrorNotification));
    }

    private Notification mapToAndroidNotification(Context context, RootInstallErrorNotification rootInstallErrorNotification) {
        Notification notificationC = new androidx.core.app.i.e(context).l(rootInstallErrorNotification.getMessage()).y(R.drawable.ic_stat_aptoide_notification).p(rootInstallErrorNotification.getIcon()).g(true).b(rootInstallErrorNotification.getAction()).n(rootInstallErrorNotification.getDeleteAction()).c();
        notificationC.flags = 20;
        return notificationC;
    }
}
