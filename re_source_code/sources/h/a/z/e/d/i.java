package h.a.z.e.d;

import android.R;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMapMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T, R> extends h.a.z.e.d.a<T, R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends h.a.l<? extends R>> f21551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f21552h;

    /* JADX INFO: compiled from: ObservableFlatMapMaybe.java */
    static final class a<T, R> extends AtomicInteger implements h.a.q<T>, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.q<? super R> f21553f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f21554g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends h.a.l<? extends R>> f21558k;
        h.a.x.c m;
        volatile boolean n;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.x.b f21555h = new h.a.x.b();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final h.a.z.j.a f21557j = new h.a.z.j.a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicInteger f21556i = new AtomicInteger(1);
        final AtomicReference<h.a.z.f.c<R>> l = new AtomicReference<>();

        /* JADX INFO: renamed from: h.a.z.e.d.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableFlatMapMaybe.java */
        final class C0295a extends AtomicReference<h.a.x.c> implements h.a.k<R>, h.a.x.c {
            C0295a() {
            }

            @Override // h.a.k
            public void a() {
                a.this.g(this);
            }

            @Override // h.a.k
            public void b(h.a.x.c cVar) {
                h.a.z.a.c.A(this, cVar);
            }

            @Override // h.a.x.c
            public void k() {
                h.a.z.a.c.g(this);
            }

            @Override // h.a.k
            public void onError(Throwable th) {
                a.this.h(this, th);
            }

            @Override // h.a.k
            public void onSuccess(R r) {
                a.this.i(this, r);
            }

            @Override // h.a.x.c
            public boolean q() {
                return h.a.z.a.c.u(get());
            }
        }

        a(h.a.q<? super R> qVar, h.a.y.f<? super T, ? extends h.a.l<? extends R>> fVar, boolean z) {
            this.f21553f = qVar;
            this.f21558k = fVar;
            this.f21554g = z;
        }

        @Override // h.a.q
        public void a() {
            this.f21556i.decrementAndGet();
            d();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.m, cVar)) {
                this.m = cVar;
                this.f21553f.b(this);
            }
        }

        void c() {
            h.a.z.f.c<R> cVar = this.l.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        void e() {
            h.a.q<? super R> qVar = this.f21553f;
            AtomicInteger atomicInteger = this.f21556i;
            AtomicReference<h.a.z.f.c<R>> atomicReference = this.l;
            int iAddAndGet = 1;
            while (!this.n) {
                if (!this.f21554g && this.f21557j.get() != null) {
                    Throwable thB = this.f21557j.b();
                    c();
                    qVar.onError(thB);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                h.a.z.f.c<R> cVar = atomicReference.get();
                R.bool boolVarPoll = cVar != null ? cVar.poll() : null;
                boolean z2 = boolVarPoll == null;
                if (z && z2) {
                    Throwable thB2 = this.f21557j.b();
                    if (thB2 != null) {
                        qVar.onError(thB2);
                        return;
                    } else {
                        qVar.a();
                        return;
                    }
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    qVar.onNext(boolVarPoll);
                }
            }
            c();
        }

        h.a.z.f.c<R> f() {
            h.a.z.f.c<R> cVar;
            do {
                h.a.z.f.c<R> cVar2 = this.l.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.a.z.f.c<>(h.a.m.b());
            } while (!this.l.compareAndSet(null, cVar));
            return cVar;
        }

        void g(a<T, R>.C0295a c0295a) {
            this.f21555h.c(c0295a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z = this.f21556i.decrementAndGet() == 0;
                    h.a.z.f.c<R> cVar = this.l.get();
                    if (!z || (cVar != null && !cVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        e();
                        return;
                    } else {
                        Throwable thB = this.f21557j.b();
                        if (thB != null) {
                            this.f21553f.onError(thB);
                            return;
                        } else {
                            this.f21553f.a();
                            return;
                        }
                    }
                }
            }
            this.f21556i.decrementAndGet();
            d();
        }

        void h(a<T, R>.C0295a c0295a, Throwable th) {
            this.f21555h.c(c0295a);
            if (!this.f21557j.a(th)) {
                h.a.a0.a.o(th);
                return;
            }
            if (!this.f21554g) {
                this.m.k();
                this.f21555h.k();
            }
            this.f21556i.decrementAndGet();
            d();
        }

        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:28:0x0062 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        void i(a<T, R>.C0295a c0295a, R r) {
            h.a.z.f.c<R> cVarF;
            this.f21555h.c(c0295a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.f21553f.onNext(r);
                    boolean z = this.f21556i.decrementAndGet() == 0;
                    h.a.z.f.c<R> cVar = this.l.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable thB = this.f21557j.b();
                        if (thB != null) {
                            this.f21553f.onError(thB);
                            return;
                        } else {
                            this.f21553f.a();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    cVarF = f();
                    synchronized (cVarF) {
                        cVarF.offer(r);
                    }
                    this.f21556i.decrementAndGet();
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            } else {
                cVarF = f();
                synchronized (cVarF) {
                    cVarF.offer(r);
                    this.f21556i.decrementAndGet();
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            e();
        }

        @Override // h.a.x.c
        public void k() {
            this.n = true;
            this.m.k();
            this.f21555h.k();
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            this.f21556i.decrementAndGet();
            if (!this.f21557j.a(th)) {
                h.a.a0.a.o(th);
                return;
            }
            if (!this.f21554g) {
                this.f21555h.k();
            }
            d();
        }

        @Override // h.a.q
        public void onNext(T t) {
            try {
                h.a.l lVar = (h.a.l) h.a.z.b.b.c(this.f21558k.a(t), "The mapper returned a null MaybeSource");
                this.f21556i.getAndIncrement();
                C0295a c0295a = new C0295a();
                if (this.n || !this.f21555h.b(c0295a)) {
                    return;
                }
                lVar.a(c0295a);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.m.k();
                onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.n;
        }
    }

    public i(h.a.p<T> pVar, h.a.y.f<? super T, ? extends h.a.l<? extends R>> fVar, boolean z) {
        super(pVar);
        this.f21551g = fVar;
        this.f21552h = z;
    }

    @Override // h.a.m
    protected void x(h.a.q<? super R> qVar) {
        this.f21503f.a(new a(qVar, this.f21551g, this.f21552h));
    }
}
