package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class g3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AdOverlayInfoParcel f12621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzapl f12622g;

    g3(zzapl zzaplVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f12622g = zzaplVar;
        this.f12621f = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzk.zzlf();
        com.google.android.gms.ads.internal.overlay.zzm.zza(this.f12622g.a, this.f12621f, true);
    }
}
