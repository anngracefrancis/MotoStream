package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzamm {
    public final List<zzaml> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f13978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f13979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<String> f13980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f13981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f13982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<String> f13983g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f13984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f13985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f13986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f13987k;
    private final int l;
    private final int m;
    private final long n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private int s;
    private int t;
    private boolean u;

    public zzamm(JSONObject jSONObject) throws JSONException {
        if (zzbad.a(2)) {
            String strValueOf = String.valueOf(jSONObject.toString(2));
            zzawz.m(strValueOf.length() != 0 ? "Mediation Response JSON: ".concat(strValueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i2 = -1;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                zzaml zzamlVar = new zzaml(jSONArray.getJSONObject(i3));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzamlVar.v)) {
                    this.u = true;
                }
                arrayList.add(zzamlVar);
                if (i2 < 0) {
                    Iterator<String> it = zzamlVar.f13969c.iterator();
                    do {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                    } while (!it.next().equals("com.google.ads.mediation.admob.AdMobAdapter"));
                    if (z) {
                        i2 = i3;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.s = i2;
        this.t = jSONArray.length();
        this.a = Collections.unmodifiableList(arrayList);
        this.f13985i = jSONObject.optString("qdata");
        this.m = jSONObject.optInt("fs_model_type", -1);
        this.n = jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject == null) {
            this.f13978b = -1L;
            this.f13979c = null;
            this.f13980d = null;
            this.f13981e = null;
            this.f13982f = null;
            this.f13983g = null;
            this.f13986j = -1L;
            this.f13987k = null;
            this.l = 0;
            this.o = false;
            this.f13984h = false;
            this.p = false;
            this.q = false;
            this.r = false;
            return;
        }
        this.f13978b = jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
        zzk.zzly();
        this.f13979c = zzamn.a(jSONObjectOptJSONObject, "click_urls");
        zzk.zzly();
        this.f13980d = zzamn.a(jSONObjectOptJSONObject, "imp_urls");
        zzk.zzly();
        this.f13981e = zzamn.a(jSONObjectOptJSONObject, "downloaded_imp_urls");
        zzk.zzly();
        this.f13982f = zzamn.a(jSONObjectOptJSONObject, "nofill_urls");
        zzk.zzly();
        this.f13983g = zzamn.a(jSONObjectOptJSONObject, "remote_ping_urls");
        this.f13984h = jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
        long jOptLong = jSONObjectOptJSONObject.optLong("refresh", -1L);
        this.f13986j = jOptLong > 0 ? 1000 * jOptLong : -1L;
        zzato zzatoVarY = zzato.y(jSONObjectOptJSONObject.optJSONArray("rewards"));
        if (zzatoVarY == null) {
            this.f13987k = null;
            this.l = 0;
        } else {
            this.f13987k = zzatoVarY.f14157f;
            this.l = zzatoVarY.f14158g;
        }
        this.o = jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
        this.p = jSONObjectOptJSONObject.optBoolean("allow_pub_rendered_attribution", false);
        this.q = jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
        this.r = jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
    }
}
