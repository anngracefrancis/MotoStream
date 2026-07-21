package io.sentry.transport;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: CurrentDateProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class o implements q {
    private static final q a = new o();

    private o() {
    }

    public static q b() {
        return a;
    }

    @Override // io.sentry.transport.q
    public final long a() {
        return System.currentTimeMillis();
    }
}
