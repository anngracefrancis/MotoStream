package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxj implements zzdti<nf> {
    private final zzdtu<Map<String, zzcjv<zzbph>>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Map<String, zzcjv<zzbyn>>> f14812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Map<String, zzclw<zzbyn>>> f14813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbpe<zzbnf>> f14814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbzc> f14815e;

    public zzbxj(zzdtu<Map<String, zzcjv<zzbph>>> zzdtuVar, zzdtu<Map<String, zzcjv<zzbyn>>> zzdtuVar2, zzdtu<Map<String, zzclw<zzbyn>>> zzdtuVar3, zzdtu<zzbpe<zzbnf>> zzdtuVar4, zzdtu<zzbzc> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14812b = zzdtuVar2;
        this.f14813c = zzdtuVar3;
        this.f14814d = zzdtuVar4;
        this.f14815e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new nf(this.a.get(), this.f14812b.get(), this.f14813c.get(), this.f14814d, this.f14815e.get());
    }
}
