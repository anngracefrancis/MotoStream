package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbuz<T> {
    public T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f14744b;

    public zzbuz(T t, Executor executor) {
        this.a = t;
        this.f14744b = executor;
    }

    public static <T> zzbuz<T> a(T t, Executor executor) {
        return new zzbuz<>(t, executor);
    }
}
