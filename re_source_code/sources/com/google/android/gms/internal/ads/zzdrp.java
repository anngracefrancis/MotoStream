package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdrp {
    private final ByteBuffer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzdni f16070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16071c;

    private zzdrp(byte[] bArr, int i2, int i3) {
        this(ByteBuffer.wrap(bArr, i2, i3));
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 2048) {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char cCharAt2 = charSequence.charAt(i3);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i3);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
                break;
            }
            i4 += (127 - cCharAt) >>> 31;
            i3++;
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = ((long) i4) + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int d(int i2, int i3) {
        return o(i2) + p(i3);
    }

    public static zzdrp e(byte[] bArr) {
        return v(bArr, 0, bArr.length);
    }

    public static int g(int i2, zzdrw zzdrwVar) {
        int iO = o(i2);
        int iC = zzdrwVar.c();
        return iO + q(iC) + iC;
    }

    public static int h(int i2, byte[] bArr) {
        return o(i2) + q(bArr.length) + bArr.length;
    }

    private static void i(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        char cCharAt;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i4 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i4 < length) {
                char cCharAt2 = charSequence.charAt(i4);
                if (cCharAt2 < 128) {
                    byteBuffer.put((byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    byteBuffer.put((byte) ((cCharAt2 >>> 6) | 960));
                    byteBuffer.put((byte) ((cCharAt2 & '?') | 128));
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i5 = i4 + 1;
                        if (i5 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        StringBuilder sb = new StringBuilder(39);
                        sb.append("Unpaired surrogate at index ");
                        sb.append(i4 - 1);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    byteBuffer.put((byte) ((cCharAt2 >>> '\f') | 480));
                    byteBuffer.put((byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((cCharAt2 & '?') | 128));
                }
                i4++;
            }
            return;
        }
        try {
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i6 = iRemaining + iArrayOffset;
            while (i4 < length2) {
                int i7 = i4 + iArrayOffset;
                if (i7 >= i6 || (cCharAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                bArrArray[i7] = (byte) cCharAt;
                i4++;
            }
            if (i4 == length2) {
                i2 = iArrayOffset + length2;
            } else {
                i2 = iArrayOffset + i4;
                while (i4 < length2) {
                    char cCharAt4 = charSequence.charAt(i4);
                    if (cCharAt4 >= 128 || i2 >= i6) {
                        if (cCharAt4 < 2048 && i2 <= i6 - 2) {
                            int i8 = i2 + 1;
                            bArrArray[i2] = (byte) ((cCharAt4 >>> 6) | 960);
                            i2 = i8 + 1;
                            bArrArray[i8] = (byte) ((cCharAt4 & '?') | 128);
                        } else {
                            if ((cCharAt4 >= 55296 && 57343 >= cCharAt4) || i2 > i6 - 3) {
                                if (i2 > i6 - 4) {
                                    StringBuilder sb2 = new StringBuilder(37);
                                    sb2.append("Failed writing ");
                                    sb2.append(cCharAt4);
                                    sb2.append(" at index ");
                                    sb2.append(i2);
                                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                }
                                int i9 = i4 + 1;
                                if (i9 != charSequence.length()) {
                                    char cCharAt5 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(cCharAt4, cCharAt5)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt4, cCharAt5);
                                        int i10 = i2 + 1;
                                        bArrArray[i2] = (byte) ((codePoint2 >>> 18) | 240);
                                        int i11 = i10 + 1;
                                        bArrArray[i10] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                        int i12 = i11 + 1;
                                        bArrArray[i11] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                        i2 = i12 + 1;
                                        bArrArray[i12] = (byte) ((codePoint2 & 63) | 128);
                                        i4 = i9;
                                    } else {
                                        i4 = i9;
                                    }
                                }
                                StringBuilder sb3 = new StringBuilder(39);
                                sb3.append("Unpaired surrogate at index ");
                                sb3.append(i4 - 1);
                                throw new IllegalArgumentException(sb3.toString());
                            }
                            int i13 = i2 + 1;
                            bArrArray[i2] = (byte) ((cCharAt4 >>> '\f') | 480);
                            int i14 = i13 + 1;
                            bArrArray[i13] = (byte) (((cCharAt4 >>> 6) & 63) | 128);
                            i3 = i14 + 1;
                            bArrArray[i14] = (byte) ((cCharAt4 & '?') | 128);
                        }
                        i4++;
                    } else {
                        i3 = i2 + 1;
                        bArrArray[i2] = (byte) cCharAt4;
                    }
                    i2 = i3;
                    i4++;
                }
            }
            byteBuffer.position(i2 - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e2) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e2);
            throw bufferOverflowException;
        }
    }

    public static int m(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int n(int i2, String str) {
        return o(i2) + r(str);
    }

    public static int o(int i2) {
        return q(i2 << 3);
    }

    public static int p(int i2) {
        if (i2 >= 0) {
            return q(i2);
        }
        return 10;
    }

    private static int q(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int r(String str) {
        int iA = a(str);
        return q(iA) + iA;
    }

    private final void s(int i2) throws IOException {
        byte b2 = (byte) i2;
        if (!this.a.hasRemaining()) {
            throw new zzdrq(this.a.position(), this.a.limit());
        }
        this.a.put(b2);
    }

    private final void t(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            s((i2 & 127) | 128);
            i2 >>>= 7;
        }
        s(i2);
    }

    public static zzdrp v(byte[] bArr, int i2, int i3) {
        return new zzdrp(bArr, 0, i3);
    }

    public final void b(int i2, zzdrw zzdrwVar) throws IOException {
        w(i2, 2);
        if (zzdrwVar.a < 0) {
            zzdrwVar.c();
        }
        t(zzdrwVar.a);
        zzdrwVar.a(this);
    }

    public final void c(int i2, byte[] bArr) throws IOException {
        w(i2, 2);
        t(bArr.length);
        int length = bArr.length;
        if (this.a.remaining() < length) {
            throw new zzdrq(this.a.position(), this.a.limit());
        }
        this.a.put(bArr, 0, length);
    }

    public final void f() {
        if (this.a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.a.remaining())));
        }
    }

    public final void j(int i2, zzdpk zzdpkVar) throws IOException {
        if (this.f16070b == null) {
            this.f16070b = zzdni.E0(this.a);
            this.f16071c = this.a.position();
        } else if (this.f16071c != this.a.position()) {
            this.f16070b.c(this.a.array(), this.f16071c, this.a.position() - this.f16071c);
            this.f16071c = this.a.position();
        }
        zzdni zzdniVar = this.f16070b;
        zzdniVar.h(i2, zzdpkVar);
        zzdniVar.b();
        this.f16071c = this.a.position();
    }

    public final void k(int i2, String str) throws IOException {
        w(i2, 2);
        try {
            int iQ = q(str.length());
            if (iQ != q(str.length() * 3)) {
                t(a(str));
                i(str, this.a);
                return;
            }
            int iPosition = this.a.position();
            if (this.a.remaining() < iQ) {
                throw new zzdrq(iPosition + iQ, this.a.limit());
            }
            this.a.position(iPosition + iQ);
            i(str, this.a);
            int iPosition2 = this.a.position();
            this.a.position(iPosition);
            t((iPosition2 - iPosition) - iQ);
            this.a.position(iPosition2);
        } catch (BufferOverflowException e2) {
            zzdrq zzdrqVar = new zzdrq(this.a.position(), this.a.limit());
            zzdrqVar.initCause(e2);
            throw zzdrqVar;
        }
    }

    public final void l(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            s((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        s((int) j2);
    }

    public final void u(int i2, boolean z) throws IOException {
        w(3, 0);
        byte b2 = z ? (byte) 1 : (byte) 0;
        if (!this.a.hasRemaining()) {
            throw new zzdrq(this.a.position(), this.a.limit());
        }
        this.a.put(b2);
    }

    public final void w(int i2, int i3) throws IOException {
        t((i2 << 3) | i3);
    }

    public final void x(int i2, int i3) throws IOException {
        w(i2, 0);
        if (i3 >= 0) {
            t(i3);
        } else {
            l(i3);
        }
    }

    private zzdrp(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
}
