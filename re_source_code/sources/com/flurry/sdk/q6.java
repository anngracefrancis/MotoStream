package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q6 implements t6 {
    protected int a = 1;

    @Override // com.flurry.sdk.t6
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fl.frame.version", this.a);
        return jSONObject;
    }
}
