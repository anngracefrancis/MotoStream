package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbog implements zzdti<zzbbh<zzbnf>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbh<zzcxu>> f14613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzblq> f14614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcmx<zzbnf>> f14615d;

    public zzbog(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<zzcxu>> zzdtuVar2, zzdtu<zzblq> zzdtuVar3, zzdtu<zzcmx<zzbnf>> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14613b = zzdtuVar2;
        this.f14614c = zzdtuVar3;
        this.f14615d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.b(zzbqq.a(this.a.get(), this.f14613b.get(), this.f14614c.get(), this.f14615d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
