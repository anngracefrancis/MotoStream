package com.google.zxing.j.b;

/* JADX INFO: compiled from: BarcodeRow.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20402b = 0;

    b(int i2) {
        this.a = new byte[i2];
    }

    private void c(int i2, boolean z) {
        this.a[i2] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f20402b;
            this.f20402b = i4 + 1;
            c(i4, z);
        }
    }

    byte[] b(int i2) {
        int length = this.a.length * i2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = this.a[i3 / i2];
        }
        return bArr;
    }
}
