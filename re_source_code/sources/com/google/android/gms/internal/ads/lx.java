package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
abstract class lx {
    lx() {
    }

    static void d(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i2, (byte) cCharAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        if (i2 == length) {
            byteBuffer.position(iPosition + i2);
            return;
        }
        iPosition += i2;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 < 128) {
                byteBuffer.put(iPosition, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i3 = iPosition + 1;
                try {
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                    byteBuffer.put(i3, (byte) ((cCharAt2 & '?') | 128));
                    iPosition = i3;
                } catch (IndexOutOfBoundsException unused2) {
                    iPosition = i3;
                }
            } else {
                if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                    int i4 = i2 + 1;
                    if (i4 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                int i5 = iPosition + 1;
                                try {
                                    byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                    iPosition = i5 + 1;
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    i5 = iPosition + 1;
                                    byteBuffer.put(iPosition, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i5, (byte) ((codePoint & 63) | 128));
                                    iPosition = i5;
                                    i2 = i4;
                                } catch (IndexOutOfBoundsException unused3) {
                                    iPosition = i5;
                                }
                            } else {
                                i2 = i4;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                        }
                        i2 = i4;
                        int iPosition2 = byteBuffer.position() + Math.max(i2, (iPosition - byteBuffer.position()) + 1);
                        char cCharAt4 = charSequence.charAt(i2);
                        StringBuilder sb = new StringBuilder(37);
                        sb.append("Failed writing ");
                        sb.append(cCharAt4);
                        sb.append(" at index ");
                        sb.append(iPosition2);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                    throw new nx(i2, length);
                }
                int i6 = iPosition + 1;
                byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                iPosition = i6 + 1;
                byteBuffer.put(i6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
            }
            i2++;
            iPosition++;
        }
        byteBuffer.position(iPosition);
    }

    abstract int a(int i2, byte[] bArr, int i3, int i4);

    abstract int b(CharSequence charSequence, byte[] bArr, int i2, int i3);

    abstract void c(CharSequence charSequence, ByteBuffer byteBuffer);

    final boolean e(byte[] bArr, int i2, int i3) {
        return a(0, bArr, i2, i3) == 0;
    }

    abstract String f(byte[] bArr, int i2, int i3) throws zzdok;
}
