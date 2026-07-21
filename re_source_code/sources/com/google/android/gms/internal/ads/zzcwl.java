package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwl implements zzdti<zzcwj> {
    private final zzdtu<zzawe> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<String> f15708c;

    public zzcwl(zzdtu<zzawe> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<String> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15707b = zzdtuVar2;
        this.f15708c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwj(this.a.get(), this.f15707b.get(), this.f15708c.get());
    }
}
