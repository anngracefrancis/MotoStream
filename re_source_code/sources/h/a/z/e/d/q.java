package h.a.z.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T> extends h.a.z.e.d.a<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.r f21590g;

    /* JADX INFO: compiled from: ObservableSubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.x.c> implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference<h.a.x.c> f21592g = new AtomicReference<>();

        a(h.a.q<? super T> qVar) {
            this.f21591f = qVar;
        }

        @Override // h.a.q
        public void a() {
            this.f21591f.a();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            h.a.z.a.c.A(this.f21592g, cVar);
        }

        void c(h.a.x.c cVar) {
            h.a.z.a.c.A(this, cVar);
        }

        @Override // h.a.x.c
        public void k() {
            h.a.z.a.c.g(this.f21592g);
            h.a.z.a.c.g(this);
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            this.f21591f.onError(th);
        }

        @Override // h.a.q
        public void onNext(T t) {
            this.f21591f.onNext(t);
        }

        @Override // h.a.x.c
        public boolean q() {
            return h.a.z.a.c.u(get());
        }
    }

    /* JADX INFO: compiled from: ObservableSubscribeOn.java */
    final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final a<T> f21593f;

        b(a<T> aVar) {
            this.f21593f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.f21503f.a(this.f21593f);
        }
    }

    public q(h.a.p<T> pVar, h.a.r rVar) {
        super(pVar);
        this.f21590g = rVar;
    }

    @Override // h.a.m
    public void x(h.a.q<? super T> qVar) {
        a aVar = new a(qVar);
        qVar.b(aVar);
        aVar.c(this.f21590g.b(new b(aVar)));
    }
}
