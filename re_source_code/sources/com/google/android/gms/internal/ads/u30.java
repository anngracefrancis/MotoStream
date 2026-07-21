package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
final class u30 implements Handler.Callback, Choreographer.FrameCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final u30 f13379f = new u30();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f13380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f13381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final HandlerThread f13382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Choreographer f13383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f13384k;

    private u30() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        this.f13382i = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.f13381h = handler;
        handler.sendEmptyMessage(0);
    }

    public static u30 a() {
        return f13379f;
    }

    public final void b() {
        this.f13381h.sendEmptyMessage(1);
    }

    public final void c() {
        this.f13381h.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        this.f13380g = j2;
        this.f13383j.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            this.f13383j = Choreographer.getInstance();
            return true;
        }
        if (i2 == 1) {
            int i3 = this.f13384k + 1;
            this.f13384k = i3;
            if (i3 == 1) {
                this.f13383j.postFrameCallback(this);
            }
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        int i4 = this.f13384k - 1;
        this.f13384k = i4;
        if (i4 == 0) {
            this.f13383j.removeFrameCallback(this);
            this.f13380g = 0L;
        }
        return true;
    }
}
