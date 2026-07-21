package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class p implements t {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18339b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnSuccessListener f18340c;

    public p(Executor executor, OnSuccessListener onSuccessListener) {
        this.a = executor;
        this.f18340c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        if (task.n()) {
            synchronized (this.f18339b) {
                if (this.f18340c == null) {
                    return;
                }
                this.a.execute(new o(this, task));
            }
        }
    }
}
