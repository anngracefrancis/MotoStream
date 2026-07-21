package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: HubAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q1 implements v1 {
    private static final q1 a = new q1();

    private q1() {
    }

    public static q1 a() {
        return a;
    }

    @Override // io.sentry.v1
    public void close() {
        a4.e();
    }

    @Override // io.sentry.v1
    public void endSession() {
        a4.g();
    }

    @Override // io.sentry.v1
    public void h(long j2) {
        a4.i(j2);
    }

    @Override // io.sentry.v1
    public /* synthetic */ void i(v0 v0Var) {
        u1.a(this, v0Var);
    }

    @Override // io.sentry.v1
    public boolean isEnabled() {
        return a4.p();
    }

    @Override // io.sentry.v1
    @ApiStatus.Internal
    public io.sentry.protocol.q j(h4 h4Var, n1 n1Var) {
        return a4.j().j(h4Var, n1Var);
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q k(l4 l4Var) {
        return u1.c(this, l4Var);
    }

    @Override // io.sentry.v1
    public e2 l(r5 r5Var, t5 t5Var) {
        return a4.u(r5Var, t5Var);
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q m(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var) {
        return u1.d(this, xVar, o5Var, n1Var);
    }

    @Override // io.sentry.v1
    public void n(v0 v0Var, n1 n1Var) {
        a4.a(v0Var, n1Var);
    }

    @Override // io.sentry.v1
    public void o(t3 t3Var) {
        a4.f(t3Var);
    }

    @Override // io.sentry.v1
    public void p(Throwable th, d2 d2Var, String str) {
        a4.j().p(th, d2Var, str);
    }

    @Override // io.sentry.v1
    public x4 q() {
        return a4.j().q();
    }

    @Override // io.sentry.v1
    public io.sentry.protocol.q r(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var, m3 m3Var) {
        return a4.j().r(xVar, o5Var, n1Var, m3Var);
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q s(h4 h4Var) {
        return u1.b(this, h4Var);
    }

    @Override // io.sentry.v1
    public void startSession() {
        a4.t();
    }

    @Override // io.sentry.v1
    public io.sentry.protocol.q t(l4 l4Var, n1 n1Var) {
        return a4.d(l4Var, n1Var);
    }

    @Override // io.sentry.v1
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v1 m372clone() {
        return a4.j().m373clone();
    }
}
