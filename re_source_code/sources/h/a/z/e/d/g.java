package h.a.z.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMapCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends h.a.z.e.d.a<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends h.a.f> f21533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f21534h;

    /* JADX INFO: compiled from: ObservableFlatMapCompletable.java */
    static final class a<T> extends h.a.z.d.a<T> implements h.a.q<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super T> f21535f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends h.a.f> f21537h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final boolean f21538i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        h.a.x.c f21540k;
        volatile boolean l;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.z.j.a f21536g = new h.a.z.j.a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final h.a.x.b f21539j = new h.a.x.b();

        /* JADX INFO: renamed from: h.a.z.e.d.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableFlatMapCompletable.java */
        final class C0293a extends AtomicReference<h.a.x.c> implements h.a.d, h.a.x.c {
            C0293a() {
            }

            @Override // h.a.d
            public void a() {
                a.this.c(this);
            }

            @Override // h.a.d
            public void b(h.a.x.c cVar) {
                h.a.z.a.c.A(this, cVar);
            }

            @Override // h.a.x.c
            public void k() {
                h.a.z.a.c.g(this);
            }

            @Override // h.a.d
            public void onError(Throwable th) {
                a.this.d(this, th);
            }

            @Override // h.a.x.c
            public boolean q() {
                return h.a.z.a.c.u(get());
            }
        }

        a(h.a.q<? super T> qVar, h.a.y.f<? super T, ? extends h.a.f> fVar, boolean z) {
            this.f21535f = qVar;
            this.f21537h = fVar;
            this.f21538i = z;
            lazySet(1);
        }

        @Override // h.a.q
        public void a() {
            if (decrementAndGet() == 0) {
                Throwable thB = this.f21536g.b();
                if (thB != null) {
                    this.f21535f.onError(thB);
                } else {
                    this.f21535f.a();
                }
            }
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21540k, cVar)) {
                this.f21540k = cVar;
                this.f21535f.b(this);
            }
        }

        void c(a<T>.C0293a c0293a) {
            this.f21539j.c(c0293a);
            a();
        }

        @Override // h.a.z.c.f
        public void clear() {
        }

        void d(a<T>.C0293a c0293a, Throwable th) {
            this.f21539j.c(c0293a);
            onError(th);
        }

        @Override // h.a.z.c.c
        public int g(int i2) {
            return i2 & 2;
        }

        @Override // h.a.z.c.f
        public boolean isEmpty() {
            return true;
        }

        @Override // h.a.x.c
        public void k() {
            this.l = true;
            this.f21540k.k();
            this.f21539j.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (!this.f21536g.a(th)) {
                h.a.a0.a.o(th);
                return;
            }
            if (this.f21538i) {
                if (decrementAndGet() == 0) {
                    this.f21535f.onError(this.f21536g.b());
                    return;
                }
                return;
            }
            k();
            if (getAndSet(0) > 0) {
                this.f21535f.onError(this.f21536g.b());
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            try {
                h.a.f fVar = (h.a.f) h.a.z.b.b.c(this.f21537h.a(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0293a c0293a = new C0293a();
                if (this.l || !this.f21539j.b(c0293a)) {
                    return;
                }
                fVar.b(c0293a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.f21540k.k();
                onError(th);
            }
        }

        @Override // h.a.z.c.f
        public T poll() throws Exception {
            return null;
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21540k.q();
        }
    }

    public g(h.a.p<T> pVar, h.a.y.f<? super T, ? extends h.a.f> fVar, boolean z) {
        super(pVar);
        this.f21533g = fVar;
        this.f21534h = z;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super T> qVar) {
        this.f21503f.a(new a(qVar, this.f21533g, this.f21534h));
    }
}
