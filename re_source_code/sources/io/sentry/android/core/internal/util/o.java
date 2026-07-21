package io.sentry.android.core.internal.util;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DeviceOrientations.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class o {
    public static io.sentry.protocol.e.b a(int i2) {
        if (i2 == 1) {
            return io.sentry.protocol.e.b.PORTRAIT;
        }
        if (i2 != 2) {
            return null;
        }
        return io.sentry.protocol.e.b.LANDSCAPE;
    }
}
