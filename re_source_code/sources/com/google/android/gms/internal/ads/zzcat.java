package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcat implements zzdti<zzcaq> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcau> f14989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcbd> f14990c;

    public zzcat(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcau> zzdtuVar2, zzdtu<zzcbd> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f14989b = zzdtuVar2;
        this.f14990c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcaq(this.a.get(), this.f14989b.get(), this.f14990c.get());
    }
}
