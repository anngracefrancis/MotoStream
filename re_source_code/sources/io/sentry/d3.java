package io.sentry;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NoOpTransaction.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d3 implements e2 {
    private static final d3 a = new d3();

    private d3() {
    }

    public static d3 r() {
        return a;
    }

    @Override // io.sentry.d2
    public o5 a() {
        return new o5(io.sentry.protocol.q.f22645f, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // io.sentry.d2
    public boolean b() {
        return true;
    }

    @Override // io.sentry.d2
    public boolean c(f4 f4Var) {
        return false;
    }

    @Override // io.sentry.d2
    public void d(j5 j5Var) {
    }

    @Override // io.sentry.e2
    public void e(j5 j5Var, boolean z) {
    }

    @Override // io.sentry.d2
    public d2 f(String str, String str2, f4 f4Var, h2 h2Var) {
        return c3.r();
    }

    @Override // io.sentry.d2
    public void g() {
    }

    @Override // io.sentry.d2
    public String getDescription() {
        return null;
    }

    @Override // io.sentry.e2
    public String getName() {
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // io.sentry.d2
    public j5 getStatus() {
        return null;
    }

    @Override // io.sentry.d2
    public void h(String str, Number number, v2 v2Var) {
    }

    @Override // io.sentry.e2
    public e5 i() {
        return null;
    }

    @Override // io.sentry.d2
    public void j(String str) {
    }

    @Override // io.sentry.e2
    public io.sentry.protocol.q k() {
        return io.sentry.protocol.q.f22645f;
    }

    @Override // io.sentry.e2
    public void l() {
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

    @Override // io.sentry.e2
    public io.sentry.protocol.z p() {
        return io.sentry.protocol.z.CUSTOM;
    }

    @Override // io.sentry.d2
    public f4 q() {
        return new v4();
    }
}
