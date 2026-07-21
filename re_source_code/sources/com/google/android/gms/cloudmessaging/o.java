package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class o implements Continuation {
    static final Continuation a = new o();

    private o() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object a(Task task) {
        return Rpc.b(task);
    }
}
