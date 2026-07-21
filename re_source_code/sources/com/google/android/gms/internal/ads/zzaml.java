package com.google.android.gms.internal.ads;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaml {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f13969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f13972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<String> f13973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<String> f13974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<String> f13975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<String> f13976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f13977k;
    private final List<String> l;
    private final List<String> m;
    private final List<String> n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final List<String> t;
    private final String u;
    public final String v;
    private final long w;

    public zzaml(JSONObject jSONObject) throws JSONException {
        List<String> listA;
        this.f13968b = jSONObject.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        this.f13969c = Collections.unmodifiableList(arrayList);
        this.f13970d = jSONObject.optString("allocation_id", null);
        zzk.zzly();
        this.f13972f = zzamn.a(jSONObject, "clickurl");
        zzk.zzly();
        this.f13973g = zzamn.a(jSONObject, "imp_urls");
        zzk.zzly();
        this.f13974h = zzamn.a(jSONObject, "downloaded_imp_urls");
        zzk.zzly();
        this.f13976j = zzamn.a(jSONObject, "fill_urls");
        zzk.zzly();
        this.l = zzamn.a(jSONObject, "video_start_urls");
        zzk.zzly();
        this.n = zzamn.a(jSONObject, "video_complete_urls");
        zzk.zzly();
        this.m = zzamn.a(jSONObject, "video_reward_urls");
        this.o = jSONObject.optString("transaction_id");
        this.p = jSONObject.optString("valid_from_timestamp");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ad");
        if (jSONObjectOptJSONObject != null) {
            zzk.zzly();
            listA = zzamn.a(jSONObjectOptJSONObject, "manual_impression_urls");
        } else {
            listA = null;
        }
        this.f13975i = listA;
        this.a = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.f13977k = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        this.f13971e = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("class_name") : null;
        this.q = jSONObject.optString("html_template", null);
        this.r = jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        this.s = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.toString() : null;
        zzk.zzly();
        this.t = zzamn.a(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.u = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.toString() : null;
        this.v = jSONObject.optString("response_type", null);
        this.w = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
