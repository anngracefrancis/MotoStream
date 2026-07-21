package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class o extends zzacj<Float> {
    o(int i2, String str, Float f2) {
        super(i2, str, f2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float h(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(a(), n().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float i(Bundle bundle) {
        String strValueOf = String.valueOf(a());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return n();
        }
        String strValueOf2 = String.valueOf(a());
        return Float.valueOf(bundle.getFloat(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float j(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(a(), n().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Float f2) {
        editor.putFloat(a(), f2.floatValue());
    }
}
