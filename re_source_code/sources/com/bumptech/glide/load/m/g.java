package com.bumptech.glide.load.m;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ExifOrientationStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f9268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte f9271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9272j;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f9268f = bArr;
        int length = bArr.length;
        f9269g = length;
        f9270h = length + 2;
    }

    public g(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f9271i = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3;
        int i4 = this.f9272j;
        if (i4 < 2 || i4 > (i3 = f9270h)) {
            i2 = super.read();
        } else {
            i2 = i4 == i3 ? this.f9271i : f9268f[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.f9272j++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.f9272j = (int) (((long) this.f9272j) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f9272j;
        int i6 = f9270h;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f9271i;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i3);
            System.arraycopy(f9268f, this.f9272j - 2, bArr, i2, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.f9272j += i4;
        }
        return i4;
    }
}
