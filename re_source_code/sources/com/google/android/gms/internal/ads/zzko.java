package com.google.android.gms.internal.ads;

import android.os.HandlerThread;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
public final class zzko extends HandlerThread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16397f;

    public zzko(String str, int i2) {
        super(str);
        this.f16397f = -16;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f16397f);
        super.run();
    }
}
