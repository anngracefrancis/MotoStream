package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.e;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends e, SERVER_PARAMETERS extends MediationServerParameters> extends b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    @Override // com.google.ads.mediation.b
    /* synthetic */ void destroy();

    @Override // com.google.ads.mediation.b
    /* synthetic */ Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    View getBannerView();

    @Override // com.google.ads.mediation.b
    /* synthetic */ Class<SERVER_PARAMETERS> getServerParametersType();

    void requestBannerAd(c cVar, Activity activity, SERVER_PARAMETERS server_parameters, e.e.a.c cVar2, a aVar, ADDITIONAL_PARAMETERS additional_parameters);
}
