package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsf implements zzdti<zzcsd> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<Context> f15600b;

    private zzcsf(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15600b = zzdtuVar2;
    }

    public static zzcsf a(zzdtu<zzbbl> zzdtuVar, zzdtu<Context> zzdtuVar2) {
        return new zzcsf(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsd(this.a.get(), this.f15600b.get());
    }
}
