package com.google.zxing.j.b;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: BarcodeMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final b[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f20400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f20401d;

    a(int i2, int i3) {
        b[] bVarArr = new b[i2];
        this.a = bVarArr;
        int length = bVarArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.a[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.f20401d = i3 * 17;
        this.f20400c = i2;
        this.f20399b = -1;
    }

    b a() {
        return this.a[this.f20399b];
    }

    public byte[][] b(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f20400c * i3, this.f20401d * i2);
        int i4 = this.f20400c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.a[i5 / i3].b(i2);
        }
        return bArr;
    }

    void c() {
        this.f20399b++;
    }
}
