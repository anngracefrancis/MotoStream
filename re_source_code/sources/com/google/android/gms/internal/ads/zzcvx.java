package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvx implements zzcuz<JSONObject> {
    private final JSONObject a;

    public zzcvx(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectK = zzazc.k(jSONObject, "content_info");
            JSONObject jSONObject2 = this.a;
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObjectK.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzawz.m("Failed putting app indexing json.");
        }
    }
}
