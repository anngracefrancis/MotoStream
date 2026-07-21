package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.d;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbad;

/* JADX INFO: loaded from: classes2.dex */
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, c>, MediationInterstitialAdapter<CustomEventExtras, c> {
    private View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventBanner f11178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private CustomEventInterstitial f11179c;

    @VisibleForTesting
    static final class a implements com.google.ads.mediation.customevent.a {
        private final CustomEventAdapter a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.ads.mediation.c f11180b;

        public a(CustomEventAdapter customEventAdapter, com.google.ads.mediation.c cVar) {
            this.a = customEventAdapter;
            this.f11180b = cVar;
        }
    }

    @VisibleForTesting
    class b implements com.google.ads.mediation.customevent.b {
        private final CustomEventAdapter a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f11181b;

        public b(CustomEventAdapter customEventAdapter, d dVar) {
            this.a = customEventAdapter;
            this.f11181b = dVar;
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbad.i(sb.toString());
            return null;
        }
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter, com.google.ads.mediation.b
    public final void destroy() {
        CustomEventBanner customEventBanner = this.f11178b;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.f11179c;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter, com.google.ads.mediation.b
    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.a;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter, com.google.ads.mediation.b
    public final Class<c> getServerParametersType() {
        return c.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(com.google.ads.mediation.c cVar, Activity activity, c cVar2, e.e.a.c cVar3, com.google.ads.mediation.a aVar, CustomEventExtras customEventExtras) {
        CustomEventBanner customEventBanner = (CustomEventBanner) a(cVar2.f11183b);
        this.f11178b = customEventBanner;
        if (customEventBanner == null) {
            cVar.a(this, e.e.a.a.INTERNAL_ERROR);
        } else {
            this.f11178b.requestBannerAd(new a(this, cVar), activity, cVar2.a, cVar2.f11184c, cVar3, aVar, customEventExtras == null ? null : customEventExtras.getExtra(cVar2.a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(d dVar, Activity activity, c cVar, com.google.ads.mediation.a aVar, CustomEventExtras customEventExtras) {
        CustomEventInterstitial customEventInterstitial = (CustomEventInterstitial) a(cVar.f11183b);
        this.f11179c = customEventInterstitial;
        if (customEventInterstitial == null) {
            dVar.b(this, e.e.a.a.INTERNAL_ERROR);
        } else {
            this.f11179c.requestInterstitialAd(new b(this, dVar), activity, cVar.a, cVar.f11184c, aVar, customEventExtras == null ? null : customEventExtras.getExtra(cVar.a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.f11179c.showInterstitial();
    }
}
