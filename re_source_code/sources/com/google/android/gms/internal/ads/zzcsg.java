package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsg implements zzcuz<Bundle> {
    private final double a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15601b;

    public zzcsg(double d2, boolean z) {
        this.a = d2;
        this.f15601b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundleA = zzcxz.a(bundle2, "device");
        bundle2.putBundle("device", bundleA);
        Bundle bundleA2 = zzcxz.a(bundleA, "battery");
        bundleA.putBundle("battery", bundleA2);
        bundleA2.putBoolean("is_charging", this.f15601b);
        bundleA2.putDouble("battery_level", this.a);
    }
}
