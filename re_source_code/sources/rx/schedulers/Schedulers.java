package rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.n.c.d;
import rx.n.c.k;
import rx.n.c.n;
import rx.q.c;
import rx.q.f;
import rx.q.g;

/* JADX INFO: loaded from: classes.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f26892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f26893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f26894d;

    private Schedulers() {
        g gVarF = f.c().f();
        h hVarG = gVarF.g();
        if (hVarG != null) {
            this.f26892b = hVarG;
        } else {
            this.f26892b = g.a();
        }
        h hVarI = gVarF.i();
        if (hVarI != null) {
            this.f26893c = hVarI;
        } else {
            this.f26893c = g.c();
        }
        h hVarJ = gVarF.j();
        if (hVarJ != null) {
            this.f26894d = hVarJ;
        } else {
            this.f26894d = g.e();
        }
    }

    private static Schedulers a() {
        while (true) {
            AtomicReference<Schedulers> atomicReference = a;
            Schedulers schedulers = atomicReference.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (atomicReference.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static h computation() {
        return c.f(a().f26892b);
    }

    public static h from(Executor executor) {
        return new rx.n.c.c(executor);
    }

    public static h immediate() {
        return rx.n.c.f.a;
    }

    public static h io() {
        return c.k(a().f26893c);
    }

    public static h newThread() {
        return c.l(a().f26894d);
    }

    public static void reset() {
        Schedulers andSet = a.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers schedulersA = a();
        schedulersA.b();
        synchronized (schedulersA) {
            d.f26664h.shutdown();
        }
    }

    public static void start() {
        Schedulers schedulersA = a();
        schedulersA.c();
        synchronized (schedulersA) {
            d.f26664h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static h trampoline() {
        return n.a;
    }

    synchronized void b() {
        Object obj = this.f26892b;
        if (obj instanceof k) {
            ((k) obj).shutdown();
        }
        Object obj2 = this.f26893c;
        if (obj2 instanceof k) {
            ((k) obj2).shutdown();
        }
        Object obj3 = this.f26894d;
        if (obj3 instanceof k) {
            ((k) obj3).shutdown();
        }
    }

    synchronized void c() {
        Object obj = this.f26892b;
        if (obj instanceof k) {
            ((k) obj).start();
        }
        Object obj2 = this.f26893c;
        if (obj2 instanceof k) {
            ((k) obj2).start();
        }
        Object obj3 = this.f26894d;
        if (obj3 instanceof k) {
            ((k) obj3).start();
        }
    }
}
