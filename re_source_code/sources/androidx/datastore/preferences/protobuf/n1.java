package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: UnknownFieldSetLiteSchema.java */
/* JADX INFO: loaded from: classes.dex */
class n1 extends l1<m1, m1> {
    n1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public m1 g(Object obj) {
        return ((y) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(m1 m1Var) {
        return m1Var.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(m1 m1Var) {
        return m1Var.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public m1 k(m1 m1Var, m1 m1Var2) {
        return m1Var2.equals(m1.e()) ? m1Var : m1.k(m1Var, m1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public m1 n() {
        return m1.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, m1 m1Var) {
        p(obj, m1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, m1 m1Var) {
        ((y) obj).unknownFields = m1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public m1 r(m1 m1Var) {
        m1Var.j();
        return m1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(m1 m1Var, s1 s1Var) throws IOException {
        m1Var.o(s1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(m1 m1Var, s1 s1Var) throws IOException {
        m1Var.q(s1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.l1
    void j(Object obj) {
        g(obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.l1
    boolean q(e1 e1Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(m1 m1Var, int i2, int i3) {
        m1Var.n(r1.c(i2, 5), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(m1 m1Var, int i2, long j2) {
        m1Var.n(r1.c(i2, 1), Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(m1 m1Var, int i2, m1 m1Var2) {
        m1Var.n(r1.c(i2, 3), m1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(m1 m1Var, int i2, h hVar) {
        m1Var.n(r1.c(i2, 2), hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(m1 m1Var, int i2, long j2) {
        m1Var.n(r1.c(i2, 0), Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.l1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public m1 f(Object obj) {
        m1 m1VarG = g(obj);
        if (m1VarG != m1.e()) {
            return m1VarG;
        }
        m1 m1VarL = m1.l();
        p(obj, m1VarL);
        return m1VarL;
    }
}
