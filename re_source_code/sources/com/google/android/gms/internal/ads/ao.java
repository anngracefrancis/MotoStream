package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;

/* JADX INFO: loaded from: classes2.dex */
final class ao<S extends zzcuz> {
    public final zzbbh<S> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f12263c;

    public ao(zzbbh<S> zzbbhVar, long j2, Clock clock) {
        this.a = zzbbhVar;
        this.f12263c = clock;
        this.f12262b = clock.b() + j2;
    }

    public final boolean a() {
        return this.f12262b < this.f12263c.b();
    }
}
