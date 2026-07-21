package com.bumptech.glide.r;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f9543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9544g;

    private c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f9543f = j2;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f9544g += i2;
        } else if (this.f9543f - ((long) this.f9544g) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f9543f + ", but read: " + this.f9544g);
        }
        return i2;
    }

    public static InputStream b(InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f9543f - ((long) this.f9544g), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return a(super.read(bArr, i2, i3));
    }
}
