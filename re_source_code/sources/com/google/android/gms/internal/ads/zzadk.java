package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzadk implements CustomRenderedAd {
    private final zzadl a;

    public zzadk(zzadl zzadlVar) {
        this.a = zzadlVar;
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getBaseUrl() {
        try {
            return this.a.M5();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final String getContent() {
        try {
            return this.a.getContent();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void onAdRendered(View view) {
        try {
            this.a.z1(view != null ? ObjectWrapper.E0(view) : null);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordClick() {
        try {
            this.a.recordClick();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.doubleclick.CustomRenderedAd
    public final void recordImpression() {
        try {
            this.a.recordImpression();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
