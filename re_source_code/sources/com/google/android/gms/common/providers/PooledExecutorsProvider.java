package com.google.android.gms.common.providers;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@Deprecated
public class PooledExecutorsProvider {
    private static PooledExecutorFactory a;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface PooledExecutorFactory {
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService a();
    }

    private PooledExecutorsProvider() {
    }

    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }
}
