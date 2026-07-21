package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11050c;

    public s5(int i2, String str) {
        this.f11049b = 0;
        this.f11050c = "Unknown";
        this.f11049b = i2;
        this.f11050c = str;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.flush.frame.code", this.f11049b);
        jSONObjectA.put("fl.flush.frame.reason", this.f11050c);
        return jSONObjectA;
    }
}
