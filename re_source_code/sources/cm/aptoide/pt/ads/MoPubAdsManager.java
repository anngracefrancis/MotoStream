package cm.aptoide.pt.ads;

import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class MoPubAdsManager {
    private final WalletAdsOfferManager walletAdsOfferManager;

    public MoPubAdsManager(WalletAdsOfferManager walletAdsOfferManager) {
        this.walletAdsOfferManager = walletAdsOfferManager;
    }

    static /* synthetic */ Single lambda$getAdsVisibilityStatus$0(Boolean bool) {
        return bool.booleanValue() ? Single.m(WalletAdsOfferManager.OfferResponseStatus.NO_ADS) : Single.m(WalletAdsOfferManager.OfferResponseStatus.ADS_HIDE);
    }

    public Single<WalletAdsOfferManager.OfferResponseStatus> getAdsVisibilityStatus() {
        return shouldRequestAds().i(new rx.m.e() { // from class: cm.aptoide.pt.ads.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return MoPubAdsManager.lambda$getAdsVisibilityStatus$0((Boolean) obj);
            }
        });
    }

    public Single<Boolean> shouldRequestAds() {
        return this.walletAdsOfferManager.shouldRequestMoPubAd();
    }
}
