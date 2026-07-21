package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.e;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzanu<NETWORK_EXTRAS extends com.google.ads.mediation.e, SERVER_PARAMETERS extends MediationServerParameters> implements com.google.ads.mediation.c, com.google.ads.mediation.d {
    private final zzamv a;

    public zzanu(zzamv zzamvVar) {
        this.a = zzamvVar;
    }

    @Override // com.google.ads.mediation.c
    public final void a(MediationBannerAdapter<?, ?> mediationBannerAdapter, e.e.a.a aVar) {
        String strValueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(strValueOf);
        zzbad.e(sb.toString());
        zzyt.a();
        if (!zzazt.w()) {
            zzbad.f("#008 Must be called on the main UI thread.", null);
            zzazt.a.post(new u2(this, aVar));
        } else {
            try {
                this.a.onAdFailedToLoad(zzaog.a(aVar));
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.ads.mediation.d
    public final void b(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, e.e.a.a aVar) {
        String strValueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(strValueOf);
        sb.append(".");
        zzbad.e(sb.toString());
        zzyt.a();
        if (!zzazt.w()) {
            zzbad.f("#008 Must be called on the main UI thread.", null);
            zzazt.a.post(new w2(this, aVar));
        } else {
            try {
                this.a.onAdFailedToLoad(zzaog.a(aVar));
            } catch (RemoteException e2) {
                zzbad.f("#007 Could not call remote method.", e2);
            }
        }
    }
}
