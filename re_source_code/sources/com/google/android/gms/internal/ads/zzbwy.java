package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwy implements zzdti<zzcjv<zzbvx>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f14786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzclq> f14787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcoc> f14788d;

    public zzbwy(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzclq> zzdtuVar3, zzdtu<zzcoc> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14786b = zzdtuVar2;
        this.f14787c = zzdtuVar3;
        this.f14788d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcjv) zzdto.b(new zzcoe(this.a.get(), this.f14786b.get(), this.f14788d.get(), this.f14787c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
