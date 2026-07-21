package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbqs implements zzdti<zzbqr> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxv> f14698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbai> f14699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzaxb> f14700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcgb> f14701e;

    private zzbqs(zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<zzaxb> zzdtuVar4, zzdtu<zzcgb> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14698b = zzdtuVar2;
        this.f14699c = zzdtuVar3;
        this.f14700d = zzdtuVar4;
        this.f14701e = zzdtuVar5;
    }

    public static zzbqs a(zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<zzaxb> zzdtuVar4, zzdtu<zzcgb> zzdtuVar5) {
        return new zzbqs(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbqr(this.a.get(), this.f14698b.get(), this.f14699c.get(), this.f14700d.get(), this.f14701e.get());
    }
}
