package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
final class in extends zzzq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzzp f12778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzcqj f12779g;

    in(zzcqj zzcqjVar, zzzp zzzpVar) {
        this.f12779g = zzcqjVar;
        this.f12778f = zzzpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void onAdMetadataChanged() throws RemoteException {
        zzzp zzzpVar;
        if (!this.f12779g.n || (zzzpVar = this.f12778f) == null) {
            return;
        }
        zzzpVar.onAdMetadataChanged();
    }
}
