package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
final class pu extends zzdnd {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f13183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f13184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13188k;
    private int l;
    private int m;

    private pu(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.m = Integer.MAX_VALUE;
        this.f13183f = bArr;
        this.f13185h = i3 + i2;
        this.f13187j = i2;
        this.f13188k = i2;
        this.f13184g = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int C() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f13187j
            int r1 = r5.f13185h
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f13183f
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f13187j = r3
            return r0
        L11:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6b
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L22
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L68
        L22:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L2f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2d:
            r1 = r3
            goto L68
        L2f:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L68
        L3d:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L68
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2d
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 < 0) goto L6b
        L68:
            r5.f13187j = r1
            return r0
        L6b:
            long r0 = r5.s()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.pu.C():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long D() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f13187j
            int r1 = r11.f13185h
            if (r1 == r0) goto Lb8
            byte[] r2 = r11.f13183f
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r11.f13187j = r3
            long r0 = (long) r0
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto Lb8
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L25
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
        L22:
            long r2 = (long) r0
            goto Lb5
        L25:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L36
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto Lb5
        L36:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L44
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L22
        L44:
            long r3 = (long) r0
            int r0 = r1 + 1
            r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L5b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L57:
            long r1 = r1 ^ r3
            r2 = r1
            r1 = r0
            goto Lb5
        L5b:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L70
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L6d:
            long r3 = r3 ^ r5
        L6e:
            r2 = r3
            goto Lb5
        L70:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L83
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L57
        L83:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L96
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L6d
        L96:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto Lb3
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto Lb8
            goto L6e
        Lb3:
            r1 = r0
            goto L6e
        Lb5:
            r11.f13187j = r1
            return r2
        Lb8:
            long r0 = r11.s()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.pu.D():long");
    }

    private final int E() throws IOException {
        int i2 = this.f13187j;
        if (this.f13185h - i2 < 4) {
            throw zzdok.a();
        }
        byte[] bArr = this.f13183f;
        this.f13187j = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private final long F() throws IOException {
        int i2 = this.f13187j;
        if (this.f13185h - i2 < 8) {
            throw zzdok.a();
        }
        byte[] bArr = this.f13183f;
        this.f13187j = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private final void G() {
        int i2 = this.f13185h + this.f13186i;
        this.f13185h = i2;
        int i3 = i2 - this.f13188k;
        int i4 = this.m;
        if (i3 <= i4) {
            this.f13186i = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f13186i = i5;
        this.f13185h = i2 - i5;
    }

    private final byte H() throws IOException {
        int i2 = this.f13187j;
        if (i2 == this.f13185h) {
            throw zzdok.a();
        }
        byte[] bArr = this.f13183f;
        this.f13187j = i2 + 1;
        return bArr[i2];
    }

    private final void I(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f13185h;
            int i4 = this.f13187j;
            if (i2 <= i3 - i4) {
                this.f13187j = i4 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw zzdok.a();
        }
        throw zzdok.b();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final void A(int i2) {
        this.m = i2;
        G();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final double a() throws IOException {
        return Double.longBitsToDouble(F());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final float b() throws IOException {
        return Float.intBitsToFloat(E());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final String c() throws IOException {
        int iC = C();
        if (iC > 0 && iC <= this.f13185h - this.f13187j) {
            String str = new String(this.f13183f, this.f13187j, iC, zzdod.a);
            this.f13187j += iC;
            return str;
        }
        if (iC == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iC < 0) {
            throw zzdok.b();
        }
        throw zzdok.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int d() throws IOException {
        if (t()) {
            this.l = 0;
            return 0;
        }
        int iC = C();
        this.l = iC;
        if ((iC >>> 3) != 0) {
            return iC;
        }
        throw zzdok.d();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long e() throws IOException {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long f() throws IOException {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int g() throws IOException {
        return C();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long h() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int i() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final boolean j() throws IOException {
        return D() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final String k() throws IOException {
        int iC = C();
        if (iC > 0) {
            int i2 = this.f13185h;
            int i3 = this.f13187j;
            if (iC <= i2 - i3) {
                String strM = jx.m(this.f13183f, i3, iC);
                this.f13187j += iC;
                return strM;
            }
        }
        if (iC == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iC <= 0) {
            throw zzdok.b();
        }
        throw zzdok.a();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    @Override // com.google.android.gms.internal.ads.zzdnd
    public final zzdmr l() throws IOException {
        byte[] bArrCopyOfRange;
        int iC = C();
        if (iC > 0) {
            int i2 = this.f13185h;
            int i3 = this.f13187j;
            if (iC <= i2 - i3) {
                zzdmr zzdmrVarA = zzdmr.A(this.f13183f, i3, iC);
                this.f13187j += iC;
                return zzdmrVarA;
            }
        }
        if (iC == 0) {
            return zzdmr.f15982f;
        }
        if (iC > 0) {
            int i4 = this.f13185h;
            int i5 = this.f13187j;
            if (iC <= i4 - i5) {
                int i6 = iC + i5;
                this.f13187j = i6;
                bArrCopyOfRange = Arrays.copyOfRange(this.f13183f, i5, i6);
            } else {
                if (iC <= 0) {
                    throw zzdok.a();
                }
                if (iC == 0) {
                    throw zzdok.b();
                }
                bArrCopyOfRange = zzdod.f16033c;
            }
        } else {
            if (iC <= 0) {
                throw zzdok.a();
            }
            if (iC == 0) {
                throw zzdok.b();
            }
            bArrCopyOfRange = zzdod.f16033c;
        }
        return zzdmr.i(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int m() throws IOException {
        return C();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int n() throws IOException {
        return C();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int o() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long p() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int q() throws IOException {
        return zzdnd.B(C());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final long r() throws IOException {
        return zzdnd.w(D());
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    final long s() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte bH = H();
            j2 |= ((long) (bH & 127)) << i2;
            if ((bH & 128) == 0) {
                return j2;
            }
        }
        throw zzdok.c();
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final boolean t() throws IOException {
        return this.f13187j == this.f13185h;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int u() {
        return this.f13187j - this.f13188k;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final void x(int i2) throws zzdok {
        if (this.l != i2) {
            throw zzdok.e();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final boolean y(int i2) throws IOException {
        int iD;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.f13185h - this.f13187j < 10) {
                while (i4 < 10) {
                    if (H() < 0) {
                        i4++;
                    }
                }
                throw zzdok.c();
            }
            while (i4 < 10) {
                byte[] bArr = this.f13183f;
                int i5 = this.f13187j;
                this.f13187j = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                }
            }
            throw zzdok.c();
            return true;
        }
        if (i3 == 1) {
            I(8);
            return true;
        }
        if (i3 == 2) {
            I(C());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw zzdok.f();
            }
            I(4);
            return true;
        }
        do {
            iD = d();
            if (iD == 0) {
                break;
            }
        } while (y(iD));
        x(((i2 >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdnd
    public final int z(int i2) throws zzdok {
        if (i2 < 0) {
            throw zzdok.b();
        }
        int iU = i2 + u();
        int i3 = this.m;
        if (iU > i3) {
            throw zzdok.a();
        }
        this.m = iU;
        G();
        return i3;
    }
}
