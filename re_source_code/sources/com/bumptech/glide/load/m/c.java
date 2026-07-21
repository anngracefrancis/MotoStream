package com.bumptech.glide.load.m;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BufferedOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OutputStream f9263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f9264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.engine.z.b f9265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9266i;

    public c(OutputStream outputStream, com.bumptech.glide.load.engine.z.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i2 = this.f9266i;
        if (i2 > 0) {
            this.f9263f.write(this.f9264g, 0, i2);
            this.f9266i = 0;
        }
    }

    private void b() throws IOException {
        if (this.f9266i == this.f9264g.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f9264g;
        if (bArr != null) {
            this.f9265h.d(bArr);
            this.f9264g = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f9263f.close();
            c();
        } catch (Throwable th) {
            this.f9263f.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f9263f.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.f9264g;
        int i3 = this.f9266i;
        this.f9266i = i3 + 1;
        bArr[i3] = (byte) i2;
        b();
    }

    c(OutputStream outputStream, com.bumptech.glide.load.engine.z.b bVar, int i2) {
        this.f9263f = outputStream;
        this.f9265h = bVar;
        this.f9264g = (byte[]) bVar.e(i2, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f9266i;
            if (i7 == 0 && i5 >= this.f9264g.length) {
                this.f9263f.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.f9264g.length - i7);
            System.arraycopy(bArr, i6, this.f9264g, this.f9266i, iMin);
            this.f9266i += iMin;
            i4 += iMin;
            b();
        } while (i4 < i3);
    }
}
