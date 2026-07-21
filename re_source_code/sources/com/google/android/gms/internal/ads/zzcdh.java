package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdh implements zzdti<zzcjv<zzcdb>> {
    private final zzdtu<zzcoe<zzcdb, zzams, zzclb>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcoe<zzcdb, zzams, zzcla>> f15093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15094c;

    public zzcdh(zzdtu<zzcoe<zzcdb, zzams, zzclb>> zzdtuVar, zzdtu<zzcoe<zzcdb, zzams, zzcla>> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15093b = zzdtuVar2;
        this.f15094c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjv) zzdto.b(this.f15094c.get().o.contains("new_rewarded") ? this.f15093b.get() : this.a.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
