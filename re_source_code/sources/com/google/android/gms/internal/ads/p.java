package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class p extends zzacj<String> {
    p(int i2, String str, String str2) {
        super(i2, str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String h(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(a(), n());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String i(Bundle bundle) {
        String strValueOf = String.valueOf(a());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return n();
        }
        String strValueOf2 = String.valueOf(a());
        return bundle.getString(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag."));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String j(JSONObject jSONObject) {
        return jSONObject.optString(a(), n());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, String str) {
        editor.putString(a(), str);
    }
}
