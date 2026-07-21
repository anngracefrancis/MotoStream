package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawl {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f14210b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f14211c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, zzamm> f14212d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONObject f14215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14216h;

    public zzawl(String str, long j2) {
        JSONObject jSONObjectOptJSONObject;
        this.f14216h = false;
        this.f14214f = str;
        this.a = j2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14215g = jSONObject;
            if (jSONObject.optInt("status", -1) != 1) {
                this.f14216h = false;
                zzbad.i("App settings could not be fetched successfully.");
                return;
            }
            this.f14216h = true;
            this.f14213e = this.f14215g.optString(RateAndReviewsFragment.BundleCons.APP_ID);
            JSONArray jSONArrayOptJSONArray = this.f14215g.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    String strOptString = jSONObject2.optString("format");
                    String strOptString2 = jSONObject2.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if ("interstitial".equalsIgnoreCase(strOptString)) {
                            this.f14211c.add(strOptString2);
                        } else if ("rewarded".equalsIgnoreCase(strOptString) && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                            this.f14212d.put(strOptString2, new zzamm(jSONObjectOptJSONObject));
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = this.f14215g.optJSONArray("persistable_banner_ad_unit_ids");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    this.f14210b.add(jSONArrayOptJSONArray2.optString(i3));
                }
            }
        } catch (JSONException e2) {
            zzbad.d("Exception occurred while processing app setting json", e2);
            zzk.zzlk().e(e2, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long a() {
        return this.a;
    }

    public final boolean b() {
        return this.f14216h;
    }

    public final String c() {
        return this.f14214f;
    }

    public final String d() {
        return this.f14213e;
    }

    public final Map<String, zzamm> e() {
        return this.f14212d;
    }

    public final JSONObject f() {
        return this.f14215g;
    }
}
