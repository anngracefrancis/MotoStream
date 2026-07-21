package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Configuration.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Executor f2288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a0 f2289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final l f2290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final v f2291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final j f2292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final String f2293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f2294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f2295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f2296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f2297k;
    private final boolean l;

    /* JADX INFO: compiled from: Configuration.java */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f2298f = new AtomicInteger(0);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f2299g;

        a(boolean z) {
            this.f2299g = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, (this.f2299g ? "WM.task-" : "androidx.work-") + this.f2298f.incrementAndGet());
        }
    }

    /* JADX INFO: renamed from: androidx.work.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Configuration.java */
    public static final class C0048b {
        Executor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a0 f2301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        l f2302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Executor f2303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        v f2304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        j f2305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        String f2306g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f2307h = 4;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f2308i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f2309j = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f2310k = 20;

        public b a() {
            return new b(this);
        }

        public C0048b b(int i2) {
            this.f2307h = i2;
            return this;
        }

        public C0048b c(a0 a0Var) {
            this.f2301b = a0Var;
            return this;
        }
    }

    /* JADX INFO: compiled from: Configuration.java */
    public interface c {
        b a();
    }

    b(C0048b c0048b) {
        Executor executor = c0048b.a;
        if (executor == null) {
            this.a = a(false);
        } else {
            this.a = executor;
        }
        Executor executor2 = c0048b.f2303d;
        if (executor2 == null) {
            this.l = true;
            this.f2288b = a(true);
        } else {
            this.l = false;
            this.f2288b = executor2;
        }
        a0 a0Var = c0048b.f2301b;
        if (a0Var == null) {
            this.f2289c = a0.getDefaultWorkerFactory();
        } else {
            this.f2289c = a0Var;
        }
        l lVar = c0048b.f2302c;
        if (lVar == null) {
            this.f2290d = l.c();
        } else {
            this.f2290d = lVar;
        }
        v vVar = c0048b.f2304e;
        if (vVar == null) {
            this.f2291e = new androidx.work.impl.a();
        } else {
            this.f2291e = vVar;
        }
        this.f2294h = c0048b.f2307h;
        this.f2295i = c0048b.f2308i;
        this.f2296j = c0048b.f2309j;
        this.f2297k = c0048b.f2310k;
        this.f2292f = c0048b.f2305f;
        this.f2293g = c0048b.f2306g;
    }

    private Executor a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z));
    }

    private ThreadFactory b(boolean z) {
        return new a(z);
    }

    public String c() {
        return this.f2293g;
    }

    public j d() {
        return this.f2292f;
    }

    public Executor e() {
        return this.a;
    }

    public l f() {
        return this.f2290d;
    }

    public int g() {
        return this.f2296j;
    }

    public int h() {
        return Build.VERSION.SDK_INT == 23 ? this.f2297k / 2 : this.f2297k;
    }

    public int i() {
        return this.f2295i;
    }

    public int j() {
        return this.f2294h;
    }

    public v k() {
        return this.f2291e;
    }

    public Executor l() {
        return this.f2288b;
    }

    public a0 m() {
        return this.f2289c;
    }
}
