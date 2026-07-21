package cm.aptoide.pt;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import javax.inject.Inject;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AptoideFirebaseNotificationService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcm/aptoide/pt/AptoideFirebaseNotificationService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "firebaseNotificationAnalytics", "Lcm/aptoide/pt/FirebaseNotificationAnalytics;", "getFirebaseNotificationAnalytics", "()Lcm/aptoide/pt/FirebaseNotificationAnalytics;", "setFirebaseNotificationAnalytics", "(Lcm/aptoide/pt/FirebaseNotificationAnalytics;)V", "handleIntent", HttpUrl.FRAGMENT_ENCODE_SET, "intent", "Landroid/content/Intent;", "onCreate", "onMessageReceived", "message", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", HttpUrl.FRAGMENT_ENCODE_SET, "setupNotificationChannel", "context", "Landroid/content/Context;", "showNotification", "Companion", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AptoideFirebaseNotificationService extends FirebaseMessagingService {
    public static final String FCM_NOTIFICATION_CHANNEL_ID = "fcm_notification_channel";
    public static final String FCM_NOTIFICATION_CHANNEL_NAME = "Remote Notification Channel";

    @Inject
    public FirebaseNotificationAnalytics firebaseNotificationAnalytics;

    private final void setupNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = context.getSystemService("notification");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (notificationManager.getNotificationChannel(FCM_NOTIFICATION_CHANNEL_ID) == null) {
                NotificationChannel notificationChannel = new NotificationChannel(FCM_NOTIFICATION_CHANNEL_ID, FCM_NOTIFICATION_CHANNEL_NAME, 3);
                notificationChannel.setSound(null, null);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    private final void showNotification(Context context, RemoteMessage message) {
        RemoteMessage.b bVarZ = message.z();
        if (bVarZ != null) {
            String strY = message.y();
            int iHashCode = strY != null ? strY.hashCode() : 0;
            Notification notificationC = new androidx.core.app.i.e(getApplicationContext(), FCM_NOTIFICATION_CHANNEL_ID).j(PendingIntent.getActivity(context, iHashCode, new Intent(context, (Class<?>) MainActivity.class).putExtras(message.W()).putExtra(FirebaseConstants.FIREBASE_MESSAGE_ID, message.y()).putExtra(FirebaseConstants.FIREBASE_ANALYTICS_DATA, message.W().getExtras()), 201326592)).t(false).y(R.drawable.ic_stat_aptoide_notification).p(ImageLoader.with(getApplicationContext()).loadBitmap(String.valueOf(bVarZ.b()))).l(bVarZ.d()).k(bVarZ.a()).v(0).g(true).x(true).c();
            kotlin.jvm.internal.m.e(notificationC, "Builder(applicationConte…(true)\n          .build()");
            androidx.core.app.l.b(getApplicationContext()).d(iHashCode, notificationC);
        }
    }

    public final FirebaseNotificationAnalytics getFirebaseNotificationAnalytics() {
        FirebaseNotificationAnalytics firebaseNotificationAnalytics = this.firebaseNotificationAnalytics;
        if (firebaseNotificationAnalytics != null) {
            return firebaseNotificationAnalytics;
        }
        kotlin.jvm.internal.m.w("firebaseNotificationAnalytics");
        return null;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService, com.google.firebase.messaging.g
    public void handleIntent(Intent intent) {
        try {
            kotlin.jvm.internal.m.c(intent);
            intent.putExtra(FirebaseConstants.LAUNCH_SOURCE, "notification");
            onMessageReceived(new RemoteMessage(intent.getExtras()));
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString(FirebaseConstants.FIREBASE_MESSAGE_ID);
                String string2 = extras.getString(FirebaseConstants.FIREBASE_MESSAGE_NAME);
                if (string == null || string2 == null) {
                    return;
                }
                getFirebaseNotificationAnalytics().sendFirebaseNotificationReceived(string, string2, System.currentTimeMillis(), extras.getString(FirebaseConstants.FIREBASE_MESSAGE_LABEL), androidx.core.app.l.b(getApplicationContext()).a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type cm.aptoide.pt.AptoideApplication");
        }
        ((AptoideApplication) applicationContext).getApplicationComponent().inject(this);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        kotlin.jvm.internal.m.f(message, "message");
        super.onMessageReceived(message);
        if (message.z() != null) {
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.m.e(applicationContext, "applicationContext");
            setupNotificationChannel(applicationContext);
            Context applicationContext2 = getApplicationContext();
            kotlin.jvm.internal.m.e(applicationContext2, "applicationContext");
            showNotification(applicationContext2, message);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        kotlin.jvm.internal.m.f(token, "token");
        super.onNewToken(token);
        Log.d("firebase", "onNewToken: " + token);
    }

    public final void setFirebaseNotificationAnalytics(FirebaseNotificationAnalytics firebaseNotificationAnalytics) {
        kotlin.jvm.internal.m.f(firebaseNotificationAnalytics, "<set-?>");
        this.firebaseNotificationAnalytics = firebaseNotificationAnalytics;
    }
}
