package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
final class c10 extends b10 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AudioTimestamp f12374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12375k;
    private long l;
    private long m;

    public c10() {
        super(null);
        this.f12374j = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.b10
    public final void b(AudioTrack audioTrack, boolean z) {
        super.b(audioTrack, z);
        this.f12375k = 0L;
        this.l = 0L;
        this.m = 0L;
    }

    @Override // com.google.android.gms.internal.ads.b10
    public final boolean f() {
        boolean timestamp = this.a.getTimestamp(this.f12374j);
        if (timestamp) {
            long j2 = this.f12374j.framePosition;
            if (this.l > j2) {
                this.f12375k++;
            }
            this.l = j2;
            this.m = j2 + (this.f12375k << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.b10
    public final long g() {
        return this.f12374j.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.b10
    public final long h() {
        return this.m;
    }
}
