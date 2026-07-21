package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxs implements zzdti<zzbbh<zzbph>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbh<zzcxu>> f14817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzblq> f14818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcmx<zzbph>> f14819d;

    public zzbxs(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<zzcxu>> zzdtuVar2, zzdtu<zzblq> zzdtuVar3, zzdtu<zzcmx<zzbph>> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14817b = zzdtuVar2;
        this.f14818c = zzdtuVar3;
        this.f14819d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.b(zzbqq.a(this.a.get(), this.f14817b.get(), this.f14818c.get(), this.f14819d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
