package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.f0;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static Intent h(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected final int b(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.a(new com.google.firebase.messaging.o(context).g(cloudMessage.y()))).intValue();
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e2);
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected final void c(Context context, Bundle bundle) {
        Intent intentH = h(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (f0.B(intentH)) {
            f0.t(intentH);
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected final void d(Context context, Bundle bundle) {
        Intent intentH = h(context, "com.google.firebase.messaging.NOTIFICATION_OPEN", bundle);
        if (f0.B(intentH)) {
            f0.v(intentH);
        }
    }
}
