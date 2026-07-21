package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcoq implements zzdti<zzcok> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzboc> f15477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzczt> f15478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbbl> f15479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzado> f15480e;

    public zzcoq(zzdtu<Context> zzdtuVar, zzdtu<zzboc> zzdtuVar2, zzdtu<zzczt> zzdtuVar3, zzdtu<zzbbl> zzdtuVar4, zzdtu<zzado> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15477b = zzdtuVar2;
        this.f15478c = zzdtuVar3;
        this.f15479d = zzdtuVar4;
        this.f15480e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcok(this.a.get(), this.f15477b.get(), this.f15478c.get(), this.f15479d.get(), this.f15480e.get());
    }
}
