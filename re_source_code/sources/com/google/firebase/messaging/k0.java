package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class k0 {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Task<String>> f19826b = new c.e.a();

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    interface a {
        Task<String> start();
    }

    k0(Executor executor) {
        this.a = executor;
    }

    synchronized Task<String> a(final String str, a aVar) {
        Task<String> task = this.f19826b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String strValueOf = String.valueOf(str);
                Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Joining ongoing request for: ".concat(strValueOf) : new String("Joining ongoing request for: "));
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String strValueOf2 = String.valueOf(str);
            Log.d("FirebaseMessaging", strValueOf2.length() != 0 ? "Making new request for: ".concat(strValueOf2) : new String("Making new request for: "));
        }
        Task taskH = aVar.start().h(this.a, new Continuation(this, str) { // from class: com.google.firebase.messaging.j0
            private final k0 a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f19824b;

            {
                this.a = this;
                this.f19824b = str;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task2) throws Exception {
                this.a.b(this.f19824b, task2);
                return task2;
            }
        });
        this.f19826b.put(str, (Task<String>) taskH);
        return taskH;
    }

    final /* synthetic */ Task b(String str, Task task) throws Exception {
        synchronized (this) {
            this.f19826b.remove(str);
        }
        return task;
    }
}
