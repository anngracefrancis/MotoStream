package h.a.z.e.a;

import h.a.e;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h.a.b {
    final e a;

    /* JADX INFO: renamed from: h.a.z.e.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CompletableCreate.java */
    static final class C0292a extends AtomicReference<h.a.x.c> implements h.a.c, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.d f21466f;

        C0292a(h.a.d dVar) {
            this.f21466f = dVar;
        }

        @Override // h.a.c
        public void a() {
            h.a.x.c andSet;
            h.a.x.c cVar = get();
            h.a.z.a.c cVar2 = h.a.z.a.c.DISPOSED;
            if (cVar == cVar2 || (andSet = getAndSet(cVar2)) == cVar2) {
                return;
            }
            try {
                this.f21466f.a();
            } finally {
                if (andSet != null) {
                    andSet.k();
                }
            }
        }

        @Override // h.a.c
        public void b(h.a.y.d dVar) {
            d(new h.a.z.a.a(dVar));
        }

        @Override // h.a.c
        public boolean c(Throwable th) {
            h.a.x.c andSet;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            h.a.x.c cVar = get();
            h.a.z.a.c cVar2 = h.a.z.a.c.DISPOSED;
            if (cVar == cVar2 || (andSet = getAndSet(cVar2)) == cVar2) {
                return false;
            }
            try {
                this.f21466f.onError(th);
            } finally {
                if (andSet != null) {
                    andSet.k();
                }
            }
        }

        public void d(h.a.x.c cVar) {
            h.a.z.a.c.y(this, cVar);
        }

        @Override // h.a.x.c
        public void k() {
            h.a.z.a.c.g(this);
        }

        @Override // h.a.c
        public void onError(Throwable th) {
            if (c(th)) {
                return;
            }
            h.a.a0.a.o(th);
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", C0292a.class.getSimpleName(), super.toString());
        }
    }

    public a(e eVar) {
        this.a = eVar;
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        C0292a c0292a = new C0292a(dVar);
        dVar.b(c0292a);
        try {
            this.a.a(c0292a);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            c0292a.onError(th);
        }
    }
}
