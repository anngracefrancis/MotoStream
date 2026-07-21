package kotlin.reflect.y.internal.j0.m.u;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.m;
import kotlin.text.v;

/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final String a(String str) {
        m.f(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if ('a' <= cCharAt && cCharAt < '{') {
            z = true;
        }
        if (!z) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        String strSubstring = str.substring(1);
        m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return upperCase + strSubstring;
    }

    public static final String b(String str) {
        m.f(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if ('A' <= cCharAt && cCharAt < '[') {
            z = true;
        }
        if (!z) {
            return str;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        String strSubstring = str.substring(1);
        m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return lowerCase + strSubstring;
    }

    public static final String c(String str, boolean z) {
        Integer next;
        m.f(str, "<this>");
        if ((str.length() == 0) || !d(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z)) {
            if (z) {
                return b(str);
            }
            if (!(str.length() > 0)) {
                return str;
            }
            char lowerCase = Character.toLowerCase(str.charAt(0));
            String strSubstring = str.substring(1);
            m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            return lowerCase + strSubstring;
        }
        Iterator<Integer> it = v.P(str).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(!d(str, next.intValue(), z)));
        Integer num = next;
        if (num == null) {
            return e(str, z);
        }
        int iIntValue = num.intValue() - 1;
        StringBuilder sb = new StringBuilder();
        String strSubstring2 = str.substring(0, iIntValue);
        m.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(e(strSubstring2, z));
        String strSubstring3 = str.substring(iIntValue);
        m.e(strSubstring3, "this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring3);
        return sb.toString();
    }

    private static final boolean d(String str, int i2, boolean z) {
        char cCharAt = str.charAt(i2);
        if (z) {
            return 'A' <= cCharAt && cCharAt < '[';
        }
        return Character.isUpperCase(cCharAt);
    }

    private static final String e(String str, boolean z) {
        if (z) {
            return f(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public static final String f(String str) {
        m.f(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ('A' <= cCharAt && cCharAt < '[') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        m.e(string, "builder.toString()");
        return string;
    }
}
