package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zze implements zzbal {
    static final zzbal zzbqz = new zze();

    private zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) throws JSONException {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzk.zzlk().r().c(jSONObject.getString("appSettingsJson"));
        }
        return zzbar.o(null);
    }
}
