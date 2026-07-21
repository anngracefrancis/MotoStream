package cm.aptoide.pt.home.bundles.ads;

import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AdsTagWrapper {
    private final List<GetAdsResponse.Ad> ads;
    private final String tag;

    public AdsTagWrapper(List<GetAdsResponse.Ad> list, String str) {
        this.ads = list;
        this.tag = str;
    }

    public List<GetAdsResponse.Ad> getAds() {
        return this.ads;
    }

    public String getTag() {
        return this.tag;
    }
}
