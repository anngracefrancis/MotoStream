package rx.n.a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0<T> implements rx.e.a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<T> f26176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f26177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final TimeUnit f26178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final rx.h f26179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final rx.e<? extends T> f26180j;

    /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    static final class a<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26181f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final rx.n.b.a f26182g;

        a(rx.j<? super T> jVar, rx.n.b.a aVar) {
            this.f26181f = jVar;
            this.f26182g = aVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26181f.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26181f.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26181f.onNext(t);
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26182g.c(gVar);
        }
    }

    /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    static final class b<T> extends rx.j<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final rx.j<? super T> f26183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f26184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final TimeUnit f26185h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final rx.h.a f26186i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final rx.e<? extends T> f26187j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final rx.n.b.a f26188k = new rx.n.b.a();
        final AtomicLong l = new AtomicLong();
        final rx.n.d.a m;
        final rx.n.d.a n;
        long o;

        /* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
        final class a implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final long f26189f;

            a(long j2) {
                this.f26189f = j2;
            }

            @Override // rx.m.a
            public void call() {
                b.this.c(this.f26189f);
            }
        }

        b(rx.j<? super T> jVar, long j2, TimeUnit timeUnit, rx.h.a aVar, rx.e<? extends T> eVar) {
            this.f26183f = jVar;
            this.f26184g = j2;
            this.f26185h = timeUnit;
            this.f26186i = aVar;
            this.f26187j = eVar;
            rx.n.d.a aVar2 = new rx.n.d.a();
            this.m = aVar2;
            this.n = new rx.n.d.a(this);
            add(aVar);
            add(aVar2);
        }

        void c(long j2) {
            if (this.l.compareAndSet(j2, Long.MAX_VALUE)) {
                unsubscribe();
                if (this.f26187j == null) {
                    this.f26183f.onError(new TimeoutException());
                    return;
                }
                long j3 = this.o;
                if (j3 != 0) {
                    this.f26188k.b(j3);
                }
                a aVar = new a(this.f26183f, this.f26188k);
                if (this.n.b(aVar)) {
                    this.f26187j.E0(aVar);
                }
            }
        }

        void d(long j2) {
            this.m.b(this.f26186i.d(new a(j2), this.f26184g, this.f26185h));
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.l.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.m.unsubscribe();
                this.f26183f.onCompleted();
                this.f26186i.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.l.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                rx.q.c.j(th);
                return;
            }
            this.m.unsubscribe();
            this.f26183f.onError(th);
            this.f26186i.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t) {
            long j2 = this.l.get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 + 1;
                if (this.l.compareAndSet(j2, j3)) {
                    rx.k kVar = this.m.get();
                    if (kVar != null) {
                        kVar.unsubscribe();
                    }
                    this.o++;
                    this.f26183f.onNext(t);
                    d(j3);
                }
            }
        }

        @Override // rx.j
        public void setProducer(rx.g gVar) {
            this.f26188k.c(gVar);
        }
    }

    public e0(rx.e<T> eVar, long j2, TimeUnit timeUnit, rx.h hVar, rx.e<? extends T> eVar2) {
        this.f26176f = eVar;
        this.f26177g = j2;
        this.f26178h = timeUnit;
        this.f26179i = hVar;
        this.f26180j = eVar2;
    }

    @Override // rx.m.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super T> jVar) {
        b bVar = new b(jVar, this.f26177g, this.f26178h, this.f26179i.createWorker(), this.f26180j);
        jVar.add(bVar.n);
        jVar.setProducer(bVar.f26188k);
        bVar.d(0L);
        this.f26176f.E0(bVar);
    }
}
