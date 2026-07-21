package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwu implements zzdti<zzbbh<zzbvx>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbh<zzcxu>> f14783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzblq> f14784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcmx<zzbvx>> f14785d;

    public zzbwu(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<zzcxu>> zzdtuVar2, zzdtu<zzblq> zzdtuVar3, zzdtu<zzcmx<zzbvx>> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14783b = zzdtuVar2;
        this.f14784c = zzdtuVar3;
        this.f14785d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.b(zzbqq.a(this.a.get(), this.f14783b.get(), this.f14784c.get(), this.f14785d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
