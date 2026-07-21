package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class i implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ j f18326f;

    i(j jVar) {
        this.f18326f = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18326f.f18327b) {
            j jVar = this.f18326f;
            if (jVar.f18328c != null) {
                jVar.f18328c.b();
            }
        }
    }
}
