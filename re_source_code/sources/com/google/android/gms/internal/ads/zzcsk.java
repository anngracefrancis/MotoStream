package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzcuz;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsk<S extends zzcuz> implements zzcva<S> {
    private final AtomicReference<ao<S>> a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f15604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcva<S> f15605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f15606d;

    public zzcsk(zzcva<S> zzcvaVar, long j2, Clock clock) {
        this.f15604b = clock;
        this.f15605c = zzcvaVar;
        this.f15606d = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<S> b() {
        ao<S> aoVar = this.a.get();
        if (aoVar == null || aoVar.a()) {
            aoVar = new ao<>(this.f15605c.b(), this.f15606d, this.f15604b);
            this.a.set(aoVar);
        }
        return aoVar.a;
    }
}
