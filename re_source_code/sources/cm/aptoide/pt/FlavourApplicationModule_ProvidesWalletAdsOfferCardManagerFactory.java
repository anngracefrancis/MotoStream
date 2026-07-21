package cm.aptoide.pt;

import cm.aptoide.pt.ads.WalletAdsOfferCardManager;
import cm.aptoide.pt.blacklist.BlacklistManager;
import cm.aptoide.pt.install.PackageRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory implements Provider {
    private final Provider<BlacklistManager> blacklistManagerProvider;
    private final FlavourApplicationModule module;
    private final Provider<PackageRepository> packageRepositoryProvider;

    public FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory(FlavourApplicationModule flavourApplicationModule, Provider<BlacklistManager> provider, Provider<PackageRepository> provider2) {
        this.module = flavourApplicationModule;
        this.blacklistManagerProvider = provider;
        this.packageRepositoryProvider = provider2;
    }

    public static FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory create(FlavourApplicationModule flavourApplicationModule, Provider<BlacklistManager> provider, Provider<PackageRepository> provider2) {
        return new FlavourApplicationModule_ProvidesWalletAdsOfferCardManagerFactory(flavourApplicationModule, provider, provider2);
    }

    public static WalletAdsOfferCardManager providesWalletAdsOfferCardManager(FlavourApplicationModule flavourApplicationModule, BlacklistManager blacklistManager, PackageRepository packageRepository) {
        return (WalletAdsOfferCardManager) f.b.b.c(flavourApplicationModule.providesWalletAdsOfferCardManager(blacklistManager, packageRepository));
    }

    @Override // javax.inject.Provider
    public WalletAdsOfferCardManager get() {
        return providesWalletAdsOfferCardManager(this.module, this.blacklistManagerProvider.get(), this.packageRepositoryProvider.get());
    }
}
