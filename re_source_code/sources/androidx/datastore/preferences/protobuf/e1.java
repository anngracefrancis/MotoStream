package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Reader.java */
/* JADX INFO: loaded from: classes.dex */
interface e1 {
    int A() throws IOException;

    void B(List<String> list) throws IOException;

    h C() throws IOException;

    void D(List<Float> list) throws IOException;

    int E() throws IOException;

    @Deprecated
    <T> void F(List<T> list, f1<T> f1Var, p pVar) throws IOException;

    boolean G() throws IOException;

    int H() throws IOException;

    void I(List<h> list) throws IOException;

    void J(List<Double> list) throws IOException;

    <T> void K(List<T> list, f1<T> f1Var, p pVar) throws IOException;

    long L() throws IOException;

    String M() throws IOException;

    void N(List<Long> list) throws IOException;

    @Deprecated
    <T> T O(f1<T> f1Var, p pVar) throws IOException;

    String a() throws IOException;

    void b(List<String> list) throws IOException;

    <T> T c(f1<T> f1Var, p pVar) throws IOException;

    void d(List<Integer> list) throws IOException;

    long e() throws IOException;

    long f() throws IOException;

    <T> T g(Class<T> cls, p pVar) throws IOException;

    int getTag();

    void h(List<Integer> list) throws IOException;

    void i(List<Long> list) throws IOException;

    void j(List<Integer> list) throws IOException;

    int k() throws IOException;

    boolean l() throws IOException;

    long m() throws IOException;

    void n(List<Long> list) throws IOException;

    @Deprecated
    <T> T o(Class<T> cls, p pVar) throws IOException;

    int p() throws IOException;

    void q(List<Long> list) throws IOException;

    void r(List<Long> list) throws IOException;

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    void s(List<Integer> list) throws IOException;

    void t(List<Integer> list) throws IOException;

    <K, V> void u(Map<K, V> map, j0.a<K, V> aVar, p pVar) throws IOException;

    int v() throws IOException;

    void w(List<Integer> list) throws IOException;

    int x() throws IOException;

    long y() throws IOException;

    void z(List<Boolean> list) throws IOException;
}
