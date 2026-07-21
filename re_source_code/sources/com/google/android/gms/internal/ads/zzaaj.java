package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaaj extends zzaah {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MuteThisAdListener f13729f;

    public zzaaj(MuteThisAdListener muteThisAdListener) {
        this.f13729f = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaag
    public final void onAdMuted() {
        this.f13729f.onAdMuted();
    }
}
