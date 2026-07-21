package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwt implements zzcuz<JSONObject> {
    private Bundle a;

    public zzcwt(Bundle bundle) {
        this.a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.a != null) {
            try {
                zzazc.k(zzazc.k(jSONObject2, "device"), "play_store").put("parental_controls", zzk.zzlg().N(this.a));
            } catch (JSONException unused) {
                zzawz.m("Failed putting parental controls bundle.");
            }
        }
    }
}
