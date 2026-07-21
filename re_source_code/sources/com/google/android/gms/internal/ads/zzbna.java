package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbna {
    public static JSONObject a(zzcxm zzcxmVar) {
        try {
            return new JSONObject(zzcxmVar.w);
        } catch (JSONException unused) {
            return null;
        }
    }
}
