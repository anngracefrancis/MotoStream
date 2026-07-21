package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdqu {
    private static final zzdqu a = new zzdqu(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f16053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f16054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f16056f;

    private zzdqu() {
        this(0, new int[8], new Object[8], true);
    }

    static zzdqu a(zzdqu zzdquVar, zzdqu zzdquVar2) {
        int i2 = zzdquVar.f16052b + zzdquVar2.f16052b;
        int[] iArrCopyOf = Arrays.copyOf(zzdquVar.f16053c, i2);
        System.arraycopy(zzdquVar2.f16053c, 0, iArrCopyOf, zzdquVar.f16052b, zzdquVar2.f16052b);
        Object[] objArrCopyOf = Arrays.copyOf(zzdquVar.f16054d, i2);
        System.arraycopy(zzdquVar2.f16054d, 0, objArrCopyOf, zzdquVar.f16052b, zzdquVar2.f16052b);
        return new zzdqu(i2, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzdqu f() {
        return a;
    }

    private static void g(int i2, Object obj, ux uxVar) throws IOException {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            uxVar.J(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            uxVar.B(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            uxVar.I(i3, (zzdmr) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new RuntimeException(zzdok.f());
            }
            uxVar.D(i3, ((Integer) obj).intValue());
        } else if (uxVar.F() == zzdob.zze.l) {
            uxVar.Q(i3);
            ((zzdqu) obj).h(uxVar);
            uxVar.C(i3);
        } else {
            uxVar.C(i3);
            ((zzdqu) obj).h(uxVar);
            uxVar.Q(i3);
        }
    }

    static zzdqu i() {
        return new zzdqu();
    }

    final void b(ux uxVar) throws IOException {
        if (uxVar.F() == zzdob.zze.m) {
            for (int i2 = this.f16052b - 1; i2 >= 0; i2--) {
                uxVar.G(this.f16053c[i2] >>> 3, this.f16054d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f16052b; i3++) {
            uxVar.G(this.f16053c[i3] >>> 3, this.f16054d[i3]);
        }
    }

    final void c(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f16052b; i3++) {
            zv.c(sb, i2, String.valueOf(this.f16053c[i3] >>> 3), this.f16054d[i3]);
        }
    }

    public final void d() {
        this.f16056f = false;
    }

    public final int e() {
        int iB0;
        int i2 = this.f16055e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f16052b; i4++) {
            int i5 = this.f16053c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                iB0 = zzdni.B0(i6, ((Long) this.f16054d[i4]).longValue());
            } else if (i7 == 1) {
                iB0 = zzdni.F0(i6, ((Long) this.f16054d[i4]).longValue());
            } else if (i7 == 2) {
                iB0 = zzdni.J(i6, (zzdmr) this.f16054d[i4]);
            } else if (i7 == 3) {
                iB0 = (zzdni.h0(i6) << 1) + ((zzdqu) this.f16054d[i4]).e();
            } else {
                if (i7 != 5) {
                    throw new IllegalStateException(zzdok.f());
                }
                iB0 = zzdni.r(i6, ((Integer) this.f16054d[i4]).intValue());
            }
            i3 += iB0;
        }
        this.f16055e = i3;
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0046 A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzdqu)) {
            return false;
        }
        zzdqu zzdquVar = (zzdqu) obj;
        int i2 = this.f16052b;
        if (i2 == zzdquVar.f16052b) {
            int[] iArr = this.f16053c;
            int[] iArr2 = zzdquVar.f16053c;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    z = true;
                    break;
                }
                if (iArr[i3] != iArr2[i3]) {
                    z = false;
                    break;
                }
                i3++;
            }
            if (z) {
                Object[] objArr = this.f16054d;
                Object[] objArr2 = zzdquVar.f16054d;
                int i4 = this.f16052b;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (!objArr[i5].equals(objArr2[i5])) {
                        z2 = false;
                        if (!z2) {
                            return true;
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void h(ux uxVar) throws IOException {
        if (this.f16052b == 0) {
            return;
        }
        if (uxVar.F() == zzdob.zze.l) {
            for (int i2 = 0; i2 < this.f16052b; i2++) {
                g(this.f16053c[i2], this.f16054d[i2], uxVar);
            }
            return;
        }
        for (int i3 = this.f16052b - 1; i3 >= 0; i3--) {
            g(this.f16053c[i3], this.f16054d[i3], uxVar);
        }
    }

    public final int hashCode() {
        int i2 = this.f16052b;
        int i3 = (i2 + 527) * 31;
        int[] iArr = this.f16053c;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i3 + i4) * 31;
        Object[] objArr = this.f16054d;
        int i7 = this.f16052b;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }

    public final int j() {
        int i2 = this.f16055e;
        if (i2 != -1) {
            return i2;
        }
        int iN = 0;
        for (int i3 = 0; i3 < this.f16052b; i3++) {
            iN += zzdni.N(this.f16053c[i3] >>> 3, (zzdmr) this.f16054d[i3]);
        }
        this.f16055e = iN;
        return iN;
    }

    final void k(int i2, Object obj) {
        if (!this.f16056f) {
            throw new UnsupportedOperationException();
        }
        int i3 = this.f16052b;
        int[] iArr = this.f16053c;
        if (i3 == iArr.length) {
            int i4 = i3 + (i3 < 4 ? 8 : i3 >> 1);
            this.f16053c = Arrays.copyOf(iArr, i4);
            this.f16054d = Arrays.copyOf(this.f16054d, i4);
        }
        int[] iArr2 = this.f16053c;
        int i5 = this.f16052b;
        iArr2[i5] = i2;
        this.f16054d[i5] = obj;
        this.f16052b = i5 + 1;
    }

    private zzdqu(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f16055e = -1;
        this.f16052b = i2;
        this.f16053c = iArr;
        this.f16054d = objArr;
        this.f16056f = z;
    }
}
