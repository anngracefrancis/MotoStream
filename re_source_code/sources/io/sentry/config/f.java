package io.sentry.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PropertiesProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f {
    public static Boolean a(g _this, String str) {
        String strB = _this.b(str);
        if (strB != null) {
            return Boolean.valueOf(strB);
        }
        return null;
    }

    public static Double b(g _this, String str) {
        String strB = _this.b(str);
        if (strB != null) {
            try {
                return Double.valueOf(strB);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static List c(g _this, String str) {
        String strB = _this.b(str);
        return strB != null ? Arrays.asList(strB.split(",")) : Collections.emptyList();
    }

    public static Long d(g _this, String str) {
        String strB = _this.b(str);
        if (strB != null) {
            try {
                return Long.valueOf(strB);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String e(g _this, String str, String str2) {
        String strB = _this.b(str);
        return strB != null ? strB : str2;
    }
}
