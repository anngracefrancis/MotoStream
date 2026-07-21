package cm.aptoide.pt.app;

import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.ads.data.ApplicationAd;
import cm.aptoide.pt.ads.data.ApplicationAdError;
import cm.aptoide.pt.ads.data.AptoideNativeAd;
import cm.aptoide.pt.view.app.AppsList;

/* JADX INFO: loaded from: classes.dex */
public class MinimalAdRequestResult implements ApplicationAdResult {
    private final AppsList.Error error;
    private final MinimalAd minimalAd;

    public MinimalAdRequestResult(MinimalAd minimalAd) {
        this.minimalAd = minimalAd;
        this.error = null;
    }

    @Override // cm.aptoide.pt.app.ApplicationAdResult
    public ApplicationAd getAd() {
        MinimalAd minimalAd = this.minimalAd;
        if (minimalAd == null) {
            return null;
        }
        return new AptoideNativeAd(minimalAd);
    }

    @Override // cm.aptoide.pt.app.ApplicationAdResult
    public ApplicationAdError getError() {
        AppsList.Error error = this.error;
        if (error == null) {
            return null;
        }
        return new ApplicationAdError(error);
    }

    public MinimalAd getMinimalAd() {
        return this.minimalAd;
    }

    public MinimalAdRequestResult(AppsList.Error error) {
        this.minimalAd = null;
        this.error = error;
    }
}
