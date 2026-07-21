package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: PropagationContext.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class o3 {
    private io.sentry.protocol.q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h5 f22523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h5 f22524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f22525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private u0 f22526e;

    public o3() {
        this(new io.sentry.protocol.q(), new h5(), null, null, null);
    }

    private static u0 a(u0 u0Var) {
        if (u0Var != null) {
            return new u0(u0Var);
        }
        return null;
    }

    public u0 b() {
        return this.f22526e;
    }

    public h5 c() {
        return this.f22524c;
    }

    public h5 d() {
        return this.f22523b;
    }

    public io.sentry.protocol.q e() {
        return this.a;
    }

    public Boolean f() {
        return this.f22525d;
    }

    public void g(u0 u0Var) {
        this.f22526e = u0Var;
    }

    public o5 h() {
        u0 u0Var = this.f22526e;
        if (u0Var != null) {
            return u0Var.F();
        }
        return null;
    }

    public o3(o3 o3Var) {
        this(o3Var.e(), o3Var.d(), o3Var.c(), a(o3Var.b()), o3Var.f());
    }

    public o3(io.sentry.protocol.q qVar, h5 h5Var, h5 h5Var2, u0 u0Var, Boolean bool) {
        this.a = qVar;
        this.f22523b = h5Var;
        this.f22524c = h5Var2;
        this.f22526e = u0Var;
        this.f22525d = bool;
    }
}
