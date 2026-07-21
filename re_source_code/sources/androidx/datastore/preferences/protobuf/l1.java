package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: UnknownFieldSchema.java */
/* JADX INFO: loaded from: classes.dex */
abstract class l1<T, B> {
    l1() {
    }

    abstract void a(B b2, int i2, int i3);

    abstract void b(B b2, int i2, long j2);

    abstract void c(B b2, int i2, T t);

    abstract void d(B b2, int i2, h hVar);

    abstract void e(B b2, int i2, long j2);

    abstract B f(Object obj);

    abstract T g(Object obj);

    abstract int h(T t);

    abstract int i(T t);

    abstract void j(Object obj);

    abstract T k(T t, T t2);

    final void l(B b2, e1 e1Var) throws IOException {
        while (e1Var.A() != Integer.MAX_VALUE && m(b2, e1Var)) {
        }
    }

    final boolean m(B b2, e1 e1Var) throws IOException {
        int tag = e1Var.getTag();
        int iA = r1.a(tag);
        int iB = r1.b(tag);
        if (iB == 0) {
            e(b2, iA, e1Var.L());
            return true;
        }
        if (iB == 1) {
            b(b2, iA, e1Var.f());
            return true;
        }
        if (iB == 2) {
            d(b2, iA, e1Var.C());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            a(b2, iA, e1Var.k());
            return true;
        }
        B bN = n();
        int iC = r1.c(iA, 4);
        l(bN, e1Var);
        if (iC != e1Var.getTag()) {
            throw InvalidProtocolBufferException.a();
        }
        c(b2, iA, r(bN));
        return true;
    }

    abstract B n();

    abstract void o(Object obj, B b2);

    abstract void p(Object obj, T t);

    abstract boolean q(e1 e1Var);

    abstract T r(B b2);

    abstract void s(T t, s1 s1Var) throws IOException;

    abstract void t(T t, s1 s1Var) throws IOException;
}
