package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
interface q3 {
    void A(List<Float> list) throws IOException;

    void B(List<Integer> list) throws IOException;

    void C(List<Integer> list) throws IOException;

    <K, V> void D(Map<K, V> map, z2<K, V> z2Var, zzeq zzeqVar) throws IOException;

    void E(List<Boolean> list) throws IOException;

    void F(List<Integer> list) throws IOException;

    void G(List<Long> list) throws IOException;

    void H(List<Double> list) throws IOException;

    @Deprecated
    <T> void I(List<T> list, p3<T> p3Var, zzeq zzeqVar) throws IOException;

    <T> T J(p3<T> p3Var, zzeq zzeqVar) throws IOException;

    @Deprecated
    <T> T K(p3<T> p3Var, zzeq zzeqVar) throws IOException;

    void L(List<Integer> list) throws IOException;

    void M(List<Long> list) throws IOException;

    <T> void N(List<T> list, p3<T> p3Var, zzeq zzeqVar) throws IOException;

    boolean O() throws IOException;

    int a() throws IOException;

    int b();

    boolean c() throws IOException;

    double d() throws IOException;

    float e() throws IOException;

    zzdu f() throws IOException;

    int g() throws IOException;

    long h() throws IOException;

    void i(List<Integer> list) throws IOException;

    String j() throws IOException;

    int k() throws IOException;

    long l() throws IOException;

    int m() throws IOException;

    void n(List<Long> list) throws IOException;

    void o(List<String> list) throws IOException;

    int p() throws IOException;

    long q() throws IOException;

    void r(List<String> list) throws IOException;

    long s() throws IOException;

    void t(List<Long> list) throws IOException;

    void u(List<Integer> list) throws IOException;

    void u0(List<Long> list) throws IOException;

    int v() throws IOException;

    String w() throws IOException;

    int x() throws IOException;

    long y() throws IOException;

    void z(List<zzdu> list) throws IOException;
}
