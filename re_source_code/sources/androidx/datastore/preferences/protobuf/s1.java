package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Writer.java */
/* JADX INFO: loaded from: classes.dex */
interface s1 {

    /* JADX INFO: compiled from: Writer.java */
    public enum a {
        ASCENDING,
        DESCENDING
    }

    void A(int i2, List<Boolean> list, boolean z) throws IOException;

    void B(int i2, List<Integer> list, boolean z) throws IOException;

    void C(int i2, List<Long> list, boolean z) throws IOException;

    void D(int i2, long j2) throws IOException;

    void E(int i2, float f2) throws IOException;

    @Deprecated
    void F(int i2) throws IOException;

    void G(int i2, List<Integer> list, boolean z) throws IOException;

    void H(int i2, int i3) throws IOException;

    void I(int i2, List<Long> list, boolean z) throws IOException;

    void J(int i2, List<Integer> list, boolean z) throws IOException;

    void K(int i2, List<Double> list, boolean z) throws IOException;

    <K, V> void L(int i2, j0.a<K, V> aVar, Map<K, V> map) throws IOException;

    void M(int i2, int i3) throws IOException;

    void N(int i2, List<h> list) throws IOException;

    @Deprecated
    void O(int i2, Object obj, f1 f1Var) throws IOException;

    void a(int i2, List<Float> list, boolean z) throws IOException;

    void b(int i2, int i3) throws IOException;

    void c(int i2, Object obj) throws IOException;

    void d(int i2, int i3) throws IOException;

    void e(int i2, double d2) throws IOException;

    void f(int i2, List<Long> list, boolean z) throws IOException;

    void g(int i2, List<Long> list, boolean z) throws IOException;

    void h(int i2, long j2) throws IOException;

    a i();

    void j(int i2, List<?> list, f1 f1Var) throws IOException;

    void k(int i2, List<String> list) throws IOException;

    @Deprecated
    void l(int i2, List<?> list, f1 f1Var) throws IOException;

    void m(int i2, String str) throws IOException;

    void n(int i2, long j2) throws IOException;

    void o(int i2, List<Integer> list, boolean z) throws IOException;

    void p(int i2, long j2) throws IOException;

    void q(int i2, boolean z) throws IOException;

    void r(int i2, int i3) throws IOException;

    @Deprecated
    void s(int i2) throws IOException;

    void t(int i2, int i3) throws IOException;

    void u(int i2, List<Long> list, boolean z) throws IOException;

    void v(int i2, List<Integer> list, boolean z) throws IOException;

    void w(int i2, h hVar) throws IOException;

    void x(int i2, long j2) throws IOException;

    void y(int i2, List<Integer> list, boolean z) throws IOException;

    void z(int i2, Object obj, f1 f1Var) throws IOException;
}
