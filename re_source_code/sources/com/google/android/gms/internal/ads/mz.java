package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes2.dex */
final class mz extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f12999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhq f13000g;

    mz(zzhq zzhqVar, AudioTrack audioTrack) {
        this.f13000g = zzhqVar;
        this.f12999f = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f12999f.release();
        } finally {
            this.f13000g.a.open();
        }
    }
}
