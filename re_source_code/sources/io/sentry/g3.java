package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: NoOpTransportFactory.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class g3 implements g2 {
    private static final g3 a = new g3();

    private g3() {
    }

    public static g3 b() {
        return a;
    }

    @Override // io.sentry.g2
    public io.sentry.transport.r a(x4 x4Var, p3 p3Var) {
        return io.sentry.transport.u.a();
    }
}
