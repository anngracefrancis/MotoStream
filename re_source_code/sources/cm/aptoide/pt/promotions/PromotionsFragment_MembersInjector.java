package cm.aptoide.pt.promotions;

import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class PromotionsFragment_MembersInjector implements f.a<PromotionsFragment> {
    private final Provider<PromotionsPresenter> promotionsPresenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public PromotionsFragment_MembersInjector(Provider<PromotionsPresenter> provider, Provider<ThemeManager> provider2) {
        this.promotionsPresenterProvider = provider;
        this.themeManagerProvider = provider2;
    }

    public static f.a<PromotionsFragment> create(Provider<PromotionsPresenter> provider, Provider<ThemeManager> provider2) {
        return new PromotionsFragment_MembersInjector(provider, provider2);
    }

    public static void injectPromotionsPresenter(PromotionsFragment promotionsFragment, PromotionsPresenter promotionsPresenter) {
        promotionsFragment.promotionsPresenter = promotionsPresenter;
    }

    public static void injectThemeManager(PromotionsFragment promotionsFragment, ThemeManager themeManager) {
        promotionsFragment.themeManager = themeManager;
    }

    public void injectMembers(PromotionsFragment promotionsFragment) {
        injectPromotionsPresenter(promotionsFragment, this.promotionsPresenterProvider.get());
        injectThemeManager(promotionsFragment, this.themeManagerProvider.get());
    }
}
