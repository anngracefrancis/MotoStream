package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* JADX INFO: loaded from: classes2.dex */
class nz {
    protected AudioTrack a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f13068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f13070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f13071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13072f;

    private nz() {
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.a = audioTrack;
        this.f13068b = z;
        this.f13070d = 0L;
        this.f13071e = 0L;
        this.f13072f = 0L;
        if (audioTrack != null) {
            this.f13069c = audioTrack.getSampleRate();
        }
    }

    public final boolean b() {
        return zzkq.a <= 22 && this.f13068b && this.a.getPlayState() == 2 && this.a.getPlaybackHeadPosition() == 0;
    }

    public final long c() {
        long playbackHeadPosition = ((long) this.a.getPlaybackHeadPosition()) & 4294967295L;
        if (zzkq.a <= 22 && this.f13068b) {
            if (this.a.getPlayState() == 1) {
                this.f13070d = playbackHeadPosition;
            } else if (this.a.getPlayState() == 2 && playbackHeadPosition == 0) {
                this.f13072f = this.f13070d;
            }
            playbackHeadPosition += this.f13072f;
        }
        if (this.f13070d > playbackHeadPosition) {
            this.f13071e++;
        }
        this.f13070d = playbackHeadPosition;
        return playbackHeadPosition + (this.f13071e << 32);
    }

    public final long d() {
        return (c() * 1000000) / ((long) this.f13069c);
    }

    public boolean e() {
        return false;
    }

    public long f() {
        throw new UnsupportedOperationException();
    }

    public long g() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ nz(mz mzVar) {
        this();
    }
}
