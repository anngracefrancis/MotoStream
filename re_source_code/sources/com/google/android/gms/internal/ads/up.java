package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class up implements zzcuz {
    static final zzcuz a = new up();

    private up() {
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final void a(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
