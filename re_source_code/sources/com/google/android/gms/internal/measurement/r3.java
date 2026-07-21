package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class r3 {
    private static final Class<?> a = F();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h4<?, ?> f17248b = g(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h4<?, ?> f17249c = g(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h4<?, ?> f17250d = new i4();

    static int A(List<Long> list) {
        int iN0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            iN0 = 0;
            while (i2 < size) {
                iN0 += zzen.n0(w2Var.e(i2));
                i2++;
            }
        } else {
            iN0 = 0;
            while (i2 < size) {
                iN0 += zzen.n0(list.get(i2).longValue());
                i2++;
            }
        }
        return iN0;
    }

    public static h4<?, ?> B() {
        return f17250d;
    }

    public static void C(int i2, List<Long> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.l(i2, list, z);
    }

    static int D(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return E(list) + (size * zzen.g0(i2));
    }

    static int E(List<Integer> list) {
        int iB0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            iB0 = 0;
            while (i2 < size) {
                iB0 += zzen.B0(n2Var.f(i2));
                i2++;
            }
        } else {
            iB0 = 0;
            while (i2 < size) {
                iB0 += zzen.B0(list.get(i2).intValue());
                i2++;
            }
        }
        return iB0;
    }

    private static Class<?> F() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void G(int i2, List<Long> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.u(i2, list, z);
    }

    static int H(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return I(list) + (size * zzen.g0(i2));
    }

    static int I(List<Integer> list) {
        int iK0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            iK0 = 0;
            while (i2 < size) {
                iK0 += zzen.k0(n2Var.f(i2));
                i2++;
            }
        } else {
            iK0 = 0;
            while (i2 < size) {
                iK0 += zzen.k0(list.get(i2).intValue());
                i2++;
            }
        }
        return iK0;
    }

    private static Class<?> J() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void K(int i2, List<Long> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.t(i2, list, z);
    }

    static int L(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * zzen.g0(i2));
    }

    static int M(List<Integer> list) {
        int iO0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            iO0 = 0;
            while (i2 < size) {
                iO0 += zzen.o0(n2Var.f(i2));
                i2++;
            }
        } else {
            iO0 = 0;
            while (i2 < size) {
                iO0 += zzen.o0(list.get(i2).intValue());
                i2++;
            }
        }
        return iO0;
    }

    public static void N(int i2, List<Long> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.s(i2, list, z);
    }

    static int O(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * zzen.g0(i2));
    }

    static int P(List<Integer> list) {
        int iS0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            iS0 = 0;
            while (i2 < size) {
                iS0 += zzen.s0(n2Var.f(i2));
                i2++;
            }
        } else {
            iS0 = 0;
            while (i2 < size) {
                iS0 += zzen.s0(list.get(i2).intValue());
                i2++;
            }
        }
        return iS0;
    }

    public static void Q(int i2, List<Long> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.m(i2, list, z);
    }

    static int R(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.x0(i2, 0);
    }

    static int S(List<?> list) {
        return list.size() << 2;
    }

    public static void T(int i2, List<Integer> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.j(i2, list, z);
    }

    static int U(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.q0(i2, 0L);
    }

    static int V(List<?> list) {
        return list.size() << 3;
    }

    public static void W(int i2, List<Integer> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.o(i2, list, z);
    }

    static int X(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.H(i2, true);
    }

    static int Y(List<?> list) {
        return list.size();
    }

    public static void Z(int i2, List<Integer> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.v(i2, list, z);
    }

    static int a(int i2, Object obj, p3 p3Var) {
        return obj instanceof zzft ? zzen.c(i2, (zzft) obj) : zzen.F(i2, (zzgo) obj, p3Var);
    }

    public static void a0(int i2, List<Integer> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.n(i2, list, z);
    }

    static int b(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int iG0 = zzen.g0(i2) * size;
        if (list instanceof zzfv) {
            zzfv zzfvVar = (zzfv) list;
            while (i3 < size) {
                Object objE = zzfvVar.e(i3);
                iG0 += objE instanceof zzdu ? zzen.I((zzdu) objE) : zzen.K((String) objE);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                iG0 += obj instanceof zzdu ? zzen.I((zzdu) obj) : zzen.K((String) obj);
                i3++;
            }
        }
        return iG0;
    }

    public static void b0(int i2, List<Integer> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.p(i2, list, z);
    }

    static int c(int i2, List<?> list, p3 p3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iG0 = zzen.g0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            iG0 += obj instanceof zzft ? zzen.d((zzft) obj) : zzen.e((zzgo) obj, p3Var);
        }
        return iG0;
    }

    public static void c0(int i2, List<Integer> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.k(i2, list, z);
    }

    static int d(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return e(list) + (list.size() * zzen.g0(i2));
    }

    public static void d0(int i2, List<Boolean> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.i(i2, list, z);
    }

    static int e(List<Long> list) {
        int iD0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            iD0 = 0;
            while (i2 < size) {
                iD0 += zzen.d0(w2Var.e(i2));
                i2++;
            }
        } else {
            iD0 = 0;
            while (i2 < size) {
                iD0 += zzen.d0(list.get(i2).longValue());
                i2++;
            }
        }
        return iD0;
    }

    public static h4<?, ?> f() {
        return f17248b;
    }

    private static h4<?, ?> g(boolean z) {
        try {
            Class<?> clsJ = J();
            if (clsJ == null) {
                return null;
            }
            return (h4) clsJ.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB h(int i2, int i3, UB ub, h4<UT, UB> h4Var) {
        if (ub == null) {
            ub = h4Var.a();
        }
        h4Var.d(ub, i2, i3);
        return ub;
    }

    static <UT, UB> UB i(int i2, List<Integer> list, zzfk zzfkVar, UB ub, h4<UT, UB> h4Var) {
        if (zzfkVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int iIntValue = list.get(i4).intValue();
                if (zzfkVar.d(iIntValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(iIntValue));
                    }
                    i3++;
                } else {
                    ub = (UB) h(i2, iIntValue, ub, h4Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzfkVar.d(iIntValue2)) {
                    ub = (UB) h(i2, iIntValue2, ub, h4Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void j(int i2, List<String> list, y4 y4Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.A(i2, list);
    }

    public static void k(int i2, List<?> list, y4 y4Var, p3 p3Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.K(i2, list, p3Var);
    }

    public static void l(int i2, List<Double> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.w(i2, list, z);
    }

    static <T, FT extends zzey<FT>> void m(d2<FT> d2Var, T t, T t2) {
        h2<T> h2VarB = d2Var.b(t2);
        if (h2VarB.f17168b.isEmpty()) {
            return;
        }
        d2Var.i(t).f(h2VarB);
    }

    static <T> void n(a3 a3Var, T t, T t2, long j2) {
        k4.j(t, j2, a3Var.g(k4.F(t, j2), k4.F(t2, j2)));
    }

    static <T, UT, UB> void o(h4<UT, UB> h4Var, T t, T t2) {
        h4Var.h(t, h4Var.p(h4Var.k(t), h4Var.k(t2)));
    }

    public static void p(Class<?> cls) {
        Class<?> cls2;
        if (!zzfd.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean q(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int r(int i2, List<zzdu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iG0 = size * zzen.g0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            iG0 += zzen.I(list.get(i3));
        }
        return iG0;
    }

    static int s(int i2, List<zzgo> list, p3 p3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iU += zzen.U(i2, list.get(i3), p3Var);
        }
        return iU;
    }

    static int t(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return u(list) + (size * zzen.g0(i2));
    }

    static int u(List<Long> list) {
        int iI0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            iI0 = 0;
            while (i2 < size) {
                iI0 += zzen.i0(w2Var.e(i2));
                i2++;
            }
        } else {
            iI0 = 0;
            while (i2 < size) {
                iI0 += zzen.i0(list.get(i2).longValue());
                i2++;
            }
        }
        return iI0;
    }

    public static h4<?, ?> v() {
        return f17249c;
    }

    public static void w(int i2, List<zzdu> list, y4 y4Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.x(i2, list);
    }

    public static void x(int i2, List<?> list, y4 y4Var, p3 p3Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.I(i2, list, p3Var);
    }

    public static void y(int i2, List<Float> list, y4 y4Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        y4Var.z(i2, list, z);
    }

    static int z(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzen.g0(i2));
    }
}
