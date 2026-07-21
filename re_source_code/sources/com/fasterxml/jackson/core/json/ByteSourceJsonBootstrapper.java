package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public final class ByteSourceJsonBootstrapper {
    private int _bytesPerChar;
    private final IOContext _context;
    private final InputStream _in;
    private final byte[] _inputBuffer;
    private boolean _bigEndian = true;
    private int _inputPtr = 0;
    private int _inputEnd = 0;
    private final boolean _bufferRecyclable = true;

    public ByteSourceJsonBootstrapper(IOContext iOContext, InputStream inputStream) {
        this._context = iOContext;
        this._in = inputStream;
        this._inputBuffer = iOContext.allocReadIOBuffer();
    }

    private boolean checkUTF16(int i2) {
        if ((65280 & i2) == 0) {
            this._bigEndian = true;
        } else {
            if ((i2 & 255) != 0) {
                return false;
            }
            this._bigEndian = false;
        }
        this._bytesPerChar = 2;
        return true;
    }

    private boolean checkUTF32(int i2) throws IOException {
        if ((i2 >> 8) == 0) {
            this._bigEndian = true;
        } else if ((16777215 & i2) == 0) {
            this._bigEndian = false;
        } else if (((-16711681) & i2) == 0) {
            reportWeirdUCS4("3412");
        } else {
            if ((i2 & (-65281)) != 0) {
                return false;
            }
            reportWeirdUCS4("2143");
        }
        this._bytesPerChar = 4;
        return true;
    }

    private boolean handleBOM(int i2) throws IOException {
        if (i2 == -16842752) {
            reportWeirdUCS4("3412");
        } else {
            if (i2 == -131072) {
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                this._bigEndian = false;
                return true;
            }
            if (i2 == 65279) {
                this._bigEndian = true;
                this._inputPtr += 4;
                this._bytesPerChar = 4;
                return true;
            }
            if (i2 == 65534) {
                reportWeirdUCS4("2143");
            }
        }
        int i3 = i2 >>> 16;
        if (i3 == 65279) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = true;
            return true;
        }
        if (i3 == 65534) {
            this._inputPtr += 2;
            this._bytesPerChar = 2;
            this._bigEndian = false;
            return true;
        }
        if ((i2 >>> 8) != 15711167) {
            return false;
        }
        this._inputPtr += 3;
        this._bytesPerChar = 1;
        this._bigEndian = true;
        return true;
    }

    private void reportWeirdUCS4(String str) throws IOException {
        throw new CharConversionException("Unsupported UCS-4 endianness (" + str + ") detected");
    }

    public JsonParser constructParser(int i2, ObjectCodec objectCodec, ByteQuadsCanonicalizer byteQuadsCanonicalizer, CharsToNameCanonicalizer charsToNameCanonicalizer, int i3) throws IOException {
        if (detectEncoding() != JsonEncoding.UTF8 || !JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(i3)) {
            return new ReaderBasedJsonParser(this._context, i2, constructReader(), objectCodec, charsToNameCanonicalizer.makeChild(i3));
        }
        return new UTF8StreamJsonParser(this._context, i2, this._in, objectCodec, byteQuadsCanonicalizer.makeChild(i3), this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }

    public Reader constructReader() throws IOException {
        JsonEncoding encoding = this._context.getEncoding();
        int iBits = encoding.bits();
        if (iBits != 8 && iBits != 16) {
            if (iBits != 32) {
                throw new RuntimeException("Internal error");
            }
            IOContext iOContext = this._context;
            return new UTF32Reader(iOContext, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, iOContext.getEncoding().isBigEndian());
        }
        InputStream mergedStream = this._in;
        if (mergedStream == null) {
            mergedStream = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
        } else if (this._inputPtr < this._inputEnd) {
            mergedStream = new MergedStream(this._context, mergedStream, this._inputBuffer, this._inputPtr, this._inputEnd);
        }
        return new InputStreamReader(mergedStream, encoding.getJavaName());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x005e  */
    public JsonEncoding detectEncoding() throws IOException {
        int i2;
        JsonEncoding jsonEncoding;
        boolean z = false;
        if (ensureLoaded(4)) {
            byte[] bArr = this._inputBuffer;
            int i3 = this._inputPtr;
            int i4 = (bArr[i3 + 3] & 255) | (bArr[i3] << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
            if (handleBOM(i4) || checkUTF32(i4) || checkUTF16(i4 >>> 16)) {
                z = true;
            }
        } else if (ensureLoaded(2)) {
            byte[] bArr2 = this._inputBuffer;
            int i5 = this._inputPtr;
            if (checkUTF16((bArr2[i5 + 1] & 255) | ((bArr2[i5] & 255) << 8))) {
                z = true;
            }
        }
        if (!z || (i2 = this._bytesPerChar) == 1) {
            jsonEncoding = JsonEncoding.UTF8;
        } else if (i2 == 2) {
            jsonEncoding = this._bigEndian ? JsonEncoding.UTF16_BE : JsonEncoding.UTF16_LE;
        } else {
            if (i2 != 4) {
                throw new RuntimeException("Internal error");
            }
            jsonEncoding = this._bigEndian ? JsonEncoding.UTF32_BE : JsonEncoding.UTF32_LE;
        }
        this._context.setEncoding(jsonEncoding);
        return jsonEncoding;
    }

    protected boolean ensureLoaded(int i2) throws IOException {
        int i3;
        int i4 = this._inputEnd - this._inputPtr;
        while (i4 < i2) {
            InputStream inputStream = this._in;
            if (inputStream == null) {
                i3 = -1;
            } else {
                byte[] bArr = this._inputBuffer;
                int i5 = this._inputEnd;
                i3 = inputStream.read(bArr, i5, bArr.length - i5);
            }
            if (i3 < 1) {
                return false;
            }
            this._inputEnd += i3;
            i4 += i3;
        }
        return true;
    }
}
