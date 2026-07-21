package com.flurry.sdk;

import android.text.TextUtils;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z3 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11163c;

    public z3(String str, String str2) {
        this.f11162b = str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
        this.f11163c = str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = super.a();
        if (!TextUtils.isEmpty(this.f11162b)) {
            jSONObjectA.put("fl.language", this.f11162b);
        }
        if (!TextUtils.isEmpty(this.f11163c)) {
            jSONObjectA.put("fl.country", this.f11163c);
        }
        return jSONObjectA;
    }
}
