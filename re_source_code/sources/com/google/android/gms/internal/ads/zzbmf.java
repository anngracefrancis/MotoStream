package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmf implements zzdti<zzbme> {
    private final zzdtu<zzcxu> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxm> f14535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzdae> f14536c;

    private zzbmf(zzdtu<zzcxu> zzdtuVar, zzdtu<zzcxm> zzdtuVar2, zzdtu<zzdae> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14535b = zzdtuVar2;
        this.f14536c = zzdtuVar3;
    }

    public static zzbmf a(zzdtu<zzcxu> zzdtuVar, zzdtu<zzcxm> zzdtuVar2, zzdtu<zzdae> zzdtuVar3) {
        return new zzbmf(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbme(this.a.get(), this.f14535b.get(), this.f14536c.get());
    }
}
