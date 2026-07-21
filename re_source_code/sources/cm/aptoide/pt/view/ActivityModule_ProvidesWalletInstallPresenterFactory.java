package cm.aptoide.pt.view;

import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.wallet.WalletInstallAnalytics;
import cm.aptoide.pt.wallet.WalletInstallConfiguration;
import cm.aptoide.pt.wallet.WalletInstallManager;
import cm.aptoide.pt.wallet.WalletInstallNavigator;
import cm.aptoide.pt.wallet.WalletInstallPresenter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidesWalletInstallPresenterFactory implements Provider {
    private final Provider<WalletInstallConfiguration> configurationProvider;
    private final Provider<MoPubAdsManager> moPubAdsManagerProvider;
    private final ActivityModule module;
    private final Provider<WalletInstallAnalytics> walletInstallAnalyticsProvider;
    private final Provider<WalletInstallManager> walletInstallManagerProvider;
    private final Provider<WalletInstallNavigator> walletInstallNavigatorProvider;

    public ActivityModule_ProvidesWalletInstallPresenterFactory(ActivityModule activityModule, Provider<WalletInstallConfiguration> provider, Provider<WalletInstallNavigator> provider2, Provider<WalletInstallManager> provider3, Provider<WalletInstallAnalytics> provider4, Provider<MoPubAdsManager> provider5) {
        this.module = activityModule;
        this.configurationProvider = provider;
        this.walletInstallNavigatorProvider = provider2;
        this.walletInstallManagerProvider = provider3;
        this.walletInstallAnalyticsProvider = provider4;
        this.moPubAdsManagerProvider = provider5;
    }

    public static ActivityModule_ProvidesWalletInstallPresenterFactory create(ActivityModule activityModule, Provider<WalletInstallConfiguration> provider, Provider<WalletInstallNavigator> provider2, Provider<WalletInstallManager> provider3, Provider<WalletInstallAnalytics> provider4, Provider<MoPubAdsManager> provider5) {
        return new ActivityModule_ProvidesWalletInstallPresenterFactory(activityModule, provider, provider2, provider3, provider4, provider5);
    }

    public static WalletInstallPresenter providesWalletInstallPresenter(ActivityModule activityModule, WalletInstallConfiguration walletInstallConfiguration, WalletInstallNavigator walletInstallNavigator, WalletInstallManager walletInstallManager, WalletInstallAnalytics walletInstallAnalytics, MoPubAdsManager moPubAdsManager) {
        return (WalletInstallPresenter) f.b.b.c(activityModule.providesWalletInstallPresenter(walletInstallConfiguration, walletInstallNavigator, walletInstallManager, walletInstallAnalytics, moPubAdsManager));
    }

    @Override // javax.inject.Provider
    public WalletInstallPresenter get() {
        return providesWalletInstallPresenter(this.module, this.configurationProvider.get(), this.walletInstallNavigatorProvider.get(), this.walletInstallManagerProvider.get(), this.walletInstallAnalyticsProvider.get(), this.moPubAdsManagerProvider.get());
    }
}
