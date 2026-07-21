package h.a.z.e.a;

import h.a.f;
import h.a.r;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends h.a.b {
    final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final r f21468b;

    /* JADX INFO: compiled from: CompletableSubscribeOn.java */
    static final class a extends AtomicReference<h.a.x.c> implements h.a.d, h.a.x.c, Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.d f21469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.z.a.f f21470g = new h.a.z.a.f();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final f f21471h;

        a(h.a.d dVar, f fVar) {
            this.f21469f = dVar;
            this.f21471h = fVar;
        }

        @Override // h.a.d
        public void a() {
            this.f21469f.a();
        }

        @Override // h.a.d
        public void b(h.a.x.c cVar) {
            h.a.z.a.c.A(this, cVar);
        }

        @Override // h.a.x.c
        public void k() {
            h.a.z.a.c.g(this);
            this.f21470g.k();
        }

        @Override // h.a.d
        public void onError(Throwable th) {
            this.f21469f.onError(th);
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21471h.b(this);
        }
    }

    public d(f fVar, r rVar) {
        this.a = fVar;
        this.f21468b = rVar;
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        a aVar = new a(dVar, this.a);
        dVar.b(aVar);
        aVar.f21470g.a(this.f21468b.b(aVar));
    }
}
