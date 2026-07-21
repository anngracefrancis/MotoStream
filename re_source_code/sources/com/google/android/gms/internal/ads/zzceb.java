package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzceb implements zzdti<zzcdn> {
    private final zzdtu<zzbhf> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzdh> f15130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbai> f15131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<com.google.android.gms.ads.internal.zza> f15132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<zzwj> f15133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<zzbtb> f15134h;

    private zzceb(zzdtu<zzbhf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzdh> zzdtuVar4, zzdtu<zzbai> zzdtuVar5, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar6, zzdtu<zzwj> zzdtuVar7, zzdtu<zzbtb> zzdtuVar8) {
        this.a = zzdtuVar;
        this.f15128b = zzdtuVar2;
        this.f15129c = zzdtuVar3;
        this.f15130d = zzdtuVar4;
        this.f15131e = zzdtuVar5;
        this.f15132f = zzdtuVar6;
        this.f15133g = zzdtuVar7;
        this.f15134h = zzdtuVar8;
    }

    public static zzceb a(zzdtu<zzbhf> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzdh> zzdtuVar4, zzdtu<zzbai> zzdtuVar5, zzdtu<com.google.android.gms.ads.internal.zza> zzdtuVar6, zzdtu<zzwj> zzdtuVar7, zzdtu<zzbtb> zzdtuVar8) {
        return new zzceb(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcdn(this.a.get(), this.f15128b.get(), this.f15129c.get(), this.f15130d.get(), this.f15131e.get(), this.f15132f.get(), this.f15133g.get(), this.f15134h.get());
    }
}
