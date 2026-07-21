package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cm.aptoide.pt.FirebaseConstants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public class FirebaseMessagingService extends g {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        String strValueOf = String.valueOf(str);
        Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Received duplicate message: ".concat(strValueOf) : new String("Received duplicate message: "));
        return true;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (h0.t(extras)) {
            h0 h0Var = new h0(extras);
            ExecutorService executorServiceD = p.d();
            try {
                if (new c(this, h0Var, executorServiceD).a()) {
                    executorServiceD.shutdown();
                    return;
                } else {
                    executorServiceD.shutdown();
                    if (f0.B(intent)) {
                        f0.u(intent);
                    }
                }
            } catch (Throwable th) {
                executorServiceD.shutdown();
                throw th;
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID);
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (alreadyReceivedMessage(intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID))) {
            return;
        }
        passMessageIntentToSdk(intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    private void passMessageIntentToSdk(Intent intent) {
        byte b2;
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        switch (stringExtra) {
            case "deleted_messages":
                b2 = 1;
                break;
            case "gcm":
                b2 = 0;
                break;
            case "send_error":
                b2 = 3;
                break;
            case "send_event":
                b2 = 2;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0) {
            f0.w(intent);
            dispatchMessage(intent);
        } else {
            if (b2 == 1) {
                onDeletedMessages();
                return;
            }
            if (b2 == 2) {
                onMessageSent(intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID));
            } else if (b2 != 3) {
                Log.w("FirebaseMessaging", stringExtra.length() != 0 ? "Received message with unknown type: ".concat(stringExtra) : new String("Received message with unknown type: "));
            } else {
                onSendError(getMessageId(intent), new SendException(intent.getStringExtra("error")));
            }
        }
    }

    @Override // com.google.firebase.messaging.g
    protected Intent getStartCommandIntent(Intent intent) {
        return l0.b().c();
    }

    @Override // com.google.firebase.messaging.g
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra("token"));
        } else {
            String strValueOf = String.valueOf(intent.getAction());
            Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Unknown intent action: ".concat(strValueOf) : new String("Unknown intent action: "));
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }
}
