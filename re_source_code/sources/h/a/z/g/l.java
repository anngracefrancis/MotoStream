package h.a.z.g;

import h.a.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final h f21710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final ScheduledExecutorService f21711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ThreadFactory f21712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f21713e;

    /* JADX INFO: compiled from: SingleScheduler.java */
    static final class a extends r.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ScheduledExecutorService f21714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.x.b f21715g = new h.a.x.b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f21716h;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f21714f = scheduledExecutorService;
        }

        @Override // h.a.r.b
        public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f21716h) {
                return h.a.z.a.d.INSTANCE;
            }
            j jVar = new j(h.a.a0.a.q(runnable), this.f21715g);
            this.f21715g.b(jVar);
            try {
                jVar.a(j2 <= 0 ? this.f21714f.submit((Callable) jVar) : this.f21714f.schedule((Callable) jVar, j2, timeUnit));
                return jVar;
            } catch (RejectedExecutionException e2) {
                k();
                h.a.a0.a.o(e2);
                return h.a.z.a.d.INSTANCE;
            }
        }

        @Override // h.a.x.c
        public void k() {
            if (this.f21716h) {
                return;
            }
            this.f21716h = true;
            this.f21715g.k();
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21716h;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f21711c = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f21710b = new h("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public l() {
        this(f21710b);
    }

    static ScheduledExecutorService d(ThreadFactory threadFactory) {
        return k.a(threadFactory);
    }

    @Override // h.a.r
    public r.b a() {
        return new a(this.f21713e.get());
    }

    @Override // h.a.r
    public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
        i iVar = new i(h.a.a0.a.q(runnable));
        try {
            iVar.a(j2 <= 0 ? this.f21713e.get().submit(iVar) : this.f21713e.get().schedule(iVar, j2, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e2) {
            h.a.a0.a.o(e2);
            return h.a.z.a.d.INSTANCE;
        }
    }

    public l(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f21713e = atomicReference;
        this.f21712d = threadFactory;
        atomicReference.lazySet(d(threadFactory));
    }
}
