package h.a.z.e.e;

import h.a.m;
import h.a.q;
import h.a.u;
import h.a.w;

/* JADX INFO: compiled from: SingleToObservable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends m<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final w<? extends T> f21621f;

    /* JADX INFO: compiled from: SingleToObservable.java */
    static final class a<T> extends h.a.z.d.c<T> implements u<T> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        h.a.x.c f21622h;

        a(q<? super T> qVar) {
            super(qVar);
        }

        @Override // h.a.u
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21622h, cVar)) {
                this.f21622h = cVar;
                this.f21464f.b(this);
            }
        }

        @Override // h.a.z.d.c, h.a.x.c
        public void k() {
            super.k();
            this.f21622h.k();
        }

        @Override // h.a.u
        public void onError(Throwable th) {
            d(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            c(t);
        }
    }

    public f(w<? extends T> wVar) {
        this.f21621f = wVar;
    }

    public static <T> u<T> E(q<? super T> qVar) {
        return new a(qVar);
    }

    @Override // h.a.m
    public void x(q<? super T> qVar) {
        this.f21621f.b(E(qVar));
    }
}
