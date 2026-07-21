package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: StringNumberConversions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", HttpUrl.FRAGMENT_ENCODE_SET, "input", HttpUrl.FRAGMENT_ENCODE_SET, "toByteOrNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
public class t extends s {
    public static Integer j(String str) {
        m.f(str, "<this>");
        return k(str, 10);
    }

    public static final Integer k(String str, int i2) {
        boolean z;
        int i3;
        m.f(str, "<this>");
        b.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (m.h(cCharAt, 48) >= 0) {
            z = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int iB = b.b(str.charAt(i6), i2);
            if (iB < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + iB) {
                return null;
            }
            i4 = i3 - iB;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long l(String str) {
        m.f(str, "<this>");
        return m(str, 10);
    }

    public static final Long m(String str, int i2) {
        m.f(str, "<this>");
        b.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        boolean z = true;
        if (m.h(cCharAt, 48) >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j2 = Long.MIN_VALUE;
                i3 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i3 = 1;
                z = false;
            }
        }
        long j3 = -256204778801521550L;
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i3 < length) {
            int iB = b.b(str.charAt(i3), i2);
            if (iB < 0) {
                return null;
            }
            if (j4 < j5) {
                if (j5 == j3) {
                    j5 = j2 / ((long) i2);
                    if (j4 < j5) {
                    }
                }
                return null;
            }
            long j6 = j4 * ((long) i2);
            long j7 = iB;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i3++;
            j3 = -256204778801521550L;
        }
        return z ? Long.valueOf(j4) : Long.valueOf(-j4);
    }
}
