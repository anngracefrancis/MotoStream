package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazg {
    private HandlerThread a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f14294b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14295c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f14296d = new Object();

    public final Handler a() {
        return this.f14294b;
    }

    public final Looper b() {
        Looper looper;
        synchronized (this.f14296d) {
            if (this.f14295c != 0) {
                Preconditions.l(this.a, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.a == null) {
                zzawz.m("Starting the looper thread.");
                HandlerThread handlerThread = new HandlerThread("LooperProvider");
                this.a = handlerThread;
                handlerThread.start();
                this.f14294b = new zzdbh(this.a.getLooper());
                zzawz.m("Looper thread started.");
            } else {
                zzawz.m("Resuming the looper thread");
                this.f14296d.notifyAll();
            }
            this.f14295c++;
            looper = this.a.getLooper();
        }
        return looper;
    }
}
