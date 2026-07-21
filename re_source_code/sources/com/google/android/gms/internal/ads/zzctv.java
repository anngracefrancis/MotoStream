package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zzctv implements zzcuz<Bundle> {
    private final String a;

    public zzctv(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        zzcxz.e(bundle, "omid_v", this.a);
    }
}
