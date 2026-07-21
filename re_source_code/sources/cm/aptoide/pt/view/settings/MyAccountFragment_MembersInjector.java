package cm.aptoide.pt.view.settings;

import cm.aptoide.pt.MyAccountManager;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.socialmedia.SocialMediaAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class MyAccountFragment_MembersInjector implements f.a<MyAccountFragment> {
    private final Provider<AccountAnalytics> accountAnalyticsProvider;
    private final Provider<String> marketNameProvider;
    private final Provider<MyAccountManager> myAccountManagerProvider;
    private final Provider<MyAccountNavigator> myAccountNavigatorProvider;
    private final Provider<SocialMediaAnalytics> socialMediaAnalyticsProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public MyAccountFragment_MembersInjector(Provider<MyAccountNavigator> provider, Provider<AccountAnalytics> provider2, Provider<MyAccountManager> provider3, Provider<String> provider4, Provider<ThemeManager> provider5, Provider<SocialMediaAnalytics> provider6) {
        this.myAccountNavigatorProvider = provider;
        this.accountAnalyticsProvider = provider2;
        this.myAccountManagerProvider = provider3;
        this.marketNameProvider = provider4;
        this.themeManagerProvider = provider5;
        this.socialMediaAnalyticsProvider = provider6;
    }

    public static f.a<MyAccountFragment> create(Provider<MyAccountNavigator> provider, Provider<AccountAnalytics> provider2, Provider<MyAccountManager> provider3, Provider<String> provider4, Provider<ThemeManager> provider5, Provider<SocialMediaAnalytics> provider6) {
        return new MyAccountFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectAccountAnalytics(MyAccountFragment myAccountFragment, AccountAnalytics accountAnalytics) {
        myAccountFragment.accountAnalytics = accountAnalytics;
    }

    @Named
    public static void injectMarketName(MyAccountFragment myAccountFragment, String str) {
        myAccountFragment.marketName = str;
    }

    public static void injectMyAccountManager(MyAccountFragment myAccountFragment, MyAccountManager myAccountManager) {
        myAccountFragment.myAccountManager = myAccountManager;
    }

    public static void injectMyAccountNavigator(MyAccountFragment myAccountFragment, MyAccountNavigator myAccountNavigator) {
        myAccountFragment.myAccountNavigator = myAccountNavigator;
    }

    public static void injectSocialMediaAnalytics(MyAccountFragment myAccountFragment, SocialMediaAnalytics socialMediaAnalytics) {
        myAccountFragment.socialMediaAnalytics = socialMediaAnalytics;
    }

    public static void injectThemeManager(MyAccountFragment myAccountFragment, ThemeManager themeManager) {
        myAccountFragment.themeManager = themeManager;
    }

    public void injectMembers(MyAccountFragment myAccountFragment) {
        injectMyAccountNavigator(myAccountFragment, this.myAccountNavigatorProvider.get());
        injectAccountAnalytics(myAccountFragment, this.accountAnalyticsProvider.get());
        injectMyAccountManager(myAccountFragment, this.myAccountManagerProvider.get());
        injectMarketName(myAccountFragment, this.marketNameProvider.get());
        injectThemeManager(myAccountFragment, this.themeManagerProvider.get());
        injectSocialMediaAnalytics(myAccountFragment, this.socialMediaAnalyticsProvider.get());
    }
}
