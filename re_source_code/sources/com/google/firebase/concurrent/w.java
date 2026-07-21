package com.google.firebase.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: DelegatingScheduledExecutorService.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements ScheduledExecutorService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ExecutorService f18970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ScheduledExecutorService f18971g;

    w(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f18970f = executorService;
        this.f18971g = scheduledExecutorService;
    }

    static /* synthetic */ void a(Runnable runnable, x.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e2) {
            bVar.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(final Runnable runnable, final x.b bVar) {
        this.f18970f.execute(new Runnable() { // from class: com.google.firebase.concurrent.c
            @Override // java.lang.Runnable
            public final void run() {
                w.a(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ScheduledFuture e(final Runnable runnable, long j2, TimeUnit timeUnit, final x.b bVar) {
        return this.f18971g.schedule(new Runnable() { // from class: com.google.firebase.concurrent.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f18936f.c(runnable, bVar);
            }
        }, j2, timeUnit);
    }

    static /* synthetic */ void f(Callable callable, x.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e2) {
            bVar.a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Future h(final Callable callable, final x.b bVar) throws Exception {
        return this.f18970f.submit(new Runnable() { // from class: com.google.firebase.concurrent.m
            @Override // java.lang.Runnable
            public final void run() {
                w.f(callable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ScheduledFuture j(final Callable callable, long j2, TimeUnit timeUnit, final x.b bVar) {
        return this.f18971g.schedule(new Callable() { // from class: com.google.firebase.concurrent.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f18939f.h(callable, bVar);
            }
        }, j2, timeUnit);
    }

    static /* synthetic */ void k(Runnable runnable, x.b bVar) throws Exception {
        try {
            runnable.run();
        } catch (Exception e2) {
            bVar.a(e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(final Runnable runnable, final x.b bVar) {
        this.f18970f.execute(new Runnable() { // from class: com.google.firebase.concurrent.i
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                w.k(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ScheduledFuture o(final Runnable runnable, long j2, long j3, TimeUnit timeUnit, final x.b bVar) {
        return this.f18971g.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.concurrent.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f18946f.m(runnable, bVar);
            }
        }, j2, j3, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(final Runnable runnable, final x.b bVar) {
        this.f18970f.execute(new Runnable() { // from class: com.google.firebase.concurrent.k
            @Override // java.lang.Runnable
            public final void run() {
                w.t(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ ScheduledFuture s(final Runnable runnable, long j2, long j3, TimeUnit timeUnit, final x.b bVar) {
        return this.f18971g.scheduleWithFixedDelay(new Runnable() { // from class: com.google.firebase.concurrent.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f18960f.q(runnable, bVar);
            }
        }, j2, j3, timeUnit);
    }

    static /* synthetic */ void t(Runnable runnable, x.b bVar) {
        try {
            runnable.run();
        } catch (Exception e2) {
            bVar.a(e2);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f18970f.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f18970f.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f18970f.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f18970f.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f18970f.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f18970f.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(final Runnable runnable, final long j2, final TimeUnit timeUnit) {
        return new x(new x.c() { // from class: com.google.firebase.concurrent.b
            @Override // com.google.firebase.concurrent.x.c
            public final ScheduledFuture a(x.b bVar) {
                return this.a.e(runnable, j2, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(final Runnable runnable, final long j2, final long j3, final TimeUnit timeUnit) {
        return new x(new x.c() { // from class: com.google.firebase.concurrent.f
            @Override // com.google.firebase.concurrent.x.c
            public final ScheduledFuture a(x.b bVar) {
                return this.a.o(runnable, j2, j3, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final long j2, final long j3, final TimeUnit timeUnit) {
        return new x(new x.c() { // from class: com.google.firebase.concurrent.j
            @Override // com.google.firebase.concurrent.x.c
            public final ScheduledFuture a(x.b bVar) {
                return this.a.s(runnable, j2, j3, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f18970f.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f18970f.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f18970f.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(final Callable<V> callable, final long j2, final TimeUnit timeUnit) {
        return new x(new x.c() { // from class: com.google.firebase.concurrent.h
            @Override // com.google.firebase.concurrent.x.c
            public final ScheduledFuture a(x.b bVar) {
                return this.a.j(callable, j2, timeUnit, bVar);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f18970f.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f18970f.submit(runnable);
    }
}
