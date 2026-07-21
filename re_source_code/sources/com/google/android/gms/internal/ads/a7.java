package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class a7<T> implements zzbbh<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Throwable f12228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c7 f12229g;

    a7(Throwable th) {
        this.f12228f = th;
        c7 c7Var = new c7();
        this.f12229g = c7Var;
        c7Var.b();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final T get() throws ExecutionException {
        throw new ExecutionException(this.f12228f);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void k(Runnable runnable, Executor executor) {
        this.f12229g.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final T get(long j2, TimeUnit timeUnit) throws ExecutionException {
        throw new ExecutionException(this.f12228f);
    }
}
