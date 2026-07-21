package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcvn implements zzcuz<JSONObject> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdvertisingIdClient.Info f15683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15684c;

    public zzcvn(AdvertisingIdClient.Info info, Context context, String str) {
        this.a = context;
        this.f15683b = info;
        this.f15684c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectK = zzazc.k(jSONObject, "pii");
            String id = null;
            boolean zIsLimitAdTrackingEnabled = false;
            AdvertisingIdClient.Info info = this.f15683b;
            if (info != null) {
                id = info.getId();
                zIsLimitAdTrackingEnabled = this.f15683b.isLimitAdTrackingEnabled();
            }
            if (TextUtils.isEmpty(id)) {
                jSONObjectK.put("pdid", this.f15684c);
                jSONObjectK.put("pdidtype", "ssaid");
            } else {
                jSONObjectK.put("rdid", id);
                jSONObjectK.put("is_lat", zIsLimitAdTrackingEnabled);
                jSONObjectK.put("idtype", "adid");
            }
        } catch (JSONException e2) {
            zzawz.l("Failed putting Ad ID.", e2);
        }
    }
}
