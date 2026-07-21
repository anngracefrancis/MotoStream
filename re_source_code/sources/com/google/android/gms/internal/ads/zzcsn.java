package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsn implements zzdti<zzcsk<zzcvf>> {
    private final zzdtu<cp> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Clock> f15608b;

    public zzcsn(zzdtu<cp> zzdtuVar, zzdtu<Clock> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15608b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcsk) zzdto.b(new zzcsk(this.a.get(), ((Long) zzyt.e().c(zzacu.T1)).longValue(), this.f15608b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
