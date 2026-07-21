package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class q implements Continuation {
    static final Continuation a = new q();

    private q() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object a(Task task) {
        return ((l) task.j()).a();
    }
}
