package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ExceptionUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class k {
    public static Throwable a(Throwable th) {
        q.c(th, "throwable cannot be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }
}
