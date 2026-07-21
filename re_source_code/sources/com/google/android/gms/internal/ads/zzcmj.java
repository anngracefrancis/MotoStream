package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcmj implements zzdti<zzcmg> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbxo> f15385b;

    public zzcmj(zzdtu<Context> zzdtuVar, zzdtu<zzbxo> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15385b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcmg(this.a.get(), this.f15385b.get());
    }
}
