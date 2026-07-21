package cm.aptoide.pt;

import cm.aptoide.pt.ads.WalletAdsOfferManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory implements Provider {
    private final FlavourApplicationModule module;

    public FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory(FlavourApplicationModule flavourApplicationModule) {
        this.module = flavourApplicationModule;
    }

    public static FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory create(FlavourApplicationModule flavourApplicationModule) {
        return new FlavourApplicationModule_ProvidesWalletAdsOfferManagerFactory(flavourApplicationModule);
    }

    public static WalletAdsOfferManager providesWalletAdsOfferManager(FlavourApplicationModule flavourApplicationModule) {
        return (WalletAdsOfferManager) f.b.b.c(flavourApplicationModule.providesWalletAdsOfferManager());
    }

    @Override // javax.inject.Provider
    public WalletAdsOfferManager get() {
        return providesWalletAdsOfferManager(this.module);
    }
}
