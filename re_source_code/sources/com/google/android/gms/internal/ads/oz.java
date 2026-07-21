package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
final class oz extends nz {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AudioTimestamp f13129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f13130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f13132j;

    public oz() {
        super(null);
        this.f13129g = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.nz
    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.f13130h = 0L;
        this.f13131i = 0L;
        this.f13132j = 0L;
    }

    @Override // com.google.android.gms.internal.ads.nz
    public final boolean e() {
        boolean timestamp = this.a.getTimestamp(this.f13129g);
        if (timestamp) {
            long j2 = this.f13129g.framePosition;
            if (this.f13131i > j2) {
                this.f13130h++;
            }
            this.f13131i = j2;
            this.f13132j = j2 + (this.f13130h << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.nz
    public final long f() {
        return this.f13129g.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.nz
    public final long g() {
        return this.f13132j;
    }
}
