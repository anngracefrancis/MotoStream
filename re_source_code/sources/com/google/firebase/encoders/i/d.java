package com.google.firebase.encoders.i;

import java.io.OutputStream;

/* JADX INFO: compiled from: LengthCountingOutputStream.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends OutputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f19597f = 0;

    d() {
    }

    long a() {
        return this.f19597f;
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        this.f19597f++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f19597f += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 >= 0 && i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) <= bArr.length && i4 >= 0) {
            this.f19597f += (long) i3;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
