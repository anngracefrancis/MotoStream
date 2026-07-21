package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10795b;

    public g5(int i2) {
        this.f10795b = i2 < 0 ? 0 : i2;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.app.orientation", this.f10795b);
        return jSONObjectA;
    }
}
