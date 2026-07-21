package cm.aptoide.pt;

import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.ads.WalletAdsOfferManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesMoPubAdsManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<WalletAdsOfferManager> walletAdsOfferManagerProvider;

    public ApplicationModule_ProvidesMoPubAdsManagerFactory(ApplicationModule applicationModule, Provider<WalletAdsOfferManager> provider) {
        this.module = applicationModule;
        this.walletAdsOfferManagerProvider = provider;
    }

    public static ApplicationModule_ProvidesMoPubAdsManagerFactory create(ApplicationModule applicationModule, Provider<WalletAdsOfferManager> provider) {
        return new ApplicationModule_ProvidesMoPubAdsManagerFactory(applicationModule, provider);
    }

    public static MoPubAdsManager providesMoPubAdsManager(ApplicationModule applicationModule, WalletAdsOfferManager walletAdsOfferManager) {
        return (MoPubAdsManager) f.b.b.c(applicationModule.providesMoPubAdsManager(walletAdsOfferManager));
    }

    @Override // javax.inject.Provider
    public MoPubAdsManager get() {
        return providesMoPubAdsManager(this.module, this.walletAdsOfferManagerProvider.get());
    }
}
