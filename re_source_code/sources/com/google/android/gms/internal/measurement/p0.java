package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class p0 {
    private final Map<String, Map<String, String>> a;

    p0(Map<String, Map<String, String>> map) {
        this.a = map;
    }

    static p0 a() {
        return new p0(null);
    }

    final String b(Uri uri, String str, String str2, String str3) {
        if (this.a == null) {
            return null;
        }
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map<String, String> map = this.a.get(str);
        if (map == null) {
            return null;
        }
        if (str2 != null) {
            String strValueOf = String.valueOf(str3);
            str3 = strValueOf.length() != 0 ? str2.concat(strValueOf) : new String(str2);
        }
        return map.get(str3);
    }
}
