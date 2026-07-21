package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsx implements zzdti<zzcsv> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15612b;

    private zzcsx(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15612b = zzdtuVar2;
    }

    public static zzcsx a(zzdtu<Context> zzdtuVar, zzdtu<zzbbl> zzdtuVar2) {
        return new zzcsx(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcsv(this.a.get(), this.f15612b.get());
    }
}
