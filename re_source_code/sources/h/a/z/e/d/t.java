package h.a.z.e.d;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ObservableUnsubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t<T> extends h.a.z.e.d.a<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.r f21603g;

    /* JADX INFO: compiled from: ObservableUnsubscribeOn.java */
    static final class a<T> extends AtomicBoolean implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.r f21605g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        h.a.x.c f21606h;

        /* JADX INFO: renamed from: h.a.z.e.d.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableUnsubscribeOn.java */
        final class RunnableC0296a implements Runnable {
            RunnableC0296a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f21606h.k();
            }
        }

        a(h.a.q<? super T> qVar, h.a.r rVar) {
            this.f21604f = qVar;
            this.f21605g = rVar;
        }

        @Override // h.a.q
        public void a() {
            if (get()) {
                return;
            }
            this.f21604f.a();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21606h, cVar)) {
                this.f21606h = cVar;
                this.f21604f.b(this);
            }
        }

        @Override // h.a.x.c
        public void k() {
            if (compareAndSet(false, true)) {
                this.f21605g.b(new RunnableC0296a());
            }
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (get()) {
                h.a.a0.a.o(th);
            } else {
                this.f21604f.onError(th);
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.f21604f.onNext(t);
        }

        @Override // h.a.x.c
        public boolean q() {
            return get();
        }
    }

    public t(h.a.p<T> pVar, h.a.r rVar) {
        super(pVar);
        this.f21603g = rVar;
    }

    @Override // h.a.m
    public void x(h.a.q<? super T> qVar) {
        this.f21503f.a(new a(qVar, this.f21603g));
    }
}
