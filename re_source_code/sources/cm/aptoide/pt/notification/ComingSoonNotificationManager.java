package cm.aptoide.pt.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import cm.aptoide.pt.home.AppComingSoonRegistrationManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ComingSoonNotificationManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcm/aptoide/pt/notification/ComingSoonNotificationManager;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Landroid/content/Context;", "appComingSoonPreferencesManager", "Lcm/aptoide/pt/home/AppComingSoonRegistrationManager;", "(Landroid/content/Context;Lcm/aptoide/pt/home/AppComingSoonRegistrationManager;)V", "comingSoonWorkRequest", "Landroidx/work/PeriodicWorkRequest;", "cancelScheduledNotification", "Lrx/Completable;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "setUpChannel", HttpUrl.FRAGMENT_ENCODE_SET, "setUpWorkRequest", "url", "setupNotification", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComingSoonNotificationManager {
    public static final String CHANNEL_ID = "coming_soon_notification_channel";
    public static final int NOTIFICATION_ID = 1994;
    public static final String PACKAGE_NAME = "package_name";
    public static final String WORKER_TAG = "ComingSoonNotificationWorker";
    private final AppComingSoonRegistrationManager appComingSoonPreferencesManager;
    private androidx.work.s comingSoonWorkRequest;
    private final Context context;

    public ComingSoonNotificationManager(Context context, AppComingSoonRegistrationManager appComingSoonRegistrationManager) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(appComingSoonRegistrationManager, "appComingSoonPreferencesManager");
        this.context = context;
        this.appComingSoonPreferencesManager = appComingSoonRegistrationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: cancelScheduledNotification$lambda-2, reason: not valid java name */
    public static final void m276cancelScheduledNotification$lambda2(ComingSoonNotificationManager comingSoonNotificationManager, String str) {
        kotlin.jvm.internal.m.f(comingSoonNotificationManager, "this$0");
        kotlin.jvm.internal.m.f(str, "$packageName");
        androidx.work.y.h(comingSoonNotificationManager.context).a(WORKER_TAG + str);
    }

    private final void setUpChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Coming Soon notifications", 3);
            notificationChannel.setDescription("Coming Soon");
            Object systemService = this.context.getSystemService("notification");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        }
    }

    private final void setUpWorkRequest(String url) {
        androidx.work.e.a aVar = new androidx.work.e.a();
        aVar.f("package_name", url);
        androidx.work.s sVarB = new androidx.work.s.a(ComingSoonNotificationWorker.class, 1L, TimeUnit.DAYS).a(WORKER_TAG + url).g(aVar.a()).b();
        kotlin.jvm.internal.m.e(sVarB, "PeriodicWorkRequestBuild…build())\n        .build()");
        this.comingSoonWorkRequest = sVarB;
        androidx.work.y yVarH = androidx.work.y.h(this.context);
        String str = WORKER_TAG + url;
        androidx.work.f fVar = androidx.work.f.KEEP;
        androidx.work.s sVar = this.comingSoonWorkRequest;
        if (sVar == null) {
            kotlin.jvm.internal.m.w("comingSoonWorkRequest");
            sVar = null;
        }
        yVarH.e(str, fVar, sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupNotification$lambda-0, reason: not valid java name */
    public static final void m277setupNotification$lambda0(ComingSoonNotificationManager comingSoonNotificationManager, String str) {
        kotlin.jvm.internal.m.f(comingSoonNotificationManager, "this$0");
        kotlin.jvm.internal.m.f(str, "$url");
        comingSoonNotificationManager.setUpChannel();
        comingSoonNotificationManager.setUpWorkRequest(str);
    }

    public final rx.b cancelScheduledNotification(final String str) {
        kotlin.jvm.internal.m.f(str, "packageName");
        rx.b bVarA = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.notification.b
            @Override // rx.m.a
            public final void call() {
                ComingSoonNotificationManager.m276cancelScheduledNotification$lambda2(this.f6677f, str);
            }
        }).a(this.appComingSoonPreferencesManager.cancelScheduledNotification(str));
        kotlin.jvm.internal.m.e(bVarA, "fromAction {\n      WorkM…otification(packageName))");
        return bVarA;
    }

    public final rx.b setupNotification(final String str) {
        kotlin.jvm.internal.m.f(str, "url");
        rx.b bVarA = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.notification.a
            @Override // rx.m.a
            public final void call() {
                ComingSoonNotificationManager.m277setupNotification$lambda0(this.f6669f, str);
            }
        }).a(this.appComingSoonPreferencesManager.registerUserNotification(str));
        kotlin.jvm.internal.m.e(bVarA, "fromAction {\n      setUp…terUserNotification(url))");
        return bVarA;
    }
}
