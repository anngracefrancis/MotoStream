package h.a.z.g;

import h.a.r;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final r f21656b = h.a.b0.a.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f21657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Executor f21658d;

    /* JADX INFO: compiled from: ExecutorScheduler.java */
    final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f21659f;

        a(b bVar) {
            this.f21659f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f21659f;
            bVar.f21662g.a(d.this.b(bVar));
        }
    }

    /* JADX INFO: compiled from: ExecutorScheduler.java */
    static final class b extends AtomicReference<Runnable> implements Runnable, h.a.x.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.z.a.f f21661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.z.a.f f21662g;

        b(Runnable runnable) {
            super(runnable);
            this.f21661f = new h.a.z.a.f();
            this.f21662g = new h.a.z.a.f();
        }

        @Override // h.a.x.c
        public void k() {
            if (getAndSet(null) != null) {
                this.f21661f.k();
                this.f21662g.k();
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    this.f21661f.lazySet(h.a.z.a.c.DISPOSED);
                    h.a.z.a.f fVar = this.f21662g;
                } finally {
                    lazySet(null);
                    this.f21661f.lazySet(h.a.z.a.c.DISPOSED);
                    this.f21662g.lazySet(h.a.z.a.c.DISPOSED);
                }
            }
        }
    }

    /* JADX INFO: compiled from: ExecutorScheduler.java */
    public static final class c extends r.b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f21663f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Executor f21664g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f21666i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicInteger f21667j = new AtomicInteger();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final h.a.x.b f21668k = new h.a.x.b();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final h.a.z.f.a<Runnable> f21665h = new h.a.z.f.a<>();

        /* JADX INFO: compiled from: ExecutorScheduler.java */
        static final class a extends AtomicBoolean implements Runnable, h.a.x.c {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final Runnable f21669f;

            a(Runnable runnable) {
                this.f21669f = runnable;
            }

            @Override // h.a.x.c
            public void k() {
                lazySet(true);
            }

            @Override // h.a.x.c
            public boolean q() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.f21669f.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* JADX INFO: compiled from: ExecutorScheduler.java */
        static final class b extends AtomicInteger implements Runnable, h.a.x.c {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final Runnable f21670f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final h.a.z.a.b f21671g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            volatile Thread f21672h;

            b(Runnable runnable, h.a.z.a.b bVar) {
                this.f21670f = runnable;
                this.f21671g = bVar;
            }

            void a() {
                h.a.z.a.b bVar = this.f21671g;
                if (bVar != null) {
                    bVar.c(this);
                }
            }

            @Override // h.a.x.c
            public void k() {
                while (true) {
                    int i2 = get();
                    if (i2 >= 2) {
                        return;
                    }
                    if (i2 == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.f21672h;
                        if (thread != null) {
                            thread.interrupt();
                            this.f21672h = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            @Override // h.a.x.c
            public boolean q() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.f21672h = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.f21672h = null;
                        return;
                    }
                    try {
                        this.f21670f.run();
                        this.f21672h = null;
                        if (compareAndSet(1, 2)) {
                        }
                    } finally {
                        this.f21672h = null;
                        if (compareAndSet(1, 2)) {
                            a();
                        } else {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        }
                    }
                }
            }
        }

        /* JADX INFO: renamed from: h.a.z.g.d$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ExecutorScheduler.java */
        final class RunnableC0301c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final h.a.z.a.f f21673f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final Runnable f21674g;

            RunnableC0301c(h.a.z.a.f fVar, Runnable runnable) {
                this.f21673f = fVar;
                this.f21674g = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f21673f.a(c.this.b(this.f21674g));
            }
        }

        public c(Executor executor, boolean z) {
            this.f21664g = executor;
            this.f21663f = z;
        }

        @Override // h.a.r.b
        public h.a.x.c b(Runnable runnable) {
            h.a.x.c aVar;
            if (this.f21666i) {
                return h.a.z.a.d.INSTANCE;
            }
            Runnable runnableQ = h.a.a0.a.q(runnable);
            if (this.f21663f) {
                aVar = new b(runnableQ, this.f21668k);
                this.f21668k.b(aVar);
            } else {
                aVar = new a(runnableQ);
            }
            this.f21665h.offer(aVar);
            if (this.f21667j.getAndIncrement() == 0) {
                try {
                    this.f21664g.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f21666i = true;
                    this.f21665h.clear();
                    h.a.a0.a.o(e2);
                    return h.a.z.a.d.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // h.a.r.b
        public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (j2 <= 0) {
                return b(runnable);
            }
            if (this.f21666i) {
                return h.a.z.a.d.INSTANCE;
            }
            h.a.z.a.f fVar = new h.a.z.a.f();
            h.a.z.a.f fVar2 = new h.a.z.a.f(fVar);
            j jVar = new j(new RunnableC0301c(fVar2, h.a.a0.a.q(runnable)), this.f21668k);
            this.f21668k.b(jVar);
            Executor executor = this.f21664g;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    jVar.a(((ScheduledExecutorService) executor).schedule((Callable) jVar, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f21666i = true;
                    h.a.a0.a.o(e2);
                    return h.a.z.a.d.INSTANCE;
                }
            } else {
                jVar.a(new h.a.z.g.c(d.f21656b.c(jVar, j2, timeUnit)));
            }
            fVar.a(jVar);
            return fVar2;
        }

        @Override // h.a.x.c
        public void k() {
            if (this.f21666i) {
                return;
            }
            this.f21666i = true;
            this.f21668k.k();
            if (this.f21667j.getAndIncrement() == 0) {
                this.f21665h.clear();
            }
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21666i;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.z.f.a<Runnable> aVar = this.f21665h;
            int iAddAndGet = 1;
            while (!this.f21666i) {
                while (true) {
                    Runnable runnablePoll = aVar.poll();
                    if (runnablePoll == null) {
                        break;
                    }
                    runnablePoll.run();
                    if (this.f21666i) {
                        aVar.clear();
                        return;
                    }
                }
                if (this.f21666i) {
                    aVar.clear();
                    return;
                } else {
                    iAddAndGet = this.f21667j.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            aVar.clear();
        }
    }

    public d(Executor executor, boolean z) {
        this.f21658d = executor;
        this.f21657c = z;
    }

    @Override // h.a.r
    public r.b a() {
        return new c(this.f21658d, this.f21657c);
    }

    @Override // h.a.r
    public h.a.x.c b(Runnable runnable) {
        Runnable runnableQ = h.a.a0.a.q(runnable);
        try {
            if (this.f21658d instanceof ExecutorService) {
                i iVar = new i(runnableQ);
                iVar.a(((ExecutorService) this.f21658d).submit(iVar));
                return iVar;
            }
            if (this.f21657c) {
                c.b bVar = new c.b(runnableQ, null);
                this.f21658d.execute(bVar);
                return bVar;
            }
            c.a aVar = new c.a(runnableQ);
            this.f21658d.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e2) {
            h.a.a0.a.o(e2);
            return h.a.z.a.d.INSTANCE;
        }
    }

    @Override // h.a.r
    public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable runnableQ = h.a.a0.a.q(runnable);
        if (!(this.f21658d instanceof ScheduledExecutorService)) {
            b bVar = new b(runnableQ);
            bVar.f21661f.a(f21656b.c(new a(bVar), j2, timeUnit));
            return bVar;
        }
        try {
            i iVar = new i(runnableQ);
            iVar.a(((ScheduledExecutorService) this.f21658d).schedule(iVar, j2, timeUnit));
            return iVar;
        } catch (RejectedExecutionException e2) {
            h.a.a0.a.o(e2);
            return h.a.z.a.d.INSTANCE;
        }
    }
}
