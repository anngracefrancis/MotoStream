package h.a.z.e.d;

import java.util.Iterator;

/* JADX INFO: compiled from: ObservableFlattenIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T, R> extends h.a.z.e.d.a<T, R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends Iterable<? extends R>> f21560g;

    /* JADX INFO: compiled from: ObservableFlattenIterable.java */
    static final class a<T, R> implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super R> f21561f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends Iterable<? extends R>> f21562g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        h.a.x.c f21563h;

        a(h.a.q<? super R> qVar, h.a.y.f<? super T, ? extends Iterable<? extends R>> fVar) {
            this.f21561f = qVar;
            this.f21562g = fVar;
        }

        @Override // h.a.q
        public void a() {
            h.a.x.c cVar = this.f21563h;
            h.a.z.a.c cVar2 = h.a.z.a.c.DISPOSED;
            if (cVar == cVar2) {
                return;
            }
            this.f21563h = cVar2;
            this.f21561f.a();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21563h, cVar)) {
                this.f21563h = cVar;
                this.f21561f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            this.f21563h.k();
            this.f21563h = h.a.z.a.c.DISPOSED;
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            h.a.x.c cVar = this.f21563h;
            h.a.z.a.c cVar2 = h.a.z.a.c.DISPOSED;
            if (cVar == cVar2) {
                h.a.a0.a.o(th);
            } else {
                this.f21563h = cVar2;
                this.f21561f.onError(th);
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            if (this.f21563h == h.a.z.a.c.DISPOSED) {
                return;
            }
            try {
                Iterator<? extends R> it = this.f21562g.a(t).iterator();
                h.a.q<? super R> qVar = this.f21561f;
                while (it.hasNext()) {
                    try {
                        try {
                            qVar.onNext((Object) h.a.z.b.b.c(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.a(th);
                            this.f21563h.k();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.a(th2);
                        this.f21563h.k();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.a(th3);
                this.f21563h.k();
                onError(th3);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21563h.q();
        }
    }

    public j(h.a.p<T> pVar, h.a.y.f<? super T, ? extends Iterable<? extends R>> fVar) {
        super(pVar);
        this.f21560g = fVar;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super R> qVar) {
        this.f21503f.a(new a(qVar, this.f21560g));
    }
}
