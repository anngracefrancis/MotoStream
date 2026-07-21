package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvj implements zzcuz<Bundle> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f15679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f15680f;

    public zzcvj(String str, int i2, int i3, int i4, boolean z, int i5) {
        this.a = str;
        this.f15676b = i2;
        this.f15677c = i3;
        this.f15678d = i4;
        this.f15679e = z;
        this.f15680f = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.a;
        zzcxz.f(bundle2, "carrier", str, !TextUtils.isEmpty(str));
        zzcxz.d(bundle2, "cnt", Integer.valueOf(this.f15676b), this.f15676b != -2);
        bundle2.putInt("gnt", this.f15677c);
        bundle2.putInt("pt", this.f15678d);
        Bundle bundleA = zzcxz.a(bundle2, "device");
        bundle2.putBundle("device", bundleA);
        Bundle bundleA2 = zzcxz.a(bundleA, "network");
        bundleA.putBundle("network", bundleA2);
        bundleA2.putInt("active_network_state", this.f15680f);
        bundleA2.putBoolean("active_network_metered", this.f15679e);
    }
}
