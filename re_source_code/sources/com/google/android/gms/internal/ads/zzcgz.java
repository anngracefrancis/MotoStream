package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgz implements zzdti<zzbbh<zzcxu>> {
    private final zzdtu<zzczt> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzchl> f15224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzchq> f15225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbbh<zzarx>> f15226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcxv> f15227e;

    private zzcgz(zzdtu<zzczt> zzdtuVar, zzdtu<zzchl> zzdtuVar2, zzdtu<zzchq> zzdtuVar3, zzdtu<zzbbh<zzarx>> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15224b = zzdtuVar2;
        this.f15225c = zzdtuVar3;
        this.f15226d = zzdtuVar4;
        this.f15227e = zzdtuVar5;
    }

    public static zzcgz a(zzdtu<zzczt> zzdtuVar, zzdtu<zzchl> zzdtuVar2, zzdtu<zzchq> zzdtuVar3, zzdtu<zzbbh<zzarx>> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        return new zzcgz(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzczt zzcztVar = this.a.get();
        zzchl zzchlVar = this.f15224b.get();
        zzchq zzchqVar = this.f15225c.get();
        zzbbh<zzarx> zzbbhVar = this.f15226d.get();
        zzcxv zzcxvVar = this.f15227e.get();
        zzk.zzlm().l();
        return (zzbbh) zzdto.b(zzcxvVar.f15750d.x != null ? zzcztVar.c(zzczs.SERVER_TRANSACTION, zzbbhVar).g(zzchqVar.a()).f() : zzcztVar.c(zzczs.SERVER_TRANSACTION, zzbbhVar).b(zzchlVar).f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
