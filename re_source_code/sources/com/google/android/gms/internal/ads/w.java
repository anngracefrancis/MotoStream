package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
final class w extends zzadc {
    w() {
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 0;
        int length = str.length();
        while (i2 < str.length() && str.charAt(i2) == ',') {
            i2++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i2) {
            return null;
        }
        return (i2 == 0 && length == str.length()) ? str : str.substring(i2, length);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final String a(String str, String str2) {
        String strB = b(str);
        String strB2 = b(str2);
        if (TextUtils.isEmpty(strB)) {
            return strB2;
        }
        if (TextUtils.isEmpty(strB2)) {
            return strB;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 1 + String.valueOf(strB2).length());
        sb.append(strB);
        sb.append(",");
        sb.append(strB2);
        return sb.toString();
    }
}
