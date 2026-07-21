package rx.n.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u0<T> extends rx.o.b<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.e<? extends T> f26503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<c<T>> f26504h;

    /* JADX INFO: compiled from: OperatorPublish.java */
    static class a implements rx.e.a<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicReference f26505f;

        a(AtomicReference atomicReference) {
            this.f26505f = atomicReference;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super T> jVar) {
            while (true) {
                c cVar = (c) this.f26505f.get();
                if (cVar == null || cVar.isUnsubscribed()) {
                    c cVar2 = new c(this.f26505f);
                    cVar2.f();
                    if (this.f26505f.compareAndSet(cVar, cVar2)) {
                        cVar = cVar2;
                    } else {
                        continue;
                    }
                }
                b<T> bVar = new b<>(cVar, jVar);
                if (cVar.c(bVar)) {
                    jVar.add(bVar);
                    jVar.setProducer(bVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: OperatorPublish.java */
    static final class b<T> extends AtomicLong implements rx.g, rx.k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final c<T> f26506f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.j<? super T> f26507g;

        public b(c<T> cVar, rx.j<? super T> jVar) {
            this.f26506f = cVar;
            this.f26507g = jVar;
            lazySet(-4611686018427387904L);
        }

        public long a(long j2) {
            long j3;
            long j4;
            if (j2 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j3 = get();
                if (j3 == -4611686018427387904L) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j3 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + ")");
                }
            } while (!compareAndSet(j3, j4));
            return j4;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.g
        public void request(long j2) throws Throwable {
            long j3;
            long j4;
            if (j2 < 0) {
                return;
            }
            do {
                j3 = get();
                if (j3 == Long.MIN_VALUE) {
                    return;
                }
                if (j3 >= 0 && j2 == 0) {
                    return;
                }
                if (j3 == -4611686018427387904L) {
                    j4 = j2;
                } else {
                    j4 = j3 + j2;
                    if (j4 < 0) {
                        j4 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j3, j4));
            this.f26506f.e();
        }

        @Override // rx.k
        public void unsubscribe() throws Throwable {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f26506f.g(this);
            this.f26506f.e();
        }
    }

    /* JADX INFO: compiled from: OperatorPublish.java */
    static final class c<T> extends rx.j<T> implements rx.k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final b[] f26508f = new b[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final b[] f26509g = new b[0];

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Queue<Object> f26510h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicReference<c<T>> f26511i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile Object f26512j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicReference<b[]> f26513k;
        final AtomicBoolean l;
        boolean m;
        boolean n;

        /* JADX INFO: compiled from: OperatorPublish.java */
        class a implements rx.m.a {
            a() {
            }

            @Override // rx.m.a
            public void call() {
                c.this.f26513k.getAndSet(c.f26509g);
                c<T> cVar = c.this;
                cVar.f26511i.compareAndSet(cVar, null);
            }
        }

        public c(AtomicReference<c<T>> atomicReference) {
            this.f26510h = rx.n.e.o.z.b() ? new rx.n.e.o.s<>(rx.n.e.h.f26744f) : new rx.n.e.n.e<>(rx.n.e.h.f26744f);
            this.f26513k = new AtomicReference<>(f26508f);
            this.f26511i = atomicReference;
            this.l = new AtomicBoolean();
        }

        boolean c(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            bVar.getClass();
            do {
                bVarArr = this.f26513k.get();
                if (bVarArr == f26509g) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f26513k.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean d(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!h.f(obj)) {
                    Throwable thD = h.d(obj);
                    this.f26511i.compareAndSet(this, null);
                    try {
                        b[] andSet = this.f26513k.getAndSet(f26509g);
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].f26507g.onError(thD);
                            i2++;
                        }
                        unsubscribe();
                        return true;
                    } catch (Throwable th) {
                        unsubscribe();
                        throw th;
                    }
                }
                if (z) {
                    this.f26511i.compareAndSet(this, null);
                    try {
                        b[] andSet2 = this.f26513k.getAndSet(f26509g);
                        int length2 = andSet2.length;
                        while (i2 < length2) {
                            andSet2[i2].f26507g.onCompleted();
                            i2++;
                        }
                        unsubscribe();
                        return true;
                    } catch (Throwable th2) {
                        unsubscribe();
                        throw th2;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x00de */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void e() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.n.a.u0.c.e():void");
        }

        void f() {
            add(rx.t.e.a(new a()));
        }

        void g(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.f26513k.get();
                if (bVarArr == f26508f || bVarArr == f26509g) {
                    return;
                }
                int i2 = -1;
                int length = bVarArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (bVarArr[i3].equals(bVar)) {
                        i2 = i3;
                        break;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f26508f;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f26513k.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // rx.f
        public void onCompleted() throws Throwable {
            if (this.f26512j == null) {
                this.f26512j = h.b();
                e();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) throws Throwable {
            if (this.f26512j == null) {
                this.f26512j = h.c(th);
                e();
            }
        }

        @Override // rx.f
        public void onNext(T t) throws Throwable {
            if (this.f26510h.offer(h.g(t))) {
                e();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // rx.j
        public void onStart() {
            request(rx.n.e.h.f26744f);
        }
    }

    private u0(rx.e.a<T> aVar, rx.e<? extends T> eVar, AtomicReference<c<T>> atomicReference) {
        super(aVar);
        this.f26503g = eVar;
        this.f26504h = atomicReference;
    }

    public static <T> rx.o.b<T> k1(rx.e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new u0(new a(atomicReference), eVar, atomicReference);
    }

    @Override // rx.o.b
    public void i1(rx.m.b<? super rx.k> bVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f26504h.get();
            if (cVar != null && !cVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f26504h);
            cVar2.f();
            if (this.f26504h.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = !cVar.l.get() && cVar.l.compareAndSet(false, true);
        bVar.call(cVar);
        if (z) {
            this.f26503g.c1(cVar);
        }
    }
}
