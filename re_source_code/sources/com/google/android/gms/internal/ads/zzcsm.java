package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsm implements zzdti<zzcsk<zzcsg>> {
    private final zzdtu<zzcsh> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Clock> f15607b;

    public zzcsm(zzdtu<zzcsh> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15607b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcsk) zzdto.b(new zzcsk(this.a.get(), 10000L, this.f15607b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
