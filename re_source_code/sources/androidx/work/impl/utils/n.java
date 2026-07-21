package androidx.work.impl.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: WorkTimer.java */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private static final String a = androidx.work.n.f("WorkTimer");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadFactory f2608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f2609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map<String, c> f2610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Map<String, b> f2611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Object f2612f;

    /* JADX INFO: compiled from: WorkTimer.java */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2613f = 0;

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
            threadNewThread.setName("WorkManager-WorkTimer-thread-" + this.f2613f);
            this.f2613f = this.f2613f + 1;
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: WorkTimer.java */
    public interface b {
        void a(String str);
    }

    /* JADX INFO: compiled from: WorkTimer.java */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final n f2615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f2616g;

        c(n nVar, String str) {
            this.f2615f = nVar;
            this.f2616g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f2615f.f2612f) {
                if (this.f2615f.f2610d.remove(this.f2616g) != null) {
                    b bVarRemove = this.f2615f.f2611e.remove(this.f2616g);
                    if (bVarRemove != null) {
                        bVarRemove.a(this.f2616g);
                    }
                } else {
                    androidx.work.n.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f2616g), new Throwable[0]);
                }
            }
        }
    }

    public n() {
        a aVar = new a();
        this.f2608b = aVar;
        this.f2610d = new HashMap();
        this.f2611e = new HashMap();
        this.f2612f = new Object();
        this.f2609c = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (this.f2609c.isShutdown()) {
            return;
        }
        this.f2609c.shutdownNow();
    }

    public void b(String str, long j2, b bVar) {
        synchronized (this.f2612f) {
            androidx.work.n.c().a(a, String.format("Starting timer for %s", str), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.f2610d.put(str, cVar);
            this.f2611e.put(str, bVar);
            this.f2609c.schedule(cVar, j2, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.f2612f) {
            if (this.f2610d.remove(str) != null) {
                androidx.work.n.c().a(a, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f2611e.remove(str);
            }
        }
    }
}
