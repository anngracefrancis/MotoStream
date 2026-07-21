package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcfi {
    private Map<String, String> a;

    public zzcfi(Context context, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.a = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", "3");
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("sdk", Build.VERSION.SDK);
        zzk.zzlg();
        linkedHashMap.put("device", zzaxi.k0());
        linkedHashMap.put("app", str);
        zzk.zzlg();
        linkedHashMap.put("is_lite_sdk", zzaxi.E(context) ? "1" : "0");
        linkedHashMap.put("e", TextUtils.join(",", zzacu.d()));
    }

    public final void a(zzcxu zzcxuVar) {
        if (zzcxuVar.f15747b.a.size() > 0) {
            int i2 = zzcxuVar.f15747b.a.get(0).f15724b;
            if (i2 == 1) {
                this.a.put("ad_format", "banner");
            } else if (i2 == 2) {
                this.a.put("ad_format", "interstitial");
            } else if (i2 == 3) {
                this.a.put("ad_format", "native_express");
            } else if (i2 == 4) {
                this.a.put("ad_format", "native_advanced");
            } else if (i2 != 5) {
                this.a.put("ad_format", "unknown");
            } else {
                this.a.put("ad_format", "rewarded");
            }
            if (TextUtils.isEmpty(zzcxuVar.f15747b.f15744b.f15736b)) {
                return;
            }
            this.a.put("gqi", zzcxuVar.f15747b.f15744b.f15736b);
        }
    }

    public final void b(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.a.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.a.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> c() {
        return this.a;
    }
}
