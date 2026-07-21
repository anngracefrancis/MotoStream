package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class i10 {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final short[] f12734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private short[] f12736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private short[] f12738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f12739k;
    private short[] l;
    private int q;
    private int r;
    private int s;
    private int t;
    private int v;
    private int w;
    private int x;
    private int m = 0;
    private int n = 0;
    private int u = 0;
    private float o = 1.0f;
    private float p = 1.0f;

    public i10(int i2, int i3) {
        this.a = i2;
        this.f12730b = i3;
        this.f12731c = i2 / 400;
        int i4 = i2 / 65;
        this.f12732d = i4;
        int i5 = i4 * 2;
        this.f12733e = i5;
        this.f12734f = new short[i5];
        this.f12735g = i5;
        this.f12736h = new short[i5 * i3];
        this.f12737i = i5;
        this.f12738j = new short[i5 * i3];
        this.f12739k = i5;
        this.l = new short[i5 * i3];
    }

    private final int b(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f12730b;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                short s = sArr[i5 + i11];
                short s2 = sArr[i5 + i3 + i11];
                i10 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i10 * i8 < i6 * i3) {
                i8 = i3;
                i6 = i10;
            }
            if (i10 * i7 > i9 * i3) {
                i7 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.w = i6 / i8;
        this.x = i9 / i7;
        return i8;
    }

    private static void d(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    private final void f(short[] sArr, int i2, int i3) {
        g(i3);
        int i4 = this.f12730b;
        System.arraycopy(sArr, i2 * i4, this.f12738j, this.r * i4, i4 * i3);
        this.r += i3;
    }

    private final void g(int i2) {
        int i3 = this.r + i2;
        int i4 = this.f12737i;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f12737i = i5;
            this.f12738j = Arrays.copyOf(this.f12738j, i5 * this.f12730b);
        }
    }

    private final void h(int i2) {
        int i3 = this.q + i2;
        int i4 = this.f12735g;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f12735g = i5;
            this.f12736h = Arrays.copyOf(this.f12736h, i5 * this.f12730b);
        }
    }

    private final void j(short[] sArr, int i2, int i3) {
        int i4 = this.f12733e / i3;
        int i5 = this.f12730b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f12734f[i8] = (short) (i9 / i6);
        }
    }

    private final void m() {
        int iB;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.r;
        float f2 = this.o / this.p;
        double d2 = f2;
        int i8 = 1;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            int i9 = this.q;
            if (i9 >= this.f12733e) {
                int i10 = 0;
                while (true) {
                    int i11 = this.t;
                    if (i11 > 0) {
                        int iMin = Math.min(this.f12733e, i11);
                        f(this.f12736h, i10, iMin);
                        this.t -= iMin;
                        i10 += iMin;
                    } else {
                        short[] sArr = this.f12736h;
                        int i12 = this.a;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.f12730b == i8 && i13 == i8) {
                            iB = b(sArr, i10, this.f12731c, this.f12732d);
                        } else {
                            j(sArr, i10, i13);
                            int iB2 = b(this.f12734f, 0, this.f12731c / i13, this.f12732d / i13);
                            if (i13 != i8) {
                                int i14 = iB2 * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.f12731c;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.f12732d;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.f12730b == i8) {
                                    iB = b(sArr, i10, i16, i17);
                                } else {
                                    j(sArr, i10, i8);
                                    iB = b(this.f12734f, 0, i16, i17);
                                }
                            } else {
                                iB = iB2;
                            }
                        }
                        int i20 = this.w;
                        int i21 = i20 != 0 && this.u != 0 && this.x <= i20 * 3 && (i20 << 1) > this.v * 3 ? this.u : iB;
                        this.v = i20;
                        this.u = iB;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.f12736h;
                            if (f2 >= 2.0f) {
                                i3 = (int) (i21 / (f2 - 1.0f));
                            } else {
                                this.t = (int) ((i21 * (2.0f - f2)) / (f2 - 1.0f));
                                i3 = i21;
                            }
                            g(i3);
                            int i22 = i3;
                            d(i3, this.f12730b, this.f12738j, this.r, sArr2, i10, sArr2, i10 + i21);
                            this.r += i22;
                            i10 += i21 + i22;
                        } else {
                            int i23 = i21;
                            short[] sArr3 = this.f12736h;
                            if (f2 < 0.5f) {
                                i2 = (int) ((i23 * f2) / (1.0f - f2));
                            } else {
                                this.t = (int) ((i23 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i2 = i23;
                            }
                            int i24 = i23 + i2;
                            g(i24);
                            int i25 = this.f12730b;
                            System.arraycopy(sArr3, i10 * i25, this.f12738j, this.r * i25, i25 * i23);
                            d(i2, this.f12730b, this.f12738j, this.r + i23, sArr3, i23 + i10, sArr3, i10);
                            this.r += i24;
                            i10 += i2;
                        }
                    }
                    if (this.f12733e + i10 > i9) {
                        break;
                    } else {
                        i8 = 1;
                    }
                }
                int i26 = this.q - i10;
                short[] sArr4 = this.f12736h;
                int i27 = this.f12730b;
                System.arraycopy(sArr4, i10 * i27, sArr4, 0, i27 * i26);
                this.q = i26;
            }
        } else {
            f(this.f12736h, 0, this.q);
            this.q = 0;
        }
        float f3 = this.p;
        if (f3 == 1.0f || this.r == i7) {
            return;
        }
        int i28 = this.a;
        int i29 = (int) (i28 / f3);
        while (true) {
            if (i29 <= 16384 && i28 <= 16384) {
                break;
            }
            i29 /= 2;
            i28 /= 2;
        }
        int i30 = this.r - i7;
        int i31 = this.s + i30;
        int i32 = this.f12739k;
        if (i31 > i32) {
            int i33 = i32 + (i32 / 2) + i30;
            this.f12739k = i33;
            this.l = Arrays.copyOf(this.l, i33 * this.f12730b);
        }
        short[] sArr5 = this.f12738j;
        int i34 = this.f12730b;
        System.arraycopy(sArr5, i7 * i34, this.l, this.s * i34, i34 * i30);
        this.r = i7;
        this.s += i30;
        int i35 = 0;
        while (true) {
            i4 = this.s;
            if (i35 >= i4 - 1) {
                break;
            }
            while (true) {
                i5 = this.m;
                int i36 = (i5 + 1) * i29;
                i6 = this.n;
                if (i36 <= i6 * i28) {
                    break;
                }
                g(1);
                int i37 = 0;
                while (true) {
                    int i38 = this.f12730b;
                    if (i37 < i38) {
                        short[] sArr6 = this.f12738j;
                        int i39 = (this.r * i38) + i37;
                        short[] sArr7 = this.l;
                        int i40 = (i35 * i38) + i37;
                        short s = sArr7[i40];
                        short s2 = sArr7[i40 + i38];
                        int i41 = this.n * i28;
                        int i42 = this.m;
                        int i43 = i42 * i29;
                        int i44 = (i42 + 1) * i29;
                        int i45 = i44 - i41;
                        int i46 = i44 - i43;
                        sArr6[i39] = (short) (((s * i45) + ((i46 - i45) * s2)) / i46);
                        i37++;
                    }
                }
                this.n++;
                this.r++;
            }
            int i47 = i5 + 1;
            this.m = i47;
            if (i47 == i28) {
                this.m = 0;
                zzsk.e(i6 == i29);
                this.n = 0;
            }
            i35++;
        }
        int i48 = i4 - 1;
        if (i48 != 0) {
            short[] sArr8 = this.l;
            int i49 = this.f12730b;
            System.arraycopy(sArr8, i48 * i49, sArr8, 0, (i4 - i48) * i49);
            this.s -= i48;
        }
    }

    public final void a(float f2) {
        this.o = f2;
    }

    public final void c(float f2) {
        this.p = f2;
    }

    public final void e(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i2 = this.f12730b;
        int i3 = iRemaining / i2;
        h(i3);
        shortBuffer.get(this.f12736h, this.q * this.f12730b, ((i2 * i3) << 1) / 2);
        this.q += i3;
        m();
    }

    public final void i(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f12730b, this.r);
        shortBuffer.put(this.f12738j, 0, this.f12730b * iMin);
        int i2 = this.r - iMin;
        this.r = i2;
        short[] sArr = this.f12738j;
        int i3 = this.f12730b;
        System.arraycopy(sArr, iMin * i3, sArr, 0, i2 * i3);
    }

    public final void k() {
        int i2;
        int i3 = this.q;
        float f2 = this.o;
        float f3 = this.p;
        int i4 = this.r + ((int) ((((i3 / (f2 / f3)) + this.s) / f3) + 0.5f));
        h((this.f12733e * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f12733e;
            int i6 = this.f12730b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f12736h[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.q += i2 * 2;
        m();
        if (this.r > i4) {
            this.r = i4;
        }
        this.q = 0;
        this.t = 0;
        this.s = 0;
    }

    public final int l() {
        return this.r;
    }
}
