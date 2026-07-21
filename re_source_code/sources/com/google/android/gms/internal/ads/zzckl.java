package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzckl implements zzdti<zzckj> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbai> f15327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzboc> f15328c;

    public zzckl(zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzboc> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15327b = zzdtuVar2;
        this.f15328c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzckj(this.a.get(), this.f15327b.get(), this.f15328c.get());
    }
}
