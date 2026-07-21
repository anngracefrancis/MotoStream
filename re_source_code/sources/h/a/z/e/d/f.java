package h.a.z.e.d;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T, U> extends h.a.z.e.d.a<T, U> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final h.a.y.f<? super T, ? extends h.a.p<? extends U>> f21518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f21519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f21520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f21521j;

    /* JADX INFO: compiled from: ObservableFlatMap.java */
    static final class a<T, U> extends AtomicReference<h.a.x.c> implements h.a.q<U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f21522f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final b<T, U> f21523g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f21524h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile h.a.z.c.f<U> f21525i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f21526j;

        a(b<T, U> bVar, long j2) {
            this.f21522f = j2;
            this.f21523g = bVar;
        }

        @Override // h.a.q
        public void a() {
            this.f21524h = true;
            this.f21523g.f();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.A(this, cVar) && (cVar instanceof h.a.z.c.b)) {
                h.a.z.c.b bVar = (h.a.z.c.b) cVar;
                int iG = bVar.g(7);
                if (iG == 1) {
                    this.f21526j = iG;
                    this.f21525i = bVar;
                    this.f21524h = true;
                    this.f21523g.f();
                    return;
                }
                if (iG == 2) {
                    this.f21526j = iG;
                    this.f21525i = bVar;
                }
            }
        }

        public void c() {
            h.a.z.a.c.g(this);
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (!this.f21523g.o.a(th)) {
                h.a.a0.a.o(th);
                return;
            }
            b<T, U> bVar = this.f21523g;
            if (!bVar.f21531j) {
                bVar.e();
            }
            this.f21524h = true;
            this.f21523g.f();
        }

        @Override // h.a.q
        public void onNext(U u) {
            if (this.f21526j == 0) {
                this.f21523g.j(u, this);
            } else {
                this.f21523g.f();
            }
        }
    }

    /* JADX INFO: compiled from: ObservableFlatMap.java */
    static final class b<T, U> extends AtomicInteger implements h.a.x.c, h.a.q<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final a<?, ?>[] f21527f = new a[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final a<?, ?>[] f21528g = new a[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.q<? super U> f21529h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final h.a.y.f<? super T, ? extends h.a.p<? extends U>> f21530i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final boolean f21531j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f21532k;
        final int l;
        volatile h.a.z.c.e<U> m;
        volatile boolean n;
        final h.a.z.j.a o = new h.a.z.j.a();
        volatile boolean p;
        final AtomicReference<a<?, ?>[]> q;
        h.a.x.c r;
        long s;
        long t;
        int u;
        Queue<h.a.p<? extends U>> v;
        int w;

        b(h.a.q<? super U> qVar, h.a.y.f<? super T, ? extends h.a.p<? extends U>> fVar, boolean z, int i2, int i3) {
            this.f21529h = qVar;
            this.f21530i = fVar;
            this.f21531j = z;
            this.f21532k = i2;
            this.l = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.v = new ArrayDeque(i2);
            }
            this.q = new AtomicReference<>(f21527f);
        }

        @Override // h.a.q
        public void a() {
            if (this.n) {
                return;
            }
            this.n = true;
            f();
        }

        @Override // h.a.q
        public void b(h.a.x.c cVar) {
            if (h.a.z.a.c.D(this.r, cVar)) {
                this.r = cVar;
                this.f21529h.b(this);
            }
        }

        boolean c(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.q.get();
                if (aVarArr == f21528g) {
                    aVar.c();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.q.compareAndSet(aVarArr, (a<?, ?>[]) aVarArr2));
            return true;
        }

        boolean d() {
            if (this.p) {
                return true;
            }
            Throwable th = this.o.get();
            if (this.f21531j || th == null) {
                return false;
            }
            e();
            Throwable thB = this.o.b();
            if (thB != h.a.z.j.c.a) {
                this.f21529h.onError(thB);
            }
            return true;
        }

        boolean e() {
            a<?, ?>[] andSet;
            this.r.k();
            a<?, ?>[] aVarArr = this.q.get();
            a<?, ?>[] aVarArr2 = f21528g;
            if (aVarArr == aVarArr2 || (andSet = this.q.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.c();
            }
            return true;
        }

        void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        /* JADX WARN: Code duplicated, block: B:120:0x00ea A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:133:0x00f2 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:85:0x00f1 A[PHI: r4
          0x00f1: PHI (r4v10 int) = (r4v8 int), (r4v11 int) binds: [B:72:0x00d0, B:84:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            int size;
            boolean z;
            h.a.q<? super U> qVar = this.f21529h;
            int iAddAndGet = 1;
            while (!d()) {
                h.a.z.c.e<U> eVar = this.m;
                if (eVar != null) {
                    while (!d()) {
                        U uPoll = eVar.poll();
                        if (uPoll != null) {
                            qVar.onNext(uPoll);
                        }
                    }
                    return;
                }
                boolean z2 = this.n;
                h.a.z.c.e<U> eVar2 = this.m;
                a<?, ?>[] aVarArr = this.q.get();
                int length = aVarArr.length;
                int i2 = 0;
                if (this.f21532k != Integer.MAX_VALUE) {
                    synchronized (this) {
                        size = this.v.size();
                    }
                } else {
                    size = 0;
                }
                if (z2 && ((eVar2 == null || eVar2.isEmpty()) && length == 0 && size == 0)) {
                    Throwable thB = this.o.b();
                    if (thB != h.a.z.j.c.a) {
                        if (thB == null) {
                            qVar.a();
                            return;
                        } else {
                            qVar.onError(thB);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    long j2 = this.t;
                    int i3 = this.u;
                    if (length <= i3 || aVarArr[i3].f21522f != j2) {
                        if (length <= i3) {
                            i3 = 0;
                        }
                        for (int i4 = 0; i4 < length && aVarArr[i3].f21522f != j2; i4++) {
                            i3++;
                            if (i3 == length) {
                                i3 = 0;
                            }
                        }
                        this.u = i3;
                        this.t = aVarArr[i3].f21522f;
                    }
                    int i5 = 0;
                    for (int i6 = 0; i6 < length; i6++) {
                        if (d()) {
                            return;
                        }
                        a<T, U> aVar = aVarArr[i3];
                        h.a.z.c.f<U> fVar = aVar.f21525i;
                        if (fVar != null) {
                            do {
                                try {
                                    U uPoll2 = fVar.poll();
                                    if (uPoll2 == null) {
                                        z = aVar.f21524h;
                                        h.a.z.c.f<U> fVar2 = aVar.f21525i;
                                        if (z && (fVar2 == null || fVar2.isEmpty())) {
                                            h(aVar);
                                            if (d()) {
                                                return;
                                            } else {
                                                i5++;
                                            }
                                        }
                                        i3++;
                                        if (i3 == length) {
                                            i3 = 0;
                                        }
                                    } else {
                                        qVar.onNext(uPoll2);
                                    }
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.a(th);
                                    aVar.c();
                                    this.o.a(th);
                                    if (d()) {
                                        return;
                                    }
                                    h(aVar);
                                    i5++;
                                    i3++;
                                    if (i3 == length) {
                                    }
                                }
                            } while (!d());
                            return;
                        }
                        z = aVar.f21524h;
                        h.a.z.c.f<U> fVar3 = aVar.f21525i;
                        if (z) {
                            h(aVar);
                            if (d()) {
                                return;
                            } else {
                                i5++;
                            }
                        }
                        i3++;
                        if (i3 == length) {
                            i3 = 0;
                        }
                    }
                    this.u = i3;
                    this.t = aVarArr[i3].f21522f;
                    i2 = i5;
                }
                if (i2 == 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (this.f21532k != Integer.MAX_VALUE) {
                    while (true) {
                        int i7 = i2 - 1;
                        if (i2 != 0) {
                            synchronized (this) {
                                h.a.p<? extends U> pVarPoll = this.v.poll();
                                if (pVarPoll == null) {
                                    this.w--;
                                } else {
                                    i(pVarPoll);
                                }
                            }
                            i2 = i7;
                        }
                    }
                } else {
                    continue;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void h(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.q.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                for (int i3 = 0; i3 < length; i3++) {
                    if (aVarArr[i3] == aVar) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f21527f;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                    System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!this.q.compareAndSet(aVarArr, aVarArr2));
        }

        void i(h.a.p<? extends U> pVar) {
            h.a.p<? extends U> pVarPoll;
            while (pVar instanceof Callable) {
                if (!l((Callable) pVar) || this.f21532k == Integer.MAX_VALUE) {
                    return;
                }
                boolean z = false;
                synchronized (this) {
                    pVarPoll = this.v.poll();
                    if (pVarPoll == null) {
                        this.w--;
                        z = true;
                    }
                }
                if (z) {
                    f();
                    return;
                }
                pVar = pVarPoll;
            }
            long j2 = this.s;
            this.s = 1 + j2;
            a<T, U> aVar = new a<>(this, j2);
            if (c(aVar)) {
                pVar.a(aVar);
            }
        }

        void j(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f21529h.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.a.z.c.f cVar = aVar.f21525i;
                if (cVar == null) {
                    cVar = new h.a.z.f.c(this.l);
                    aVar.f21525i = cVar;
                }
                cVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            g();
        }

        @Override // h.a.x.c
        public void k() {
            Throwable thB;
            if (this.p) {
                return;
            }
            this.p = true;
            if (!e() || (thB = this.o.b()) == null || thB == h.a.z.j.c.a) {
                return;
            }
            h.a.a0.a.o(thB);
        }

        boolean l(Callable<? extends U> callable) {
            try {
                U uCall = callable.call();
                if (uCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f21529h.onNext(uCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    h.a.z.c.e<U> cVar = this.m;
                    if (cVar == null) {
                        cVar = this.f21532k == Integer.MAX_VALUE ? new h.a.z.f.c<>(this.l) : new h.a.z.f.b<>(this.f21532k);
                        this.m = cVar;
                    }
                    if (!cVar.offer(uCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                g();
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.o.a(th);
                f();
                return true;
            }
        }

        @Override // h.a.q
        public void onError(Throwable th) {
            if (this.n) {
                h.a.a0.a.o(th);
            } else if (!this.o.a(th)) {
                h.a.a0.a.o(th);
            } else {
                this.n = true;
                f();
            }
        }

        @Override // h.a.q
        public void onNext(T t) {
            if (this.n) {
                return;
            }
            try {
                h.a.p<? extends U> pVar = (h.a.p) h.a.z.b.b.c(this.f21530i.a(t), "The mapper returned a null ObservableSource");
                if (this.f21532k != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i2 = this.w;
                        if (i2 == this.f21532k) {
                            this.v.offer(pVar);
                            return;
                        }
                        this.w = i2 + 1;
                    }
                }
                i(pVar);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.a(th);
                this.r.k();
                onError(th);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.p;
        }
    }

    public f(h.a.p<T> pVar, h.a.y.f<? super T, ? extends h.a.p<? extends U>> fVar, boolean z, int i2, int i3) {
        super(pVar);
        this.f21518g = fVar;
        this.f21519h = z;
        this.f21520i = i2;
        this.f21521j = i3;
    }

    @Override // h.a.m
    public void x(h.a.q<? super U> qVar) {
        if (p.b(this.f21503f, qVar, this.f21518g)) {
            return;
        }
        this.f21503f.a(new b(qVar, this.f21518g, this.f21519h, this.f21520i, this.f21521j));
    }
}
