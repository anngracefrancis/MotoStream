package cm.aptoide.pt.ads.data;

import android.view.View;
import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.view.app.Application;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class AptoideNativeAd extends Application implements ApplicationAd {
    private Long adId;
    private String clickUrl;
    private String cpcUrl;
    private String cpdUrl;
    private String cpiUrl;
    private String description;
    private Long modified;
    private Long networkId;
    private Payout payout;
    private Integer stars;

    public AptoideNativeAd(MinimalAd minimalAd) {
        super(minimalAd.getName(), minimalAd.getIconPath(), 0.0f, minimalAd.getDownloads(), minimalAd.getPackageName(), minimalAd.getAppId(), HttpUrl.FRAGMENT_ENCODE_SET, minimalAd.getIsHasAppc());
        this.networkId = Long.valueOf(minimalAd.getNetworkId());
        this.clickUrl = minimalAd.getClickUrl();
        this.cpcUrl = minimalAd.getCpcUrl();
        this.cpdUrl = minimalAd.getCpdUrl();
        this.adId = Long.valueOf(minimalAd.getAdId());
        this.cpiUrl = minimalAd.getCpiUrl();
        this.description = minimalAd.getDescription();
        this.stars = Integer.valueOf(minimalAd.getStars());
        this.modified = Long.valueOf(minimalAd.getModified());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AptoideNativeAd)) {
            return false;
        }
        AptoideNativeAd aptoideNativeAd = (AptoideNativeAd) obj;
        return aptoideNativeAd.modified.equals(this.modified) && aptoideNativeAd.stars.equals(this.stars) && Integer.valueOf(aptoideNativeAd.getDownloads()).equals(Integer.valueOf(getDownloads())) && aptoideNativeAd.description.equals(this.description) && aptoideNativeAd.getIcon().equals(getIcon()) && aptoideNativeAd.getName().equals(getName()) && aptoideNativeAd.cpiUrl.equals(this.cpiUrl) && aptoideNativeAd.adId.equals(this.adId) && aptoideNativeAd.cpdUrl.equals(this.cpdUrl) && aptoideNativeAd.cpcUrl.equals(this.cpcUrl) && Long.valueOf(aptoideNativeAd.getAppId()).equals(Long.valueOf(getAppId())) && aptoideNativeAd.clickUrl.equals(this.clickUrl) && aptoideNativeAd.networkId.equals(this.networkId) && aptoideNativeAd.getPackageName().equals(getPackageName());
    }

    public Long getAdId() {
        return this.adId;
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public String getAdTitle() {
        return super.getName();
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public Payout getAppcPayout() {
        return this.payout;
    }

    public String getClickUrl() {
        return this.clickUrl;
    }

    public String getCpcUrl() {
        return this.cpcUrl;
    }

    public String getCpdUrl() {
        return this.cpdUrl;
    }

    public String getCpiUrl() {
        return this.cpiUrl;
    }

    public String getDescription() {
        return this.description;
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public String getIconUrl() {
        return super.getIcon();
    }

    public Long getModified() {
        return this.modified;
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public ApplicationAd.Network getNetwork() {
        return ApplicationAd.Network.SERVER;
    }

    public Long getNetworkId() {
        return this.networkId;
    }

    @Override // cm.aptoide.pt.view.app.Application, cm.aptoide.pt.ads.data.ApplicationAd
    public String getPackageName() {
        return super.getPackageName();
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public Integer getStars() {
        return this.stars;
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public boolean hasAppcPayout() {
        Payout payout;
        return hasAppcBilling() && (payout = this.payout) != null && payout.getFiatAmount() > 0.0d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.cpdUrl.hashCode() * 31) + this.description.hashCode()) * 31) + getPackageName().hashCode()) * 31) + this.clickUrl.hashCode()) * 31) + this.cpcUrl.hashCode()) * 31) + this.cpiUrl.hashCode()) * 31) + getName().hashCode()) * 31) + getIcon().hashCode()) * 31) + Integer.valueOf(getDownloads()).hashCode()) * 31) + this.stars.hashCode()) * 31) + ((int) (this.networkId.longValue() ^ (this.networkId.longValue() >>> 32)))) * 31) + ((int) (getAppId() ^ (getAppId() >>> 32)))) * 31) + ((int) (this.adId.longValue() ^ (this.adId.longValue() >>> 32)))) * 31) + ((int) (this.modified.longValue() ^ (this.modified.longValue() >>> 32)));
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public void registerClickableView(View view) {
    }

    @Override // cm.aptoide.pt.ads.data.ApplicationAd
    public void setAdView(View view) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AptoideNativeAd(GetAdsResponse.Ad ad) {
        super(ad.getData().getName(), ad.getData().getIcon(), 0.0f, ad.getData().getDownloads(), ad.getData().getPackageName(), ad.getData().getId(), HttpUrl.FRAGMENT_ENCODE_SET, (ad.getInfo().getPayout() == null || ad.getInfo().getPayout().getFiat() == null || ad.getInfo().getPayout().getFiat().getAmount() <= 0.0d) ? false : true);
        int id = 0;
        GetAdsResponse.Partner partner = ad.getPartner();
        String clickUrl = null;
        if (partner != null) {
            id = partner.getInfo().getId();
            clickUrl = partner.getData().getClickUrl();
        }
        this.networkId = Long.valueOf(id);
        this.clickUrl = clickUrl;
        this.cpcUrl = ad.getInfo().getCpcUrl();
        this.cpdUrl = ad.getInfo().getCpdUrl();
        this.adId = Long.valueOf(ad.getInfo().getAdId());
        this.cpiUrl = ad.getInfo().getCpiUrl();
        this.description = ad.getData().getDescription();
        this.stars = Integer.valueOf(ad.getData().getStars());
        this.modified = Long.valueOf(ad.getData().getModified().getTime());
        GetAdsResponse.Info.Payout payout = ad.getInfo().getPayout();
        if (payout != null) {
            GetAdsResponse.Info.Fiat fiat = payout.getFiat();
            this.payout = new Payout(payout.getAppc(), fiat.getAmount(), fiat.getCurrency(), fiat.getSymbol());
        }
    }
}
