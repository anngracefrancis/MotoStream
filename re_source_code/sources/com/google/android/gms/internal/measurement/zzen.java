package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzen extends zzdv {
    private static final Logger a = Logger.getLogger(zzen.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f17376b = k4.m();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    c2 f17377c;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    static class a extends zzen {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f17378d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f17379e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f17380f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f17381g;

        a(byte[] bArr, int i2, int i3) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i4 = i3 + 0;
            if ((i3 | 0 | (bArr.length - i4)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i3)));
            }
            this.f17378d = bArr;
            this.f17379e = 0;
            this.f17381g = 0;
            this.f17380f = i4;
        }

        private final void F0(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f17378d, this.f17381g, i3);
                this.f17381g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17381g), Integer.valueOf(this.f17380f), Integer.valueOf(i3)), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void O(int i2) throws IOException {
            if (!zzen.f17376b || k1.b() || b() < 5) {
                while ((i2 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f17378d;
                        int i3 = this.f17381g;
                        this.f17381g = i3 + 1;
                        bArr[i3] = (byte) ((i2 & 127) | 128);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17381g), Integer.valueOf(this.f17380f), 1), e2);
                    }
                }
                byte[] bArr2 = this.f17378d;
                int i4 = this.f17381g;
                this.f17381g = i4 + 1;
                bArr2[i4] = (byte) i2;
                return;
            }
            if ((i2 & (-128)) == 0) {
                byte[] bArr3 = this.f17378d;
                int i5 = this.f17381g;
                this.f17381g = i5 + 1;
                k4.l(bArr3, i5, (byte) i2);
                return;
            }
            byte[] bArr4 = this.f17378d;
            int i6 = this.f17381g;
            this.f17381g = i6 + 1;
            k4.l(bArr4, i6, (byte) (i2 | 128));
            int i7 = i2 >>> 7;
            if ((i7 & (-128)) == 0) {
                byte[] bArr5 = this.f17378d;
                int i8 = this.f17381g;
                this.f17381g = i8 + 1;
                k4.l(bArr5, i8, (byte) i7);
                return;
            }
            byte[] bArr6 = this.f17378d;
            int i9 = this.f17381g;
            this.f17381g = i9 + 1;
            k4.l(bArr6, i9, (byte) (i7 | 128));
            int i10 = i7 >>> 7;
            if ((i10 & (-128)) == 0) {
                byte[] bArr7 = this.f17378d;
                int i11 = this.f17381g;
                this.f17381g = i11 + 1;
                k4.l(bArr7, i11, (byte) i10);
                return;
            }
            byte[] bArr8 = this.f17378d;
            int i12 = this.f17381g;
            this.f17381g = i12 + 1;
            k4.l(bArr8, i12, (byte) (i10 | 128));
            int i13 = i10 >>> 7;
            if ((i13 & (-128)) == 0) {
                byte[] bArr9 = this.f17378d;
                int i14 = this.f17381g;
                this.f17381g = i14 + 1;
                k4.l(bArr9, i14, (byte) i13);
                return;
            }
            byte[] bArr10 = this.f17378d;
            int i15 = this.f17381g;
            this.f17381g = i15 + 1;
            k4.l(bArr10, i15, (byte) (i13 | 128));
            byte[] bArr11 = this.f17378d;
            int i16 = this.f17381g;
            this.f17381g = i16 + 1;
            k4.l(bArr11, i16, (byte) (i13 >>> 7));
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void P(int i2, int i3) throws IOException {
            m(i2, 0);
            j(i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void R(int i2, zzdu zzduVar) throws IOException {
            m(1, 3);
            X(2, i2);
            o(3, zzduVar);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void X(int i2, int i3) throws IOException {
            m(i2, 0);
            O(i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void Y(int i2, long j2) throws IOException {
            m(i2, 1);
            Z(j2);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void Z(long j2) throws IOException {
            try {
                byte[] bArr = this.f17378d;
                int i2 = this.f17381g;
                int i3 = i2 + 1;
                this.f17381g = i3;
                bArr[i2] = (byte) j2;
                int i4 = i3 + 1;
                this.f17381g = i4;
                bArr[i3] = (byte) (j2 >> 8);
                int i5 = i4 + 1;
                this.f17381g = i5;
                bArr[i4] = (byte) (j2 >> 16);
                int i6 = i5 + 1;
                this.f17381g = i6;
                bArr[i5] = (byte) (j2 >> 24);
                int i7 = i6 + 1;
                this.f17381g = i7;
                bArr[i6] = (byte) (j2 >> 32);
                int i8 = i7 + 1;
                this.f17381g = i8;
                bArr[i7] = (byte) (j2 >> 40);
                int i9 = i8 + 1;
                this.f17381g = i9;
                bArr[i8] = (byte) (j2 >> 48);
                this.f17381g = i9 + 1;
                bArr[i9] = (byte) (j2 >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17381g), Integer.valueOf(this.f17380f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzdv
        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            F0(bArr, i2, i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final int b() {
            return this.f17380f - this.f17381g;
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void e0(int i2) throws IOException {
            try {
                byte[] bArr = this.f17378d;
                int i3 = this.f17381g;
                int i4 = i3 + 1;
                this.f17381g = i4;
                bArr[i3] = (byte) i2;
                int i5 = i4 + 1;
                this.f17381g = i5;
                bArr[i4] = (byte) (i2 >> 8);
                int i6 = i5 + 1;
                this.f17381g = i6;
                bArr[i5] = (byte) (i2 >> 16);
                this.f17381g = i6 + 1;
                bArr[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17381g), Integer.valueOf(this.f17380f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void g(byte b2) throws IOException {
            try {
                byte[] bArr = this.f17378d;
                int i2 = this.f17381g;
                this.f17381g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17381g), Integer.valueOf(this.f17380f), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void j(int i2) throws IOException {
            if (i2 >= 0) {
                O(i2);
            } else {
                t(i2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void j0(int i2, int i3) throws IOException {
            m(i2, 5);
            e0(i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void m(int i2, int i3) throws IOException {
            O((i2 << 3) | i3);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void n(int i2, long j2) throws IOException {
            m(i2, 0);
            t(j2);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void o(int i2, zzdu zzduVar) throws IOException {
            m(i2, 2);
            u(zzduVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void p(int i2, zzgo zzgoVar) throws IOException {
            m(1, 3);
            X(2, i2);
            m(3, 2);
            v(zzgoVar);
            m(1, 4);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        final void q(int i2, zzgo zzgoVar, p3 p3Var) throws IOException {
            m(i2, 2);
            zzdl zzdlVar = (zzdl) zzgoVar;
            int iK = zzdlVar.k();
            if (iK == -1) {
                iK = p3Var.b(zzdlVar);
                zzdlVar.l(iK);
            }
            O(iK);
            p3Var.h(zzgoVar, this.f17377c);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void r(int i2, String str) throws IOException {
            m(i2, 2);
            w(str);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void s(int i2, boolean z) throws IOException {
            m(i2, 0);
            g(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void t(long j2) throws IOException {
            if (zzen.f17376b && b() >= 10) {
                while ((j2 & (-128)) != 0) {
                    byte[] bArr = this.f17378d;
                    int i2 = this.f17381g;
                    this.f17381g = i2 + 1;
                    k4.l(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr2 = this.f17378d;
                int i3 = this.f17381g;
                this.f17381g = i3 + 1;
                k4.l(bArr2, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f17378d;
                    int i4 = this.f17381g;
                    this.f17381g = i4 + 1;
                    bArr3[i4] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f17381g), Integer.valueOf(this.f17380f), 1), e2);
                }
            }
            byte[] bArr4 = this.f17378d;
            int i5 = this.f17381g;
            this.f17381g = i5 + 1;
            bArr4[i5] = (byte) j2;
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void u(zzdu zzduVar) throws IOException {
            O(zzduVar.f());
            zzduVar.s(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void v(zzgo zzgoVar) throws IOException {
            O(zzgoVar.i());
            zzgoVar.g(this);
        }

        @Override // com.google.android.gms.internal.measurement.zzen
        public final void w(String str) throws IOException {
            int i2 = this.f17381g;
            try {
                int iO0 = zzen.o0(str.length() * 3);
                int iO1 = zzen.o0(str.length());
                if (iO1 != iO0) {
                    O(n4.d(str));
                    this.f17381g = n4.e(str, this.f17378d, this.f17381g, b());
                    return;
                }
                int i3 = i2 + iO1;
                this.f17381g = i3;
                int iE = n4.e(str, this.f17378d, i3, b());
                this.f17381g = i2;
                O((iE - i2) - iO1);
                this.f17381g = iE;
            } catch (q4 e2) {
                this.f17381g = i2;
                x(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zza(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzen() {
    }

    public static int A(float f2) {
        return 4;
    }

    public static int A0(int i2, int i3) {
        return g0(i2) + 4;
    }

    public static int B(int i2, double d2) {
        return g0(i2) + 8;
    }

    public static int B0(int i2) {
        return k0(i2);
    }

    public static int C(int i2, float f2) {
        return g0(i2) + 4;
    }

    public static int C0(int i2, int i3) {
        return g0(i2) + k0(i3);
    }

    public static int D(int i2, zzft zzftVar) {
        return (g0(1) << 1) + p0(2, i2) + c(3, zzftVar);
    }

    @Deprecated
    public static int D0(int i2) {
        return o0(i2);
    }

    public static int E(int i2, zzgo zzgoVar) {
        return (g0(1) << 1) + p0(2, i2) + g0(3) + J(zzgoVar);
    }

    private static int E0(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    static int F(int i2, zzgo zzgoVar, p3 p3Var) {
        return g0(i2) + e(zzgoVar, p3Var);
    }

    public static int G(int i2, String str) {
        return g0(i2) + K(str);
    }

    public static int H(int i2, boolean z) {
        return g0(i2) + 1;
    }

    public static int I(zzdu zzduVar) {
        int iF = zzduVar.f();
        return o0(iF) + iF;
    }

    public static int J(zzgo zzgoVar) {
        int i2 = zzgoVar.i();
        return o0(i2) + i2;
    }

    public static int K(String str) {
        int length;
        try {
            length = n4.d(str);
        } catch (q4 unused) {
            length = str.getBytes(zzff.a).length;
        }
        return o0(length) + length;
    }

    public static int L(boolean z) {
        return 1;
    }

    public static int M(byte[] bArr) {
        int length = bArr.length;
        return o0(length) + length;
    }

    public static int T(int i2, zzdu zzduVar) {
        int iG0 = g0(i2);
        int iF = zzduVar.f();
        return iG0 + o0(iF) + iF;
    }

    @Deprecated
    static int U(int i2, zzgo zzgoVar, p3 p3Var) {
        int iG0 = g0(i2) << 1;
        zzdl zzdlVar = (zzdl) zzgoVar;
        int iK = zzdlVar.k();
        if (iK == -1) {
            iK = p3Var.b(zzdlVar);
            zzdlVar.l(iK);
        }
        return iG0 + iK;
    }

    @Deprecated
    public static int V(zzgo zzgoVar) {
        return zzgoVar.i();
    }

    public static int b0(int i2, long j2) {
        return g0(i2) + i0(j2);
    }

    public static int c(int i2, zzft zzftVar) {
        int iG0 = g0(i2);
        int iB = zzftVar.b();
        return iG0 + o0(iB) + iB;
    }

    public static int c0(int i2, zzdu zzduVar) {
        return (g0(1) << 1) + p0(2, i2) + T(3, zzduVar);
    }

    public static int d(zzft zzftVar) {
        int iB = zzftVar.b();
        return o0(iB) + iB;
    }

    public static int d0(long j2) {
        return i0(j2);
    }

    static int e(zzgo zzgoVar, p3 p3Var) {
        zzdl zzdlVar = (zzdl) zzgoVar;
        int iK = zzdlVar.k();
        if (iK == -1) {
            iK = p3Var.b(zzdlVar);
            zzdlVar.l(iK);
        }
        return o0(iK) + iK;
    }

    public static zzen f(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int g0(int i2) {
        return o0(i2 << 3);
    }

    public static int h0(int i2, long j2) {
        return g0(i2) + i0(j2);
    }

    public static int i0(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public static int k0(int i2) {
        if (i2 >= 0) {
            return o0(i2);
        }
        return 10;
    }

    public static int l0(int i2, int i3) {
        return g0(i2) + k0(i3);
    }

    public static int m0(int i2, long j2) {
        return g0(i2) + i0(y0(j2));
    }

    public static int n0(long j2) {
        return i0(y0(j2));
    }

    public static int o0(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int p0(int i2, int i3) {
        return g0(i2) + o0(i3);
    }

    public static int q0(int i2, long j2) {
        return g0(i2) + 8;
    }

    public static int r0(long j2) {
        return 8;
    }

    public static int s0(int i2) {
        return o0(E0(i2));
    }

    public static int t0(int i2, int i3) {
        return g0(i2) + o0(E0(i3));
    }

    public static int u0(int i2, long j2) {
        return g0(i2) + 8;
    }

    public static int v0(long j2) {
        return 8;
    }

    public static int w0(int i2) {
        return 4;
    }

    public static int x0(int i2, int i3) {
        return g0(i2) + 4;
    }

    private static long y0(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int z(double d2) {
        return 8;
    }

    public static int z0(int i2) {
        return 4;
    }

    public final void N() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void O(int i2) throws IOException;

    public abstract void P(int i2, int i3) throws IOException;

    public final void Q(int i2, long j2) throws IOException {
        n(i2, y0(j2));
    }

    public abstract void R(int i2, zzdu zzduVar) throws IOException;

    public final void S(long j2) throws IOException {
        t(y0(j2));
    }

    public final void W(int i2) throws IOException {
        O(E0(i2));
    }

    public abstract void X(int i2, int i3) throws IOException;

    public abstract void Y(int i2, long j2) throws IOException;

    public abstract void Z(long j2) throws IOException;

    public abstract int b();

    public abstract void e0(int i2) throws IOException;

    public final void f0(int i2, int i3) throws IOException {
        X(i2, E0(i3));
    }

    public abstract void g(byte b2) throws IOException;

    public final void h(double d2) throws IOException {
        Z(Double.doubleToRawLongBits(d2));
    }

    public final void i(float f2) throws IOException {
        e0(Float.floatToRawIntBits(f2));
    }

    public abstract void j(int i2) throws IOException;

    public abstract void j0(int i2, int i3) throws IOException;

    public final void k(int i2, double d2) throws IOException {
        Y(i2, Double.doubleToRawLongBits(d2));
    }

    public final void l(int i2, float f2) throws IOException {
        j0(i2, Float.floatToRawIntBits(f2));
    }

    public abstract void m(int i2, int i3) throws IOException;

    public abstract void n(int i2, long j2) throws IOException;

    public abstract void o(int i2, zzdu zzduVar) throws IOException;

    public abstract void p(int i2, zzgo zzgoVar) throws IOException;

    abstract void q(int i2, zzgo zzgoVar, p3 p3Var) throws IOException;

    public abstract void r(int i2, String str) throws IOException;

    public abstract void s(int i2, boolean z) throws IOException;

    public abstract void t(long j2) throws IOException;

    public abstract void u(zzdu zzduVar) throws IOException;

    public abstract void v(zzgo zzgoVar) throws IOException;

    public abstract void w(String str) throws IOException;

    final void x(String str, q4 q4Var) throws IOException {
        a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) q4Var);
        byte[] bytes = str.getBytes(zzff.a);
        try {
            O(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zza e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zza(e3);
        }
    }

    public final void y(boolean z) throws IOException {
        g(z ? (byte) 1 : (byte) 0);
    }
}
