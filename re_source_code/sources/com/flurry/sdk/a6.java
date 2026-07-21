package com.flurry.sdk;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a6 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10626c;

    public a6(String str, boolean z) {
        this.f10625b = str;
        this.f10626c = z;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        if (!TextUtils.isEmpty(this.f10625b)) {
            jSONObjectA.put("fl.notification.key", this.f10625b);
        }
        jSONObjectA.put("fl.notification.enabled", this.f10626c);
        return jSONObjectA;
    }
}
