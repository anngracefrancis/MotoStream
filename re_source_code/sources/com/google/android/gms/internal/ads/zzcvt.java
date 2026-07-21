package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvt implements zzcuz<JSONObject> {
    private final String a;

    public zzcvt(String str) {
        this.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.a);
        } catch (JSONException e2) {
            zzawz.l("Failed putting Ad ID.", e2);
        }
    }
}
