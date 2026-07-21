package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctu implements zzdti<zzctp> {
    private final zzdtu<zzbbl> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxv> f15621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<PackageInfo> f15622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzaxb> f15623d;

    public zzctu(zzdtu<zzbbl> zzdtuVar, zzdtu<zzcxv> zzdtuVar2, zzdtu<PackageInfo> zzdtuVar3, zzdtu<zzaxb> zzdtuVar4) {
        this.a = zzdtuVar;
        this.f15621b = zzdtuVar2;
        this.f15622c = zzdtuVar3;
        this.f15623d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzctp(this.a.get(), this.f15621b.get(), this.f15622c.get(), this.f15623d.get());
    }
}
