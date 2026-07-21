package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: GetAuthTokenListener.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements n {
    private final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskCompletionSource<l> f19693b;

    public j(o oVar, TaskCompletionSource<l> taskCompletionSource) {
        this.a = oVar;
        this.f19693b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.n
    public boolean a(Exception exc) {
        this.f19693b.d(exc);
        return true;
    }

    @Override // com.google.firebase.installations.n
    public boolean b(com.google.firebase.installations.q.d dVar) {
        if (!dVar.k() || this.a.f(dVar)) {
            return false;
        }
        this.f19693b.c(l.a().b(dVar.b()).d(dVar.c()).c(dVar.h()).a());
        return true;
    }
}
