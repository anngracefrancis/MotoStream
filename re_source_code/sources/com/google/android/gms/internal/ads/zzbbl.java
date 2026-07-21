package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public interface zzbbl extends ExecutorService {
    zzbbh<?> x(Runnable runnable);

    <T> zzbbh<T> y(Callable<T> callable);
}
