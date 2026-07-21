package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvi implements zzdti<cp> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15675b;

    public zzcvi(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15675b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new cp(this.a.get(), this.f15675b.get());
    }
}
