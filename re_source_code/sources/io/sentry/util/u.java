package io.sentry.util;

import io.sentry.s4;
import io.sentry.w1;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class u {
    private static final Charset a = Charset.forName("UTF-8");

    public static String a(String str, w1 w1Var) {
        if (str != null && !str.isEmpty()) {
            try {
                return new StringBuilder(new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(str.getBytes(a))).toString(16)).toString();
            } catch (NoSuchAlgorithmException e2) {
                w1Var.b(s4.INFO, "SHA-1 isn't available to calculate the hash.", e2);
            } catch (Throwable th) {
                w1Var.c(s4.INFO, "string: %s could not calculate its hash", th, str);
            }
        }
        return null;
    }

    public static String b(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        Locale locale = Locale.ROOT;
        sb.append(strSubstring.toUpperCase(locale));
        sb.append(str.substring(1).toLowerCase(locale));
        return sb.toString();
    }

    public static String c(String str) {
        int i2;
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        return (iLastIndexOf < 0 || str.length() <= (i2 = iLastIndexOf + 1)) ? str : str.substring(i2);
    }

    public static String d(String str) {
        return str.equals("0000-0000") ? "00000000-0000-0000-0000-000000000000" : str;
    }

    public static String e(String str, String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }

    public static String f(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }
}
