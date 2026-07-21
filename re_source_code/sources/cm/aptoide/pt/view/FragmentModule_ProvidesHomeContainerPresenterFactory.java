package cm.aptoide.pt.view;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.home.ChipManager;
import cm.aptoide.pt.home.Home;
import cm.aptoide.pt.home.HomeAnalytics;
import cm.aptoide.pt.home.HomeContainerNavigator;
import cm.aptoide.pt.home.HomeContainerPresenter;
import cm.aptoide.pt.home.HomeNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesHomeContainerPresenterFactory implements Provider {
    private final Provider<AptoideAccountManager> accountManagerProvider;
    private final Provider<ChipManager> chipManagerProvider;
    private final Provider<HomeAnalytics> homeAnalyticsProvider;
    private final Provider<HomeContainerNavigator> homeContainerNavigatorProvider;
    private final Provider<HomeNavigator> homeNavigatorProvider;
    private final Provider<Home> homeProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesHomeContainerPresenterFactory(FragmentModule fragmentModule, Provider<AptoideAccountManager> provider, Provider<HomeContainerNavigator> provider2, Provider<HomeNavigator> provider3, Provider<HomeAnalytics> provider4, Provider<Home> provider5, Provider<ChipManager> provider6) {
        this.module = fragmentModule;
        this.accountManagerProvider = provider;
        this.homeContainerNavigatorProvider = provider2;
        this.homeNavigatorProvider = provider3;
        this.homeAnalyticsProvider = provider4;
        this.homeProvider = provider5;
        this.chipManagerProvider = provider6;
    }

    public static FragmentModule_ProvidesHomeContainerPresenterFactory create(FragmentModule fragmentModule, Provider<AptoideAccountManager> provider, Provider<HomeContainerNavigator> provider2, Provider<HomeNavigator> provider3, Provider<HomeAnalytics> provider4, Provider<Home> provider5, Provider<ChipManager> provider6) {
        return new FragmentModule_ProvidesHomeContainerPresenterFactory(fragmentModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static HomeContainerPresenter providesHomeContainerPresenter(FragmentModule fragmentModule, AptoideAccountManager aptoideAccountManager, HomeContainerNavigator homeContainerNavigator, HomeNavigator homeNavigator, HomeAnalytics homeAnalytics, Home home, ChipManager chipManager) {
        return (HomeContainerPresenter) f.b.b.c(fragmentModule.providesHomeContainerPresenter(aptoideAccountManager, homeContainerNavigator, homeNavigator, homeAnalytics, home, chipManager));
    }

    @Override // javax.inject.Provider
    public HomeContainerPresenter get() {
        return providesHomeContainerPresenter(this.module, this.accountManagerProvider.get(), this.homeContainerNavigatorProvider.get(), this.homeNavigatorProvider.get(), this.homeAnalyticsProvider.get(), this.homeProvider.get(), this.chipManagerProvider.get());
    }
}
