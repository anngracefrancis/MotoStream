package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmd implements zzdti<zzclx> {
    private final zzdtu<zzbxo> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcaq> f15380c;

    public zzcmd(zzdtu<zzbxo> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzcaq> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15379b = zzdtuVar2;
        this.f15380c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzclx(this.a.get(), this.f15379b.get(), this.f15380c.get());
    }
}
