package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
class b10 {
    protected AudioTrack a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f12294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f12297i;

    private b10() {
    }

    public final void a() {
        if (this.f12295g != -9223372036854775807L) {
            return;
        }
        this.a.pause();
    }

    public void b(AudioTrack audioTrack, boolean z) {
        this.a = audioTrack;
        this.f12290b = z;
        this.f12295g = -9223372036854775807L;
        this.f12292d = 0L;
        this.f12293e = 0L;
        this.f12294f = 0L;
        if (audioTrack != null) {
            this.f12291c = audioTrack.getSampleRate();
        }
    }

    public final long c() {
        return (e() * 1000000) / ((long) this.f12291c);
    }

    public final void d(long j2) {
        this.f12296h = e();
        this.f12295g = SystemClock.elapsedRealtime() * 1000;
        this.f12297i = j2;
        this.a.stop();
    }

    public final long e() {
        if (this.f12295g != -9223372036854775807L) {
            return Math.min(this.f12297i, this.f12296h + ((((SystemClock.elapsedRealtime() * 1000) - this.f12295g) * ((long) this.f12291c)) / 1000000));
        }
        int playState = this.a.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.a.getPlaybackHeadPosition());
        if (this.f12290b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f12294f = this.f12292d;
            }
            playbackHeadPosition += this.f12294f;
        }
        if (this.f12292d > playbackHeadPosition) {
            this.f12293e++;
        }
        this.f12292d = playbackHeadPosition;
        return playbackHeadPosition + (this.f12293e << 32);
    }

    public boolean f() {
        return false;
    }

    public long g() {
        throw new UnsupportedOperationException();
    }

    public long h() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ b10(a10 a10Var) {
        this();
    }
}
