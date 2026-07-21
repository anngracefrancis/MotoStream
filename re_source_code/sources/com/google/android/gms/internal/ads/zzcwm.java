package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwm implements zzcuz<JSONObject> {
    private List<String> a;

    public zzcwm(List<String> list) {
        this.a = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.a));
        } catch (JSONException unused) {
            zzawz.m("Failed putting experiment ids.");
        }
    }
}
