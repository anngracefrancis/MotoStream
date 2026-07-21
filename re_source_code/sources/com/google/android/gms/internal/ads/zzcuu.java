package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcuu implements zzdti<zzcus> {
    private final zzdtu<zzavg> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbbl> f15652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<Context> f15653c;

    private zzcuu(zzdtu<zzavg> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15652b = zzdtuVar2;
        this.f15653c = zzdtuVar3;
    }

    public static zzcuu a(zzdtu<zzavg> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<Context> zzdtuVar3) {
        return new zzcuu(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcus(this.a.get(), this.f15652b.get(), this.f15653c.get());
    }
}
