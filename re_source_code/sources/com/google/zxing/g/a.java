package com.google.zxing.g;

import java.util.Arrays;

/* JADX INFO: compiled from: BitArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f20339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f20340g;

    public a() {
        this.f20340g = 0;
        this.f20339f = new int[1];
    }

    private void g(int i2) {
        if (i2 > (this.f20339f.length << 5)) {
            int[] iArrK = k(i2);
            int[] iArr = this.f20339f;
            System.arraycopy(iArr, 0, iArrK, 0, iArr.length);
            this.f20339f = iArrK;
        }
    }

    private static int[] k(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void b(boolean z) {
        g(this.f20340g + 1);
        if (z) {
            int[] iArr = this.f20339f;
            int i2 = this.f20340g;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.f20340g++;
    }

    public void d(a aVar) {
        int i2 = aVar.f20340g;
        g(this.f20340g + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            b(aVar.h(i3));
        }
    }

    public void e(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        g(this.f20340g + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            b(z);
            i3--;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f20340g == aVar.f20340g && Arrays.equals(this.f20339f, aVar.f20339f);
    }

    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f20339f.clone(), this.f20340g);
    }

    public boolean h(int i2) {
        return ((1 << (i2 & 31)) & this.f20339f[i2 / 32]) != 0;
    }

    public int hashCode() {
        return (this.f20340g * 31) + Arrays.hashCode(this.f20339f);
    }

    public int i() {
        return this.f20340g;
    }

    public int j() {
        return (this.f20340g + 7) / 8;
    }

    public void l(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (h(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public void m(a aVar) {
        if (this.f20340g != aVar.f20340g) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f20339f;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.f20339f[i2];
            i2++;
        }
    }

    public String toString() {
        int i2 = this.f20340g;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.f20340g; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(h(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    a(int[] iArr, int i2) {
        this.f20339f = iArr;
        this.f20340g = i2;
    }
}
