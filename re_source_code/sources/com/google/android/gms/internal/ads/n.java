package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class n extends zzacj<Long> {
    n(int i2, String str, Long l) {
        super(i2, str, l, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long h(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(a(), n().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long i(Bundle bundle) {
        String strValueOf = String.valueOf(a());
        if (!bundle.containsKey(strValueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf) : new String("com.google.android.gms.ads.flag."))) {
            return n();
        }
        String strValueOf2 = String.valueOf(a());
        return Long.valueOf(bundle.getLong(strValueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(strValueOf2) : new String("com.google.android.gms.ads.flag.")));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long j(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(a(), n().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void k(SharedPreferences.Editor editor, Long l) {
        editor.putLong(a(), l.longValue());
    }
}
