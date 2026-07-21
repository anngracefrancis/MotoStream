package com.google.android.gms.internal.ads;

import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzst {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16733c;

    public zzst() {
    }

    public final int a() {
        byte[] bArr = this.a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int b() {
        return this.f16732b;
    }

    public final int c() {
        return this.f16733c;
    }

    public final int d() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        int i4 = (bArr[i2] & 255) << 24;
        int i5 = i3 + 1;
        this.f16732b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        int i7 = i5 + 1;
        this.f16732b = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        this.f16732b = i7 + 1;
        return (bArr[i7] & 255) | i8;
    }

    public final long e() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        long j2 = (((long) bArr[i2]) & 255) << 56;
        int i4 = i3 + 1;
        this.f16732b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 48);
        int i5 = i4 + 1;
        this.f16732b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        this.f16732b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i7 = i6 + 1;
        this.f16732b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        this.f16732b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        this.f16732b = i9;
        long j8 = j7 | ((((long) bArr[i8]) & 255) << 8);
        this.f16732b = i9 + 1;
        return (((long) bArr[i9]) & 255) | j8;
    }

    public final short f() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f16732b = i3 + 1;
        return (short) ((bArr[i3] & 255) | i4);
    }

    public final int g() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        this.f16732b = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int h() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f16732b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public final void i() {
        this.f16732b = 0;
        this.f16733c = 0;
    }

    public final void j(int i2) {
        m(a() < i2 ? new byte[i2] : this.a, i2);
    }

    public final void k(int i2) {
        zzsk.a(i2 >= 0 && i2 <= this.f16733c);
        this.f16732b = i2;
    }

    public final void l(int i2) {
        k(this.f16732b + i2);
    }

    public final void m(byte[] bArr, int i2) {
        this.a = bArr;
        this.f16733c = i2;
        this.f16732b = 0;
    }

    public final void n(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.a, this.f16732b, bArr, i2, i3);
        this.f16732b += i3;
    }

    public final void o(int i2) {
        zzsk.a(i2 >= 0 && i2 <= this.a.length);
        this.f16733c = i2;
    }

    public final String p(int i2) {
        if (i2 == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int i3 = (this.f16732b + i2) - 1;
        String str = new String(this.a, this.f16732b, (i3 >= this.f16733c || this.a[i3] != 0) ? i2 : i2 - 1);
        this.f16732b += i2;
        return str;
    }

    public final long q() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        long j2 = (((long) bArr[i2]) & 255) << 24;
        int i4 = i3 + 1;
        this.f16732b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i5 = i4 + 1;
        this.f16732b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 8);
        this.f16732b = i5 + 1;
        return (((long) bArr[i5]) & 255) | j4;
    }

    public final int r() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        int i5 = i3 + 1;
        this.f16732b = i5;
        int i6 = (bArr[i3] & 255) | i4;
        this.f16732b = i5 + 2;
        return i6;
    }

    public final int s() {
        int iD = d();
        if (iD >= 0) {
            return iD;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(iD);
        throw new IllegalStateException(sb.toString());
    }

    public final long t() {
        long jE = e();
        if (jE >= 0) {
            return jE;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(jE);
        throw new IllegalStateException(sb.toString());
    }

    public final int u() {
        return this.f16733c - this.f16732b;
    }

    public final int v() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        int i4 = bArr[i2] & 255;
        this.f16732b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | i4;
    }

    public final long w() {
        byte[] bArr = this.a;
        int i2 = this.f16732b;
        int i3 = i2 + 1;
        this.f16732b = i3;
        long j2 = ((long) bArr[i2]) & 255;
        int i4 = i3 + 1;
        this.f16732b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i5 = i4 + 1;
        this.f16732b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 16);
        this.f16732b = i5 + 1;
        return ((((long) bArr[i5]) & 255) << 24) | j4;
    }

    public zzst(int i2) {
        this.a = new byte[i2];
        this.f16733c = i2;
    }

    public zzst(byte[] bArr) {
        this.a = bArr;
        this.f16733c = bArr.length;
    }
}
