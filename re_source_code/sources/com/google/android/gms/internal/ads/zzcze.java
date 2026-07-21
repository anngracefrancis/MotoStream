package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcze<E, V> implements zzbbh<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final E f15790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f15791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbbh<V> f15792h;

    public zzcze(E e2, String str, zzbbh<V> zzbbhVar) {
        this.f15790f = e2;
        this.f15791g = str;
        this.f15792h = zzbbhVar;
    }

    public final E a() {
        return this.f15790f;
    }

    public final String b() {
        return this.f15791g;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f15792h.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        return this.f15792h.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15792h.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f15792h.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void k(Runnable runnable, Executor executor) {
        this.f15792h.k(runnable, executor);
    }

    public final String toString() {
        String str = this.f15791g;
        int iIdentityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(iIdentityHashCode);
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f15792h.get(j2, timeUnit);
    }
}
