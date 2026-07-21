package com.google.android.gms.internal.ads;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcwp implements zzcuz<JSONObject> {
    private final Location a;

    public zzcwp(Location location) {
        this.a = location;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (this.a != null) {
                JSONObject jSONObject3 = new JSONObject();
                Float fValueOf = Float.valueOf(this.a.getAccuracy() * 1000.0f);
                Long lValueOf = Long.valueOf(this.a.getTime() * 1000);
                Long lValueOf2 = Long.valueOf((long) (this.a.getLatitude() * 1.0E7d));
                Long lValueOf3 = Long.valueOf((long) (this.a.getLongitude() * 1.0E7d));
                jSONObject3.put("radius", fValueOf);
                jSONObject3.put("lat", lValueOf2);
                jSONObject3.put("long", lValueOf3);
                jSONObject3.put("time", lValueOf);
                jSONObject2.put("uule", jSONObject3);
            }
        } catch (JSONException e2) {
            zzawz.l("Failed adding location to the request JSON.", e2);
        }
    }
}
