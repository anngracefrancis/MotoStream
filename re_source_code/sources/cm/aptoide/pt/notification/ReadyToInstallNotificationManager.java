package cm.aptoide.pt.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.R;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.MainActivity;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: ReadyToInstallNotificationManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, d2 = {"Lcm/aptoide/pt/notification/ReadyToInstallNotificationManager;", HttpUrl.FRAGMENT_ENCODE_SET, "installManager", "Lcm/aptoide/pt/install/InstallManager;", "notificationIdsMapper", "Lcm/aptoide/pt/notification/NotificationIdsMapper;", "(Lcm/aptoide/pt/install/InstallManager;Lcm/aptoide/pt/notification/NotificationIdsMapper;)V", "getInstallManager", "()Lcm/aptoide/pt/install/InstallManager;", "isNotificationDisplayed", HttpUrl.FRAGMENT_ENCODE_SET, "getNotificationIdsMapper", "()Lcm/aptoide/pt/notification/NotificationIdsMapper;", "buildMultiReadyToInstallNotification", "Lrx/Single;", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "buildNotification", "aptoideNotification", "Lcm/aptoide/pt/notification/AptoideNotification;", "buildSingleReadyToInstallNotification", "appName", HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.ICON, "url", "getMultiAppPressIntentAction", "Landroid/app/PendingIntent;", "getNotificationChannel", "Landroid/app/NotificationChannel;", "getOnDismissAction", "getSingleAppPressIntentAction", "setIsNotificationDisplayed", HttpUrl.FRAGMENT_ENCODE_SET, "isActive", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ReadyToInstallNotificationManager {
    public static final String CHANNEL_ID = "ready_to_install_notification_channel";
    public static final String ORIGIN = "ready_to_install";
    private final InstallManager installManager;
    private boolean isNotificationDisplayed;
    private final NotificationIdsMapper notificationIdsMapper;

    public ReadyToInstallNotificationManager(InstallManager installManager, NotificationIdsMapper notificationIdsMapper) {
        kotlin.jvm.internal.m.f(installManager, "installManager");
        kotlin.jvm.internal.m.f(notificationIdsMapper, "notificationIdsMapper");
        this.installManager = installManager;
        this.notificationIdsMapper = notificationIdsMapper;
    }

    private final Single<Notification> buildMultiReadyToInstallNotification(final Context context) {
        Single<Notification> singleL = Single.l(new Callable() { // from class: cm.aptoide.pt.notification.a1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReadyToInstallNotificationManager.m282buildMultiReadyToInstallNotification$lambda2(context, this);
            }
        });
        kotlin.jvm.internal.m.e(singleL, "fromCallable {\n      val…\n      notification\n    }");
        return singleL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildMultiReadyToInstallNotification$lambda-2, reason: not valid java name */
    public static final Notification m282buildMultiReadyToInstallNotification$lambda2(Context context, ReadyToInstallNotificationManager readyToInstallNotificationManager) {
        kotlin.jvm.internal.m.f(context, "$context");
        kotlin.jvm.internal.m.f(readyToInstallNotificationManager, "this$0");
        String string = context.getString(R.string.notification_install_ready_plural_title);
        kotlin.jvm.internal.m.e(string, "context.getString(R.stri…stall_ready_plural_title)");
        String string2 = context.getString(R.string.notification_install_ready_plural_body);
        kotlin.jvm.internal.m.e(string2, "context.getString(R.stri…nstall_ready_plural_body)");
        Notification notificationC = new androidx.core.app.i.e(context).j(readyToInstallNotificationManager.getMultiAppPressIntentAction(context)).n(readyToInstallNotificationManager.getOnDismissAction(context)).y(R.drawable.ic_stat_aptoide_notification).p(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).l(string).k(string2).A(new androidx.core.app.i.c().h(string2)).g(true).h(CHANNEL_ID).u(true).t(true).c();
        kotlin.jvm.internal.m.e(notificationC, "Builder(context)\n       …(true)\n          .build()");
        return notificationC;
    }

    private final Single<Notification> buildSingleReadyToInstallNotification(final String appName, final String icon, final String url, final Context context) {
        Single<Notification> singleL = Single.l(new Callable() { // from class: cm.aptoide.pt.notification.b1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReadyToInstallNotificationManager.m283buildSingleReadyToInstallNotification$lambda1(context, appName, this, url, icon);
            }
        });
        kotlin.jvm.internal.m.e(singleL, "fromCallable {\n      val…\n      notification\n    }");
        return singleL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildSingleReadyToInstallNotification$lambda-1, reason: not valid java name */
    public static final Notification m283buildSingleReadyToInstallNotification$lambda1(Context context, String str, ReadyToInstallNotificationManager readyToInstallNotificationManager, String str2, String str3) {
        kotlin.jvm.internal.m.f(context, "$context");
        kotlin.jvm.internal.m.f(str, "$appName");
        kotlin.jvm.internal.m.f(readyToInstallNotificationManager, "this$0");
        kotlin.jvm.internal.m.f(str2, "$url");
        kotlin.jvm.internal.m.f(str3, "$icon");
        String string = context.getString(R.string.notification_install_ready_singular_title);
        kotlin.jvm.internal.m.e(string, "context.getString(R.stri…all_ready_singular_title)");
        String string2 = context.getString(R.string.notification_install_ready_singular_body, str);
        kotlin.jvm.internal.m.e(string2, "context.getString(R.stri…y_singular_body, appName)");
        Notification notificationC = new androidx.core.app.i.e(context).j(readyToInstallNotificationManager.getSingleAppPressIntentAction(str2, context)).n(readyToInstallNotificationManager.getOnDismissAction(context)).y(R.drawable.ic_stat_aptoide_notification).l(string).k(string2).p(ImageLoader.with(context).loadBitmap(str3)).A(new androidx.core.app.i.c().h(string2)).g(true).t(true).h(CHANNEL_ID).u(true).c();
        kotlin.jvm.internal.m.e(notificationC, "Builder(context)\n       …(true)\n          .build()");
        return notificationC;
    }

    private final PendingIntent getMultiAppPressIntentAction(Context context) {
        Intent intent = new Intent(context, AptoideApplication.getActivityProvider().getMainActivityFragmentClass());
        intent.putExtra(DeepLinkIntentReceiver.DeepLinksTargets.APPS, true);
        intent.putExtra(DeepLinkIntentReceiver.DeepLinksKeys.FROM_NOTIFICATION_READY_TO_INSTALL, true);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 67108864);
        kotlin.jvm.internal.m.e(activity, "getActivity(\n      conte…tent.FLAG_IMMUTABLE\n    )");
        return activity;
    }

    private final PendingIntent getOnDismissAction(Context context) {
        int notificationId = this.notificationIdsMapper.getNotificationId(9);
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setAction(SystemNotificationShower.NOTIFICATION_DISMISSED_ACTION);
        intent.putExtra(SystemNotificationShower.NOTIFICATION_NOTIFICATION_ID, notificationId);
        return PendingIntent.getActivity(context, notificationId, intent, 167772160);
    }

    private final PendingIntent getSingleAppPressIntentAction(String url, Context context) {
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.VIEW", Uri.parse(url), context, DeepLinkIntentReceiver.class), 67108864);
        kotlin.jvm.internal.m.e(activity, "getActivity(\n      conte…tent.FLAG_IMMUTABLE\n    )");
        return activity;
    }

    public final Single<Notification> buildNotification(AptoideNotification aptoideNotification, Context context) {
        kotlin.jvm.internal.m.f(aptoideNotification, "aptoideNotification");
        kotlin.jvm.internal.m.f(context, "context");
        if (this.isNotificationDisplayed) {
            return buildMultiReadyToInstallNotification(context);
        }
        String appName = aptoideNotification.getAppName();
        kotlin.jvm.internal.m.e(appName, "aptoideNotification.appName");
        String img = aptoideNotification.getImg();
        kotlin.jvm.internal.m.e(img, "aptoideNotification.img");
        String url = aptoideNotification.getUrl();
        kotlin.jvm.internal.m.e(url, "aptoideNotification.url");
        return buildSingleReadyToInstallNotification(appName, img, url, context);
    }

    public final InstallManager getInstallManager() {
        return this.installManager;
    }

    public final NotificationChannel getNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Install notifications", 3);
        notificationChannel.setDescription("Install");
        return notificationChannel;
    }

    public final NotificationIdsMapper getNotificationIdsMapper() {
        return this.notificationIdsMapper;
    }

    public final synchronized void setIsNotificationDisplayed(boolean isActive) {
        this.isNotificationDisplayed = isActive;
    }
}
