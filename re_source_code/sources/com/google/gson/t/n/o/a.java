package com.google.gson.t.n.o;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ISO8601Utils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final TimeZone a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    private static int b(String str, int i2) {
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d6 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0181 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01b4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x0107, please report this as an issue */
    public static Date c(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i2;
        int i3;
        int i4;
        int iD;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int iD2 = d(str, index, i5);
            if (a(str, i5, '-')) {
                i5++;
            }
            int i6 = i5 + 2;
            int iD3 = d(str, i5, i6);
            if (a(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int iD4 = d(str, i6, i7);
            boolean zA = a(str, i7, 'T');
            if (!zA && str.length() <= i7) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iD2, iD3 - 1, iD4);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i8 = i7 + 1;
                int i9 = i8 + 2;
                int iD5 = d(str, i8, i9);
                if (a(str, i9, ':')) {
                    i9++;
                }
                int i10 = i9 + 2;
                int iD6 = d(str, i9, i10);
                if (a(str, i10, ':')) {
                    i10++;
                }
                if (str.length() <= i10 || (cCharAt2 = str.charAt(i10)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i3 = iD6;
                    i4 = 0;
                    i2 = iD5;
                    i7 = i10;
                } else {
                    int i11 = i10 + 2;
                    iD = d(str, i10, i11);
                    if (iD > 59 && iD < 63) {
                        iD = 59;
                    }
                    if (a(str, i11, '.')) {
                        int i12 = i11 + 1;
                        int iB = b(str, i12 + 1);
                        int iMin = Math.min(iB, i12 + 3);
                        int iD7 = d(str, i12, iMin);
                        int i13 = iMin - i12;
                        if (i13 == 1) {
                            iD7 *= 100;
                        } else if (i13 == 2) {
                            iD7 *= 10;
                        }
                        i3 = iD6;
                        i4 = iD7;
                        i2 = iD5;
                        i7 = iB;
                    } else {
                        i3 = iD6;
                        i2 = iD5;
                        i7 = i11;
                        i4 = 0;
                    }
                }
                if (str.length() > i7) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i7);
                if (cCharAt == 'Z') {
                    timeZone = a;
                    length = i7 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i7);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i7 + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = a;
                    } else {
                        String str3 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                        String id = timeZone2.getID();
                        if (!id.equals(str3) && !id.replace(":", HttpUrl.FRAGMENT_ENCODE_SET).equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, iD2);
                gregorianCalendar2.set(2, iD3 - 1);
                gregorianCalendar2.set(5, iD4);
                gregorianCalendar2.set(11, i2);
                gregorianCalendar2.set(12, i3);
                gregorianCalendar2.set(13, iD);
                gregorianCalendar2.set(14, i4);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i2 = 0;
            i3 = 0;
            i4 = 0;
            iD = 0;
            if (str.length() > i7) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i7);
            if (cCharAt == 'Z') {
                timeZone = a;
                length = i7 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i7);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i7 + strSubstring.length();
                if ("+0000".equals(strSubstring)) {
                    timeZone = a;
                } else {
                    timeZone = a;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, iD2);
            gregorianCalendar3.set(2, iD3 - 1);
            gregorianCalendar3.set(5, iD4);
            gregorianCalendar3.set(11, i2);
            gregorianCalendar3.set(12, i3);
            gregorianCalendar3.set(13, iD);
            gregorianCalendar3.set(14, i4);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e2) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = '\"' + str + '\"';
            }
            String message = e2.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e2.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e2);
            throw parseException;
        }
    }

    private static int d(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -iDigit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int iDigit2 = Character.digit(str.charAt(i4), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - iDigit2;
            i4 = i6;
        }
        return -i5;
    }
}
