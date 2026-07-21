package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonStringEncoder {
    protected ByteArrayBuilder _bytes;
    protected final char[] _qbuf = {'\\', 0, '0', '0', 0, 0};
    protected TextBuffer _text;
    private static final char[] HC = CharTypes.copyHexChars();
    private static final byte[] HB = CharTypes.copyHexBytes();
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal<>();

    private int _appendByte(int i2, int i3, ByteArrayBuilder byteArrayBuilder, int i4) {
        byteArrayBuilder.setCurrentSegmentLength(i4);
        byteArrayBuilder.append(92);
        if (i3 < 0) {
            byteArrayBuilder.append(117);
            if (i2 > 255) {
                int i5 = i2 >> 8;
                byte[] bArr = HB;
                byteArrayBuilder.append(bArr[i5 >> 4]);
                byteArrayBuilder.append(bArr[i5 & 15]);
                i2 &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = HB;
            byteArrayBuilder.append(bArr2[i2 >> 4]);
            byteArrayBuilder.append(bArr2[i2 & 15]);
        } else {
            byteArrayBuilder.append((byte) i3);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private int _appendNamed(int i2, char[] cArr) {
        cArr[1] = (char) i2;
        return 2;
    }

    private int _appendNumeric(int i2, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = HC;
        cArr[4] = cArr2[i2 >> 4];
        cArr[5] = cArr2[i2 & 15];
        return 6;
    }

    private static int _convert(int i2, int i3) {
        if (i3 >= 56320 && i3 <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i3 - 56320);
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i2) + ", second 0x" + Integer.toHexString(i3) + "; illegal combination");
    }

    private static void _illegal(int i2) {
        throw new IllegalArgumentException(UTF8Writer.illegalSurrogateDesc(i2));
    }

    public static JsonStringEncoder getInstance() {
        ThreadLocal<SoftReference<JsonStringEncoder>> threadLocal = _threadEncoder;
        SoftReference<JsonStringEncoder> softReference = threadLocal.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
        threadLocal.set(new SoftReference<>(jsonStringEncoder2));
        return jsonStringEncoder2;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:54:0x00dc A[SYNTHETIC] */
    public byte[] encodeAsUTF8(String str) {
        int i2;
        int i3;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int length2 = bArrResetAndGetFirstSegment.length;
        int i4 = 0;
        int i5 = 0;
        loop0: while (i4 < length) {
            int i6 = i4 + 1;
            char cCharAt = str.charAt(i4);
            while (cCharAt <= 127) {
                if (i5 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i5 = 0;
                }
                int i7 = i5 + 1;
                bArrResetAndGetFirstSegment[i5] = (byte) cCharAt;
                if (i6 >= length) {
                    i5 = i7;
                    break loop0;
                }
                char cCharAt2 = str.charAt(i6);
                i6++;
                cCharAt = cCharAt2;
                i5 = i7;
            }
            if (i5 >= length2) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                length2 = bArrResetAndGetFirstSegment.length;
                i5 = 0;
            }
            if (cCharAt < 2048) {
                i2 = i5 + 1;
                bArrResetAndGetFirstSegment[i5] = (byte) ((cCharAt >> 6) | 192);
            } else {
                if (cCharAt < 55296 || cCharAt > 57343) {
                    int i8 = i5 + 1;
                    bArrResetAndGetFirstSegment[i5] = (byte) ((cCharAt >> '\f') | 224);
                    if (i8 >= length2) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        length2 = bArrResetAndGetFirstSegment.length;
                        i8 = 0;
                    }
                    bArrResetAndGetFirstSegment[i8] = (byte) (((cCharAt >> 6) & 63) | 128);
                    i2 = i8 + 1;
                } else {
                    if (cCharAt > 56319) {
                        _illegal(cCharAt);
                    }
                    if (i6 >= length) {
                        _illegal(cCharAt);
                    }
                    int i9 = i6 + 1;
                    int i_convert = _convert(cCharAt, str.charAt(i6));
                    if (i_convert > 1114111) {
                        _illegal(i_convert);
                    }
                    int i10 = i5 + 1;
                    bArrResetAndGetFirstSegment[i5] = (byte) ((i_convert >> 18) | 240);
                    if (i10 >= length2) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        length2 = bArrResetAndGetFirstSegment.length;
                        i10 = 0;
                    }
                    int i11 = i10 + 1;
                    bArrResetAndGetFirstSegment[i10] = (byte) (((i_convert >> 12) & 63) | 128);
                    if (i11 >= length2) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        length2 = bArrResetAndGetFirstSegment.length;
                        i11 = 0;
                    }
                    int i12 = i11 + 1;
                    bArrResetAndGetFirstSegment[i11] = (byte) (((i_convert >> 6) & 63) | 128);
                    i3 = i_convert;
                    i4 = i9;
                    i2 = i12;
                }
                if (i2 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i2 = 0;
                }
                bArrResetAndGetFirstSegment[i2] = (byte) ((i3 & 63) | 128);
                i5 = i2 + 1;
            }
            i3 = cCharAt;
            i4 = i6;
            if (i2 >= length2) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                length2 = bArrResetAndGetFirstSegment.length;
                i2 = 0;
            }
            bArrResetAndGetFirstSegment[i2] = (byte) ((i3 & 63) | 128);
            i5 = i2 + 1;
        }
        return this._bytes.completeAndCoalesce(i5);
    }

    public char[] quoteAsString(String str) {
        TextBuffer textBuffer = this._text;
        if (textBuffer == null) {
            textBuffer = new TextBuffer(null);
            this._text = textBuffer;
        }
        char[] cArrEmptyAndGetCurrentSegment = textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = str.length();
        int i2 = 0;
        int i3 = 0;
        loop0: while (i2 < length2) {
            while (true) {
                char cCharAt = str.charAt(i2);
                if (cCharAt >= length || iArr[cCharAt] == 0) {
                    if (i3 >= cArrEmptyAndGetCurrentSegment.length) {
                        cArrEmptyAndGetCurrentSegment = textBuffer.finishCurrentSegment();
                        i3 = 0;
                    }
                    int i4 = i3 + 1;
                    cArrEmptyAndGetCurrentSegment[i3] = cCharAt;
                    i2++;
                    if (i2 >= length2) {
                        i3 = i4;
                        break loop0;
                    }
                    i3 = i4;
                }
            }
            int i5 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            int i6 = iArr[cCharAt2];
            int i_appendNumeric = i6 < 0 ? _appendNumeric(cCharAt2, this._qbuf) : _appendNamed(i6, this._qbuf);
            int i7 = i3 + i_appendNumeric;
            if (i7 > cArrEmptyAndGetCurrentSegment.length) {
                int length3 = cArrEmptyAndGetCurrentSegment.length - i3;
                if (length3 > 0) {
                    System.arraycopy(this._qbuf, 0, cArrEmptyAndGetCurrentSegment, i3, length3);
                }
                cArrEmptyAndGetCurrentSegment = textBuffer.finishCurrentSegment();
                int i8 = i_appendNumeric - length3;
                System.arraycopy(this._qbuf, length3, cArrEmptyAndGetCurrentSegment, 0, i8);
                i3 = i8;
            } else {
                System.arraycopy(this._qbuf, 0, cArrEmptyAndGetCurrentSegment, i3, i_appendNumeric);
                i3 = i7;
            }
            i2 = i5;
        }
        textBuffer.setCurrentLength(i3);
        return textBuffer.contentsAsArray();
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00f8  */
    public byte[] quoteAsUTF8(String str) {
        int i2;
        int i3;
        int i4;
        ByteArrayBuilder byteArrayBuilder = this._bytes;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._bytes = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int i5 = 0;
        int i_appendByte = 0;
        loop0: while (i5 < length) {
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                char cCharAt = str.charAt(i5);
                if (cCharAt > 127 || iArr[cCharAt] != 0) {
                    break;
                }
                if (i_appendByte >= bArrResetAndGetFirstSegment.length) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i_appendByte = 0;
                }
                int i6 = i_appendByte + 1;
                bArrResetAndGetFirstSegment[i_appendByte] = (byte) cCharAt;
                i5++;
                if (i5 >= length) {
                    i_appendByte = i6;
                    break loop0;
                }
                i_appendByte = i6;
            }
            if (i_appendByte >= bArrResetAndGetFirstSegment.length) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                i_appendByte = 0;
            }
            int i7 = i5 + 1;
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 <= 127) {
                i_appendByte = _appendByte(cCharAt2, iArr[cCharAt2], byteArrayBuilder, i_appendByte);
                bArrResetAndGetFirstSegment = byteArrayBuilder.getCurrentSegment();
                i5 = i7;
            } else {
                if (cCharAt2 <= 2047) {
                    i3 = i_appendByte + 1;
                    bArrResetAndGetFirstSegment[i_appendByte] = (byte) ((cCharAt2 >> 6) | 192);
                    i2 = (cCharAt2 & '?') | 128;
                } else {
                    if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                        int i8 = i_appendByte + 1;
                        bArrResetAndGetFirstSegment[i_appendByte] = (byte) ((cCharAt2 >> '\f') | 224);
                        if (i8 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i8 = 0;
                        }
                        bArrResetAndGetFirstSegment[i8] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                        i2 = (cCharAt2 & '?') | 128;
                        i3 = i8 + 1;
                    } else {
                        if (cCharAt2 > 56319) {
                            _illegal(cCharAt2);
                        }
                        if (i7 >= length) {
                            _illegal(cCharAt2);
                        }
                        int i9 = i7 + 1;
                        int i_convert = _convert(cCharAt2, str.charAt(i7));
                        if (i_convert > 1114111) {
                            _illegal(i_convert);
                        }
                        int i10 = i_appendByte + 1;
                        bArrResetAndGetFirstSegment[i_appendByte] = (byte) ((i_convert >> 18) | 240);
                        if (i10 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        bArrResetAndGetFirstSegment[i10] = (byte) (((i_convert >> 12) & 63) | 128);
                        if (i11 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i11 = 0;
                        }
                        int i12 = i11 + 1;
                        bArrResetAndGetFirstSegment[i11] = (byte) (((i_convert >> 6) & 63) | 128);
                        i4 = (i_convert & 63) | 128;
                        i5 = i9;
                        i3 = i12;
                    }
                    if (i3 >= bArrResetAndGetFirstSegment.length) {
                        bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                        i3 = 0;
                    }
                    bArrResetAndGetFirstSegment[i3] = (byte) i4;
                    i_appendByte = i3 + 1;
                }
                i4 = i2;
                i5 = i7;
                if (i3 >= bArrResetAndGetFirstSegment.length) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i3 = 0;
                }
                bArrResetAndGetFirstSegment[i3] = (byte) i4;
                i_appendByte = i3 + 1;
            }
        }
        return this._bytes.completeAndCoalesce(i_appendByte);
    }
}
