package rx.n.a;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r<T, R> implements rx.e.a<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<? extends T> f26436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final rx.m.e<? super T, ? extends Iterable<? extends R>> f26437g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f26438h;

    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    class a implements rx.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f26439f;

        a(b bVar) {
            this.f26439f = bVar;
        }

        @Override // rx.g
        public void request(long j2) {
            this.f26439f.e(j2);
        }
    }

    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    static final class b<T, R> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super R> f26441f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends Iterable<? extends R>> f26442g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f26443h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Queue<Object> f26444i;
        volatile boolean m;
        long n;
        Iterator<? extends R> o;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference<Throwable> f26445j = new AtomicReference<>();
        final AtomicInteger l = new AtomicInteger();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicLong f26446k = new AtomicLong();

        public b(rx.j<? super R> jVar, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar, int i2) {
            this.f26441f = jVar;
            this.f26442g = eVar;
            if (i2 == Integer.MAX_VALUE) {
                this.f26443h = Long.MAX_VALUE;
                this.f26444i = new rx.n.e.n.g(rx.n.e.h.f26744f);
            } else {
                this.f26443h = i2 - (i2 >> 2);
                if (rx.n.e.o.z.b()) {
                    this.f26444i = new rx.n.e.o.s(i2);
                } else {
                    this.f26444i = new rx.n.e.n.e(i2);
                }
            }
            request(i2);
        }

        boolean c(boolean z, boolean z2, rx.j<?> jVar, Queue<?> queue) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                this.o = null;
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.f26445j.get() == null) {
                if (!z2) {
                    return false;
                }
                jVar.onCompleted();
                return true;
            }
            Throwable thQ = rx.n.e.e.q(this.f26445j);
            unsubscribe();
            queue.clear();
            this.o = null;
            jVar.onError(thQ);
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0063  */
        /* JADX WARN: Code duplicated, block: B:28:0x0066  */
        /* JADX WARN: Code duplicated, block: B:31:0x0072  */
        /* JADX WARN: Code duplicated, block: B:38:0x008b  */
        /* JADX WARN: Code duplicated, block: B:49:0x00af  */
        /* JADX WARN: Code duplicated, block: B:58:0x00c5  */
        /* JADX WARN: Code duplicated, block: B:64:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:72:0x007a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:73:0x008a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:74:0x00c0 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:75:0x00cc A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:76:0x00d8 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:77:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:78:0x00cf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:81:0x0010 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:82:0x0092 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:? A[LOOP:1: B:29:0x006d->B:84:?, LOOP_END, SYNTHETIC] */
        void d() {
            int i2;
            long j2;
            long j3;
            boolean z;
            if (this.l.getAndIncrement() != 0) {
                return;
            }
            rx.j<? super R> jVar = this.f26441f;
            Queue<?> queue = this.f26444i;
            int iAddAndGet = 1;
            while (true) {
                Iterator<? extends R> it = this.o;
                boolean z2 = false;
                if (it == null) {
                    boolean z3 = this.m;
                    Object objPoll = queue.poll();
                    boolean z4 = objPoll == null;
                    if (c(z3, z4, jVar, queue)) {
                        return;
                    }
                    if (z4) {
                        i2 = iAddAndGet;
                    } else {
                        long j4 = this.n + 1;
                        i2 = iAddAndGet;
                        if (j4 == this.f26443h) {
                            this.n = 0L;
                            request(j4);
                        } else {
                            this.n = j4;
                        }
                        try {
                            it = this.f26442g.call((Object) h.e(objPoll)).iterator();
                            if (it.hasNext()) {
                                this.o = it;
                            }
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            onError(th);
                        }
                    }
                    if (it != null) {
                        j2 = this.f26446k.get();
                        j3 = 0;
                        while (j3 != j2) {
                            if (c(this.m, false, jVar, queue)) {
                                return;
                            }
                            try {
                                jVar.onNext(it.next());
                                if (c(this.m, false, jVar, queue)) {
                                    return;
                                }
                                j3++;
                                try {
                                    if (!it.hasNext()) {
                                        this.o = null;
                                        it = null;
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    rx.exceptions.a.e(th2);
                                    this.o = null;
                                    onError(th2);
                                }
                            } catch (Throwable th3) {
                                rx.exceptions.a.e(th3);
                                this.o = null;
                                onError(th3);
                            }
                        }
                        if (j3 == j2) {
                            z = this.m;
                            if (queue.isEmpty() && it == null) {
                                z2 = true;
                            }
                            if (c(z, z2, jVar, queue)) {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            rx.n.a.a.c(this.f26446k, j3);
                        }
                        if (it == null) {
                        }
                    }
                    iAddAndGet = this.l.addAndGet(-i2);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    i2 = iAddAndGet;
                    if (it != null) {
                        j2 = this.f26446k.get();
                        j3 = 0;
                        while (j3 != j2) {
                            if (c(this.m, false, jVar, queue)) {
                                return;
                            }
                            jVar.onNext(it.next());
                            if (c(this.m, false, jVar, queue)) {
                                return;
                            }
                            j3++;
                            if (!it.hasNext()) {
                                this.o = null;
                                it = null;
                                break;
                            }
                        }
                        if (j3 == j2) {
                            z = this.m;
                            if (queue.isEmpty()) {
                                z2 = true;
                            }
                            if (c(z, z2, jVar, queue)) {
                                return;
                            }
                        }
                        if (j3 != 0) {
                            rx.n.a.a.c(this.f26446k, j3);
                        }
                        if (it == null) {
                        }
                    }
                    iAddAndGet = this.l.addAndGet(-i2);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
                iAddAndGet = i2;
            }
        }

        void e(long j2) {
            if (j2 > 0) {
                rx.n.a.a.b(this.f26446k, j2);
                d();
            } else {
                if (j2 >= 0) {
                    return;
                }
                throw new IllegalStateException("n >= 0 required but it was " + j2);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.m = true;
            d();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!rx.n.e.e.g(this.f26445j, th)) {
                rx.q.c.j(th);
            } else {
                this.m = true;
                d();
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26444i.offer(h.g(t))) {
                d();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }
    }

    /* JADX INFO: compiled from: OnSubscribeFlattenIterable.java */
    static final class c<T, R> implements rx.e.a<R> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final T f26447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.m.e<? super T, ? extends Iterable<? extends R>> f26448g;

        public c(T t, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar) {
            this.f26447f = t;
            this.f26448g = eVar;
        }

        @Override // rx.m.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super R> jVar) {
            try {
                Iterator<? extends R> it = this.f26448g.call(this.f26447f).iterator();
                if (it.hasNext()) {
                    jVar.setProducer(new u.a(jVar, it));
                } else {
                    jVar.onCompleted();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, jVar, this.f26447f);
            }
        }
    }

    protected r(rx.e<? extends T> eVar, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar2, int i2) {
        this.f26436f = eVar;
        this.f26437g = eVar2;
        this.f26438h = i2;
    }

    public static <T, R> rx.e<R> b(rx.e<? extends T> eVar, rx.m.e<? super T, ? extends Iterable<? extends R>> eVar2, int i2) {
        return eVar instanceof rx.n.e.j ? rx.e.b1(new c(((rx.n.e.j) eVar).h1(), eVar2)) : rx.e.b1(new r(eVar, eVar2, i2));
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super R> jVar) {
        b bVar = new b(jVar, this.f26437g, this.f26438h);
        jVar.add(bVar);
        jVar.setProducer(new a(bVar));
        this.f26436f.c1(bVar);
    }
}
