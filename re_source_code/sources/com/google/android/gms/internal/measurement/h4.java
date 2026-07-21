package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class h4<T, B> {
    h4() {
    }

    abstract B a();

    abstract T b(B b2);

    abstract void c(B b2, int i2, int i3);

    abstract void d(B b2, int i2, long j2);

    abstract void e(B b2, int i2, zzdu zzduVar);

    abstract void f(B b2, int i2, T t);

    abstract void g(T t, y4 y4Var) throws IOException;

    abstract void h(Object obj, T t);

    abstract boolean i(q3 q3Var);

    final boolean j(B b2, q3 q3Var) throws IOException {
        int iB = q3Var.b();
        int i2 = iB >>> 3;
        int i3 = iB & 7;
        if (i3 == 0) {
            d(b2, i2, q3Var.s());
            return true;
        }
        if (i3 == 1) {
            l(b2, i2, q3Var.l());
            return true;
        }
        if (i3 == 2) {
            e(b2, i2, q3Var.f());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw zzfo.f();
            }
            c(b2, i2, q3Var.v());
            return true;
        }
        B bA = a();
        int i4 = 4 | (i2 << 3);
        while (q3Var.a() != Integer.MAX_VALUE && j(bA, q3Var)) {
        }
        if (i4 != q3Var.b()) {
            throw zzfo.e();
        }
        f(b2, i2, b(bA));
        return true;
    }

    abstract T k(Object obj);

    abstract void l(B b2, int i2, long j2);

    abstract void m(T t, y4 y4Var) throws IOException;

    abstract void n(Object obj, B b2);

    abstract B o(Object obj);

    abstract T p(T t, T t2);

    abstract void q(Object obj);

    abstract int r(T t);

    abstract int s(T t);
}
