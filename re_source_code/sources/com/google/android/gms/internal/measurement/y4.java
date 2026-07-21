package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
interface y4 {
    void A(int i2, List<String> list) throws IOException;

    void B(int i2, boolean z) throws IOException;

    void C(int i2, Object obj, p3 p3Var) throws IOException;

    void D(int i2, int i3) throws IOException;

    void E(int i2, zzdu zzduVar) throws IOException;

    @Deprecated
    void F(int i2, Object obj, p3 p3Var) throws IOException;

    void G(int i2, int i3) throws IOException;

    void H(int i2, int i3) throws IOException;

    @Deprecated
    void I(int i2, List<?> list, p3 p3Var) throws IOException;

    void J(int i2, int i3) throws IOException;

    void K(int i2, List<?> list, p3 p3Var) throws IOException;

    void L(int i2, long j2) throws IOException;

    void M(int i2, int i3) throws IOException;

    void N(int i2, long j2) throws IOException;

    <K, V> void O(int i2, z2<K, V> z2Var, Map<K, V> map) throws IOException;

    int a();

    void b(int i2, long j2) throws IOException;

    void c(int i2, long j2) throws IOException;

    @Deprecated
    void d(int i2) throws IOException;

    @Deprecated
    void e(int i2) throws IOException;

    void f(int i2, Object obj) throws IOException;

    void g(int i2, String str) throws IOException;

    void h(int i2, double d2) throws IOException;

    void i(int i2, List<Boolean> list, boolean z) throws IOException;

    void j(int i2, List<Integer> list, boolean z) throws IOException;

    void k(int i2, List<Integer> list, boolean z) throws IOException;

    void l(int i2, List<Long> list, boolean z) throws IOException;

    void m(int i2, List<Long> list, boolean z) throws IOException;

    void n(int i2, List<Integer> list, boolean z) throws IOException;

    void o(int i2, List<Integer> list, boolean z) throws IOException;

    void p(int i2, List<Integer> list, boolean z) throws IOException;

    void q(int i2, long j2) throws IOException;

    void r(int i2, float f2) throws IOException;

    void s(int i2, List<Long> list, boolean z) throws IOException;

    void t(int i2, List<Long> list, boolean z) throws IOException;

    void u(int i2, List<Long> list, boolean z) throws IOException;

    void v(int i2, List<Integer> list, boolean z) throws IOException;

    void w(int i2, List<Double> list, boolean z) throws IOException;

    void x(int i2, List<zzdu> list) throws IOException;

    void y(int i2, int i3) throws IOException;

    void z(int i2, List<Float> list, boolean z) throws IOException;
}
