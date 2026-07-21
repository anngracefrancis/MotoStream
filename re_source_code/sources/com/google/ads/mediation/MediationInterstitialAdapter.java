package com.google.ads.mediation;

import android.app.Activity;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.e;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends e, SERVER_PARAMETERS extends MediationServerParameters> extends b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    @Override // com.google.ads.mediation.b
    /* synthetic */ void destroy();

    @Override // com.google.ads.mediation.b
    /* synthetic */ Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    @Override // com.google.ads.mediation.b
    /* synthetic */ Class<SERVER_PARAMETERS> getServerParametersType();

    void requestInterstitialAd(d dVar, Activity activity, SERVER_PARAMETERS server_parameters, a aVar, ADDITIONAL_PARAMETERS additional_parameters);

    void showInterstitial();
}
