package cm.aptoide.pt.home.bundles.ads;

import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AdBundle implements HomeBundle {
    private final List<AdClick> ads;
    private final Event event;
    private final String tag;
    private final String title;

    public AdBundle(String str, AdsTagWrapper adsTagWrapper, Event event, String str2) {
        this.title = str;
        if (adsTagWrapper.getAds() != null) {
            this.ads = new ArrayList();
            Iterator<GetAdsResponse.Ad> it = adsTagWrapper.getAds().iterator();
            while (it.hasNext()) {
                this.ads.add(new AdClick(it.next(), str2));
            }
        } else {
            this.ads = null;
        }
        this.event = event;
        this.tag = str2;
    }

    public List<AdClick> getAds() {
        return this.ads;
    }

    @Override // cm.aptoide.pt.home.bundles.base.HomeBundle
    public List<?> getContent() {
        return this.ads;
    }

    @Override // cm.aptoide.pt.home.bundles.base.HomeBundle
    public Event getEvent() {
        return this.event;
    }

    @Override // cm.aptoide.pt.home.bundles.base.HomeBundle
    public String getTag() {
        return this.tag;
    }

    @Override // cm.aptoide.pt.home.bundles.base.HomeBundle
    public String getTitle() {
        return this.title;
    }

    @Override // cm.aptoide.pt.home.bundles.base.HomeBundle
    public HomeBundle.BundleType getType() {
        return HomeBundle.BundleType.ADS;
    }
}
