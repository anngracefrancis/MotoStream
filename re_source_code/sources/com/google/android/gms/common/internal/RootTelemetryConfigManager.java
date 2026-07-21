package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class RootTelemetryConfigManager {
    private static RootTelemetryConfigManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RootTelemetryConfiguration f12003b = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RootTelemetryConfiguration f12004c;

    private RootTelemetryConfigManager() {
    }

    @KeepForSdk
    public static synchronized RootTelemetryConfigManager a() {
        if (a == null) {
            a = new RootTelemetryConfigManager();
        }
        return a;
    }

    @VisibleForTesting
    public final synchronized void b(RootTelemetryConfiguration rootTelemetryConfiguration) {
        try {
            if (rootTelemetryConfiguration == null) {
                this.f12004c = f12003b;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f12004c;
            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.e0() < rootTelemetryConfiguration.e0()) {
                this.f12004c = rootTelemetryConfiguration;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
