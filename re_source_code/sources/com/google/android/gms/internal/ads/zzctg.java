package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctg implements zzcuz<Bundle> {
    private final Bundle a;

    public zzctg(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundleA = zzcxz.a(bundle2, "device");
        bundleA.putBundle("android_mem_info", this.a);
        bundle2.putBundle("device", bundleA);
    }
}
