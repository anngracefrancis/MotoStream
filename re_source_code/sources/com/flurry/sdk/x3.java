package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class x3 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11144c;

    public x3(int i2, boolean z) {
        this.f11143b = i2;
        this.f11144c = z;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.event.count", this.f11143b);
        jSONObjectA.put("fl.event.set.complete", this.f11144c);
        return jSONObjectA;
    }
}
