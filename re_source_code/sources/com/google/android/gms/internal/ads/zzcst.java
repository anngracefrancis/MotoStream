package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcst implements zzdti<zzcsp> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15610b;

    private zzcst(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15610b = zzdtuVar2;
    }

    public static zzcst a(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        return new zzcst(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsp(this.a.get(), this.f15610b.get());
    }
}
