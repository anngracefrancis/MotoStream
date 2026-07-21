package cm.aptoide.pt.home;

import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class HomeContainerFragment_MembersInjector implements f.a<HomeContainerFragment> {
    private final Provider<HomeContainerPresenter> presenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public HomeContainerFragment_MembersInjector(Provider<HomeContainerPresenter> provider, Provider<ThemeManager> provider2) {
        this.presenterProvider = provider;
        this.themeManagerProvider = provider2;
    }

    public static f.a<HomeContainerFragment> create(Provider<HomeContainerPresenter> provider, Provider<ThemeManager> provider2) {
        return new HomeContainerFragment_MembersInjector(provider, provider2);
    }

    public static void injectPresenter(HomeContainerFragment homeContainerFragment, HomeContainerPresenter homeContainerPresenter) {
        homeContainerFragment.presenter = homeContainerPresenter;
    }

    public static void injectThemeManager(HomeContainerFragment homeContainerFragment, ThemeManager themeManager) {
        homeContainerFragment.themeManager = themeManager;
    }

    public void injectMembers(HomeContainerFragment homeContainerFragment) {
        injectPresenter(homeContainerFragment, this.presenterProvider.get());
        injectThemeManager(homeContainerFragment, this.themeManagerProvider.get());
    }
}
