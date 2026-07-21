package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.socialmedia.SocialMediaNavigator;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.settings.MyAccountNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideMyAccountNavigatorFactory implements Provider {
    private final Provider<AccountNavigator> accountNavigatorProvider;
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;
    private final Provider<SocialMediaNavigator> socialMediaNavigatorProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public ActivityModule_ProvideMyAccountNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AccountNavigator> provider2, Provider<AppNavigator> provider3, Provider<ThemeManager> provider4, Provider<SocialMediaNavigator> provider5) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
        this.accountNavigatorProvider = provider2;
        this.appNavigatorProvider = provider3;
        this.themeManagerProvider = provider4;
        this.socialMediaNavigatorProvider = provider5;
    }

    public static ActivityModule_ProvideMyAccountNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<AccountNavigator> provider2, Provider<AppNavigator> provider3, Provider<ThemeManager> provider4, Provider<SocialMediaNavigator> provider5) {
        return new ActivityModule_ProvideMyAccountNavigatorFactory(activityModule, provider, provider2, provider3, provider4, provider5);
    }

    public static MyAccountNavigator provideMyAccountNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator, AccountNavigator accountNavigator, AppNavigator appNavigator, ThemeManager themeManager, SocialMediaNavigator socialMediaNavigator) {
        return (MyAccountNavigator) f.b.b.c(activityModule.provideMyAccountNavigator(fragmentNavigator, accountNavigator, appNavigator, themeManager, socialMediaNavigator));
    }

    @Override // javax.inject.Provider
    public MyAccountNavigator get() {
        return provideMyAccountNavigator(this.module, this.fragmentNavigatorProvider.get(), this.accountNavigatorProvider.get(), this.appNavigatorProvider.get(), this.themeManagerProvider.get(), this.socialMediaNavigatorProvider.get());
    }
}
