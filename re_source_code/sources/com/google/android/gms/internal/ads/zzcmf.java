package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmf implements zzdti<zzcme> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbxo> f15382b;

    public zzcmf(zzdtu<Context> zzdtuVar, zzdtu<zzbxo> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15382b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcme(this.a.get(), this.f15382b.get());
    }
}
