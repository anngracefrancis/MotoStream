package com.google.zxing.g;

import java.util.Arrays;

/* JADX INFO: compiled from: BitMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f20341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f20342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f20343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f20344i;

    public b(int i2) {
        this(i2, i2);
    }

    private String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f20342g * (this.f20341f + 1));
        for (int i2 = 0; i2 < this.f20342g; i2++) {
            for (int i3 = 0; i3 < this.f20341f; i3++) {
                sb.append(f(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void d() {
        int length = this.f20344i.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f20344i[i2] = 0;
        }
    }

    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f20341f, this.f20342g, this.f20343h, (int[]) this.f20344i.clone());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f20341f == bVar.f20341f && this.f20342g == bVar.f20342g && this.f20343h == bVar.f20343h && Arrays.equals(this.f20344i, bVar.f20344i);
    }

    public boolean f(int i2, int i3) {
        return ((this.f20344i[(i3 * this.f20343h) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public int g() {
        return this.f20342g;
    }

    public int h() {
        return this.f20341f;
    }

    public int hashCode() {
        int i2 = this.f20341f;
        return (((((((i2 * 31) + i2) * 31) + this.f20342g) * 31) + this.f20343h) * 31) + Arrays.hashCode(this.f20344i);
    }

    public void i(int i2, int i3) {
        int i4 = (i3 * this.f20343h) + (i2 / 32);
        int[] iArr = this.f20344i;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void j(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i7 > this.f20342g || i6 > this.f20341f) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i3 < i7) {
            int i8 = this.f20343h * i3;
            for (int i9 = i2; i9 < i6; i9++) {
                int[] iArr = this.f20344i;
                int i10 = (i9 / 32) + i8;
                iArr[i10] = iArr[i10] | (1 << (i9 & 31));
            }
            i3++;
        }
    }

    public String k(String str, String str2) {
        return b(str, str2, "\n");
    }

    public String toString() {
        return k("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f20341f = i2;
        this.f20342g = i3;
        int i4 = (i2 + 31) / 32;
        this.f20343h = i4;
        this.f20344i = new int[i4 * i3];
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.f20341f = i2;
        this.f20342g = i3;
        this.f20343h = i4;
        this.f20344i = iArr;
    }
}
