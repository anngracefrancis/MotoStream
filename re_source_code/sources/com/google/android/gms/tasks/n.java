package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class n implements t {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18335b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnFailureListener f18336c;

    public n(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.f18336c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        if (task.n() || task.l()) {
            return;
        }
        synchronized (this.f18335b) {
            if (this.f18336c == null) {
                return;
            }
            this.a.execute(new m(this, task));
        }
    }
}
