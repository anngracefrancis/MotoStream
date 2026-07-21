package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidCurrentDateProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class g implements io.sentry.transport.q {
    private static final io.sentry.transport.q a = new g();

    private g() {
    }

    public static io.sentry.transport.q b() {
        return a;
    }

    @Override // io.sentry.transport.q
    public long a() {
        return SystemClock.uptimeMillis();
    }
}
