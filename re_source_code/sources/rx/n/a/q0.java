package rx.n.a;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: OperatorMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q0<T> implements rx.e.b<T, rx.e<? extends T>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f26417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f26418g;

    /* JADX INFO: compiled from: OperatorMerge.java */
    static final class a {
        static final q0<Object> a = new q0<>(true, Integer.MAX_VALUE);
    }

    /* JADX INFO: compiled from: OperatorMerge.java */
    static final class b {
        static final q0<Object> a = new q0<>(false, Integer.MAX_VALUE);
    }

    /* JADX INFO: compiled from: OperatorMerge.java */
    static final class c<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final int f26419f = rx.n.e.h.f26744f / 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final e<T> f26420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f26421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f26422i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile rx.n.e.h f26423j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f26424k;

        public c(e<T> eVar, long j2) {
            this.f26420g = eVar;
            this.f26421h = j2;
        }

        public void c(long j2) {
            int i2 = this.f26424k - ((int) j2);
            if (i2 > f26419f) {
                this.f26424k = i2;
                return;
            }
            int i3 = rx.n.e.h.f26744f;
            this.f26424k = i3;
            int i4 = i3 - i2;
            if (i4 > 0) {
                request(i4);
            }
        }

        @Override // rx.f
        public void onCompleted() throws Throwable {
            this.f26422i = true;
            this.f26420g.e();
        }

        @Override // rx.f
        public void onError(Throwable th) throws Throwable {
            this.f26420g.k().offer(th);
            this.f26422i = true;
            this.f26420g.e();
        }

        @Override // rx.f
        public void onNext(T t) throws Throwable {
            this.f26420g.s(this, t);
        }

        @Override // rx.j
        public void onStart() {
            int i2 = rx.n.e.h.f26744f;
            this.f26424k = i2;
            request(i2);
        }
    }

    /* JADX INFO: compiled from: OperatorMerge.java */
    static final class d<T> extends AtomicLong implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final e<T> f26425f;

        public d(e<T> eVar) {
            this.f26425f = eVar;
        }

        public long a(int i2) {
            return addAndGet(-i2);
        }

        @Override // rx.g
        public void request(long j2) throws Throwable {
            if (j2 <= 0) {
                if (j2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                rx.n.a.a.b(this, j2);
                this.f26425f.e();
            }
        }
    }

    /* JADX INFO: compiled from: OperatorMerge.java */
    static final class e<T> extends rx.j<rx.e<? extends T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final c<?>[] f26426f = new c[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.j<? super T> f26427g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f26428h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final int f26429i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        d<T> f26430j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile Queue<Object> f26431k;
        volatile rx.t.b l;
        volatile ConcurrentLinkedQueue<Throwable> m;
        volatile boolean n;
        boolean o;
        boolean p;
        final Object q = new Object();
        volatile c<?>[] r = f26426f;
        long s;
        long t;
        int u;
        final int v;
        int w;

        public e(rx.j<? super T> jVar, boolean z, int i2) {
            this.f26427g = jVar;
            this.f26428h = z;
            this.f26429i = i2;
            if (i2 == Integer.MAX_VALUE) {
                this.v = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.v = Math.max(1, i2 >> 1);
                request(i2);
            }
        }

        private void p() {
            ArrayList arrayList = new ArrayList(this.m);
            if (arrayList.size() == 1) {
                this.f26427g.onError((Throwable) arrayList.get(0));
            } else {
                this.f26427g.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(c<T> cVar) {
            j().a(cVar);
            synchronized (this.q) {
                c<?>[] cVarArr = this.r;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.r = cVarArr2;
            }
        }

        boolean d() {
            if (this.f26427g.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
            if (this.f26428h || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                p();
                return true;
            } finally {
                unsubscribe();
            }
        }

        void e() throws Throwable {
            synchronized (this) {
                if (this.o) {
                    this.p = true;
                } else {
                    this.o = true;
                    g();
                }
            }
        }

        void f() {
            int i2 = this.w + 1;
            if (i2 != this.v) {
                this.w = i2;
            } else {
                this.w = 0;
                q(i2);
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0197 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void g() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 424
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.n.a.q0.e.g():void");
        }

        protected void h(T t, long j2) throws Throwable {
            boolean z = true;
            try {
                try {
                    try {
                        this.f26427g.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.o = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (!this.f26428h) {
                        rx.exceptions.a.e(th2);
                        unsubscribe();
                        onError(th2);
                        return;
                    }
                    k().offer(th2);
                }
                if (j2 != Long.MAX_VALUE) {
                    this.f26430j.a(1);
                }
                int i2 = this.w + 1;
                if (i2 == this.v) {
                    this.w = 0;
                    q(i2);
                } else {
                    this.w = i2;
                }
                synchronized (this) {
                    if (!this.p) {
                        this.o = false;
                    } else {
                        this.p = false;
                        g();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        /* JADX WARN: Code duplicated, block: B:34:0x004a  */
        /* JADX WARN: Code duplicated, block: B:46:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        protected void i(c<T> cVar, T t, long j2) throws Throwable {
            boolean z = true;
            try {
                try {
                    try {
                        this.f26427g.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.o = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (!this.f26428h) {
                        rx.exceptions.a.e(th2);
                        cVar.unsubscribe();
                        cVar.onError(th2);
                        return;
                    }
                    k().offer(th2);
                }
                if (j2 != Long.MAX_VALUE) {
                    this.f26430j.a(1);
                }
                cVar.c(1L);
                synchronized (this) {
                    if (!this.p) {
                        this.o = false;
                    } else {
                        this.p = false;
                        g();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!z) {
                    synchronized (this) {
                        this.o = false;
                    }
                }
                throw th;
            }
        }

        rx.t.b j() {
            rx.t.b bVar;
            rx.t.b bVar2 = this.l;
            if (bVar2 != null) {
                return bVar2;
            }
            boolean z = false;
            synchronized (this) {
                bVar = this.l;
                if (bVar == null) {
                    rx.t.b bVar3 = new rx.t.b();
                    this.l = bVar3;
                    bVar = bVar3;
                    z = true;
                }
            }
            if (z) {
                add(bVar);
            }
            return bVar;
        }

        Queue<Throwable> k() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.m;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.m = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<? extends T> eVar) throws Throwable {
            if (eVar == null) {
                return;
            }
            if (eVar == rx.e.B()) {
                f();
                return;
            }
            if (eVar instanceof rx.n.e.j) {
                r(((rx.n.e.j) eVar).h1());
                return;
            }
            long j2 = this.s;
            this.s = 1 + j2;
            c cVar = new c(this, j2);
            c(cVar);
            eVar.c1(cVar);
            e();
        }

        protected void m(T t) throws Throwable {
            Queue<Object> fVar;
            Queue<Object> hVar = this.f26431k;
            if (hVar == null) {
                int i2 = this.f26429i;
                if (i2 == Integer.MAX_VALUE) {
                    hVar = new rx.n.e.n.h<>(rx.n.e.h.f26744f);
                } else {
                    if (rx.n.e.o.j.a(i2)) {
                        fVar = rx.n.e.o.z.b() ? new rx.n.e.o.s<>(i2) : new rx.n.e.n.e<>(i2);
                    } else {
                        fVar = new rx.n.e.n.f<>(i2);
                    }
                    hVar = fVar;
                }
                this.f26431k = hVar;
            }
            if (hVar.offer(h.g(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.a(new MissingBackpressureException(), t));
        }

        protected void n(c<T> cVar, T t) throws Throwable {
            rx.n.e.h hVarB = cVar.f26423j;
            if (hVarB == null) {
                hVarB = rx.n.e.h.b();
                cVar.add(hVarB);
                cVar.f26423j = hVarB;
            }
            try {
                hVarB.g(h.g(t));
            } catch (IllegalStateException e2) {
                if (cVar.isUnsubscribed()) {
                    return;
                }
                cVar.unsubscribe();
                cVar.onError(e2);
            } catch (MissingBackpressureException e3) {
                cVar.unsubscribe();
                cVar.onError(e3);
            }
        }

        void o(c<T> cVar) {
            rx.n.e.h hVar = cVar.f26423j;
            if (hVar != null) {
                hVar.j();
            }
            this.l.d(cVar);
            synchronized (this.q) {
                c<?>[] cVarArr = this.r;
                int length = cVarArr.length;
                int i2 = -1;
                for (int i3 = 0; i3 < length; i3++) {
                    if (cVar.equals(cVarArr[i3])) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    this.r = f26426f;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr2, i2, (length - i2) - 1);
                this.r = cVarArr2;
            }
        }

        @Override // rx.f
        public void onCompleted() throws Throwable {
            this.n = true;
            e();
        }

        @Override // rx.f
        public void onError(Throwable th) throws Throwable {
            k().offer(th);
            this.n = true;
            e();
        }

        public void q(long j2) {
            request(j2);
        }

        void r(T t) throws Throwable {
            long j2 = this.f26430j.get();
            boolean z = false;
            if (j2 != 0) {
                synchronized (this) {
                    j2 = this.f26430j.get();
                    if (!this.o && j2 != 0) {
                        this.o = true;
                        z = true;
                    }
                }
            }
            if (!z) {
                m(t);
                e();
                return;
            }
            Queue<Object> queue = this.f26431k;
            if (queue == null || queue.isEmpty()) {
                h(t, j2);
            } else {
                m(t);
                g();
            }
        }

        void s(c<T> cVar, T t) throws Throwable {
            long j2 = this.f26430j.get();
            boolean z = false;
            if (j2 != 0) {
                synchronized (this) {
                    j2 = this.f26430j.get();
                    if (!this.o && j2 != 0) {
                        this.o = true;
                        z = true;
                    }
                }
            }
            if (!z) {
                n(cVar, t);
                e();
                return;
            }
            rx.n.e.h hVar = cVar.f26423j;
            if (hVar == null || hVar.e()) {
                i(cVar, t, j2);
            } else {
                n(cVar, t);
                g();
            }
        }
    }

    q0(boolean z, int i2) {
        this.f26417f = z;
        this.f26418g = i2;
    }

    public static <T> q0<T> b(boolean z) {
        return z ? (q0<T>) a.a : (q0<T>) b.a;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<rx.e<? extends T>> call(rx.j<? super T> jVar) {
        e eVar = new e(jVar, this.f26417f, this.f26418g);
        d<T> dVar = new d<>(eVar);
        eVar.f26430j = dVar;
        jVar.add(eVar);
        jVar.setProducer(dVar);
        return eVar;
    }
}
