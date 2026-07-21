package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class ByteBufferBackedOutputStream extends OutputStream {
    protected final ByteBuffer _b;

    public ByteBufferBackedOutputStream(ByteBuffer byteBuffer) {
        this._b = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this._b.put((byte) i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this._b.put(bArr, i2, i3);
    }
}
