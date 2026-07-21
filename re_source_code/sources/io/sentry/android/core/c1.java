package io.sentry.android.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: MainLooperHandler.java */
/* JADX INFO: loaded from: classes2.dex */
final class c1 {
    private final Handler a;

    c1() {
        this(Looper.getMainLooper());
    }

    public Thread a() {
        return this.a.getLooper().getThread();
    }

    public void b(Runnable runnable) {
        this.a.post(runnable);
    }

    c1(Looper looper) {
        this.a = new Handler(looper);
    }
}
