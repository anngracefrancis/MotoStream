package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d4 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10701b;

    public d4(int i2) {
        this.f10701b = i2;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.error.count", this.f10701b);
        return jSONObjectA;
    }
}
