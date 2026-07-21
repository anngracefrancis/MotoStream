package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdm implements zzdti<zzcjv<zzcdb>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcnd> f15099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcoc> f15100d;

    public zzcdm(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzcnd> zzdtuVar3, zzdtu<zzcoc> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15098b = zzdtuVar2;
        this.f15099c = zzdtuVar3;
        this.f15100d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjv) zzdto.b(new zzcoe(this.a.get(), this.f15098b.get(), this.f15100d.get(), this.f15099c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
