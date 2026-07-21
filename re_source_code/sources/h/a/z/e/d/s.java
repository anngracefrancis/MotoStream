package h.a.z.e.d;

import h.a.u;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableToListSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s<T, U extends Collection<? super T>> extends h.a.s<U> implements h.a.z.c.a<U> {
    final h.a.p<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f21599b;

    /* JADX INFO: compiled from: ObservableToListSingle.java */
    static final class a<T, U extends Collection<? super T>> implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final u<? super U> f21600f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        U f21601g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        h.a.x.c f21602h;

        a(u<? super U> uVar, U u) {
            this.f21600f = uVar;
            this.f21601g = u;
        }

        @Override // h.a.q
        public void a() {
            U u = this.f21601g;
            this.f21601g = null;
            this.f21600f.onSuccess(u);
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21602h, cVar)) {
                this.f21602h = cVar;
                this.f21600f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            this.f21602h.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            this.f21601g = null;
            this.f21600f.onError(th);
        }

        @Override // h.a.q
        public void onNext(T t) {
            this.f21601g.add(t);
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21602h.q();
        }
    }

    public s(h.a.p<T> pVar, int i2) {
        this.a = pVar;
        this.f21599b = h.a.z.b.a.a(i2);
    }

    @Override // h.a.z.c.a
    public h.a.m<U> a() {
        return h.a.a0.a.m(new r(this.a, this.f21599b));
    }

    @Override // h.a.s
    public void h(u<? super U> uVar) {
        try {
            this.a.a(new a(uVar, (Collection) h.a.z.b.b.c(this.f21599b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            h.a.z.a.d.y(th, uVar);
        }
    }
}
