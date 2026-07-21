package cm.aptoide.pt.ads;

import cm.aptoide.pt.database.room.RoomStoredMinimalAd;
import cm.aptoide.pt.dataprovider.model.MinimalAdInterface;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.search.model.SearchAdResult;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class MinimalAdMapper {
    public MinimalAd map(GetAdsResponse.Ad ad) {
        String clickUrl;
        int i2;
        String currency;
        String symbol;
        double d2;
        double d3;
        boolean z;
        GetAdsResponse.Partner partner = ad.getPartner();
        if (partner != null) {
            int id = partner.getInfo().getId();
            clickUrl = partner.getData().getClickUrl();
            i2 = id;
        } else {
            clickUrl = null;
            i2 = 0;
        }
        GetAdsResponse.Info.Payout payout = ad.getInfo().getPayout();
        if (payout != null) {
            double appc = payout.getAppc();
            double amount = payout.getFiat().getAmount();
            currency = payout.getFiat().getCurrency();
            symbol = payout.getFiat().getSymbol();
            d2 = appc;
            d3 = amount;
            z = true;
        } else {
            currency = HttpUrl.FRAGMENT_ENCODE_SET;
            symbol = currency;
            d2 = -1.0d;
            d3 = -1.0d;
            z = false;
        }
        return new MinimalAd(ad.getData().getPackageName(), i2, clickUrl, ad.getInfo().getCpcUrl(), ad.getInfo().getCpdUrl(), ad.getData().getId(), ad.getInfo().getAdId(), ad.getInfo().getCpiUrl(), ad.getData().getName(), ad.getData().getIcon(), ad.getData().getDescription(), ad.getData().getDownloads(), ad.getData().getStars(), ad.getData().getModified().getTime(), z, d2, d3, currency, symbol);
    }

    public RoomStoredMinimalAd map(SearchAdResult searchAdResult, String str) {
        return new RoomStoredMinimalAd(searchAdResult.getPackageName(), str, searchAdResult.getCpcUrl(), searchAdResult.getClickPerDownloadUrl(), searchAdResult.getClickPerInstallUrl(), Long.valueOf(searchAdResult.getAdId()));
    }

    public MinimalAdInterface map(final RoomStoredMinimalAd roomStoredMinimalAd) {
        return new MinimalAdInterface() { // from class: cm.aptoide.pt.ads.MinimalAdMapper.1
            public String cpdUrl;

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public String getCpcUrl() {
                return roomStoredMinimalAd.getCpcUrl();
            }

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public String getCpdUrl() {
                String str = this.cpdUrl;
                return str == null ? roomStoredMinimalAd.getCpdUrl() : str;
            }

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public String getCpiUrl() {
                return roomStoredMinimalAd.getCpiUrl();
            }

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public void setCpdUrl(String str) {
                this.cpdUrl = str;
            }
        };
    }

    public MinimalAdInterface map(final SearchAdResult searchAdResult) {
        return new MinimalAdInterface() { // from class: cm.aptoide.pt.ads.MinimalAdMapper.2
            public String cpdUrl;

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public String getCpcUrl() {
                return searchAdResult.getCpcUrl();
            }

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public String getCpdUrl() {
                String str = this.cpdUrl;
                return str == null ? searchAdResult.getClickPerDownloadUrl() : str;
            }

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public String getCpiUrl() {
                return searchAdResult.getClickPerInstallUrl();
            }

            @Override // cm.aptoide.pt.dataprovider.model.MinimalAdInterface
            public void setCpdUrl(String str) {
                this.cpdUrl = str;
            }
        };
    }
}
