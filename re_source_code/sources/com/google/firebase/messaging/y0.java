package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class y0 extends Binder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f19884f;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    interface a {
        Task<Void> a(Intent intent);
    }

    y0(a aVar) {
        this.f19884f = aVar;
    }

    void b(final b1.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "service received new intent via bind strategy");
        }
        this.f19884f.a(aVar.a).c(w0.f19882f, new OnCompleteListener(aVar) { // from class: com.google.firebase.messaging.x0
            private final b1.a a;

            {
                this.a = aVar;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void a(Task task) {
                this.a.b();
            }
        });
    }
}
