package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class l extends zzacj<Boolean> {
    l(int i2, String str, Boolean bool) {
        super(i2, str, bool, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Boolean h(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(a(), n().booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Boolean i(Bundle bundle) {
        String strValueOf = String.valueOf(a());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return n();
        }
        String strValueOf2 = String.valueOf(a());
        return Boolean.valueOf(bundle.getBoolean(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Boolean j(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(a(), n().booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(a(), bool.booleanValue());
    }
}
