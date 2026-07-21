package h.a.z.g;

import h.a.r;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: IoScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final h f21676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final h f21677c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final c f21680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final a f21681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final ThreadFactory f21682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicReference<a> f21683i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TimeUnit f21679e = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21678d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f21684f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f21685g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.x.b f21686h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ScheduledExecutorService f21687i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Future<?> f21688j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final ThreadFactory f21689k;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j2) : 0L;
            this.f21684f = nanos;
            this.f21685g = new ConcurrentLinkedQueue<>();
            this.f21686h = new h.a.x.b();
            this.f21689k = threadFactory;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, e.f21677c);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f21687i = scheduledExecutorServiceNewScheduledThreadPool;
            this.f21688j = scheduledFutureScheduleWithFixedDelay;
        }

        void a() {
            if (this.f21685g.isEmpty()) {
                return;
            }
            long jC = c();
            for (c cVar : this.f21685g) {
                if (cVar.g() > jC) {
                    return;
                }
                if (this.f21685g.remove(cVar)) {
                    this.f21686h.a(cVar);
                }
            }
        }

        c b() {
            if (this.f21686h.q()) {
                return e.f21680f;
            }
            while (!this.f21685g.isEmpty()) {
                c cVarPoll = this.f21685g.poll();
                if (cVarPoll != null) {
                    return cVarPoll;
                }
            }
            c cVar = new c(this.f21689k);
            this.f21686h.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.h(c() + this.f21684f);
            this.f21685g.offer(cVar);
        }

        void e() {
            this.f21686h.k();
            Future<?> future = this.f21688j;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f21687i;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class b extends r.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final a f21691g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final c f21692h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f21693i = new AtomicBoolean();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final h.a.x.b f21690f = new h.a.x.b();

        b(a aVar) {
            this.f21691g = aVar;
            this.f21692h = aVar.b();
        }

        @Override // h.a.r.b
        public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
            return this.f21690f.q() ? h.a.z.a.d.INSTANCE : this.f21692h.d(runnable, j2, timeUnit, this.f21690f);
        }

        @Override // h.a.x.c
        public void k() {
            if (this.f21693i.compareAndSet(false, true)) {
                this.f21690f.k();
                this.f21691g.d(this.f21692h);
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21693i.get();
        }
    }

    /* JADX INFO: compiled from: IoScheduler.java */
    static final class c extends g {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f21694h;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f21694h = 0L;
        }

        public long g() {
            return this.f21694h;
        }

        public void h(long j2) {
            this.f21694h = j2;
        }
    }

    static {
        c cVar = new c(new h("RxCachedThreadSchedulerShutdown"));
        f21680f = cVar;
        cVar.k();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        h hVar = new h("RxCachedThreadScheduler", iMax);
        f21676b = hVar;
        f21677c = new h("RxCachedWorkerPoolEvictor", iMax);
        a aVar = new a(0L, null, hVar);
        f21681g = aVar;
        aVar.e();
    }

    public e() {
        this(f21676b);
    }

    @Override // h.a.r
    public r.b a() {
        return new b(this.f21683i.get());
    }

    public void d() {
        a aVar = new a(f21678d, f21679e, this.f21682h);
        if (this.f21683i.compareAndSet(f21681g, aVar)) {
            return;
        }
        aVar.e();
    }

    public e(ThreadFactory threadFactory) {
        this.f21682h = threadFactory;
        this.f21683i = new AtomicReference<>(f21681g);
        d();
    }
}
