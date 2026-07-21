package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11023b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11024c;

    public q5(String str) {
        this.f11024c = str;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.background.enabled", this.f11023b);
        jSONObjectA.put("fl.sdk.version.code", this.f11024c);
        return jSONObjectA;
    }
}
