package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class l implements t {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f18331b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OnCompleteListener f18332c;

    public l(Executor executor, OnCompleteListener onCompleteListener) {
        this.a = executor;
        this.f18332c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.t
    public final void a(Task task) {
        synchronized (this.f18331b) {
            if (this.f18332c == null) {
                return;
            }
            this.a.execute(new k(this, task));
        }
    }
}
