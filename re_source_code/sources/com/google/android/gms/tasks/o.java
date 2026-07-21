package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class o implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ p f18338g;

    o(p pVar, Task task) {
        this.f18338g = pVar;
        this.f18337f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18338g.f18339b) {
            p pVar = this.f18338g;
            if (pVar.f18340c != null) {
                pVar.f18340c.onSuccess(this.f18337f.j());
            }
        }
    }
}
