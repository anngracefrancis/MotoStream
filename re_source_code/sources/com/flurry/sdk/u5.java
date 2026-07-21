package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11077b;

    public u5(long j2) {
        this.f11077b = j2;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.frame.log.counter", this.f11077b);
        return jSONObjectA;
    }
}
