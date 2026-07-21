package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class f7 implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f12570f = new zzaxa(Looper.getMainLooper());

    f7() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.f12570f.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            zzk.zzlg();
            zzaxi.n(zzk.zzlk().a(), th);
            throw th;
        }
    }
}
