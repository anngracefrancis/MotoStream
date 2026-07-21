package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class vj implements zzalm<zzcir> {
    vj() {
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final /* synthetic */ JSONObject b(zzcir zzcirVar) throws JSONException {
        zzcir zzcirVar2 = zzcirVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcirVar2.f15271d.b());
        jSONObject2.put("signals", zzcirVar2.f15270c);
        jSONObject3.put("body", zzcirVar2.f15269b.f15281c);
        jSONObject3.put("headers", zzk.zzlg().Y(zzcirVar2.f15269b.f15280b));
        jSONObject3.put("response_code", zzcirVar2.f15269b.a);
        jSONObject3.put("latency", zzcirVar2.f15269b.f15282d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcirVar2.f15271d.e());
        return jSONObject;
    }
}
