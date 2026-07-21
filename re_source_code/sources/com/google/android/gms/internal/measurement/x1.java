package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class x1 extends zzeg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f17284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f17286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f17287i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17288j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f17289k;
    private int l;
    private int m;

    private x1(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.m = Integer.MAX_VALUE;
        this.f17284f = bArr;
        this.f17286h = i3 + i2;
        this.f17288j = i2;
        this.f17289k = i2;
        this.f17285g = z;
    }

    private final byte C() throws IOException {
        int i2 = this.f17288j;
        if (i2 == this.f17286h) {
            throw zzfo.a();
        }
        byte[] bArr = this.f17284f;
        this.f17288j = i2 + 1;
        return bArr[i2];
    }

    private final void D(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f17286h;
            int i4 = this.f17288j;
            if (i2 <= i3 - i4) {
                this.f17288j = i4 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw zzfo.a();
        }
        throw zzfo.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (r2[r3] >= 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int E() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f17288j
            int r1 = r5.f17286h
            if (r1 == r0) goto L6b
            byte[] r2 = r5.f17284f
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L11
            r5.f17288j = r3
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
            r5.f17288j = r1
            return r0
        L6b:
            long r0 = r5.z()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.x1.E():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b0, code lost:
    
        if (r2[r0] >= 0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long F() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f17288j
            int r1 = r11.f17286h
            if (r1 == r0) goto Lb8
            byte[] r2 = r11.f17284f
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r11.f17288j = r3
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
            r11.f17288j = r1
            return r2
        Lb8:
            long r0 = r11.z()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.x1.F():long");
    }

    private final int G() throws IOException {
        int i2 = this.f17288j;
        if (this.f17286h - i2 < 4) {
            throw zzfo.a();
        }
        byte[] bArr = this.f17284f;
        this.f17288j = i2 + 4;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private final long H() throws IOException {
        int i2 = this.f17288j;
        if (this.f17286h - i2 < 8) {
            throw zzfo.a();
        }
        byte[] bArr = this.f17284f;
        this.f17288j = i2 + 8;
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    private final void I() {
        int i2 = this.f17286h + this.f17287i;
        this.f17286h = i2;
        int i3 = i2 - this.f17289k;
        int i4 = this.m;
        if (i3 <= i4) {
            this.f17287i = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f17287i = i5;
        this.f17286h = i2 - i5;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean A() throws IOException {
        return this.f17288j == this.f17286h;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int B() {
        return this.f17288j - this.f17289k;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int a() throws IOException {
        if (A()) {
            this.l = 0;
            return 0;
        }
        int iE = E();
        this.l = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw zzfo.d();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final void d(int i2) throws zzfo {
        if (this.l != i2) {
            throw zzfo.e();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final double e() throws IOException {
        return Double.longBitsToDouble(H());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean f(int i2) throws IOException {
        int iA;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.f17286h - this.f17288j < 10) {
                while (i4 < 10) {
                    if (C() < 0) {
                        i4++;
                    }
                }
                throw zzfo.c();
            }
            while (i4 < 10) {
                byte[] bArr = this.f17284f;
                int i5 = this.f17288j;
                this.f17288j = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                }
            }
            throw zzfo.c();
            return true;
        }
        if (i3 == 1) {
            D(8);
            return true;
        }
        if (i3 == 2) {
            D(E());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw zzfo.f();
            }
            D(4);
            return true;
        }
        do {
            iA = a();
            if (iA == 0) {
                break;
            }
        } while (f(iA));
        d(((i2 >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final float g() throws IOException {
        return Float.intBitsToFloat(G());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int h(int i2) throws zzfo {
        if (i2 < 0) {
            throw zzfo.b();
        }
        int iB = i2 + B();
        int i3 = this.m;
        if (iB > i3) {
            throw zzfo.a();
        }
        this.m = iB;
        I();
        return i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long i() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final void j(int i2) {
        this.m = i2;
        I();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long l() throws IOException {
        return F();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int m() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long n() throws IOException {
        return H();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int o() throws IOException {
        return G();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean p() throws IOException {
        return F() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final String q() throws IOException {
        int iE = E();
        if (iE > 0 && iE <= this.f17286h - this.f17288j) {
            String str = new String(this.f17284f, this.f17288j, iE, zzff.a);
            this.f17288j += iE;
            return str;
        }
        if (iE == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iE < 0) {
            throw zzfo.b();
        }
        throw zzfo.a();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final String r() throws IOException {
        int iE = E();
        if (iE > 0) {
            int i2 = this.f17286h;
            int i3 = this.f17288j;
            if (iE <= i2 - i3) {
                String strK = n4.k(this.f17284f, i3, iE);
                this.f17288j += iE;
                return strK;
            }
        }
        if (iE == 0) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (iE <= 0) {
            throw zzfo.b();
        }
        throw zzfo.a();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    @Override // com.google.android.gms.internal.measurement.zzeg
    public final zzdu s() throws IOException {
        byte[] bArrCopyOfRange;
        int iE = E();
        if (iE > 0) {
            int i2 = this.f17286h;
            int i3 = this.f17288j;
            if (iE <= i2 - i3) {
                zzdu zzduVarQ = zzdu.q(this.f17284f, i3, iE);
                this.f17288j += iE;
                return zzduVarQ;
            }
        }
        if (iE == 0) {
            return zzdu.f17368f;
        }
        if (iE > 0) {
            int i4 = this.f17286h;
            int i5 = this.f17288j;
            if (iE <= i4 - i5) {
                int i6 = iE + i5;
                this.f17288j = i6;
                bArrCopyOfRange = Arrays.copyOfRange(this.f17284f, i5, i6);
            } else {
                if (iE <= 0) {
                    throw zzfo.a();
                }
                if (iE == 0) {
                    throw zzfo.b();
                }
                bArrCopyOfRange = zzff.f17408c;
            }
        } else {
            if (iE <= 0) {
                throw zzfo.a();
            }
            if (iE == 0) {
                throw zzfo.b();
            }
            bArrCopyOfRange = zzff.f17408c;
        }
        return zzdu.o(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int t() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int u() throws IOException {
        return E();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int v() throws IOException {
        return G();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long w() throws IOException {
        return H();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int x() throws IOException {
        return zzeg.k(E());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long y() throws IOException {
        return zzeg.b(F());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    final long z() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte bC = C();
            j2 |= ((long) (bC & 127)) << i2;
            if ((bC & 128) == 0) {
                return j2;
            }
        }
        throw zzfo.c();
    }
}
