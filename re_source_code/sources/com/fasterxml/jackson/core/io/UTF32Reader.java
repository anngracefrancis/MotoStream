package com.fasterxml.jackson.core.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public class UTF32Reader extends Reader {
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i2, int i3, boolean z) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i2;
        this._length = i3;
        this._bigEndian = z;
        this._managedBuffers = inputStream != null;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            this._context.releaseReadIOBuffer(bArr);
        }
    }

    private boolean loadMore(int i2) throws IOException {
        int i3;
        this._byteCount += this._length - i2;
        if (i2 > 0) {
            int i4 = this._ptr;
            if (i4 > 0) {
                byte[] bArr = this._buffer;
                System.arraycopy(bArr, i4, bArr, 0, i2);
                this._ptr = 0;
            }
            this._length = i2;
        } else {
            this._ptr = 0;
            InputStream inputStream = this._in;
            int i5 = inputStream == null ? -1 : inputStream.read(this._buffer);
            if (i5 < 1) {
                this._length = 0;
                if (i5 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = i5;
        }
        while (true) {
            int i6 = this._length;
            if (i6 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            if (inputStream2 == null) {
                i3 = -1;
            } else {
                byte[] bArr2 = this._buffer;
                i3 = inputStream2.read(bArr2, i6, bArr2.length - i6);
            }
            if (i3 < 1) {
                if (i3 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i3;
        }
    }

    private void reportBounds(char[] cArr, int i2, int i3) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i2 + "," + i3 + "), cbuf[" + cArr.length + "]");
    }

    private void reportInvalid(int i2, int i3, String str) throws IOException {
        int i4 = (this._byteCount + this._ptr) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i2) + str + " at char #" + (this._charCount + i3) + ", byte #" + i4 + ")");
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i2, int i3) throws IOException {
        int i4 = this._byteCount + i2;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i2 + ", needed " + i3 + ", at char #" + this._charCount + ", byte #" + i4 + ")");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00cc A[LOOP:0: B:21:0x0031->B:38:0x00cc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca A[SYNTHETIC] */
    @Override // java.io.Reader
    public int read(char[] cArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int i6;
        int i7;
        if (this._buffer == null) {
            return -1;
        }
        if (i3 < 1) {
            return i3;
        }
        if (i2 < 0 || i2 + i3 > cArr.length) {
            reportBounds(cArr, i2, i3);
        }
        int i8 = i3 + i2;
        char c2 = this._surrogate;
        if (c2 != 0) {
            i4 = i2 + 1;
            cArr[i2] = c2;
            this._surrogate = (char) 0;
        } else {
            int i9 = this._length - this._ptr;
            if (i9 < 4 && !loadMore(i9)) {
                return -1;
            }
            i4 = i2;
        }
        while (i4 < i8) {
            int i10 = this._ptr;
            if (this._bigEndian) {
                byte[] bArr = this._buffer;
                i5 = (bArr[i10] << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
                i6 = bArr[i10 + 3] & 255;
            } else {
                byte[] bArr2 = this._buffer;
                i5 = (bArr2[i10] & 255) | ((bArr2[i10 + 1] & 255) << 8) | ((bArr2[i10 + 2] & 255) << 16);
                i6 = bArr2[i10 + 3] << 24;
            }
            int i11 = i6 | i5;
            this._ptr = i10 + 4;
            if (i11 > 65535) {
                if (i11 > 1114111) {
                    reportInvalid(i11, i4 - i2, "(above " + Integer.toHexString(1114111) + ") ");
                }
                int i12 = i11 - 65536;
                i7 = i4 + 1;
                cArr[i4] = (char) ((i12 >> 10) + 55296);
                i11 = (i12 & 1023) | 56320;
                if (i7 >= i8) {
                    this._surrogate = (char) i11;
                } else {
                    i4 = i7;
                    i7 = i4 + 1;
                    cArr[i4] = (char) i11;
                    if (this._ptr >= this._length) {
                        i4 = i7;
                    }
                }
            } else {
                i7 = i4 + 1;
                cArr[i4] = (char) i11;
                if (this._ptr >= this._length) {
                    i4 = i7;
                }
            }
            i4 = i7;
            break;
        }
        int i13 = i4 - i2;
        this._charCount += i13;
        return i13;
    }
}
