package rx.n.a;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class s0<T> implements rx.e.b<T, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Long f26470f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final rx.m.a f26471g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final rx.a.d f26472h = rx.a.f26001b;

    /* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
    static final class a<T> extends rx.j<T> implements rx.n.e.c.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final AtomicLong f26474g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final rx.j<? super T> f26475h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final rx.n.e.c f26477j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final rx.m.a f26478k;
        private final rx.a.d l;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ConcurrentLinkedQueue<Object> f26473f = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final AtomicBoolean f26476i = new AtomicBoolean(false);

        public a(rx.j<? super T> jVar, Long l, rx.m.a aVar, rx.a.d dVar) {
            this.f26475h = jVar;
            this.f26474g = l != null ? new AtomicLong(l.longValue()) : null;
            this.f26478k = aVar;
            this.f26477j = new rx.n.e.c(this);
            this.l = dVar;
        }

        private boolean c() throws Throwable {
            long j2;
            boolean z;
            if (this.f26474g == null) {
                return true;
            }
            do {
                j2 = this.f26474g.get();
                if (j2 <= 0) {
                    try {
                        z = this.l.a() && poll() != null;
                    } catch (MissingBackpressureException e2) {
                        if (this.f26476i.compareAndSet(false, true)) {
                            unsubscribe();
                            this.f26475h.onError(e2);
                        }
                    }
                    rx.m.a aVar = this.f26478k;
                    if (aVar != null) {
                        try {
                            aVar.call();
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            this.f26477j.c(th);
                            return false;
                        }
                    }
                    if (!z) {
                        return false;
                    }
                }
            } while (!this.f26474g.compareAndSet(j2, j2 - 1));
            return true;
        }

        @Override // rx.n.e.c.a
        public boolean a(Object obj) {
            return h.a(this.f26475h, obj);
        }

        @Override // rx.n.e.c.a
        public void b(Throwable th) {
            if (th != null) {
                this.f26475h.onError(th);
            } else {
                this.f26475h.onCompleted();
            }
        }

        protected rx.g d() {
            return this.f26477j;
        }

        @Override // rx.f
        public void onCompleted() throws Throwable {
            if (this.f26476i.get()) {
                return;
            }
            this.f26477j.b();
        }

        @Override // rx.f
        public void onError(Throwable th) throws Throwable {
            if (this.f26476i.get()) {
                return;
            }
            this.f26477j.c(th);
        }

        @Override // rx.f
        public void onNext(T t) throws Throwable {
            if (c()) {
                this.f26473f.offer(h.g(t));
                this.f26477j.a();
            }
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.n.e.c.a
        public Object peek() {
            return this.f26473f.peek();
        }

        @Override // rx.n.e.c.a
        public Object poll() {
            Object objPoll = this.f26473f.poll();
            AtomicLong atomicLong = this.f26474g;
            if (atomicLong != null && objPoll != null) {
                atomicLong.incrementAndGet();
            }
            return objPoll;
        }
    }

    /* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
    static final class b {
        static final s0<?> a = new s0<>();
    }

    s0() {
    }

    public static <T> s0<T> b() {
        return (s0<T>) b.a;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super T> jVar) {
        a aVar = new a(jVar, this.f26470f, this.f26471g, this.f26472h);
        jVar.add(aVar);
        jVar.setProducer(aVar.d());
        return aVar;
    }
}
