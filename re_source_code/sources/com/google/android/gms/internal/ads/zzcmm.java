package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmm implements zzdti<zzcml> {
    private final zzdtu<zzbjm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbxk> f15389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbqy.zza> f15390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbtv> f15391d;

    public zzcmm(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbxk> zzdtuVar2, zzdtu<zzbqy.zza> zzdtuVar3, zzdtu<zzbtv> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15389b = zzdtuVar2;
        this.f15390c = zzdtuVar3;
        this.f15391d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcml(this.a.get(), this.f15389b.get(), this.f15390c.get(), this.f15391d.get());
    }
}
