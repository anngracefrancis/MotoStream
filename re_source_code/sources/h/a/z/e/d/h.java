package h.a.z.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMapCompletableCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends h.a.b implements h.a.z.c.a<T> {
    final h.a.p<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends h.a.f> f21542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f21543c;

    /* JADX INFO: compiled from: ObservableFlatMapCompletableCompletable.java */
    static final class a<T> extends AtomicInteger implements h.a.x.c, h.a.q<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.d f21544f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends h.a.f> f21546h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final boolean f21547i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        h.a.x.c f21549k;
        volatile boolean l;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.z.j.a f21545g = new h.a.z.j.a();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final h.a.x.b f21548j = new h.a.x.b();

        /* JADX INFO: renamed from: h.a.z.e.d.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableFlatMapCompletableCompletable.java */
        final class C0294a extends AtomicReference<h.a.x.c> implements h.a.d, h.a.x.c {
            C0294a() {
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

        a(h.a.d dVar, h.a.y.f<? super T, ? extends h.a.f> fVar, boolean z) {
            this.f21544f = dVar;
            this.f21546h = fVar;
            this.f21547i = z;
            lazySet(1);
        }

        @Override // h.a.q
        public void a() {
            if (decrementAndGet() == 0) {
                Throwable thB = this.f21545g.b();
                if (thB != null) {
                    this.f21544f.onError(thB);
                } else {
                    this.f21544f.a();
                }
            }
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.f21549k, cVar)) {
                this.f21549k = cVar;
                this.f21544f.b(this);
            }
        }

        void c(a<T>.C0294a c0294a) {
            this.f21548j.c(c0294a);
            a();
        }

        void d(a<T>.C0294a c0294a, Throwable th) {
            this.f21548j.c(c0294a);
            onError(th);
        }

        @Override // h.a.x.c
        public void k() {
            this.l = true;
            this.f21549k.k();
            this.f21548j.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (!this.f21545g.a(th)) {
                h.a.a0.a.o(th);
                return;
            }
            if (this.f21547i) {
                if (decrementAndGet() == 0) {
                    this.f21544f.onError(this.f21545g.b());
                    return;
                }
                return;
            }
            k();
            if (getAndSet(0) > 0) {
                this.f21544f.onError(this.f21545g.b());
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            try {
                h.a.f fVar = (h.a.f) h.a.z.b.b.c(this.f21546h.a(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0294a c0294a = new C0294a();
                if (this.l || !this.f21548j.b(c0294a)) {
                    return;
                }
                fVar.b(c0294a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.f21549k.k();
                onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21549k.q();
        }
    }

    public h(h.a.p<T> pVar, h.a.y.f<? super T, ? extends h.a.f> fVar, boolean z) {
        this.a = pVar;
        this.f21542b = fVar;
        this.f21543c = z;
    }

    @Override // h.a.z.c.a
    public h.a.m<T> a() {
        return h.a.a0.a.m(new g(this.a, this.f21542b, this.f21543c));
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        this.a.a(new a(dVar, this.f21542b, this.f21543c));
    }
}
