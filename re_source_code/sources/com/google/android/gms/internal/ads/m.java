package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class m extends zzacj<Integer> {
    m(int i2, String str, Integer num) {
        super(i2, str, num, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer h(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(a(), n().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer i(Bundle bundle) {
        String strValueOf = String.valueOf(a());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return n();
        }
        String strValueOf2 = String.valueOf(a());
        return Integer.valueOf(bundle.getInt(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer j(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(a(), n().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(a(), num.intValue());
    }
}
