package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
final class ph implements com.google.android.gms.ads.internal.overlay.zzo, com.google.android.gms.ads.internal.overlay.zzu, zzagv, zzagx, zzxr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzxr f13164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzagv f13165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzo f13166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzagx f13167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.google.android.gms.ads.internal.overlay.zzu f13168j;

    private ph() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void b(zzxr zzxrVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, zzagx zzagxVar, com.google.android.gms.ads.internal.overlay.zzu zzuVar) {
        this.f13164f = zzxrVar;
        this.f13165g = zzagvVar;
        this.f13166h = zzoVar;
        this.f13167i = zzagxVar;
        this.f13168j = zzuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagv
    public final synchronized void k(String str, Bundle bundle) {
        zzagv zzagvVar = this.f13165g;
        if (zzagvVar != null) {
            zzagvVar.k(str, bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        zzxr zzxrVar = this.f13164f;
        if (zzxrVar != null) {
            zzxrVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzagx
    public final synchronized void onAppEvent(String str, String str2) {
        zzagx zzagxVar = this.f13167i;
        if (zzagxVar != null) {
            zzagxVar.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.f13166h;
        if (zzoVar != null) {
            zzoVar.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.f13166h;
        if (zzoVar != null) {
            zzoVar.onResume();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzsz() {
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.f13166h;
        if (zzoVar != null) {
            zzoVar.zzsz();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzta() {
        com.google.android.gms.ads.internal.overlay.zzo zzoVar = this.f13166h;
        if (zzoVar != null) {
            zzoVar.zzta();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzu
    public final synchronized void zztq() {
        com.google.android.gms.ads.internal.overlay.zzu zzuVar = this.f13168j;
        if (zzuVar != null) {
            zzuVar.zztq();
        }
    }

    /* synthetic */ ph(lh lhVar) {
        this();
    }
}
