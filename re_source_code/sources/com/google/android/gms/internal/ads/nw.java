package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class nw {
    private static final Class<?> a = t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final cx<?, ?> f13064b = y(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final cx<?, ?> f13065c = y(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final cx<?, ?> f13066d = new dx();

    static int A(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int iH0 = zzdni.h0(i2) * size;
        if (list instanceof zzdot) {
            zzdot zzdotVar = (zzdot) list;
            while (i3 < size) {
                Object objK1 = zzdotVar.k1(i3);
                iH0 += objK1 instanceof zzdmr ? zzdni.Q((zzdmr) objK1) : zzdni.r0((String) objK1);
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                iH0 += obj instanceof zzdmr ? zzdni.Q((zzdmr) obj) : zzdni.r0((String) obj);
                i3++;
            }
        }
        return iH0;
    }

    static int B(int i2, List<?> list, lw lwVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iH0 = zzdni.h0(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            iH0 += obj instanceof zzdor ? zzdni.e((zzdor) obj) : zzdni.A((zzdpk) obj, lwVar);
        }
        return iH0;
    }

    public static void C(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.l(i2, list, z);
    }

    static int D(int i2, List<zzdmr> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iH0 = size * zzdni.h0(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            iH0 += zzdni.Q(list.get(i3));
        }
        return iH0;
    }

    static int E(int i2, List<zzdpk> list, lw lwVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iL += zzdni.L(i2, list.get(i3), lwVar);
        }
        return iL;
    }

    public static void F(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.u(i2, list, z);
    }

    public static void G(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.t(i2, list, z);
    }

    static boolean H(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void I(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.s(i2, list, z);
    }

    public static void J(int i2, List<Long> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.m(i2, list, z);
    }

    public static void K(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.j(i2, list, z);
    }

    public static void L(Class<?> cls) {
        Class<?> cls2;
        if (!zzdob.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void M(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.o(i2, list, z);
    }

    public static void N(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.v(i2, list, z);
    }

    public static void O(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.n(i2, list, z);
    }

    public static void P(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.p(i2, list, z);
    }

    public static void Q(int i2, List<Integer> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.k(i2, list, z);
    }

    public static void R(int i2, List<Boolean> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.i(i2, list, z);
    }

    static int S(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return c0(list) + (list.size() * zzdni.h0(i2));
    }

    static int T(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d0(list) + (size * zzdni.h0(i2));
    }

    static int U(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return i(list) + (size * zzdni.h0(i2));
    }

    static int V(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return j(list) + (size * zzdni.h0(i2));
    }

    static int W(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k(list) + (size * zzdni.h0(i2));
    }

    static int X(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return l(list) + (size * zzdni.h0(i2));
    }

    static int Y(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return m(list) + (size * zzdni.h0(i2));
    }

    static int Z(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.r(i2, 0);
    }

    static <UT, UB> UB a(int i2, int i3, UB ub, cx<UT, UB> cxVar) {
        if (ub == null) {
            ub = cxVar.m();
        }
        cxVar.a(ub, i2, i3);
        return ub;
    }

    static int a0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.F0(i2, 0L);
    }

    static <UT, UB> UB b(int i2, List<Integer> list, zzdog zzdogVar, UB ub, cx<UT, UB> cxVar) {
        if (zzdogVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int iIntValue = list.get(i4).intValue();
                if (zzdogVar.a(iIntValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(iIntValue));
                    }
                    i3++;
                } else {
                    ub = (UB) a(i2, iIntValue, ub, cxVar);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!zzdogVar.a(iIntValue2)) {
                    ub = (UB) a(i2, iIntValue2, ub, cxVar);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static int b0(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzdni.w0(i2, true);
    }

    public static void c(int i2, List<String> list, ux uxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.A(i2, list);
    }

    static int c0(List<Long> list) {
        int iV;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ov) {
            ov ovVar = (ov) list;
            iV = 0;
            while (i2 < size) {
                iV += zzdni.V(ovVar.f(i2));
                i2++;
            }
        } else {
            iV = 0;
            while (i2 < size) {
                iV += zzdni.V(list.get(i2).longValue());
                i2++;
            }
        }
        return iV;
    }

    public static void d(int i2, List<?> list, ux uxVar, lw lwVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.W(i2, list, lwVar);
    }

    static int d0(List<Long> list) {
        int iW;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ov) {
            ov ovVar = (ov) list;
            iW = 0;
            while (i2 < size) {
                iW += zzdni.W(ovVar.f(i2));
                i2++;
            }
        } else {
            iW = 0;
            while (i2 < size) {
                iW += zzdni.W(list.get(i2).longValue());
                i2++;
            }
        }
        return iW;
    }

    public static void e(int i2, List<Double> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.w(i2, list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T, FT extends zzdnu<FT>> void f(vu<FT> vuVar, T t, T t2) {
        yu<T> yuVarI = vuVar.i(t2);
        if (yuVarI.b()) {
            return;
        }
        vuVar.j(t).h(yuVarI);
    }

    static <T> void g(uv uvVar, T t, T t2, long j2) {
        gx.g(t, j2, uvVar.a(gx.L(t, j2), gx.L(t2, j2)));
    }

    static <T, UT, UB> void h(cx<UT, UB> cxVar, T t, T t2) {
        cxVar.q(t, cxVar.s(cxVar.j(t), cxVar.j(t2)));
    }

    static int i(List<Long> list) {
        int iX;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ov) {
            ov ovVar = (ov) list;
            iX = 0;
            while (i2 < size) {
                iX += zzdni.X(ovVar.f(i2));
                i2++;
            }
        } else {
            iX = 0;
            while (i2 < size) {
                iX += zzdni.X(list.get(i2).longValue());
                i2++;
            }
        }
        return iX;
    }

    static int j(List<Integer> list) {
        int iN0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            iN0 = 0;
            while (i2 < size) {
                iN0 += zzdni.n0(gvVar.f(i2));
                i2++;
            }
        } else {
            iN0 = 0;
            while (i2 < size) {
                iN0 += zzdni.n0(list.get(i2).intValue());
                i2++;
            }
        }
        return iN0;
    }

    static int k(List<Integer> list) {
        int iI0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            iI0 = 0;
            while (i2 < size) {
                iI0 += zzdni.i0(gvVar.f(i2));
                i2++;
            }
        } else {
            iI0 = 0;
            while (i2 < size) {
                iI0 += zzdni.i0(list.get(i2).intValue());
                i2++;
            }
        }
        return iI0;
    }

    static int l(List<Integer> list) {
        int iJ0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            iJ0 = 0;
            while (i2 < size) {
                iJ0 += zzdni.j0(gvVar.f(i2));
                i2++;
            }
        } else {
            iJ0 = 0;
            while (i2 < size) {
                iJ0 += zzdni.j0(list.get(i2).intValue());
                i2++;
            }
        }
        return iJ0;
    }

    static int m(List<Integer> list) {
        int iK0;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof gv) {
            gv gvVar = (gv) list;
            iK0 = 0;
            while (i2 < size) {
                iK0 += zzdni.k0(gvVar.f(i2));
                i2++;
            }
        } else {
            iK0 = 0;
            while (i2 < size) {
                iK0 += zzdni.k0(list.get(i2).intValue());
                i2++;
            }
        }
        return iK0;
    }

    static int n(List<?> list) {
        return list.size() << 2;
    }

    static int o(List<?> list) {
        return list.size() << 3;
    }

    static int p(List<?> list) {
        return list.size();
    }

    public static cx<?, ?> q() {
        return f13064b;
    }

    public static cx<?, ?> r() {
        return f13065c;
    }

    public static cx<?, ?> s() {
        return f13066d;
    }

    private static Class<?> t() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> u() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void v(int i2, List<zzdmr> list, ux uxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.x(i2, list);
    }

    public static void w(int i2, List<?> list, ux uxVar, lw lwVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.S(i2, list, lwVar);
    }

    public static void x(int i2, List<Float> list, ux uxVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        uxVar.z(i2, list, z);
    }

    private static cx<?, ?> y(boolean z) {
        try {
            Class<?> clsU = u();
            if (clsU == null) {
                return null;
            }
            return (cx) clsU.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    static int z(int i2, Object obj, lw lwVar) {
        return obj instanceof zzdor ? zzdni.d(i2, (zzdor) obj) : zzdni.z(i2, (zzdpk) obj, lwVar);
    }
}
