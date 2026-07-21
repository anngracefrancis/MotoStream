package io.sentry.transport;

import io.sentry.s4;
import io.sentry.w1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: QueuedThreadPoolExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
final class x extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final w1 f22750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final z f22751h;

    /* JADX INFO: compiled from: QueuedThreadPoolExecutor.java */
    static final class a<T> implements Future<T> {
        a() {
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            throw new CancellationException();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j2, TimeUnit timeUnit) {
            throw new CancellationException();
        }
    }

    public x(int i2, int i3, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, w1 w1Var) {
        super(i2, i2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.f22751h = new z();
        this.f22749f = i3;
        this.f22750g = w1Var;
    }

    private boolean a() {
        return this.f22751h.b() < this.f22749f;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        try {
            super.afterExecute(runnable, th);
        } finally {
            this.f22751h.a();
        }
    }

    void b(long j2) {
        try {
            this.f22751h.d(j2, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            this.f22750g.b(s4.ERROR, "Failed to wait till idle", e2);
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (a()) {
            this.f22751h.c();
            return super.submit(runnable);
        }
        this.f22750g.c(s4.WARNING, "Submit cancelled", new Object[0]);
        return new a();
    }
}
