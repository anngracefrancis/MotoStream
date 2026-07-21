package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class t3 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11065g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f11066h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f11067i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f11068j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f11069k;
    public final Map<String, String> l;
    public final Map<String, String> m;
    public int n;
    public List<m7> o;

    public t3(int i2, String str, long j2, String str2, String str3, String str4, int i3, int i4, Map<String, String> map, Map<String, String> map2, int i5, List<m7> list, String str5, String str6) {
        this.f11060b = i2;
        this.f11061c = str;
        this.f11062d = j2;
        this.f11063e = str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2;
        this.f11064f = str3 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str3;
        this.f11065g = str4 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str4;
        this.f11066h = i3;
        this.f11067i = i4;
        this.l = map == null ? new HashMap<>() : map;
        this.m = map2 == null ? new HashMap<>() : map2;
        this.n = i5;
        this.o = list == null ? new ArrayList<>() : list;
        this.f11068j = str5 != null ? c2.h(str5) : HttpUrl.FRAGMENT_ENCODE_SET;
        this.f11069k = str6 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str6;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.error.id", this.f11060b);
        jSONObjectA.put("fl.error.name", this.f11061c);
        jSONObjectA.put("fl.error.timestamp", this.f11062d);
        jSONObjectA.put("fl.error.message", this.f11063e);
        jSONObjectA.put("fl.error.class", this.f11064f);
        jSONObjectA.put("fl.error.type", this.f11066h);
        jSONObjectA.put("fl.crash.report", this.f11065g);
        jSONObjectA.put("fl.crash.platform", this.f11067i);
        jSONObjectA.put("fl.error.user.crash.parameter", e2.a(this.m));
        jSONObjectA.put("fl.error.sdk.crash.parameter", e2.a(this.l));
        jSONObjectA.put("fl.breadcrumb.version", this.n);
        JSONArray jSONArray = new JSONArray();
        List<m7> list = this.o;
        if (list != null) {
            for (m7 m7Var : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fl.breadcrumb.message", m7Var.f10923b);
                jSONObject.put("fl.breadcrumb.timestamp", m7Var.f10924c);
                jSONArray.put(jSONObject);
            }
        }
        jSONObjectA.put("fl.breadcrumb", jSONArray);
        jSONObjectA.put("fl.nativecrash.minidump", this.f11068j);
        jSONObjectA.put("fl.nativecrash.logcat", this.f11069k);
        return jSONObjectA;
    }
}
