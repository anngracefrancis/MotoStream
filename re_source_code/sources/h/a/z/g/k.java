package h.a.z.g;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SchedulerPoolFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f21708c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f21709d = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SchedulerPoolFactory.java */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(k.f21709d.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    k.f21709d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SchedulerPoolFactory.java */
    static final class b implements h.a.y.f<String, String> {
        b() {
        }

        @Override // h.a.y.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean zB = b(true, "rx2.purge-enabled", true, true, bVar);
        a = zB;
        f21707b = c(zB, "rx2.purge-period-seconds", 1, 1, bVar);
        d();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        e(a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    static boolean b(boolean z, String str, boolean z2, boolean z3, h.a.y.f<String, String> fVar) {
        if (!z) {
            return z3;
        }
        try {
            String strA = fVar.a(str);
            return strA == null ? z2 : "true".equals(strA);
        } catch (Throwable unused) {
            return z2;
        }
    }

    static int c(boolean z, String str, int i2, int i3, h.a.y.f<String, String> fVar) {
        if (!z) {
            return i3;
        }
        try {
            String strA = fVar.a(str);
            return strA == null ? i2 : Integer.parseInt(strA);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public static void d() {
        f(a);
    }

    static void e(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f21709d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void f(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f21708c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new h("RxSchedulerPurge"));
            if (atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f21707b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
