package io.sentry;

/* JADX INFO: compiled from: NoOpHub.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y2 implements v1 {
    private static final y2 a = new y2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x4 f22821b = x4.empty();

    private y2() {
    }

    public static y2 a() {
        return a;
    }

    @Override // io.sentry.v1
    public void close() {
    }

    @Override // io.sentry.v1
    public void endSession() {
    }

    @Override // io.sentry.v1
    public void h(long j2) {
    }

    @Override // io.sentry.v1
    public /* synthetic */ void i(v0 v0Var) {
        u1.a(this, v0Var);
    }

    @Override // io.sentry.v1
    public boolean isEnabled() {
        return false;
    }

    @Override // io.sentry.v1
    public io.sentry.protocol.q j(h4 h4Var, n1 n1Var) {
        return io.sentry.protocol.q.f22645f;
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q k(l4 l4Var) {
        return u1.c(this, l4Var);
    }

    @Override // io.sentry.v1
    public e2 l(r5 r5Var, t5 t5Var) {
        return d3.r();
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q m(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var) {
        return u1.d(this, xVar, o5Var, n1Var);
    }

    @Override // io.sentry.v1
    public void n(v0 v0Var, n1 n1Var) {
    }

    @Override // io.sentry.v1
    public void o(t3 t3Var) {
    }

    @Override // io.sentry.v1
    public void p(Throwable th, d2 d2Var, String str) {
    }

    @Override // io.sentry.v1
    public x4 q() {
        return this.f22821b;
    }

    @Override // io.sentry.v1
    public io.sentry.protocol.q r(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var, m3 m3Var) {
        return io.sentry.protocol.q.f22645f;
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q s(h4 h4Var) {
        return u1.b(this, h4Var);
    }

    @Override // io.sentry.v1
    public void startSession() {
    }

    @Override // io.sentry.v1
    public io.sentry.protocol.q t(l4 l4Var, n1 n1Var) {
        return io.sentry.protocol.q.f22645f;
    }

    @Override // io.sentry.v1
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v1 m373clone() {
        return a;
    }
}
