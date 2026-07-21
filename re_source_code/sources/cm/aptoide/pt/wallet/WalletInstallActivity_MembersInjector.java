package cm.aptoide.pt.wallet;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.analytics.view.AnalyticsActivity_MembersInjector;
import cm.aptoide.pt.navigator.ActivityResultNavigator_MembersInjector;
import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class WalletInstallActivity_MembersInjector implements f.a<WalletInstallActivity> {
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<WalletInstallPresenter> presenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public WalletInstallActivity_MembersInjector(Provider<ThemeManager> provider, Provider<AccountNavigator> provider2, Provider<String> provider3, Provider<AnalyticsManager> provider4, Provider<FirstLaunchAnalytics> provider5, Provider<WalletInstallPresenter> provider6) {
        this.themeManagerProvider = provider;
        this.accountNavigatorProvider = provider2;
        this.marketNameProvider = provider3;
        this.analyticsManagerProvider = provider4;
        this.firstLaunchAnalyticsProvider = provider5;
        this.presenterProvider = provider6;
    }

    public static f.a<WalletInstallActivity> create(Provider<ThemeManager> provider, Provider<AccountNavigator> provider2, Provider<String> provider3, Provider<AnalyticsManager> provider4, Provider<FirstLaunchAnalytics> provider5, Provider<WalletInstallPresenter> provider6) {
        return new WalletInstallActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectPresenter(WalletInstallActivity walletInstallActivity, WalletInstallPresenter walletInstallPresenter) {
        walletInstallActivity.presenter = walletInstallPresenter;
    }

    public void injectMembers(WalletInstallActivity walletInstallActivity) {
        ActivityResultNavigator_MembersInjector.injectThemeManager(walletInstallActivity, this.themeManagerProvider.get());
        ActivityResultNavigator_MembersInjector.injectAccountNavigator(walletInstallActivity, this.accountNavigatorProvider.get());
        ActivityResultNavigator_MembersInjector.injectMarketName(walletInstallActivity, this.marketNameProvider.get());
        AnalyticsActivity_MembersInjector.injectAnalyticsManager(walletInstallActivity, this.analyticsManagerProvider.get());
        AnalyticsActivity_MembersInjector.injectFirstLaunchAnalytics(walletInstallActivity, this.firstLaunchAnalyticsProvider.get());
        injectPresenter(walletInstallActivity, this.presenterProvider.get());
    }
}
