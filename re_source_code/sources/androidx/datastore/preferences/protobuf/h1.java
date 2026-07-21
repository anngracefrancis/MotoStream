package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SchemaUtil.java */
/* JADX INFO: loaded from: classes.dex */
final class h1 {
    private static final Class<?> a = B();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l1<?, ?> f1311b = C(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final l1<?, ?> f1312c = C(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final l1<?, ?> f1313d = new n1();

    static <UT, UB> UB A(int i2, List<Integer> list, a0.e eVar, UB ub, l1<UT, UB> l1Var) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int iIntValue = list.get(i4).intValue();
                if (eVar.a(iIntValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(iIntValue));
                    }
                    i3++;
                } else {
                    ub = (UB) L(i2, iIntValue, ub, l1Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!eVar.a(iIntValue2)) {
                    ub = (UB) L(i2, iIntValue2, ub, l1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static l1<?, ?> C(boolean z) {
        try {
            Class<?> clsD = D();
            if (clsD == null) {
                return null;
            }
            return (l1) clsD.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends u.b<FT>> void E(q<FT> qVar, T t, T t2) {
        u<T> uVarC = qVar.c(t2);
        if (uVarC.n()) {
            return;
        }
        qVar.d(t).u(uVarC);
    }

    static <T> void F(l0 l0Var, T t, T t2, long j2) {
        p1.O(t, j2, l0Var.a(p1.A(t, j2), p1.A(t2, j2)));
    }

    static <T, UT, UB> void G(l1<UT, UB> l1Var, T t, T t2) {
        l1Var.p(t, l1Var.k(l1Var.g(t), l1Var.g(t2)));
    }

    public static l1<?, ?> H() {
        return f1311b;
    }

    public static l1<?, ?> I() {
        return f1312c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!y.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <UT, UB> UB L(int i2, int i3, UB ub, l1<UT, UB> l1Var) {
        if (ub == null) {
            ub = l1Var.n();
        }
        l1Var.e(ub, i2, i3);
        return ub;
    }

    public static l1<?, ?> M() {
        return f1313d;
    }

    public static void N(int i2, List<Boolean> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.A(i2, list, z);
    }

    public static void O(int i2, List<h> list, s1 s1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.N(i2, list);
    }

    public static void P(int i2, List<Double> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.K(i2, list, z);
    }

    public static void Q(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.J(i2, list, z);
    }

    public static void R(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.y(i2, list, z);
    }

    public static void S(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.u(i2, list, z);
    }

    public static void T(int i2, List<Float> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.a(i2, list, z);
    }

    public static void U(int i2, List<?> list, s1 s1Var, f1 f1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.l(i2, list, f1Var);
    }

    public static void V(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.o(i2, list, z);
    }

    public static void W(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.I(i2, list, z);
    }

    public static void X(int i2, List<?> list, s1 s1Var, f1 f1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.j(i2, list, f1Var);
    }

    public static void Y(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.v(i2, list, z);
    }

    public static void Z(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.f(i2, list, z);
    }

    static int a(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(size) : size * CodedOutputStream.d(i2, true);
    }

    public static void a0(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.G(i2, list, z);
    }

    static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.C(i2, list, z);
    }

    static int c(int i2, List<h> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = size * CodedOutputStream.V(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            iV += CodedOutputStream.h(list.get(i3));
        }
        return iV;
    }

    public static void c0(int i2, List<String> list, s1 s1Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.k(i2, list);
    }

    static int d(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iE) : iE + (size * CodedOutputStream.V(i2));
    }

    public static void d0(int i2, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.B(i2, list, z);
    }

    static int e(List<Integer> list) {
        int iL;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iL = 0;
            while (i2 < size) {
                iL += CodedOutputStream.l(zVar.q(i2));
                i2++;
            }
        } else {
            iL = 0;
            while (i2 < size) {
                iL += CodedOutputStream.l(list.get(i2).intValue());
                i2++;
            }
        }
        return iL;
    }

    public static void e0(int i2, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        s1Var.g(i2, list, z);
    }

    static int f(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(size * 4) : size * CodedOutputStream.m(i2, 0);
    }

    static int g(List<?> list) {
        return list.size() * 4;
    }

    static int h(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(size * 8) : size * CodedOutputStream.o(i2, 0L);
    }

    static int i(List<?> list) {
        return list.size() * 8;
    }

    static int j(int i2, List<q0> list, f1 f1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iS += CodedOutputStream.s(i2, list.get(i3), f1Var);
        }
        return iS;
    }

    static int k(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iL) : iL + (size * CodedOutputStream.V(i2));
    }

    static int l(List<Integer> list) {
        int iW;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iW = 0;
            while (i2 < size) {
                iW += CodedOutputStream.w(zVar.q(i2));
                i2++;
            }
        } else {
            iW = 0;
            while (i2 < size) {
                iW += CodedOutputStream.w(list.get(i2).intValue());
                i2++;
            }
        }
        return iW;
    }

    static int m(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iN) : iN + (list.size() * CodedOutputStream.V(i2));
    }

