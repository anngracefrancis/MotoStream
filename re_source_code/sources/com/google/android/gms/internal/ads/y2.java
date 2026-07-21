package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
final class y2 extends FilterInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f13603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f13604g;

    y2(InputStream inputStream, long j2) {
        super(inputStream);
        this.f13603f = j2;
    }

    final long a() {
        return this.f13603f - this.f13604g;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = super.read();
        if (i2 != -1) {
            this.f13604g++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = super.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f13604g += (long) i4;
        }
        return i4;
    }
}
