package h.a.z.e.e;

import h.a.s;
import h.a.t;
import h.a.u;
import h.a.v;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends s<T> {
    final v<T> a;

    /* JADX INFO: renamed from: h.a.z.e.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SingleCreate.java */
    static final class C0297a<T> extends AtomicReference<h.a.x.c> implements t<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final u<? super T> f21608f;

        C0297a(u<? super T> uVar) {
            this.f21608f = uVar;
        }

        public void a(Throwable th) {
            if (c(th)) {
                return;
            }
            h.a.a0.a.o(th);
        }

        @Override // h.a.t
        public void b(h.a.y.d dVar) {
            d(new h.a.z.a.a(dVar));
        }

        @Override // h.a.t
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
                this.f21608f.onError(th);
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

        @Override // h.a.t
        public void onSuccess(T t) {
            h.a.x.c andSet;
            h.a.x.c cVar = get();
            h.a.z.a.c cVar2 = h.a.z.a.c.DISPOSED;
            if (cVar == cVar2 || (andSet = getAndSet(cVar2)) == cVar2) {
                return;
            }
            try {
                if (t == null) {
                    this.f21608f.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.f21608f.onSuccess(t);
                }
                if (andSet != null) {
                    andSet.k();
                }
            } catch (Throwable th) {
                if (andSet != null) {
                    andSet.k();
                }
                throw th;
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", C0297a.class.getSimpleName(), super.toString());
        }
    }

    public a(v<T> vVar) {
        this.a = vVar;
    }

    @Override // h.a.s
    protected void h(u<? super T> uVar) {
        C0297a c0297a = new C0297a(uVar);
        uVar.b(c0297a);
        try {
            this.a.a(c0297a);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            c0297a.a(th);
        }
    }
}
