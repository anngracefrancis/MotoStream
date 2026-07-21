package rx.n.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: OperatorEagerConcatMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p0<T, R> implements rx.e.b<R, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.m.e<? super T, ? extends rx.e<? extends R>> f26385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f26386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f26387h;

    /* JADX INFO: compiled from: OperatorEagerConcatMap.java */
    static final class a<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final c<?, T> f26388f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Queue<Object> f26389g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f26390h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Throwable f26391i;

        public a(c<?, T> cVar, int i2) {
            this.f26388f = cVar;
            this.f26389g = rx.n.e.o.z.b() ? new rx.n.e.o.s<>(i2) : new rx.n.e.n.e<>(i2);
            request(i2);
        }

        void c(long j2) {
            request(j2);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26390h = true;
            this.f26388f.d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26391i = th;
            this.f26390h = true;
            this.f26388f.d();
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26389g.offer(h.g(t));
            this.f26388f.d();
        }
    }

    /* JADX INFO: compiled from: OperatorEagerConcatMap.java */
    static final class b extends AtomicLong implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final c<?, ?> f26392f;

        public b(c<?, ?> cVar) {
            this.f26392f = cVar;
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j2);
            }
            if (j2 > 0) {
                rx.n.a.a.b(this, j2);
                this.f26392f.d();
            }
        }
    }

    /* JADX INFO: compiled from: OperatorEagerConcatMap.java */
    static final class c<T, R> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.m.e<? super T, ? extends rx.e<? extends R>> f26393f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f26394g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.j<? super R> f26395h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f26397j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f26398k;
        volatile boolean l;
        private b n;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Queue<a<R>> f26396i = new LinkedList();
        final AtomicInteger m = new AtomicInteger();

        /* JADX INFO: compiled from: OperatorEagerConcatMap.java */
        class a implements rx.m.a {
            a() {
            }

            @Override // rx.m.a
            public void call() {
                c.this.l = true;
                if (c.this.m.getAndIncrement() == 0) {
                    c.this.c();
                }
            }
        }

        public c(rx.m.e<? super T, ? extends rx.e<? extends R>> eVar, int i2, int i3, rx.j<? super R> jVar) {
            this.f26393f = eVar;
            this.f26394g = i2;
            this.f26395h = jVar;
            request(i3 == Integer.MAX_VALUE ? Long.MAX_VALUE : i3);
        }

        void c() {
            ArrayList arrayList;
            synchronized (this.f26396i) {
                arrayList = new ArrayList(this.f26396i);
                this.f26396i.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((rx.k) it.next()).unsubscribe();
            }
        }

        /* JADX WARN: Code duplicated, block: B:47:0x007e  */
        void d() {
            a<R> aVarPeek;
            int i2;
            if (this.m.getAndIncrement() != 0) {
                return;
            }
            b bVar = this.n;
            rx.j<? super R> jVar = this.f26395h;
            int iAddAndGet = 1;
            while (!this.l) {
                boolean z = this.f26397j;
                synchronized (this.f26396i) {
                    aVarPeek = this.f26396i.peek();
                }
                boolean z2 = false;
                boolean z3 = aVarPeek == null;
                if (z) {
                    Throwable th = this.f26398k;
                    if (th != null) {
                        c();
                        jVar.onError(th);
                        return;
                    } else if (z3) {
                        jVar.onCompleted();
                        return;
                    }
                }
                if (z3) {
                    i2 = iAddAndGet;
                } else {
                    long j2 = bVar.get();
                    Queue<Object> queue = aVarPeek.f26389g;
                    long j3 = 0;
                    while (true) {
                        boolean z4 = aVarPeek.f26390h;
                        Object objPeek = queue.peek();
                        i2 = iAddAndGet;
                        boolean z5 = objPeek == null;
                        if (!z4) {
                            if (!z5 || j2 == j3) {
                                break;
                            }
                            queue.poll();
                            try {
                                jVar.onNext((Object) h.e(objPeek));
                                j3++;
                                iAddAndGet = i2;
                            } catch (Throwable th2) {
                                rx.exceptions.a.g(th2, jVar, objPeek);
                                return;
                            }
                        } else {
                            Throwable th3 = aVarPeek.f26391i;
                            if (th3 != null) {
                                c();
                                jVar.onError(th3);
                                return;
                            }
                            if (z5) {
                                synchronized (this.f26396i) {
                                    this.f26396i.poll();
                                }
                                aVarPeek.unsubscribe();
                                request(1L);
                                z2 = true;
                                break;
                            }
                            if (!z5) {
                                break;
                            }
                            queue.poll();
                            jVar.onNext((Object) h.e(objPeek));
                            j3++;
                            iAddAndGet = i2;
                        }
                    }
                    if (j3 != 0) {
                        if (j2 != Long.MAX_VALUE) {
                            rx.n.a.a.c(bVar, j3);
                        }
                        if (!z2) {
                            aVarPeek.c(j3);
                        }
                    }
                    if (z2) {
                        iAddAndGet = i2;
                    }
                }
                iAddAndGet = this.m.addAndGet(-i2);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            c();
        }

        void e() {
            this.n = new b(this);
            add(rx.t.e.a(new a()));
            this.f26395h.add(this);
            this.f26395h.setProducer(this.n);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26397j = true;
            d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26398k = th;
            this.f26397j = true;
            d();
        }

        @Override // rx.f
        public void onNext(T t) {
            try {
                rx.e<? extends R> eVarCall = this.f26393f.call(t);
                if (this.l) {
                    return;
                }
                a<R> aVar = new a<>(this, this.f26394g);
                synchronized (this.f26396i) {
                    if (this.l) {
                        return;
                    }
                    this.f26396i.add(aVar);
                    if (this.l) {
                        return;
                    }
                    eVarCall.c1(aVar);
                    d();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f26395h, t);
            }
        }
    }

    public p0(rx.m.e<? super T, ? extends rx.e<? extends R>> eVar, int i2, int i3) {
        this.f26385f = eVar;
        this.f26386g = i2;
        this.f26387h = i3;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super R> jVar) {
        c cVar = new c(this.f26385f, this.f26386g, this.f26387h, jVar);
        cVar.e();
        return cVar;
    }
}
