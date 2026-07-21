package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes2.dex */
final class a10 extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f12211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzmh f12212g;

    a10(zzmh zzmhVar, AudioTrack audioTrack) {
        this.f12212g = zzmhVar;
        this.f12211f = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f12211f.flush();
            this.f12211f.release();
        } finally {
            this.f12212g.f16461f.open();
        }
    }
}
