package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class s<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, t {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SuccessContinuation f18343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f18344c;

    public s(Executor executor, SuccessContinuation successContinuation, x xVar) {
        this.a = executor;
        this.f18343b = successContinuation;
        this.f18344c = xVar;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        this.a.execute(new q(this, task));
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void b() {
        this.f18344c.s();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void c(Exception exc) {
        this.f18344c.q(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.f18344c.r(tcontinuationresult);
    }
}
