package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbpv implements com.google.android.gms.ads.internal.overlay.zzo {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbse f14673f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicBoolean f14674g = new AtomicBoolean(false);

    public zzbpv(zzbse zzbseVar) {
        this.f14673f = zzbseVar;
    }

    public final boolean a() {
        return this.f14674g.get();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
        this.f14674g.set(true);
        this.f14673f.Y();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
        this.f14673f.g0();
    }
}
