package h.a.z.e.e;

import h.a.s;
import h.a.u;
import h.a.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleFlatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T, R> extends s<R> {
    final w<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends w<? extends R>> f21609b;

    /* JADX INFO: compiled from: SingleFlatMap.java */
    static final class a<T, R> extends AtomicReference<h.a.x.c> implements u<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final u<? super R> f21610f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends w<? extends R>> f21611g;

        /* JADX INFO: renamed from: h.a.z.e.e.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleFlatMap.java */
        static final class C0298a<R> implements u<R> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final AtomicReference<h.a.x.c> f21612f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final u<? super R> f21613g;

            C0298a(AtomicReference<h.a.x.c> atomicReference, u<? super R> uVar) {
                this.f21612f = atomicReference;
                this.f21613g = uVar;
            }

            @Override // h.a.u
            public void b(h.a.x.c cVar) {
                h.a.z.a.c.v(this.f21612f, cVar);
            }

            @Override // h.a.u
            public void onError(Throwable th) {
                this.f21613g.onError(th);
            }

            @Override // h.a.u
            public void onSuccess(R r) {
                this.f21613g.onSuccess(r);
            }
        }

        a(u<? super R> uVar, h.a.y.f<? super T, ? extends w<? extends R>> fVar) {
            this.f21610f = uVar;
            this.f21611g = fVar;
        }

        @Override // h.a.u
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.A(this, cVar)) {
                this.f21610f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            h.a.z.a.c.g(this);
        }

        @Override // h.a.u
        public void onError(Throwable th) {
            this.f21610f.onError(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            try {
                w wVar = (w) h.a.z.b.b.c(this.f21611g.a(t), "The single returned by the mapper is null");
                if (q()) {
                    return;
                }
                wVar.b(new C0298a(this, this.f21610f));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.f21610f.onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }
    }

    public b(w<? extends T> wVar, h.a.y.f<? super T, ? extends w<? extends R>> fVar) {
        this.f21609b = fVar;
        this.a = wVar;
    }

    @Override // h.a.s
    protected void h(u<? super R> uVar) {
        this.a.b(new a(uVar, this.f21609b));
    }
}
