package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class HandlerExecutor implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f12164f;

    @KeepForSdk
    public HandlerExecutor(Looper looper) {
        this.f12164f = new zzi(looper);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f12164f.post(runnable);
    }
}
