package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcuc implements zzdti<zzcub> {
    private final zzdtu<ApplicationInfo> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<PackageInfo> f15631b;

    private zzcuc(zzdtu<ApplicationInfo> zzdtuVar, zzdtu<PackageInfo> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15631b = zzdtuVar2;
    }

    public static zzcuc a(zzdtu<ApplicationInfo> zzdtuVar, zzdtu<PackageInfo> zzdtuVar2) {
        return new zzcuc(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcub(this.a.get(), this.f15631b.get());
    }
}
