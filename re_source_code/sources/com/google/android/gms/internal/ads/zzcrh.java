package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrh implements zzcuz<Bundle> {
    private final zzcxv a;

    public zzcrh(zzcxv zzcxvVar) {
        Preconditions.l(zzcxvVar, "the targeting must not be null");
        this.a = zzcxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzcxv zzcxvVar = this.a;
        zzxz zzxzVar = zzcxvVar.f15750d;
        bundle2.putString("slotname", zzcxvVar.f15752f);
        if (this.a.o.contains("new_rewarded")) {
            bundle2.putBoolean("is_new_rewarded", true);
        }
        zzcxz.f(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzxzVar.f16969g)), zzxzVar.f16969g != -1);
        zzcxz.b(bundle2, "extras", zzxzVar.f16970h);
        zzcxz.d(bundle2, "cust_gender", Integer.valueOf(zzxzVar.f16971i), zzxzVar.f16971i != -1);
        zzcxz.g(bundle2, "kw", zzxzVar.f16972j);
        zzcxz.d(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzxzVar.l), zzxzVar.l != -1);
        boolean z = zzxzVar.f16973k;
        if (z) {
            bundle2.putBoolean("test_request", z);
        }
        zzcxz.d(bundle2, "d_imp_hdr", 1, zzxzVar.f16968f >= 2 && zzxzVar.m);
        String str = zzxzVar.n;
        zzcxz.f(bundle2, "ppid", str, zzxzVar.f16968f >= 2 && !TextUtils.isEmpty(str));
        Location location = zzxzVar.p;
        if (location != null) {
            Float fValueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long lValueOf = Long.valueOf(location.getTime() * 1000);
            Long lValueOf2 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long lValueOf3 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", fValueOf.floatValue());
            bundle3.putLong("lat", lValueOf2.longValue());
            bundle3.putLong("long", lValueOf3.longValue());
            bundle3.putLong("time", lValueOf.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzcxz.e(bundle2, "url", zzxzVar.q);
        zzcxz.b(bundle2, "custom_targeting", zzxzVar.s);
        zzcxz.g(bundle2, "category_exclusions", zzxzVar.t);
        zzcxz.e(bundle2, "request_agent", zzxzVar.u);
        zzcxz.e(bundle2, "request_pkg", zzxzVar.v);
        zzcxz.c(bundle2, "is_designed_for_families", Boolean.valueOf(zzxzVar.w), zzxzVar.f16968f >= 7);
        if (zzxzVar.f16968f >= 8) {
            zzcxz.d(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzxzVar.y), zzxzVar.y != -1);
            zzcxz.e(bundle2, "max_ad_content_rating", zzxzVar.z);
        }
    }
}
