package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgs implements zzdti<zzcgn> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzchv> f15213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcig> f15214d;

    private zzcgs(zzdtu<zzbbl> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzchv> zzdtuVar3, zzdtu<zzcig> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15212b = zzdtuVar2;
        this.f15213c = zzdtuVar3;
        this.f15214d = zzdtuVar4;
    }

    public static zzcgs a(zzdtu<zzbbl> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzchv> zzdtuVar3, zzdtu<zzcig> zzdtuVar4) {
        return new zzcgs(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcgn(this.a.get(), this.f15212b.get(), this.f15213c.get(), zzdth.b(this.f15214d));
    }
}
