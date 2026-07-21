package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f12170f;

    public a(Runnable runnable, int i2) {
        this.f12170f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f12170f.run();
    }
}
