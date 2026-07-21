package com.bumptech.glide.r;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionCatchingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Queue<d> f9545f = k.f(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private InputStream f9546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IOException f9547h;

    d() {
    }

    public static d b(InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = f9545f;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.d(inputStream);
        return dVarPoll;
    }

    public IOException a() {
        return this.f9547h;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f9546g.available();
    }

    public void c() {
        this.f9547h = null;
        this.f9546g = null;
        Queue<d> queue = f9545f;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9546g.close();
    }

    void d(InputStream inputStream) {
        this.f9546g = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f9546g.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9546g.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f9546g.read(bArr);
        } catch (IOException e2) {
            this.f9547h = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f9546g.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) {
        try {
            return this.f9546g.skip(j2);
        } catch (IOException e2) {
            this.f9547h = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f9546g.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f9547h = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f9546g.read();
        } catch (IOException e2) {
            this.f9547h = e2;
            return -1;
        }
    }
}
