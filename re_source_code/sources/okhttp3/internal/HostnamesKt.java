package okhttp3.internal;

import j.f;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: hostnames.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u001a\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "toCanonicalHost", "(Ljava/lang/String;)Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "containsInvalidHostnameAsciiCodes", "(Ljava/lang/String;)Z", "input", HttpUrl.FRAGMENT_ENCODE_SET, "pos", "limit", "Ljava/net/InetAddress;", "decodeIpv6", "(Ljava/lang/String;II)Ljava/net/InetAddress;", HttpUrl.FRAGMENT_ENCODE_SET, "address", "addressOffset", "decodeIpv4Suffix", "(Ljava/lang/String;II[BI)Z", "inet6AddressToAscii", "([B)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (m.h(cCharAt, 31) <= 0 || m.h(cCharAt, 127) >= 0 || v.V(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = str.charAt(i6);
                if (m.h(cCharAt, 48) < 0 || m.h(cCharAt, 57) > 0) {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076 A[LOOP:1: B:30:0x0069->B:34:0x0076, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x007c A[EDGE_INSN: B:55:0x007c->B:35:0x007c BREAK  A[LOOP:1: B:30:0x0069->B:34:0x0076], SYNTHETIC] */
    private static final InetAddress decodeIpv6(String str, int i2, int i3) {
        int i4;
        int i5;
        int hexDigit;
        byte[] bArr = new byte[16];
        int i6 = i2;
        int i7 = 0;
        int i8 = -1;
        int i9 = -1;
        while (i6 < i3) {
            if (i7 == 16) {
                return null;
            }
            int i10 = i6 + 2;
            if (i10 <= i3 && u.D(str, "::", i6, false, 4, null)) {
                if (i8 != -1) {
                    return null;
                }
                i7 += 2;
                if (i10 == i3) {
                    i8 = i7;
                    break;
                }
                i9 = i10;
                i8 = i7;
                i6 = i9;
                i4 = 0;
                while (i6 < i3) {
                    hexDigit = Util.parseHexDigit(str.charAt(i6));
                    if (hexDigit == -1) {
                        break;
                        break;
                    }
                    i4 = (i4 << 4) + hexDigit;
                    i6++;
                }
                i5 = i6 - i9;
                if (i5 != 0) {
                }
                return null;
            }
            if (i7 != 0) {
                if (!u.D(str, ":", i6, false, 4, null)) {
                    if (!u.D(str, ".", i6, false, 4, null) || !decodeIpv4Suffix(str, i9, i3, bArr, i7 - 2)) {
                        return null;
                    }
                    i7 += 2;
                    break;
                }
                i6++;
            }
            i9 = i6;
            i6 = i9;
            i4 = 0;
            while (i6 < i3) {
                hexDigit = Util.parseHexDigit(str.charAt(i6));
                if (hexDigit == -1) {
                    break;
                }
                i4 = (i4 << 4) + hexDigit;
                i6++;
            }
            i5 = i6 - i9;
            if (i5 != 0 || i5 > 4) {
                return null;
            }
            int i11 = i7 + 1;
            bArr[i7] = (byte) ((i4 >>> 8) & 255);
            i7 = i11 + 1;
            bArr[i11] = (byte) (i4 & 255);
        }
        if (i7 != 16) {
            if (i8 == -1) {
                return null;
            }
            int i12 = i7 - i8;
            System.arraycopy(bArr, i8, bArr, 16 - i12, i12);
            Arrays.fill(bArr, i8, (16 - i7) + i8, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        f fVar = new f();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                fVar.writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    fVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    fVar.writeByte(58);
                }
                fVar.C0((Util.and(bArr[i2], 255) << 8) | Util.and(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return fVar.T();
    }

    public static final String toCanonicalHost(String str) {
        m.f(str, "$this$toCanonicalHost");
        if (!v.J(str, ":", false, 2, null)) {
            try {
                String ascii = IDN.toASCII(str);
                m.e(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                m.e(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (!(lowerCase.length() == 0) && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (u.E(str, "[", false, 2, null) && u.p(str, "]", false, 2, null)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length == 16) {
            m.e(address, "address");
            return inet6AddressToAscii(address);
        }
        if (address.length == 4) {
            return inetAddressDecodeIpv6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
