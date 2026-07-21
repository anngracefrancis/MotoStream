package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class d extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f17076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f17077g;

    d(InputStream inputStream, long j2) {
        super(inputStream);
        this.f17077g = -1L;
        inputStream.getClass();
        this.f17076f = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f17076f);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
        this.f17077g = this.f17076f;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f17076f == 0) {
            return -1;
        }
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 != -1) {
            this.f17076f--;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f17077g == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f17076f = this.f17077g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j2, this.f17076f));
        this.f17076f -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.f17076f;
        if (j2 == 0) {
            return -1;
        }
        int i4 = ((FilterInputStream) this).in.read(bArr, i2, (int) Math.min(i3, j2));
        if (i4 != -1) {
            this.f17076f -= (long) i4;
        }
        return i4;
    }
}
