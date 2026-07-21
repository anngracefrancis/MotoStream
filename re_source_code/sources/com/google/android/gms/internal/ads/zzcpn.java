package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpn implements zzdti<zzcpm> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzyz> f15507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzcxv> f15508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbnf> f15509d;

    public zzcpn(zzdtu<Context> zzdtuVar, zzdtu<zzyz> zzdtuVar2, zzdtu<zzcxv> zzdtuVar3, zzdtu<zzbnf> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15507b = zzdtuVar2;
        this.f15508c = zzdtuVar3;
        this.f15509d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcpm(this.a.get(), this.f15507b.get(), this.f15508c.get(), this.f15509d.get());
    }
}
