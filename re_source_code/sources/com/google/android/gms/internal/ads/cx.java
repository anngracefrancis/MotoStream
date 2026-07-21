package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
abstract class cx<T, B> {
    cx() {
    }

    abstract void a(B b2, int i2, long j2);

    abstract void b(B b2, int i2, zzdmr zzdmrVar);

    abstract void c(B b2, int i2, T t);

    abstract void d(T t, ux uxVar) throws IOException;

    abstract boolean e(kw kwVar);

    final boolean f(B b2, kw kwVar) throws IOException {
        int tag = kwVar.getTag();
        int i2 = tag >>> 3;
        int i3 = tag & 7;
        if (i3 == 0) {
            a(b2, i2, kwVar.K());
            return true;
        }
        if (i3 == 1) {
            n(b2, i2, kwVar.L());
            return true;
        }
        if (i3 == 2) {
            b(b2, i2, kwVar.T());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw zzdok.f();
            }
            o(b2, i2, kwVar.R());
            return true;
        }
        B bM = m();
        int i4 = 4 | (i2 << 3);
        while (kwVar.N() != Integer.MAX_VALUE && f(bM, kwVar)) {
        }
        if (i4 != kwVar.getTag()) {
            throw zzdok.e();
        }
        c(b2, i2, h(bM));
        return true;
    }

    abstract void g(Object obj);

    abstract T h(B b2);

    abstract int i(T t);

    abstract T j(Object obj);

    abstract B k(Object obj);

    abstract int l(T t);

    abstract B m();

    abstract void n(B b2, int i2, long j2);

    abstract void o(B b2, int i2, int i3);

    abstract void p(T t, ux uxVar) throws IOException;

    abstract void q(Object obj, T t);

    abstract void r(Object obj, B b2);

    abstract T s(T t, T t2);
}
