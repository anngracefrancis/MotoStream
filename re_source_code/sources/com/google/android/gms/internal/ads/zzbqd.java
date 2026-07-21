package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqd implements zzdti<zzawj> {
    private final zzdtu<Clock> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzawu> f14680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f14681c;

    private zzbqd(zzdtu<Clock> zzdtuVar, zzdtu<zzawu> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14680b = zzdtuVar2;
        this.f14681c = zzdtuVar3;
    }

    public static zzbqd a(zzdtu<Clock> zzdtuVar, zzdtu<zzawu> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        return new zzbqd(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzawj) zzdto.b(this.f14680b.get().c(this.a.get(), this.f14681c.get().f15752f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
