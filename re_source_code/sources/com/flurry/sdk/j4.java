package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j4 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Map<String, String>> f10852b;

    public j4(Map<String, Map<String, String>> map) {
        this.f10852b = new HashMap(map);
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        Map<String, Map<String, String>> map = this.f10852b;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
                for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(entry2.getKey(), entry2.getValue());
                    jSONObject2 = jSONObject3;
                }
                jSONObject.put(entry.getKey(), jSONObject2);
            }
        }
        jSONObjectA.put("fl.session.property", jSONObject);
        return jSONObjectA;
    }
}
