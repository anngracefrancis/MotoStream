package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f10965b;

    public o5(Map<String, String> map) {
        this.f10965b = new HashMap(map);
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.device.properties", e2.a(this.f10965b));
        return jSONObjectA;
    }
}
