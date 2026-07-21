package io.sentry;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryExecutorService.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class n4 implements b2 {
    private final ScheduledExecutorService a;

    /* JADX INFO: compiled from: SentryExecutorService.java */
    private static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22512f;

        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder();
            sb.append("SentryExecutorServiceThreadFactory-");
            int i2 = this.f22512f;
            this.f22512f = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    n4(ScheduledExecutorService scheduledExecutorService) {
        this.a = scheduledExecutorService;
    }

    @Override // io.sentry.b2
    public void a(long j2) {
        synchronized (this.a) {
            if (!this.a.isShutdown()) {
                this.a.shutdown();
                try {
                    if (!this.a.awaitTermination(j2, TimeUnit.MILLISECONDS)) {
                        this.a.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.a.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // io.sentry.b2
    public Future<?> b(Runnable runnable, long j2) {
        return this.a.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    @Override // io.sentry.b2
    public boolean isClosed() {
        boolean zIsShutdown;
        synchronized (this.a) {
            zIsShutdown = this.a.isShutdown();
        }
        return zIsShutdown;
    }

    @Override // io.sentry.b2
    public Future<?> submit(Runnable runnable) {
        return this.a.submit(runnable);
    }

    public n4() {
        this(Executors.newSingleThreadScheduledExecutor(new b()));
    }
}
