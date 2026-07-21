package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@Deprecated
public class zzbbw<T> {
    private final zzbbr<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f14340b;

    public zzbbw() {
        zzbbr<T> zzbbrVar = new zzbbr<>();
        this.a = zzbbrVar;
        this.f14340b = new AtomicInteger(0);
        zzbar.f(zzbbrVar, new i7(this), zzbbm.f14331b);
    }

    @Deprecated
    public final int a() {
        return this.f14340b.get();
    }

    @Deprecated
    public final void b() {
        this.a.c(new Exception());
    }

    @Deprecated
    public final void d(zzbbv<T> zzbbvVar, zzbbt zzbbtVar) {
        zzbar.f(this.a, new j7(this, zzbbvVar, zzbbtVar), zzbbm.f14331b);
    }

    @Deprecated
    public final void e(T t) {
        this.a.a(t);
    }
}
