package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcub implements zzcuz<Bundle>, zzcva<zzcuz<Bundle>> {
    private final ApplicationInfo a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageInfo f15630b;

    zzcub(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.a = applicationInfo;
        this.f15630b = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.a.packageName;
        PackageInfo packageInfo = this.f15630b;
        Integer numValueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (numValueOf != null) {
            bundle2.putInt("vc", numValueOf.intValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> b() {
        return zzbar.o(this);
    }
}
