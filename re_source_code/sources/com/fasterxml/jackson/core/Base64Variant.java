package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Base64Variant implements Serializable {
    private final transient int[] _asciiToBase64;
    private final transient byte[] _base64ToAsciiB;
    private final transient char[] _base64ToAsciiC;
    private final transient int _maxLineLength;
    final String _name;
    private final transient char _paddingChar;
    private final transient boolean _usesPadding;

    public Base64Variant(String str, String str2, boolean z, char c2, int i2) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        this._base64ToAsciiB = new byte[64];
        this._name = str;
        this._usesPadding = z;
        this._paddingChar = c2;
        this._maxLineLength = i2;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < length; i3++) {
            char c3 = this._base64ToAsciiC[i3];
            this._base64ToAsciiB[i3] = (byte) c3;
            this._asciiToBase64[c3] = i3;
        }
        if (z) {
            this._asciiToBase64[c2] = -2;
        }
    }

    protected void _reportBase64EOF() throws IllegalArgumentException {
        throw new IllegalArgumentException("Unexpected end-of-String in base64 content");
    }

    protected void _reportInvalidBase64(char c2, int i2, String str) throws IllegalArgumentException {
        String str2;
        if (c2 <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c2) + ") as character #" + (i2 + 1) + " of 4-char base64 unit: can only used between units";
        } else if (usesPaddingChar(c2)) {
            str2 = "Unexpected padding character ('" + getPaddingChar() + "') as character #" + (i2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        } else if (!Character.isDefined(c2) || Character.isISOControl(c2)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c2) + ") in base64 content";
        } else {
            str2 = "Illegal character '" + c2 + "' (code 0x" + Integer.toHexString(c2) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw new IllegalArgumentException(str2);
    }

    public byte[] decode(String str) throws IllegalArgumentException {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        decode(str, byteArrayBuilder);
        return byteArrayBuilder.toByteArray();
    }

    public int decodeBase64Char(char c2) {
        if (c2 <= 127) {
            return this._asciiToBase64[c2];
        }
        return -1;
    }

    public String encode(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int maxLineLength = getMaxLineLength() >> 2;
        int i2 = 0;
        int i3 = length - 3;
        while (i2 <= i3) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] << 8) | (bArr[i4] & 255)) << 8;
            int i7 = i5 + 1;
            encodeBase64Chunk(sb, i6 | (bArr[i5] & 255));
            maxLineLength--;
            if (maxLineLength <= 0) {
                sb.append('\\');
                sb.append('n');
                maxLineLength = getMaxLineLength() >> 2;
            }
            i2 = i7;
        }
        int i8 = length - i2;
        if (i8 > 0) {
            int i9 = i2 + 1;
            int i10 = bArr[i2] << 16;
            if (i8 == 2) {
                i10 |= (bArr[i9] & 255) << 8;
            }
            encodeBase64Partial(sb, i10, i8);
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public int encodeBase64Chunk(int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i3] = cArr2[(i2 >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = cArr2[(i2 >> 12) & 63];
        int i6 = i5 + 1;
        cArr[i5] = cArr2[(i2 >> 6) & 63];
        int i7 = i6 + 1;
        cArr[i6] = cArr2[i2 & 63];
        return i7;
    }

    public int encodeBase64Partial(int i2, int i3, char[] cArr, int i4) {
        int i5 = i4 + 1;
        char[] cArr2 = this._base64ToAsciiC;
        cArr[i4] = cArr2[(i2 >> 18) & 63];
        int i6 = i5 + 1;
        cArr[i5] = cArr2[(i2 >> 12) & 63];
        if (this._usesPadding) {
            int i7 = i6 + 1;
            cArr[i6] = i3 == 2 ? cArr2[(i2 >> 6) & 63] : this._paddingChar;
            int i8 = i7 + 1;
            cArr[i7] = this._paddingChar;
            return i8;
        }
        if (i3 != 2) {
            return i6;
        }
        int i9 = i6 + 1;
        cArr[i6] = cArr2[(i2 >> 6) & 63];
        return i9;
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int getMaxLineLength() {
        return this._maxLineLength;
    }

    public char getPaddingChar() {
        return this._paddingChar;
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    protected Object readResolve() {
        return Base64Variants.valueOf(this._name);
    }

    public String toString() {
        return this._name;
    }

    public boolean usesPadding() {
        return this._usesPadding;
    }

    public boolean usesPaddingChar(char c2) {
        return c2 == this._paddingChar;
    }

    public int decodeBase64Char(int i2) {
        if (i2 <= 127) {
            return this._asciiToBase64[i2];
        }
        return -1;
    }

    public boolean usesPaddingChar(int i2) {
        return i2 == this._paddingChar;
    }

    public void decode(String str, ByteArrayBuilder byteArrayBuilder) throws IllegalArgumentException {
        int i2;
        char cCharAt;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            while (true) {
                i2 = i3 + 1;
                cCharAt = str.charAt(i3);
                if (i2 >= length) {
                    return;
                }
                if (cCharAt > ' ') {
                    break;
                } else {
                    i3 = i2;
                }
            }
            int iDecodeBase64Char = decodeBase64Char(cCharAt);
            if (iDecodeBase64Char < 0) {
                _reportInvalidBase64(cCharAt, 0, null);
            }
            if (i2 >= length) {
                _reportBase64EOF();
            }
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            int iDecodeBase64Char2 = decodeBase64Char(cCharAt2);
            if (iDecodeBase64Char2 < 0) {
                _reportInvalidBase64(cCharAt2, 1, null);
            }
            int i5 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
            if (i4 >= length) {
                if (!usesPadding()) {
                    byteArrayBuilder.append(i5 >> 4);
                    return;
                }
                _reportBase64EOF();
            }
            int i6 = i4 + 1;
            char cCharAt3 = str.charAt(i4);
            int iDecodeBase64Char3 = decodeBase64Char(cCharAt3);
            if (iDecodeBase64Char3 < 0) {
                if (iDecodeBase64Char3 != -2) {
                    _reportInvalidBase64(cCharAt3, 2, null);
                }
                if (i6 >= length) {
                    _reportBase64EOF();
                }
                i3 = i6 + 1;
                char cCharAt4 = str.charAt(i6);
                if (!usesPaddingChar(cCharAt4)) {
                    _reportInvalidBase64(cCharAt4, 3, "expected padding character '" + getPaddingChar() + "'");
                }
                byteArrayBuilder.append(i5 >> 4);
            } else {
                int i7 = (i5 << 6) | iDecodeBase64Char3;
                if (i6 >= length) {
                    if (!usesPadding()) {
                        byteArrayBuilder.appendTwoBytes(i7 >> 2);
                        return;
                    }
                    _reportBase64EOF();
                }
                int i8 = i6 + 1;
                char cCharAt5 = str.charAt(i6);
                int iDecodeBase64Char4 = decodeBase64Char(cCharAt5);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        _reportInvalidBase64(cCharAt5, 3, null);
                    }
                    byteArrayBuilder.appendTwoBytes(i7 >> 2);
                } else {
                    byteArrayBuilder.appendThreeBytes((i7 << 6) | iDecodeBase64Char4);
                }
                i3 = i8;
            }
        }
    }

    public void encodeBase64Chunk(StringBuilder sb, int i2) {
        sb.append(this._base64ToAsciiC[(i2 >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i2 >> 12) & 63]);
        sb.append(this._base64ToAsciiC[(i2 >> 6) & 63]);
        sb.append(this._base64ToAsciiC[i2 & 63]);
    }

    public void encodeBase64Partial(StringBuilder sb, int i2, int i3) {
        sb.append(this._base64ToAsciiC[(i2 >> 18) & 63]);
        sb.append(this._base64ToAsciiC[(i2 >> 12) & 63]);
        if (this._usesPadding) {
            sb.append(i3 == 2 ? this._base64ToAsciiC[(i2 >> 6) & 63] : this._paddingChar);
            sb.append(this._paddingChar);
        } else if (i3 == 2) {
            sb.append(this._base64ToAsciiC[(i2 >> 6) & 63]);
        }
    }

    public int encodeBase64Chunk(int i2, byte[] bArr, int i3) {
        int i4 = i3 + 1;
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i3] = bArr2[(i2 >> 18) & 63];
        int i5 = i4 + 1;
        bArr[i4] = bArr2[(i2 >> 12) & 63];
        int i6 = i5 + 1;
        bArr[i5] = bArr2[(i2 >> 6) & 63];
        int i7 = i6 + 1;
        bArr[i6] = bArr2[i2 & 63];
        return i7;
    }

    public int encodeBase64Partial(int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4 + 1;
        byte[] bArr2 = this._base64ToAsciiB;
        bArr[i4] = bArr2[(i2 >> 18) & 63];
        int i6 = i5 + 1;
        bArr[i5] = bArr2[(i2 >> 12) & 63];
        if (!this._usesPadding) {
            if (i3 != 2) {
                return i6;
            }
            int i7 = i6 + 1;
            bArr[i6] = bArr2[(i2 >> 6) & 63];
            return i7;
        }
        byte b2 = (byte) this._paddingChar;
        int i8 = i6 + 1;
        bArr[i6] = i3 == 2 ? bArr2[(i2 >> 6) & 63] : b2;
        int i9 = i8 + 1;
        bArr[i8] = b2;
        return i9;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i2) {
        this(base64Variant, str, base64Variant._usesPadding, base64Variant._paddingChar, i2);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z, char c2, int i2) {
        int[] iArr = new int[128];
        this._asciiToBase64 = iArr;
        char[] cArr = new char[64];
        this._base64ToAsciiC = cArr;
        byte[] bArr = new byte[64];
        this._base64ToAsciiB = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant._base64ToAsciiB;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant._base64ToAsciiC;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant._asciiToBase64;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._usesPadding = z;
        this._paddingChar = c2;
        this._maxLineLength = i2;
    }
}
