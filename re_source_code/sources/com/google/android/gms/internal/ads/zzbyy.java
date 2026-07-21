package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyy extends zzbyx {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f14882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f14884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f14885e;

    public zzbyy(zzcxm zzcxmVar, JSONObject jSONObject) {
        super(zzcxmVar);
        this.f14882b = zzazc.e(jSONObject, "tracking_urls_and_actions", "active_view");
        this.f14883c = zzazc.i(false, jSONObject, "allow_pub_owned_ad_view");
        this.f14884d = zzazc.i(false, jSONObject, "attribution", "allow_pub_rendering");
        this.f14885e = zzazc.i(false, jSONObject, "enable_omid");
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final JSONObject a() {
        JSONObject jSONObject = this.f14882b;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.a.w);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final boolean b() {
        return this.f14883c;
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final boolean c() {
        return this.f14884d;
    }

    @Override // com.google.android.gms.internal.ads.zzbyx
    public final boolean d() {
        return this.f14885e;
    }
}
