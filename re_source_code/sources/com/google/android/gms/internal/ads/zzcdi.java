package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdi implements zzdti<zzbbh<zzcdb>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbh<zzcxu>> f15095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzblq> f15096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcmx<zzcdb>> f15097d;

    public zzcdi(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<zzcxu>> zzdtuVar2, zzdtu<zzblq> zzdtuVar3, zzdtu<zzcmx<zzcdb>> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15095b = zzdtuVar2;
        this.f15096c = zzdtuVar3;
        this.f15097d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.b(zzbqq.a(this.a.get(), this.f15095b.get(), this.f15096c.get(), this.f15097d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
