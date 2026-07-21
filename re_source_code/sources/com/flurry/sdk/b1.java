package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final class b1<V> extends FutureTask<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<Callable<V>> f10635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<Runnable> f10636g;

    public b1(Runnable runnable, V v) {
        super(runnable, v);
        this.f10635f = new WeakReference<>(null);
        this.f10636g = new WeakReference<>(runnable);
    }

    public final Runnable a() {
        return this.f10636g.get();
    }
}
