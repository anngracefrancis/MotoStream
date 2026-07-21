package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcxq implements zzazf {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f15742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f15743d;

    zzcxq(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        JSONObject jSONObjectM = zzazc.m(jsonReader);
        this.f15743d = jSONObjectM;
        this.a = jSONObjectM.optString("ad_html", null);
        this.f15741b = jSONObjectM.optString("ad_base_url", null);
        this.f15742c = jSONObjectM.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.internal.ads.zzazf
    public final void a(JsonWriter jsonWriter) throws IOException {
        zzazc.h(jsonWriter, this.f15743d);
    }
}
