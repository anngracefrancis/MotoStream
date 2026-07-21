package com.google.firebase.crashlytics.internal.n;

import android.annotation.SuppressLint;
import com.google.firebase.crashlytics.internal.h;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ExecutorUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: compiled from: ExecutorUtils.java */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f19036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AtomicLong f19037g;

        /* JADX INFO: renamed from: com.google.firebase.crashlytics.h.n.g0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ExecutorUtils.java */
        class C0206a extends o {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Runnable f19038f;

            C0206a(Runnable runnable) {
                this.f19038f = runnable;
            }

            @Override // com.google.firebase.crashlytics.internal.n.o
            public void a() {
                this.f19038f.run();
            }
        }

        a(String str, AtomicLong atomicLong) {
            this.f19036f = str;
            this.f19037g = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(new C0206a(runnable));
            threadNewThread.setName(this.f19036f + this.f19037g.getAndIncrement());
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: ExecutorUtils.java */
    class b extends o {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f19040f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ExecutorService f19041g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f19042h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TimeUnit f19043i;

        b(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
            this.f19040f = str;
            this.f19041g = executorService;
            this.f19042h = j2;
            this.f19043i = timeUnit;
        }

        @Override // com.google.firebase.crashlytics.internal.n.o
        public void a() {
            try {
                h.f().b("Executing shutdown hook for " + this.f19040f);
                this.f19041g.shutdown();
                if (this.f19041g.awaitTermination(this.f19042h, this.f19043i)) {
                    return;
                }
                h.f().b(this.f19040f + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f19041g.shutdownNow();
            } catch (InterruptedException unused) {
                h.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f19040f));
                this.f19041g.shutdownNow();
            }
        }
    }

    private static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static void b(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new b(str, executorService, j2, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService executorServiceE = e(d(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, executorServiceE);
        return executorServiceE;
    }

    public static ThreadFactory d(String str) {
        return new a(str, new AtomicLong(1L));
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static ExecutorService e(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
