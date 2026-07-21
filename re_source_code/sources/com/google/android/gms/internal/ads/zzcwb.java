package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwb implements zzcuz<JSONObject> {
    private JSONObject a;

    public zzcwb(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.a);
        } catch (JSONException unused) {
            zzawz.m("Unable to get cache_state");
        }
    }
}
