package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f4 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f10758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0 f10762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f10763g;

    public f4(c0 c0Var) {
        this.f10758b = c0Var.a;
        this.f10759c = c0Var.f10652b;
        this.f10760d = c0Var.f10653c;
        this.f10761e = c0Var.f10654d;
        this.f10762f = c0Var.f10655e;
        this.f10763g = c0Var.f10656f;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.session.timestamp", this.f10759c);
        jSONObjectA.put("fl.initial.timestamp", this.f10760d);
        jSONObjectA.put("fl.continue.session.millis", this.f10761e);
        jSONObjectA.put("fl.session.state", this.f10758b.f10737j);
        jSONObjectA.put("fl.session.event", this.f10762f.name());
        jSONObjectA.put("fl.session.manual", this.f10763g);
        return jSONObjectA;
    }
}
