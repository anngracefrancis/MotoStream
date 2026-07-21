package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.tasks.zza;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class w implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f18347f = new zza(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f18347f.post(runnable);
    }
}
