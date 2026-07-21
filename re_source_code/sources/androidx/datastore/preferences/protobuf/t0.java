package androidx.datastore.preferences.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: MessageSchema.java */
/* JADX INFO: loaded from: classes.dex */
final class t0<T> implements f1<T> {
    private static final int[] a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Unsafe f1413b = p1.B();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f1414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f1415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q0 f1418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f1419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f1420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f1421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f1422k;
    private final int[] l;
    private final int m;
    private final int n;
    private final v0 o;
    private final g0 p;
    private final l1<?, ?> q;
    private final q<?> r;
    private final l0 s;

    private t0(int[] iArr, Object[] objArr, int i2, int i3, q0 q0Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        this.f1414c = iArr;
        this.f1415d = objArr;
        this.f1416e = i2;
        this.f1417f = i3;
        this.f1420i = q0Var instanceof y;
        this.f1421j = z;
        this.f1419h = qVar != null && qVar.e(q0Var);
        this.f1422k = z2;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = v0Var;
        this.p = g0Var;
        this.q = l1Var;
        this.r = qVar;
        this.f1418g = q0Var;
        this.s = l0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean A(Object obj, int i2, f1 f1Var) {
        return f1Var.g(p1.A(obj, R(i2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean B(Object obj, int i2, int i3) {
        List list = (List) p1.A(obj, R(i2));
        if (list.isEmpty()) {
            return true;
        }
        f1 f1VarS = s(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!f1VarS.g(list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.f1] */
    private boolean C(T t, int i2, int i3) {
        Map<?, ?> mapH = this.s.h(p1.A(t, R(i2)));
        if (mapH.isEmpty()) {
            return true;
        }
        if (this.s.c(r(i3)).f1353c.g() != r1.c.MESSAGE) {
            return true;
        }
        ?? D = 0;
        for (Object obj : mapH.values()) {
            if (D == 0) {
                D = D;
                D = b1.a().d(obj.getClass());
            }
            D = D;
            if (!D.g(obj)) {
                return false;
            }
        }
        return true;
    }

    private boolean D(T t, T t2, int i2) {
        long jY = Y(i2) & 1048575;
        return p1.x(t, jY) == p1.x(t2, jY);
    }

    private boolean E(T t, int i2, int i3) {
        return p1.x(t, (long) (Y(i3) & 1048575)) == i2;
    }

    private static boolean F(int i2) {
        return (i2 & 268435456) != 0;
    }

    private static List<?> G(Object obj, long j2) {
        return (List) p1.A(obj, j2);
    }

    private static <T> long H(T t, long j2) {
        return p1.y(t, j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends u.b<ET>> void I(l1<UT, UB> l1Var, q<ET> qVar, T t, e1 e1Var, p pVar) throws IOException {
        Object objN = null;
        Object objD = null;
        while (true) {
            try {
                int iA = e1Var.A();
                int iX = X(iA);
                if (iX >= 0) {
                    int iI0 = i0(iX);
                    try {
                        switch (h0(iI0)) {
                            case 0:
                                p1.K(t, R(iI0), e1Var.readDouble());
                                e0(t, iX);
                                break;
                            case 1:
                                p1.L(t, R(iI0), e1Var.readFloat());
                                e0(t, iX);
                                break;
                            case 2:
                                p1.N(t, R(iI0), e1Var.L());
                                e0(t, iX);
                                break;
                            case 3:
                                p1.N(t, R(iI0), e1Var.e());
                                e0(t, iX);
                                break;
                            case 4:
                                p1.M(t, R(iI0), e1Var.E());
                                e0(t, iX);
                                break;
                            case 5:
                                p1.N(t, R(iI0), e1Var.f());
                                e0(t, iX);
                                break;
                            case 6:
                                p1.M(t, R(iI0), e1Var.k());
                                e0(t, iX);
                                break;
                            case 7:
                                p1.E(t, R(iI0), e1Var.l());
                                e0(t, iX);
                                break;
                            case 8:
                                b0(t, iI0, e1Var);
                                e0(t, iX);
                                break;
                            case 9:
                                if (y(t, iX)) {
                                    p1.O(t, R(iI0), a0.h(p1.A(t, R(iI0)), e1Var.c(s(iX), pVar)));
                                } else {
                                    p1.O(t, R(iI0), e1Var.c(s(iX), pVar));
                                    e0(t, iX);
                                }
                                break;
                            case 10:
                                p1.O(t, R(iI0), e1Var.C());
                                e0(t, iX);
                                break;
                            case 11:
                                p1.M(t, R(iI0), e1Var.p());
                                e0(t, iX);
                                break;
                            case 12:
                                int iV = e1Var.v();
                                a0.e eVarQ = q(iX);
                                if (eVarQ == null || eVarQ.a(iV)) {
                                    p1.M(t, R(iI0), iV);
                                    e0(t, iX);
                                } else {
                                    objN = h1.L(iA, iV, objN, l1Var);
                                }
                                break;
                            case 13:
                                p1.M(t, R(iI0), e1Var.H());
                                e0(t, iX);
                                break;
                            case 14:
                                p1.N(t, R(iI0), e1Var.m());
                                e0(t, iX);
                                break;
                            case 15:
                                p1.M(t, R(iI0), e1Var.x());
                                e0(t, iX);
                                break;
                            case 16:
                                p1.N(t, R(iI0), e1Var.y());
                                e0(t, iX);
                                break;
                            case 17:
                                if (y(t, iX)) {
                                    p1.O(t, R(iI0), a0.h(p1.A(t, R(iI0)), e1Var.O(s(iX), pVar)));
                                } else {
                                    p1.O(t, R(iI0), e1Var.O(s(iX), pVar));
                                    e0(t, iX);
                                }
                                break;
                            case 18:
                                e1Var.J(this.p.e(t, R(iI0)));
                                break;
                            case 19:
                                e1Var.D(this.p.e(t, R(iI0)));
                                break;
                            case 20:
                                e1Var.q(this.p.e(t, R(iI0)));
                                break;
                            case 21:
                                e1Var.n(this.p.e(t, R(iI0)));
                                break;
                            case 22:
                                e1Var.s(this.p.e(t, R(iI0)));
                                break;
                            case 23:
                                e1Var.N(this.p.e(t, R(iI0)));
                                break;
                            case 24:
                                e1Var.w(this.p.e(t, R(iI0)));
                                break;
                            case 25:
                                e1Var.z(this.p.e(t, R(iI0)));
                                break;
                            case 26:
                                c0(t, iI0, e1Var);
                                break;
                            case 27:
                                a0(t, iI0, e1Var, s(iX), pVar);
                                break;
                            case 28:
                                e1Var.I(this.p.e(t, R(iI0)));
                                break;
                            case 29:
                                e1Var.j(this.p.e(t, R(iI0)));
                                break;
                            case 30:
                                List<Integer> listE = this.p.e(t, R(iI0));
                                e1Var.t(listE);
                                objN = h1.A(iA, listE, q(iX), objN, l1Var);
                                break;
                            case 31:
                                e1Var.h(this.p.e(t, R(iI0)));
                                break;
                            case 32:
                                e1Var.r(this.p.e(t, R(iI0)));
                                break;
                            case 33:
                                e1Var.d(this.p.e(t, R(iI0)));
                                break;
                            case 34:
                                e1Var.i(this.p.e(t, R(iI0)));
                                break;
                            case 35:
                                e1Var.J(this.p.e(t, R(iI0)));
                                break;
                            case 36:
                                e1Var.D(this.p.e(t, R(iI0)));
                                break;
                            case 37:
                                e1Var.q(this.p.e(t, R(iI0)));
                                break;
                            case 38:
                                e1Var.n(this.p.e(t, R(iI0)));
                                break;
                            case 39:
                                e1Var.s(this.p.e(t, R(iI0)));
                                break;
                            case 40:
                                e1Var.N(this.p.e(t, R(iI0)));
                                break;
                            case 41:
                                e1Var.w(this.p.e(t, R(iI0)));
                                break;
                            case 42:
                                e1Var.z(this.p.e(t, R(iI0)));
                                break;
                            case 43:
                                e1Var.j(this.p.e(t, R(iI0)));
                                break;
                            case 44:
                                List<Integer> listE2 = this.p.e(t, R(iI0));
                                e1Var.t(listE2);
                                objN = h1.A(iA, listE2, q(iX), objN, l1Var);
                                break;
                            case 45:
                                e1Var.h(this.p.e(t, R(iI0)));
                                break;
                            case 46:
                                e1Var.r(this.p.e(t, R(iI0)));
                                break;
                            case 47:
                                e1Var.d(this.p.e(t, R(iI0)));
                                break;
                            case 48:
                                e1Var.i(this.p.e(t, R(iI0)));
                                break;
                            case 49:
                                Z(t, R(iI0), e1Var, s(iX), pVar);
                                break;
                            case 50:
                                J(t, iX, r(iX), pVar, e1Var);
                                break;
                            case 51:
                                p1.O(t, R(iI0), Double.valueOf(e1Var.readDouble()));
                                f0(t, iA, iX);
                                break;
                            case 52:
                                p1.O(t, R(iI0), Float.valueOf(e1Var.readFloat()));
                                f0(t, iA, iX);
                                break;
                            case 53:
                                p1.O(t, R(iI0), Long.valueOf(e1Var.L()));
                                f0(t, iA, iX);
                                break;
                            case 54:
                                p1.O(t, R(iI0), Long.valueOf(e1Var.e()));
                                f0(t, iA, iX);
                                break;
                            case 55:
                                p1.O(t, R(iI0), Integer.valueOf(e1Var.E()));
                                f0(t, iA, iX);
                                break;
                            case 56:
                                p1.O(t, R(iI0), Long.valueOf(e1Var.f()));
                                f0(t, iA, iX);
                                break;
                            case 57:
                                p1.O(t, R(iI0), Integer.valueOf(e1Var.k()));
                                f0(t, iA, iX);
                                break;
                            case 58:
                                p1.O(t, R(iI0), Boolean.valueOf(e1Var.l()));
                                f0(t, iA, iX);
                                break;
                            case 59:
                                b0(t, iI0, e1Var);
                                f0(t, iA, iX);
                                break;
                            case 60:
                                if (E(t, iA, iX)) {
                                    p1.O(t, R(iI0), a0.h(p1.A(t, R(iI0)), e1Var.c(s(iX), pVar)));
                                } else {
                                    p1.O(t, R(iI0), e1Var.c(s(iX), pVar));
                                    e0(t, iX);
                                }
                                f0(t, iA, iX);
                                break;
                            case 61:
                                p1.O(t, R(iI0), e1Var.C());
                                f0(t, iA, iX);
                                break;
                            case 62:
                                p1.O(t, R(iI0), Integer.valueOf(e1Var.p()));
                                f0(t, iA, iX);
                                break;
                            case 63:
                                int iV2 = e1Var.v();
                                a0.e eVarQ2 = q(iX);
                                if (eVarQ2 == null || eVarQ2.a(iV2)) {
                                    p1.O(t, R(iI0), Integer.valueOf(iV2));
                                    f0(t, iA, iX);
                                } else {
                                    objN = h1.L(iA, iV2, objN, l1Var);
                                }
                                break;
                            case 64:
                                p1.O(t, R(iI0), Integer.valueOf(e1Var.H()));
                                f0(t, iA, iX);
                                break;
                            case 65:
                                p1.O(t, R(iI0), Long.valueOf(e1Var.m()));
                                f0(t, iA, iX);
                                break;
                            case 66:
                                p1.O(t, R(iI0), Integer.valueOf(e1Var.x()));
                                f0(t, iA, iX);
                                break;
                            case 67:
                                p1.O(t, R(iI0), Long.valueOf(e1Var.y()));
                                f0(t, iA, iX);
                                break;
                            case 68:
                                p1.O(t, R(iI0), e1Var.O(s(iX), pVar));
                                f0(t, iA, iX);
                                break;
                            default:
                                if (objN == null) {
                                    objN = l1Var.n();
                                }
                                if (!l1Var.m(objN, e1Var)) {
                                    for (int i2 = this.m; i2 < this.n; i2++) {
                                        objN = n(t, this.l[i2], objN, l1Var);
                                    }
                                    if (objN != null) {
                                        l1Var.o(t, objN);
                                        return;
                                    }
                                    return;
                                }
                                break;
                                break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (!l1Var.q(e1Var)) {
                            if (objN == null) {
                                objN = l1Var.f(t);
                            }
                            if (!l1Var.m(objN, e1Var)) {
                                for (int i3 = this.m; i3 < this.n; i3++) {
                                    objN = n(t, this.l[i3], objN, l1Var);
                                }
                                if (objN != null) {
                                    l1Var.o(t, objN);
                                    return;
                                }
                                return;
                            }
                        } else if (!e1Var.G()) {
                            for (int i4 = this.m; i4 < this.n; i4++) {
                                objN = n(t, this.l[i4], objN, l1Var);
                            }
                            if (objN != null) {
                                l1Var.o(t, objN);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    if (iA == Integer.MAX_VALUE) {
                        for (int i5 = this.m; i5 < this.n; i5++) {
                            objN = n(t, this.l[i5], objN, l1Var);
                        }
                        if (objN != null) {
                            l1Var.o(t, objN);
                            return;
                        }
                        return;
                    }
                    Object objB = !this.f1419h ? null : qVar.b(pVar, this.f1418g, iA);
                    if (objB != null) {
                        if (objD == null) {
                            objD = qVar.d(t);
                        }
                        objN = qVar.g(e1Var, objB, pVar, objD, objN, l1Var);
                    } else if (!l1Var.q(e1Var)) {
                        if (objN == null) {
                            objN = l1Var.f(t);
                        }
                        if (l1Var.m(objN, e1Var)) {
                        }
                    } else if (e1Var.G()) {
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.m; i6 < this.n; i6++) {
                    objN = n(t, this.l[i6], objN, l1Var);
                }
                if (objN != null) {
                    l1Var.o(t, objN);
                }
                throw th;
            }
        }
        for (int i7 = this.m; i7 < this.n; i7++) {
            objN = n(t, this.l[i7], objN, l1Var);
        }
        if (objN != null) {
            l1Var.o(t, objN);
        }
    }

    private final <K, V> void J(Object obj, int i2, Object obj2, p pVar, e1 e1Var) throws IOException {
        long jR = R(i0(i2));
        Object objA = p1.A(obj, jR);
        if (objA == null) {
            objA = this.s.e(obj2);
            p1.O(obj, jR, objA);
        } else if (this.s.g(objA)) {
            Object objE = this.s.e(obj2);
            this.s.a(objE, objA);
            p1.O(obj, jR, objE);
            objA = objE;
        }
        e1Var.u(this.s.d(objA), this.s.c(obj2), pVar);
    }

    private void K(T t, T t2, int i2) {
        long jR = R(i0(i2));
        if (y(t2, i2)) {
            Object objA = p1.A(t, jR);
            Object objA2 = p1.A(t2, jR);
            if (objA != null && objA2 != null) {
                p1.O(t, jR, a0.h(objA, objA2));
                e0(t, i2);
            } else if (objA2 != null) {
                p1.O(t, jR, objA2);
                e0(t, i2);
            }
        }
    }

    private void L(T t, T t2, int i2) {
        int iI0 = i0(i2);
        int iQ = Q(i2);
        long jR = R(iI0);
        if (E(t2, iQ, i2)) {
            Object objA = p1.A(t, jR);
            Object objA2 = p1.A(t2, jR);
            if (objA != null && objA2 != null) {
                p1.O(t, jR, a0.h(objA, objA2));
                f0(t, iQ, i2);
            } else if (objA2 != null) {
                p1.O(t, jR, objA2);
                f0(t, iQ, i2);
            }
        }
    }

    private void M(T t, T t2, int i2) {
        int iI0 = i0(i2);
        long jR = R(iI0);
        int iQ = Q(i2);
        switch (h0(iI0)) {
            case 0:
                if (y(t2, i2)) {
                    p1.K(t, jR, p1.v(t2, jR));
                    e0(t, i2);
                }
                break;
            case 1:
                if (y(t2, i2)) {
                    p1.L(t, jR, p1.w(t2, jR));
                    e0(t, i2);
                }
                break;
            case 2:
                if (y(t2, i2)) {
                    p1.N(t, jR, p1.y(t2, jR));
                    e0(t, i2);
                }
                break;
            case 3:
                if (y(t2, i2)) {
                    p1.N(t, jR, p1.y(t2, jR));
                    e0(t, i2);
                }
                break;
            case 4:
                if (y(t2, i2)) {
                    p1.M(t, jR, p1.x(t2, jR));
                    e0(t, i2);
                }
                break;
            case 5:
                if (y(t2, i2)) {
                    p1.N(t, jR, p1.y(t2, jR));
                    e0(t, i2);
                }
                break;
            case 6:
                if (y(t2, i2)) {
                    p1.M(t, jR, p1.x(t2, jR));
                    e0(t, i2);
                }
                break;
            case 7:
                if (y(t2, i2)) {
                    p1.E(t, jR, p1.p(t2, jR));
                    e0(t, i2);
                }
                break;
            case 8:
                if (y(t2, i2)) {
                    p1.O(t, jR, p1.A(t2, jR));
                    e0(t, i2);
                }
                break;
            case 9:
                K(t, t2, i2);
                break;
            case 10:
                if (y(t2, i2)) {
                    p1.O(t, jR, p1.A(t2, jR));
                    e0(t, i2);
                }
                break;
            case 11:
                if (y(t2, i2)) {
                    p1.M(t, jR, p1.x(t2, jR));
                    e0(t, i2);
                }
                break;
            case 12:
                if (y(t2, i2)) {
                    p1.M(t, jR, p1.x(t2, jR));
                    e0(t, i2);
                }
                break;
            case 13:
                if (y(t2, i2)) {
                    p1.M(t, jR, p1.x(t2, jR));
                    e0(t, i2);
                }
                break;
            case 14:
                if (y(t2, i2)) {
                    p1.N(t, jR, p1.y(t2, jR));
                    e0(t, i2);
                }
                break;
            case 15:
                if (y(t2, i2)) {
                    p1.M(t, jR, p1.x(t2, jR));
                    e0(t, i2);
                }
                break;
            case 16:
                if (y(t2, i2)) {
                    p1.N(t, jR, p1.y(t2, jR));
                    e0(t, i2);
                }
                break;
            case 17:
                K(t, t2, i2);
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
                this.p.d(t, t2, jR);
                break;
            case 50:
                h1.F(this.s, t, t2, jR);
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
                if (E(t2, iQ, i2)) {
                    p1.O(t, jR, p1.A(t2, jR));
                    f0(t, iQ, i2);
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
                if (E(t2, iQ, i2)) {
                    p1.O(t, jR, p1.A(t2, jR));
                    f0(t, iQ, i2);
                }
                break;
            case 68:
                L(t, t2, i2);
                break;
        }
    }

    static <T> t0<T> N(Class<T> cls, o0 o0Var, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        return o0Var instanceof d1 ? P((d1) o0Var, v0Var, g0Var, l1Var, qVar, l0Var) : O((j1) o0Var, v0Var, g0Var, l1Var, qVar, l0Var);
    }

    static <T> t0<T> O(j1 j1Var, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        boolean z = j1Var.c() == a1.PROTO3;
        t[] tVarArrE = j1Var.e();
        if (tVarArrE.length != 0) {
            t tVar = tVarArrE[0];
            throw null;
        }
        int length = tVarArrE.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (tVarArrE.length > 0) {
            t tVar2 = tVarArrE[0];
            throw null;
        }
        int[] iArrD = j1Var.d();
        if (iArrD == null) {
            iArrD = a;
        }
        if (tVarArrE.length > 0) {
            t tVar3 = tVarArrE[0];
            throw null;
        }
        int[] iArr2 = a;
        int[] iArr3 = a;
        int[] iArr4 = new int[iArrD.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrD, 0, iArr4, 0, iArrD.length);
        System.arraycopy(iArr2, 0, iArr4, iArrD.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrD.length + iArr2.length, iArr3.length);
        return new t0<>(iArr, objArr, 0, 0, j1Var.b(), z, true, iArr4, iArrD.length, iArrD.length + iArr2.length, v0Var, g0Var, l1Var, qVar, l0Var);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0277  */
    /* JADX WARN: Code duplicated, block: B:125:0x027a  */
    /* JADX WARN: Code duplicated, block: B:128:0x0292  */
    /* JADX WARN: Code duplicated, block: B:129:0x0295  */
    /* JADX WARN: Code duplicated, block: B:163:0x033d  */
    /* JADX WARN: Code duplicated, block: B:165:0x0342  */
    /* JADX WARN: Code duplicated, block: B:167:0x034d  */
    /* JADX WARN: Code duplicated, block: B:170:0x0359 A[LOOP:6: B:168:0x0351->B:170:0x0359, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:174:0x0376  */
    /* JADX WARN: Code duplicated, block: B:175:0x0379  */
    /* JADX WARN: Code duplicated, block: B:177:0x038c  */
    /* JADX WARN: Code duplicated, block: B:178:0x0392  */
    /* JADX WARN: Code duplicated, block: B:182:0x039f  */
    /* JADX WARN: Code duplicated, block: B:204:0x0363 A[EDGE_INSN: B:204:0x0363->B:171:0x0363 BREAK  A[LOOP:6: B:168:0x0351->B:170:0x0359], SYNTHETIC] */
    static <T> t0<T> P(d1 d1Var, v0 v0Var, g0 g0Var, l1<?, ?> l1Var, q<?> qVar, l0 l0Var) {
        int i2;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        char cCharAt;
        int i7;
        char cCharAt2;
        int i8;
        char cCharAt3;
        int i9;
        char cCharAt4;
        int i10;
        char cCharAt5;
        int i11;
        char cCharAt6;
        int i12;
        char cCharAt7;
        int i13;
        char cCharAt8;
        int i14;
        int i15;
        boolean z;
        int i16;
        int[] iArr2;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int i19;
        int i20;
        int iObjectFieldOffset2;
        int i21;
        int iCharAt4;
        int i22;
        Object obj;
        Field fieldD0;
        int i23;
        int i24;
        int i25;
        char cCharAt9;
        int i26;
        int i27;
        int i28;
        Object obj2;
        Field fieldD1;
        int i29;
        Object obj3;
        Field fieldD2;
        int i30;
        char cCharAt10;
        int i31;
        char cCharAt11;
        int i32;
        char cCharAt12;
        int i33;
        char cCharAt13;
        char cCharAt14;
        int i34 = 0;
        boolean z2 = d1Var.c() == a1.PROTO3;
        String strE = d1Var.e();
        int length = strE.length();
        int iCharAt5 = strE.charAt(0);
        if (iCharAt5 >= 55296) {
            int i35 = iCharAt5 & 8191;
            int i36 = 1;
            int i37 = 13;
            while (true) {
                i2 = i36 + 1;
                cCharAt14 = strE.charAt(i36);
                if (cCharAt14 < 55296) {
                    break;
                }
                i35 |= (cCharAt14 & 8191) << i37;
                i37 += 13;
                i36 = i2;
            }
            iCharAt5 = i35 | (cCharAt14 << i37);
        } else {
            i2 = 1;
        }
        int i38 = i2 + 1;
        int iCharAt6 = strE.charAt(i2);
        if (iCharAt6 >= 55296) {
            int i39 = iCharAt6 & 8191;
            int i40 = 13;
            while (true) {
                i33 = i38 + 1;
                cCharAt13 = strE.charAt(i38);
                if (cCharAt13 < 55296) {
                    break;
                }
                i39 |= (cCharAt13 & 8191) << i40;
                i40 += 13;
                i38 = i33;
            }
            iCharAt6 = i39 | (cCharAt13 << i40);
            i38 = i33;
        }
        if (iCharAt6 == 0) {
            iArr = a;
            i4 = 0;
            i5 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            iCharAt3 = 0;
        } else {
            int i41 = i38 + 1;
            int iCharAt7 = strE.charAt(i38);
            if (iCharAt7 >= 55296) {
                int i42 = iCharAt7 & 8191;
                int i43 = 13;
                while (true) {
                    i13 = i41 + 1;
                    cCharAt8 = strE.charAt(i41);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt8 & 8191) << i43;
                    i43 += 13;
                    i41 = i13;
                }
                iCharAt7 = i42 | (cCharAt8 << i43);
                i41 = i13;
            }
            int i44 = i41 + 1;
            int iCharAt8 = strE.charAt(i41);
            if (iCharAt8 >= 55296) {
                int i45 = iCharAt8 & 8191;
                int i46 = 13;
                while (true) {
                    i12 = i44 + 1;
                    cCharAt7 = strE.charAt(i44);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i12;
                }
                iCharAt8 = i45 | (cCharAt7 << i46);
                i44 = i12;
            }
            int i47 = i44 + 1;
            int iCharAt9 = strE.charAt(i44);
            if (iCharAt9 >= 55296) {
                int i48 = iCharAt9 & 8191;
                int i49 = 13;
                while (true) {
                    i11 = i47 + 1;
                    cCharAt6 = strE.charAt(i47);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i11;
                }
                iCharAt9 = i48 | (cCharAt6 << i49);
                i47 = i11;
            }
            int i50 = i47 + 1;
            iCharAt = strE.charAt(i47);
            if (iCharAt >= 55296) {
                int i51 = iCharAt & 8191;
                int i52 = 13;
                while (true) {
                    i10 = i50 + 1;
                    cCharAt5 = strE.charAt(i50);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i10;
                }
                iCharAt = i51 | (cCharAt5 << i52);
                i50 = i10;
            }
            int i53 = i50 + 1;
            iCharAt2 = strE.charAt(i50);
            if (iCharAt2 >= 55296) {
                int i54 = iCharAt2 & 8191;
                int i55 = 13;
                while (true) {
                    i9 = i53 + 1;
                    cCharAt4 = strE.charAt(i53);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i9;
                }
                iCharAt2 = i54 | (cCharAt4 << i55);
                i53 = i9;
            }
            int i56 = i53 + 1;
            int iCharAt10 = strE.charAt(i53);
            if (iCharAt10 >= 55296) {
                int i57 = iCharAt10 & 8191;
                int i58 = 13;
                while (true) {
                    i8 = i56 + 1;
                    cCharAt3 = strE.charAt(i56);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i8;
                }
                iCharAt10 = i57 | (cCharAt3 << i58);
                i56 = i8;
            }
            int i59 = i56 + 1;
            int iCharAt11 = strE.charAt(i56);
            if (iCharAt11 >= 55296) {
                int i60 = iCharAt11 & 8191;
                int i61 = 13;
                while (true) {
                    i7 = i59 + 1;
                    cCharAt2 = strE.charAt(i59);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt2 & 8191) << i61;
                    i61 += 13;
                    i59 = i7;
                }
                iCharAt11 = i60 | (cCharAt2 << i61);
                i59 = i7;
            }
            int i62 = i59 + 1;
            iCharAt3 = strE.charAt(i59);
            if (iCharAt3 >= 55296) {
                int i63 = iCharAt3 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i6 = i64 + 1;
                    cCharAt = strE.charAt(i64);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i63 |= (cCharAt & 8191) << i65;
                    i65 += 13;
                    i64 = i6;
                }
                iCharAt3 = i63 | (cCharAt << i65);
                i62 = i6;
            }
            int[] iArr3 = new int[iCharAt3 + iCharAt10 + iCharAt11];
            i3 = (iCharAt7 * 2) + iCharAt8;
            i4 = iCharAt7;
            i38 = i62;
            int i66 = iCharAt10;
            iArr = iArr3;
            i34 = iCharAt9;
            i5 = i66;
        }
        Unsafe unsafe = f1413b;
        Object[] objArrD = d1Var.d();
        Class<?> cls = d1Var.b().getClass();
        int[] iArr4 = new int[iCharAt2 * 3];
        Object[] objArr = new Object[iCharAt2 * 2];
        int i67 = iCharAt3 + i5;
        int i68 = iCharAt3;
        int i69 = i67;
        int i70 = 0;
        int i71 = 0;
        while (i38 < length) {
            int i72 = i38 + 1;
            int iCharAt12 = strE.charAt(i38);
            int i73 = length;
            if (iCharAt12 >= 55296) {
                int i74 = iCharAt12 & 8191;
                int i75 = i72;
                int i76 = 13;
                while (true) {
                    i32 = i75 + 1;
                    cCharAt12 = strE.charAt(i75);
                    i14 = iCharAt3;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i74 |= (cCharAt12 & 8191) << i76;
                    i76 += 13;
                    i75 = i32;
                    iCharAt3 = i14;
                }
                iCharAt12 = i74 | (cCharAt12 << i76);
                i15 = i32;
            } else {
                i14 = iCharAt3;
                i15 = i72;
            }
            int i77 = i15 + 1;
            int iCharAt13 = strE.charAt(i15);
            if (iCharAt13 >= 55296) {
                int i78 = iCharAt13 & 8191;
                int i79 = i77;
                int i80 = 13;
                while (true) {
                    i31 = i79 + 1;
                    cCharAt11 = strE.charAt(i79);
                    z = z2;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i78 |= (cCharAt11 & 8191) << i80;
                    i80 += 13;
                    i79 = i31;
                    z2 = z;
                }
                iCharAt13 = i78 | (cCharAt11 << i80);
                i16 = i31;
            } else {
                z = z2;
                i16 = i77;
            }
            int i81 = iCharAt13 & 255;
            int i82 = iCharAt;
            if ((iCharAt13 & 1024) != 0) {
                iArr[i70] = i71;
                i70++;
            }
            int i83 = i70;
            if (i81 >= 51) {
                int i84 = i16 + 1;
                int iCharAt14 = strE.charAt(i16);
                char c2 = 55296;
                if (iCharAt14 >= 55296) {
                    int i85 = iCharAt14 & 8191;
                    int i86 = 13;
                    while (true) {
                        i30 = i84 + 1;
                        cCharAt10 = strE.charAt(i84);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i85 |= (cCharAt10 & 8191) << i86;
                        i86 += 13;
                        i84 = i30;
                        c2 = 55296;
                    }
                    iCharAt14 = i85 | (cCharAt10 << i86);
                    i84 = i30;
                }
                int i87 = i81 - 51;
                int i88 = i84;
                if (i87 == 9 || i87 == 17) {
                    i27 = i3 + 1;
                    objArr[((i71 / 3) * 2) + 1] = objArrD[i3];
                } else {
                    if (i87 == 12 && (iCharAt5 & 1) == 1) {
                        i27 = i3 + 1;
                        objArr[((i71 / 3) * 2) + 1] = objArrD[i3];
                    }
                    i28 = iCharAt14 * 2;
                    obj2 = objArrD[i28];
                    if (obj2 instanceof Field) {
                        fieldD1 = (Field) obj2;
                    } else {
                        fieldD1 = d0(cls, (String) obj2);
                        objArrD[i28] = fieldD1;
                    }
                    iArr2 = iArr4;
                    i17 = iCharAt12;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldD1);
                    i29 = i28 + 1;
                    obj3 = objArrD[i29];
                    if (obj3 instanceof Field) {
                        fieldD2 = (Field) obj3;
                    } else {
                        fieldD2 = d0(cls, (String) obj3);
                        objArrD[i29] = fieldD2;
                    }
                    strE = strE;
                    cls = cls;
                    iCharAt5 = iCharAt5;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldD2);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i19 = i81;
                    i18 = i3;
                    i20 = i88;
                    i21 = 0;
                }
                i3 = i27;
                i28 = iCharAt14 * 2;
                obj2 = objArrD[i28];
                if (obj2 instanceof Field) {
                    fieldD1 = (Field) obj2;
                } else {
                    fieldD1 = d0(cls, (String) obj2);
                    objArrD[i28] = fieldD1;
                }
                iArr2 = iArr4;
                i17 = iCharAt12;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldD1);
                i29 = i28 + 1;
                obj3 = objArrD[i29];
                if (obj3 instanceof Field) {
                    fieldD2 = (Field) obj3;
                } else {
                    fieldD2 = d0(cls, (String) obj3);
                    objArrD[i29] = fieldD2;
                }
                strE = strE;
                cls = cls;
                iCharAt5 = iCharAt5;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldD2);
                iObjectFieldOffset = iObjectFieldOffset4;
                i19 = i81;
                i18 = i3;
                i20 = i88;
                i21 = 0;
            } else {
                iArr2 = iArr4;
                i17 = iCharAt12;
                i18 = i3 + 1;
                Field fieldD3 = d0(cls, (String) objArrD[i3]);
                if (i81 == 9 || i81 == 17) {
                    objArr[((i71 / 3) * 2) + 1] = fieldD3.getType();
                } else {
                    if (i81 == 27 || i81 == 49) {
                        i26 = i18 + 1;
                        objArr[((i71 / 3) * 2) + 1] = objArrD[i18];
                    } else if (i81 == 12 || i81 == 30 || i81 == 44) {
                        if ((iCharAt5 & 1) == 1) {
                            i26 = i18 + 1;
                            objArr[((i71 / 3) * 2) + 1] = objArrD[i18];
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldD3);
                        if ((iCharAt5 & 1) == 1) {
                            i19 = i81;
                            if (i19 <= 17) {
                                i20 = i16 + 1;
                                iCharAt4 = strE.charAt(i16);
                                if (iCharAt4 >= 55296) {
                                    i23 = iCharAt4 & 8191;
                                    i24 = 13;
                                    while (true) {
                                        i25 = i20 + 1;
                                        cCharAt9 = strE.charAt(i20);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i23 |= (cCharAt9 & 8191) << i24;
                                        i24 += 13;
                                        i20 = i25;
                                    }
                                    iCharAt4 = i23 | (cCharAt9 << i24);
                                    i20 = i25;
                                }
                                i22 = (i4 * 2) + (iCharAt4 / 32);
                                obj = objArrD[i22];
                                strE = strE;
                                if (obj instanceof Field) {
                                    fieldD0 = (Field) obj;
                                } else {
                                    fieldD0 = d0(cls, (String) obj);
                                    objArrD[i22] = fieldD0;
                                }
                                cls = cls;
                                iCharAt5 = iCharAt5;
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldD0);
                                i21 = iCharAt4 % 32;
                            }
                            if (i19 >= 18 && i19 <= 49) {
                                iArr[i69] = iObjectFieldOffset;
                                i69++;
                            }
                        } else {
                            i19 = i81;
                        }
                        i20 = i16;
                        iObjectFieldOffset2 = 0;
                        i21 = 0;
                        if (i19 >= 18) {
                            iArr[i69] = iObjectFieldOffset;
                            i69++;
                        }
                    } else if (i81 == 50) {
                        int i89 = i68 + 1;
                        iArr[i68] = i71;
                        int i90 = (i71 / 3) * 2;
                        int i91 = i18 + 1;
                        objArr[i90] = objArrD[i18];
                        if ((iCharAt13 & RecyclerView.l.FLAG_MOVED) != 0) {
                            i18 = i91 + 1;
                            objArr[i90 + 1] = objArrD[i91];
                            i68 = i89;
                        } else {
                            i68 = i89;
                            i18 = i91;
                        }
                    }
                    i18 = i26;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldD3);
                    if ((iCharAt5 & 1) == 1) {
                        i19 = i81;
                        if (i19 <= 17) {
                            i20 = i16 + 1;
                            iCharAt4 = strE.charAt(i16);
                            if (iCharAt4 >= 55296) {
                                i23 = iCharAt4 & 8191;
                                i24 = 13;
                                while (true) {
                                    i25 = i20 + 1;
                                    cCharAt9 = strE.charAt(i20);
                                    if (cCharAt9 < 55296) {
                                        break;
                                        break;
                                    }
                                    i23 |= (cCharAt9 & 8191) << i24;
                                    i24 += 13;
                                    i20 = i25;
                                }
                                iCharAt4 = i23 | (cCharAt9 << i24);
                                i20 = i25;
                            }
                            i22 = (i4 * 2) + (iCharAt4 / 32);
                            obj = objArrD[i22];
                            strE = strE;
                            if (obj instanceof Field) {
                                fieldD0 = (Field) obj;
                            } else {
                                fieldD0 = d0(cls, (String) obj);
                                objArrD[i22] = fieldD0;
                            }
                            cls = cls;
                            iCharAt5 = iCharAt5;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldD0);
                            i21 = iCharAt4 % 32;
                        }
                        if (i19 >= 18) {
                            iArr[i69] = iObjectFieldOffset;
                            i69++;
                        }
                    } else {
                        i19 = i81;
                    }
                    i20 = i16;
                    iObjectFieldOffset2 = 0;
                    i21 = 0;
                    if (i19 >= 18) {
                        iArr[i69] = iObjectFieldOffset;
                        i69++;
                    }
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldD3);
                if ((iCharAt5 & 1) == 1) {
                    i19 = i81;
                    if (i19 <= 17) {
                        i20 = i16 + 1;
                        iCharAt4 = strE.charAt(i16);
                        if (iCharAt4 >= 55296) {
                            i23 = iCharAt4 & 8191;
                            i24 = 13;
                            while (true) {
                                i25 = i20 + 1;
                                cCharAt9 = strE.charAt(i20);
                                if (cCharAt9 < 55296) {
                                    break;
                                    break;
                                }
                                i23 |= (cCharAt9 & 8191) << i24;
                                i24 += 13;
                                i20 = i25;
                            }
                            iCharAt4 = i23 | (cCharAt9 << i24);
                            i20 = i25;
                        }
                        i22 = (i4 * 2) + (iCharAt4 / 32);
                        obj = objArrD[i22];
                        strE = strE;
                        if (obj instanceof Field) {
                            fieldD0 = (Field) obj;
                        } else {
                            fieldD0 = d0(cls, (String) obj);
                            objArrD[i22] = fieldD0;
                        }
                        cls = cls;
                        iCharAt5 = iCharAt5;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldD0);
                        i21 = iCharAt4 % 32;
                    }
                    if (i19 >= 18) {
                        iArr[i69] = iObjectFieldOffset;
                        i69++;
                    }
                } else {
                    i19 = i81;
                }
                i20 = i16;
                iObjectFieldOffset2 = 0;
                i21 = 0;
                if (i19 >= 18) {
                    iArr[i69] = iObjectFieldOffset;
                    i69++;
                }
            }
            int i92 = i71 + 1;
            iArr2[i71] = i17;
            int i93 = i92 + 1;
            int i94 = iCharAt5;
            iArr2[i92] = ((iCharAt13 & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 ? 536870912 : 0) | ((iCharAt13 & 256) != 0 ? 268435456 : 0) | (i19 << 20) | iObjectFieldOffset;
            int i95 = i93 + 1;
            iArr2[i93] = (i21 << 20) | iObjectFieldOffset2;
            i38 = i20;
            cls = cls;
            iCharAt5 = i94;
            length = i73;
            iCharAt3 = i14;
            z2 = z;
            i70 = i83;
            i71 = i95;
            i3 = i18;
            iArr4 = iArr2;
            iCharAt = i82;
            strE = strE;
        }
        return new t0<>(iArr4, objArr, i34, iCharAt, d1Var.b(), z2, false, iArr, iCharAt3, i67, v0Var, g0Var, l1Var, qVar, l0Var);
    }

    private int Q(int i2) {
        return this.f1414c[i2];
    }

    private static long R(int i2) {
        return i2 & 1048575;
    }

    private static <T> boolean S(T t, long j2) {
        return ((Boolean) p1.A(t, j2)).booleanValue();
    }

    private static <T> double T(T t, long j2) {
        return ((Double) p1.A(t, j2)).doubleValue();
    }

    private static <T> float U(T t, long j2) {
        return ((Float) p1.A(t, j2)).floatValue();
    }

    private static <T> int V(T t, long j2) {
        return ((Integer) p1.A(t, j2)).intValue();
    }

    private static <T> long W(T t, long j2) {
        return ((Long) p1.A(t, j2)).longValue();
    }

    private int X(int i2) {
        if (i2 < this.f1416e || i2 > this.f1417f) {
            return -1;
        }
        return g0(i2, 0);
    }

    private int Y(int i2) {
        return this.f1414c[i2 + 2];
    }

    private <E> void Z(Object obj, long j2, e1 e1Var, f1<E> f1Var, p pVar) throws IOException {
        e1Var.F(this.p.e(obj, j2), f1Var, pVar);
    }

    private <E> void a0(Object obj, int i2, e1 e1Var, f1<E> f1Var, p pVar) throws IOException {
        e1Var.K(this.p.e(obj, R(i2)), f1Var, pVar);
    }

    private void b0(Object obj, int i2, e1 e1Var) throws IOException {
        if (x(i2)) {
            p1.O(obj, R(i2), e1Var.M());
        } else if (this.f1420i) {
            p1.O(obj, R(i2), e1Var.a());
        } else {
            p1.O(obj, R(i2), e1Var.C());
        }
    }

    private void c0(Object obj, int i2, e1 e1Var) throws IOException {
        if (x(i2)) {
            e1Var.B(this.p.e(obj, R(i2)));
        } else {
            e1Var.b(this.p.e(obj, R(i2)));
        }
    }

    private static Field d0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void e0(T t, int i2) {
        if (this.f1421j) {
            return;
        }
        int iY = Y(i2);
        long j2 = iY & 1048575;
        p1.M(t, j2, p1.x(t, j2) | (1 << (iY >>> 20)));
    }

    private void f0(T t, int i2, int i3) {
        p1.M(t, Y(i3) & 1048575, i2);
    }

    private int g0(int i2, int i3) {
        int length = (this.f1414c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int iQ = Q(i5);
            if (i2 == iQ) {
                return i5;
            }
            if (i2 < iQ) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    private static int h0(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    private int i0(int i2) {
        return this.f1414c[i2 + 1];
    }

    private boolean j(T t, T t2, int i2) {
        return y(t, i2) == y(t2, i2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void j0(T t, s1 s1Var) throws IOException {
        Iterator itS;
        Map.Entry<?, ?> entry;
        Map.Entry<?, ?> entry2;
        int i2;
        if (this.f1419h) {
            u<T> uVarC = this.r.c(t);
            if (uVarC.n()) {
                itS = null;
                entry = null;
            } else {
                itS = uVarC.s();
                entry = (Map.Entry) itS.next();
            }
        } else {
            itS = null;
            entry = null;
        }
        int i3 = -1;
        int length = this.f1414c.length;
        Unsafe unsafe = f1413b;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iI0 = i0(i4);
            int iQ = Q(i4);
            int iH0 = h0(iI0);
            if (this.f1421j || iH0 > 17) {
                entry2 = entry;
                i2 = 0;
            } else {
                int i6 = this.f1414c[i4 + 2];
                int i7 = i6 & 1048575;
                Map.Entry<?, ?> entry3 = entry;
                if (i7 != i3) {
                    i5 = unsafe.getInt(t, i7);
                    i3 = i7;
                }
                i2 = 1 << (i6 >>> 20);
                entry2 = entry3;
            }
            while (entry2 != null && this.r.a(entry2) <= iQ) {
                this.r.j(s1Var, entry2);
                entry2 = itS.hasNext() ? (Map.Entry) itS.next() : null;
            }
            Map.Entry<?, ?> entry4 = entry2;
            int i8 = i3;
            long jR = R(iI0);
            switch (iH0) {
                case 0:
                    if ((i2 & i5) != 0) {
                        s1Var.e(iQ, l(t, jR));
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 1:
                    if ((i2 & i5) != 0) {
                        s1Var.E(iQ, p(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 2:
                    if ((i2 & i5) != 0) {
                        s1Var.p(iQ, unsafe.getLong(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 3:
                    if ((i2 & i5) != 0) {
                        s1Var.n(iQ, unsafe.getLong(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 4:
                    if ((i2 & i5) != 0) {
                        s1Var.t(iQ, unsafe.getInt(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 5:
                    if ((i2 & i5) != 0) {
                        s1Var.h(iQ, unsafe.getLong(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 6:
                    if ((i2 & i5) != 0) {
                        s1Var.d(iQ, unsafe.getInt(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 7:
                    if ((i2 & i5) != 0) {
                        s1Var.q(iQ, k(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 8:
                    if ((i2 & i5) != 0) {
                        n0(iQ, unsafe.getObject(t, jR), s1Var);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 9:
                    if ((i2 & i5) != 0) {
                        s1Var.z(iQ, unsafe.getObject(t, jR), s(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 10:
                    if ((i2 & i5) != 0) {
                        s1Var.w(iQ, (h) unsafe.getObject(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 11:
                    if ((i2 & i5) != 0) {
                        s1Var.b(iQ, unsafe.getInt(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 12:
                    if ((i2 & i5) != 0) {
                        s1Var.H(iQ, unsafe.getInt(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 13:
                    if ((i2 & i5) != 0) {
                        s1Var.r(iQ, unsafe.getInt(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 14:
                    if ((i2 & i5) != 0) {
                        s1Var.x(iQ, unsafe.getLong(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 15:
                    if ((i2 & i5) != 0) {
                        s1Var.M(iQ, unsafe.getInt(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 16:
                    if ((i2 & i5) != 0) {
                        s1Var.D(iQ, unsafe.getLong(t, jR));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 17:
                    if ((i2 & i5) != 0) {
                        s1Var.O(iQ, unsafe.getObject(t, jR), s(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 18:
                    h1.P(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 19:
                    h1.T(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 20:
                    h1.W(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 21:
                    h1.e0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 22:
                    h1.V(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 23:
                    h1.S(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 24:
                    h1.R(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 25:
                    h1.N(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 26:
                    h1.c0(Q(i4), (List) unsafe.getObject(t, jR), s1Var);
                    break;
                case 27:
                    h1.X(Q(i4), (List) unsafe.getObject(t, jR), s1Var, s(i4));
                    break;
                case 28:
                    h1.O(Q(i4), (List) unsafe.getObject(t, jR), s1Var);
                    break;
                case 29:
                    h1.d0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 30:
                    h1.Q(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 31:
                    h1.Y(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 32:
                    h1.Z(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 33:
                    h1.a0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 34:
                    h1.b0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, false);
                    continue;
                    i4 += 3;
                    i3 = i8;
                    entry = entry4;
                    break;
                case 35:
                    h1.P(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 36:
                    h1.T(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 37:
                    h1.W(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 38:
                    h1.e0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 39:
                    h1.V(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 40:
                    h1.S(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 41:
                    h1.R(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 42:
                    h1.N(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 43:
                    h1.d0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 44:
                    h1.Q(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 45:
                    h1.Y(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 46:
                    h1.Z(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 47:
                    h1.a0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 48:
                    h1.b0(Q(i4), (List) unsafe.getObject(t, jR), s1Var, true);
                    break;
                case 49:
                    h1.U(Q(i4), (List) unsafe.getObject(t, jR), s1Var, s(i4));
                    break;
                case 50:
                    m0(s1Var, iQ, unsafe.getObject(t, jR), i4);
                    break;
                case 51:
                    if (E(t, iQ, i4)) {
                        s1Var.e(iQ, T(t, jR));
                    }
                    break;
                case 52:
                    if (E(t, iQ, i4)) {
                        s1Var.E(iQ, U(t, jR));
                    }
                    break;
                case 53:
                    if (E(t, iQ, i4)) {
                        s1Var.p(iQ, W(t, jR));
                    }
                    break;
                case 54:
                    if (E(t, iQ, i4)) {
                        s1Var.n(iQ, W(t, jR));
                    }
                    break;
                case 55:
                    if (E(t, iQ, i4)) {
                        s1Var.t(iQ, V(t, jR));
                    }
                    break;
                case 56:
                    if (E(t, iQ, i4)) {
                        s1Var.h(iQ, W(t, jR));
                    }
                    break;
                case 57:
                    if (E(t, iQ, i4)) {
                        s1Var.d(iQ, V(t, jR));
                    }
                    break;
                case 58:
                    if (E(t, iQ, i4)) {
                        s1Var.q(iQ, S(t, jR));
                    }
                    break;
                case 59:
                    if (E(t, iQ, i4)) {
                        n0(iQ, unsafe.getObject(t, jR), s1Var);
                    }
                    break;
                case 60:
                    if (E(t, iQ, i4)) {
                        s1Var.z(iQ, unsafe.getObject(t, jR), s(i4));
                    }
                    break;
                case 61:
                    if (E(t, iQ, i4)) {
                        s1Var.w(iQ, (h) unsafe.getObject(t, jR));
                    }
                    break;
                case 62:
                    if (E(t, iQ, i4)) {
                        s1Var.b(iQ, V(t, jR));
                    }
                    break;
                case 63:
                    if (E(t, iQ, i4)) {
                        s1Var.H(iQ, V(t, jR));
                    }
                    break;
                case 64:
                    if (E(t, iQ, i4)) {
                        s1Var.r(iQ, V(t, jR));
                    }
                    break;
                case 65:
                    if (E(t, iQ, i4)) {
                        s1Var.x(iQ, W(t, jR));
                    }
                    break;
                case 66:
                    if (E(t, iQ, i4)) {
                        s1Var.M(iQ, V(t, jR));
                    }
                    break;
                case 67:
                    if (E(t, iQ, i4)) {
                        s1Var.D(iQ, W(t, jR));
                    }
                    break;
                case 68:
                    if (E(t, iQ, i4)) {
                        s1Var.O(iQ, unsafe.getObject(t, jR), s(i4));
                    }
                    break;
            }
            i4 += 3;
            i3 = i8;
            entry = entry4;
        }
        while (entry != null) {
            this.r.j(s1Var, entry);
            entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
        }
        o0(this.q, t, s1Var);
    }

    private static <T> boolean k(T t, long j2) {
        return p1.p(t, j2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    private void k0(T t, s1 s1Var) throws IOException {
        Iterator itS;
        Map.Entry<?, ?> entry;
        if (this.f1419h) {
            u<T> uVarC = this.r.c(t);
            if (uVarC.n()) {
                itS = null;
                entry = null;
            } else {
                itS = uVarC.s();
                entry = (Map.Entry) itS.next();
            }
        } else {
            itS = null;
            entry = null;
        }
        int length = this.f1414c.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int iI0 = i0(i2);
            int iQ = Q(i2);
            while (entry != null && this.r.a(entry) <= iQ) {
                this.r.j(s1Var, entry);
                entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
            }
            switch (h0(iI0)) {
                case 0:
                    if (y(t, i2)) {
                        s1Var.e(iQ, l(t, R(iI0)));
                    }
                    break;
                case 1:
                    if (y(t, i2)) {
                        s1Var.E(iQ, p(t, R(iI0)));
                    }
                    break;
                case 2:
                    if (y(t, i2)) {
                        s1Var.p(iQ, H(t, R(iI0)));
                    }
                    break;
                case 3:
                    if (y(t, i2)) {
                        s1Var.n(iQ, H(t, R(iI0)));
                    }
                    break;
                case 4:
                    if (y(t, i2)) {
                        s1Var.t(iQ, w(t, R(iI0)));
                    }
                    break;
                case 5:
                    if (y(t, i2)) {
                        s1Var.h(iQ, H(t, R(iI0)));
                    }
                    break;
                case 6:
                    if (y(t, i2)) {
                        s1Var.d(iQ, w(t, R(iI0)));
                    }
                    break;
                case 7:
                    if (y(t, i2)) {
                        s1Var.q(iQ, k(t, R(iI0)));
                    }
                    break;
                case 8:
                    if (y(t, i2)) {
                        n0(iQ, p1.A(t, R(iI0)), s1Var);
                    }
                    break;
                case 9:
                    if (y(t, i2)) {
                        s1Var.z(iQ, p1.A(t, R(iI0)), s(i2));
                    }
                    break;
                case 10:
                    if (y(t, i2)) {
                        s1Var.w(iQ, (h) p1.A(t, R(iI0)));
                    }
                    break;
                case 11:
                    if (y(t, i2)) {
                        s1Var.b(iQ, w(t, R(iI0)));
                    }
                    break;
                case 12:
                    if (y(t, i2)) {
                        s1Var.H(iQ, w(t, R(iI0)));
                    }
                    break;
                case 13:
                    if (y(t, i2)) {
                        s1Var.r(iQ, w(t, R(iI0)));
                    }
                    break;
                case 14:
                    if (y(t, i2)) {
                        s1Var.x(iQ, H(t, R(iI0)));
                    }
                    break;
                case 15:
                    if (y(t, i2)) {
                        s1Var.M(iQ, w(t, R(iI0)));
                    }
                    break;
                case 16:
                    if (y(t, i2)) {
                        s1Var.D(iQ, H(t, R(iI0)));
                    }
                    break;
                case 17:
                    if (y(t, i2)) {
                        s1Var.O(iQ, p1.A(t, R(iI0)), s(i2));
                    }
                    break;
                case 18:
                    h1.P(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 19:
                    h1.T(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 20:
                    h1.W(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 21:
                    h1.e0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 22:
                    h1.V(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 23:
                    h1.S(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 24:
                    h1.R(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 25:
                    h1.N(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 26:
                    h1.c0(Q(i2), (List) p1.A(t, R(iI0)), s1Var);
                    break;
                case 27:
                    h1.X(Q(i2), (List) p1.A(t, R(iI0)), s1Var, s(i2));
                    break;
                case 28:
                    h1.O(Q(i2), (List) p1.A(t, R(iI0)), s1Var);
                    break;
                case 29:
                    h1.d0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 30:
                    h1.Q(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 31:
                    h1.Y(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 32:
                    h1.Z(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 33:
                    h1.a0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 34:
                    h1.b0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 35:
                    h1.P(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 36:
                    h1.T(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 37:
                    h1.W(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 38:
                    h1.e0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 39:
                    h1.V(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 40:
                    h1.S(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 41:
                    h1.R(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 42:
                    h1.N(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 43:
                    h1.d0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 44:
                    h1.Q(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 45:
                    h1.Y(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 46:
                    h1.Z(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 47:
                    h1.a0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 48:
                    h1.b0(Q(i2), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 49:
                    h1.U(Q(i2), (List) p1.A(t, R(iI0)), s1Var, s(i2));
                    break;
                case 50:
                    m0(s1Var, iQ, p1.A(t, R(iI0)), i2);
                    break;
                case 51:
                    if (E(t, iQ, i2)) {
                        s1Var.e(iQ, T(t, R(iI0)));
                    }
                    break;
                case 52:
                    if (E(t, iQ, i2)) {
                        s1Var.E(iQ, U(t, R(iI0)));
                    }
                    break;
                case 53:
                    if (E(t, iQ, i2)) {
                        s1Var.p(iQ, W(t, R(iI0)));
                    }
                    break;
                case 54:
                    if (E(t, iQ, i2)) {
                        s1Var.n(iQ, W(t, R(iI0)));
                    }
                    break;
                case 55:
                    if (E(t, iQ, i2)) {
                        s1Var.t(iQ, V(t, R(iI0)));
                    }
                    break;
                case 56:
                    if (E(t, iQ, i2)) {
                        s1Var.h(iQ, W(t, R(iI0)));
                    }
                    break;
                case 57:
                    if (E(t, iQ, i2)) {
                        s1Var.d(iQ, V(t, R(iI0)));
                    }
                    break;
                case 58:
                    if (E(t, iQ, i2)) {
                        s1Var.q(iQ, S(t, R(iI0)));
                    }
                    break;
                case 59:
                    if (E(t, iQ, i2)) {
                        n0(iQ, p1.A(t, R(iI0)), s1Var);
                    }
                    break;
                case 60:
                    if (E(t, iQ, i2)) {
                        s1Var.z(iQ, p1.A(t, R(iI0)), s(i2));
                    }
                    break;
                case 61:
                    if (E(t, iQ, i2)) {
                        s1Var.w(iQ, (h) p1.A(t, R(iI0)));
                    }
                    break;
                case 62:
                    if (E(t, iQ, i2)) {
                        s1Var.b(iQ, V(t, R(iI0)));
                    }
                    break;
                case 63:
                    if (E(t, iQ, i2)) {
                        s1Var.H(iQ, V(t, R(iI0)));
                    }
                    break;
                case 64:
                    if (E(t, iQ, i2)) {
                        s1Var.r(iQ, V(t, R(iI0)));
                    }
                    break;
                case 65:
                    if (E(t, iQ, i2)) {
                        s1Var.x(iQ, W(t, R(iI0)));
                    }
                    break;
                case 66:
                    if (E(t, iQ, i2)) {
                        s1Var.M(iQ, V(t, R(iI0)));
                    }
                    break;
                case 67:
                    if (E(t, iQ, i2)) {
                        s1Var.D(iQ, W(t, R(iI0)));
                    }
                    break;
                case 68:
                    if (E(t, iQ, i2)) {
                        s1Var.O(iQ, p1.A(t, R(iI0)), s(i2));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.r.j(s1Var, entry);
            entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
        }
        o0(this.q, t, s1Var);
    }

    private static <T> double l(T t, long j2) {
        return p1.v(t, j2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void l0(T t, s1 s1Var) throws IOException {
        Iterator itG;
        Map.Entry<?, ?> entry;
        o0(this.q, t, s1Var);
        if (this.f1419h) {
            u<T> uVarC = this.r.c(t);
            if (uVarC.n()) {
                itG = null;
                entry = null;
            } else {
                itG = uVarC.g();
                entry = (Map.Entry) itG.next();
            }
        } else {
            itG = null;
            entry = null;
        }
        for (int length = this.f1414c.length - 3; length >= 0; length -= 3) {
            int iI0 = i0(length);
            int iQ = Q(length);
            while (entry != null && this.r.a(entry) > iQ) {
                this.r.j(s1Var, entry);
                entry = itG.hasNext() ? (Map.Entry) itG.next() : null;
            }
            switch (h0(iI0)) {
                case 0:
                    if (y(t, length)) {
                        s1Var.e(iQ, l(t, R(iI0)));
                    }
                    break;
                case 1:
                    if (y(t, length)) {
                        s1Var.E(iQ, p(t, R(iI0)));
                    }
                    break;
                case 2:
                    if (y(t, length)) {
                        s1Var.p(iQ, H(t, R(iI0)));
                    }
                    break;
                case 3:
                    if (y(t, length)) {
                        s1Var.n(iQ, H(t, R(iI0)));
                    }
                    break;
                case 4:
                    if (y(t, length)) {
                        s1Var.t(iQ, w(t, R(iI0)));
                    }
                    break;
                case 5:
                    if (y(t, length)) {
                        s1Var.h(iQ, H(t, R(iI0)));
                    }
                    break;
                case 6:
                    if (y(t, length)) {
                        s1Var.d(iQ, w(t, R(iI0)));
                    }
                    break;
                case 7:
                    if (y(t, length)) {
                        s1Var.q(iQ, k(t, R(iI0)));
                    }
                    break;
                case 8:
                    if (y(t, length)) {
                        n0(iQ, p1.A(t, R(iI0)), s1Var);
                    }
                    break;
                case 9:
                    if (y(t, length)) {
                        s1Var.z(iQ, p1.A(t, R(iI0)), s(length));
                    }
                    break;
                case 10:
                    if (y(t, length)) {
                        s1Var.w(iQ, (h) p1.A(t, R(iI0)));
                    }
                    break;
                case 11:
                    if (y(t, length)) {
                        s1Var.b(iQ, w(t, R(iI0)));
                    }
                    break;
                case 12:
                    if (y(t, length)) {
                        s1Var.H(iQ, w(t, R(iI0)));
                    }
                    break;
                case 13:
                    if (y(t, length)) {
                        s1Var.r(iQ, w(t, R(iI0)));
                    }
                    break;
                case 14:
                    if (y(t, length)) {
                        s1Var.x(iQ, H(t, R(iI0)));
                    }
                    break;
                case 15:
                    if (y(t, length)) {
                        s1Var.M(iQ, w(t, R(iI0)));
                    }
                    break;
                case 16:
                    if (y(t, length)) {
                        s1Var.D(iQ, H(t, R(iI0)));
                    }
                    break;
                case 17:
                    if (y(t, length)) {
                        s1Var.O(iQ, p1.A(t, R(iI0)), s(length));
                    }
                    break;
                case 18:
                    h1.P(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 19:
                    h1.T(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 20:
                    h1.W(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 21:
                    h1.e0(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 22:
                    h1.V(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 23:
                    h1.S(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 24:
                    h1.R(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 25:
                    h1.N(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 26:
                    h1.c0(Q(length), (List) p1.A(t, R(iI0)), s1Var);
                    break;
                case 27:
                    h1.X(Q(length), (List) p1.A(t, R(iI0)), s1Var, s(length));
                    break;
                case 28:
                    h1.O(Q(length), (List) p1.A(t, R(iI0)), s1Var);
                    break;
                case 29:
                    h1.d0(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 30:
                    h1.Q(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 31:
                    h1.Y(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 32:
                    h1.Z(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 33:
                    h1.a0(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 34:
                    h1.b0(Q(length), (List) p1.A(t, R(iI0)), s1Var, false);
                    break;
                case 35:
                    h1.P(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 36:
                    h1.T(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 37:
                    h1.W(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 38:
                    h1.e0(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 39:
                    h1.V(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 40:
                    h1.S(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 41:
                    h1.R(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 42:
                    h1.N(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 43:
                    h1.d0(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 44:
                    h1.Q(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 45:
                    h1.Y(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 46:
                    h1.Z(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 47:
                    h1.a0(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 48:
                    h1.b0(Q(length), (List) p1.A(t, R(iI0)), s1Var, true);
                    break;
                case 49:
                    h1.U(Q(length), (List) p1.A(t, R(iI0)), s1Var, s(length));
                    break;
                case 50:
                    m0(s1Var, iQ, p1.A(t, R(iI0)), length);
                    break;
                case 51:
                    if (E(t, iQ, length)) {
                        s1Var.e(iQ, T(t, R(iI0)));
                    }
                    break;
                case 52:
                    if (E(t, iQ, length)) {
                        s1Var.E(iQ, U(t, R(iI0)));
                    }
                    break;
                case 53:
                    if (E(t, iQ, length)) {
                        s1Var.p(iQ, W(t, R(iI0)));
                    }
                    break;
                case 54:
                    if (E(t, iQ, length)) {
                        s1Var.n(iQ, W(t, R(iI0)));
                    }
                    break;
                case 55:
                    if (E(t, iQ, length)) {
                        s1Var.t(iQ, V(t, R(iI0)));
                    }
                    break;
                case 56:
                    if (E(t, iQ, length)) {
                        s1Var.h(iQ, W(t, R(iI0)));
                    }
                    break;
                case 57:
                    if (E(t, iQ, length)) {
                        s1Var.d(iQ, V(t, R(iI0)));
                    }
                    break;
                case 58:
                    if (E(t, iQ, length)) {
                        s1Var.q(iQ, S(t, R(iI0)));
                    }
                    break;
                case 59:
                    if (E(t, iQ, length)) {
                        n0(iQ, p1.A(t, R(iI0)), s1Var);
                    }
                    break;
                case 60:
                    if (E(t, iQ, length)) {
                        s1Var.z(iQ, p1.A(t, R(iI0)), s(length));
                    }
                    break;
                case 61:
                    if (E(t, iQ, length)) {
                        s1Var.w(iQ, (h) p1.A(t, R(iI0)));
                    }
                    break;
                case 62:
                    if (E(t, iQ, length)) {
                        s1Var.b(iQ, V(t, R(iI0)));
                    }
                    break;
                case 63:
                    if (E(t, iQ, length)) {
                        s1Var.H(iQ, V(t, R(iI0)));
                    }
                    break;
                case 64:
                    if (E(t, iQ, length)) {
                        s1Var.r(iQ, V(t, R(iI0)));
                    }
                    break;
                case 65:
                    if (E(t, iQ, length)) {
                        s1Var.x(iQ, W(t, R(iI0)));
                    }
                    break;
                case 66:
                    if (E(t, iQ, length)) {
                        s1Var.M(iQ, V(t, R(iI0)));
                    }
                    break;
                case 67:
                    if (E(t, iQ, length)) {
                        s1Var.D(iQ, W(t, R(iI0)));
                    }
                    break;
                case 68:
                    if (E(t, iQ, length)) {
                        s1Var.O(iQ, p1.A(t, R(iI0)), s(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.r.j(s1Var, entry);
            entry = itG.hasNext() ? (Map.Entry) itG.next() : null;
        }
    }

    private boolean m(T t, T t2, int i2) {
        int iI0 = i0(i2);
        long jR = R(iI0);
        switch (h0(iI0)) {
            case 0:
                return j(t, t2, i2) && Double.doubleToLongBits(p1.v(t, jR)) == Double.doubleToLongBits(p1.v(t2, jR));
            case 1:
                return j(t, t2, i2) && Float.floatToIntBits(p1.w(t, jR)) == Float.floatToIntBits(p1.w(t2, jR));
            case 2:
                return j(t, t2, i2) && p1.y(t, jR) == p1.y(t2, jR);
            case 3:
                return j(t, t2, i2) && p1.y(t, jR) == p1.y(t2, jR);
            case 4:
                return j(t, t2, i2) && p1.x(t, jR) == p1.x(t2, jR);
            case 5:
                return j(t, t2, i2) && p1.y(t, jR) == p1.y(t2, jR);
            case 6:
                return j(t, t2, i2) && p1.x(t, jR) == p1.x(t2, jR);
            case 7:
                return j(t, t2, i2) && p1.p(t, jR) == p1.p(t2, jR);
            case 8:
                return j(t, t2, i2) && h1.K(p1.A(t, jR), p1.A(t2, jR));
            case 9:
                return j(t, t2, i2) && h1.K(p1.A(t, jR), p1.A(t2, jR));
            case 10:
                return j(t, t2, i2) && h1.K(p1.A(t, jR), p1.A(t2, jR));
            case 11:
                return j(t, t2, i2) && p1.x(t, jR) == p1.x(t2, jR);
            case 12:
                return j(t, t2, i2) && p1.x(t, jR) == p1.x(t2, jR);
            case 13:
                return j(t, t2, i2) && p1.x(t, jR) == p1.x(t2, jR);
            case 14:
                return j(t, t2, i2) && p1.y(t, jR) == p1.y(t2, jR);
            case 15:
                return j(t, t2, i2) && p1.x(t, jR) == p1.x(t2, jR);
            case 16:
                return j(t, t2, i2) && p1.y(t, jR) == p1.y(t2, jR);
            case 17:
                return j(t, t2, i2) && h1.K(p1.A(t, jR), p1.A(t2, jR));
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
                return h1.K(p1.A(t, jR), p1.A(t2, jR));
            case 50:
                return h1.K(p1.A(t, jR), p1.A(t2, jR));
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
                return D(t, t2, i2) && h1.K(p1.A(t, jR), p1.A(t2, jR));
            default:
                return true;
        }
    }

    private <K, V> void m0(s1 s1Var, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            s1Var.L(i2, this.s.c(r(i3)), this.s.h(obj));
        }
    }

    private final <UT, UB> UB n(Object obj, int i2, UB ub, l1<UT, UB> l1Var) {
        a0.e eVarQ;
        int iQ = Q(i2);
        Object objA = p1.A(obj, R(i0(i2)));
        return (objA == null || (eVarQ = q(i2)) == null) ? ub : (UB) o(i2, iQ, this.s.d(objA), eVarQ, ub, l1Var);
    }

    private void n0(int i2, Object obj, s1 s1Var) throws IOException {
        if (obj instanceof String) {
            s1Var.m(i2, (String) obj);
        } else {
            s1Var.w(i2, (h) obj);
        }
    }

    private final <K, V, UT, UB> UB o(int i2, int i3, Map<K, V> map, a0.e eVar, UB ub, l1<UT, UB> l1Var) {
        j0.a<?, ?> aVarC = this.s.c(r(i2));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = l1Var.n();
                }
                h.C0033h c0033hU = h.u(j0.b(aVarC, next.getKey(), next.getValue()));
                try {
                    j0.e(c0033hU.b(), aVarC, next.getKey(), next.getValue());
                    l1Var.d(ub, i3, c0033hU.a());
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    private <UT, UB> void o0(l1<UT, UB> l1Var, T t, s1 s1Var) throws IOException {
        l1Var.t(l1Var.g(t), s1Var);
    }

    private static <T> float p(T t, long j2) {
        return p1.w(t, j2);
    }

    private a0.e q(int i2) {
        return (a0.e) this.f1415d[((i2 / 3) * 2) + 1];
    }

    private Object r(int i2) {
        return this.f1415d[(i2 / 3) * 2];
    }

    private f1 s(int i2) {
        int i3 = (i2 / 3) * 2;
        f1 f1Var = (f1) this.f1415d[i3];
        if (f1Var != null) {
            return f1Var;
        }
        f1<T> f1VarD = b1.a().d((Class) this.f1415d[i3 + 1]);
        this.f1415d[i3] = f1VarD;
        return f1VarD;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:185:0x041f A[PHI: r6
      0x041f: PHI (r6v4 int) = 
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
      (r6v7 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v1 int)
      (r6v8 int)
      (r6v1 int)
     binds: [B:21:0x0060, B:224:0x04c6, B:221:0x04bb, B:215:0x049f, B:212:0x048e, B:209:0x047f, B:206:0x0472, B:203:0x0465, B:199:0x045a, B:196:0x0451, B:193:0x0444, B:190:0x0437, B:187:0x0424, B:161:0x0335, B:155:0x0318, B:149:0x02fb, B:143:0x02de, B:137:0x02c0, B:131:0x02a2, B:125:0x0284, B:119:0x0266, B:113:0x0248, B:107:0x022a, B:101:0x020c, B:95:0x01ee, B:89:0x01d0, B:83:0x01b2, B:78:0x017e, B:75:0x0172, B:72:0x0162, B:69:0x0152, B:66:0x0142, B:63:0x0136, B:60:0x0129, B:57:0x011c, B:51:0x00fe, B:48:0x00ea, B:45:0x00d8, B:42:0x00c8, B:39:0x00b8, B:201:0x0461, B:36:0x00ab, B:33:0x009f, B:30:0x008f, B:27:0x007f, B:184:0x041e, B:24:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    private int t(T t) {
        int i2;
        int i3;
        int i4;
        int iD;
        int iL;
        int i5;
        int iV;
        int iX;
        Unsafe unsafe = f1413b;
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < this.f1414c.length) {
            int iI0 = i0(i7);
            int iQ = Q(i7);
            int iH0 = h0(iI0);
            if (iH0 <= 17) {
                i2 = this.f1414c[i7 + 2];
                int i10 = 1048575 & i2;
                int i11 = 1 << (i2 >>> 20);
                if (i10 != i6) {
                    i9 = unsafe.getInt(t, i10);
                    i6 = i10;
                }
                i3 = i11;
            } else {
                i2 = (!this.f1422k || iH0 < v.O.g() || iH0 > v.b0.g()) ? 0 : this.f1414c[i7 + 2] & 1048575;
                i3 = 0;
            }
            long jR = R(iI0);
            int i12 = i6;
            switch (iH0) {
                case 0:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.i(iQ, 0.0d);
                        i8 += i4;
                    }
                    break;
                case 1:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.q(iQ, 0.0f);
                        i8 += i4;
                    }
                    break;
                case 2:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.x(iQ, unsafe.getLong(t, jR));
                        i8 += i4;
                    }
                    break;
                case 3:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.Y(iQ, unsafe.getLong(t, jR));
                        i8 += i4;
                    }
                    break;
                case 4:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.v(iQ, unsafe.getInt(t, jR));
                        i8 += i4;
                    }
                    break;
                case 5:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.o(iQ, 0L);
                        i8 += i4;
                    }
                    break;
                case 6:
                    if ((i9 & i3) != 0) {
                        i4 = CodedOutputStream.m(iQ, 0);
                        i8 += i4;
                    }
                    break;
                case 7:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.d(iQ, true);
                        i8 += iD;
                    }
                    break;
                case 8:
                    if ((i9 & i3) != 0) {
                        Object object = unsafe.getObject(t, jR);
                        iD = object instanceof h ? CodedOutputStream.g(iQ, (h) object) : CodedOutputStream.T(iQ, (String) object);
                        i8 += iD;
                    }
                    break;
                case 9:
                    if ((i9 & i3) != 0) {
                        iD = h1.o(iQ, unsafe.getObject(t, jR), s(i7));
                        i8 += iD;
                    }
                    break;
                case 10:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.g(iQ, (h) unsafe.getObject(t, jR));
                        i8 += iD;
                    }
                    break;
                case 11:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.W(iQ, unsafe.getInt(t, jR));
                        i8 += iD;
                    }
                    break;
                case 12:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.k(iQ, unsafe.getInt(t, jR));
                        i8 += iD;
                    }
                    break;
                case 13:
                    if ((i9 & i3) != 0) {
                        iL = CodedOutputStream.L(iQ, 0);
                        i8 += iL;
                    }
                    break;
                case 14:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.N(iQ, 0L);
                        i8 += iD;
                    }
                    break;
                case 15:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.P(iQ, unsafe.getInt(t, jR));
                        i8 += iD;
                    }
                    break;
                case 16:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.R(iQ, unsafe.getLong(t, jR));
                        i8 += iD;
                    }
                    break;
                case 17:
                    if ((i9 & i3) != 0) {
                        iD = CodedOutputStream.s(iQ, (q0) unsafe.getObject(t, jR), s(i7));
                        i8 += iD;
                    }
                    break;
                case 18:
                    iD = h1.h(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 19:
                    iD = h1.f(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 20:
                    iD = h1.m(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 21:
                    iD = h1.x(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 22:
                    iD = h1.k(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 23:
                    iD = h1.h(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 24:
                    iD = h1.f(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 25:
                    iD = h1.a(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 26:
                    iD = h1.u(iQ, (List) unsafe.getObject(t, jR));
                    i8 += iD;
                    break;
                case 27:
                    iD = h1.p(iQ, (List) unsafe.getObject(t, jR), s(i7));
                    i8 += iD;
                    break;
                case 28:
                    iD = h1.c(iQ, (List) unsafe.getObject(t, jR));
                    i8 += iD;
                    break;
                case 29:
                    iD = h1.v(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 30:
                    iD = h1.d(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 31:
                    iD = h1.f(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 32:
                    iD = h1.h(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 33:
                    iD = h1.q(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 34:
                    iD = h1.s(iQ, (List) unsafe.getObject(t, jR), false);
                    i8 += iD;
                    break;
                case 35:
                    i5 = h1.i((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 36:
                    i5 = h1.g((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 37:
                    i5 = h1.n((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 38:
                    i5 = h1.y((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 39:
                    i5 = h1.l((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 40:
                    i5 = h1.i((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 41:
                    i5 = h1.g((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 42:
                    i5 = h1.b((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 43:
                    i5 = h1.w((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 44:
                    i5 = h1.e((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 45:
                    i5 = h1.g((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 46:
                    i5 = h1.i((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 47:
                    i5 = h1.r((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 48:
                    i5 = h1.t((List) unsafe.getObject(t, jR));
                    if (i5 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i2, i5);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i5);
                        iL = iV + iX + i5;
                        i8 += iL;
                    }
                    break;
                case 49:
                    iD = h1.j(iQ, (List) unsafe.getObject(t, jR), s(i7));
                    i8 += iD;
                    break;
                case 50:
                    iD = this.s.f(iQ, unsafe.getObject(t, jR), r(i7));
                    i8 += iD;
                    break;
                case 51:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.i(iQ, 0.0d);
                        i8 += iD;
                    }
                    break;
                case 52:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.q(iQ, 0.0f);
                        i8 += iD;
                    }
                    break;
                case 53:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.x(iQ, W(t, jR));
                        i8 += iD;
                    }
                    break;
                case 54:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.Y(iQ, W(t, jR));
                        i8 += iD;
                    }
                    break;
                case 55:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.v(iQ, V(t, jR));
                        i8 += iD;
                    }
                    break;
                case 56:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.o(iQ, 0L);
                        i8 += iD;
                    }
                    break;
                case 57:
                    if (E(t, iQ, i7)) {
                        iL = CodedOutputStream.m(iQ, 0);
                        i8 += iL;
                    }
                    break;
                case 58:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.d(iQ, true);
                        i8 += iD;
                    }
                    break;
                case 59:
                    if (E(t, iQ, i7)) {
                        Object object2 = unsafe.getObject(t, jR);
                        iD = object2 instanceof h ? CodedOutputStream.g(iQ, (h) object2) : CodedOutputStream.T(iQ, (String) object2);
                        i8 += iD;
                    }
                    break;
                case 60:
                    if (E(t, iQ, i7)) {
                        iD = h1.o(iQ, unsafe.getObject(t, jR), s(i7));
                        i8 += iD;
                    }
                    break;
                case 61:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.g(iQ, (h) unsafe.getObject(t, jR));
                        i8 += iD;
                    }
                    break;
                case 62:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.W(iQ, V(t, jR));
                        i8 += iD;
                    }
                    break;
                case 63:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.k(iQ, V(t, jR));
                        i8 += iD;
                    }
                    break;
                case 64:
                    if (E(t, iQ, i7)) {
                        iL = CodedOutputStream.L(iQ, 0);
                        i8 += iL;
                    }
                    break;
                case 65:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.N(iQ, 0L);
                        i8 += iD;
                    }
                    break;
                case 66:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.P(iQ, V(t, jR));
                        i8 += iD;
                    }
                    break;
                case 67:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.R(iQ, W(t, jR));
                        i8 += iD;
                    }
                    break;
                case 68:
                    if (E(t, iQ, i7)) {
                        iD = CodedOutputStream.s(iQ, (q0) unsafe.getObject(t, jR), s(i7));
                        i8 += iD;
                    }
                    break;
                default:
                    break;
            }
            i7 += 3;
            i6 = i12;
        }
        int iV2 = i8 + v(this.q, t);
        return this.f1419h ? iV2 + this.r.c(t).l() : iV2;
    }

    private int u(T t) {
        int i2;
        int i3;
        int iV;
        int iX;
        Unsafe unsafe = f1413b;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f1414c.length; i5 += 3) {
            int iI0 = i0(i5);
            int iH0 = h0(iI0);
            int iQ = Q(i5);
            long jR = R(iI0);
            int i6 = (iH0 < v.O.g() || iH0 > v.b0.g()) ? 0 : this.f1414c[i5 + 2] & 1048575;
            switch (iH0) {
                case 0:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.i(iQ, 0.0d);
                        i4 += i2;
                    }
                    break;
                case 1:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.q(iQ, 0.0f);
                        i4 += i2;
                    }
                    break;
                case 2:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.x(iQ, p1.y(t, jR));
                        i4 += i2;
                    }
                    break;
                case 3:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.Y(iQ, p1.y(t, jR));
                        i4 += i2;
                    }
                    break;
                case 4:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.v(iQ, p1.x(t, jR));
                        i4 += i2;
                    }
                    break;
                case 5:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.o(iQ, 0L);
                        i4 += i2;
                    }
                    break;
                case 6:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.m(iQ, 0);
                        i4 += i2;
                    }
                    break;
                case 7:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.d(iQ, true);
                        i4 += i2;
                    }
                    break;
                case 8:
                    if (y(t, i5)) {
                        Object objA = p1.A(t, jR);
                        i2 = objA instanceof h ? CodedOutputStream.g(iQ, (h) objA) : CodedOutputStream.T(iQ, (String) objA);
                        i4 += i2;
                    }
                    break;
                case 9:
                    if (y(t, i5)) {
                        i2 = h1.o(iQ, p1.A(t, jR), s(i5));
                        i4 += i2;
                    }
                    break;
                case 10:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.g(iQ, (h) p1.A(t, jR));
                        i4 += i2;
                    }
                    break;
                case 11:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.W(iQ, p1.x(t, jR));
                        i4 += i2;
                    }
                    break;
                case 12:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.k(iQ, p1.x(t, jR));
                        i4 += i2;
                    }
                    break;
                case 13:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.L(iQ, 0);
                        i4 += i2;
                    }
                    break;
                case 14:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.N(iQ, 0L);
                        i4 += i2;
                    }
                    break;
                case 15:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.P(iQ, p1.x(t, jR));
                        i4 += i2;
                    }
                    break;
                case 16:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.R(iQ, p1.y(t, jR));
                        i4 += i2;
                    }
                    break;
                case 17:
                    if (y(t, i5)) {
                        i2 = CodedOutputStream.s(iQ, (q0) p1.A(t, jR), s(i5));
                        i4 += i2;
                    }
                    break;
                case 18:
                    i2 = h1.h(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 19:
                    i2 = h1.f(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 20:
                    i2 = h1.m(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 21:
                    i2 = h1.x(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 22:
                    i2 = h1.k(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 23:
                    i2 = h1.h(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 24:
                    i2 = h1.f(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 25:
                    i2 = h1.a(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 26:
                    i2 = h1.u(iQ, G(t, jR));
                    i4 += i2;
                    break;
                case 27:
                    i2 = h1.p(iQ, G(t, jR), s(i5));
                    i4 += i2;
                    break;
                case 28:
                    i2 = h1.c(iQ, G(t, jR));
                    i4 += i2;
                    break;
                case 29:
                    i2 = h1.v(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 30:
                    i2 = h1.d(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 31:
                    i2 = h1.f(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 32:
                    i2 = h1.h(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 33:
                    i2 = h1.q(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 34:
                    i2 = h1.s(iQ, G(t, jR), false);
                    i4 += i2;
                    break;
                case 35:
                    i3 = h1.i((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 36:
                    i3 = h1.g((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 37:
                    i3 = h1.n((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 38:
                    i3 = h1.y((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 39:
                    i3 = h1.l((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 40:
                    i3 = h1.i((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 41:
                    i3 = h1.g((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 42:
                    i3 = h1.b((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 43:
                    i3 = h1.w((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 44:
                    i3 = h1.e((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 45:
                    i3 = h1.g((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 46:
                    i3 = h1.i((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 47:
                    i3 = h1.r((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 48:
                    i3 = h1.t((List) unsafe.getObject(t, jR));
                    if (i3 > 0) {
                        if (this.f1422k) {
                            unsafe.putInt(t, i6, i3);
                        }
                        iV = CodedOutputStream.V(iQ);
                        iX = CodedOutputStream.X(i3);
                        i2 = iV + iX + i3;
                        i4 += i2;
                    }
                    break;
                case 49:
                    i2 = h1.j(iQ, G(t, jR), s(i5));
                    i4 += i2;
                    break;
                case 50:
                    i2 = this.s.f(iQ, p1.A(t, jR), r(i5));
                    i4 += i2;
                    break;
                case 51:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.i(iQ, 0.0d);
                        i4 += i2;
                    }
                    break;
                case 52:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.q(iQ, 0.0f);
                        i4 += i2;
                    }
                    break;
                case 53:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.x(iQ, W(t, jR));
                        i4 += i2;
                    }
                    break;
                case 54:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.Y(iQ, W(t, jR));
                        i4 += i2;
                    }
                    break;
                case 55:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.v(iQ, V(t, jR));
                        i4 += i2;
                    }
                    break;
                case 56:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.o(iQ, 0L);
                        i4 += i2;
                    }
                    break;
                case 57:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.m(iQ, 0);
                        i4 += i2;
                    }
                    break;
                case 58:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.d(iQ, true);
                        i4 += i2;
                    }
                    break;
                case 59:
                    if (E(t, iQ, i5)) {
                        Object objA2 = p1.A(t, jR);
                        i2 = objA2 instanceof h ? CodedOutputStream.g(iQ, (h) objA2) : CodedOutputStream.T(iQ, (String) objA2);
                        i4 += i2;
                    }
                    break;
                case 60:
                    if (E(t, iQ, i5)) {
                        i2 = h1.o(iQ, p1.A(t, jR), s(i5));
                        i4 += i2;
                    }
                    break;
                case 61:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.g(iQ, (h) p1.A(t, jR));
                        i4 += i2;
                    }
                    break;
                case 62:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.W(iQ, V(t, jR));
                        i4 += i2;
                    }
                    break;
                case 63:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.k(iQ, V(t, jR));
                        i4 += i2;
                    }
                    break;
                case 64:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.L(iQ, 0);
                        i4 += i2;
                    }
                    break;
                case 65:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.N(iQ, 0L);
                        i4 += i2;
                    }
                    break;
                case 66:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.P(iQ, V(t, jR));
                        i4 += i2;
                    }
                    break;
                case 67:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.R(iQ, W(t, jR));
                        i4 += i2;
                    }
                    break;
                case 68:
                    if (E(t, iQ, i5)) {
                        i2 = CodedOutputStream.s(iQ, (q0) p1.A(t, jR), s(i5));
                        i4 += i2;
                    }
                    break;
            }
        }
        return i4 + v(this.q, t);
    }

    private <UT, UB> int v(l1<UT, UB> l1Var, T t) {
        return l1Var.h(l1Var.g(t));
    }

    private static <T> int w(T t, long j2) {
        return p1.x(t, j2);
    }

    private static boolean x(int i2) {
        return (i2 & 536870912) != 0;
    }

    private boolean y(T t, int i2) {
        if (!this.f1421j) {
            int iY = Y(i2);
            return (p1.x(t, (long) (iY & 1048575)) & (1 << (iY >>> 20))) != 0;
        }
        int iI0 = i0(i2);
        long jR = R(iI0);
        switch (h0(iI0)) {
            case 0:
                return p1.v(t, jR) != 0.0d;
            case 1:
                return p1.w(t, jR) != 0.0f;
            case 2:
                return p1.y(t, jR) != 0;
            case 3:
                return p1.y(t, jR) != 0;
            case 4:
                return p1.x(t, jR) != 0;
            case 5:
                return p1.y(t, jR) != 0;
            case 6:
                return p1.x(t, jR) != 0;
            case 7:
                return p1.p(t, jR);
            case 8:
                Object objA = p1.A(t, jR);
                if (objA instanceof String) {
                    return !((String) objA).isEmpty();
                }
                if (objA instanceof h) {
                    return !h.f1298f.equals(objA);
                }
                throw new IllegalArgumentException();
            case 9:
                return p1.A(t, jR) != null;
            case 10:
                return !h.f1298f.equals(p1.A(t, jR));
            case 11:
                return p1.x(t, jR) != 0;
            case 12:
                return p1.x(t, jR) != 0;
            case 13:
                return p1.x(t, jR) != 0;
            case 14:
                return p1.y(t, jR) != 0;
            case 15:
                return p1.x(t, jR) != 0;
            case 16:
                return p1.y(t, jR) != 0;
            case 17:
                return p1.A(t, jR) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean z(T t, int i2, int i3, int i4) {
        if (this.f1421j) {
            return y(t, i2);
        }
        return (i3 & i4) != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void a(T t, T t2) {
        t2.getClass();
        for (int i2 = 0; i2 < this.f1414c.length; i2 += 3) {
            M(t, t2, i2);
        }
        if (this.f1421j) {
            return;
        }
        h1.G(this.q, t, t2);
        if (this.f1419h) {
            h1.E(this.r, t, t2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public boolean b(T t, T t2) {
        int length = this.f1414c.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            if (!m(t, t2, i2)) {
                return false;
            }
        }
        if (!this.q.g(t).equals(this.q.g(t2))) {
            return false;
        }
        if (this.f1419h) {
            return this.r.c(t).equals(this.r.c(t2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public T c() {
        return (T) this.o.a(this.f1418g);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public int d(T t) {
        int i2;
        int iF;
        int length = this.f1414c.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iI0 = i0(i4);
            int iQ = Q(i4);
            long jR = R(iI0);
            int iHashCode = 37;
            switch (h0(iI0)) {
                case 0:
                    i2 = i3 * 53;
                    iF = a0.f(Double.doubleToLongBits(p1.v(t, jR)));
                    i3 = i2 + iF;
                    break;
                case 1:
                    i2 = i3 * 53;
                    iF = Float.floatToIntBits(p1.w(t, jR));
                    i3 = i2 + iF;
                    break;
                case 2:
                    i2 = i3 * 53;
                    iF = a0.f(p1.y(t, jR));
                    i3 = i2 + iF;
                    break;
                case 3:
                    i2 = i3 * 53;
                    iF = a0.f(p1.y(t, jR));
                    i3 = i2 + iF;
                    break;
                case 4:
                    i2 = i3 * 53;
                    iF = p1.x(t, jR);
                    i3 = i2 + iF;
                    break;
                case 5:
                    i2 = i3 * 53;
                    iF = a0.f(p1.y(t, jR));
                    i3 = i2 + iF;
                    break;
                case 6:
                    i2 = i3 * 53;
                    iF = p1.x(t, jR);
                    i3 = i2 + iF;
                    break;
                case 7:
                    i2 = i3 * 53;
                    iF = a0.c(p1.p(t, jR));
                    i3 = i2 + iF;
                    break;
                case 8:
                    i2 = i3 * 53;
                    iF = ((String) p1.A(t, jR)).hashCode();
                    i3 = i2 + iF;
                    break;
                case 9:
                    Object objA = p1.A(t, jR);
                    if (objA != null) {
                        iHashCode = objA.hashCode();
                    }
                    i3 = (i3 * 53) + iHashCode;
                    break;
                case 10:
                    i2 = i3 * 53;
                    iF = p1.A(t, jR).hashCode();
                    i3 = i2 + iF;
                    break;
                case 11:
                    i2 = i3 * 53;
                    iF = p1.x(t, jR);
                    i3 = i2 + iF;
                    break;
                case 12:
                    i2 = i3 * 53;
                    iF = p1.x(t, jR);
                    i3 = i2 + iF;
                    break;
                case 13:
                    i2 = i3 * 53;
                    iF = p1.x(t, jR);
                    i3 = i2 + iF;
                    break;
                case 14:
                    i2 = i3 * 53;
                    iF = a0.f(p1.y(t, jR));
                    i3 = i2 + iF;
                    break;
                case 15:
                    i2 = i3 * 53;
                    iF = p1.x(t, jR);
                    i3 = i2 + iF;
                    break;
                case 16:
                    i2 = i3 * 53;
                    iF = a0.f(p1.y(t, jR));
                    i3 = i2 + iF;
                    break;
                case 17:
                    Object objA2 = p1.A(t, jR);
                    if (objA2 != null) {
                        iHashCode = objA2.hashCode();
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
                    iF = p1.A(t, jR).hashCode();
                    i3 = i2 + iF;
                    break;
                case 50:
                    i2 = i3 * 53;
                    iF = p1.A(t, jR).hashCode();
                    i3 = i2 + iF;
                    break;
                case 51:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.f(Double.doubleToLongBits(T(t, jR)));
                        i3 = i2 + iF;
                    }
                    break;
                case 52:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = Float.floatToIntBits(U(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 53:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.f(W(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 54:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.f(W(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 55:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = V(t, jR);
                        i3 = i2 + iF;
                    }
                    break;
                case 56:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.f(W(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 57:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = V(t, jR);
                        i3 = i2 + iF;
                    }
                    break;
                case 58:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.c(S(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 59:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = ((String) p1.A(t, jR)).hashCode();
                        i3 = i2 + iF;
                    }
                    break;
                case 60:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = p1.A(t, jR).hashCode();
                        i3 = i2 + iF;
                    }
                    break;
                case 61:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = p1.A(t, jR).hashCode();
                        i3 = i2 + iF;
                    }
                    break;
                case 62:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = V(t, jR);
                        i3 = i2 + iF;
                    }
                    break;
                case 63:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = V(t, jR);
                        i3 = i2 + iF;
                    }
                    break;
                case 64:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = V(t, jR);
                        i3 = i2 + iF;
                    }
                    break;
                case 65:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.f(W(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 66:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = V(t, jR);
                        i3 = i2 + iF;
                    }
                    break;
                case 67:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = a0.f(W(t, jR));
                        i3 = i2 + iF;
                    }
                    break;
                case 68:
                    if (E(t, iQ, i4)) {
                        i2 = i3 * 53;
                        iF = p1.A(t, jR).hashCode();
                        i3 = i2 + iF;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + this.q.g(t).hashCode();
        return this.f1419h ? (iHashCode2 * 53) + this.r.c(t).hashCode() : iHashCode2;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void e(T t, e1 e1Var, p pVar) throws IOException {
        pVar.getClass();
        I(this.q, this.r, t, e1Var, pVar);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void f(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long jR = R(i0(this.l[i3]));
            Object objA = p1.A(t, jR);
            if (objA != null) {
                p1.O(t, jR, this.s.b(objA));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.c(t, this.l[i2]);
            i2++;
        }
        this.q.j(t);
        if (this.f1419h) {
            this.r.f(t);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0078  */
    /* JADX WARN: Code duplicated, block: B:58:0x007e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0090 A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.f1
    public final boolean g(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.m; i5++) {
            int i6 = this.l[i5];
            int iQ = Q(i6);
            int iI0 = i0(i6);
            if (this.f1421j) {
                i2 = 0;
            } else {
                int i7 = this.f1414c[i6 + 2];
                int i8 = 1048575 & i7;
                i2 = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = f1413b.getInt(t, i8);
                    i3 = i8;
                }
            }
            if (F(iI0) && !z(t, i6, i4, i2)) {
                return false;
            }
            int iH0 = h0(iI0);
            if (iH0 == 9 || iH0 == 17) {
                if (z(t, i6, i4, i2) && !A(t, iI0, s(i6))) {
                    return false;
                }
            } else if (iH0 == 27) {
                if (!B(t, iI0, i6)) {
                    return false;
                }
            } else if (iH0 == 60 || iH0 == 68) {
                if (E(t, iQ, i6) && !A(t, iI0, s(i6))) {
                    return false;
                }
            } else if (iH0 != 49) {
                if (iH0 == 50 && !C(t, iI0, i6)) {
                    return false;
                }
            } else if (!B(t, iI0, i6)) {
                return false;
            }
        }
        return !this.f1419h || this.r.c(t).p();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void h(T t, s1 s1Var) throws IOException {
        if (s1Var.i() == s1.a.DESCENDING) {
            l0(t, s1Var);
        } else if (this.f1421j) {
            k0(t, s1Var);
        } else {
            j0(t, s1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public int i(T t) {
        return this.f1421j ? u(t) : t(t);
    }
}
