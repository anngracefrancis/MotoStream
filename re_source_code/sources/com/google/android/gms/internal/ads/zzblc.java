package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzblc implements zzdti<zzbkz> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f14516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzclc> f14517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcjz<zzams, zzclb>> f14518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcpf> f14519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzcgb> f14520f;

    public zzblc(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzclc> zzdtuVar3, zzdtu<zzcjz<zzams, zzclb>> zzdtuVar4, zzdtu<zzcpf> zzdtuVar5, zzdtu<zzcgb> zzdtuVar6) {
        this.a = zzdtuVar;
        this.f14516b = zzdtuVar2;
        this.f14517c = zzdtuVar3;
        this.f14518d = zzdtuVar4;
        this.f14519e = zzdtuVar5;
        this.f14520f = zzdtuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbkz(this.a.get(), this.f14516b.get(), this.f14517c.get(), this.f14518d.get(), this.f14519e.get(), this.f14520f.get());
    }
}
