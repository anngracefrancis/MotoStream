package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CodedOutputStreamWriter.java */
/* JADX INFO: loaded from: classes.dex */
final class l implements s1 {
    private final CodedOutputStream a;

    /* JADX INFO: compiled from: CodedOutputStreamWriter.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.b.values().length];
            a = iArr;
            try {
                iArr[r1.b.m.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r1.b.l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r1.b.f1401j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r1.b.t.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r1.b.v.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r1.b.r.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r1.b.f1402k.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r1.b.f1399h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r1.b.u.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r1.b.w.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r1.b.f1400i.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r1.b.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private l(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) a0.b(codedOutputStream, "output");
        this.a = codedOutputStream2;
        codedOutputStream2.f1241c = this;
    }

    public static l P(CodedOutputStream codedOutputStream) {
        l lVar = codedOutputStream.f1241c;
        return lVar != null ? lVar : new l(codedOutputStream);
    }

    private <V> void Q(int i2, boolean z, V v, j0.a<Boolean, V> aVar) throws IOException {
        this.a.W0(i2, 2);
        this.a.Y0(j0.b(aVar, Boolean.valueOf(z), v));
        j0.e(this.a, aVar, Boolean.valueOf(z), v);
    }

    private <V> void R(int i2, j0.a<Integer, V> aVar, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = it.next().intValue();
            i3++;
        }
        Arrays.sort(iArr);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            V v = map.get(Integer.valueOf(i5));
            this.a.W0(i2, 2);
            this.a.Y0(j0.b(aVar, Integer.valueOf(i5), v));
            j0.e(this.a, aVar, Integer.valueOf(i5), v);
        }
    }

    private <V> void S(int i2, j0.a<Long, V> aVar, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            jArr[i3] = it.next().longValue();
            i3++;
        }
        Arrays.sort(jArr);
        for (int i4 = 0; i4 < size; i4++) {
            long j2 = jArr[i4];
            V v = map.get(Long.valueOf(j2));
            this.a.W0(i2, 2);
            this.a.Y0(j0.b(aVar, Long.valueOf(j2), v));
            j0.e(this.a, aVar, Long.valueOf(j2), v);
        }
    }

    private <K, V> void T(int i2, j0.a<K, V> aVar, Map<K, V> map) throws IOException {
        switch (a.a[aVar.a.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    Q(i2, false, v, aVar);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    Q(i2, true, v2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i2, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i2, aVar, map);
                return;
            case 12:
                U(i2, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.a);
        }
    }

    private <V> void U(int i2, j0.a<String, V> aVar, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            strArr[i3] = it.next();
            i3++;
        }
        Arrays.sort(strArr);
        for (int i4 = 0; i4 < size; i4++) {
            String str = strArr[i4];
            V v = map.get(str);
            this.a.W0(i2, 2);
            this.a.Y0(j0.b(aVar, str, v));
            j0.e(this.a, aVar, str, v);
        }
    }

    private void V(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            this.a.U0(i2, (String) obj);
        } else {
            this.a.o0(i2, (h) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void A(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.k0(i2, list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iE = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iE += CodedOutputStream.e(list.get(i4).booleanValue());
        }
        this.a.Y0(iE);
        while (i3 < list.size()) {
            this.a.l0(list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void B(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.X0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iX = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iX += CodedOutputStream.X(list.get(i4).intValue());
        }
        this.a.Y0(iX);
        while (i3 < list.size()) {
            this.a.Y0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void C(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.S0(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iS = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iS += CodedOutputStream.S(list.get(i4).longValue());
        }
        this.a.Y0(iS);
        while (i3 < list.size()) {
            this.a.T0(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void D(int i2, long j2) throws IOException {
        this.a.S0(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void E(int i2, float f2) throws IOException {
        this.a.y0(i2, f2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void F(int i2) throws IOException {
        this.a.W0(i2, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void G(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.Q0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iQ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iQ += CodedOutputStream.Q(list.get(i4).intValue());
        }
        this.a.Y0(iQ);
        while (i3 < list.size()) {
            this.a.R0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void H(int i2, int i3) throws IOException {
        this.a.s0(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void I(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.G0(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iY = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iY += CodedOutputStream.y(list.get(i4).longValue());
        }
        this.a.Y0(iY);
        while (i3 < list.size()) {
            this.a.H0(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void J(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.s0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iL = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iL += CodedOutputStream.l(list.get(i4).intValue());
        }
        this.a.Y0(iL);
        while (i3 < list.size()) {
            this.a.t0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void K(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.q0(i2, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iJ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iJ += CodedOutputStream.j(list.get(i4).doubleValue());
        }
        this.a.Y0(iJ);
        while (i3 < list.size()) {
            this.a.r0(list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public <K, V> void L(int i2, j0.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.a.e0()) {
            T(i2, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.W0(i2, 2);
            this.a.Y0(j0.b(aVar, entry.getKey(), entry.getValue()));
            j0.e(this.a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void M(int i2, int i3) throws IOException {
        this.a.Q0(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void N(int i2, List<h> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.o0(i2, list.get(i3));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void O(int i2, Object obj, f1 f1Var) throws IOException {
        this.a.B0(i2, (q0) obj, f1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void a(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.y0(i2, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iR = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iR += CodedOutputStream.r(list.get(i4).floatValue());
        }
        this.a.Y0(iR);
        while (i3 < list.size()) {
            this.a.z0(list.get(i3).floatValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void b(int i2, int i3) throws IOException {
        this.a.X0(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public final void c(int i2, Object obj) throws IOException {
        if (obj instanceof h) {
            this.a.L0(i2, (h) obj);
        } else {
            this.a.K0(i2, (q0) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void d(int i2, int i3) throws IOException {
        this.a.u0(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void e(int i2, double d2) throws IOException {
        this.a.q0(i2, d2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void f(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.O0(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iO = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iO += CodedOutputStream.O(list.get(i4).longValue());
        }
        this.a.Y0(iO);
        while (i3 < list.size()) {
            this.a.P0(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void g(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.Z0(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iZ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZ += CodedOutputStream.Z(list.get(i4).longValue());
        }
        this.a.Y0(iZ);
        while (i3 < list.size()) {
            this.a.a1(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void h(int i2, long j2) throws IOException {
        this.a.w0(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public s1.a i() {
        return s1.a.ASCENDING;
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void j(int i2, List<?> list, f1 f1Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            z(i2, list.get(i3), f1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void k(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (!(list instanceof f0)) {
            while (i3 < list.size()) {
                this.a.U0(i2, list.get(i3));
                i3++;
            }
        } else {
            f0 f0Var = (f0) list;
            while (i3 < list.size()) {
                V(i2, f0Var.c1(i3));
                i3++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void l(int i2, List<?> list, f1 f1Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            O(i2, list.get(i3), f1Var);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void m(int i2, String str) throws IOException {
        this.a.U0(i2, str);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void n(int i2, long j2) throws IOException {
        this.a.Z0(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.E0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iW = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iW += CodedOutputStream.w(list.get(i4).intValue());
        }
        this.a.Y0(iW);
        while (i3 < list.size()) {
            this.a.F0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void p(int i2, long j2) throws IOException {
        this.a.G0(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void q(int i2, boolean z) throws IOException {
        this.a.k0(i2, z);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void r(int i2, int i3) throws IOException {
        this.a.M0(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void s(int i2) throws IOException {
        this.a.W0(i2, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void t(int i2, int i3) throws IOException {
        this.a.E0(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.w0(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iP = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iP += CodedOutputStream.p(list.get(i4).longValue());
        }
        this.a.Y0(iP);
        while (i3 < list.size()) {
            this.a.x0(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void v(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.M0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iM = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iM += CodedOutputStream.M(list.get(i4).intValue());
        }
        this.a.Y0(iM);
        while (i3 < list.size()) {
            this.a.N0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void w(int i2, h hVar) throws IOException {
        this.a.o0(i2, hVar);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void x(int i2, long j2) throws IOException {
        this.a.O0(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void y(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.u0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.W0(i2, 2);
        int iN = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iN += CodedOutputStream.n(list.get(i4).intValue());
        }
        this.a.Y0(iN);
        while (i3 < list.size()) {
            this.a.v0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.s1
    public void z(int i2, Object obj, f1 f1Var) throws IOException {
        this.a.I0(i2, (q0) obj, f1Var);
    }
}
