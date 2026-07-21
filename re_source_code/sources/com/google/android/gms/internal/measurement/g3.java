package com.google.android.gms.internal.measurement;

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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g3<T> implements p3<T> {
    private static final int[] a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Unsafe f17156b = k4.t();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f17157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f17158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzgo f17161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f17162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f17163i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f17164j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f17165k;
    private final int[] l;
    private final int m;
    private final int n;
    private final j3 o;
    private final s2 p;
    private final h4<?, ?> q;
    private final d2<?> r;
    private final a3 s;

    private g3(int[] iArr, Object[] objArr, int i2, int i3, zzgo zzgoVar, boolean z, boolean z2, int[] iArr2, int i4, int i5, j3 j3Var, s2 s2Var, h4<?, ?> h4Var, d2<?> d2Var, a3 a3Var) {
        this.f17157c = iArr;
        this.f17158d = objArr;
        this.f17159e = i2;
        this.f17160f = i3;
        this.f17163i = zzgoVar instanceof zzfd;
        this.f17164j = z;
        this.f17162h = d2Var != null && d2Var.h(zzgoVar);
        this.f17165k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = j3Var;
        this.p = s2Var;
        this.q = h4Var;
        this.r = d2Var;
        this.f17161g = zzgoVar;
        this.s = a3Var;
    }

    private final void A(T t, T t2, int i2) {
        long jP = P(i2) & 1048575;
        if (B(t2, i2)) {
            Object objF = k4.F(t, jP);
            Object objF2 = k4.F(t2, jP);
            if (objF != null && objF2 != null) {
                k4.j(t, jP, zzff.e(objF, objF2));
                I(t, i2);
            } else if (objF2 != null) {
                k4.j(t, jP, objF2);
                I(t, i2);
            }
        }
    }

    private final boolean B(T t, int i2) {
        if (!this.f17164j) {
            int iR = R(i2);
            return (k4.b(t, (long) (iR & 1048575)) & (1 << (iR >>> 20))) != 0;
        }
        int iP = P(i2);
        long j2 = iP & 1048575;
        switch ((iP & 267386880) >>> 20) {
            case 0:
                return k4.C(t, j2) != 0.0d;
            case 1:
                return k4.x(t, j2) != 0.0f;
            case 2:
                return k4.o(t, j2) != 0;
            case 3:
                return k4.o(t, j2) != 0;
            case 4:
                return k4.b(t, j2) != 0;
            case 5:
                return k4.o(t, j2) != 0;
            case 6:
                return k4.b(t, j2) != 0;
            case 7:
                return k4.w(t, j2);
            case 8:
                Object objF = k4.F(t, j2);
                if (objF instanceof String) {
                    return !((String) objF).isEmpty();
                }
                if (objF instanceof zzdu) {
                    return !zzdu.f17368f.equals(objF);
                }
                throw new IllegalArgumentException();
            case 9:
                return k4.F(t, j2) != null;
            case 10:
                return !zzdu.f17368f.equals(k4.F(t, j2));
            case 11:
                return k4.b(t, j2) != 0;
            case 12:
                return k4.b(t, j2) != 0;
            case 13:
                return k4.b(t, j2) != 0;
            case 14:
                return k4.o(t, j2) != 0;
            case 15:
                return k4.b(t, j2) != 0;
            case 16:
                return k4.o(t, j2) != 0;
            case 17:
                return k4.F(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean C(T t, int i2, int i3) {
        return k4.b(t, (long) (R(i3) & 1048575)) == i2;
    }

    private final boolean D(T t, int i2, int i3, int i4) {
        if (this.f17164j) {
            return B(t, i2);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean E(Object obj, int i2, p3 p3Var) {
        return p3Var.e(k4.F(obj, i2 & 1048575));
    }

    private static <T> double F(T t, long j2) {
        return ((Double) k4.F(t, j2)).doubleValue();
    }

    private final int G(int i2, int i3) {
        int length = (this.f17157c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f17157c[i5];
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

    private final Object H(int i2) {
        return this.f17158d[(i2 / 3) << 1];
    }

    private final void I(T t, int i2) {
        if (this.f17164j) {
            return;
        }
        int iR = R(i2);
        long j2 = iR & 1048575;
        k4.h(t, j2, k4.b(t, j2) | (1 << (iR >>> 20)));
    }

    private final void J(T t, int i2, int i3) {
        k4.h(t, R(i3) & 1048575, i2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    private final void K(T t, y4 y4Var) throws IOException {
        Iterator itO;
        Map.Entry<?, ?> entry;
        int i2;
        if (this.f17162h) {
            h2<T> h2VarB = this.r.b(t);
            if (h2VarB.f17168b.isEmpty()) {
                itO = null;
                entry = null;
            } else {
                itO = h2VarB.o();
                entry = (Map.Entry) itO.next();
            }
        } else {
            itO = null;
            entry = null;
        }
        int i3 = -1;
        int length = this.f17157c.length;
        Unsafe unsafe = f17156b;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iP = P(i4);
            int[] iArr = this.f17157c;
            int i6 = iArr[i4];
            int i7 = (267386880 & iP) >>> 20;
            if (this.f17164j || i7 > 17) {
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
                this.r.g(y4Var, entry);
                entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
            }
            long j2 = iP & 1048575;
            int i10 = i4;
            switch (i7) {
                case 0:
                    if ((i2 & i5) != 0) {
                        y4Var.h(i6, k4.C(t, j2));
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 1:
                    if ((i2 & i5) != 0) {
                        y4Var.r(i6, k4.x(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 2:
                    if ((i2 & i5) != 0) {
                        y4Var.q(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 3:
                    if ((i2 & i5) != 0) {
                        y4Var.c(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 4:
                    if ((i2 & i5) != 0) {
                        y4Var.G(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 5:
                    if ((i2 & i5) != 0) {
                        y4Var.L(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 6:
                    if ((i2 & i5) != 0) {
                        y4Var.y(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 7:
                    if ((i2 & i5) != 0) {
                        y4Var.B(i6, k4.w(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 8:
                    if ((i2 & i5) != 0) {
                        w(i6, unsafe.getObject(t, j2), y4Var);
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 9:
                    if ((i2 & i5) != 0) {
                        y4Var.C(i6, unsafe.getObject(t, j2), r(i10));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 10:
                    if ((i2 & i5) != 0) {
                        y4Var.E(i6, (zzdu) unsafe.getObject(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 11:
                    if ((i2 & i5) != 0) {
                        y4Var.M(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 12:
                    if ((i2 & i5) != 0) {
                        y4Var.D(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 13:
                    if ((i2 & i5) != 0) {
                        y4Var.H(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 14:
                    if ((i2 & i5) != 0) {
                        y4Var.b(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 15:
                    if ((i2 & i5) != 0) {
                        y4Var.J(i6, unsafe.getInt(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 16:
                    if ((i2 & i5) != 0) {
                        y4Var.N(i6, unsafe.getLong(t, j2));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 17:
                    if ((i2 & i5) != 0) {
                        y4Var.F(i6, unsafe.getObject(t, j2), r(i10));
                    } else {
                        continue;
                    }
                    i4 = i10 + 3;
                    break;
                case 18:
                    r3.l(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 19:
                    r3.y(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 20:
                    r3.C(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 21:
                    r3.G(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 22:
                    r3.T(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 23:
                    r3.N(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 24:
                    r3.a0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 25:
                    r3.d0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 26:
                    r3.j(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var);
                    break;
                case 27:
                    r3.k(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, r(i10));
                    break;
                case 28:
                    r3.w(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var);
                    break;
                case 29:
                    r3.W(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 30:
                    r3.c0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 31:
                    r3.b0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 32:
                    r3.Q(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 33:
                    r3.Z(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 34:
                    r3.K(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, false);
                    continue;
                    i4 = i10 + 3;
                    break;
                case 35:
                    r3.l(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 36:
                    r3.y(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 37:
                    r3.C(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 38:
                    r3.G(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 39:
                    r3.T(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 40:
                    r3.N(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 41:
                    r3.a0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 42:
                    r3.d0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 43:
                    r3.W(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 44:
                    r3.c0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 45:
                    r3.b0(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 46:
                    r3.Q(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 47:
                    r3.Z(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 48:
                    r3.K(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, true);
                    break;
                case 49:
                    r3.x(this.f17157c[i10], (List) unsafe.getObject(t, j2), y4Var, r(i10));
                    break;
                case 50:
                    y(y4Var, i6, unsafe.getObject(t, j2), i10);
                    break;
                case 51:
                    if (C(t, i6, i10)) {
                        y4Var.h(i6, F(t, j2));
                    }
                    break;
                case 52:
                    if (C(t, i6, i10)) {
                        y4Var.r(i6, M(t, j2));
                    }
                    break;
                case 53:
                    if (C(t, i6, i10)) {
                        y4Var.q(i6, S(t, j2));
                    }
                    break;
                case 54:
                    if (C(t, i6, i10)) {
                        y4Var.c(i6, S(t, j2));
                    }
                    break;
                case 55:
                    if (C(t, i6, i10)) {
                        y4Var.G(i6, Q(t, j2));
                    }
                    break;
                case 56:
                    if (C(t, i6, i10)) {
                        y4Var.L(i6, S(t, j2));
                    }
                    break;
                case 57:
                    if (C(t, i6, i10)) {
                        y4Var.y(i6, Q(t, j2));
                    }
                    break;
                case 58:
                    if (C(t, i6, i10)) {
                        y4Var.B(i6, V(t, j2));
                    }
                    break;
                case 59:
                    if (C(t, i6, i10)) {
                        w(i6, unsafe.getObject(t, j2), y4Var);
                    }
                    break;
                case 60:
                    if (C(t, i6, i10)) {
                        y4Var.C(i6, unsafe.getObject(t, j2), r(i10));
                    }
                    break;
                case 61:
                    if (C(t, i6, i10)) {
                        y4Var.E(i6, (zzdu) unsafe.getObject(t, j2));
                    }
                    break;
                case 62:
                    if (C(t, i6, i10)) {
                        y4Var.M(i6, Q(t, j2));
                    }
                    break;
                case 63:
                    if (C(t, i6, i10)) {
                        y4Var.D(i6, Q(t, j2));
                    }
                    break;
                case 64:
                    if (C(t, i6, i10)) {
                        y4Var.H(i6, Q(t, j2));
                    }
                    break;
                case 65:
                    if (C(t, i6, i10)) {
                        y4Var.b(i6, S(t, j2));
                    }
                    break;
                case 66:
                    if (C(t, i6, i10)) {
                        y4Var.J(i6, Q(t, j2));
                    }
                    break;
                case 67:
                    if (C(t, i6, i10)) {
                        y4Var.N(i6, S(t, j2));
                    }
                    break;
                case 68:
                    if (C(t, i6, i10)) {
                        y4Var.F(i6, unsafe.getObject(t, j2), r(i10));
                    }
                    break;
            }
            i4 = i10 + 3;
        }
        while (entry != null) {
            this.r.g(y4Var, entry);
            entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
        }
        x(this.q, t, y4Var);
    }

    private final void L(T t, T t2, int i2) {
        int iP = P(i2);
        int i3 = this.f17157c[i2];
        long j2 = iP & 1048575;
        if (C(t2, i3, i2)) {
            Object objF = k4.F(t, j2);
            Object objF2 = k4.F(t2, j2);
            if (objF != null && objF2 != null) {
                k4.j(t, j2, zzff.e(objF, objF2));
                J(t, i3, i2);
            } else if (objF2 != null) {
                k4.j(t, j2, objF2);
                J(t, i3, i2);
            }
        }
    }

    private static <T> float M(T t, long j2) {
        return ((Float) k4.F(t, j2)).floatValue();
    }

    private final zzfk N(int i2) {
        return (zzfk) this.f17158d[((i2 / 3) << 1) + 1];
    }

    private final boolean O(T t, T t2, int i2) {
        return B(t, i2) == B(t2, i2);
    }

    private final int P(int i2) {
        return this.f17157c[i2 + 1];
    }

    private static <T> int Q(T t, long j2) {
        return ((Integer) k4.F(t, j2)).intValue();
    }

    private final int R(int i2) {
        return this.f17157c[i2 + 2];
    }

    private static <T> long S(T t, long j2) {
        return ((Long) k4.F(t, j2)).longValue();
    }

    private static zzhy T(Object obj) {
        zzfd zzfdVar = (zzfd) obj;
        zzhy zzhyVar = zzfdVar.zzb;
        if (zzhyVar != zzhy.a()) {
            return zzhyVar;
        }
        zzhy zzhyVarG = zzhy.g();
        zzfdVar.zzb = zzhyVarG;
        return zzhyVarG;
    }

    private static boolean U(int i2) {
        return (i2 & 536870912) != 0;
    }

    private static <T> boolean V(T t, long j2) {
        return ((Boolean) k4.F(t, j2)).booleanValue();
    }

    private final int W(int i2) {
        if (i2 < this.f17159e || i2 > this.f17160f) {
            return -1;
        }
        return G(i2, 0);
    }

    private final int k(int i2, int i3) {
        if (i2 < this.f17159e || i2 > this.f17160f) {
            return -1;
        }
        return G(i2, i3);
    }

    private static <UT, UB> int l(h4<UT, UB> h4Var, T t) {
        return h4Var.s(h4Var.k(t));
    }

    private final int m(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, m1 m1Var) throws IOException {
        int iK;
        Unsafe unsafe = f17156b;
        long j3 = this.f17157c[i9 + 2] & 1048575;
        switch (i8) {
            case 51:
                if (i6 != 1) {
                    return i2;
                }
                unsafe.putObject(t, j2, Double.valueOf(j1.m(bArr, i2)));
                iK = i2 + 8;
                unsafe.putInt(t, j3, i5);
                return iK;
            case 52:
                if (i6 != 5) {
                    return i2;
                }
                unsafe.putObject(t, j2, Float.valueOf(j1.o(bArr, i2)));
                iK = i2 + 4;
                unsafe.putInt(t, j3, i5);
                return iK;
            case 53:
            case 54:
                if (i6 != 0) {
                    return i2;
                }
                iK = j1.k(bArr, i2, m1Var);
                unsafe.putObject(t, j2, Long.valueOf(m1Var.f17218b));
                unsafe.putInt(t, j3, i5);
                return iK;
            case 55:
            case 62:
                if (i6 != 0) {
                    return i2;
                }
                iK = j1.i(bArr, i2, m1Var);
                unsafe.putObject(t, j2, Integer.valueOf(m1Var.a));
                unsafe.putInt(t, j3, i5);
                return iK;
            case 56:
            case 65:
                if (i6 != 1) {
                    return i2;
                }
                unsafe.putObject(t, j2, Long.valueOf(j1.l(bArr, i2)));
                iK = i2 + 8;
                unsafe.putInt(t, j3, i5);
                return iK;
            case 57:
            case 64:
                if (i6 != 5) {
                    return i2;
                }
                unsafe.putObject(t, j2, Integer.valueOf(j1.h(bArr, i2)));
                iK = i2 + 4;
                unsafe.putInt(t, j3, i5);
                return iK;
            case 58:
                if (i6 != 0) {
                    return i2;
                }
                iK = j1.k(bArr, i2, m1Var);
                unsafe.putObject(t, j2, Boolean.valueOf(m1Var.f17218b != 0));
                unsafe.putInt(t, j3, i5);
                return iK;
            case 59:
                if (i6 != 2) {
                    return i2;
                }
                int i10 = j1.i(bArr, i2, m1Var);
                int i11 = m1Var.a;
                if (i11 == 0) {
                    unsafe.putObject(t, j2, HttpUrl.FRAGMENT_ENCODE_SET);
                } else {
                    if ((i7 & 536870912) != 0 && !n4.g(bArr, i10, i10 + i11)) {
                        throw zzfo.h();
                    }
                    unsafe.putObject(t, j2, new String(bArr, i10, i11, zzff.a));
                    i10 += i11;
                }
                unsafe.putInt(t, j3, i5);
                return i10;
            case 60:
                if (i6 != 2) {
                    return i2;
                }
                int iG = j1.g(r(i9), bArr, i2, i3, m1Var);
                Object object = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                if (object == null) {
                    unsafe.putObject(t, j2, m1Var.f17219c);
                } else {
                    unsafe.putObject(t, j2, zzff.e(object, m1Var.f17219c));
                }
                unsafe.putInt(t, j3, i5);
                return iG;
            case 61:
                if (i6 != 2) {
                    return i2;
                }
                iK = j1.q(bArr, i2, m1Var);
                unsafe.putObject(t, j2, m1Var.f17219c);
                unsafe.putInt(t, j3, i5);
                return iK;
            case 63:
                if (i6 != 0) {
                    return i2;
                }
                int i12 = j1.i(bArr, i2, m1Var);
                int i13 = m1Var.a;
                zzfk zzfkVarN = N(i9);
                if (zzfkVarN != null && !zzfkVarN.d(i13)) {
                    T(t).c(i4, Long.valueOf(i13));
                    return i12;
                }
                unsafe.putObject(t, j2, Integer.valueOf(i13));
                iK = i12;
                unsafe.putInt(t, j3, i5);
                return iK;
            case 66:
                if (i6 != 0) {
                    return i2;
                }
                iK = j1.i(bArr, i2, m1Var);
                unsafe.putObject(t, j2, Integer.valueOf(zzeg.k(m1Var.a)));
                unsafe.putInt(t, j3, i5);
                return iK;
            case 67:
                if (i6 != 0) {
                    return i2;
                }
                iK = j1.k(bArr, i2, m1Var);
                unsafe.putObject(t, j2, Long.valueOf(zzeg.b(m1Var.f17218b)));
                unsafe.putInt(t, j3, i5);
                return iK;
            case 68:
                if (i6 != 3) {
                    return i2;
                }
                iK = j1.f(r(i9), bArr, i2, i3, (i4 & (-8)) | 4, m1Var);
                Object object2 = unsafe.getInt(t, j3) == i5 ? unsafe.getObject(t, j2) : null;
                if (object2 == null) {
                    unsafe.putObject(t, j2, m1Var.f17219c);
                } else {
                    unsafe.putObject(t, j2, zzff.e(object2, m1Var.f17219c));
                }
                unsafe.putInt(t, j3, i5);
                return iK;
            default:
                return i2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    private final int n(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, m1 m1Var) throws IOException {
        int i9;
        int i10 = i2;
        Unsafe unsafe = f17156b;
        zzfl zzflVarD = (zzfl) unsafe.getObject(t, j3);
        if (!zzflVarD.a()) {
            int size = zzflVarD.size();
            zzflVarD = zzflVarD.d(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j3, zzflVarD);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    b2 b2Var = (b2) zzflVarD;
                    int i11 = j1.i(bArr, i10, m1Var);
                    int i12 = m1Var.a + i11;
                    while (i11 < i12) {
                        b2Var.f(j1.m(bArr, i11));
                        i11 += 8;
                    }
                    if (i11 == i12) {
                        return i11;
                    }
                    throw zzfo.a();
                }
                if (i6 == 1) {
                    b2 b2Var2 = (b2) zzflVarD;
                    b2Var2.f(j1.m(bArr, i2));
                    while (true) {
                        int i13 = i10 + 8;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i10 = j1.i(bArr, i13, m1Var);
                        if (i4 != m1Var.a) {
                            return i13;
                        }
                        b2Var2.f(j1.m(bArr, i10));
                    }
                }
                return i10;
            case 19:
            case 36:
                if (i6 == 2) {
                    l2 l2Var = (l2) zzflVarD;
                    int i14 = j1.i(bArr, i10, m1Var);
                    int i15 = m1Var.a + i14;
                    while (i14 < i15) {
                        l2Var.f(j1.o(bArr, i14));
                        i14 += 4;
                    }
                    if (i14 == i15) {
                        return i14;
                    }
                    throw zzfo.a();
                }
                if (i6 == 5) {
                    l2 l2Var2 = (l2) zzflVarD;
                    l2Var2.f(j1.o(bArr, i2));
                    while (true) {
                        int i16 = i10 + 4;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i10 = j1.i(bArr, i16, m1Var);
                        if (i4 != m1Var.a) {
                            return i16;
                        }
                        l2Var2.f(j1.o(bArr, i10));
                    }
                }
                return i10;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    w2 w2Var = (w2) zzflVarD;
                    int i17 = j1.i(bArr, i10, m1Var);
                    int i18 = m1Var.a + i17;
                    while (i17 < i18) {
                        i17 = j1.k(bArr, i17, m1Var);
                        w2Var.G0(m1Var.f17218b);
                    }
                    if (i17 == i18) {
                        return i17;
                    }
                    throw zzfo.a();
                }
                if (i6 == 0) {
                    w2 w2Var2 = (w2) zzflVarD;
                    int iK = j1.k(bArr, i10, m1Var);
                    w2Var2.G0(m1Var.f17218b);
                    while (iK < i3) {
                        int i19 = j1.i(bArr, iK, m1Var);
                        if (i4 != m1Var.a) {
                            return iK;
                        }
                        iK = j1.k(bArr, i19, m1Var);
                        w2Var2.G0(m1Var.f17218b);
                    }
                    return iK;
                }
                return i10;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return j1.j(bArr, i10, zzflVarD, m1Var);
                }
                if (i6 == 0) {
                    return j1.b(i4, bArr, i2, i3, zzflVarD, m1Var);
                }
                return i10;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    w2 w2Var3 = (w2) zzflVarD;
                    int i20 = j1.i(bArr, i10, m1Var);
                    int i21 = m1Var.a + i20;
                    while (i20 < i21) {
                        w2Var3.G0(j1.l(bArr, i20));
                        i20 += 8;
                    }
                    if (i20 == i21) {
                        return i20;
                    }
                    throw zzfo.a();
                }
                if (i6 == 1) {
                    w2 w2Var4 = (w2) zzflVarD;
                    w2Var4.G0(j1.l(bArr, i2));
                    while (true) {
                        int i22 = i10 + 8;
                        if (i22 >= i3) {
                            return i22;
                        }
                        i10 = j1.i(bArr, i22, m1Var);
                        if (i4 != m1Var.a) {
                            return i22;
                        }
                        w2Var4.G0(j1.l(bArr, i10));
                    }
                }
                return i10;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    n2 n2Var = (n2) zzflVarD;
                    int i23 = j1.i(bArr, i10, m1Var);
                    int i24 = m1Var.a + i23;
                    while (i23 < i24) {
                        n2Var.h(j1.h(bArr, i23));
                        i23 += 4;
                    }
                    if (i23 == i24) {
                        return i23;
                    }
                    throw zzfo.a();
                }
                if (i6 == 5) {
                    n2 n2Var2 = (n2) zzflVarD;
                    n2Var2.h(j1.h(bArr, i2));
                    while (true) {
                        int i25 = i10 + 4;
                        if (i25 >= i3) {
                            return i25;
                        }
                        i10 = j1.i(bArr, i25, m1Var);
                        if (i4 != m1Var.a) {
                            return i25;
                        }
                        n2Var2.h(j1.h(bArr, i10));
                    }
                }
                return i10;
            case 25:
            case 42:
                if (i6 == 2) {
                    l1 l1Var = (l1) zzflVarD;
                    i9 = j1.i(bArr, i10, m1Var);
                    int i26 = m1Var.a + i9;
                    while (i9 < i26) {
                        i9 = j1.k(bArr, i9, m1Var);
                        l1Var.f(m1Var.f17218b != 0);
                    }
                    if (i9 != i26) {
                        throw zzfo.a();
                    }
                    return i9;
                }
                if (i6 == 0) {
                    l1 l1Var2 = (l1) zzflVarD;
                    i10 = j1.k(bArr, i10, m1Var);
                    l1Var2.f(m1Var.f17218b != 0);
                    while (i10 < i3) {
                        int i27 = j1.i(bArr, i10, m1Var);
                        if (i4 == m1Var.a) {
                            i10 = j1.k(bArr, i27, m1Var);
                            l1Var2.f(m1Var.f17218b != 0);
                        }
                    }
                }
                return i10;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        i10 = j1.i(bArr, i10, m1Var);
                        int i28 = m1Var.a;
                        if (i28 < 0) {
                            throw zzfo.b();
                        }
                        if (i28 == 0) {
                            zzflVarD.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            zzflVarD.add(new String(bArr, i10, i28, zzff.a));
                            i10 += i28;
                        }
                        while (i10 < i3) {
                            int i29 = j1.i(bArr, i10, m1Var);
                            if (i4 == m1Var.a) {
                                i10 = j1.i(bArr, i29, m1Var);
                                int i30 = m1Var.a;
                                if (i30 < 0) {
                                    throw zzfo.b();
                                }
                                if (i30 == 0) {
                                    zzflVarD.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    zzflVarD.add(new String(bArr, i10, i30, zzff.a));
                                    i10 += i30;
                                }
                            }
                        }
                    } else {
                        i10 = j1.i(bArr, i10, m1Var);
                        int i31 = m1Var.a;
                        if (i31 < 0) {
                            throw zzfo.b();
                        }
                        if (i31 == 0) {
                            zzflVarD.add(HttpUrl.FRAGMENT_ENCODE_SET);
                        } else {
                            int i32 = i10 + i31;
                            if (!n4.g(bArr, i10, i32)) {
                                throw zzfo.h();
                            }
                            zzflVarD.add(new String(bArr, i10, i31, zzff.a));
                            i10 = i32;
                        }
                        while (i10 < i3) {
                            int i33 = j1.i(bArr, i10, m1Var);
                            if (i4 == m1Var.a) {
                                i10 = j1.i(bArr, i33, m1Var);
                                int i34 = m1Var.a;
                                if (i34 < 0) {
                                    throw zzfo.b();
                                }
                                if (i34 == 0) {
                                    zzflVarD.add(HttpUrl.FRAGMENT_ENCODE_SET);
                                } else {
                                    int i35 = i10 + i34;
                                    if (!n4.g(bArr, i10, i35)) {
                                        throw zzfo.h();
                                    }
                                    zzflVarD.add(new String(bArr, i10, i34, zzff.a));
                                    i10 = i35;
                                }
                            }
                        }
                    }
                }
                return i10;
            case 27:
                if (i6 == 2) {
                    return j1.e(r(i7), i4, bArr, i2, i3, zzflVarD, m1Var);
                }
                return i10;
            case 28:
                if (i6 == 2) {
                    int i36 = j1.i(bArr, i10, m1Var);
                    int i37 = m1Var.a;
                    if (i37 < 0) {
                        throw zzfo.b();
                    }
                    if (i37 > bArr.length - i36) {
                        throw zzfo.a();
                    }
                    if (i37 == 0) {
                        zzflVarD.add(zzdu.f17368f);
                    } else {
                        zzflVarD.add(zzdu.q(bArr, i36, i37));
                        i36 += i37;
                    }
                    while (i36 < i3) {
                        int i38 = j1.i(bArr, i36, m1Var);
                        if (i4 != m1Var.a) {
                            return i36;
                        }
                        i36 = j1.i(bArr, i38, m1Var);
                        int i39 = m1Var.a;
                        if (i39 < 0) {
                            throw zzfo.b();
                        }
                        if (i39 > bArr.length - i36) {
                            throw zzfo.a();
                        }
                        if (i39 == 0) {
                            zzflVarD.add(zzdu.f17368f);
                        } else {
                            zzflVarD.add(zzdu.q(bArr, i36, i39));
                            i36 += i39;
                        }
                    }
                    return i36;
                }
                return i10;
            case 30:
            case 44:
                if (i6 != 2) {
                    if (i6 == 0) {
                        i9 = j1.b(i4, bArr, i2, i3, zzflVarD, m1Var);
                    }
                    return i10;
                }
                i9 = j1.j(bArr, i10, zzflVarD, m1Var);
                zzfd zzfdVar = (zzfd) t;
                zzhy zzhyVar = zzfdVar.zzb;
                if (zzhyVar == zzhy.a()) {
                    zzhyVar = null;
                }
                zzhy zzhyVar2 = (zzhy) r3.i(i5, zzflVarD, N(i7), zzhyVar, this.q);
                if (zzhyVar2 != null) {
                    zzfdVar.zzb = zzhyVar2;
                }
                return i9;
            case 33:
            case 47:
                if (i6 == 2) {
                    n2 n2Var3 = (n2) zzflVarD;
                    int i40 = j1.i(bArr, i10, m1Var);
                    int i41 = m1Var.a + i40;
                    while (i40 < i41) {
                        i40 = j1.i(bArr, i40, m1Var);
                        n2Var3.h(zzeg.k(m1Var.a));
                    }
                    if (i40 == i41) {
                        return i40;
                    }
                    throw zzfo.a();
                }
                if (i6 == 0) {
                    n2 n2Var4 = (n2) zzflVarD;
                    int i42 = j1.i(bArr, i10, m1Var);
                    n2Var4.h(zzeg.k(m1Var.a));
                    while (i42 < i3) {
                        int i43 = j1.i(bArr, i42, m1Var);
                        if (i4 != m1Var.a) {
                            return i42;
                        }
                        i42 = j1.i(bArr, i43, m1Var);
                        n2Var4.h(zzeg.k(m1Var.a));
                    }
                    return i42;
                }
                return i10;
            case 34:
            case 48:
                if (i6 == 2) {
                    w2 w2Var5 = (w2) zzflVarD;
                    int i44 = j1.i(bArr, i10, m1Var);
                    int i45 = m1Var.a + i44;
                    while (i44 < i45) {
                        i44 = j1.k(bArr, i44, m1Var);
                        w2Var5.G0(zzeg.b(m1Var.f17218b));
                    }
                    if (i44 == i45) {
                        return i44;
                    }
                    throw zzfo.a();
                }
                if (i6 == 0) {
                    w2 w2Var6 = (w2) zzflVarD;
                    int iK2 = j1.k(bArr, i10, m1Var);
                    w2Var6.G0(zzeg.b(m1Var.f17218b));
                    while (iK2 < i3) {
                        int i46 = j1.i(bArr, iK2, m1Var);
                        if (i4 != m1Var.a) {
                            return iK2;
                        }
                        iK2 = j1.k(bArr, i46, m1Var);
                        w2Var6.G0(zzeg.b(m1Var.f17218b));
                    }
                    return iK2;
                }
                return i10;
            case 49:
                if (i6 == 3) {
                    p3 p3VarR = r(i7);
                    int i47 = (i4 & (-8)) | 4;
                    i10 = j1.f(p3VarR, bArr, i2, i3, i47, m1Var);
                    zzflVarD.add(m1Var.f17219c);
                    while (i10 < i3) {
                        int i48 = j1.i(bArr, i10, m1Var);
                        if (i4 == m1Var.a) {
                            i10 = j1.f(p3VarR, bArr, i48, i3, i47, m1Var);
                            zzflVarD.add(m1Var.f17219c);
                        }
                    }
                }
                return i10;
            default:
                return i10;
        }
    }

    private final <K, V> int o(T t, byte[] bArr, int i2, int i3, int i4, long j2, m1 m1Var) throws IOException {
        Unsafe unsafe = f17156b;
        Object objH = H(i4);
        Object object = unsafe.getObject(t, j2);
        if (this.s.f(object)) {
            Object objD = this.s.d(objH);
            this.s.g(objD, object);
            unsafe.putObject(t, j2, objD);
            object = objD;
        }
        this.s.zzf(objH);
        this.s.c(object);
        int i5 = j1.i(bArr, i2, m1Var);
        int i6 = m1Var.a;
        if (i6 < 0 || i6 > i3 - i5) {
            throw zzfo.a();
        }
        throw null;
    }

    static <T> g3<T> q(Class<T> cls, e3 e3Var, j3 j3Var, s2 s2Var, h4<?, ?> h4Var, d2<?> d2Var, a3 a3Var) {
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
        n3 n3Var;
        int i19;
        int i20;
        int iObjectFieldOffset;
        String str;
        int iObjectFieldOffset2;
        int i21;
        Field fieldU;
        int i22;
        char cCharAt9;
        int i23;
        Field fieldU2;
        Field fieldU3;
        int i24;
        char cCharAt10;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        char cCharAt14;
        if (!(e3Var instanceof n3)) {
            ((e4) e3Var).a();
            int i28 = zzfd.zze.f17405j;
            throw new NoSuchMethodError();
        }
        n3 n3Var2 = (n3) e3Var;
        int i29 = 0;
        boolean z2 = n3Var2.a() == zzfd.zze.f17405j;
        String strD = n3Var2.d();
        int length = strD.length();
        int iCharAt3 = strD.charAt(0);
        if (iCharAt3 >= 55296) {
            int i30 = iCharAt3 & 8191;
            int i31 = 1;
            int i32 = 13;
            while (true) {
                i2 = i31 + 1;
                cCharAt14 = strD.charAt(i31);
                if (cCharAt14 < 55296) {
                    break;
                }
                i30 |= (cCharAt14 & 8191) << i32;
                i32 += 13;
                i31 = i2;
            }
            iCharAt3 = i30 | (cCharAt14 << i32);
        } else {
            i2 = 1;
        }
        int i33 = i2 + 1;
        int iCharAt4 = strD.charAt(i2);
        if (iCharAt4 >= 55296) {
            int i34 = iCharAt4 & 8191;
            int i35 = 13;
            while (true) {
                i27 = i33 + 1;
                cCharAt13 = strD.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i27;
            }
            iCharAt4 = i34 | (cCharAt13 << i35);
            i33 = i27;
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
            int i36 = i33 + 1;
            int iCharAt5 = strD.charAt(i33);
            if (iCharAt5 >= 55296) {
                int i37 = iCharAt5 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = strD.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt5 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt6 = strD.charAt(i36);
            if (iCharAt6 >= 55296) {
                int i40 = iCharAt6 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strD.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt6 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            iCharAt = strD.charAt(i39);
            if (iCharAt >= 55296) {
                int i43 = iCharAt & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strD.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt7 = strD.charAt(i42);
            if (iCharAt7 >= 55296) {
                int i46 = iCharAt7 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strD.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt7 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt2 = strD.charAt(i45);
            if (iCharAt2 >= 55296) {
                int i49 = iCharAt2 & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strD.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt2 = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt8 = strD.charAt(i48);
            if (iCharAt8 >= 55296) {
                int i52 = iCharAt8 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strD.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt8 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt9 = strD.charAt(i51);
            if (iCharAt9 >= 55296) {
                int i55 = iCharAt9 & 8191;
                int i56 = i54;
                int i57 = 13;
                while (true) {
                    i9 = i56 + 1;
                    cCharAt2 = strD.charAt(i56);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i56 = i9;
                }
                iCharAt9 = i55 | (cCharAt2 << i57);
                i3 = i9;
            } else {
                i3 = i54;
            }
            int i58 = i3 + 1;
            int iCharAt10 = strD.charAt(i3);
            if (iCharAt10 >= 55296) {
                int i59 = iCharAt10 & 8191;
                int i60 = i58;
                int i61 = 13;
                while (true) {
                    i8 = i60 + 1;
                    cCharAt = strD.charAt(i60);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i61;
                    i61 += 13;
                    i60 = i8;
                }
                iCharAt10 = i59 | (cCharAt << i61);
                i58 = i8;
            }
            int[] iArr2 = new int[iCharAt10 + iCharAt8 + iCharAt9];
            int i62 = (iCharAt5 << 1) + iCharAt6;
            i4 = iCharAt7;
            i5 = i62;
            i6 = iCharAt10;
            i29 = iCharAt5;
            i33 = i58;
            int i63 = iCharAt8;
            iArr = iArr2;
            i7 = i63;
        }
        Unsafe unsafe = f17156b;
        Object[] objArrE = n3Var2.e();
        Class<?> cls2 = n3Var2.c().getClass();
        int i64 = i33;
        int[] iArr3 = new int[iCharAt2 * 3];
        Object[] objArr = new Object[iCharAt2 << 1];
        int i65 = i6 + i7;
        int i66 = i6;
        int i67 = i64;
        int i68 = i65;
        int i69 = 0;
        int i70 = 0;
        while (i67 < length) {
            int i71 = i67 + 1;
            int iCharAt11 = strD.charAt(i67);
            int i72 = length;
            if (iCharAt11 >= 55296) {
                int i73 = iCharAt11 & 8191;
                int i74 = i71;
                int i75 = 13;
                while (true) {
                    i26 = i74 + 1;
                    cCharAt12 = strD.charAt(i74);
                    i16 = i6;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i73 |= (cCharAt12 & 8191) << i75;
                    i75 += 13;
                    i74 = i26;
                    i6 = i16;
                }
                iCharAt11 = i73 | (cCharAt12 << i75);
                i17 = i26;
            } else {
                i16 = i6;
                i17 = i71;
            }
            int i76 = i17 + 1;
            int iCharAt12 = strD.charAt(i17);
            if (iCharAt12 >= 55296) {
                int i77 = iCharAt12 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i25 = i78 + 1;
                    cCharAt11 = strD.charAt(i78);
                    z = z2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i77 |= (cCharAt11 & 8191) << i79;
                    i79 += 13;
                    i78 = i25;
                    z2 = z;
                }
                iCharAt12 = i77 | (cCharAt11 << i79);
                i18 = i25;
            } else {
                z = z2;
                i18 = i76;
            }
            int i80 = iCharAt12 & 255;
            int i81 = i4;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i69] = i70;
                i69++;
            }
            int i82 = iCharAt;
            if (i80 >= 51) {
                int i83 = i18 + 1;
                int iCharAt13 = strD.charAt(i18);
                char c2 = 55296;
                if (iCharAt13 >= 55296) {
                    int i84 = iCharAt13 & 8191;
                    int i85 = 13;
                    while (true) {
                        i24 = i83 + 1;
                        cCharAt10 = strD.charAt(i83);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i84 |= (cCharAt10 & 8191) << i85;
                        i85 += 13;
                        i83 = i24;
                        c2 = 55296;
                    }
                    iCharAt13 = i84 | (cCharAt10 << i85);
                    i83 = i24;
                }
                int i86 = i80 - 51;
                int i87 = i83;
                if (i86 == 9 || i86 == 17) {
                    objArr[((i70 / 3) << 1) + 1] = objArrE[i5];
                    i5++;
                } else if (i86 == 12 && (iCharAt3 & 1) == 1) {
                    objArr[((i70 / 3) << 1) + 1] = objArrE[i5];
                    i5++;
                }
                int i88 = iCharAt13 << 1;
                Object obj = objArrE[i88];
                if (obj instanceof Field) {
                    fieldU2 = (Field) obj;
                } else {
                    fieldU2 = u(cls2, (String) obj);
                    objArrE[i88] = fieldU2;
                }
                n3Var = n3Var2;
                String str2 = strD;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldU2);
                int i89 = i88 + 1;
                Object obj2 = objArrE[i89];
                if (obj2 instanceof Field) {
                    fieldU3 = (Field) obj2;
                } else {
                    fieldU3 = u(cls2, (String) obj2);
                    objArrE[i89] = fieldU3;
                }
                cls2 = cls2;
                i19 = i5;
                i18 = i87;
                str = str2;
                i21 = 0;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldU3);
                i29 = i29;
            } else {
                n3Var = n3Var2;
                String str3 = strD;
                i19 = i5 + 1;
                Field fieldU4 = u(cls2, (String) objArrE[i5]);
                if (i80 == 9 || i80 == 17) {
                    i20 = 1;
                    objArr[((i70 / 3) << 1) + 1] = fieldU4.getType();
                } else {
                    if (i80 == 27 || i80 == 49) {
                        i20 = 1;
                        i23 = i19 + 1;
                        objArr[((i70 / 3) << 1) + 1] = objArrE[i19];
                    } else if (i80 == 12 || i80 == 30 || i80 == 44) {
                        i20 = 1;
                        if ((iCharAt3 & 1) == 1) {
                            i23 = i19 + 1;
                            objArr[((i70 / 3) << 1) + 1] = objArrE[i19];
                        }
                    } else if (i80 == 50) {
                        int i90 = i66 + 1;
                        iArr[i66] = i70;
                        int i91 = (i70 / 3) << 1;
                        int i92 = i19 + 1;
                        objArr[i91] = objArrE[i19];
                        if ((iCharAt12 & RecyclerView.l.FLAG_MOVED) != 0) {
                            i19 = i92 + 1;
                            objArr[i91 + 1] = objArrE[i92];
                            i66 = i90;
                            i20 = 1;
                        } else {
                            i19 = i92;
                            i20 = 1;
                            i66 = i90;
                        }
                    } else {
                        i20 = 1;
                    }
                    i19 = i23;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldU4);
                if ((iCharAt3 & 1) != i20 || i80 > 17) {
                    str = str3;
                    iObjectFieldOffset2 = 0;
                    i21 = 0;
                } else {
                    int i93 = i18 + 1;
                    str = str3;
                    int iCharAt14 = str.charAt(i18);
                    if (iCharAt14 >= 55296) {
                        int i94 = iCharAt14 & 8191;
                        int i95 = 13;
                        while (true) {
                            i22 = i93 + 1;
                            cCharAt9 = str.charAt(i93);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i94 |= (cCharAt9 & 8191) << i95;
                            i95 += 13;
                            i93 = i22;
                        }
                        iCharAt14 = i94 | (cCharAt9 << i95);
                        i93 = i22;
                    }
                    int i96 = (i29 << 1) + (iCharAt14 / 32);
                    Object obj3 = objArrE[i96];
                    if (obj3 instanceof Field) {
                        fieldU = (Field) obj3;
                    } else {
                        fieldU = u(cls2, (String) obj3);
                        objArrE[i96] = fieldU;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldU);
                    i21 = iCharAt14 % 32;
                    i18 = i93;
                }
                if (i80 >= 18 && i80 <= 49) {
                    iArr[i68] = iObjectFieldOffset;
                    i68++;
                }
            }
            int i97 = i70 + 1;
            iArr3[i70] = iCharAt11;
            int i98 = i97 + 1;
            iArr3[i97] = iObjectFieldOffset | ((iCharAt12 & 256) != 0 ? 268435456 : 0) | ((iCharAt12 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 536870912 : 0) | (i80 << 20);
            i70 = i98 + 1;
            iArr3[i98] = (i21 << 20) | iObjectFieldOffset2;
            i29 = i29;
            strD = str;
            i67 = i18;
            cls2 = cls2;
            i4 = i81;
            length = i72;
            i6 = i16;
            z2 = z;
            iCharAt = i82;
            i5 = i19;
            n3Var2 = n3Var;
        }
        return new g3<>(iArr3, objArr, iCharAt, i4, n3Var2.c(), z2, false, iArr, i6, i65, j3Var, s2Var, h4Var, d2Var, a3Var);
    }

    private final p3 r(int i2) {
        int i3 = (i2 / 3) << 1;
        p3 p3Var = (p3) this.f17158d[i3];
        if (p3Var != null) {
            return p3Var;
        }
        p3<T> p3VarB = l3.a().b((Class) this.f17158d[i3 + 1]);
        this.f17158d[i3] = p3VarB;
        return p3VarB;
    }

    private final <K, V, UT, UB> UB s(int i2, int i3, Map<K, V> map, zzfk zzfkVar, UB ub, h4<UT, UB> h4Var) {
        z2<?, ?> z2VarZzf = this.s.zzf(H(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfkVar.d(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = h4Var.a();
                }
                t1 t1VarX = zzdu.x(zzgg.a(z2VarZzf, next.getKey(), next.getValue()));
                try {
                    zzgg.b(t1VarX.b(), z2VarZzf, next.getKey(), next.getValue());
                    h4Var.e(ub, i3, t1VarX.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB t(Object obj, int i2, UB ub, h4<UT, UB> h4Var) {
        zzfk zzfkVarN;
        int i3 = this.f17157c[i2];
        Object objF = k4.F(obj, P(i2) & 1048575);
        return (objF == null || (zzfkVarN = N(i2)) == null) ? ub : (UB) s(i2, i3, this.s.c(objF), zzfkVarN, ub, h4Var);
    }

    private static Field u(Class<?> cls, String str) {
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

    private static List<?> v(Object obj, long j2) {
        return (List) k4.F(obj, j2);
    }

    private static void w(int i2, Object obj, y4 y4Var) throws IOException {
        if (obj instanceof String) {
            y4Var.g(i2, (String) obj);
        } else {
            y4Var.E(i2, (zzdu) obj);
        }
    }

    private static <UT, UB> void x(h4<UT, UB> h4Var, T t, y4 y4Var) throws IOException {
        h4Var.g(h4Var.k(t), y4Var);
    }

    private final <K, V> void y(y4 y4Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            y4Var.O(i2, this.s.zzf(H(i3)), this.s.b(obj));
        }
    }

    private final void z(Object obj, int i2, q3 q3Var) throws IOException {
        if (U(i2)) {
            k4.j(obj, i2 & 1048575, q3Var.j());
        } else if (this.f17163i) {
            k4.j(obj, i2 & 1048575, q3Var.w());
        } else {
            k4.j(obj, i2 & 1048575, q3Var.f());
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final T a() {
        return (T) this.o.c(this.f17161g);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:421:0x090b A[PHI: r6
      0x090b: PHI (r6v4 int) = 
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
      (r6v16 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v17 int)
      (r6v1 int)
     binds: [B:256:0x0545, B:459:0x09b0, B:453:0x0994, B:450:0x0982, B:447:0x0973, B:444:0x0966, B:441:0x0959, B:437:0x094e, B:434:0x0943, B:431:0x0936, B:428:0x0929, B:425:0x0916, B:396:0x081f, B:390:0x0802, B:384:0x07e5, B:378:0x07c8, B:372:0x07aa, B:366:0x078c, B:360:0x076e, B:354:0x0750, B:348:0x0732, B:342:0x0714, B:336:0x06f6, B:330:0x06d8, B:324:0x06ba, B:318:0x069c, B:313:0x0668, B:310:0x065b, B:307:0x064b, B:304:0x063b, B:301:0x062b, B:298:0x061d, B:295:0x0610, B:292:0x0603, B:286:0x05e5, B:283:0x05d1, B:280:0x05bf, B:277:0x05af, B:274:0x059f, B:439:0x0955, B:271:0x0592, B:268:0x0584, B:265:0x0574, B:262:0x0564, B:420:0x090a, B:259:0x054e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.p3
    public final int b(T t) {
        int i2;
        int i3;
        long j2;
        int iB0;
        int iT;
        int iA0;
        int iR;
        int iV;
        int iG0;
        int iO0;
        int iB;
        int iV2;
        int iG1;
        int iO1;
        int i4 = 267386880;
        int i5 = 1;
        if (!this.f17164j) {
            Unsafe unsafe = f17156b;
            int i6 = -1;
            int i7 = 0;
            int iB2 = 0;
            int i8 = 0;
            while (i7 < this.f17157c.length) {
                int iP = P(i7);
                int[] iArr = this.f17157c;
                int i9 = iArr[i7];
                int i10 = (iP & 267386880) >>> 20;
                if (i10 <= 17) {
                    int i11 = iArr[i7 + 2];
                    int i12 = i11 & 1048575;
                    i3 = i5 << (i11 >>> 20);
                    if (i12 != i6) {
                        i8 = unsafe.getInt(t, i12);
                        i6 = i12;
                    }
                    i2 = i11;
                } else {
                    i2 = (!this.f17165k || i10 < zzex.O.a() || i10 > zzex.b0.a()) ? 0 : this.f17157c[i7 + 2] & 1048575;
                    i3 = 0;
                }
                long j3 = iP & 1048575;
                switch (i10) {
                    case 0:
                        j2 = 0;
                        if ((i8 & i3) != 0) {
                            iB2 += zzen.B(i9, 0.0d);
                        }
                        break;
                    case 1:
                        j2 = 0;
                        if ((i8 & i3) != 0) {
                            iB2 += zzen.C(i9, 0.0f);
                        }
                        break;
                    case 2:
                        j2 = 0;
                        if ((i8 & i3) != 0) {
                            iB0 = zzen.b0(i9, unsafe.getLong(t, j3));
                            iB2 += iB0;
                        }
                        break;
                    case 3:
                        j2 = 0;
                        if ((i8 & i3) != 0) {
                            iB0 = zzen.h0(i9, unsafe.getLong(t, j3));
                            iB2 += iB0;
                        }
                        break;
                    case 4:
                        j2 = 0;
                        if ((i8 & i3) != 0) {
                            iB0 = zzen.l0(i9, unsafe.getInt(t, j3));
                            iB2 += iB0;
                        }
                        break;
                    case 5:
                        j2 = 0;
                        if ((i8 & i3) != 0) {
                            iB0 = zzen.q0(i9, 0L);
                            iB2 += iB0;
                        }
                        break;
                    case 6:
                        if ((i8 & i3) != 0) {
                            iB2 += zzen.x0(i9, 0);
                        }
                        j2 = 0;
                        break;
                    case 7:
                        if ((i8 & i3) != 0) {
                            iB2 += zzen.H(i9, true);
                        }
                        j2 = 0;
                        break;
                    case 8:
                        if ((i8 & i3) != 0) {
                            Object object = unsafe.getObject(t, j3);
                            iT = object instanceof zzdu ? zzen.T(i9, (zzdu) object) : zzen.G(i9, (String) object);
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 9:
                        if ((i8 & i3) != 0) {
                            iT = r3.a(i9, unsafe.getObject(t, j3), r(i7));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 10:
                        if ((i8 & i3) != 0) {
                            iT = zzen.T(i9, (zzdu) unsafe.getObject(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 11:
                        if ((i8 & i3) != 0) {
                            iT = zzen.p0(i9, unsafe.getInt(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 12:
                        if ((i8 & i3) != 0) {
                            iT = zzen.C0(i9, unsafe.getInt(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 13:
                        if ((i8 & i3) != 0) {
                            iA0 = zzen.A0(i9, 0);
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 14:
                        if ((i8 & i3) != 0) {
                            iT = zzen.u0(i9, 0L);
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 15:
                        if ((i8 & i3) != 0) {
                            iT = zzen.t0(i9, unsafe.getInt(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 16:
                        if ((i8 & i3) != 0) {
                            iT = zzen.m0(i9, unsafe.getLong(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 17:
                        if ((i8 & i3) != 0) {
                            iT = zzen.U(i9, (zzgo) unsafe.getObject(t, j3), r(i7));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 18:
                        iT = r3.U(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 19:
                        iR = r3.R(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 20:
                        iR = r3.d(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 21:
                        iR = r3.t(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 22:
                        iR = r3.H(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 23:
                        iR = r3.U(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 24:
                        iR = r3.R(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 25:
                        iR = r3.X(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 26:
                        iT = r3.b(i9, (List) unsafe.getObject(t, j3));
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 27:
                        iT = r3.c(i9, (List) unsafe.getObject(t, j3), r(i7));
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 28:
                        iT = r3.r(i9, (List) unsafe.getObject(t, j3));
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 29:
                        iT = r3.L(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 30:
                        iR = r3.D(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 31:
                        iR = r3.R(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 32:
                        iR = r3.U(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 33:
                        iR = r3.O(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 34:
                        iR = r3.z(i9, (List) unsafe.getObject(t, j3), false);
                        iB2 += iR;
                        j2 = 0;
                        break;
                    case 35:
                        iV = r3.V((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 36:
                        iV = r3.S((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 37:
                        iV = r3.e((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 38:
                        iV = r3.u((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 39:
                        iV = r3.I((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 40:
                        iV = r3.V((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 41:
                        iV = r3.S((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 42:
                        iV = r3.Y((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 43:
                        iV = r3.M((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 44:
                        iV = r3.E((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 45:
                        iV = r3.S((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 46:
                        iV = r3.V((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 47:
                        iV = r3.P((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 48:
                        iV = r3.A((List) unsafe.getObject(t, j3));
                        if (iV > 0) {
                            if (this.f17165k) {
                                unsafe.putInt(t, i2, iV);
                            }
                            iG0 = zzen.g0(i9);
                            iO0 = zzen.o0(iV);
                            iA0 = iG0 + iO0 + iV;
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 49:
                        iT = r3.s(i9, (List) unsafe.getObject(t, j3), r(i7));
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 50:
                        iT = this.s.h(i9, unsafe.getObject(t, j3), H(i7));
                        iB2 += iT;
                        j2 = 0;
                        break;
                    case 51:
                        if (C(t, i9, i7)) {
                            iT = zzen.B(i9, 0.0d);
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 52:
                        if (C(t, i9, i7)) {
                            iA0 = zzen.C(i9, 0.0f);
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 53:
                        if (C(t, i9, i7)) {
                            iT = zzen.b0(i9, S(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 54:
                        if (C(t, i9, i7)) {
                            iT = zzen.h0(i9, S(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 55:
                        if (C(t, i9, i7)) {
                            iT = zzen.l0(i9, Q(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 56:
                        if (C(t, i9, i7)) {
                            iT = zzen.q0(i9, 0L);
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 57:
                        if (C(t, i9, i7)) {
                            iA0 = zzen.x0(i9, 0);
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 58:
                        if (C(t, i9, i7)) {
                            iA0 = zzen.H(i9, true);
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 59:
                        if (C(t, i9, i7)) {
                            Object object2 = unsafe.getObject(t, j3);
                            iT = object2 instanceof zzdu ? zzen.T(i9, (zzdu) object2) : zzen.G(i9, (String) object2);
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 60:
                        if (C(t, i9, i7)) {
                            iT = r3.a(i9, unsafe.getObject(t, j3), r(i7));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 61:
                        if (C(t, i9, i7)) {
                            iT = zzen.T(i9, (zzdu) unsafe.getObject(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 62:
                        if (C(t, i9, i7)) {
                            iT = zzen.p0(i9, Q(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 63:
                        if (C(t, i9, i7)) {
                            iT = zzen.C0(i9, Q(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 64:
                        if (C(t, i9, i7)) {
                            iA0 = zzen.A0(i9, 0);
                            iB2 += iA0;
                        }
                        j2 = 0;
                        break;
                    case 65:
                        if (C(t, i9, i7)) {
                            iT = zzen.u0(i9, 0L);
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 66:
                        if (C(t, i9, i7)) {
                            iT = zzen.t0(i9, Q(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 67:
                        if (C(t, i9, i7)) {
                            iT = zzen.m0(i9, S(t, j3));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    case 68:
                        if (C(t, i9, i7)) {
                            iT = zzen.U(i9, (zzgo) unsafe.getObject(t, j3), r(i7));
                            iB2 += iT;
                        }
                        j2 = 0;
                        break;
                    default:
                        j2 = 0;
                        break;
                }
                i7 += 3;
                i5 = 1;
            }
            int iA = 0;
            int iL = iB2 + l(this.q, t);
            if (!this.f17162h) {
                return iL;
            }
            h2<T> h2VarB = this.r.b(t);
            for (int i13 = 0; i13 < h2VarB.f17168b.k(); i13++) {
                Map.Entry entryI = h2VarB.f17168b.i(i13);
                iA += h2.a((zzey) entryI.getKey(), entryI.getValue());
            }
            for (Map.Entry entry : h2VarB.f17168b.n()) {
                iA += h2.a((zzey) entry.getKey(), entry.getValue());
            }
            return iL + iA;
        }
        Unsafe unsafe2 = f17156b;
        int i14 = 0;
        int i15 = 0;
        while (i14 < this.f17157c.length) {
            int iP2 = P(i14);
            int i16 = (iP2 & i4) >>> 20;
            int i17 = this.f17157c[i14];
            long j4 = iP2 & 1048575;
            int i18 = (i16 < zzex.O.a() || i16 > zzex.b0.a()) ? 0 : this.f17157c[i14 + 2] & 1048575;
            switch (i16) {
                case 0:
                    if (B(t, i14)) {
                        iB = zzen.B(i17, 0.0d);
                        i15 += iB;
                    }
                    break;
                case 1:
                    if (B(t, i14)) {
                        iB = zzen.C(i17, 0.0f);
                        i15 += iB;
                    }
                    break;
                case 2:
                    if (B(t, i14)) {
                        iB = zzen.b0(i17, k4.o(t, j4));
                        i15 += iB;
                    }
                    break;
                case 3:
                    if (B(t, i14)) {
                        iB = zzen.h0(i17, k4.o(t, j4));
                        i15 += iB;
                    }
                    break;
                case 4:
                    if (B(t, i14)) {
                        iB = zzen.l0(i17, k4.b(t, j4));
                        i15 += iB;
                    }
                    break;
                case 5:
                    if (B(t, i14)) {
                        iB = zzen.q0(i17, 0L);
                        i15 += iB;
                    }
                    break;
                case 6:
                    if (B(t, i14)) {
                        iB = zzen.x0(i17, 0);
                        i15 += iB;
                    }
                    break;
                case 7:
                    if (B(t, i14)) {
                        iB = zzen.H(i17, true);
                        i15 += iB;
                    }
                    break;
                case 8:
                    if (B(t, i14)) {
                        Object objF = k4.F(t, j4);
                        iB = objF instanceof zzdu ? zzen.T(i17, (zzdu) objF) : zzen.G(i17, (String) objF);
                        i15 += iB;
                    }
                    break;
                case 9:
                    if (B(t, i14)) {
                        iB = r3.a(i17, k4.F(t, j4), r(i14));
                        i15 += iB;
                    }
                    break;
                case 10:
                    if (B(t, i14)) {
                        iB = zzen.T(i17, (zzdu) k4.F(t, j4));
                        i15 += iB;
                    }
                    break;
                case 11:
                    if (B(t, i14)) {
                        iB = zzen.p0(i17, k4.b(t, j4));
                        i15 += iB;
                    }
                    break;
                case 12:
                    if (B(t, i14)) {
                        iB = zzen.C0(i17, k4.b(t, j4));
                        i15 += iB;
                    }
                    break;
                case 13:
                    if (B(t, i14)) {
                        iB = zzen.A0(i17, 0);
                        i15 += iB;
                    }
                    break;
                case 14:
                    if (B(t, i14)) {
                        iB = zzen.u0(i17, 0L);
                        i15 += iB;
                    }
                    break;
                case 15:
                    if (B(t, i14)) {
                        iB = zzen.t0(i17, k4.b(t, j4));
                        i15 += iB;
                    }
                    break;
                case 16:
                    if (B(t, i14)) {
                        iB = zzen.m0(i17, k4.o(t, j4));
                        i15 += iB;
                    }
                    break;
                case 17:
                    if (B(t, i14)) {
                        iB = zzen.U(i17, (zzgo) k4.F(t, j4), r(i14));
                        i15 += iB;
                    }
                    break;
                case 18:
                    iB = r3.U(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 19:
                    iB = r3.R(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 20:
                    iB = r3.d(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 21:
                    iB = r3.t(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 22:
                    iB = r3.H(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 23:
                    iB = r3.U(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 24:
                    iB = r3.R(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 25:
                    iB = r3.X(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 26:
                    iB = r3.b(i17, v(t, j4));
                    i15 += iB;
                    break;
                case 27:
                    iB = r3.c(i17, v(t, j4), r(i14));
                    i15 += iB;
                    break;
                case 28:
                    iB = r3.r(i17, v(t, j4));
                    i15 += iB;
                    break;
                case 29:
                    iB = r3.L(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 30:
                    iB = r3.D(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 31:
                    iB = r3.R(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 32:
                    iB = r3.U(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 33:
                    iB = r3.O(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 34:
                    iB = r3.z(i17, v(t, j4), false);
                    i15 += iB;
                    break;
                case 35:
                    iV2 = r3.V((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 36:
                    iV2 = r3.S((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 37:
                    iV2 = r3.e((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 38:
                    iV2 = r3.u((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 39:
                    iV2 = r3.I((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 40:
                    iV2 = r3.V((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 41:
                    iV2 = r3.S((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 42:
                    iV2 = r3.Y((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 43:
                    iV2 = r3.M((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 44:
                    iV2 = r3.E((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 45:
                    iV2 = r3.S((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 46:
                    iV2 = r3.V((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 47:
                    iV2 = r3.P((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 48:
                    iV2 = r3.A((List) unsafe2.getObject(t, j4));
                    if (iV2 > 0) {
                        if (this.f17165k) {
                            unsafe2.putInt(t, i18, iV2);
                        }
                        iG1 = zzen.g0(i17);
                        iO1 = zzen.o0(iV2);
                        iB = iG1 + iO1 + iV2;
                        i15 += iB;
                    }
                    break;
                case 49:
                    iB = r3.s(i17, v(t, j4), r(i14));
                    i15 += iB;
                    break;
                case 50:
                    iB = this.s.h(i17, k4.F(t, j4), H(i14));
                    i15 += iB;
                    break;
                case 51:
                    if (C(t, i17, i14)) {
                        iB = zzen.B(i17, 0.0d);
                        i15 += iB;
                    }
                    break;
                case 52:
                    if (C(t, i17, i14)) {
                        iB = zzen.C(i17, 0.0f);
                        i15 += iB;
                    }
                    break;
                case 53:
                    if (C(t, i17, i14)) {
                        iB = zzen.b0(i17, S(t, j4));
                        i15 += iB;
                    }
                    break;
                case 54:
                    if (C(t, i17, i14)) {
                        iB = zzen.h0(i17, S(t, j4));
                        i15 += iB;
                    }
                    break;
                case 55:
                    if (C(t, i17, i14)) {
                        iB = zzen.l0(i17, Q(t, j4));
                        i15 += iB;
                    }
                    break;
                case 56:
                    if (C(t, i17, i14)) {
                        iB = zzen.q0(i17, 0L);
                        i15 += iB;
                    }
                    break;
                case 57:
                    if (C(t, i17, i14)) {
                        iB = zzen.x0(i17, 0);
                        i15 += iB;
                    }
                    break;
                case 58:
                    if (C(t, i17, i14)) {
                        iB = zzen.H(i17, true);
                        i15 += iB;
                    }
                    break;
                case 59:
                    if (C(t, i17, i14)) {
                        Object objF2 = k4.F(t, j4);
                        iB = objF2 instanceof zzdu ? zzen.T(i17, (zzdu) objF2) : zzen.G(i17, (String) objF2);
                        i15 += iB;
                    }
                    break;
                case 60:
                    if (C(t, i17, i14)) {
                        iB = r3.a(i17, k4.F(t, j4), r(i14));
                        i15 += iB;
                    }
                    break;
                case 61:
                    if (C(t, i17, i14)) {
                        iB = zzen.T(i17, (zzdu) k4.F(t, j4));
                        i15 += iB;
                    }
                    break;
                case 62:
                    if (C(t, i17, i14)) {
                        iB = zzen.p0(i17, Q(t, j4));
                        i15 += iB;
                    }
                    break;
                case 63:
                    if (C(t, i17, i14)) {
                        iB = zzen.C0(i17, Q(t, j4));
                        i15 += iB;
                    }
                    break;
                case 64:
                    if (C(t, i17, i14)) {
                        iB = zzen.A0(i17, 0);
                        i15 += iB;
                    }
                    break;
                case 65:
                    if (C(t, i17, i14)) {
                        iB = zzen.u0(i17, 0L);
                        i15 += iB;
                    }
                    break;
                case 66:
                    if (C(t, i17, i14)) {
                        iB = zzen.t0(i17, Q(t, j4));
                        i15 += iB;
                    }
                    break;
                case 67:
                    if (C(t, i17, i14)) {
                        iB = zzen.m0(i17, S(t, j4));
                        i15 += iB;
                    }
                    break;
                case 68:
                    if (C(t, i17, i14)) {
                        iB = zzen.U(i17, (zzgo) k4.F(t, j4), r(i14));
                        i15 += iB;
                    }
                    break;
            }
            i14 += 3;
            i4 = 267386880;
        }
        return i15 + l(this.q, t);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final int c(T t) {
        int i2;
        int iB;
        int length = this.f17157c.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iP = P(i4);
            int i5 = this.f17157c[i4];
            long j2 = 1048575 & iP;
            int iHashCode = 37;
            switch ((iP & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    iB = zzff.b(Double.doubleToLongBits(k4.C(t, j2)));
                    i3 = i2 + iB;
                    break;
                case 1:
                    i2 = i3 * 53;
                    iB = Float.floatToIntBits(k4.x(t, j2));
                    i3 = i2 + iB;
                    break;
                case 2:
                    i2 = i3 * 53;
                    iB = zzff.b(k4.o(t, j2));
                    i3 = i2 + iB;
                    break;
                case 3:
                    i2 = i3 * 53;
                    iB = zzff.b(k4.o(t, j2));
                    i3 = i2 + iB;
                    break;
                case 4:
                    i2 = i3 * 53;
                    iB = k4.b(t, j2);
                    i3 = i2 + iB;
                    break;
                case 5:
                    i2 = i3 * 53;
                    iB = zzff.b(k4.o(t, j2));
                    i3 = i2 + iB;
                    break;
                case 6:
                    i2 = i3 * 53;
                    iB = k4.b(t, j2);
                    i3 = i2 + iB;
                    break;
                case 7:
                    i2 = i3 * 53;
                    iB = zzff.c(k4.w(t, j2));
                    i3 = i2 + iB;
                    break;
                case 8:
                    i2 = i3 * 53;
                    iB = ((String) k4.F(t, j2)).hashCode();
                    i3 = i2 + iB;
                    break;
                case 9:
                    Object objF = k4.F(t, j2);
                    if (objF != null) {
                        iHashCode = objF.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i2 = i3 * 53;
                    iB = k4.F(t, j2).hashCode();
                    i3 = i2 + iB;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iB = k4.b(t, j2);
                    i3 = i2 + iB;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iB = k4.b(t, j2);
                    i3 = i2 + iB;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iB = k4.b(t, j2);
                    i3 = i2 + iB;
                    break;
                case 14:
                    i2 = i3 * 53;
                    iB = zzff.b(k4.o(t, j2));
                    i3 = i2 + iB;
                    break;
                case 15:
                    i2 = i3 * 53;
                    iB = k4.b(t, j2);
                    i3 = i2 + iB;
                    break;
                case 16:
                    i2 = i3 * 53;
                    iB = zzff.b(k4.o(t, j2));
                    i3 = i2 + iB;
                    break;
                case 17:
                    Object objF2 = k4.F(t, j2);
                    if (objF2 != null) {
                        iHashCode = objF2.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
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
                    i2 = i3 * 53;
                    iB = k4.F(t, j2).hashCode();
                    i3 = i2 + iB;
                    break;
                case 50:
                    i2 = i3 * 53;
                    iB = k4.F(t, j2).hashCode();
                    i3 = i2 + iB;
                    break;
                case 51:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.b(Double.doubleToLongBits(F(t, j2)));
                        i3 = i2 + iB;
                    }
                    break;
                case 52:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Float.floatToIntBits(M(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 53:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.b(S(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 54:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.b(S(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 55:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Q(t, j2);
                        i3 = i2 + iB;
                    }
                    break;
                case 56:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.b(S(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 57:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Q(t, j2);
                        i3 = i2 + iB;
                    }
                    break;
                case 58:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.c(V(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 59:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = ((String) k4.F(t, j2)).hashCode();
                        i3 = i2 + iB;
                    }
                    break;
                case 60:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = k4.F(t, j2).hashCode();
                        i3 = i2 + iB;
                    }
                    break;
                case 61:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = k4.F(t, j2).hashCode();
                        i3 = i2 + iB;
                    }
                    break;
                case 62:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Q(t, j2);
                        i3 = i2 + iB;
                    }
                    break;
                case 63:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Q(t, j2);
                        i3 = i2 + iB;
                    }
                    break;
                case 64:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Q(t, j2);
                        i3 = i2 + iB;
                    }
                    break;
                case 65:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.b(S(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 66:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = Q(t, j2);
                        i3 = i2 + iB;
                    }
                    break;
                case 67:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = zzff.b(S(t, j2));
                        i3 = i2 + iB;
                    }
                    break;
                case 68:
                    if (C(t, i5, i4)) {
                        i2 = i3 * 53;
                        iB = k4.F(t, j2).hashCode();
                        i3 = i2 + iB;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + this.q.k(t).hashCode();
        return this.f17162h ? (iHashCode2 * 53) + this.r.b(t).hashCode() : iHashCode2;
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
    @Override // com.google.android.gms.internal.measurement.p3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.measurement.m1 r32) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g3.d(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.m1):void");
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bd A[LOOP:1: B:47:0x00ab->B:52:0x00bd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean e(T t) {
        int i2;
        List list;
        p3 p3VarR;
        int i3;
        int i4 = -1;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.m) {
                return !this.f17162h || this.r.b(t).q();
            }
            int i7 = this.l[i5];
            int i8 = this.f17157c[i7];
            int iP = P(i7);
            if (this.f17164j) {
                i2 = 0;
            } else {
                int i9 = this.f17157c[i7 + 2];
                int i10 = i9 & 1048575;
                i2 = 1 << (i9 >>> 20);
                if (i10 != i4) {
                    i6 = f17156b.getInt(t, i10);
                    i4 = i10;
                }
            }
            if (((268435456 & iP) != 0) && !D(t, i7, i6, i2)) {
                return false;
            }
            int i11 = (267386880 & iP) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (D(t, i7, i6, i2) && !E(t, iP, r(i7))) {
                    return false;
                }
            } else if (i11 == 27) {
                list = (List) k4.F(t, iP & 1048575);
                if (!list.isEmpty()) {
                    p3VarR = r(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!p3VarR.e(list.get(i3))) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (i11 == 60 || i11 == 68) {
                if (C(t, i8, i7) && !E(t, iP, r(i7))) {
                    return false;
                }
            } else if (i11 == 49) {
                list = (List) k4.F(t, iP & 1048575);
                if (!list.isEmpty()) {
                    p3VarR = r(i7);
                    while (i3 < list.size()) {
                        if (!p3VarR.e(list.get(i3))) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (i11 == 50 && !this.s.b(k4.F(t, iP & 1048575)).isEmpty()) {
                this.s.zzf(H(i7));
                throw null;
            }
            i5++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void f(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long jP = P(this.l[i3]) & 1048575;
            Object objF = k4.F(t, jP);
            if (objF != null) {
                k4.j(t, jP, this.s.e(objF));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.e(t, this.l[i2]);
            i2++;
        }
        this.q.q(t);
        if (this.f17162h) {
            this.r.j(t);
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01c1  */
    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean g(T t, T t2) {
        int length = this.f17157c.length;
        int i2 = 0;
        while (true) {
            boolean zQ = true;
            if (i2 >= length) {
                if (!this.q.k(t).equals(this.q.k(t2))) {
                    return false;
                }
                if (this.f17162h) {
                    return this.r.b(t).equals(this.r.b(t2));
                }
                return true;
            }
            int iP = P(i2);
            long j2 = iP & 1048575;
            switch ((iP & 267386880) >>> 20) {
                case 0:
                    if (!O(t, t2, i2) || Double.doubleToLongBits(k4.C(t, j2)) != Double.doubleToLongBits(k4.C(t2, j2))) {
                        zQ = false;
                    }
                    break;
                case 1:
                    if (!O(t, t2, i2) || Float.floatToIntBits(k4.x(t, j2)) != Float.floatToIntBits(k4.x(t2, j2))) {
                        zQ = false;
                    }
                    break;
                case 2:
                    if (!O(t, t2, i2) || k4.o(t, j2) != k4.o(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 3:
                    if (!O(t, t2, i2) || k4.o(t, j2) != k4.o(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 4:
                    if (!O(t, t2, i2) || k4.b(t, j2) != k4.b(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 5:
                    if (!O(t, t2, i2) || k4.o(t, j2) != k4.o(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 6:
                    if (!O(t, t2, i2) || k4.b(t, j2) != k4.b(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 7:
                    if (!O(t, t2, i2) || k4.w(t, j2) != k4.w(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 8:
                    if (!O(t, t2, i2) || !r3.q(k4.F(t, j2), k4.F(t2, j2))) {
                        zQ = false;
                    }
                    break;
                case 9:
                    if (!O(t, t2, i2) || !r3.q(k4.F(t, j2), k4.F(t2, j2))) {
                        zQ = false;
                    }
                    break;
                case 10:
                    if (!O(t, t2, i2) || !r3.q(k4.F(t, j2), k4.F(t2, j2))) {
                        zQ = false;
                    }
                    break;
                case 11:
                    if (!O(t, t2, i2) || k4.b(t, j2) != k4.b(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 12:
                    if (!O(t, t2, i2) || k4.b(t, j2) != k4.b(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 13:
                    if (!O(t, t2, i2) || k4.b(t, j2) != k4.b(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 14:
                    if (!O(t, t2, i2) || k4.o(t, j2) != k4.o(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 15:
                    if (!O(t, t2, i2) || k4.b(t, j2) != k4.b(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 16:
                    if (!O(t, t2, i2) || k4.o(t, j2) != k4.o(t2, j2)) {
                        zQ = false;
                    }
                    break;
                case 17:
                    if (!O(t, t2, i2) || !r3.q(k4.F(t, j2), k4.F(t2, j2))) {
                        zQ = false;
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
                    zQ = r3.q(k4.F(t, j2), k4.F(t2, j2));
                    break;
                case 50:
                    zQ = r3.q(k4.F(t, j2), k4.F(t2, j2));
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
                    if (k4.b(t, jR) != k4.b(t2, jR) || !r3.q(k4.F(t, j2), k4.F(t2, j2))) {
                        zQ = false;
                    }
                    break;
            }
            if (!zQ) {
                return false;
            }
            i2 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:178:0x054a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0032  */
    @Override // com.google.android.gms.internal.measurement.p3
    public final void h(T t, y4 y4Var) throws IOException {
        Iterator itO;
        Map.Entry<?, ?> entry;
        Iterator itP;
        Map.Entry<?, ?> entry2;
        if (y4Var.a() == zzfd.zze.m) {
            x(this.q, t, y4Var);
            if (this.f17162h) {
                h2<T> h2VarB = this.r.b(t);
                if (h2VarB.f17168b.isEmpty()) {
                    itP = null;
                    entry2 = null;
                } else {
                    itP = h2VarB.p();
                    entry2 = (Map.Entry) itP.next();
                }
            } else {
                itP = null;
                entry2 = null;
            }
            for (int length = this.f17157c.length - 3; length >= 0; length -= 3) {
                int iP = P(length);
                int i2 = this.f17157c[length];
                while (entry2 != null && this.r.a(entry2) > i2) {
                    this.r.g(y4Var, entry2);
                    entry2 = itP.hasNext() ? (Map.Entry) itP.next() : null;
                }
                switch ((iP & 267386880) >>> 20) {
                    case 0:
                        if (B(t, length)) {
                            y4Var.h(i2, k4.C(t, iP & 1048575));
                        }
                        break;
                    case 1:
                        if (B(t, length)) {
                            y4Var.r(i2, k4.x(t, iP & 1048575));
                        }
                        break;
                    case 2:
                        if (B(t, length)) {
                            y4Var.q(i2, k4.o(t, iP & 1048575));
                        }
                        break;
                    case 3:
                        if (B(t, length)) {
                            y4Var.c(i2, k4.o(t, iP & 1048575));
                        }
                        break;
                    case 4:
                        if (B(t, length)) {
                            y4Var.G(i2, k4.b(t, iP & 1048575));
                        }
                        break;
                    case 5:
                        if (B(t, length)) {
                            y4Var.L(i2, k4.o(t, iP & 1048575));
                        }
                        break;
                    case 6:
                        if (B(t, length)) {
                            y4Var.y(i2, k4.b(t, iP & 1048575));
                        }
                        break;
                    case 7:
                        if (B(t, length)) {
                            y4Var.B(i2, k4.w(t, iP & 1048575));
                        }
                        break;
                    case 8:
                        if (B(t, length)) {
                            w(i2, k4.F(t, iP & 1048575), y4Var);
                        }
                        break;
                    case 9:
                        if (B(t, length)) {
                            y4Var.C(i2, k4.F(t, iP & 1048575), r(length));
                        }
                        break;
                    case 10:
                        if (B(t, length)) {
                            y4Var.E(i2, (zzdu) k4.F(t, iP & 1048575));
                        }
                        break;
                    case 11:
                        if (B(t, length)) {
                            y4Var.M(i2, k4.b(t, iP & 1048575));
                        }
                        break;
                    case 12:
                        if (B(t, length)) {
                            y4Var.D(i2, k4.b(t, iP & 1048575));
                        }
                        break;
                    case 13:
                        if (B(t, length)) {
                            y4Var.H(i2, k4.b(t, iP & 1048575));
                        }
                        break;
                    case 14:
                        if (B(t, length)) {
                            y4Var.b(i2, k4.o(t, iP & 1048575));
                        }
                        break;
                    case 15:
                        if (B(t, length)) {
                            y4Var.J(i2, k4.b(t, iP & 1048575));
                        }
                        break;
                    case 16:
                        if (B(t, length)) {
                            y4Var.N(i2, k4.o(t, iP & 1048575));
                        }
                        break;
                    case 17:
                        if (B(t, length)) {
                            y4Var.F(i2, k4.F(t, iP & 1048575), r(length));
                        }
                        break;
                    case 18:
                        r3.l(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 19:
                        r3.y(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 20:
                        r3.C(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 21:
                        r3.G(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 22:
                        r3.T(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 23:
                        r3.N(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 24:
                        r3.a0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 25:
                        r3.d0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 26:
                        r3.j(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var);
                        break;
                    case 27:
                        r3.k(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, r(length));
                        break;
                    case 28:
                        r3.w(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var);
                        break;
                    case 29:
                        r3.W(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 30:
                        r3.c0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 31:
                        r3.b0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 32:
                        r3.Q(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 33:
                        r3.Z(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 34:
                        r3.K(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, false);
                        break;
                    case 35:
                        r3.l(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 36:
                        r3.y(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 37:
                        r3.C(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 38:
                        r3.G(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 39:
                        r3.T(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 40:
                        r3.N(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 41:
                        r3.a0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 42:
                        r3.d0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 43:
                        r3.W(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 44:
                        r3.c0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 45:
                        r3.b0(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 46:
                        r3.Q(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 47:
                        r3.Z(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 48:
                        r3.K(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, true);
                        break;
                    case 49:
                        r3.x(this.f17157c[length], (List) k4.F(t, iP & 1048575), y4Var, r(length));
                        break;
                    case 50:
                        y(y4Var, i2, k4.F(t, iP & 1048575), length);
                        break;
                    case 51:
                        if (C(t, i2, length)) {
                            y4Var.h(i2, F(t, iP & 1048575));
                        }
                        break;
                    case 52:
                        if (C(t, i2, length)) {
                            y4Var.r(i2, M(t, iP & 1048575));
                        }
                        break;
                    case 53:
                        if (C(t, i2, length)) {
                            y4Var.q(i2, S(t, iP & 1048575));
                        }
                        break;
                    case 54:
                        if (C(t, i2, length)) {
                            y4Var.c(i2, S(t, iP & 1048575));
                        }
                        break;
                    case 55:
                        if (C(t, i2, length)) {
                            y4Var.G(i2, Q(t, iP & 1048575));
                        }
                        break;
                    case 56:
                        if (C(t, i2, length)) {
                            y4Var.L(i2, S(t, iP & 1048575));
                        }
                        break;
                    case 57:
                        if (C(t, i2, length)) {
                            y4Var.y(i2, Q(t, iP & 1048575));
                        }
                        break;
                    case 58:
                        if (C(t, i2, length)) {
                            y4Var.B(i2, V(t, iP & 1048575));
                        }
                        break;
                    case 59:
                        if (C(t, i2, length)) {
                            w(i2, k4.F(t, iP & 1048575), y4Var);
                        }
                        break;
                    case 60:
                        if (C(t, i2, length)) {
                            y4Var.C(i2, k4.F(t, iP & 1048575), r(length));
                        }
                        break;
                    case 61:
                        if (C(t, i2, length)) {
                            y4Var.E(i2, (zzdu) k4.F(t, iP & 1048575));
                        }
                        break;
                    case 62:
                        if (C(t, i2, length)) {
                            y4Var.M(i2, Q(t, iP & 1048575));
                        }
                        break;
                    case 63:
                        if (C(t, i2, length)) {
                            y4Var.D(i2, Q(t, iP & 1048575));
                        }
                        break;
                    case 64:
                        if (C(t, i2, length)) {
                            y4Var.H(i2, Q(t, iP & 1048575));
                        }
                        break;
                    case 65:
                        if (C(t, i2, length)) {
                            y4Var.b(i2, S(t, iP & 1048575));
                        }
                        break;
                    case 66:
                        if (C(t, i2, length)) {
                            y4Var.J(i2, Q(t, iP & 1048575));
                        }
                        break;
                    case 67:
                        if (C(t, i2, length)) {
                            y4Var.N(i2, S(t, iP & 1048575));
                        }
                        break;
                    case 68:
                        if (C(t, i2, length)) {
                            y4Var.F(i2, k4.F(t, iP & 1048575), r(length));
                        }
                        break;
                }
            }
            while (entry2 != null) {
                this.r.g(y4Var, entry2);
                entry2 = itP.hasNext() ? (Map.Entry) itP.next() : null;
            }
            return;
        }
        if (!this.f17164j) {
            K(t, y4Var);
            return;
        }
        if (this.f17162h) {
            h2<T> h2VarB2 = this.r.b(t);
            if (h2VarB2.f17168b.isEmpty()) {
                itO = null;
                entry = null;
            } else {
                itO = h2VarB2.o();
                entry = (Map.Entry) itO.next();
            }
        } else {
            itO = null;
            entry = null;
        }
        int length2 = this.f17157c.length;
        for (int i3 = 0; i3 < length2; i3 += 3) {
            int iP2 = P(i3);
            int i4 = this.f17157c[i3];
            while (entry != null && this.r.a(entry) <= i4) {
                this.r.g(y4Var, entry);
                entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
            }
            switch ((iP2 & 267386880) >>> 20) {
                case 0:
                    if (B(t, i3)) {
                        y4Var.h(i4, k4.C(t, iP2 & 1048575));
                    }
                    break;
                case 1:
                    if (B(t, i3)) {
                        y4Var.r(i4, k4.x(t, iP2 & 1048575));
                    }
                    break;
                case 2:
                    if (B(t, i3)) {
                        y4Var.q(i4, k4.o(t, iP2 & 1048575));
                    }
                    break;
                case 3:
                    if (B(t, i3)) {
                        y4Var.c(i4, k4.o(t, iP2 & 1048575));
                    }
                    break;
                case 4:
                    if (B(t, i3)) {
                        y4Var.G(i4, k4.b(t, iP2 & 1048575));
                    }
                    break;
                case 5:
                    if (B(t, i3)) {
                        y4Var.L(i4, k4.o(t, iP2 & 1048575));
                    }
                    break;
                case 6:
                    if (B(t, i3)) {
                        y4Var.y(i4, k4.b(t, iP2 & 1048575));
                    }
                    break;
                case 7:
                    if (B(t, i3)) {
                        y4Var.B(i4, k4.w(t, iP2 & 1048575));
                    }
                    break;
                case 8:
                    if (B(t, i3)) {
                        w(i4, k4.F(t, iP2 & 1048575), y4Var);
                    }
                    break;
                case 9:
                    if (B(t, i3)) {
                        y4Var.C(i4, k4.F(t, iP2 & 1048575), r(i3));
                    }
                    break;
                case 10:
                    if (B(t, i3)) {
                        y4Var.E(i4, (zzdu) k4.F(t, iP2 & 1048575));
                    }
                    break;
                case 11:
                    if (B(t, i3)) {
                        y4Var.M(i4, k4.b(t, iP2 & 1048575));
                    }
                    break;
                case 12:
                    if (B(t, i3)) {
                        y4Var.D(i4, k4.b(t, iP2 & 1048575));
                    }
                    break;
                case 13:
                    if (B(t, i3)) {
                        y4Var.H(i4, k4.b(t, iP2 & 1048575));
                    }
                    break;
                case 14:
                    if (B(t, i3)) {
                        y4Var.b(i4, k4.o(t, iP2 & 1048575));
                    }
                    break;
                case 15:
                    if (B(t, i3)) {
                        y4Var.J(i4, k4.b(t, iP2 & 1048575));
                    }
                    break;
                case 16:
                    if (B(t, i3)) {
                        y4Var.N(i4, k4.o(t, iP2 & 1048575));
                    }
                    break;
                case 17:
                    if (B(t, i3)) {
                        y4Var.F(i4, k4.F(t, iP2 & 1048575), r(i3));
                    }
                    break;
                case 18:
                    r3.l(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 19:
                    r3.y(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 20:
                    r3.C(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 21:
                    r3.G(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 22:
                    r3.T(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 23:
                    r3.N(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 24:
                    r3.a0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 25:
                    r3.d0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 26:
                    r3.j(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var);
                    break;
                case 27:
                    r3.k(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, r(i3));
                    break;
                case 28:
                    r3.w(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var);
                    break;
                case 29:
                    r3.W(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 30:
                    r3.c0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 31:
                    r3.b0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 32:
                    r3.Q(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 33:
                    r3.Z(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 34:
                    r3.K(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, false);
                    break;
                case 35:
                    r3.l(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 36:
                    r3.y(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 37:
                    r3.C(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 38:
                    r3.G(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 39:
                    r3.T(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 40:
                    r3.N(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 41:
                    r3.a0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 42:
                    r3.d0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 43:
                    r3.W(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 44:
                    r3.c0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 45:
                    r3.b0(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 46:
                    r3.Q(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 47:
                    r3.Z(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 48:
                    r3.K(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, true);
                    break;
                case 49:
                    r3.x(this.f17157c[i3], (List) k4.F(t, iP2 & 1048575), y4Var, r(i3));
                    break;
                case 50:
                    y(y4Var, i4, k4.F(t, iP2 & 1048575), i3);
                    break;
                case 51:
                    if (C(t, i4, i3)) {
                        y4Var.h(i4, F(t, iP2 & 1048575));
                    }
                    break;
                case 52:
                    if (C(t, i4, i3)) {
                        y4Var.r(i4, M(t, iP2 & 1048575));
                    }
                    break;
                case 53:
                    if (C(t, i4, i3)) {
                        y4Var.q(i4, S(t, iP2 & 1048575));
                    }
                    break;
                case 54:
                    if (C(t, i4, i3)) {
                        y4Var.c(i4, S(t, iP2 & 1048575));
                    }
                    break;
                case 55:
                    if (C(t, i4, i3)) {
                        y4Var.G(i4, Q(t, iP2 & 1048575));
                    }
                    break;
                case 56:
                    if (C(t, i4, i3)) {
                        y4Var.L(i4, S(t, iP2 & 1048575));
                    }
                    break;
                case 57:
                    if (C(t, i4, i3)) {
                        y4Var.y(i4, Q(t, iP2 & 1048575));
                    }
                    break;
                case 58:
                    if (C(t, i4, i3)) {
                        y4Var.B(i4, V(t, iP2 & 1048575));
                    }
                    break;
                case 59:
                    if (C(t, i4, i3)) {
                        w(i4, k4.F(t, iP2 & 1048575), y4Var);
                    }
                    break;
                case 60:
                    if (C(t, i4, i3)) {
                        y4Var.C(i4, k4.F(t, iP2 & 1048575), r(i3));
                    }
                    break;
                case 61:
                    if (C(t, i4, i3)) {
                        y4Var.E(i4, (zzdu) k4.F(t, iP2 & 1048575));
                    }
                    break;
                case 62:
                    if (C(t, i4, i3)) {
                        y4Var.M(i4, Q(t, iP2 & 1048575));
                    }
                    break;
                case 63:
                    if (C(t, i4, i3)) {
                        y4Var.D(i4, Q(t, iP2 & 1048575));
                    }
                    break;
                case 64:
                    if (C(t, i4, i3)) {
                        y4Var.H(i4, Q(t, iP2 & 1048575));
                    }
                    break;
                case 65:
                    if (C(t, i4, i3)) {
                        y4Var.b(i4, S(t, iP2 & 1048575));
                    }
                    break;
                case 66:
                    if (C(t, i4, i3)) {
                        y4Var.J(i4, Q(t, iP2 & 1048575));
                    }
                    break;
                case 67:
                    if (C(t, i4, i3)) {
                        y4Var.N(i4, S(t, iP2 & 1048575));
                    }
                    break;
                case 68:
                    if (C(t, i4, i3)) {
                        y4Var.F(i4, k4.F(t, iP2 & 1048575), r(i3));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.r.g(y4Var, entry);
            entry = itO.hasNext() ? (Map.Entry) itO.next() : null;
        }
        x(this.q, t, y4Var);
    }

    /* JADX WARN: Code duplicated, block: B:165:0x05ce A[LOOP:5: B:163:0x05ca->B:165:0x05ce, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:167:0x05db  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.internal.measurement.p3
    public final void i(T t, q3 q3Var, zzeq zzeqVar) throws IOException {
        int i2;
        zzeqVar.getClass();
        h4<?, ?> h4Var = this.q;
        d2<?> d2Var = this.r;
        h2 h2VarI = null;
        Object objT = null;
        while (true) {
            try {
                int iA = q3Var.a();
                int iW = W(iA);
                if (iW >= 0) {
                    int iP = P(iW);
                    switch ((267386880 & iP) >>> 20) {
                        case 0:
                            k4.f(t, iP & 1048575, q3Var.d());
                            I(t, iW);
                            continue;
                        case 1:
                            k4.g(t, iP & 1048575, q3Var.e());
                            I(t, iW);
                            continue;
                        case 2:
                            k4.i(t, iP & 1048575, q3Var.s());
                            I(t, iW);
                            continue;
                        case 3:
                            k4.i(t, iP & 1048575, q3Var.q());
                            I(t, iW);
                            continue;
                        case 4:
                            k4.h(t, iP & 1048575, q3Var.m());
                            I(t, iW);
                            continue;
                        case 5:
                            k4.i(t, iP & 1048575, q3Var.l());
                            I(t, iW);
                            continue;
                        case 6:
                            k4.h(t, iP & 1048575, q3Var.v());
                            I(t, iW);
                            continue;
                        case 7:
                            k4.k(t, iP & 1048575, q3Var.O());
                            I(t, iW);
                            continue;
                        case 8:
                            z(t, iP, q3Var);
                            I(t, iW);
                            continue;
                        case 9:
                            if (B(t, iW)) {
                                long j2 = iP & 1048575;
                                k4.j(t, j2, zzff.e(k4.F(t, j2), q3Var.J(r(iW), zzeqVar)));
                            } else {
                                k4.j(t, iP & 1048575, q3Var.J(r(iW), zzeqVar));
                                I(t, iW);
                                continue;
                            }
                            break;
                        case 10:
                            k4.j(t, iP & 1048575, q3Var.f());
                            I(t, iW);
                            continue;
                        case 11:
                            k4.h(t, iP & 1048575, q3Var.p());
                            I(t, iW);
                            continue;
                        case 12:
                            int iK = q3Var.k();
                            zzfk zzfkVarN = N(iW);
                            if (zzfkVarN == null || zzfkVarN.d(iK)) {
                                k4.h(t, iP & 1048575, iK);
                                I(t, iW);
                                continue;
                            } else {
                                objT = r3.h(iA, iK, objT, h4Var);
                            }
                            break;
                        case 13:
                            k4.h(t, iP & 1048575, q3Var.g());
                            I(t, iW);
                            continue;
                        case 14:
                            k4.i(t, iP & 1048575, q3Var.h());
                            I(t, iW);
                            continue;
                        case 15:
                            k4.h(t, iP & 1048575, q3Var.x());
                            I(t, iW);
                            continue;
                        case 16:
                            k4.i(t, iP & 1048575, q3Var.y());
                            I(t, iW);
                            continue;
                        case 17:
                            if (B(t, iW)) {
                                long j3 = iP & 1048575;
                                k4.j(t, j3, zzff.e(k4.F(t, j3), q3Var.K(r(iW), zzeqVar)));
                            } else {
                                k4.j(t, iP & 1048575, q3Var.K(r(iW), zzeqVar));
                                I(t, iW);
                                continue;
                            }
                            break;
                        case 18:
                            q3Var.H(this.p.b(t, iP & 1048575));
                            continue;
                        case 19:
                            q3Var.A(this.p.b(t, iP & 1048575));
                            continue;
                        case 20:
                            q3Var.M(this.p.b(t, iP & 1048575));
                            continue;
                        case 21:
                            q3Var.u0(this.p.b(t, iP & 1048575));
                            continue;
                        case 22:
                            q3Var.L(this.p.b(t, iP & 1048575));
                            continue;
                        case 23:
                            q3Var.G(this.p.b(t, iP & 1048575));
                            continue;
                        case 24:
                            q3Var.F(this.p.b(t, iP & 1048575));
                            continue;
                        case 25:
                            q3Var.E(this.p.b(t, iP & 1048575));
                            continue;
                        case 26:
                            if (U(iP)) {
                                q3Var.o(this.p.b(t, iP & 1048575));
                            } else {
                                q3Var.r(this.p.b(t, iP & 1048575));
                                continue;
                            }
                            break;
                        case 27:
                            q3Var.N(this.p.b(t, iP & 1048575), r(iW), zzeqVar);
                            continue;
                        case 28:
                            q3Var.z(this.p.b(t, iP & 1048575));
                            continue;
                        case 29:
                            q3Var.u(this.p.b(t, iP & 1048575));
                            continue;
                        case 30:
                            List<Integer> listB = this.p.b(t, iP & 1048575);
                            q3Var.C(listB);
                            objT = r3.i(iA, listB, N(iW), objT, h4Var);
                            continue;
                        case 31:
                            q3Var.B(this.p.b(t, iP & 1048575));
                            continue;
                        case 32:
                            q3Var.n(this.p.b(t, iP & 1048575));
                            continue;
                        case 33:
                            q3Var.i(this.p.b(t, iP & 1048575));
                            continue;
                        case 34:
                            q3Var.t(this.p.b(t, iP & 1048575));
                            continue;
                        case 35:
                            q3Var.H(this.p.b(t, iP & 1048575));
                            continue;
                        case 36:
                            q3Var.A(this.p.b(t, iP & 1048575));
                            continue;
                        case 37:
                            q3Var.M(this.p.b(t, iP & 1048575));
                            continue;
                        case 38:
                            q3Var.u0(this.p.b(t, iP & 1048575));
                            continue;
                        case 39:
                            q3Var.L(this.p.b(t, iP & 1048575));
                            continue;
                        case 40:
                            q3Var.G(this.p.b(t, iP & 1048575));
                            continue;
                        case 41:
                            q3Var.F(this.p.b(t, iP & 1048575));
                            continue;
                        case 42:
                            q3Var.E(this.p.b(t, iP & 1048575));
                            continue;
                        case 43:
                            q3Var.u(this.p.b(t, iP & 1048575));
                            continue;
                        case 44:
                            List<Integer> listB2 = this.p.b(t, iP & 1048575);
                            q3Var.C(listB2);
                            objT = r3.i(iA, listB2, N(iW), objT, h4Var);
                            continue;
                        case 45:
                            q3Var.B(this.p.b(t, iP & 1048575));
                            continue;
                        case 46:
                            q3Var.n(this.p.b(t, iP & 1048575));
                            continue;
                        case 47:
                            q3Var.i(this.p.b(t, iP & 1048575));
                            continue;
                        case 48:
                            q3Var.t(this.p.b(t, iP & 1048575));
                            continue;
                        case 49:
                            q3Var.I(this.p.b(t, iP & 1048575), r(iW), zzeqVar);
                            continue;
                        case 50:
                            Object objH = H(iW);
                            long jP = P(iW) & 1048575;
                            Object objF = k4.F(t, jP);
                            if (objF == null) {
                                objF = this.s.d(objH);
                                k4.j(t, jP, objF);
                            } else if (this.s.f(objF)) {
                                Object objD = this.s.d(objH);
                                this.s.g(objD, objF);
                                k4.j(t, jP, objD);
                                objF = objD;
                            }
                            q3Var.D(this.s.c(objF), this.s.zzf(objH), zzeqVar);
                            continue;
                        case 51:
                            k4.j(t, iP & 1048575, Double.valueOf(q3Var.d()));
                            J(t, iA, iW);
                            continue;
                        case 52:
                            k4.j(t, iP & 1048575, Float.valueOf(q3Var.e()));
                            J(t, iA, iW);
                            continue;
                        case 53:
                            k4.j(t, iP & 1048575, Long.valueOf(q3Var.s()));
                            J(t, iA, iW);
                            continue;
                        case 54:
                            k4.j(t, iP & 1048575, Long.valueOf(q3Var.q()));
                            J(t, iA, iW);
                            continue;
                        case 55:
                            k4.j(t, iP & 1048575, Integer.valueOf(q3Var.m()));
                            J(t, iA, iW);
                            continue;
                        case 56:
                            k4.j(t, iP & 1048575, Long.valueOf(q3Var.l()));
                            J(t, iA, iW);
                            continue;
                        case 57:
                            k4.j(t, iP & 1048575, Integer.valueOf(q3Var.v()));
                            J(t, iA, iW);
                            continue;
                        case 58:
                            k4.j(t, iP & 1048575, Boolean.valueOf(q3Var.O()));
                            J(t, iA, iW);
                            continue;
                        case 59:
                            z(t, iP, q3Var);
                            J(t, iA, iW);
                            continue;
                        case 60:
                            if (C(t, iA, iW)) {
                                long j4 = iP & 1048575;
                                k4.j(t, j4, zzff.e(k4.F(t, j4), q3Var.J(r(iW), zzeqVar)));
                            } else {
                                k4.j(t, iP & 1048575, q3Var.J(r(iW), zzeqVar));
                                I(t, iW);
                            }
                            J(t, iA, iW);
                            continue;
                        case 61:
                            k4.j(t, iP & 1048575, q3Var.f());
                            J(t, iA, iW);
                            continue;
                        case 62:
                            k4.j(t, iP & 1048575, Integer.valueOf(q3Var.p()));
                            J(t, iA, iW);
                            continue;
                        case 63:
                            int iK2 = q3Var.k();
                            zzfk zzfkVarN2 = N(iW);
                            if (zzfkVarN2 == null || zzfkVarN2.d(iK2)) {
                                k4.j(t, iP & 1048575, Integer.valueOf(iK2));
                                J(t, iA, iW);
                                continue;
                            } else {
                                objT = r3.h(iA, iK2, objT, h4Var);
                            }
                            break;
                        case 64:
                            k4.j(t, iP & 1048575, Integer.valueOf(q3Var.g()));
                            J(t, iA, iW);
                            continue;
                        case 65:
                            k4.j(t, iP & 1048575, Long.valueOf(q3Var.h()));
                            J(t, iA, iW);
                            continue;
                        case 66:
                            k4.j(t, iP & 1048575, Integer.valueOf(q3Var.x()));
                            J(t, iA, iW);
                            continue;
                        case 67:
                            k4.j(t, iP & 1048575, Long.valueOf(q3Var.y()));
                            J(t, iA, iW);
                            continue;
                        case 68:
                            k4.j(t, iP & 1048575, q3Var.K(r(iW), zzeqVar));
                            J(t, iA, iW);
                            continue;
                        default:
                            if (objT == null) {
                                try {
                                    objT = h4Var.a();
                                } catch (zzfn unused) {
                                    h4Var.i(q3Var);
                                    if (objT == null) {
                                        objT = h4Var.o(t);
                                    }
                                    if (!h4Var.j((Object) objT, q3Var)) {
                                        for (int i3 = this.m; i3 < this.n; i3++) {
                                            objT = t(t, this.l[i3], objT, h4Var);
                                        }
                                        if (objT != null) {
                                            h4Var.n(t, (Object) objT);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            if (!h4Var.j((Object) objT, q3Var)) {
                                for (int i4 = this.m; i4 < this.n; i4++) {
                                    objT = t(t, this.l[i4], objT, h4Var);
                                }
                                if (objT != null) {
                                    h4Var.n(t, (Object) objT);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                    for (i2 = this.m; i2 < this.n; i2++) {
                        objT = t(t, this.l[i2], objT, h4Var);
                    }
                    if (objT != null) {
                        h4Var.n(t, (Object) objT);
                    }
                    throw th;
                }
                if (iA == Integer.MAX_VALUE) {
                    for (int i5 = this.m; i5 < this.n; i5++) {
                        objT = t(t, this.l[i5], objT, h4Var);
                    }
                    if (objT != null) {
                        h4Var.n(t, (Object) objT);
                        return;
                    }
                    return;
                }
                Object objC = !this.f17162h ? null : d2Var.c(zzeqVar, this.f17161g, iA);
                if (objC != null) {
                    if (h2VarI == null) {
                        h2VarI = d2Var.i(t);
                    }
                    h2 h2Var = h2VarI;
                    objT = d2Var.d(q3Var, objC, zzeqVar, h2Var, objT, h4Var);
                    h2VarI = h2Var;
                } else {
                    h4Var.i(q3Var);
                    if (objT == null) {
                        objT = h4Var.o(t);
                    }
                    if (!h4Var.j((Object) objT, q3Var)) {
                        for (int i6 = this.m; i6 < this.n; i6++) {
                            objT = t(t, this.l[i6], objT, h4Var);
                        }
                        if (objT != null) {
                            h4Var.n(t, (Object) objT);
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                while (i2 < this.n) {
                    objT = t(t, this.l[i2], objT, h4Var);
                }
                if (objT != null) {
                    h4Var.n(t, (Object) objT);
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void j(T t, T t2) {
        t2.getClass();
        for (int i2 = 0; i2 < this.f17157c.length; i2 += 3) {
            int iP = P(i2);
            long j2 = 1048575 & iP;
            int i3 = this.f17157c[i2];
            switch ((iP & 267386880) >>> 20) {
                case 0:
                    if (B(t2, i2)) {
                        k4.f(t, j2, k4.C(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 1:
                    if (B(t2, i2)) {
                        k4.g(t, j2, k4.x(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 2:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 3:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 4:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 5:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 6:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 7:
                    if (B(t2, i2)) {
                        k4.k(t, j2, k4.w(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 8:
                    if (B(t2, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 9:
                    A(t, t2, i2);
                    break;
                case 10:
                    if (B(t2, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 11:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 12:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 13:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 14:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 15:
                    if (B(t2, i2)) {
                        k4.h(t, j2, k4.b(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 16:
                    if (B(t2, i2)) {
                        k4.i(t, j2, k4.o(t2, j2));
                        I(t, i2);
                    }
                    break;
                case 17:
                    A(t, t2, i2);
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
                    this.p.c(t, t2, j2);
                    break;
                case 50:
                    r3.n(this.s, t, t2, j2);
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
                    if (C(t2, i3, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        J(t, i3, i2);
                    }
                    break;
                case 60:
                    L(t, t2, i2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (C(t2, i3, i2)) {
                        k4.j(t, j2, k4.F(t2, j2));
                        J(t, i3, i2);
                    }
                    break;
                case 68:
                    L(t, t2, i2);
                    break;
            }
        }
        if (this.f17164j) {
            return;
        }
        r3.o(this.q, t, t2);
        if (this.f17162h) {
            r3.m(this.r, t, t2);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int p(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.m1 r35) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g3.p(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.m1):int");
    }
}
