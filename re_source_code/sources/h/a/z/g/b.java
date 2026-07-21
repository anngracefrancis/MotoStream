package h.a.z.g;

import h.a.r;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ComputationScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final C0300b f21642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final h f21643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f21644d = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final c f21645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ThreadFactory f21646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<C0300b> f21647g;

    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class a extends r.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final h.a.z.a.e f21648f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final h.a.x.b f21649g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final h.a.z.a.e f21650h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final c f21651i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f21652j;

        a(c cVar) {
            this.f21651i = cVar;
            h.a.z.a.e eVar = new h.a.z.a.e();
            this.f21648f = eVar;
            h.a.x.b bVar = new h.a.x.b();
            this.f21649g = bVar;
            h.a.z.a.e eVar2 = new h.a.z.a.e();
            this.f21650h = eVar2;
            eVar2.b(eVar);
            eVar2.b(bVar);
        }

        @Override // h.a.r.b
        public h.a.x.c b(Runnable runnable) {
            return this.f21652j ? h.a.z.a.d.INSTANCE : this.f21651i.d(runnable, 0L, TimeUnit.MILLISECONDS, this.f21648f);
        }

        @Override // h.a.r.b
        public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
            return this.f21652j ? h.a.z.a.d.INSTANCE : this.f21651i.d(runnable, j2, timeUnit, this.f21649g);
        }

        @Override // h.a.x.c
        public void k() {
            if (this.f21652j) {
                return;
            }
            this.f21652j = true;
            this.f21650h.k();
        }

        @Override // h.a.x.c
        public boolean q() {
            return this.f21652j;
        }
    }

    /* JADX INFO: renamed from: h.a.z.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class C0300b {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f21653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f21654c;

        C0300b(int i2, ThreadFactory threadFactory) {
            this.a = i2;
            this.f21653b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f21653b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.a;
            if (i2 == 0) {
                return b.f21645e;
            }
            c[] cVarArr = this.f21653b;
            long j2 = this.f21654c;
            this.f21654c = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (c cVar : this.f21653b) {
                cVar.k();
            }
        }
    }

    /* JADX INFO: compiled from: ComputationScheduler.java */
    static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new h("RxComputationShutdown"));
        f21645e = cVar;
        cVar.k();
        h hVar = new h("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f21643c = hVar;
        C0300b c0300b = new C0300b(0, hVar);
        f21642b = c0300b;
        c0300b.b();
    }

    public b() {
        this(f21643c);
    }

    static int d(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    @Override // h.a.r
    public r.b a() {
        return new a(this.f21647g.get().a());
    }

    @Override // h.a.r
    public h.a.x.c c(Runnable runnable, long j2, TimeUnit timeUnit) {
        return this.f21647g.get().a().e(runnable, j2, timeUnit);
    }

    public void e() {
        C0300b c0300b = new C0300b(f21644d, this.f21646f);
        if (this.f21647g.compareAndSet(f21642b, c0300b)) {
            return;
        }
        c0300b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f21646f = threadFactory;
        this.f21647g = new AtomicReference<>(f21642b);
        e();
    }
}
