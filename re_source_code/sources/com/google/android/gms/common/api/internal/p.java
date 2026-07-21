package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes2.dex */
abstract class p implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zaak f11778f;

    private p(zaak zaakVar) {
        this.f11778f = zaakVar;
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        this.f11778f.f11805b.lock();
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            return;
        } catch (RuntimeException e2) {
            this.f11778f.a.k(e2);
            return;
        } finally {
            this.f11778f.f11805b.unlock();
        }
        this.f11778f.f11805b.unlock();
    }

    /* synthetic */ p(zaak zaakVar, g gVar) {
        this(zaakVar);
    }
}
