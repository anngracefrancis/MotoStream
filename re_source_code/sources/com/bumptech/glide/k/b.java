package com.bumptech.glide.k;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f8981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Charset f8982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f8983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8985j;

    /* JADX INFO: compiled from: StrictLineReader.java */
    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.f8982g.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f8981f;
        byte[] bArr = this.f8983h;
        int i2 = inputStream.read(bArr, 0, bArr.length);
        if (i2 == -1) {
            throw new EOFException();
        }
        this.f8984i = 0;
        this.f8985j = i2;
    }

    public boolean c() {
        return this.f8985j == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f8981f) {
            if (this.f8983h != null) {
                this.f8983h = null;
                this.f8981f.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String d() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f8981f) {
            if (this.f8983h == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f8984i >= this.f8985j) {
                b();
            }
            for (int i4 = this.f8984i; i4 != this.f8985j; i4++) {
                byte[] bArr2 = this.f8983h;
                if (bArr2[i4] == 10) {
                    if (i4 != this.f8984i) {
                        i3 = i4 - 1;
                        if (bArr2[i3] != 13) {
                            i3 = i4;
                        }
                    } else {
                        i3 = i4;
                    }
                    byte[] bArr3 = this.f8983h;
                    int i5 = this.f8984i;
                    String str = new String(bArr3, i5, i3 - i5, this.f8982g.name());
                    this.f8984i = i4 + 1;
                    return str;
                }
            }
            a aVar = new a((this.f8985j - this.f8984i) + 80);
            loop1: while (true) {
                byte[] bArr4 = this.f8983h;
                int i6 = this.f8984i;
                aVar.write(bArr4, i6, this.f8985j - i6);
                this.f8985j = -1;
                b();
                i2 = this.f8984i;
                while (i2 != this.f8985j) {
                    bArr = this.f8983h;
                    if (bArr[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            int i7 = this.f8984i;
            if (i2 != i7) {
                aVar.write(bArr, i7, i2 - i7);
            }
            this.f8984i = i2 + 1;
            return aVar.toString();
        }
    }

    public b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f8981f = inputStream;
        this.f8982g = charset;
        this.f8983h = new byte[i2];
    }
}
