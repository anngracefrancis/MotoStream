package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class NumberInput {
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    private static NumberFormatException _badBD(String str) {
        return new NumberFormatException("Value \"" + str + "\" can not be represented as BigDecimal");
    }

    public static boolean inLongRange(char[] cArr, int i2, int i3, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i3 < length) {
            return true;
        }
        if (i3 > length) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            int iCharAt = cArr[i2 + i4] - str.charAt(i4);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static int parseAsInt(String str, int i2) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i2;
        }
        int i3 = 0;
        if (length > 0) {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i3 = 1;
            }
        }
        while (i3 < length) {
            char cCharAt2 = strTrim.charAt(i3);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return i2;
                }
            }
            i3++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i2;
        }
    }

    public static long parseAsLong(String str, long j2) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j2;
        }
        int i2 = 0;
        if (length > 0) {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i2 = 1;
            }
        }
        while (i2 < length) {
            char cCharAt2 = strTrim.charAt(i2);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (long) parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return j2;
                }
            }
            i2++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j2;
        }
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException unused) {
            throw _badBD(str);
        }
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static int parseInt(char[] cArr, int i2, int i3) {
        int i4 = cArr[i2] - '0';
        if (i3 > 4) {
            int i5 = i2 + 1;
            int i6 = ((i4 * 10) + (cArr[i5] - '0')) * 10;
            int i7 = i5 + 1;
            int i8 = (i6 + (cArr[i7] - '0')) * 10;
            int i9 = i7 + 1;
            int i10 = (i8 + (cArr[i9] - '0')) * 10;
            i2 = i9 + 1;
            i4 = i10 + (cArr[i2] - '0');
            i3 -= 4;
            if (i3 > 4) {
                int i11 = i2 + 1;
                int i12 = ((i4 * 10) + (cArr[i11] - '0')) * 10;
                int i13 = i11 + 1;
                int i14 = (i12 + (cArr[i13] - '0')) * 10;
                int i15 = i13 + 1;
                return ((i14 + (cArr[i15] - '0')) * 10) + (cArr[i15 + 1] - '0');
            }
        }
        if (i3 <= 1) {
            return i4;
        }
        int i16 = i2 + 1;
        int i17 = (i4 * 10) + (cArr[i16] - '0');
        if (i3 <= 2) {
            return i17;
        }
        int i18 = i16 + 1;
        int i19 = (i17 * 10) + (cArr[i18] - '0');
        return i3 > 3 ? (i19 * 10) + (cArr[i18 + 1] - '0') : i19;
    }

    public static long parseLong(char[] cArr, int i2, int i3) {
        int i4 = i3 - 9;
        return (((long) parseInt(cArr, i2, i4)) * 1000000000) + ((long) parseInt(cArr, i2 + i4, 9));
    }

    public static BigDecimal parseBigDecimal(char[] cArr) throws NumberFormatException {
        return parseBigDecimal(cArr, 0, cArr.length);
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            int iCharAt = str.charAt(i2) - str2.charAt(i2);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static BigDecimal parseBigDecimal(char[] cArr, int i2, int i3) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i2, i3);
        } catch (NumberFormatException unused) {
            throw _badBD(new String(cArr, i2, i3));
        }
    }

    public static int parseInt(String str) {
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i2 = 1;
        boolean z = cCharAt == '-';
        if (z) {
            if (length != 1 && length <= 10) {
                cCharAt = str.charAt(1);
                i2 = 2;
            } else {
                return Integer.parseInt(str);
            }
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (cCharAt > '9' || cCharAt < '0') {
            return Integer.parseInt(str);
        }
        int i3 = cCharAt - '0';
        if (i2 < length) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return Integer.parseInt(str);
            }
            i3 = (i3 * 10) + (cCharAt2 - '0');
            if (i4 < length) {
                int i5 = i4 + 1;
                char cCharAt3 = str.charAt(i4);
                if (cCharAt3 > '9' || cCharAt3 < '0') {
                    return Integer.parseInt(str);
                }
                i3 = (i3 * 10) + (cCharAt3 - '0');
                if (i5 < length) {
                    while (true) {
                        int i6 = i5 + 1;
                        char cCharAt4 = str.charAt(i5);
                        if (cCharAt4 > '9' || cCharAt4 < '0') {
                            break;
                        }
                        i3 = (i3 * 10) + (cCharAt4 - '0');
                        if (i6 < length) {
                            i5 = i6;
                        }
                    }
                    return Integer.parseInt(str);
                }
            }
        }
        return z ? -i3 : i3;
    }
}
