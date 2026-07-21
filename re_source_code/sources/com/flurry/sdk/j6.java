package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j6 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<m, String> f10853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10854c;

    public j6(Map<m, String> map, boolean z) {
        this.f10853b = new HashMap(map);
        this.f10854c = z;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<m, String> entry : this.f10853b.entrySet()) {
            jSONObject.put(entry.getKey().name(), entry.getValue());
        }
        jSONObjectA.put("fl.reported.id", jSONObject);
        jSONObjectA.put("fl.ad.tracking", this.f10854c);
        return jSONObjectA;
    }
}
