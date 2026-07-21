package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class en extends zzaap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzaao f12538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcqf f12539g;

    en(zzcqf zzcqfVar, zzaao zzaaoVar) {
        this.f12539g = zzcqfVar;
        this.f12538f = zzaaoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaao
    public final void onAdMetadataChanged() throws RemoteException {
        zzaao zzaaoVar;
        if (!this.f12539g.o || (zzaaoVar = this.f12538f) == null) {
            return;
        }
        zzaaoVar.onAdMetadataChanged();
    }
}
