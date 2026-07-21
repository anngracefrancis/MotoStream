package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbou implements zzdti<zzbot> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbgz> f14636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxm> f14637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbai> f14638d;

    public zzbou(zzdtu<Context> zzdtuVar, zzdtu<zzbgz> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzbai> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f14636b = zzdtuVar2;
        this.f14637c = zzdtuVar3;
        this.f14638d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbot(this.a.get(), this.f14636b.get(), this.f14637c.get(), this.f14638d.get());
    }
}
