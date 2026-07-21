package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public abstract class zzbak extends AbstractExecutorService implements zzbbl {
    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new e7(runnable, t);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public final zzbbh<?> submit(Runnable runnable) throws RejectedExecutionException {
        return (zzbbh) super.submit(runnable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final <T> zzbbh<T> submit(Callable<T> callable) throws RejectedExecutionException {
        return (zzbbh) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new e7(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (zzbbh) super.submit(runnable, obj);
    }
}
