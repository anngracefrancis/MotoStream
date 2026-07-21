package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class aw<T> implements lw<T> {
    private static final int[] a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Unsafe f12268b = gx.r();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f12269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f12270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f12272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdpk f12273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f12274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f12275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f12276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f12277k;
    private final int[] l;
    private final int m;
    private final int n;
    private final cw o;
    private final kv p;
    private final cx<?, ?> q;
    private final vu<?> r;
    private final uv s;

    private aw(int[] iArr, Object[] objArr, int i2, int i3, zzdpk zzdpkVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, cw cwVar, kv kvVar, cx<?, ?> cxVar, vu<?> vuVar, uv uvVar) {
        this.f12269c = iArr;
        this.f12270d = objArr;
        this.f12271e = i2;
        this.f12272f = i3;
        this.f12275i = zzdpkVar instanceof zzdob;
        this.f12276j = z;
        this.f12274h = vuVar != null && vuVar.h(zzdpkVar);
        this.f12277k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = cwVar;
        this.p = kvVar;
        this.q = cxVar;
        this.r = vuVar;
        this.f12273g = zzdpkVar;
        this.s = uvVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean A(Object obj, int i2, lw lwVar) {
        return lwVar.j(gx.L(obj, i2 & 1048575));
    }

    private final int B(int i2, int i3) {
        if (i2 < this.f12271e || i2 > this.f12272f) {
            return -1;
        }
        return C(i2, i3);
    }

    private final int C(int i2, int i3) {
        int length = (this.f12269c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f12269c[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static zzdqu D(Object obj) {
        zzdob zzdobVar = (zzdob) obj;
        zzdqu zzdquVar = zzdobVar.zzhhd;
        if (zzdquVar != zzdqu.f()) {
            return zzdquVar;
        }
        zzdqu zzdquVarI = zzdqu.i();
        zzdobVar.zzhhd = zzdquVarI;
        return zzdquVarI;
    }

    private final void E(T t, int i2, int i3) {
        gx.n(t, R(i3) & 1048575, i2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private final void F(T t, ux uxVar) throws IOException {
        Iterator itE;
        Map.Entry<?, ?> entry;
        int i2;
        if (this.f12274h) {
            yu<T> yuVarI = this.r.i(t);
            if (yuVarI.b()) {
                itE = null;
                entry = null;
            } else {
                itE = yuVarI.e();
                entry = (Map.Entry) itE.next();
            }
        } else {
            itE = null;
            entry = null;
        }
        int i3 = -1;
        int length = this.f12269c.length;
        Unsafe unsafe = f12268b;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iQ = Q(i4);
            int[] iArr = this.f12269c;
            int i6 = iArr[i4];
            int i7 = (267386880 & iQ) >>> 20;
            if (this.f12276j || i7 > 17) {
                i2 = 0;
            } else {
                int i8 = iArr[i4 + 2];
                int i9 = i8 & 1048575;
                if (i9 != i3) {
                    i5 = unsafe.getInt(t, i9);
                    i3 = i9;
                }
                i2 = 1 << (i8 >>> 20);
            }
            while (entry != null && this.r.a(entry) <= i6) {
                this.r.f(uxVar, entry);
                entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
            }
            long j2 = iQ & 1048575;
            int i10 = i4;
            switch (i7) {
                case 0:
                    if ((i2 & i5) != 0) {
                        uxVar.E(i6, gx.K(t, j2));
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 1:
                    if ((i2 & i5) != 0) {
                        uxVar.r(i6, gx.I(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 2:
                    if ((i2 & i5) != 0) {
                        uxVar.J(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 3:
                    if ((i2 & i5) != 0) {
                        uxVar.L(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 4:
                    if ((i2 & i5) != 0) {
                        uxVar.T(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 5:
                    if ((i2 & i5) != 0) {
                        uxVar.B(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 6:
                    if ((i2 & i5) != 0) {
                        uxVar.D(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 7:
                    if ((i2 & i5) != 0) {
                        uxVar.R(i6, gx.H(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 8:
                    if ((i2 & i5) != 0) {
                        t(i6, unsafe.getObject(t, j2), uxVar);
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 9:
                    if ((i2 & i5) != 0) {
                        uxVar.Y(i6, unsafe.getObject(t, j2), N(i10));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 10:
                    if ((i2 & i5) != 0) {
                        uxVar.I(i6, (zzdmr) unsafe.getObject(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 11:
                    if ((i2 & i5) != 0) {
                        uxVar.K(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 12:
                    if ((i2 & i5) != 0) {
                        uxVar.N(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 13:
                    if ((i2 & i5) != 0) {
                        uxVar.H(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 14:
                    if ((i2 & i5) != 0) {
                        uxVar.M(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 15:
                    if ((i2 & i5) != 0) {
                        uxVar.O(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 16:
                    if ((i2 & i5) != 0) {
                        uxVar.P(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 17:
                    if ((i2 & i5) != 0) {
                        uxVar.U(i6, unsafe.getObject(t, j2), N(i10));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 18:
                    nw.e(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 19:
                    nw.x(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 20:
                    nw.C(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 21:
                    nw.F(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 22:
                    nw.K(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 23:
                    nw.I(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 24:
                    nw.O(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 25:
                    nw.R(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 26:
                    nw.c(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar);
                    break;
                case 27:
                    nw.d(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, N(i10));
                    break;
                case 28:
                    nw.v(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar);
                    break;
                case 29:
                    nw.M(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 30:
                    nw.Q(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 31:
                    nw.P(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 32:
                    nw.J(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 33:
                    nw.N(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 34:
                    nw.G(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 35:
                    nw.e(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 36:
                    nw.x(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 37:
                    nw.C(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 38:
                    nw.F(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 39:
                    nw.K(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 40:
                    nw.I(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 41:
                    nw.O(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 42:
                    nw.R(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 43:
                    nw.M(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 44:
                    nw.Q(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 45:
                    nw.P(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 46:
                    nw.J(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 47:
                    nw.N(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 48:
                    nw.G(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, true);
                    break;
                case 49:
                    nw.w(this.f12269c[i10], (List) unsafe.getObject(t, j2), uxVar, N(i10));
                    break;
                case 50:
                    v(uxVar, i6, unsafe.getObject(t, j2), i10);
                    break;
                case 51:
                    if (y(t, i6, i10)) {
                        uxVar.E(i6, L(t, j2));
                    }
                    break;
                case 52:
                    if (y(t, i6, i10)) {
                        uxVar.r(i6, M(t, j2));
                    }
                    break;
                case 53:
                    if (y(t, i6, i10)) {
                        uxVar.J(i6, V(t, j2));
                    }
                    break;
                case 54:
                    if (y(t, i6, i10)) {
                        uxVar.L(i6, V(t, j2));
                    }
                    break;
                case 55:
                    if (y(t, i6, i10)) {
                        uxVar.T(i6, U(t, j2));
                    }
                    break;
                case 56:
                    if (y(t, i6, i10)) {
                        uxVar.B(i6, V(t, j2));
                    }
                    break;
                case 57:
                    if (y(t, i6, i10)) {
                        uxVar.D(i6, U(t, j2));
                    }
                    break;
                case 58:
                    if (y(t, i6, i10)) {
                        uxVar.R(i6, W(t, j2));
                    }
                    break;
                case 59:
                    if (y(t, i6, i10)) {
                        t(i6, unsafe.getObject(t, j2), uxVar);
                    }
                    break;
                case 60:
                    if (y(t, i6, i10)) {
                        uxVar.Y(i6, unsafe.getObject(t, j2), N(i10));
                    }
                    break;
                case 61:
                    if (y(t, i6, i10)) {
                        uxVar.I(i6, (zzdmr) unsafe.getObject(t, j2));
                    }
                    break;
                case 62:
                    if (y(t, i6, i10)) {
                        uxVar.K(i6, U(t, j2));
                    }
                    break;
                case 63:
                    if (y(t, i6, i10)) {
                        uxVar.N(i6, U(t, j2));
                    }
                    break;
                case 64:
                    if (y(t, i6, i10)) {
                        uxVar.H(i6, U(t, j2));
                    }
                    break;
                case 65:
                    if (y(t, i6, i10)) {
                        uxVar.M(i6, V(t, j2));
                    }
                    break;
                case 66:
                    if (y(t, i6, i10)) {
                        uxVar.O(i6, U(t, j2));
                    }
                    break;
                case 67:
                    if (y(t, i6, i10)) {
                        uxVar.P(i6, V(t, j2));
                    }
                    break;
                case 68:
                    if (y(t, i6, i10)) {
                        uxVar.U(i6, unsafe.getObject(t, j2), N(i10));
                    }
                    break;
            }
            i4 = i10 + 3;
        }
        while (entry != null) {
            this.r.f(uxVar, entry);
            entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
        }
        u(this.q, t, uxVar);
    }

    private final void G(T t, T t2, int i2) {
        int iQ = Q(i2);
        int i3 = this.f12269c[i2];
        long j2 = iQ & 1048575;
        if (y(t2, i3, i2)) {
            Object objL = gx.L(t, j2);
            Object objL2 = gx.L(t2, j2);
            if (objL != null && objL2 != null) {
                gx.g(t, j2, zzdod.g(objL, objL2));
                E(t, i3, i2);
            } else if (objL2 != null) {
                gx.g(t, j2, objL2);
                E(t, i3, i2);
            }
        }
    }

    private final boolean H(T t, T t2, int i2) {
        return I(t, i2) == I(t2, i2);
    }

    private final boolean I(T t, int i2) {
        if (!this.f12276j) {
            int iR = R(i2);
            return (gx.E(t, (long) (iR & 1048575)) & (1 << (iR >>> 20))) != 0;
        }
        int iQ = Q(i2);
        long j2 = iQ & 1048575;
        switch ((iQ & 267386880) >>> 20) {
            case 0:
                return gx.K(t, j2) != 0.0d;
            case 1:
                return gx.I(t, j2) != 0.0f;
            case 2:
                return gx.F(t, j2) != 0;
            case 3:
                return gx.F(t, j2) != 0;
            case 4:
                return gx.E(t, j2) != 0;
            case 5:
                return gx.F(t, j2) != 0;
            case 6:
                return gx.E(t, j2) != 0;
            case 7:
                return gx.H(t, j2);
            case 8:
                Object objL = gx.L(t, j2);
                if (objL instanceof String) {
                    return !((String) objL).isEmpty();
                }
                if (objL instanceof zzdmr) {
                    return !zzdmr.f15982f.equals(objL);
                }
                throw new IllegalArgumentException();
            case 9:
                return gx.L(t, j2) != null;
            case 10:
                return !zzdmr.f15982f.equals(gx.L(t, j2));
            case 11:
                return gx.E(t, j2) != 0;
            case 12:
                return gx.E(t, j2) != 0;
            case 13:
                return gx.E(t, j2) != 0;
            case 14:
                return gx.F(t, j2) != 0;
            case 15:
                return gx.E(t, j2) != 0;
            case 16:
                return gx.F(t, j2) != 0;
            case 17:
                return gx.L(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static <E> List<E> J(Object obj, long j2) {
        return (List) gx.L(obj, j2);
    }

    private final void K(T t, int i2) {
        if (this.f12276j) {
            return;
        }
        int iR = R(i2);
        long j2 = iR & 1048575;
        gx.n(t, j2, gx.E(t, j2) | (1 << (iR >>> 20)));
    }

    private static <T> double L(T t, long j2) {
        return ((Double) gx.L(t, j2)).doubleValue();
    }

    private static <T> float M(T t, long j2) {
        return ((Float) gx.L(t, j2)).floatValue();
    }

    private final lw N(int i2) {
        int i3 = (i2 / 3) << 1;
        lw lwVar = (lw) this.f12270d[i3];
        if (lwVar != null) {
            return lwVar;
        }
        lw<T> lwVarC = gw.b().c((Class) this.f12270d[i3 + 1]);
        this.f12270d[i3] = lwVarC;
        return lwVarC;
    }

    private final Object O(int i2) {
        return this.f12270d[(i2 / 3) << 1];
    }

    private final zzdog P(int i2) {
        return (zzdog) this.f12270d[((i2 / 3) << 1) + 1];
    }

    private final int Q(int i2) {
        return this.f12269c[i2 + 1];
    }

    private final int R(int i2) {
        return this.f12269c[i2 + 2];
    }

    private static boolean S(int i2) {
        return (i2 & 536870912) != 0;
    }

    private final int T(int i2) {
        if (i2 < this.f12271e || i2 > this.f12272f) {
            return -1;
        }
        return C(i2, 0);
    }

    private static <T> int U(T t, long j2) {
        return ((Integer) gx.L(t, j2)).intValue();
    }

    private static <T> long V(T t, long j2) {
        return ((Long) gx.L(t, j2)).longValue();
    }

    private static <T> boolean W(T t, long j2) {
        return ((Boolean) gx.L(t, j2)).booleanValue();
    }

    private static <UT, UB> int k(cx<UT, UB> cxVar, T t) {
        return cxVar.i(cxVar.j(t));
    }

    private final int l(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, bu buVar) throws IOException {
        int iJ;
        Unsafe unsafe = f12268b;
        long j3 = this.f12269c[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i2;
                }
                unsafe.putObject(t, j2, Double.valueOf(au.p(bArr, i2)));
                iJ = i2 + 8;
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 52:
                if (i6 != 5) {
                    return i2;
                }
                unsafe.putObject(t, j2, Float.valueOf(au.q(bArr, i2)));
                iJ = i2 + 4;
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i2;
                }
                iJ = au.j(bArr, i2, buVar);
                unsafe.putObject(t, j2, Long.valueOf(buVar.f12360b));
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i2;
                }
                iJ = au.h(bArr, i2, buVar);
                unsafe.putObject(t, j2, Integer.valueOf(buVar.a));
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 56:
            case 65:
                if (i6 != 1) {
                    return i2;
                }
                unsafe.putObject(t, j2, Long.valueOf(au.o(bArr, i2)));
                iJ = i2 + 8;
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i2;
                }
                unsafe.putObject(t, j2, Integer.valueOf(au.n(bArr, i2)));
                iJ = i2 + 4;
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 58:
                if (i6 != 0) {
                    return i2;
                }
                iJ = au.j(bArr, i2, buVar);
                unsafe.putObject(t, j2, Boolean.valueOf(buVar.f12360b != 0));
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 59:
                if (i6 != 2) {
                    return i2;
                }
                int iH = au.h(bArr, i2, buVar);
                int i10 = buVar.a;
                if (i10 == 0) {
                    unsafe.putObject(t, j2, HttpUrl.FRAGMENT_ENCODE_SET);
                } else {
                    if ((i7 & 536870912) != 0 && !jx.k(bArr, iH, iH + i10)) {
                        throw zzdok.h();
                    }
                    unsafe.putObject(t, j2, new String(bArr, iH, i10, zzdod.a));
                    iH += i10;
                }
                unsafe.putInt(t, j3, i5);
                return iH;
            case 60:
                if (i6 != 2) {
                    return i2;
                }
                int iG = au.g(N(i9), bArr, i2, i3, buVar);
                Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                if (object == null) {
                    unsafe.putObject(t, j2, buVar.f12361c);
                } else {
                    unsafe.putObject(t, j2, zzdod.g(object, buVar.f12361c));
                }
                unsafe.putInt(t, j3, i5);
                return iG;
            case 61:
                if (i6 != 2) {
                    return i2;
                }
                iJ = au.m(bArr, i2, buVar);
                unsafe.putObject(t, j2, buVar.f12361c);
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 63:
                if (i6 != 0) {
                    return i2;
                }
                int iH2 = au.h(bArr, i2, buVar);
                int i11 = buVar.a;
                zzdog zzdogVarP = P(i9);
                if (zzdogVarP != null && !zzdogVarP.a(i11)) {
                    D(t).k(i4, Long.valueOf(i11));
                    return iH2;
                }
                unsafe.putObject(t, j2, Integer.valueOf(i11));
                iJ = iH2;
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 66:
                if (i6 != 0) {
                    return i2;
                }
                iJ = au.h(bArr, i2, buVar);
                unsafe.putObject(t, j2, Integer.valueOf(zzdnd.B(buVar.a)));
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 67:
                if (i6 != 0) {
                    return i2;
                }
                iJ = au.j(bArr, i2, buVar);
                unsafe.putObject(t, j2, Long.valueOf(zzdnd.w(buVar.f12360b)));
                unsafe.putInt(t, j3, i5);
                return iJ;
            case 68:
                if (i6 != 3) {
                    return i2;
                }
                iJ = au.f(N(i9), bArr, i2, i3, (i4 & (-8)) | 4, buVar);
                Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j2, buVar.f12361c);
                } else {
                    unsafe.putObject(t, j2, zzdod.g(object2, buVar.f12361c));
                }
                unsafe.putInt(t, j3, i5);
                return iJ;
            default:
                return i2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int m(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, bu buVar) throws IOException {
        int iH;
        int iH2 = i2;
        Unsafe unsafe = f12268b;
        zzdoj zzdojVarN = (zzdoj) unsafe.getObject(t, j3);
        if (!zzdojVarN.m0()) {
            int size = zzdojVarN.size();
            zzdojVarN = zzdojVarN.N(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j3, zzdojVarN);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    tu tuVar = (tu) zzdojVarN;
                    int iH3 = au.h(bArr, iH2, buVar);
                    int i9 = buVar.a + iH3;
                    while (iH3 < i9) {
                        tuVar.f(au.p(bArr, iH3));
                        iH3 += 8;
                    }
                    if (iH3 == i9) {
                        return iH3;
                    }
                    throw zzdok.a();
                }
                if (i6 == 1) {
                    tu tuVar2 = (tu) zzdojVarN;
                    tuVar2.f(au.p(bArr, i2));
                    while (true) {
                        int i10 = iH2 + 8;
                        if (i10 >= i3) {
                            return i10;
                        }
                        iH2 = au.h(bArr, i10, buVar);
                        if (i4 != buVar.a) {
                            return i10;
                        }
                        tuVar2.f(au.p(bArr, iH2));
                    }
                }
                return iH2;
            case 19:
            case 36:
                if (i6 == 2) {
                    cv cvVar = (cv) zzdojVarN;
                    int iH4 = au.h(bArr, iH2, buVar);
                    int i11 = buVar.a + iH4;
                    while (iH4 < i11) {
                        cvVar.i(au.q(bArr, iH4));
                        iH4 += 4;
                    }
                    if (iH4 == i11) {
                        return iH4;
                    }
                    throw zzdok.a();
                }
                if (i6 == 5) {
                    cv cvVar2 = (cv) zzdojVarN;
                    cvVar2.i(au.q(bArr, i2));
                    while (true) {
                        int i12 = iH2 + 4;
                        if (i12 >= i3) {
                            return i12;
                        }
                        iH2 = au.h(bArr, i12, buVar);
                        if (i4 != buVar.a) {
                            return i12;
                        }
                        cvVar2.i(au.q(bArr, iH2));
                    }
                }
                return iH2;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    ov ovVar = (ov) zzdojVarN;
                    int iH5 = au.h(bArr, iH2, buVar);
                    int i13 = buVar.a + iH5;
                    while (iH5 < i13) {
                        iH5 = au.j(bArr, iH5, buVar);
                        ovVar.i(buVar.f12360b);
                    }
                    if (iH5 == i13) {
                        return iH5;
                    }
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    ov ovVar2 = (ov) zzdojVarN;
                    int iJ = au.j(bArr, iH2, buVar);
                    ovVar2.i(buVar.f12360b);
                    while (iJ < i3) {
                        int iH6 = au.h(bArr, iJ, buVar);
                        if (i4 != buVar.a) {
                            return iJ;
                        }
                        iJ = au.j(bArr, iH6, buVar);
                        ovVar2.i(buVar.f12360b);
                    }
                    return iJ;
                }
                return iH2;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return au.i(bArr, iH2, zzdojVarN, buVar);
                }
                if (i6 == 0) {
                    return au.b(i4, bArr, i2, i3, zzdojVarN, buVar);
                }
                return iH2;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    ov ovVar3 = (ov) zzdojVarN;
                    int iH7 = au.h(bArr, iH2, buVar);
                    int i14 = buVar.a + iH7;
                    while (iH7 < i14) {
                        ovVar3.i(au.o(bArr, iH7));
                        iH7 += 8;
                    }
                    if (iH7 == i14) {
                        return iH7;
                    }
                    throw zzdok.a();
                }
                if (i6 == 1) {
                    ov ovVar4 = (ov) zzdojVarN;
                    ovVar4.i(au.o(bArr, i2));
                    while (true) {
                        int i15 = iH2 + 8;
                        if (i15 >= i3) {
                            return i15;
                        }
                        iH2 = au.h(bArr, i15, buVar);
                        if (i4 != buVar.a) {
                            return i15;
                        }
                        ovVar4.i(au.o(bArr, iH2));
                    }
                }
                return iH2;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    gv gvVar = (gv) zzdojVarN;
                    int iH8 = au.h(bArr, iH2, buVar);
                    int i16 = buVar.a + iH8;
                    while (iH8 < i16) {
                        gvVar.Z0(au.n(bArr, iH8));
                        iH8 += 4;
                    }
                    if (iH8 == i16) {
                        return iH8;
                    }
                    throw zzdok.a();
                }
                if (i6 == 5) {
                    gv gvVar2 = (gv) zzdojVarN;
                    gvVar2.Z0(au.n(bArr, i2));
                    while (true) {
                        int i17 = iH2 + 4;
                        if (i17 >= i3) {
                            return i17;
                        }
                        iH2 = au.h(bArr, i17, buVar);
                        if (i4 != buVar.a) {
                            return i17;
                        }
                        gvVar2.Z0(au.n(bArr, iH2));
                    }
                }
                return iH2;
            case 25:
            case 42:
                if (i6 == 2) {
                    cu cuVar = (cu) zzdojVarN;
                    iH = au.h(bArr, iH2, buVar);
                    int i18 = buVar.a + iH;
                    while (iH < i18) {
                        iH = au.j(bArr, iH, buVar);
                        cuVar.f(buVar.f12360b != 0);
                    }
                    if (iH != i18) {
                        throw zzdok.a();
                    }
                    return iH;
                }
                if (i6 == 0) {
                    cu cuVar2 = (cu) zzdojVarN;
                    iH2 = au.j(bArr, iH2, buVar);
                    cuVar2.f(buVar.f12360b != 0);
                    while (iH2 < i3) {
                        int iH9 = au.h(bArr, iH2, buVar);
                        if (i4 == buVar.a) {
                            iH2 = au.j(bArr, iH9, buVar);
                            cuVar2.f(buVar.f12360b != 0);
                        }
                    }
                }
                return iH2;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        iH2 = au.h(bArr, iH2, buVar);
                        int i19 = buVar.a;
                        if (i19 < 0) {
                            throw zzdok.b();
                        }
                        if (i19 == 0) {
                            zzdojVarN.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            zzdojVarN.add(new String(bArr, iH2, i19, zzdod.a));
                            iH2 += i19;
                        }
                        while (iH2 < i3) {
                            int iH10 = au.h(bArr, iH2, buVar);
                            if (i4 == buVar.a) {
                                iH2 = au.h(bArr, iH10, buVar);
                                int i20 = buVar.a;
                                if (i20 < 0) {
                                    throw zzdok.b();
                                }
                                if (i20 == 0) {
                                    zzdojVarN.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    zzdojVarN.add(new String(bArr, iH2, i20, zzdod.a));
                                    iH2 += i20;
                                }
                            }
                        }
                    } else {
                        iH2 = au.h(bArr, iH2, buVar);
                        int i21 = buVar.a;
                        if (i21 < 0) {
                            throw zzdok.b();
                        }
                        if (i21 == 0) {
                            zzdojVarN.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            int i22 = iH2 + i21;
                            if (!jx.k(bArr, iH2, i22)) {
                                throw zzdok.h();
                            }
                            zzdojVarN.add(new String(bArr, iH2, i21, zzdod.a));
                            iH2 = i22;
                        }
                        while (iH2 < i3) {
                            int iH11 = au.h(bArr, iH2, buVar);
                            if (i4 == buVar.a) {
                                iH2 = au.h(bArr, iH11, buVar);
                                int i23 = buVar.a;
                                if (i23 < 0) {
                                    throw zzdok.b();
                                }
                                if (i23 == 0) {
                                    zzdojVarN.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    int i24 = iH2 + i23;
                                    if (!jx.k(bArr, iH2, i24)) {
                                        throw zzdok.h();
                                    }
                                    zzdojVarN.add(new String(bArr, iH2, i23, zzdod.a));
                                    iH2 = i24;
                                }
                            }
                        }
                    }
                }
                return iH2;
            case 27:
                if (i6 == 2) {
                    return au.e(N(i7), i4, bArr, i2, i3, zzdojVarN, buVar);
                }
                return iH2;
            case 28:
                if (i6 == 2) {
                    int iH12 = au.h(bArr, iH2, buVar);
                    int i25 = buVar.a;
                    if (i25 < 0) {
                        throw zzdok.b();
                    }
                    if (i25 > bArr.length - iH12) {
                        throw zzdok.a();
                    }
                    if (i25 == 0) {
                        zzdojVarN.add(zzdmr.f15982f);
                    } else {
                        zzdojVarN.add(zzdmr.A(bArr, iH12, i25));
                        iH12 += i25;
                    }
                    while (iH12 < i3) {
                        int iH13 = au.h(bArr, iH12, buVar);
                        if (i4 != buVar.a) {
                            return iH12;
                        }
                        iH12 = au.h(bArr, iH13, buVar);
                        int i26 = buVar.a;
                        if (i26 < 0) {
                            throw zzdok.b();
                        }
                        if (i26 > bArr.length - iH12) {
                            throw zzdok.a();
                        }
                        if (i26 == 0) {
                            zzdojVarN.add(zzdmr.f15982f);
                        } else {
                            zzdojVarN.add(zzdmr.A(bArr, iH12, i26));
                            iH12 += i26;
                        }
                    }
                    return iH12;
                }
                return iH2;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        iH = au.b(i4, bArr, i2, i3, zzdojVarN, buVar);
                    }
                    return iH2;
                }
                iH = au.i(bArr, iH2, zzdojVarN, buVar);
                zzdob zzdobVar = (zzdob) t;
                zzdqu zzdquVar = zzdobVar.zzhhd;
                if (zzdquVar == zzdqu.f()) {
                    zzdquVar = null;
                }
                zzdqu zzdquVar2 = (zzdqu) nw.b(i5, zzdojVarN, P(i7), zzdquVar, this.q);
                if (zzdquVar2 != null) {
                    zzdobVar.zzhhd = zzdquVar2;
                }
                return iH;
            case 33:
            case 47:
                if (i6 == 2) {
                    gv gvVar3 = (gv) zzdojVarN;
                    int iH14 = au.h(bArr, iH2, buVar);
                    int i27 = buVar.a + iH14;
                    while (iH14 < i27) {
                        iH14 = au.h(bArr, iH14, buVar);
                        gvVar3.Z0(zzdnd.B(buVar.a));
                    }
                    if (iH14 == i27) {
                        return iH14;
                    }
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    gv gvVar4 = (gv) zzdojVarN;
                    int iH15 = au.h(bArr, iH2, buVar);
                    gvVar4.Z0(zzdnd.B(buVar.a));
                    while (iH15 < i3) {
                        int iH16 = au.h(bArr, iH15, buVar);
                        if (i4 != buVar.a) {
                            return iH15;
                        }
                        iH15 = au.h(bArr, iH16, buVar);
                        gvVar4.Z0(zzdnd.B(buVar.a));
                    }
                    return iH15;
                }
                return iH2;
            case 34:
            case 48:
                if (i6 == 2) {
                    ov ovVar5 = (ov) zzdojVarN;
                    int iH17 = au.h(bArr, iH2, buVar);
                    int i28 = buVar.a + iH17;
                    while (iH17 < i28) {
                        iH17 = au.j(bArr, iH17, buVar);
                        ovVar5.i(zzdnd.w(buVar.f12360b));
                    }
                    if (iH17 == i28) {
                        return iH17;
                    }
                    throw zzdok.a();
                }
                if (i6 == 0) {
                    ov ovVar6 = (ov) zzdojVarN;
                    int iJ2 = au.j(bArr, iH2, buVar);
                    ovVar6.i(zzdnd.w(buVar.f12360b));
                    while (iJ2 < i3) {
                        int iH18 = au.h(bArr, iJ2, buVar);
                        if (i4 != buVar.a) {
                            return iJ2;
                        }
                        iJ2 = au.j(bArr, iH18, buVar);
                        ovVar6.i(zzdnd.w(buVar.f12360b));
                    }
                    return iJ2;
                }
                return iH2;
            case 49:
                if (i6 == 3) {
                    lw lwVarN = N(i7);
                    int i29 = (i4 & (-8)) | 4;
                    iH2 = au.f(lwVarN, bArr, i2, i3, i29, buVar);
                    zzdojVarN.add(buVar.f12361c);
                    while (iH2 < i3) {
                        int iH19 = au.h(bArr, iH2, buVar);
                        if (i4 == buVar.a) {
                            iH2 = au.f(lwVarN, bArr, iH19, i3, i29, buVar);
                            zzdojVarN.add(buVar.f12361c);
                        }
                    }
                }
                return iH2;
            default:
                return iH2;
        }
    }

    private final <K, V> int n(T t, byte[] bArr, int i2, int i3, int i4, long j2, bu buVar) throws IOException {
        Unsafe unsafe = f12268b;
        Object objO = O(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.s.c(object)) {
            Object objE = this.s.e(objO);
            this.s.a(objE, object);
            unsafe.putObject(t, j2, objE);
            object = objE;
        }
        this.s.g(objO);
        this.s.h(object);
        int iH = au.h(bArr, i2, buVar);
        int i5 = buVar.a;
        if (i5 < 0 || i5 > i3 - iH) {
            throw zzdok.a();
        }
        throw null;
    }

    static <T> aw<T> p(Class<T> cls, xv xvVar, cw cwVar, kv kvVar, cx<?, ?> cxVar, vu<?> vuVar, uv uvVar) {
        int i2;
        int iCharAt;
        int iCharAt2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        boolean z;
        int i18;
        iw iwVar;
        int i19;
        int i20;
        int iObjectFieldOffset;
        String str;
        int iObjectFieldOffset2;
        int i21;
        Field fieldS;
        int i22;
        char cCharAt9;
        int i23;
        Field fieldS2;
        Field fieldS3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        char cCharAt14;
        if (!(xvVar instanceof iw)) {
            ((yw) xvVar).c();
            throw new NoSuchMethodError();
        }
        iw iwVar2 = (iw) xvVar;
        int i28 = 0;
        boolean z2 = iwVar2.c() == zzdob.zze.f16030j;
        String strD = iwVar2.d();
        int length = strD.length();
        int iCharAt3 = strD.charAt(0);
        if (iCharAt3 >= 55296) {
            int i29 = iCharAt3 & 8191;
            int i30 = 1;
            int i31 = 13;
            while (true) {
                i2 = i30 + 1;
                cCharAt14 = strD.charAt(i30);
                if (cCharAt14 < 55296) {
                    break;
                }
                i29 |= (cCharAt14 & 8191) << i31;
                i31 += 13;
                i30 = i2;
            }
            iCharAt3 = i29 | (cCharAt14 << i31);
        } else {
            i2 = 1;
        }
        int i32 = i2 + 1;
        int iCharAt4 = strD.charAt(i2);
        if (iCharAt4 >= 55296) {
            int i33 = iCharAt4 & 8191;
            int i34 = 13;
            while (true) {
                i27 = i32 + 1;
                cCharAt13 = strD.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i27;
            }
            iCharAt4 = i33 | (cCharAt13 << i34);
            i32 = i27;
        }
        if (iCharAt4 == 0) {
            iArr = a;
            i7 = 0;
            i4 = 0;
            iCharAt = 0;
            i5 = 0;
            iCharAt2 = 0;
            i6 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt5 = strD.charAt(i32);
            if (iCharAt5 >= 55296) {
                int i36 = iCharAt5 & 8191;
                int i37 = 13;
                while (true) {
                    i15 = i35 + 1;
                    cCharAt8 = strD.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i15;
                }
                iCharAt5 = i36 | (cCharAt8 << i37);
                i35 = i15;
            }
            int i38 = i35 + 1;
            int iCharAt6 = strD.charAt(i35);
            if (iCharAt6 >= 55296) {
                int i39 = iCharAt6 & 8191;
                int i40 = 13;
                while (true) {
                    i14 = i38 + 1;
                    cCharAt7 = strD.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i14;
                }
                iCharAt6 = i39 | (cCharAt7 << i40);
                i38 = i14;
            }
            int i41 = i38 + 1;
            iCharAt = strD.charAt(i38);
            if (iCharAt >= 55296) {
                int i42 = iCharAt & 8191;
                int i43 = 13;
                while (true) {
                    i13 = i41 + 1;
                    cCharAt6 = strD.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i13;
                }
                iCharAt = i42 | (cCharAt6 << i43);
                i41 = i13;
            }
            int i44 = i41 + 1;
            int iCharAt7 = strD.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i12 = i44 + 1;
                    cCharAt5 = strD.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i12;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i12;
            }
            int i47 = i44 + 1;
            iCharAt2 = strD.charAt(i44);
            if (iCharAt2 >= 55296) {
                int i48 = iCharAt2 & 8191;
                int i49 = 13;
                while (true) {
                    i11 = i47 + 1;
                    cCharAt4 = strD.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i11;
                }
                iCharAt2 = i48 | (cCharAt4 << i49);
                i47 = i11;
            }
            int i50 = i47 + 1;
            int iCharAt8 = strD.charAt(i47);
            if (iCharAt8 >= 55296) {
                int i51 = iCharAt8 & 8191;
                int i52 = 13;
                while (true) {
                    i10 = i50 + 1;
                    cCharAt3 = strD.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i10;
                }
                iCharAt8 = i51 | (cCharAt3 << i52);
                i50 = i10;
            }
            int i53 = i50 + 1;
            int iCharAt9 = strD.charAt(i50);
            if (iCharAt9 >= 55296) {
                int i54 = iCharAt9 & 8191;
                int i55 = i53;
                int i56 = 13;
                while (true) {
                    i9 = i55 + 1;
                    cCharAt2 = strD.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i55 = i9;
                }
                iCharAt9 = i54 | (cCharAt2 << i56);
                i3 = i9;
            } else {
                i3 = i53;
            }
            int i57 = i3 + 1;
            int iCharAt10 = strD.charAt(i3);
            if (iCharAt10 >= 55296) {
                int i58 = iCharAt10 & 8191;
                int i59 = i57;
                int i60 = 13;
                while (true) {
                    i8 = i59 + 1;
                    cCharAt = strD.charAt(i59);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i59 = i8;
                }
                iCharAt10 = i58 | (cCharAt << i60);
                i57 = i8;
            }
            int[] iArr2 = new int[iCharAt10 + iCharAt8 + iCharAt9];
            int i61 = (iCharAt5 << 1) + iCharAt6;
            i4 = iCharAt7;
            i5 = i61;
            i6 = iCharAt10;
            i28 = iCharAt5;
            i32 = i57;
            int i62 = iCharAt8;
            iArr = iArr2;
            i7 = i62;
        }
        Unsafe unsafe = f12268b;
        Object[] objArrE = iwVar2.e();
        Class<?> cls2 = iwVar2.b().getClass();
        int i63 = i32;
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr = new Object[iCharAt2 << 1];
        int i64 = i6 + i7;
        int i65 = i6;
        int i66 = i63;
        int i67 = i64;
        int i68 = 0;
        int i69 = 0;
        while (i66 < length) {
            int i70 = i66 + 1;
            int iCharAt11 = strD.charAt(i66);
            int i71 = length;
            if (iCharAt11 >= 55296) {
                int i72 = iCharAt11 & 8191;
                int i73 = i70;
                int i74 = 13;
                while (true) {
                    i26 = i73 + 1;
                    cCharAt12 = strD.charAt(i73);
                    i16 = i6;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i72 |= (cCharAt12 & 8191) << i74;
                    i74 += 13;
                    i73 = i26;
                    i6 = i16;
                }
                iCharAt11 = i72 | (cCharAt12 << i74);
                i17 = i26;
            } else {
                i16 = i6;
                i17 = i70;
            }
            int i75 = i17 + 1;
            int iCharAt12 = strD.charAt(i17);
            if (iCharAt12 >= 55296) {
                int i76 = iCharAt12 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i25 = i77 + 1;
                    cCharAt11 = strD.charAt(i77);
                    z = z2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i76 |= (cCharAt11 & 8191) << i78;
                    i78 += 13;
                    i77 = i25;
                    z2 = z;
                }
                iCharAt12 = i76 | (cCharAt11 << i78);
                i18 = i25;
            } else {
                z = z2;
                i18 = i75;
            }
            int i79 = iCharAt12 & 255;
            int i80 = i4;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i68] = i69;
                i68++;
            }
            int i81 = iCharAt;
            if (i79 >= 51) {
                int i82 = i18 + 1;
                int iCharAt13 = strD.charAt(i18);
                char c2 = 55296;
                if (iCharAt13 >= 55296) {
                    int i83 = iCharAt13 & 8191;
                    int i84 = 13;
                    while (true) {
                        i24 = i82 + 1;
                        cCharAt10 = strD.charAt(i82);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i83 |= (cCharAt10 & 8191) << i84;
                        i84 += 13;
                        i82 = i24;
                        c2 = 55296;
                    }
                    iCharAt13 = i83 | (cCharAt10 << i84);
                    i82 = i24;
                }
                int i85 = i79 - 51;
                int i86 = i82;
                if (i85 == 9 || i85 == 17) {
                    objArr[((i69 / 3) << 1) + 1] = objArrE[i5];
                    i5++;
                } else if (i85 == 12 && (iCharAt3 & 1) == 1) {
                    objArr[((i69 / 3) << 1) + 1] = objArrE[i5];
                    i5++;
                }
                int i87 = iCharAt13 << 1;
                Object obj = objArrE[i87];
                if (obj instanceof Field) {
                    fieldS2 = (Field) obj;
                } else {
                    fieldS2 = s(cls2, (String) obj);
                    objArrE[i87] = fieldS2;
                }
                iwVar = iwVar2;
                String str2 = strD;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldS2);
                int i88 = i87 + 1;
                Object obj2 = objArrE[i88];
                if (obj2 instanceof Field) {
                    fieldS3 = (Field) obj2;
                } else {
                    fieldS3 = s(cls2, (String) obj2);
                    objArrE[i88] = fieldS3;
                }
                cls2 = cls2;
                i19 = i5;
                i18 = i86;
                str = str2;
                i21 = 0;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldS3);
                i28 = i28;
            } else {
                iwVar = iwVar2;
                String str3 = strD;
                i19 = i5 + 1;
                Field fieldS4 = s(cls2, (String) objArrE[i5]);
                if (i79 == 9 || i79 == 17) {
                    i20 = 1;
                    objArr[((i69 / 3) << 1) + 1] = fieldS4.getType();
                } else {
                    if (i79 == 27 || i79 == 49) {
                        i20 = 1;
                        i23 = i19 + 1;
                        objArr[((i69 / 3) << 1) + 1] = objArrE[i19];
                    } else if (i79 == 12 || i79 == 30 || i79 == 44) {
                        i20 = 1;
                        if ((iCharAt3 & 1) == 1) {
                            i23 = i19 + 1;
                            objArr[((i69 / 3) << 1) + 1] = objArrE[i19];
                        }
                    } else if (i79 == 50) {
                        int i89 = i65 + 1;
                        iArr[i65] = i69;
                        int i90 = (i69 / 3) << 1;
                        int i91 = i19 + 1;
                        objArr[i90] = objArrE[i19];
                        if ((iCharAt12 & RecyclerView.l.FLAG_MOVED) != 0) {
                            i19 = i91 + 1;
                            objArr[i90 + 1] = objArrE[i91];
                            i65 = i89;
                            i20 = 1;
                        } else {
                            i19 = i91;
                            i20 = 1;
                            i65 = i89;
                        }
                    } else {
                        i20 = 1;
                    }
                    i19 = i23;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldS4);
                if ((iCharAt3 & 1) != i20 || i79 > 17) {
                    str = str3;
                    iObjectFieldOffset2 = 0;
                    i21 = 0;
                } else {
                    int i92 = i18 + 1;
                    str = str3;
                    int iCharAt14 = str.charAt(i18);
                    if (iCharAt14 >= 55296) {
                        int i93 = iCharAt14 & 8191;
                        int i94 = 13;
                        while (true) {
                            i22 = i92 + 1;
                            cCharAt9 = str.charAt(i92);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i93 |= (cCharAt9 & 8191) << i94;
                            i94 += 13;
                            i92 = i22;
                        }
                        iCharAt14 = i93 | (cCharAt9 << i94);
                        i92 = i22;
                    }
                    int i95 = (i28 << 1) + (iCharAt14 / 32);
                    Object obj3 = objArrE[i95];
                    if (obj3 instanceof Field) {
                        fieldS = (Field) obj3;
                    } else {
                        fieldS = s(cls2, (String) obj3);
                        objArrE[i95] = fieldS;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldS);
                    i21 = iCharAt14 % 32;
                    i18 = i92;
                }
                if (i79 >= 18 && i79 <= 49) {
                    iArr[i67] = iObjectFieldOffset;
                    i67++;
                }
            }
            int i96 = i69 + 1;
            iArr3[i69] = iCharAt11;
            int i97 = i96 + 1;
            iArr3[i96] = iObjectFieldOffset | ((iCharAt12 & 256) != 0 ? 268435456 : 0) | ((iCharAt12 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 536870912 : 0) | (i79 << 20);
            i69 = i97 + 1;
            iArr3[i97] = (i21 << 20) | iObjectFieldOffset2;
            i28 = i28;
            strD = str;
            i66 = i18;
            cls2 = cls2;
            i4 = i80;
            length = i71;
            i6 = i16;
            z2 = z;
            iCharAt = i81;
            i5 = i19;
            iwVar2 = iwVar;
        }
        return new aw<>(iArr3, objArr, iCharAt, i4, iwVar2.b(), z2, false, iArr, i6, i64, cwVar, kvVar, cxVar, vuVar, uvVar);
    }

    private final <K, V, UT, UB> UB q(int i2, int i3, Map<K, V> map, zzdog zzdogVar, UB ub, cx<UT, UB> cxVar) {
        tv<?, ?> tvVarG = this.s.g(O(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzdogVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = cxVar.m();
                }
                ju juVarX = zzdmr.x(zzdpc.a(tvVarG, next.getKey(), next.getValue()));
                try {
                    zzdpc.b(juVarX.b(), tvVarG, next.getKey(), next.getValue());
                    cxVar.b(ub, i3, juVarX.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB r(Object obj, int i2, UB ub, cx<UT, UB> cxVar) {
        zzdog zzdogVarP;
        int i3 = this.f12269c[i2];
        Object objL = gx.L(obj, Q(i2) & 1048575);
        return (objL == null || (zzdogVarP = P(i2)) == null) ? ub : (UB) q(i2, i3, this.s.h(objL), zzdogVarP, ub, cxVar);
    }

    private static Field s(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString());
        }
    }

    private static void t(int i2, Object obj, ux uxVar) throws IOException {
        if (obj instanceof String) {
            uxVar.X(i2, (String) obj);
        } else {
            uxVar.I(i2, (zzdmr) obj);
        }
    }

    private static <UT, UB> void u(cx<UT, UB> cxVar, T t, ux uxVar) throws IOException {
        cxVar.d(cxVar.j(t), uxVar);
    }

    private final <K, V> void v(ux uxVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            uxVar.V(i2, this.s.g(O(i3)), this.s.b(obj));
        }
    }

    private final void w(Object obj, int i2, kw kwVar) throws IOException {
        if (S(i2)) {
            gx.g(obj, i2 & 1048575, kwVar.M());
        } else if (this.f12275i) {
            gx.g(obj, i2 & 1048575, kwVar.a());
        } else {
            gx.g(obj, i2 & 1048575, kwVar.T());
        }
    }

    private final void x(T t, T t2, int i2) {
        long jQ = Q(i2) & 1048575;
        if (I(t2, i2)) {
            Object objL = gx.L(t, jQ);
            Object objL2 = gx.L(t2, jQ);
            if (objL != null && objL2 != null) {
                gx.g(t, jQ, zzdod.g(objL, objL2));
                K(t, i2);
            } else if (objL2 != null) {
                gx.g(t, jQ, objL2);
                K(t, i2);
            }
        }
    }

    private final boolean y(T t, int i2, int i3) {
        return gx.E(t, (long) (R(i3) & 1048575)) == i2;
    }

    private final boolean z(T t, int i2, int i3, int i4) {
        if (this.f12276j) {
            return I(t, i2);
        }
        return (i3 & i4) != 0;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void a(T t, T t2) {
        t2.getClass();
        for (int i2 = 0; i2 < this.f12269c.length; i2 += 3) {
            int iQ = Q(i2);
            long j2 = 1048575 & iQ;
            int i3 = this.f12269c[i2];
            switch ((iQ & 267386880) >>> 20) {
                case 0:
                    if (I(t2, i2)) {
                        gx.d(t, j2, gx.K(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 1:
                    if (I(t2, i2)) {
                        gx.e(t, j2, gx.I(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 2:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 3:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 4:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 5:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 6:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 7:
                    if (I(t2, i2)) {
                        gx.h(t, j2, gx.H(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 8:
                    if (I(t2, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 9:
                    x(t, t2, i2);
                    break;
                case 10:
                    if (I(t2, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 11:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 12:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 13:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 14:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 15:
                    if (I(t2, i2)) {
                        gx.n(t, j2, gx.E(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 16:
                    if (I(t2, i2)) {
                        gx.f(t, j2, gx.F(t2, j2));
                        K(t, i2);
                    }
                    break;
                case 17:
                    x(t, t2, i2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.p.b(t, t2, j2);
                    break;
                case 50:
                    nw.g(this.s, t, t2, j2);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (y(t2, i3, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        E(t, i3, i2);
                    }
                    break;
                case 60:
                    G(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (y(t2, i3, i2)) {
                        gx.g(t, j2, gx.L(t2, j2));
                        E(t, i3, i2);
                    }
                    break;
                case 68:
                    G(t, t2, i2);
                    break;
            }
        }
        if (this.f12276j) {
            return;
        }
        nw.h(this.q, t, t2);
        if (this.f12274h) {
            nw.f(this.r, t, t2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.ads.lw
    public final boolean b(T t, T t2) {
        int length = this.f12269c.length;
        int i2 = 0;
        while (true) {
            boolean zH = true;
            if (i2 >= length) {
                if (!this.q.j(t).equals(this.q.j(t2))) {
                    return false;
                }
                if (this.f12274h) {
                    return this.r.i(t).equals(this.r.i(t2));
                }
                return true;
            }
            int iQ = Q(i2);
            long j2 = iQ & 1048575;
            switch ((iQ & 267386880) >>> 20) {
                case 0:
                    if (!H(t, t2, i2) || Double.doubleToLongBits(gx.K(t, j2)) != Double.doubleToLongBits(gx.K(t2, j2))) {
                        zH = false;
                    }
                    break;
                case 1:
                    if (!H(t, t2, i2) || Float.floatToIntBits(gx.I(t, j2)) != Float.floatToIntBits(gx.I(t2, j2))) {
                        zH = false;
                    }
                    break;
                case 2:
                    if (!H(t, t2, i2) || gx.F(t, j2) != gx.F(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 3:
                    if (!H(t, t2, i2) || gx.F(t, j2) != gx.F(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 4:
                    if (!H(t, t2, i2) || gx.E(t, j2) != gx.E(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 5:
                    if (!H(t, t2, i2) || gx.F(t, j2) != gx.F(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 6:
                    if (!H(t, t2, i2) || gx.E(t, j2) != gx.E(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 7:
                    if (!H(t, t2, i2) || gx.H(t, j2) != gx.H(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 8:
                    if (!H(t, t2, i2) || !nw.H(gx.L(t, j2), gx.L(t2, j2))) {
                        zH = false;
                    }
                    break;
                case 9:
                    if (!H(t, t2, i2) || !nw.H(gx.L(t, j2), gx.L(t2, j2))) {
                        zH = false;
                    }
                    break;
                case 10:
                    if (!H(t, t2, i2) || !nw.H(gx.L(t, j2), gx.L(t2, j2))) {
                        zH = false;
                    }
                    break;
                case 11:
                    if (!H(t, t2, i2) || gx.E(t, j2) != gx.E(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 12:
                    if (!H(t, t2, i2) || gx.E(t, j2) != gx.E(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 13:
                    if (!H(t, t2, i2) || gx.E(t, j2) != gx.E(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 14:
                    if (!H(t, t2, i2) || gx.F(t, j2) != gx.F(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 15:
                    if (!H(t, t2, i2) || gx.E(t, j2) != gx.E(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 16:
                    if (!H(t, t2, i2) || gx.F(t, j2) != gx.F(t2, j2)) {
                        zH = false;
                    }
                    break;
                case 17:
                    if (!H(t, t2, i2) || !nw.H(gx.L(t, j2), gx.L(t2, j2))) {
                        zH = false;
                    }
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zH = nw.H(gx.L(t, j2), gx.L(t2, j2));
                    break;
                case 50:
                    zH = nw.H(gx.L(t, j2), gx.L(t2, j2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jR = R(i2) & 1048575;
                    if (gx.E(t, jR) != gx.E(t2, jR) || !nw.H(gx.L(t, j2), gx.L(t2, j2))) {
                        zH = false;
                    }
                    break;
            }
            if (!zH) {
                return false;
            }
            i2 += 3;
        }
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final T c() {
        return (T) this.o.a(this.f12273g);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final int d(T t) {
        int i2;
        int i3;
        int length = this.f12269c.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iQ = Q(i5);
            int i6 = this.f12269c[i5];
            long j2 = 1048575 & iQ;
            int iHashCode = 37;
            switch ((iQ & 267386880) >>> 20) {
                case 0:
                    i2 = i4 * 53;
                    i3 = zzdod.i(Double.doubleToLongBits(gx.K(t, j2)));
                    i4 = i2 + i3;
                    break;
                case 1:
                    i2 = i4 * 53;
                    i3 = Float.floatToIntBits(gx.I(t, j2));
                    i4 = i2 + i3;
                    break;
                case 2:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 3:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 4:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 5:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 6:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i2 = i4 * 53;
                    i3 = zzdod.h(gx.H(t, j2));
                    i4 = i2 + i3;
                    break;
                case 8:
                    i2 = i4 * 53;
                    i3 = ((String) gx.L(t, j2)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    Object objL = gx.L(t, j2);
                    if (objL != null) {
                        iHashCode = objL.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i2 = i4 * 53;
                    i3 = gx.L(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 11:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 12:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 13:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 14:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 15:
                    i2 = i4 * 53;
                    i3 = gx.E(t, j2);
                    i4 = i2 + i3;
                    break;
                case 16:
                    i2 = i4 * 53;
                    i3 = zzdod.i(gx.F(t, j2));
                    i4 = i2 + i3;
                    break;
                case 17:
                    Object objL2 = gx.L(t, j2);
                    if (objL2 != null) {
                        iHashCode = objL2.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i4 * 53;
                    i3 = gx.L(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 50:
                    i2 = i4 * 53;
                    i3 = gx.L(t, j2).hashCode();
                    i4 = i2 + i3;
                    break;
                case 51:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(Double.doubleToLongBits(L(t, j2)));
                        i4 = i2 + i3;
                    }
                    break;
                case 52:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = Float.floatToIntBits(M(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 53:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 54:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 55:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                    }
                    break;
                case 56:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 57:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                    }
                    break;
                case 58:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.h(W(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 59:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = ((String) gx.L(t, j2)).hashCode();
                        i4 = i2 + i3;
                    }
                    break;
                case 60:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = gx.L(t, j2).hashCode();
                        i4 = i2 + i3;
                    }
                    break;
                case 61:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = gx.L(t, j2).hashCode();
                        i4 = i2 + i3;
                    }
                    break;
                case 62:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                    }
                    break;
                case 63:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                    }
                    break;
                case 64:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                    }
                    break;
                case 65:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 66:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = U(t, j2);
                        i4 = i2 + i3;
                    }
                    break;
                case 67:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = zzdod.i(V(t, j2));
                        i4 = i2 + i3;
                    }
                    break;
                case 68:
                    if (y(t, i6, i5)) {
                        i2 = i4 * 53;
                        i3 = gx.L(t, j2).hashCode();
                        i4 = i2 + i3;
                    }
                    break;
            }
        }
        int iHashCode2 = (i4 * 53) + this.q.j(t).hashCode();
        return this.f12274h ? (iHashCode2 * 53) + this.r.i(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x0546  */
    /* JADX WARN: Code duplicated, block: B:9:0x0030  */
    @Override // com.google.android.gms.internal.ads.lw
    public final void e(T t, ux uxVar) throws IOException {
        Iterator itE;
        Map.Entry<?, ?> entry;
        Iterator itA;
        Map.Entry<?, ?> entry2;
        if (uxVar.F() == zzdob.zze.m) {
            u(this.q, t, uxVar);
            if (this.f12274h) {
                yu<T> yuVarI = this.r.i(t);
                if (yuVarI.b()) {
                    itA = null;
                    entry2 = null;
                } else {
                    itA = yuVarI.a();
                    entry2 = (Map.Entry) itA.next();
                }
            } else {
                itA = null;
                entry2 = null;
            }
            for (int length = this.f12269c.length - 3; length >= 0; length -= 3) {
                int iQ = Q(length);
                int i2 = this.f12269c[length];
                while (entry2 != null && this.r.a(entry2) > i2) {
                    this.r.f(uxVar, entry2);
                    entry2 = itA.hasNext() ? (Map.Entry) itA.next() : null;
                }
                switch ((iQ & 267386880) >>> 20) {
                    case 0:
                        if (I(t, length)) {
                            uxVar.E(i2, gx.K(t, iQ & 1048575));
                        }
                        break;
                    case 1:
                        if (I(t, length)) {
                            uxVar.r(i2, gx.I(t, iQ & 1048575));
                        }
                        break;
                    case 2:
                        if (I(t, length)) {
                            uxVar.J(i2, gx.F(t, iQ & 1048575));
                        }
                        break;
                    case 3:
                        if (I(t, length)) {
                            uxVar.L(i2, gx.F(t, iQ & 1048575));
                        }
                        break;
                    case 4:
                        if (I(t, length)) {
                            uxVar.T(i2, gx.E(t, iQ & 1048575));
                        }
                        break;
                    case 5:
                        if (I(t, length)) {
                            uxVar.B(i2, gx.F(t, iQ & 1048575));
                        }
                        break;
                    case 6:
                        if (I(t, length)) {
                            uxVar.D(i2, gx.E(t, iQ & 1048575));
                        }
                        break;
                    case 7:
                        if (I(t, length)) {
                            uxVar.R(i2, gx.H(t, iQ & 1048575));
                        }
                        break;
                    case 8:
                        if (I(t, length)) {
                            t(i2, gx.L(t, iQ & 1048575), uxVar);
                        }
                        break;
                    case 9:
                        if (I(t, length)) {
                            uxVar.Y(i2, gx.L(t, iQ & 1048575), N(length));
                        }
                        break;
                    case 10:
                        if (I(t, length)) {
                            uxVar.I(i2, (zzdmr) gx.L(t, iQ & 1048575));
                        }
                        break;
                    case 11:
                        if (I(t, length)) {
                            uxVar.K(i2, gx.E(t, iQ & 1048575));
                        }
                        break;
                    case 12:
                        if (I(t, length)) {
                            uxVar.N(i2, gx.E(t, iQ & 1048575));
                        }
                        break;
                    case 13:
                        if (I(t, length)) {
                            uxVar.H(i2, gx.E(t, iQ & 1048575));
                        }
                        break;
                    case 14:
                        if (I(t, length)) {
                            uxVar.M(i2, gx.F(t, iQ & 1048575));
                        }
                        break;
                    case 15:
                        if (I(t, length)) {
                            uxVar.O(i2, gx.E(t, iQ & 1048575));
                        }
                        break;
                    case 16:
                        if (I(t, length)) {
                            uxVar.P(i2, gx.F(t, iQ & 1048575));
                        }
                        break;
                    case 17:
                        if (I(t, length)) {
                            uxVar.U(i2, gx.L(t, iQ & 1048575), N(length));
                        }
                        break;
                    case 18:
                        nw.e(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 19:
                        nw.x(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 20:
                        nw.C(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 21:
                        nw.F(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 22:
                        nw.K(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 23:
                        nw.I(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 24:
                        nw.O(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 25:
                        nw.R(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 26:
                        nw.c(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar);
                        break;
                    case 27:
                        nw.d(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, N(length));
                        break;
                    case 28:
                        nw.v(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar);
                        break;
                    case 29:
                        nw.M(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 30:
                        nw.Q(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 31:
                        nw.P(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 32:
                        nw.J(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 33:
                        nw.N(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 34:
                        nw.G(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, false);
                        break;
                    case 35:
                        nw.e(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 36:
                        nw.x(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 37:
                        nw.C(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 38:
                        nw.F(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 39:
                        nw.K(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 40:
                        nw.I(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 41:
                        nw.O(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 42:
                        nw.R(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 43:
                        nw.M(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 44:
                        nw.Q(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 45:
                        nw.P(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 46:
                        nw.J(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 47:
                        nw.N(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 48:
                        nw.G(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, true);
                        break;
                    case 49:
                        nw.w(this.f12269c[length], (List) gx.L(t, iQ & 1048575), uxVar, N(length));
                        break;
                    case 50:
                        v(uxVar, i2, gx.L(t, iQ & 1048575), length);
                        break;
                    case 51:
                        if (y(t, i2, length)) {
                            uxVar.E(i2, L(t, iQ & 1048575));
                        }
                        break;
                    case 52:
                        if (y(t, i2, length)) {
                            uxVar.r(i2, M(t, iQ & 1048575));
                        }
                        break;
                    case 53:
                        if (y(t, i2, length)) {
                            uxVar.J(i2, V(t, iQ & 1048575));
                        }
                        break;
                    case 54:
                        if (y(t, i2, length)) {
                            uxVar.L(i2, V(t, iQ & 1048575));
                        }
                        break;
                    case 55:
                        if (y(t, i2, length)) {
                            uxVar.T(i2, U(t, iQ & 1048575));
                        }
                        break;
                    case 56:
                        if (y(t, i2, length)) {
                            uxVar.B(i2, V(t, iQ & 1048575));
                        }
                        break;
                    case 57:
                        if (y(t, i2, length)) {
                            uxVar.D(i2, U(t, iQ & 1048575));
                        }
                        break;
                    case 58:
                        if (y(t, i2, length)) {
                            uxVar.R(i2, W(t, iQ & 1048575));
                        }
                        break;
                    case 59:
                        if (y(t, i2, length)) {
                            t(i2, gx.L(t, iQ & 1048575), uxVar);
                        }
                        break;
                    case 60:
                        if (y(t, i2, length)) {
                            uxVar.Y(i2, gx.L(t, iQ & 1048575), N(length));
                        }
                        break;
                    case 61:
                        if (y(t, i2, length)) {
                            uxVar.I(i2, (zzdmr) gx.L(t, iQ & 1048575));
                        }
                        break;
                    case 62:
                        if (y(t, i2, length)) {
                            uxVar.K(i2, U(t, iQ & 1048575));
                        }
                        break;
                    case 63:
                        if (y(t, i2, length)) {
                            uxVar.N(i2, U(t, iQ & 1048575));
                        }
                        break;
                    case 64:
                        if (y(t, i2, length)) {
                            uxVar.H(i2, U(t, iQ & 1048575));
                        }
                        break;
                    case 65:
                        if (y(t, i2, length)) {
                            uxVar.M(i2, V(t, iQ & 1048575));
                        }
                        break;
                    case 66:
                        if (y(t, i2, length)) {
                            uxVar.O(i2, U(t, iQ & 1048575));
                        }
                        break;
                    case 67:
                        if (y(t, i2, length)) {
                            uxVar.P(i2, V(t, iQ & 1048575));
                        }
                        break;
                    case 68:
                        if (y(t, i2, length)) {
                            uxVar.U(i2, gx.L(t, iQ & 1048575), N(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.r.f(uxVar, entry2);
                entry2 = itA.hasNext() ? (Map.Entry) itA.next() : null;
            }
            return;
        }
        if (!this.f12276j) {
            F(t, uxVar);
            return;
        }
        if (this.f12274h) {
            yu<T> yuVarI2 = this.r.i(t);
            if (yuVarI2.b()) {
                itE = null;
                entry = null;
            } else {
                itE = yuVarI2.e();
                entry = (Map.Entry) itE.next();
            }
        } else {
            itE = null;
            entry = null;
        }
        int length2 = this.f12269c.length;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            int iQ2 = Q(i3);
            int i4 = this.f12269c[i3];
            while (entry != null && this.r.a(entry) <= i4) {
                this.r.f(uxVar, entry);
                entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
            }
            switch ((iQ2 & 267386880) >>> 20) {
                case 0:
                    if (I(t, i3)) {
                        uxVar.E(i4, gx.K(t, iQ2 & 1048575));
                    }
                    break;
                case 1:
                    if (I(t, i3)) {
                        uxVar.r(i4, gx.I(t, iQ2 & 1048575));
                    }
                    break;
                case 2:
                    if (I(t, i3)) {
                        uxVar.J(i4, gx.F(t, iQ2 & 1048575));
                    }
                    break;
                case 3:
                    if (I(t, i3)) {
                        uxVar.L(i4, gx.F(t, iQ2 & 1048575));
                    }
                    break;
                case 4:
                    if (I(t, i3)) {
                        uxVar.T(i4, gx.E(t, iQ2 & 1048575));
                    }
                    break;
                case 5:
                    if (I(t, i3)) {
                        uxVar.B(i4, gx.F(t, iQ2 & 1048575));
                    }
                    break;
                case 6:
                    if (I(t, i3)) {
                        uxVar.D(i4, gx.E(t, iQ2 & 1048575));
                    }
                    break;
                case 7:
                    if (I(t, i3)) {
                        uxVar.R(i4, gx.H(t, iQ2 & 1048575));
                    }
                    break;
                case 8:
                    if (I(t, i3)) {
                        t(i4, gx.L(t, iQ2 & 1048575), uxVar);
                    }
                    break;
                case 9:
                    if (I(t, i3)) {
                        uxVar.Y(i4, gx.L(t, iQ2 & 1048575), N(i3));
                    }
                    break;
                case 10:
                    if (I(t, i3)) {
                        uxVar.I(i4, (zzdmr) gx.L(t, iQ2 & 1048575));
                    }
                    break;
                case 11:
                    if (I(t, i3)) {
                        uxVar.K(i4, gx.E(t, iQ2 & 1048575));
                    }
                    break;
                case 12:
                    if (I(t, i3)) {
                        uxVar.N(i4, gx.E(t, iQ2 & 1048575));
                    }
                    break;
                case 13:
                    if (I(t, i3)) {
                        uxVar.H(i4, gx.E(t, iQ2 & 1048575));
                    }
                    break;
                case 14:
                    if (I(t, i3)) {
                        uxVar.M(i4, gx.F(t, iQ2 & 1048575));
                    }
                    break;
                case 15:
                    if (I(t, i3)) {
                        uxVar.O(i4, gx.E(t, iQ2 & 1048575));
                    }
                    break;
                case 16:
                    if (I(t, i3)) {
                        uxVar.P(i4, gx.F(t, iQ2 & 1048575));
                    }
                    break;
                case 17:
                    if (I(t, i3)) {
                        uxVar.U(i4, gx.L(t, iQ2 & 1048575), N(i3));
                    }
                    break;
                case 18:
                    nw.e(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 19:
                    nw.x(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 20:
                    nw.C(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 21:
                    nw.F(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 22:
                    nw.K(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 23:
                    nw.I(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 24:
                    nw.O(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 25:
                    nw.R(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 26:
                    nw.c(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar);
                    break;
                case 27:
                    nw.d(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, N(i3));
                    break;
                case 28:
                    nw.v(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar);
                    break;
                case 29:
                    nw.M(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 30:
                    nw.Q(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 31:
                    nw.P(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 32:
                    nw.J(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 33:
                    nw.N(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 34:
                    nw.G(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, false);
                    break;
                case 35:
                    nw.e(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 36:
                    nw.x(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 37:
                    nw.C(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 38:
                    nw.F(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 39:
                    nw.K(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 40:
                    nw.I(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 41:
                    nw.O(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 42:
                    nw.R(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 43:
                    nw.M(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 44:
                    nw.Q(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 45:
                    nw.P(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 46:
                    nw.J(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 47:
                    nw.N(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 48:
                    nw.G(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, true);
                    break;
                case 49:
                    nw.w(this.f12269c[i3], (List) gx.L(t, iQ2 & 1048575), uxVar, N(i3));
                    break;
                case 50:
                    v(uxVar, i4, gx.L(t, iQ2 & 1048575), i3);
                    break;
                case 51:
                    if (y(t, i4, i3)) {
                        uxVar.E(i4, L(t, iQ2 & 1048575));
                    }
                    break;
                case 52:
                    if (y(t, i4, i3)) {
                        uxVar.r(i4, M(t, iQ2 & 1048575));
                    }
                    break;
                case 53:
                    if (y(t, i4, i3)) {
                        uxVar.J(i4, V(t, iQ2 & 1048575));
                    }
                    break;
                case 54:
                    if (y(t, i4, i3)) {
                        uxVar.L(i4, V(t, iQ2 & 1048575));
                    }
                    break;
                case 55:
                    if (y(t, i4, i3)) {
                        uxVar.T(i4, U(t, iQ2 & 1048575));
                    }
                    break;
                case 56:
                    if (y(t, i4, i3)) {
                        uxVar.B(i4, V(t, iQ2 & 1048575));
                    }
                    break;
                case 57:
                    if (y(t, i4, i3)) {
                        uxVar.D(i4, U(t, iQ2 & 1048575));
                    }
                    break;
                case 58:
                    if (y(t, i4, i3)) {
                        uxVar.R(i4, W(t, iQ2 & 1048575));
                    }
                    break;
                case 59:
                    if (y(t, i4, i3)) {
                        t(i4, gx.L(t, iQ2 & 1048575), uxVar);
                    }
                    break;
                case 60:
                    if (y(t, i4, i3)) {
                        uxVar.Y(i4, gx.L(t, iQ2 & 1048575), N(i3));
                    }
                    break;
                case 61:
                    if (y(t, i4, i3)) {
                        uxVar.I(i4, (zzdmr) gx.L(t, iQ2 & 1048575));
                    }
                    break;
                case 62:
                    if (y(t, i4, i3)) {
                        uxVar.K(i4, U(t, iQ2 & 1048575));
                    }
                    break;
                case 63:
                    if (y(t, i4, i3)) {
                        uxVar.N(i4, U(t, iQ2 & 1048575));
                    }
                    break;
                case 64:
                    if (y(t, i4, i3)) {
                        uxVar.H(i4, U(t, iQ2 & 1048575));
                    }
                    break;
                case 65:
                    if (y(t, i4, i3)) {
                        uxVar.M(i4, V(t, iQ2 & 1048575));
                    }
                    break;
                case 66:
                    if (y(t, i4, i3)) {
                        uxVar.O(i4, U(t, iQ2 & 1048575));
                    }
                    break;
                case 67:
                    if (y(t, i4, i3)) {
                        uxVar.P(i4, V(t, iQ2 & 1048575));
                    }
                    break;
                case 68:
                    if (y(t, i4, i3)) {
                        uxVar.U(i4, gx.L(t, iQ2 & 1048575), N(i3));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.r.f(uxVar, entry);
            entry = itE.hasNext() ? (Map.Entry) itE.next() : null;
        }
        u(this.q, t, uxVar);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void f(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long jQ = Q(this.l[i3]) & 1048575;
            Object objL = gx.L(t, jQ);
            if (objL != null) {
                gx.g(t, jQ, this.s.d(objL));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.e(t, this.l[i2]);
            i2++;
        }
        this.q.g(t);
        if (this.f12274h) {
            this.r.g(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:87:0x01a4  */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x022e, code lost:
    
        if (r0 == r15) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0230, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01e2, code lost:
    
        if (r0 == r15) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x020f, code lost:
    
        if (r0 == r15) goto L104;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0061. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.lw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.bu r32) throws java.io.IOException, java.lang.CloneNotSupportedException {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aw.g(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.bu):void");
    }

    /* JADX WARN: Code duplicated, block: B:165:0x05ce A[LOOP:5: B:163:0x05ca->B:165:0x05ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:167:0x05db  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.ads.lw
    public final void h(T t, kw kwVar, zzdno zzdnoVar) throws IOException {
        int i2;
        zzdnoVar.getClass();
        cx<?, ?> cxVar = this.q;
        vu<?> vuVar = this.r;
        yu yuVarJ = null;
        Object objR = null;
        while (true) {
            try {
                int iN = kwVar.N();
                int iT = T(iN);
                if (iT >= 0) {
                    int iQ = Q(iT);
                    switch ((267386880 & iQ) >>> 20) {
                        case 0:
                            gx.d(t, iQ & 1048575, kwVar.readDouble());
                            K(t, iT);
                            continue;
                        case 1:
                            gx.e(t, iQ & 1048575, kwVar.readFloat());
                            K(t, iT);
                            continue;
                        case 2:
                            gx.f(t, iQ & 1048575, kwVar.K());
                            K(t, iT);
                            continue;
                        case 3:
                            gx.f(t, iQ & 1048575, kwVar.E());
                            K(t, iT);
                            continue;
                        case 4:
                            gx.n(t, iQ & 1048575, kwVar.P());
                            K(t, iT);
                            continue;
                        case 5:
                            gx.f(t, iQ & 1048575, kwVar.L());
                            K(t, iT);
                            continue;
                        case 6:
                            gx.n(t, iQ & 1048575, kwVar.R());
                            K(t, iT);
                            continue;
                        case 7:
                            gx.h(t, iQ & 1048575, kwVar.G());
                            K(t, iT);
                            continue;
                        case 8:
                            w(t, iQ, kwVar);
                            K(t, iT);
                            continue;
                        case 9:
                            if (I(t, iT)) {
                                long j2 = iQ & 1048575;
                                gx.g(t, j2, zzdod.g(gx.L(t, j2), kwVar.U(N(iT), zzdnoVar)));
                            } else {
                                gx.g(t, iQ & 1048575, kwVar.U(N(iT), zzdnoVar));
                                K(t, iT);
                                continue;
                            }
                            break;
                        case 10:
                            gx.g(t, iQ & 1048575, kwVar.T());
                            K(t, iT);
                            continue;
                        case 11:
                            gx.n(t, iQ & 1048575, kwVar.V());
                            K(t, iT);
                            continue;
                        case 12:
                            int iX = kwVar.X();
                            zzdog zzdogVarP = P(iT);
                            if (zzdogVarP == null || zzdogVarP.a(iX)) {
                                gx.n(t, iQ & 1048575, iX);
                                K(t, iT);
                                continue;
                            } else {
                                objR = nw.a(iN, iX, objR, cxVar);
                            }
                            break;
                        case 13:
                            gx.n(t, iQ & 1048575, kwVar.b0());
                            K(t, iT);
                            continue;
                        case 14:
                            gx.f(t, iQ & 1048575, kwVar.e0());
                            K(t, iT);
                            continue;
                        case 15:
                            gx.n(t, iQ & 1048575, kwVar.D());
                            K(t, iT);
                            continue;
                        case 16:
                            gx.f(t, iQ & 1048575, kwVar.J());
                            K(t, iT);
                            continue;
                        case 17:
                            if (I(t, iT)) {
                                long j3 = iQ & 1048575;
                                gx.g(t, j3, zzdod.g(gx.L(t, j3), kwVar.c0(N(iT), zzdnoVar)));
                            } else {
                                gx.g(t, iQ & 1048575, kwVar.c0(N(iT), zzdnoVar));
                                K(t, iT);
                                continue;
                            }
                            break;
                        case 18:
                            kwVar.r(this.p.a(t, iQ & 1048575));
                            continue;
                        case 19:
                            kwVar.o(this.p.a(t, iQ & 1048575));
                            continue;
                        case 20:
                            kwVar.u(this.p.a(t, iQ & 1048575));
                            continue;
                        case 21:
                            kwVar.z(this.p.a(t, iQ & 1048575));
                            continue;
                        case 22:
                            kwVar.C(this.p.a(t, iQ & 1048575));
                            continue;
                        case 23:
                            kwVar.B(this.p.a(t, iQ & 1048575));
                            continue;
                        case 24:
                            kwVar.n(this.p.a(t, iQ & 1048575));
                            continue;
                        case 25:
                            kwVar.i(this.p.a(t, iQ & 1048575));
                            continue;
                        case 26:
                            if (S(iQ)) {
                                kwVar.t(this.p.a(t, iQ & 1048575));
                            } else {
                                kwVar.b(this.p.a(t, iQ & 1048575));
                                continue;
                            }
                            break;
                        case 27:
                            kwVar.Z(this.p.a(t, iQ & 1048575), N(iT), zzdnoVar);
                            continue;
                        case 28:
                            kwVar.O(this.p.a(t, iQ & 1048575));
                            continue;
                        case 29:
                            kwVar.Y(this.p.a(t, iQ & 1048575));
                            continue;
                        case 30:
                            List<Integer> listA = this.p.a(t, iQ & 1048575);
                            kwVar.W(listA);
                            objR = nw.b(iN, listA, P(iT), objR, cxVar);
                            continue;
                        case 31:
                            kwVar.d0(this.p.a(t, iQ & 1048575));
                            continue;
                        case 32:
                            kwVar.a0(this.p.a(t, iQ & 1048575));
                            continue;
                        case 33:
                            kwVar.I(this.p.a(t, iQ & 1048575));
                            continue;
                        case 34:
                            kwVar.H(this.p.a(t, iQ & 1048575));
                            continue;
                        case 35:
                            kwVar.r(this.p.a(t, iQ & 1048575));
                            continue;
                        case 36:
                            kwVar.o(this.p.a(t, iQ & 1048575));
                            continue;
                        case 37:
                            kwVar.u(this.p.a(t, iQ & 1048575));
                            continue;
                        case 38:
                            kwVar.z(this.p.a(t, iQ & 1048575));
                            continue;
                        case 39:
                            kwVar.C(this.p.a(t, iQ & 1048575));
                            continue;
                        case 40:
                            kwVar.B(this.p.a(t, iQ & 1048575));
                            continue;
                        case 41:
                            kwVar.n(this.p.a(t, iQ & 1048575));
                            continue;
                        case 42:
                            kwVar.i(this.p.a(t, iQ & 1048575));
                            continue;
                        case 43:
                            kwVar.Y(this.p.a(t, iQ & 1048575));
                            continue;
                        case 44:
                            List<Integer> listA2 = this.p.a(t, iQ & 1048575);
                            kwVar.W(listA2);
                            objR = nw.b(iN, listA2, P(iT), objR, cxVar);
                            continue;
                        case 45:
                            kwVar.d0(this.p.a(t, iQ & 1048575));
                            continue;
                        case 46:
                            kwVar.a0(this.p.a(t, iQ & 1048575));
                            continue;
                        case 47:
                            kwVar.I(this.p.a(t, iQ & 1048575));
                            continue;
                        case 48:
                            kwVar.H(this.p.a(t, iQ & 1048575));
                            continue;
                        case 49:
                            kwVar.Q(this.p.a(t, iQ & 1048575), N(iT), zzdnoVar);
                            continue;
                        case 50:
                            Object objO = O(iT);
                            long jQ = Q(iT) & 1048575;
                            Object objL = gx.L(t, jQ);
                            if (objL == null) {
                                objL = this.s.e(objO);
                                gx.g(t, jQ, objL);
                            } else if (this.s.c(objL)) {
                                Object objE = this.s.e(objO);
                                this.s.a(objE, objL);
                                gx.g(t, jQ, objE);
                                objL = objE;
                            }
                            kwVar.F(this.s.h(objL), this.s.g(objO), zzdnoVar);
                            continue;
                        case 51:
                            gx.g(t, iQ & 1048575, Double.valueOf(kwVar.readDouble()));
                            E(t, iN, iT);
                            continue;
                        case 52:
                            gx.g(t, iQ & 1048575, Float.valueOf(kwVar.readFloat()));
                            E(t, iN, iT);
                            continue;
                        case 53:
                            gx.g(t, iQ & 1048575, Long.valueOf(kwVar.K()));
                            E(t, iN, iT);
                            continue;
                        case 54:
                            gx.g(t, iQ & 1048575, Long.valueOf(kwVar.E()));
                            E(t, iN, iT);
                            continue;
                        case 55:
                            gx.g(t, iQ & 1048575, Integer.valueOf(kwVar.P()));
                            E(t, iN, iT);
                            continue;
                        case 56:
                            gx.g(t, iQ & 1048575, Long.valueOf(kwVar.L()));
                            E(t, iN, iT);
                            continue;
                        case 57:
                            gx.g(t, iQ & 1048575, Integer.valueOf(kwVar.R()));
                            E(t, iN, iT);
                            continue;
                        case 58:
                            gx.g(t, iQ & 1048575, Boolean.valueOf(kwVar.G()));
                            E(t, iN, iT);
                            continue;
                        case 59:
                            w(t, iQ, kwVar);
                            E(t, iN, iT);
                            continue;
                        case 60:
                            if (y(t, iN, iT)) {
                                long j4 = iQ & 1048575;
                                gx.g(t, j4, zzdod.g(gx.L(t, j4), kwVar.U(N(iT), zzdnoVar)));
                            } else {
                                gx.g(t, iQ & 1048575, kwVar.U(N(iT), zzdnoVar));
                                K(t, iT);
                            }
                            E(t, iN, iT);
                            continue;
                        case 61:
                            gx.g(t, iQ & 1048575, kwVar.T());
                            E(t, iN, iT);
                            continue;
                        case 62:
                            gx.g(t, iQ & 1048575, Integer.valueOf(kwVar.V()));
                            E(t, iN, iT);
                            continue;
                        case 63:
                            int iX2 = kwVar.X();
                            zzdog zzdogVarP2 = P(iT);
                            if (zzdogVarP2 == null || zzdogVarP2.a(iX2)) {
                                gx.g(t, iQ & 1048575, Integer.valueOf(iX2));
                                E(t, iN, iT);
                                continue;
                            } else {
                                objR = nw.a(iN, iX2, objR, cxVar);
                            }
                            break;
                        case 64:
                            gx.g(t, iQ & 1048575, Integer.valueOf(kwVar.b0()));
                            E(t, iN, iT);
                            continue;
                        case 65:
                            gx.g(t, iQ & 1048575, Long.valueOf(kwVar.e0()));
                            E(t, iN, iT);
                            continue;
                        case 66:
                            gx.g(t, iQ & 1048575, Integer.valueOf(kwVar.D()));
                            E(t, iN, iT);
                            continue;
                        case 67:
                            gx.g(t, iQ & 1048575, Long.valueOf(kwVar.J()));
                            E(t, iN, iT);
                            continue;
                        case 68:
                            gx.g(t, iQ & 1048575, kwVar.c0(N(iT), zzdnoVar));
                            E(t, iN, iT);
                            continue;
                        default:
                            if (objR == null) {
                                try {
                                    objR = cxVar.m();
                                } catch (zzdol unused) {
                                    cxVar.e(kwVar);
                                    if (objR == null) {
                                        objR = cxVar.k(t);
                                    }
                                    if (!cxVar.f((Object) objR, kwVar)) {
                                        for (int i3 = this.m; i3 < this.n; i3++) {
                                            objR = r(t, this.l[i3], objR, cxVar);
                                        }
                                        if (objR != null) {
                                            cxVar.r(t, (Object) objR);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            if (!cxVar.f((Object) objR, kwVar)) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    objR = r(t, this.l[i4], objR, cxVar);
                                }
                                if (objR != null) {
                                    cxVar.r(t, (Object) objR);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                    for (i2 = this.m; i2 < this.n; i2++) {
                        objR = r(t, this.l[i2], objR, cxVar);
                    }
                    if (objR != null) {
                        cxVar.r(t, (Object) objR);
                    }
                    throw th;
                }
                if (iN == Integer.MAX_VALUE) {
                    for (int i5 = this.m; i5 < this.n; i5++) {
                        objR = r(t, this.l[i5], objR, cxVar);
                    }
                    if (objR != null) {
                        cxVar.r(t, (Object) objR);
                        return;
                    }
                    return;
                }
                Object objB = !this.f12274h ? null : vuVar.b(zzdnoVar, this.f12273g, iN);
                if (objB != null) {
                    if (yuVarJ == null) {
                        yuVarJ = vuVar.j(t);
                    }
                    yu yuVar = yuVarJ;
                    objR = vuVar.c(kwVar, objB, zzdnoVar, yuVar, objR, cxVar);
                    yuVarJ = yuVar;
                } else {
                    cxVar.e(kwVar);
                    if (objR == null) {
                        objR = cxVar.k(t);
                    }
                    if (!cxVar.f((Object) objR, kwVar)) {
                        for (int i6 = this.m; i6 < this.n; i6++) {
                            objR = r(t, this.l[i6], objR, cxVar);
                        }
                        if (objR != null) {
                            cxVar.r(t, (Object) objR);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                while (i2 < this.n) {
                    objR = r(t, this.l[i2], objR, cxVar);
                }
                if (objR != null) {
                    cxVar.r(t, (Object) objR);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:420:0x0908 A[PHI: r6
      0x0908: PHI (r6v4 int) = 
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v13 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v14 int)
      (r6v1 int)
     binds: [B:256:0x0545, B:460:0x09b6, B:457:0x09ac, B:451:0x0990, B:448:0x097e, B:445:0x096f, B:442:0x0962, B:439:0x0955, B:435:0x094a, B:432:0x093f, B:429:0x0932, B:426:0x0925, B:423:0x0912, B:396:0x081e, B:390:0x0801, B:384:0x07e4, B:378:0x07c7, B:372:0x07a9, B:366:0x078b, B:360:0x076d, B:354:0x074f, B:348:0x0731, B:342:0x0713, B:336:0x06f5, B:330:0x06d7, B:324:0x06b9, B:318:0x069b, B:313:0x0667, B:310:0x065a, B:307:0x064a, B:304:0x063a, B:301:0x062a, B:298:0x061c, B:295:0x060f, B:292:0x0603, B:286:0x05e5, B:283:0x05d1, B:280:0x05bf, B:277:0x05af, B:274:0x059f, B:437:0x0951, B:271:0x0592, B:268:0x0584, B:265:0x0574, B:262:0x0564, B:419:0x0907, B:259:0x054e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.lw
    public final int i(T t) {
        int i2;
        int i3;
        long j2;
        int iZ0;
        int iW0;
        int iS;
        int iO;
        int iH0;
        int iJ0;
        int I;
        int iO2;
        int iH1;
        int iJ1;
        int i4 = 267386880;
        if (!this.f12276j) {
            Unsafe unsafe = f12268b;
            int i5 = -1;
            int I2 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < this.f12269c.length; i7 += 3) {
                int iQ = Q(i7);
                int[] iArr = this.f12269c;
                int i8 = iArr[i7];
                int i9 = (iQ & 267386880) >>> 20;
                if (i9 <= 17) {
                    int i10 = iArr[i7 + 2];
                    int i11 = i10 & 1048575;
                    i3 = 1 << (i10 >>> 20);
                    if (i11 != i5) {
                        i6 = unsafe.getInt(t, i11);
                        i5 = i11;
                    }
                    i2 = i10;
                } else {
                    i2 = (!this.f12277k || i9 < zzdnv.O.g() || i9 > zzdnv.b0.g()) ? 0 : this.f12269c[i7 + 2] & 1048575;
                    i3 = 0;
                }
                long j3 = iQ & 1048575;
                switch (i9) {
                    case 0:
                        j2 = 0;
                        if ((i6 & i3) != 0) {
                            I2 += zzdni.I(i8, 0.0d);
                        }
                        break;
                    case 1:
                        j2 = 0;
                        if ((i6 & i3) != 0) {
                            I2 += zzdni.x(i8, 0.0f);
                        }
                        break;
                    case 2:
                        j2 = 0;
                        if ((i6 & i3) != 0) {
                            iZ0 = zzdni.z0(i8, unsafe.getLong(t, j3));
                            I2 += iZ0;
                        }
                        break;
                    case 3:
                        j2 = 0;
                        if ((i6 & i3) != 0) {
                            iZ0 = zzdni.B0(i8, unsafe.getLong(t, j3));
                            I2 += iZ0;
                        }
                        break;
                    case 4:
                        j2 = 0;
                        if ((i6 & i3) != 0) {
                            iZ0 = zzdni.m(i8, unsafe.getInt(t, j3));
                            I2 += iZ0;
                        }
                        break;
                    case 5:
                        j2 = 0;
                        if ((i6 & i3) != 0) {
                            iZ0 = zzdni.F0(i8, 0L);
                            I2 += iZ0;
                        }
                        break;
                    case 6:
                        if ((i6 & i3) != 0) {
                            I2 += zzdni.r(i8, 0);
                        }
                        j2 = 0;
                        break;
                    case 7:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.w0(i8, true);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 8:
                        if ((i6 & i3) != 0) {
                            Object object = unsafe.getObject(t, j3);
                            iW0 = object instanceof zzdmr ? zzdni.J(i8, (zzdmr) object) : zzdni.c0(i8, (String) object);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 9:
                        if ((i6 & i3) != 0) {
                            iW0 = nw.z(i8, unsafe.getObject(t, j3), N(i7));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 10:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.J(i8, (zzdmr) unsafe.getObject(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 11:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.o(i8, unsafe.getInt(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 12:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.t(i8, unsafe.getInt(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 13:
                        if ((i6 & i3) != 0) {
                            iS = zzdni.s(i8, 0);
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 14:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.G0(i8, 0L);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 15:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.q(i8, unsafe.getInt(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 16:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.D0(i8, unsafe.getLong(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 17:
                        if ((i6 & i3) != 0) {
                            iW0 = zzdni.L(i8, (zzdpk) unsafe.getObject(t, j3), N(i7));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 18:
                        iW0 = nw.a0(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 19:
                        iW0 = nw.Z(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 20:
                        iW0 = nw.S(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 21:
                        iW0 = nw.T(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 22:
                        iW0 = nw.W(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 23:
                        iW0 = nw.a0(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 24:
                        iW0 = nw.Z(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 25:
                        iW0 = nw.b0(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 26:
                        iW0 = nw.A(i8, (List) unsafe.getObject(t, j3));
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 27:
                        iW0 = nw.B(i8, (List) unsafe.getObject(t, j3), N(i7));
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 28:
                        iW0 = nw.D(i8, (List) unsafe.getObject(t, j3));
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 29:
                        iW0 = nw.X(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 30:
                        iW0 = nw.V(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 31:
                        iW0 = nw.Z(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 32:
                        iW0 = nw.a0(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 33:
                        iW0 = nw.Y(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 34:
                        iW0 = nw.U(i8, (List) unsafe.getObject(t, j3), false);
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 35:
                        iO = nw.o((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 36:
                        iO = nw.n((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 37:
                        iO = nw.c0((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 38:
                        iO = nw.d0((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 39:
                        iO = nw.k((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 40:
                        iO = nw.o((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 41:
                        iO = nw.n((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 42:
                        iO = nw.p((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 43:
                        iO = nw.l((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 44:
                        iO = nw.j((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 45:
                        iO = nw.n((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 46:
                        iO = nw.o((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 47:
                        iO = nw.m((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 48:
                        iO = nw.i((List) unsafe.getObject(t, j3));
                        if (iO > 0) {
                            if (this.f12277k) {
                                unsafe.putInt(t, i2, iO);
                            }
                            iH0 = zzdni.h0(i8);
                            iJ0 = zzdni.j0(iO);
                            iS = iH0 + iJ0 + iO;
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 49:
                        iW0 = nw.E(i8, (List) unsafe.getObject(t, j3), N(i7));
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 50:
                        iW0 = this.s.f(i8, unsafe.getObject(t, j3), O(i7));
                        I2 += iW0;
                        j2 = 0;
                        break;
                    case 51:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.I(i8, 0.0d);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 52:
                        if (y(t, i8, i7)) {
                            iS = zzdni.x(i8, 0.0f);
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 53:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.z0(i8, V(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 54:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.B0(i8, V(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 55:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.m(i8, U(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 56:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.F0(i8, 0L);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 57:
                        if (y(t, i8, i7)) {
                            iS = zzdni.r(i8, 0);
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 58:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.w0(i8, true);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 59:
                        if (y(t, i8, i7)) {
                            Object object2 = unsafe.getObject(t, j3);
                            iW0 = object2 instanceof zzdmr ? zzdni.J(i8, (zzdmr) object2) : zzdni.c0(i8, (String) object2);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 60:
                        if (y(t, i8, i7)) {
                            iW0 = nw.z(i8, unsafe.getObject(t, j3), N(i7));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 61:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.J(i8, (zzdmr) unsafe.getObject(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 62:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.o(i8, U(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 63:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.t(i8, U(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 64:
                        if (y(t, i8, i7)) {
                            iS = zzdni.s(i8, 0);
                            I2 += iS;
                        }
                        j2 = 0;
                        break;
                    case 65:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.G0(i8, 0L);
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 66:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.q(i8, U(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 67:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.D0(i8, V(t, j3));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    case 68:
                        if (y(t, i8, i7)) {
                            iW0 = zzdni.L(i8, (zzdpk) unsafe.getObject(t, j3), N(i7));
                            I2 += iW0;
                        }
                        j2 = 0;
                        break;
                    default:
                        j2 = 0;
                        break;
                }
            }
            int iK = I2 + k(this.q, t);
            return this.f12274h ? iK + this.r.i(t).n() : iK;
        }
        Unsafe unsafe2 = f12268b;
        int i12 = 0;
        int i13 = 0;
        while (i12 < this.f12269c.length) {
            int iQ2 = Q(i12);
            int i14 = (iQ2 & i4) >>> 20;
            int i15 = this.f12269c[i12];
            long j4 = iQ2 & 1048575;
            int i16 = (i14 < zzdnv.O.g() || i14 > zzdnv.b0.g()) ? 0 : this.f12269c[i12 + 2] & 1048575;
            switch (i14) {
                case 0:
                    if (I(t, i12)) {
                        I = zzdni.I(i15, 0.0d);
                        i13 += I;
                    }
                    break;
                case 1:
                    if (I(t, i12)) {
                        I = zzdni.x(i15, 0.0f);
                        i13 += I;
                    }
                    break;
                case 2:
                    if (I(t, i12)) {
                        I = zzdni.z0(i15, gx.F(t, j4));
                        i13 += I;
                    }
                    break;
                case 3:
                    if (I(t, i12)) {
                        I = zzdni.B0(i15, gx.F(t, j4));
                        i13 += I;
                    }
                    break;
                case 4:
                    if (I(t, i12)) {
                        I = zzdni.m(i15, gx.E(t, j4));
                        i13 += I;
                    }
                    break;
                case 5:
                    if (I(t, i12)) {
                        I = zzdni.F0(i15, 0L);
                        i13 += I;
                    }
                    break;
                case 6:
                    if (I(t, i12)) {
                        I = zzdni.r(i15, 0);
                        i13 += I;
                    }
                    break;
                case 7:
                    if (I(t, i12)) {
                        I = zzdni.w0(i15, true);
                        i13 += I;
                    }
                    break;
                case 8:
                    if (I(t, i12)) {
                        Object objL = gx.L(t, j4);
                        I = objL instanceof zzdmr ? zzdni.J(i15, (zzdmr) objL) : zzdni.c0(i15, (String) objL);
                        i13 += I;
                    }
                    break;
                case 9:
                    if (I(t, i12)) {
                        I = nw.z(i15, gx.L(t, j4), N(i12));
                        i13 += I;
                    }
                    break;
                case 10:
                    if (I(t, i12)) {
                        I = zzdni.J(i15, (zzdmr) gx.L(t, j4));
                        i13 += I;
                    }
                    break;
                case 11:
                    if (I(t, i12)) {
                        I = zzdni.o(i15, gx.E(t, j4));
                        i13 += I;
                    }
                    break;
                case 12:
                    if (I(t, i12)) {
                        I = zzdni.t(i15, gx.E(t, j4));
                        i13 += I;
                    }
                    break;
                case 13:
                    if (I(t, i12)) {
                        I = zzdni.s(i15, 0);
                        i13 += I;
                    }
                    break;
                case 14:
                    if (I(t, i12)) {
                        I = zzdni.G0(i15, 0L);
                        i13 += I;
                    }
                    break;
                case 15:
                    if (I(t, i12)) {
                        I = zzdni.q(i15, gx.E(t, j4));
                        i13 += I;
                    }
                    break;
                case 16:
                    if (I(t, i12)) {
                        I = zzdni.D0(i15, gx.F(t, j4));
                        i13 += I;
                    }
                    break;
                case 17:
                    if (I(t, i12)) {
                        I = zzdni.L(i15, (zzdpk) gx.L(t, j4), N(i12));
                        i13 += I;
                    }
                    break;
                case 18:
                    I = nw.a0(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 19:
                    I = nw.Z(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 20:
                    I = nw.S(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 21:
                    I = nw.T(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 22:
                    I = nw.W(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 23:
                    I = nw.a0(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 24:
                    I = nw.Z(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 25:
                    I = nw.b0(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 26:
                    I = nw.A(i15, J(t, j4));
                    i13 += I;
                    break;
                case 27:
                    I = nw.B(i15, J(t, j4), N(i12));
                    i13 += I;
                    break;
                case 28:
                    I = nw.D(i15, J(t, j4));
                    i13 += I;
                    break;
                case 29:
                    I = nw.X(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 30:
                    I = nw.V(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 31:
                    I = nw.Z(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 32:
                    I = nw.a0(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 33:
                    I = nw.Y(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 34:
                    I = nw.U(i15, J(t, j4), false);
                    i13 += I;
                    break;
                case 35:
                    iO2 = nw.o((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 36:
                    iO2 = nw.n((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 37:
                    iO2 = nw.c0((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 38:
                    iO2 = nw.d0((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 39:
                    iO2 = nw.k((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 40:
                    iO2 = nw.o((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 41:
                    iO2 = nw.n((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 42:
                    iO2 = nw.p((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 43:
                    iO2 = nw.l((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 44:
                    iO2 = nw.j((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 45:
                    iO2 = nw.n((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 46:
                    iO2 = nw.o((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 47:
                    iO2 = nw.m((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 48:
                    iO2 = nw.i((List) unsafe2.getObject(t, j4));
                    if (iO2 > 0) {
                        if (this.f12277k) {
                            unsafe2.putInt(t, i16, iO2);
                        }
                        iH1 = zzdni.h0(i15);
                        iJ1 = zzdni.j0(iO2);
                        I = iH1 + iJ1 + iO2;
                        i13 += I;
                    }
                    break;
                case 49:
                    I = nw.E(i15, J(t, j4), N(i12));
                    i13 += I;
                    break;
                case 50:
                    I = this.s.f(i15, gx.L(t, j4), O(i12));
                    i13 += I;
                    break;
                case 51:
                    if (y(t, i15, i12)) {
                        I = zzdni.I(i15, 0.0d);
                        i13 += I;
                    }
                    break;
                case 52:
                    if (y(t, i15, i12)) {
                        I = zzdni.x(i15, 0.0f);
                        i13 += I;
                    }
                    break;
                case 53:
                    if (y(t, i15, i12)) {
                        I = zzdni.z0(i15, V(t, j4));
                        i13 += I;
                    }
                    break;
                case 54:
                    if (y(t, i15, i12)) {
                        I = zzdni.B0(i15, V(t, j4));
                        i13 += I;
                    }
                    break;
                case 55:
                    if (y(t, i15, i12)) {
                        I = zzdni.m(i15, U(t, j4));
                        i13 += I;
                    }
                    break;
                case 56:
                    if (y(t, i15, i12)) {
                        I = zzdni.F0(i15, 0L);
                        i13 += I;
                    }
                    break;
                case 57:
                    if (y(t, i15, i12)) {
                        I = zzdni.r(i15, 0);
                        i13 += I;
                    }
                    break;
                case 58:
                    if (y(t, i15, i12)) {
                        I = zzdni.w0(i15, true);
                        i13 += I;
                    }
                    break;
                case 59:
                    if (y(t, i15, i12)) {
                        Object objL2 = gx.L(t, j4);
                        I = objL2 instanceof zzdmr ? zzdni.J(i15, (zzdmr) objL2) : zzdni.c0(i15, (String) objL2);
                        i13 += I;
                    }
                    break;
                case 60:
                    if (y(t, i15, i12)) {
                        I = nw.z(i15, gx.L(t, j4), N(i12));
                        i13 += I;
                    }
                    break;
                case 61:
                    if (y(t, i15, i12)) {
                        I = zzdni.J(i15, (zzdmr) gx.L(t, j4));
                        i13 += I;
                    }
                    break;
                case 62:
                    if (y(t, i15, i12)) {
                        I = zzdni.o(i15, U(t, j4));
                        i13 += I;
                    }
                    break;
                case 63:
                    if (y(t, i15, i12)) {
                        I = zzdni.t(i15, U(t, j4));
                        i13 += I;
                    }
                    break;
                case 64:
                    if (y(t, i15, i12)) {
                        I = zzdni.s(i15, 0);
                        i13 += I;
                    }
                    break;
                case 65:
                    if (y(t, i15, i12)) {
                        I = zzdni.G0(i15, 0L);
                        i13 += I;
                    }
                    break;
                case 66:
                    if (y(t, i15, i12)) {
                        I = zzdni.q(i15, U(t, j4));
                        i13 += I;
                    }
                    break;
                case 67:
                    if (y(t, i15, i12)) {
                        I = zzdni.D0(i15, V(t, j4));
                        i13 += I;
                    }
                    break;
                case 68:
                    if (y(t, i15, i12)) {
                        I = zzdni.L(i15, (zzdpk) gx.L(t, j4), N(i12));
                        i13 += I;
                    }
                    break;
            }
            i12 += 3;
            i4 = 267386880;
        }
        return i13 + k(this.q, t);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bd A[LOOP:1: B:47:0x00ab->B:52:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.lw
    public final boolean j(T t) {
        int i2;
        List list;
        lw lwVarN;
        int i3;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.m) {
                return !this.f12274h || this.r.i(t).d();
            }
            int i7 = this.l[i5];
            int i8 = this.f12269c[i7];
            int iQ = Q(i7);
            if (this.f12276j) {
                i2 = 0;
            } else {
                int i9 = this.f12269c[i7 + 2];
                int i10 = i9 & 1048575;
                i2 = 1 << (i9 >>> 20);
                if (i10 != i4) {
                    i6 = f12268b.getInt(t, i10);
                    i4 = i10;
                }
            }
            if (((268435456 & iQ) != 0) && !z(t, i7, i6, i2)) {
                return false;
            }
            int i11 = (267386880 & iQ) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (z(t, i7, i6, i2) && !A(t, iQ, N(i7))) {
                    return false;
                }
            } else if (i11 == 27) {
                list = (List) gx.L(t, iQ & 1048575);
                if (!list.isEmpty()) {
                    lwVarN = N(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!lwVarN.j(list.get(i3))) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (i11 == 60 || i11 == 68) {
                if (y(t, i8, i7) && !A(t, iQ, N(i7))) {
                    return false;
                }
            } else if (i11 == 49) {
                list = (List) gx.L(t, iQ & 1048575);
                if (!list.isEmpty()) {
                    lwVarN = N(i7);
                    while (i3 < list.size()) {
                        if (!lwVarN.j(list.get(i3))) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (i11 == 50 && !this.s.b(gx.L(t, iQ & 1048575)).isEmpty()) {
                this.s.g(O(i7));
                throw null;
            }
            i5++;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12741. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int o(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.ads.bu r35) throws java.io.IOException, java.lang.CloneNotSupportedException {
        /*
            Method dump skipped, instruction units count: 1274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aw.o(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.bu):int");
    }
}
