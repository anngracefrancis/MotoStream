package h.a.z.e.d;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableToList.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T, U extends Collection<? super T>> extends h.a.z.e.d.a<T, U> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Callable<U> f21595g;

    /* JADX INFO: compiled from: ObservableToList.java */
    static final class a<T, U extends Collection<? super T>> implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super U> f21596f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        h.a.x.c f21597g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        U f21598h;

        a(h.a.q<? super U> qVar, U u) {
            this.f21596f = qVar;
            this.f21598h = u;
        }

        @Override // h.a.q
        public void a() {
            U u = this.f21598h;
            this.f21598h = null;
            this.f21596f.onNext(u);
            this.f21596f.a();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21597g, cVar)) {
                this.f21597g = cVar;
                this.f21596f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            this.f21597g.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            this.f21598h = null;
            this.f21596f.onError(th);
        }

        @Override // h.a.q
        public void onNext(T t) {
            this.f21598h.add(t);
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21597g.q();
        }
    }

    public r(h.a.p<T> pVar, Callable<U> callable) {
        super(pVar);
        this.f21595g = callable;
    }

    @Override // h.a.m
    public void x(h.a.q<? super U> qVar) {
        try {
            this.f21503f.a(new a(qVar, (Collection) h.a.z.b.b.c(this.f21595g.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            h.a.z.a.d.x(th, qVar);
        }
    }
}
