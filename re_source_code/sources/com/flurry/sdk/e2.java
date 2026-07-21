package com.flurry.sdk;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e2 {
    public static JSONObject a(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
