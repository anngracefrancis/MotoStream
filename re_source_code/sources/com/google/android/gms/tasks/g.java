package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ h f18323g;

    g(h hVar, Task task) {
        this.f18323g = hVar;
        this.f18322f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Task task = (Task) this.f18323g.f18324b.a(this.f18322f);
            if (task == null) {
                this.f18323g.c(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f18310b;
            task.e(executor, this.f18323g);
            task.d(executor, this.f18323g);
            task.a(executor, this.f18323g);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f18323g.f18325c.q((Exception) e2.getCause());
            } else {
                this.f18323g.f18325c.q(e2);
            }
        } catch (Exception e3) {
            this.f18323g.f18325c.q(e3);
        }
    }
}
