package com.bumptech.glide.r;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: MarkEnforcingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9553f;

    public h(InputStream inputStream) {
        super(inputStream);
        this.f9553f = Integer.MIN_VALUE;
    }

    private long a(long j2) {
        int i2 = this.f9553f;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    private void b(long j2) {
        int i2 = this.f9553f;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.f9553f = (int) (((long) i2) - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i2 = this.f9553f;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        super.mark(i2);
        this.f9553f = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i2 = super.read();
        b(1L);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f9553f = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jA = a(j2);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int iA = (int) a(i3);
        if (iA == -1) {
            return -1;
        }
        int i4 = super.read(bArr, i2, iA);
        b(i4);
        return i4;
    }
}
