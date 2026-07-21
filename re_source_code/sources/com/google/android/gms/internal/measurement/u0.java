package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u0 extends zzcl<Double> {
    u0(zzcr zzcrVar, String str, Double d2) {
        super(zzcrVar, str, d2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzcl
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final Double e(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String strM = super.m();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strM).length() + 27 + strValueOf.length());
        sb.append("Invalid double value for ");
        sb.append(strM);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
