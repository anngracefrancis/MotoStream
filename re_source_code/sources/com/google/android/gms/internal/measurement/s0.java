package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class s0 extends zzcl<Long> {
    s0(zzcr zzcrVar, String str, Long l) {
        super(zzcrVar, str, l, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcl
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final Long e(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String strM = super.m();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strM).length() + 25 + strValueOf.length());
        sb.append("Invalid long value for ");
        sb.append(strM);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
