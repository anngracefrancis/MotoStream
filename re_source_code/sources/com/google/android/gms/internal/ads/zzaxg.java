package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaxg {
    public static final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzbbl f14253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ScheduledExecutorService f14254c;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a = zzbbm.a(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, timeUnit, new SynchronousQueue(), c("Default")));
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10L, timeUnit, new LinkedBlockingQueue(), c("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f14253b = zzbbm.a(threadPoolExecutor);
        f14254c = new ScheduledThreadPoolExecutor(3, c("Schedule"));
    }

    public static <T> zzbbh<T> a(Callable<T> callable) {
        return a.submit(callable);
    }

    public static zzbbh<?> b(Runnable runnable) {
        return a.submit(runnable);
    }

    private static ThreadFactory c(String str) {
        return new d5(str);
    }
}
