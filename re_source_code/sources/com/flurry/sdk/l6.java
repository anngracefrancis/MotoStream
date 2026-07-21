package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class l6 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f10896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10899e;

    public l6(long j2, long j3, long j4, int i2) {
        this.f10896b = j2;
        this.f10897c = j3;
        this.f10898d = j4;
        this.f10899e = i2;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.session.id", this.f10896b);
        jSONObjectA.put("fl.session.elapsed.start.time", this.f10897c);
        long j2 = this.f10898d;
        if (j2 >= this.f10897c) {
            jSONObjectA.put("fl.session.elapsed.end.time", j2);
        }
        jSONObjectA.put("fl.session.id.current.state", this.f10899e);
        return jSONObjectA;
    }
}
