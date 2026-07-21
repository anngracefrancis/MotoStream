package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class e implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ f f18319g;

    e(f fVar, Task task) {
        this.f18319g = fVar;
        this.f18318f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f18318f.l()) {
            this.f18319g.f18321c.s();
            return;
        }
        try {
            this.f18319g.f18321c.r(this.f18319g.f18320b.a(this.f18318f));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f18319g.f18321c.q((Exception) e2.getCause());
            } else {
                this.f18319g.f18321c.q(e2);
            }
        } catch (Exception e3) {
            this.f18319g.f18321c.q(e3);
        }
    }
}
