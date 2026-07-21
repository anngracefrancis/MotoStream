package com.bumptech.glide.load.engine.b0;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f9079f = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile int f9080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ExecutorService f9081h;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideExecutor.java */
    private static final class ThreadFactoryC0126a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f9082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final b f9083g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f9084h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9085i;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0127a extends Thread {
            C0127a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (ThreadFactoryC0126a.this.f9084h) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    ThreadFactoryC0126a.this.f9083g.a(th);
                }
            }
        }

        ThreadFactoryC0126a(String str, b bVar, boolean z) {
            this.f9082f = str;
            this.f9083g = bVar;
            this.f9084h = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            C0127a c0127a;
            c0127a = new C0127a(runnable, "glide-" + this.f9082f + "-thread-" + this.f9085i);
            this.f9085i = this.f9085i + 1;
            return c0127a;
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface b {
        public static final b a = new C0128a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f9087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f9088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f9089d;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b0.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0128a implements b {
            C0128a() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.b
            public void a(Throwable th) {
            }
        }

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b0.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0129b implements b {
            C0129b() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.b
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* JADX INFO: compiled from: GlideExecutor.java */
        class c implements b {
            c() {
            }

            @Override // com.bumptech.glide.load.engine.b0.a.b
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            C0129b c0129b = new C0129b();
            f9087b = c0129b;
            f9088c = new c();
            f9089d = c0129b;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f9081h = executorService;
    }

    public static int a() {
        if (f9080g == 0) {
            f9080g = Math.min(4, com.bumptech.glide.load.engine.b0.b.a());
        }
        return f9080g;
    }

    public static a b() {
        return c(a() >= 4 ? 2 : 1, b.f9089d);
    }

    public static a c(int i2, b bVar) {
        return new a(new ThreadPoolExecutor(0, i2, f9079f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0126a("animation", bVar, true)));
    }

    public static a d() {
        return e(1, "disk-cache", b.f9089d);
    }

    public static a e(int i2, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0126a(str, bVar, true)));
    }

    public static a f() {
        return g(a(), "source", b.f9089d);
    }

    public static a g(int i2, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i2, i2, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0126a(str, bVar, false)));
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f9079f, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0126a("source-unlimited", b.f9089d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f9081h.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f9081h.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f9081h.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f9081h.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f9081h.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f9081h.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f9081h.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f9081h.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f9081h.submit(runnable);
    }

    public String toString() {
        return this.f9081h.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f9081h.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f9081h.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f9081h.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f9081h.submit(callable);
    }
}
