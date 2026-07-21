package rx.n.c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CachedThreadScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends rx.h implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f26616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TimeUnit f26617g = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final c f26618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final C0454a f26619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final ThreadFactory f26620j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final AtomicReference<C0454a> f26621k = new AtomicReference<>(f26619i);

    /* JADX INFO: renamed from: rx.n.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    static final class C0454a {
        private final ThreadFactory a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f26622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f26623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final rx.t.b f26624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ScheduledExecutorService f26625e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Future<?> f26626f;

        /* JADX INFO: renamed from: rx.n.c.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        class ThreadFactoryC0455a implements ThreadFactory {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ ThreadFactory f26627f;

            ThreadFactoryC0455a(ThreadFactory threadFactory) {
                this.f26627f = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread threadNewThread = this.f26627f.newThread(runnable);
                threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
                return threadNewThread;
            }
        }

        /* JADX INFO: renamed from: rx.n.c.a$a$b */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0454a.this.a();
            }
        }

        C0454a(ThreadFactory threadFactory, long j2, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f26622b = nanos;
            this.f26623c = new ConcurrentLinkedQueue<>();
            this.f26624d = new rx.t.b();
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactoryC0455a(threadFactory));
                h.m(scheduledExecutorServiceNewScheduledThreadPool);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f26625e = scheduledExecutorServiceNewScheduledThreadPool;
            this.f26626f = scheduledFutureScheduleWithFixedDelay;
        }

        void a() {
            if (this.f26623c.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.f26623c) {
                if (cVar.n() > jC) {
                    return;
                }
                if (this.f26623c.remove(cVar)) {
                    this.f26624d.d(cVar);
                }
            }
        }

        c b() {
            if (this.f26624d.isUnsubscribed()) {
                return a.f26618h;
            }
            while (!this.f26623c.isEmpty()) {
                c cVarPoll = this.f26623c.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.a);
            this.f26624d.a(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.o(c() + this.f26622b);
            this.f26623c.offer(cVar);
        }

        void e() {
            try {
                Future<?> future = this.f26626f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f26625e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f26624d.unsubscribe();
            }
        }
    }

    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    static final class b extends rx.h.a implements rx.m.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final C0454a f26631g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final c f26632h;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.t.b f26630f = new rx.t.b();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f26633i = new AtomicBoolean();

        /* JADX INFO: renamed from: rx.n.c.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CachedThreadScheduler.java */
        class C0456a implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.m.a f26634f;

            C0456a(rx.m.a aVar) {
                this.f26634f = aVar;
            }

            @Override // rx.m.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f26634f.call();
            }
        }

        b(C0454a c0454a) {
            this.f26631g = c0454a;
            this.f26632h = c0454a.b();
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            return d(aVar, 0L, null);
        }

        @Override // rx.m.a
        public void call() {
            this.f26631g.d(this.f26632h);
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f26630f.isUnsubscribed()) {
                return rx.t.e.c();
            }
            j jVarJ = this.f26632h.j(new C0456a(aVar), j2, timeUnit);
            this.f26630f.a(jVarJ);
            jVarJ.c(this.f26630f);
            return jVarJ;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26630f.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (this.f26633i.compareAndSet(false, true)) {
                this.f26632h.c(this);
            }
            this.f26630f.unsubscribe();
        }
    }

    /* JADX INFO: compiled from: CachedThreadScheduler.java */
    static final class c extends h {
        private long n;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.n = 0L;
        }

        public long n() {
            return this.n;
        }

        public void o(long j2) {
            this.n = j2;
        }
    }

    static {
        c cVar = new c(rx.n.e.i.f26748f);
        f26618h = cVar;
        cVar.unsubscribe();
        C0454a c0454a = new C0454a(null, 0L, null);
        f26619i = c0454a;
        c0454a.e();
        f26616f = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f26620j = threadFactory;
        start();
    }

    @Override // rx.h
    public rx.h.a createWorker() {
        return new b(this.f26621k.get());
    }

    @Override // rx.n.c.k
    public void shutdown() {
        C0454a c0454a;
        C0454a c0454a2;
        do {
            c0454a = this.f26621k.get();
            c0454a2 = f26619i;
            if (c0454a == c0454a2) {
                return;
            }
        } while (!this.f26621k.compareAndSet(c0454a, c0454a2));
        c0454a.e();
    }

    @Override // rx.n.c.k
    public void start() {
        C0454a c0454a = new C0454a(this.f26620j, f26616f, f26617g);
        if (this.f26621k.compareAndSet(f26619i, c0454a)) {
            return;
        }
        c0454a.e();
    }
}
