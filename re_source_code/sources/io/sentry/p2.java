package io.sentry;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: JsonObjectWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p2 implements h3 {
    private final io.sentry.vendor.gson.stream.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o2 f22544b;

    public p2(Writer writer, int i2) {
        this.a = new io.sentry.vendor.gson.stream.c(writer);
        this.f22544b = new o2(i2);
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public p2 l() throws IOException {
        this.a.c();
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public p2 f() throws IOException {
        this.a.d();
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public p2 j() throws IOException {
        this.a.f();
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public p2 d() throws IOException {
        this.a.j();
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public p2 k(String str) throws IOException {
        this.a.k(str);
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public p2 i() throws IOException {
        this.a.m();
        return this;
    }

    public void s(String str) {
        this.a.A(str);
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public p2 a(long j2) throws IOException {
        this.a.D(j2);
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public p2 g(w1 w1Var, Object obj) throws IOException {
        this.f22544b.a(this, w1Var, obj);
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public p2 h(Boolean bool) throws IOException {
        this.a.H(bool);
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public p2 e(Number number) throws IOException {
        this.a.I(number);
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public p2 b(String str) throws IOException {
        this.a.J(str);
        return this;
    }

    @Override // io.sentry.h3
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public p2 c(boolean z) throws IOException {
        this.a.K(z);
        return this;
    }
}
