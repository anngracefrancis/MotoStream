package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzj;

/* JADX INFO: loaded from: classes2.dex */
final class th implements zzj {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzcdn f13355f;

    th(zzcdn zzcdnVar) {
        this.f13355f = zzcdnVar;
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzlc() {
        this.f13355f.f15107h.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzj
    public final void zzld() {
        this.f13355f.f15107h.onResume();
    }
}
