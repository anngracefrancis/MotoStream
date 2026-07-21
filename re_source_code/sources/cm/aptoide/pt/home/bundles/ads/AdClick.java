package cm.aptoide.pt.home.bundles.ads;

import cm.aptoide.pt.ads.data.ApplicationAd;
import cm.aptoide.pt.ads.data.AptoideNativeAd;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;

/* JADX INFO: loaded from: classes.dex */
public class AdClick {
    private final ApplicationAd ad;
    private final String tag;

    public AdClick(GetAdsResponse.Ad ad, String str) {
        this.ad = new AptoideNativeAd(ad);
        this.tag = str;
    }

    public ApplicationAd getAd() {
        return this.ad;
    }

    public String getTag() {
        return this.tag;
    }

    public AdClick(ApplicationAd applicationAd, String str) {
        this.ad = applicationAd;
        this.tag = str;
    }
}
