package com.bumptech.glide.load.o.c;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class s extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile byte[] f9388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9393k;

    /* JADX INFO: compiled from: RecyclableBufferedInputStream.java */
    static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    public s(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f9391i;
        if (i2 != -1) {
            int i3 = this.f9392j - i2;
            int i4 = this.f9390h;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f9389g == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f9393k.e(i4, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f9388f = bArr2;
                    this.f9393k.d(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i5 = this.f9392j - this.f9391i;
                this.f9392j = i5;
                this.f9391i = 0;
                this.f9389g = 0;
                int i6 = inputStream.read(bArr, i5, bArr.length - i5);
                int i7 = this.f9392j;
                if (i6 > 0) {
                    i7 += i6;
                }
                this.f9389g = i7;
                return i6;
            }
        }
        int i8 = inputStream.read(bArr);
        if (i8 > 0) {
            this.f9391i = -1;
            this.f9392j = 0;
            this.f9389g = i8;
        }
        return i8;
    }

    private static IOException d() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f9388f == null || inputStream == null) {
            throw d();
        }
        return (this.f9389g - this.f9392j) + inputStream.available();
    }

    public synchronized void b() {
        this.f9390h = this.f9388f.length;
    }

    public synchronized void c() {
        if (this.f9388f != null) {
            this.f9393k.d(this.f9388f);
            this.f9388f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f9388f != null) {
            this.f9393k.d(this.f9388f);
            this.f9388f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        this.f9390h = Math.max(this.f9390h, i2);
        this.f9391i = this.f9392j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f9388f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw d();
        }
        if (this.f9392j >= this.f9389g && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f9388f && (bArr = this.f9388f) == null) {
            throw d();
        }
        int i2 = this.f9389g;
        int i3 = this.f9392j;
        if (i2 - i3 <= 0) {
            return -1;
        }
        this.f9392j = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f9388f == null) {
            throw new IOException("Stream is closed");
        }
        int i2 = this.f9391i;
        if (-1 == i2) {
            throw new a("Mark has been invalidated, pos: " + this.f9392j + " markLimit: " + this.f9390h);
        }
        this.f9392j = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j2) throws IOException {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f9388f;
        if (bArr == null) {
            throw d();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw d();
        }
        int i2 = this.f9389g;
        int i3 = this.f9392j;
        if (i2 - i3 >= j2) {
            this.f9392j = (int) (((long) i3) + j2);
            return j2;
        }
        long j3 = ((long) i2) - ((long) i3);
        this.f9392j = i2;
        if (this.f9391i == -1 || j2 > this.f9390h) {
            return j3 + inputStream.skip(j2 - j3);
        }
        if (a(inputStream, bArr) == -1) {
            return j3;
        }
        int i4 = this.f9389g;
        int i5 = this.f9392j;
        if (i4 - i5 >= j2 - j3) {
            this.f9392j = (int) ((((long) i5) + j2) - j3);
            return j2;
        }
        long j4 = (j3 + ((long) i4)) - ((long) i5);
        this.f9392j = i4;
        return j4;
    }

    s(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar, int i2) {
        super(inputStream);
        this.f9391i = -1;
        this.f9393k = bVar;
        this.f9388f = (byte[]) bVar.e(i2, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f9388f;
        if (bArr2 == null) {
            throw d();
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i6 = this.f9392j;
            int i7 = this.f9389g;
            if (i6 < i7) {
                int i8 = i7 - i6 >= i3 ? i3 : i7 - i6;
                System.arraycopy(bArr2, i6, bArr, i2, i8);
                this.f9392j += i8;
                if (i8 == i3 || inputStream.available() == 0) {
                    return i8;
                }
                i2 += i8;
                i4 = i3 - i8;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f9391i == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.f9388f && (bArr2 = this.f9388f) == null) {
                        throw d();
                    }
                    int i9 = this.f9389g;
                    int i10 = this.f9392j;
                    i5 = i9 - i10 >= i4 ? i4 : i9 - i10;
                    System.arraycopy(bArr2, i10, bArr, i2, i5);
                    this.f9392j += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            throw d();
        }
    }
}
