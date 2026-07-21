package io.sentry;

/* JADX INFO: compiled from: NoOpSpan.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c3 implements d2 {
    private static final c3 a = new c3();

    private c3() {
    }

    public static c3 r() {
        return a;
    }

    @Override // io.sentry.d2
    public boolean b() {
        return false;
    }

    @Override // io.sentry.d2
    public boolean c(f4 f4Var) {
        return false;
    }

    @Override // io.sentry.d2
    public void d(j5 j5Var) {
    }

    @Override // io.sentry.d2
    public void g() {
    }

    @Override // io.sentry.d2
    public String getDescription() {
        return null;
    }

    @Override // io.sentry.d2
    public j5 getStatus() {
        return null;
    }

    @Override // io.sentry.d2
    public void h(String str, Number number, v2 v2Var) {
    }

    @Override // io.sentry.d2
    public void j(String str) {
    }

    @Override // io.sentry.d2
    public f5 m() {
        return new f5(io.sentry.protocol.q.f22645f, h5.f22423f, "op", null, null);
    }

    @Override // io.sentry.d2
    public f4 n() {
        return new v4();
    }

    @Override // io.sentry.d2
    public void o(j5 j5Var, f4 f4Var) {
    }

    @Override // io.sentry.d2
    public f4 q() {
        return new v4();
    }
}
