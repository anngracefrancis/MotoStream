package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h4 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10811c;

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.session.property.param.name", this.f10810b);
        jSONObjectA.put("fl.session.property.param.value", this.f10811c);
        return jSONObjectA;
    }
}
