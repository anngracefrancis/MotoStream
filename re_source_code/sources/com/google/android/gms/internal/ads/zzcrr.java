package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrr implements zzdti<zzcrp> {
    private final zzdtu<zzcsk<zzcvf>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxv> f15579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Context> f15580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzawm> f15581d;

    private zzcrr(zzdtu<zzcsk<zzcvf>> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<Context> zzdtuVar3, zzdtu<zzawm> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15579b = zzdtuVar2;
        this.f15580c = zzdtuVar3;
        this.f15581d = zzdtuVar4;
    }

    public static zzcrr a(zzdtu<zzcsk<zzcvf>> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<Context> zzdtuVar3, zzdtu<zzawm> zzdtuVar4) {
        return new zzcrr(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrp(this.a.get(), this.f15579b.get(), this.f15580c.get(), this.f15581d.get());
    }
}
