package rx.n.a;

import android.R;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: OperatorSwitch.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a1<T> implements rx.e.b<T, rx.e<? extends T>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f26112f;

    /* JADX INFO: compiled from: OperatorSwitch.java */
    static final class a {
        static final a1<Object> a = new a1<>(false);
    }

    /* JADX INFO: compiled from: OperatorSwitch.java */
    static final class b {
        static final a1<Object> a = new a1<>(true);
    }

    /* JADX INFO: compiled from: OperatorSwitch.java */
    static final class c<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f26113f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final d<T> f26114g;

        c(long j2, d<T> dVar) {
            this.f26113f = j2;
            this.f26114g = dVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26114g.f(this.f26113f);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26114g.i(th, this.f26113f);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26114g.h(t, this);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26114g.k(gVar, this.f26113f);
        }
    }

    /* JADX INFO: compiled from: OperatorSwitch.java */
    static final class d<T> extends rx.j<rx.e<? extends T>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final Throwable f26115f = new Throwable("Terminal error");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.j<? super T> f26116g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final boolean f26118i;
        boolean l;
        boolean m;
        long n;
        rx.g o;
        volatile boolean p;
        Throwable q;
        boolean r;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.t.d f26117h = new rx.t.d();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicLong f26119j = new AtomicLong();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final rx.n.e.n.g<Object> f26120k = new rx.n.e.n.g<>(rx.n.e.h.f26744f);

        /* JADX INFO: compiled from: OperatorSwitch.java */
        class a implements rx.m.a {
            a() {
            }

            @Override // rx.m.a
            public void call() {
                d.this.e();
            }
        }

        /* JADX INFO: compiled from: OperatorSwitch.java */
        class b implements rx.g {
            b() {
            }

            @Override // rx.g
            public void request(long j2) {
                if (j2 > 0) {
                    d.this.d(j2);
                } else {
                    if (j2 >= 0) {
                        return;
                    }
                    throw new IllegalArgumentException("n >= 0 expected but it was " + j2);
                }
            }
        }

        d(rx.j<? super T> jVar, boolean z) {
            this.f26116g = jVar;
            this.f26118i = z;
        }

        protected boolean c(boolean z, boolean z2, Throwable th, rx.n.e.n.g<Object> gVar, rx.j<? super T> jVar, boolean z3) {
            if (this.f26118i) {
                if (!z || z2 || !z3) {
                    return false;
                }
                if (th != null) {
                    jVar.onError(th);
                } else {
                    jVar.onCompleted();
                }
                return true;
            }
            if (th != null) {
                gVar.clear();
                jVar.onError(th);
                return true;
            }
            if (!z || z2 || !z3) {
                return false;
            }
            jVar.onCompleted();
            return true;
        }

        void d(long j2) {
            rx.g gVar;
            synchronized (this) {
                gVar = this.o;
                this.n = rx.n.a.a.a(this.n, j2);
            }
            if (gVar != null) {
                gVar.request(j2);
            }
            g();
        }

        void e() {
            synchronized (this) {
                this.o = null;
            }
        }

        void f(long j2) {
            synchronized (this) {
                if (this.f26119j.get() != j2) {
                    return;
                }
                this.r = false;
                this.o = null;
                g();
            }
        }

        void g() {
            Throwable th;
            Throwable th2;
            synchronized (this) {
                if (this.l) {
                    this.m = true;
                    return;
                }
                this.l = true;
                boolean z = this.r;
                long j2 = this.n;
                Throwable th3 = this.q;
                if (th3 != null && th3 != (th2 = f26115f) && !this.f26118i) {
                    this.q = th2;
                }
                rx.n.e.n.g<Object> gVar = this.f26120k;
                AtomicLong atomicLong = this.f26119j;
                rx.j<? super T> jVar = this.f26116g;
                long j3 = j2;
                Throwable th4 = th3;
                boolean z2 = this.p;
                while (true) {
                    long j4 = 0;
                    while (j4 != j3) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        boolean zIsEmpty = gVar.isEmpty();
                        if (c(z2, z, th4, gVar, jVar, zIsEmpty)) {
                            return;
                        }
                        if (zIsEmpty) {
                            break;
                        }
                        c cVar = (c) gVar.poll();
                        R.bool boolVar = (Object) h.e(gVar.poll());
                        if (atomicLong.get() == cVar.f26113f) {
                            jVar.onNext(boolVar);
                            j4++;
                        }
                    }
                    if (j4 == j3) {
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        if (c(this.p, z, th4, gVar, jVar, gVar.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j5 = this.n;
                        if (j5 != Long.MAX_VALUE) {
                            j5 -= j4;
                            this.n = j5;
                        }
                        j3 = j5;
                        if (!this.m) {
                            this.l = false;
                            return;
                        }
                        this.m = false;
                        z2 = this.p;
                        z = this.r;
                        th4 = this.q;
                        if (th4 != null && th4 != (th = f26115f) && !this.f26118i) {
                            this.q = th;
                        }
                    }
                }
            }
        }

        void h(T t, c<T> cVar) {
            synchronized (this) {
                if (this.f26119j.get() != ((c) cVar).f26113f) {
                    return;
                }
                this.f26120k.u(cVar, h.g(t));
                g();
            }
        }

        void i(Throwable th, long j2) {
            boolean zN;
            synchronized (this) {
                if (this.f26119j.get() == j2) {
                    zN = n(th);
                    this.r = false;
                    this.o = null;
                } else {
                    zN = true;
                }
            }
            if (zN) {
                g();
            } else {
                m(th);
            }
        }

        void j() {
            this.f26116g.add(this.f26117h);
            this.f26116g.add(rx.t.e.a(new a()));
            this.f26116g.setProducer(new b());
        }

        void k(rx.g gVar, long j2) {
            synchronized (this) {
                if (this.f26119j.get() != j2) {
                    return;
                }
                long j3 = this.n;
                this.o = gVar;
                gVar.request(j3);
            }
        }

        @Override // rx.f
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<? extends T> eVar) {
            c cVar;
            long jIncrementAndGet = this.f26119j.incrementAndGet();
            rx.k kVarA = this.f26117h.a();
            if (kVarA != null) {
                kVarA.unsubscribe();
            }
            synchronized (this) {
                cVar = new c(jIncrementAndGet, this);
                this.r = true;
                this.o = null;
            }
            this.f26117h.b(cVar);
            eVar.c1(cVar);
        }

        void m(Throwable th) {
            rx.q.c.j(th);
        }

        boolean n(Throwable th) {
            Throwable th2 = this.q;
            if (th2 == f26115f) {
                return false;
            }
            if (th2 == null) {
                this.q = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                arrayList.add(th);
                this.q = new CompositeException(arrayList);
            } else {
                this.q = new CompositeException(th2, th);
            }
            return true;
        }

        @Override // rx.f
        public void onCompleted() {
            this.p = true;
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            boolean zN;
            synchronized (this) {
                zN = n(th);
            }
            if (!zN) {
                m(th);
            } else {
                this.p = true;
                g();
            }
        }
    }

    a1(boolean z) {
        this.f26112f = z;
    }

    public static <T> a1<T> b(boolean z) {
        return z ? (a1<T>) b.a : (a1<T>) a.a;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super rx.e<? extends T>> call(rx.j<? super T> jVar) {
        d dVar = new d(jVar, this.f26112f);
        jVar.add(dVar);
        dVar.j();
        return dVar;
    }
}
