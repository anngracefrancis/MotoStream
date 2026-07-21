package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwe implements zzdti<zzcwc> {
    private final zzdtu<zzvx> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Context> f15703c;

    public zzcwe(zzdtu<zzvx> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15702b = zzdtuVar2;
        this.f15703c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwc(this.a.get(), this.f15702b.get(), this.f15703c.get());
    }
}
