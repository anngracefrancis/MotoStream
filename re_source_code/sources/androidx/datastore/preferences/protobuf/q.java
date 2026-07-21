package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u.b;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: ExtensionSchema.java */
/* JADX INFO: loaded from: classes.dex */
abstract class q<T extends u.b<T>> {
    q() {
    }

    abstract int a(Map.Entry<?, ?> entry);

    abstract Object b(p pVar, q0 q0Var, int i2);

    abstract u<T> c(Object obj);

    abstract u<T> d(Object obj);

    abstract boolean e(q0 q0Var);

    abstract void f(Object obj);

    abstract <UT, UB> UB g(e1 e1Var, Object obj, p pVar, u<T> uVar, UB ub, l1<UT, UB> l1Var) throws IOException;

    abstract void h(e1 e1Var, Object obj, p pVar, u<T> uVar) throws IOException;

    abstract void i(h hVar, Object obj, p pVar, u<T> uVar) throws IOException;

    abstract void j(s1 s1Var, Map.Entry<?, ?> entry) throws IOException;
}
