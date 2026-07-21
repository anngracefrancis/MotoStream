package rx.n.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;

/* JADX INFO: compiled from: OnSubscribeFlatMapSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q<T, R> implements rx.e.a<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<T> f26405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends Single<? extends R>> f26406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f26407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f26408i;

    /* JADX INFO: compiled from: OnSubscribeFlatMapSingle.java */
    static final class a<T, R> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends Single<? extends R>> f26410g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f26411h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final int f26412i;
        final Queue<Object> n;
        volatile boolean p;
        volatile boolean q;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicInteger f26413j = new AtomicInteger();
        final AtomicReference<Throwable> m = new AtomicReference<>();
        final a<T, R>.b o = new b();
        final rx.t.b l = new rx.t.b();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicInteger f26414k = new AtomicInteger();

        /* JADX INFO: renamed from: rx.n.a.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OnSubscribeFlatMapSingle.java */
        final class C0446a extends rx.i<R> {
            C0446a() {
            }

            @Override // rx.i
            public void c(R r) {
                a.this.e(this, r);
            }

            @Override // rx.i
            public void onError(Throwable th) {
                a.this.d(this, th);
            }
        }

        /* JADX INFO: compiled from: OnSubscribeFlatMapSingle.java */
        final class b extends AtomicLong implements rx.g, rx.k {
            b() {
            }

            void a(long j2) {
                rx.n.a.a.c(this, j2);
            }

            @Override // rx.k
            public boolean isUnsubscribed() {
                return a.this.q;
            }

            @Override // rx.g
            public void request(long j2) {
                if (j2 > 0) {
                    rx.n.a.a.b(this, j2);
                    a.this.c();
                }
            }

            @Override // rx.k
            public void unsubscribe() {
                a.this.q = true;
                a.this.unsubscribe();
                if (a.this.f26413j.getAndIncrement() == 0) {
                    a.this.n.clear();
                }
            }
        }

        a(rx.j<? super R> jVar, rx.m.e<? super T, ? extends Single<? extends R>> eVar, boolean z, int i2) {
            this.f26409f = jVar;
            this.f26410g = eVar;
            this.f26411h = z;
            this.f26412i = i2;
            if (rx.n.e.o.z.b()) {
                this.n = new rx.n.e.o.i();
            } else {
                this.n = new rx.n.e.n.d();
            }
            request(i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE);
        }

        void c() {
            if (this.f26413j.getAndIncrement() != 0) {
                return;
            }
            rx.j<? super R> jVar = this.f26409f;
            Queue<Object> queue = this.n;
            boolean z = this.f26411h;
            AtomicInteger atomicInteger = this.f26414k;
            int iAddAndGet = 1;
            do {
                long j2 = this.o.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.q) {
                        queue.clear();
                        return;
                    }
                    boolean z2 = this.p;
                    if (!z && z2 && this.m.get() != null) {
                        queue.clear();
                        jVar.onError(rx.n.e.e.q(this.m));
                        return;
                    }
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && atomicInteger.get() == 0 && z3) {
                        if (this.m.get() != null) {
                            jVar.onError(rx.n.e.e.q(this.m));
                            return;
                        } else {
                            jVar.onCompleted();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    jVar.onNext((Object) h.e(objPoll));
                    j3++;
                }
                if (j3 == j2) {
                    if (this.q) {
                        queue.clear();
                        return;
                    }
                    if (this.p) {
                        if (z) {
                            if (atomicInteger.get() == 0 && queue.isEmpty()) {
                                if (this.m.get() != null) {
                                    jVar.onError(rx.n.e.e.q(this.m));
                                    return;
                                } else {
                                    jVar.onCompleted();
                                    return;
                                }
                            }
                        } else if (this.m.get() != null) {
                            queue.clear();
                            jVar.onError(rx.n.e.e.q(this.m));
                            return;
                        } else if (atomicInteger.get() == 0 && queue.isEmpty()) {
                            jVar.onCompleted();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    this.o.a(j3);
                    if (!this.p && this.f26412i != Integer.MAX_VALUE) {
                        request(j3);
                    }
                }
                iAddAndGet = this.f26413j.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void d(a<T, R>.C0446a c0446a, Throwable th) {
            if (this.f26411h) {
                rx.n.e.e.g(this.m, th);
                this.l.d(c0446a);
                if (!this.p && this.f26412i != Integer.MAX_VALUE) {
                    request(1L);
                }
            } else {
                this.l.unsubscribe();
                unsubscribe();
                if (!this.m.compareAndSet(null, th)) {
                    rx.q.c.j(th);
                    return;
                }
                this.p = true;
            }
            this.f26414k.decrementAndGet();
            c();
        }

        void e(a<T, R>.C0446a c0446a, R r) {
            this.n.offer(h.g(r));
            this.l.d(c0446a);
            this.f26414k.decrementAndGet();
            c();
        }

        @Override // rx.f
        public void onCompleted() {
            this.p = true;
            c();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26411h) {
                rx.n.e.e.g(this.m, th);
            } else {
                this.l.unsubscribe();
                if (!this.m.compareAndSet(null, th)) {
                    rx.q.c.j(th);
                    return;
                }
            }
            this.p = true;
            c();
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                Single<? extends R> singleCall = this.f26410g.call(t);
                if (singleCall == null) {
                    throw new NullPointerException("The mapper returned a null Single");
                }
                C0446a c0446a = new C0446a();
                this.l.a(c0446a);
                this.f26414k.incrementAndGet();
                singleCall.t(c0446a);
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public q(rx.e<T> eVar, rx.m.e<? super T, ? extends Single<? extends R>> eVar2, boolean z, int i2) {
        if (eVar2 == null) {
            throw new NullPointerException("mapper is null");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i2);
        }
        this.f26405f = eVar;
        this.f26406g = eVar2;
        this.f26407h = z;
        this.f26408i = i2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        a aVar = new a(jVar, this.f26406g, this.f26407h, this.f26408i);
        jVar.add(aVar.l);
        jVar.add(aVar.o);
        jVar.setProducer(aVar.o);
        this.f26405f.c1(aVar);
    }
}
