package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcpv implements zzxr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzyw f15527f;

    public final synchronized void a(zzyw zzywVar) {
        this.f15527f = zzywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        zzyw zzywVar = this.f15527f;
        if (zzywVar != null) {
            try {
                zzywVar.onAdClicked();
            } catch (RemoteException e2) {
                zzbad.d("Remote Exception at onAdClicked.", e2);
            }
        }
    }
}
