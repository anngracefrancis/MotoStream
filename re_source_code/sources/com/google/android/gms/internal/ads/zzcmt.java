package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmt implements zzdti<zzcms> {
    private final zzdtu<zzbjm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqy.zza> f15412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbtv> f15413c;

    public zzcmt(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbqy.zza> zzdtuVar2, zzdtu<zzbtv> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15412b = zzdtuVar2;
        this.f15413c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcms(this.a.get(), this.f15412b.get(), this.f15413c.get());
    }
}
