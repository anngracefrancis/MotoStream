package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10892b;

    public k5(boolean z) {
        this.f10892b = z;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.ccpa.optout", this.f10892b);
        return jSONObjectA;
    }
}
