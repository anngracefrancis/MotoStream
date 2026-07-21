package cm.aptoide.pt.app;

import cm.aptoide.pt.ads.data.ApplicationAd;
import cm.aptoide.pt.view.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class AppViewSimilarApp {
    private ApplicationAd ad;
    private Application app;

    public AppViewSimilarApp(Application application, ApplicationAd applicationAd) {
        this.app = application;
        this.ad = applicationAd;
    }

    public ApplicationAd getAd() {
        return this.ad;
    }

    public Application getApp() {
        return this.app;
    }

    public int getNetworkAdType() {
        ApplicationAd applicationAd = this.ad;
        if (applicationAd == null) {
            return 0;
        }
        return applicationAd.getNetwork().ordinal();
    }

    public boolean isAd() {
        return this.app == null && this.ad != null;
    }
}
