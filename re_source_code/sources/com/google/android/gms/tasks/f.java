package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class f implements t {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Continuation f18320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f18321c;

    public f(Executor executor, Continuation continuation, x xVar) {
        this.a = executor;
        this.f18320b = continuation;
        this.f18321c = xVar;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        this.a.execute(new e(this, task));
    }
}
