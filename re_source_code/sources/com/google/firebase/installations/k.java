package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: GetIdListener.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements n {
    final TaskCompletionSource<String> a;

    public k(TaskCompletionSource<String> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.n
    public boolean a(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.n
    public boolean b(com.google.firebase.installations.q.d dVar) {
        if (!dVar.l() && !dVar.k() && !dVar.i()) {
            return false;
        }
        this.a.e(dVar.d());
        return true;
    }
}
