package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: loaded from: classes2.dex */
public final class zzacc extends zzaav {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final VideoController.VideoLifecycleCallbacks f13784f;

    public zzacc(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f13784f = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void T0(boolean z) {
        this.f13784f.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void n0() {
        this.f13784f.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPause() {
        this.f13784f.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPlay() {
        this.f13784f.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoStart() {
        this.f13784f.onVideoStart();
    }
}
