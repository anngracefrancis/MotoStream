package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class j implements t {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18327b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnCanceledListener f18328c;

    public j(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = executor;
        this.f18328c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        if (task.l()) {
            synchronized (this.f18327b) {
                if (this.f18328c == null) {
                    return;
                }
                this.a.execute(new i(this));
            }
        }
    }
}
