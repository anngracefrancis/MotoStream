package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class EarnAppcListFragment_MembersInjector implements f.a<EarnAppcListFragment> {
    private final Provider<EarnAppcListPresenter> presenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public EarnAppcListFragment_MembersInjector(Provider<EarnAppcListPresenter> provider, Provider<ThemeManager> provider2) {
        this.presenterProvider = provider;
        this.themeManagerProvider = provider2;
    }

    public static f.a<EarnAppcListFragment> create(Provider<EarnAppcListPresenter> provider, Provider<ThemeManager> provider2) {
        return new EarnAppcListFragment_MembersInjector(provider, provider2);
    }

    public static void injectPresenter(EarnAppcListFragment earnAppcListFragment, EarnAppcListPresenter earnAppcListPresenter) {
        earnAppcListFragment.presenter = earnAppcListPresenter;
    }

    public static void injectThemeManager(EarnAppcListFragment earnAppcListFragment, ThemeManager themeManager) {
        earnAppcListFragment.themeManager = themeManager;
    }

    public void injectMembers(EarnAppcListFragment earnAppcListFragment) {
        injectPresenter(earnAppcListFragment, this.presenterProvider.get());
        injectThemeManager(earnAppcListFragment, this.themeManagerProvider.get());
    }
}
