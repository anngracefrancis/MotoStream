package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v0 extends zzcl<Boolean> {
    v0(zzcr zzcrVar, String str, Boolean bool) {
        super(zzcrVar, str, bool, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcl
    final /* synthetic */ Boolean e(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzbw.f17325c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzbw.f17326d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String strM = super.m();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strM).length() + 28 + strValueOf.length());
        sb.append("Invalid boolean value for ");
        sb.append(strM);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
