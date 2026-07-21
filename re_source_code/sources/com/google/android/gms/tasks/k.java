package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class k implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ l f18330g;

    k(l lVar, Task task) {
        this.f18330g = lVar;
        this.f18329f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18330g.f18331b) {
            l lVar = this.f18330g;
            if (lVar.f18332c != null) {
                lVar.f18332c.a(this.f18329f);
            }
        }
    }
}
