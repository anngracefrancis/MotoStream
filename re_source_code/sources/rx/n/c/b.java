package rx.n.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: EventLoopsScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends rx.h implements k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f26636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final c f26637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final C0459b f26638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final ThreadFactory f26639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final AtomicReference<C0459b> f26640j = new AtomicReference<>(f26638h);

    /* JADX INFO: compiled from: EventLoopsScheduler.java */
    static final class a extends rx.h.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final rx.n.e.l f26641f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final rx.t.b f26642g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final rx.n.e.l f26643h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final c f26644i;

        /* JADX INFO: renamed from: rx.n.c.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: EventLoopsScheduler.java */
        class C0457a implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.m.a f26645f;

            C0457a(rx.m.a aVar) {
                this.f26645f = aVar;
            }

            @Override // rx.m.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f26645f.call();
            }
        }

        /* JADX INFO: renamed from: rx.n.c.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: EventLoopsScheduler.java */
        class C0458b implements rx.m.a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ rx.m.a f26647f;

            C0458b(rx.m.a aVar) {
                this.f26647f = aVar;
            }

            @Override // rx.m.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f26647f.call();
            }
        }

        a(c cVar) {
            rx.n.e.l lVar = new rx.n.e.l();
            this.f26641f = lVar;
            rx.t.b bVar = new rx.t.b();
            this.f26642g = bVar;
            this.f26643h = new rx.n.e.l(lVar, bVar);
            this.f26644i = cVar;
        }

        @Override // rx.h.a
        public rx.k c(rx.m.a aVar) {
            return isUnsubscribed() ? rx.t.e.c() : this.f26644i.k(new C0457a(aVar), 0L, null, this.f26641f);
        }

        @Override // rx.h.a
        public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
            return isUnsubscribed() ? rx.t.e.c() : this.f26644i.l(new C0458b(aVar), j2, timeUnit, this.f26642g);
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.f26643h.isUnsubscribed();
        }

        @Override // rx.k
        public void unsubscribe() {
            this.f26643h.unsubscribe();
        }
    }

    /* JADX INFO: renamed from: rx.n.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventLoopsScheduler.java */
    static final class C0459b {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c[] f26649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f26650c;

        C0459b(ThreadFactory threadFactory, int i2) {
            this.a = i2;
            this.f26649b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f26649b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.a;
            if (i2 == 0) {
                return b.f26637g;
            }
            c[] cVarArr = this.f26649b;
            long j2 = this.f26650c;
            this.f26650c = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (c cVar : this.f26649b) {
                cVar.unsubscribe();
            }
        }
    }

    /* JADX INFO: compiled from: EventLoopsScheduler.java */
    static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int iIntValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iIntValue <= 0 || iIntValue > iAvailableProcessors) {
            iIntValue = iAvailableProcessors;
        }
        f26636f = iIntValue;
        c cVar = new c(rx.n.e.i.f26748f);
        f26637g = cVar;
        cVar.unsubscribe();
        f26638h = new C0459b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f26639i = threadFactory;
        start();
    }

    public rx.k a(rx.m.a aVar) {
        return this.f26640j.get().a().j(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // rx.h
    public rx.h.a createWorker() {
        return new a(this.f26640j.get().a());
    }

    @Override // rx.n.c.k
    public void shutdown() {
        C0459b c0459b;
        C0459b c0459b2;
        do {
            c0459b = this.f26640j.get();
            c0459b2 = f26638h;
            if (c0459b == c0459b2) {
                return;
            }
        } while (!this.f26640j.compareAndSet(c0459b, c0459b2));
        c0459b.b();
    }

    @Override // rx.n.c.k
    public void start() {
        C0459b c0459b = new C0459b(this.f26639i, f26636f);
        if (this.f26640j.compareAndSet(f26638h, c0459b)) {
            return;
        }
        c0459b.b();
    }
}
