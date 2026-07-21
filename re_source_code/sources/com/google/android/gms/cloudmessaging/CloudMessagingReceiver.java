package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import cm.aptoide.pt.FirebaseConstants;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private final ExecutorService a = com.google.android.gms.internal.cloudmessaging.zza.a().b(new NamedThreadFactory("firebase-iid-executor"), zzf.a);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class IntentActionKeys {
        private IntentActionKeys() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class IntentKeys {
        private IntentKeys() {
        }
    }

    private final int e(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            d(context, extras);
            return -1;
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    private final int g(Context context, Intent intent) {
        Task<Void> taskD;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            taskD = Tasks.e(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseConstants.FIREBASE_MESSAGE_ID, stringExtra);
            taskD = zze.c(context).d(2, bundle);
        }
        int iB = b(context, new CloudMessage(intent));
        try {
            Tasks.b(taskD, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(strValueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return iB;
    }

    protected Executor a() {
        return this.a;
    }

    protected abstract int b(Context context, CloudMessage cloudMessage);

    protected void c(Context context, Bundle bundle) {
    }

    protected void d(Context context, Bundle bundle) {
    }

    final /* synthetic */ void f(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            int iE = intent2 != null ? e(context, intent2) : g(context, intent);
            if (z) {
                pendingResult.setResultCode(iE);
            }
        } finally {
            pendingResult.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        a().execute(new Runnable(this, intent, context, zIsOrderedBroadcast, pendingResultGoAsync) { // from class: com.google.android.gms.cloudmessaging.b

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final CloudMessagingReceiver f11580f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Intent f11581g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final Context f11582h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final boolean f11583i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private final BroadcastReceiver.PendingResult f11584j;

            {
                this.f11580f = this;
                this.f11581g = intent;
                this.f11582h = context;
                this.f11583i = zIsOrderedBroadcast;
                this.f11584j = pendingResultGoAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11580f.f(this.f11581g, this.f11582h, this.f11583i, this.f11584j);
            }
        });
    }
}
