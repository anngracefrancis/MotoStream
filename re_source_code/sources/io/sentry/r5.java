package io.sentry;

import cm.aptoide.pt.BuildConfig;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: TransactionContext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r5 extends f5 {
    private static final io.sentry.protocol.z p = io.sentry.protocol.z.CUSTOM;
    private String q;
    private io.sentry.protocol.z r;
    private q5 s;
    private u0 t;
    private h2 u;

    @ApiStatus.Internal
    public r5(String str, io.sentry.protocol.z zVar, String str2) {
        this(str, zVar, str2, null);
    }

    @ApiStatus.Internal
    public static r5 q(o3 o3Var) {
        q5 q5Var;
        Boolean boolF = o3Var.f();
        q5 q5Var2 = boolF == null ? null : new q5(boolF);
        u0 u0VarB = o3Var.b();
        if (u0VarB != null) {
            u0VarB.a();
            Double dH = u0VarB.h();
            Boolean boolValueOf = Boolean.valueOf(boolF != null ? boolF.booleanValue() : false);
            if (dH != null) {
                q5Var = new q5(boolValueOf, dH);
            } else {
                q5Var2 = new q5(boolValueOf);
                q5Var = q5Var2;
            }
        } else {
            q5Var = q5Var2;
        }
        return new r5(o3Var.e(), o3Var.d(), o3Var.c(), q5Var, u0VarB);
    }

    public u0 r() {
        return this.t;
    }

    public h2 s() {
        return this.u;
    }

    public String t() {
        return this.q;
    }

    public q5 u() {
        return this.s;
    }

    public io.sentry.protocol.z v() {
        return this.r;
    }

    @ApiStatus.Internal
    public r5(String str, io.sentry.protocol.z zVar, String str2, q5 q5Var) {
        super(str2);
        this.u = h2.SENTRY;
        this.q = (String) io.sentry.util.q.c(str, "name is required");
        this.r = zVar;
        n(q5Var);
    }

    @ApiStatus.Internal
    public r5(io.sentry.protocol.q qVar, h5 h5Var, h5 h5Var2, q5 q5Var, u0 u0Var) {
        super(qVar, h5Var, BuildConfig.APTOIDE_THEME, h5Var2, null);
        this.u = h2.SENTRY;
        this.q = "<unlabeled transaction>";
        this.s = q5Var;
        this.r = p;
        this.t = u0Var;
    }
}
