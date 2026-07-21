package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwi implements zzcuz<JSONObject> {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15704b;

    public zzcwi(String str, String str2) {
        this.a = str;
        this.f15704b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectK = zzazc.k(jSONObject, "pii");
            jSONObjectK.put("doritos", this.a);
            jSONObjectK.put("doritos_v2", this.f15704b);
        } catch (JSONException unused) {
            zzawz.m("Failed putting doritos string.");
        }
    }
}
