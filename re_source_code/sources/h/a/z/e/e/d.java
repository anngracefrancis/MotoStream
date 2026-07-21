package h.a.z.e.e;

import h.a.s;
import h.a.u;
import h.a.w;

/* JADX INFO: compiled from: SingleMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d<T, R> extends s<R> {
    final w<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends R> f21614b;

    /* JADX INFO: compiled from: SingleMap.java */
    static final class a<T, R> implements u<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final u<? super R> f21615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends R> f21616g;

        a(u<? super R> uVar, h.a.y.f<? super T, ? extends R> fVar) {
            this.f21615f = uVar;
            this.f21616g = fVar;
        }

        @Override // h.a.u
        public void b(h.a.x.c cVar) {
            this.f21615f.b(cVar);
        }

        @Override // h.a.u
        public void onError(Throwable th) {
            this.f21615f.onError(th);
        }

        @Override // h.a.u
        public void onSuccess(T t) {
            try {
                this.f21615f.onSuccess(h.a.z.b.b.c(this.f21616g.a(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                onError(th);
            }
        }
    }

    public d(w<? extends T> wVar, h.a.y.f<? super T, ? extends R> fVar) {
        this.a = wVar;
        this.f21614b = fVar;
    }

    @Override // h.a.s
    protected void h(u<? super R> uVar) {
        this.a.b(new a(uVar, this.f21614b));
    }
}
