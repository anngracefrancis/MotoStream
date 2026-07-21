package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcuv implements zzcuz<Bundle> {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f15657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15658f;

    public zzcuv(boolean z, boolean z2, String str, boolean z3, int i2, int i3) {
        this.a = z;
        this.f15654b = z2;
        this.f15655c = str;
        this.f15656d = z3;
        this.f15657e = i2;
        this.f15658f = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.f15655c);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzyt.e().c(zzacu.C2));
        bundle2.putInt("target_api", this.f15657e);
        bundle2.putInt("dv", this.f15658f);
        Bundle bundleA = zzcxz.a(bundle2, "sdk_env");
        bundleA.putBoolean("mf", ((Boolean) zzyt.e().c(zzacu.E2)).booleanValue());
        bundleA.putBoolean("instant_app", this.a);
        bundleA.putBoolean("lite", this.f15654b);
        bundleA.putBoolean("is_privileged_process", this.f15656d);
        bundle2.putBundle("sdk_env", bundleA);
        Bundle bundleA2 = zzcxz.a(bundleA, "build_meta");
        bundleA2.putString("cl", "248613007");
        bundleA2.putString("rapid_rc", "dev");
        bundleA2.putString("rapid_rollup", "HEAD");
        bundleA.putBundle("build_meta", bundleA2);
    }
}
