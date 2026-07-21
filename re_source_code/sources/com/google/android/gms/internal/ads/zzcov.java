package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcov<AdT> implements zzdti<zzcor<AdT>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzado> f15485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcou<AdT>> f15486d;

    public zzcov(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<zzado> zzdtuVar3, zzdtu<zzcou<AdT>> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15484b = zzdtuVar2;
        this.f15485c = zzdtuVar3;
        this.f15486d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcor(this.a.get(), this.f15484b.get(), this.f15485c.get(), this.f15486d.get());
    }
}
