package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ISentryClient.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a2 {
    void a(d5 d5Var, n1 n1Var);

    io.sentry.protocol.q b(l4 l4Var, s3 s3Var, n1 n1Var);

    @ApiStatus.Internal
    io.sentry.protocol.q c(io.sentry.protocol.x xVar, o5 o5Var, s3 s3Var, n1 n1Var, m3 m3Var);

    void close();

    void h(long j2);

    io.sentry.protocol.q j(h4 h4Var, n1 n1Var);
}
