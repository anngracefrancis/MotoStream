package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c2 implements y4 {
    private final zzen a;

    private c2(zzen zzenVar) {
        zzen zzenVar2 = (zzen) zzff.f(zzenVar, "output");
        this.a = zzenVar2;
        zzenVar2.f17377c = this;
    }

    public static c2 P(zzen zzenVar) {
        c2 c2Var = zzenVar.f17377c;
        return c2Var != null ? c2Var : new c2(zzenVar);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void A(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (!(list instanceof zzfv)) {
            while (i3 < list.size()) {
                this.a.r(i2, list.get(i3));
                i3++;
            }
            return;
        }
        zzfv zzfvVar = (zzfv) list;
        while (i3 < list.size()) {
            Object objE = zzfvVar.e(i3);
            if (objE instanceof String) {
                this.a.r(i2, (String) objE);
            } else {
                this.a.o(i2, (zzdu) objE);
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void B(int i2, boolean z) throws IOException {
        this.a.s(i2, z);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void C(int i2, Object obj, p3 p3Var) throws IOException {
        this.a.q(i2, (zzgo) obj, p3Var);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void D(int i2, int i3) throws IOException {
        this.a.P(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void E(int i2, zzdu zzduVar) throws IOException {
        this.a.o(i2, zzduVar);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void F(int i2, Object obj, p3 p3Var) throws IOException {
        zzen zzenVar = this.a;
        zzenVar.m(i2, 3);
        p3Var.h((zzgo) obj, zzenVar.f17377c);
        zzenVar.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void G(int i2, int i3) throws IOException {
        this.a.P(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void H(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void I(int i2, List<?> list, p3 p3Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            F(i2, list.get(i3), p3Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void J(int i2, int i3) throws IOException {
        this.a.f0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void K(int i2, List<?> list, p3 p3Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            C(i2, list.get(i3), p3Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void L(int i2, long j2) throws IOException {
        this.a.Y(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void M(int i2, int i3) throws IOException {
        this.a.X(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void N(int i2, long j2) throws IOException {
        this.a.Q(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final <K, V> void O(int i2, z2<K, V> z2Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.a.m(i2, 2);
            this.a.O(zzgg.a(z2Var, entry.getKey(), entry.getValue()));
            zzgg.b(this.a, z2Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final int a() {
        return zzfd.zze.l;
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void b(int i2, long j2) throws IOException {
        this.a.Y(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void c(int i2, long j2) throws IOException {
        this.a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void d(int i2) throws IOException {
        this.a.m(i2, 3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void e(int i2) throws IOException {
        this.a.m(i2, 4);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void f(int i2, Object obj) throws IOException {
        if (obj instanceof zzdu) {
            this.a.R(i2, (zzdu) obj);
        } else {
            this.a.p(i2, (zzgo) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void g(int i2, String str) throws IOException {
        this.a.r(i2, str);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void h(int i2, double d2) throws IOException {
        this.a.k(i2, d2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void i(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.s(i2, list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iL = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iL += zzen.L(list.get(i4).booleanValue());
        }
        this.a.O(iL);
        while (i3 < list.size()) {
            this.a.y(list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void j(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.P(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iK0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iK0 += zzen.k0(list.get(i4).intValue());
        }
        this.a.O(iK0);
        while (i3 < list.size()) {
            this.a.j(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.P(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iB0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iB0 += zzen.B0(list.get(i4).intValue());
        }
        this.a.O(iB0);
        while (i3 < list.size()) {
            this.a.j(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void l(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.n(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iD0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iD0 += zzen.d0(list.get(i4).longValue());
        }
        this.a.O(iD0);
        while (i3 < list.size()) {
            this.a.t(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void m(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.Y(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iV0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iV0 += zzen.v0(list.get(i4).longValue());
        }
        this.a.O(iV0);
        while (i3 < list.size()) {
            this.a.Z(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.j0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iW0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iW0 += zzen.w0(list.get(i4).intValue());
        }
        this.a.O(iW0);
        while (i3 < list.size()) {
            this.a.e0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void o(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.X(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iO0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iO0 += zzen.o0(list.get(i4).intValue());
        }
        this.a.O(iO0);
        while (i3 < list.size()) {
            this.a.O(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void p(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.j0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iZ0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZ0 += zzen.z0(list.get(i4).intValue());
        }
        this.a.O(iZ0);
        while (i3 < list.size()) {
            this.a.e0(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void q(int i2, long j2) throws IOException {
        this.a.n(i2, j2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void r(int i2, float f2) throws IOException {
        this.a.l(i2, f2);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void s(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.Y(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iR0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iR0 += zzen.r0(list.get(i4).longValue());
        }
        this.a.O(iR0);
        while (i3 < list.size()) {
            this.a.Z(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void t(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.Q(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iN0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iN0 += zzen.n0(list.get(i4).longValue());
        }
        this.a.O(iN0);
        while (i3 < list.size()) {
            this.a.S(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void u(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.n(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iI0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iI0 += zzen.i0(list.get(i4).longValue());
        }
        this.a.O(iI0);
        while (i3 < list.size()) {
            this.a.t(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void v(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.f0(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iS0 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iS0 += zzen.s0(list.get(i4).intValue());
        }
        this.a.O(iS0);
        while (i3 < list.size()) {
            this.a.W(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void w(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.k(i2, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iZ = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iZ += zzen.z(list.get(i4).doubleValue());
        }
        this.a.O(iZ);
        while (i3 < list.size()) {
            this.a.h(list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void x(int i2, List<zzdu> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.a.o(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void y(int i2, int i3) throws IOException {
        this.a.j0(i2, i3);
    }

    @Override // com.google.android.gms.internal.measurement.y4
    public final void z(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.a.l(i2, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        this.a.m(i2, 2);
        int iA = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            iA += zzen.A(list.get(i4).floatValue());
        }
        this.a.O(iA);
        while (i3 < list.size()) {
            this.a.i(list.get(i3).floatValue());
            i3++;
        }
    }
}
