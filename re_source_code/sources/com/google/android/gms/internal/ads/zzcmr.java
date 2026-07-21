package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmr implements zzdti<zzcmq> {
    private final zzdtu<zzbjm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqy.zza> f15407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcow> f15408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbtv> f15409d;

    public zzcmr(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbqy.zza> zzdtuVar2, zzdtu<zzcow> zzdtuVar3, zzdtu<zzbtv> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15407b = zzdtuVar2;
        this.f15408c = zzdtuVar3;
        this.f15409d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcmq(this.a.get(), this.f15407b.get(), this.f15408c.get(), this.f15409d.get());
    }
}
