package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: IHub.java */
/* JADX INFO: loaded from: classes2.dex */
public interface v1 {
    v1 clone();

    void close();

    void endSession();

    void h(long j2);

    void i(v0 v0Var);

    boolean isEnabled();

    io.sentry.protocol.q j(h4 h4Var, n1 n1Var);

    io.sentry.protocol.q k(l4 l4Var);

    e2 l(r5 r5Var, t5 t5Var);

    @ApiStatus.Internal
    io.sentry.protocol.q m(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var);

    void n(v0 v0Var, n1 n1Var);

    void o(t3 t3Var);

    @ApiStatus.Internal
    void p(Throwable th, d2 d2Var, String str);

    x4 q();

    @ApiStatus.Internal
    io.sentry.protocol.q r(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var, m3 m3Var);

    io.sentry.protocol.q s(h4 h4Var);

    void startSession();

    io.sentry.protocol.q t(l4 l4Var, n1 n1Var);
}
