package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzchg implements zzdti<PackageInfo> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<ApplicationInfo> f15238b;

    private zzchg(zzdtu<Context> zzdtuVar, zzdtu<ApplicationInfo> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f15238b = zzdtuVar2;
    }

    public static zzchg a(zzdtu<Context> zzdtuVar, zzdtu<ApplicationInfo> zzdtuVar2) {
        return new zzchg(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzcgt.a(this.a.get(), this.f15238b.get());
    }
}
