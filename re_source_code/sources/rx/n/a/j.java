package rx.n.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

/* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j<T, R> implements rx.e.a<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<? extends T>[] f26263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Iterable<? extends rx.e<? extends T>> f26264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final rx.m.h<? extends R> f26265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f26266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f26267j;

    /* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
    static final class a<T, R> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final b<T, R> f26268f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f26269g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f26270h;

        public a(b<T, R> bVar, int i2) {
            this.f26268f = bVar;
            this.f26269g = i2;
            request(bVar.f26275j);
        }

        public void c(long j2) {
            request(j2);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26270h) {
                return;
            }
            this.f26270h = true;
            this.f26268f.c(null, this.f26269g);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26270h) {
                rx.q.c.j(th);
                return;
            }
            this.f26268f.e(th);
            this.f26270h = true;
            this.f26268f.c(null, this.f26269g);
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26270h) {
                return;
            }
            this.f26268f.c(h.g(t), this.f26269g);
        }
    }

    /* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
    static final class b<T, R> extends AtomicInteger implements rx.g, rx.k {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final Object f26271f = new Object();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.j<? super R> f26272g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final rx.m.h<? extends R> f26273h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final a<T, R>[] f26274i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final int f26275j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Object[] f26276k;
        final rx.n.e.n.g<Object> l;
        final boolean m;
        volatile boolean n;
        volatile boolean o;
        final AtomicLong p;
        final AtomicReference<Throwable> q;
        int r;
        int s;

        public b(rx.j<? super R> jVar, rx.m.h<? extends R> hVar, int i2, int i3, boolean z) {
            this.f26272g = jVar;
            this.f26273h = hVar;
            this.f26275j = i3;
            this.m = z;
            Object[] objArr = new Object[i2];
            this.f26276k = objArr;
            Arrays.fill(objArr, f26271f);
            this.f26274i = new a[i2];
            this.l = new rx.n.e.n.g<>(i3);
            this.p = new AtomicLong();
            this.q = new AtomicReference<>();
        }

        void a(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.f26274i) {
                aVar.unsubscribe();
            }
        }

        boolean b(boolean z, boolean z2, rx.j<?> jVar, Queue<?> queue, boolean z3) {
            if (this.n) {
                a(queue);
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.q.get();
                if (th != null) {
                    jVar.onError(th);
                } else {
                    jVar.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.q.get();
            if (th2 != null) {
                a(queue);
                jVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            jVar.onCompleted();
            return true;
        }

        void c(Object obj, int i2) {
            boolean z;
            a<T, R> aVar = this.f26274i[i2];
            synchronized (this) {
                Object[] objArr = this.f26276k;
                int length = objArr.length;
                Object obj2 = objArr[i2];
                int i3 = this.r;
                Object obj3 = f26271f;
                if (obj2 == obj3) {
                    i3++;
                    this.r = i3;
                }
                int i4 = this.s;
                if (obj == null) {
                    i4++;
                    this.s = i4;
                } else {
                    objArr[i2] = h.e(obj);
                }
                boolean z2 = false;
                z = i3 == length;
                if (i4 == length || (obj == null && obj2 == obj3)) {
                    z2 = true;
                }
                if (z2) {
                    this.o = true;
                } else if (obj != null && z) {
                    this.l.u(aVar, this.f26276k.clone());
                } else if (obj == null && this.q.get() != null && (obj2 == obj3 || !this.m)) {
                    this.o = true;
                }
            }
            if (z || obj == null) {
                d();
            } else {
                aVar.c(1L);
            }
        }

        void d() {
            long j2;
            if (getAndIncrement() != 0) {
                return;
            }
            rx.n.e.n.g<Object> gVar = this.l;
            rx.j<? super R> jVar = this.f26272g;
            boolean z = this.m;
            AtomicLong atomicLong = this.p;
            int iAddAndGet = 1;
            while (!b(this.o, gVar.isEmpty(), jVar, gVar, z)) {
                long j3 = atomicLong.get();
                long j4 = 0;
                while (true) {
                    if (j4 == j3) {
                        j2 = j4;
                        break;
                    }
                    boolean z2 = this.o;
                    a aVar = (a) gVar.peek();
                    boolean z3 = aVar == null;
                    long j5 = j4;
                    if (b(z2, z3, jVar, gVar, z)) {
                        return;
                    }
                    if (z3) {
                        j2 = j5;
                        break;
                    }
                    gVar.poll();
                    Object[] objArr = (Object[]) gVar.poll();
                    if (objArr == null) {
                        this.n = true;
                        a(gVar);
                        jVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        jVar.onNext(this.f26273h.call(objArr));
                        aVar.c(1L);
                        j4 = j5 + 1;
                    } catch (Throwable th) {
                        this.n = true;
                        a(gVar);
                        jVar.onError(th);
                        return;
                    }
                }
                if (j2 != 0 && j3 != Long.MAX_VALUE) {
                    rx.n.a.a.c(atomicLong, j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void e(Throwable th) {
            Throwable th2;
            Throwable compositeException;
            AtomicReference<Throwable> atomicReference = this.q;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    compositeException = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                    arrayList.add(th);
                    compositeException = new CompositeException(arrayList);
                } else {
                    compositeException = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, compositeException));
        }

        public void f(rx.e<? extends T>[] eVarArr) {
            a<T, R>[] aVarArr = this.f26274i;
            int length = aVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                aVarArr[i2] = new a<>(this, i2);
            }
            lazySet(0);
            this.f26272g.add(this);
            this.f26272g.setProducer(this);
            for (int i3 = 0; i3 < length && !this.n; i3++) {
                eVarArr[i3].E0(aVarArr[i3]);
            }
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.n;
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j2);
            }
            if (j2 != 0) {
                rx.n.a.a.b(this.p, j2);
                d();
            }
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.n) {
                return;
            }
            this.n = true;
            if (getAndIncrement() == 0) {
                a(this.l);
            }
        }
    }

    public j(Iterable<? extends rx.e<? extends T>> iterable, rx.m.h<? extends R> hVar) {
        this(null, iterable, hVar, rx.n.e.h.f26744f, false);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        int length;
        int i2;
        rx.e<? extends T>[] eVarArr = this.f26263f;
        if (eVarArr == null) {
            Iterable<? extends rx.e<? extends T>> iterable = this.f26264g;
            if (iterable instanceof List) {
                List list = (List) iterable;
                eVarArr = (rx.e[]) list.toArray(new rx.e[list.size()]);
                length = eVarArr.length;
            } else {
                rx.e<? extends T>[] eVarArr2 = new rx.e[8];
                int i3 = 0;
                for (rx.e<? extends T> eVar : iterable) {
                    if (i3 == eVarArr2.length) {
                        rx.e<? extends T>[] eVarArr3 = new rx.e[(i3 >> 2) + i3];
                        System.arraycopy(eVarArr2, 0, eVarArr3, 0, i3);
                        eVarArr2 = eVarArr3;
                    }
                    eVarArr2[i3] = eVar;
                    i3++;
                }
                eVarArr = eVarArr2;
                i2 = i3;
            }
            if (i2 == 0) {
                jVar.onCompleted();
            } else {
                new b(jVar, this.f26265h, i2, this.f26266i, this.f26267j).f(eVarArr);
            }
        }
        length = eVarArr.length;
        i2 = length;
        if (i2 == 0) {
            jVar.onCompleted();
        } else {
            new b(jVar, this.f26265h, i2, this.f26266i, this.f26267j).f(eVarArr);
        }
    }

    public j(rx.e<? extends T>[] eVarArr, Iterable<? extends rx.e<? extends T>> iterable, rx.m.h<? extends R> hVar, int i2, boolean z) {
        this.f26263f = eVarArr;
        this.f26264g = iterable;
        this.f26265h = hVar;
        this.f26266i = i2;
        this.f26267j = z;
    }
}