    static int n(List<Long> list) {
        int iY;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            iY = 0;
            while (i2 < size) {
                iY += CodedOutputStream.y(h0Var.q(i2));
                i2++;
            }
        } else {
            iY = 0;
            while (i2 < size) {
                iY += CodedOutputStream.y(list.get(i2).longValue());
                i2++;
            }
        }
        return iY;
    }

    static int o(int i2, Object obj, f1 f1Var) {
        return obj instanceof d0 ? CodedOutputStream.A(i2, (d0) obj) : CodedOutputStream.F(i2, (q0) obj, f1Var);
    }

    static int p(int i2, List<?> list, f1 f1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = CodedOutputStream.V(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            iV += obj instanceof d0 ? CodedOutputStream.B((d0) obj) : CodedOutputStream.H((q0) obj, f1Var);
        }
        return iV;
    }

    static int q(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iR) : iR + (size * CodedOutputStream.V(i2));
    }

    static int r(List<Integer> list) {
        int iQ;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iQ = 0;
            while (i2 < size) {
                iQ += CodedOutputStream.Q(zVar.q(i2));
                i2++;
            }
        } else {
            iQ = 0;
            while (i2 < size) {
                iQ += CodedOutputStream.Q(list.get(i2).intValue());
                i2++;
            }
        }
        return iQ;
    }

    static int s(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iT) : iT + (size * CodedOutputStream.V(i2));
    }

    static int t(List<Long> list) {
        int iS;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            iS = 0;
            while (i2 < size) {
                iS += CodedOutputStream.S(h0Var.q(i2));
                i2++;
            }
        } else {
            iS = 0;
            while (i2 < size) {
                iS += CodedOutputStream.S(list.get(i2).longValue());
                i2++;
            }
        }
        return iS;
    }

    static int u(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int iV = CodedOutputStream.V(i2) * size;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            while (i3 < size) {
                Object objC1 = f0Var.c1(i3);
                iV += objC1 instanceof h ? CodedOutputStream.h((h) objC1) : CodedOutputStream.U((String) objC1);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                iV += obj instanceof h ? CodedOutputStream.h((h) obj) : CodedOutputStream.U((String) obj);
                i3++;
            }
        }
        return iV;
    }

    static int v(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iW) : iW + (size * CodedOutputStream.V(i2));
    }

    static int w(List<Integer> list) {
        int iX;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iX = 0;
            while (i2 < size) {
                iX += CodedOutputStream.X(zVar.q(i2));
                i2++;
            }
        } else {
            iX = 0;
            while (i2 < size) {
                iX += CodedOutputStream.X(list.get(i2).intValue());
                i2++;
            }
        }
        return iX;
    }

    static int x(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z ? CodedOutputStream.V(i2) + CodedOutputStream.C(iY) : iY + (size * CodedOutputStream.V(i2));
    }

    static int y(List<Long> list) {
        int iZ;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof h0) {
            h0 h0Var = (h0) list;
            iZ = 0;
            while (i2 < size) {
                iZ += CodedOutputStream.Z(h0Var.q(i2));
                i2++;
            }
        } else {
            iZ = 0;
            while (i2 < size) {
                iZ += CodedOutputStream.Z(list.get(i2).longValue());
                i2++;
            }
        }
        return iZ;
    }

    static <UT, UB> UB z(int i2, List<Integer> list, a0.d<?> dVar, UB ub, l1<UT, UB> l1Var) {
        if (dVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int iIntValue = list.get(i4).intValue();
                if (dVar.a(iIntValue) != null) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(iIntValue));
                    }
                    i3++;
                } else {
                    ub = (UB) L(i2, iIntValue, ub, l1Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (dVar.a(iIntValue2) == null) {
                    ub = (UB) L(i2, iIntValue2, ub, l1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
