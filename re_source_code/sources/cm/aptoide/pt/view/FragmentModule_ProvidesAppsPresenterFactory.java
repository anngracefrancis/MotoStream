package cm.aptoide.pt.view;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.home.apps.AppsManager;
import cm.aptoide.pt.home.apps.AppsNavigator;
import cm.aptoide.pt.home.apps.AppsPresenter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAppsPresenterFactory implements Provider {
    private final Provider<AppsManager> appsManagerProvider;
    private final Provider<AppsNavigator> appsNavigatorProvider;
    private final Provider<AptoideAccountManager> aptoideAccountManagerProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesAppsPresenterFactory(FragmentModule fragmentModule, Provider<AppsManager> provider, Provider<AptoideAccountManager> provider2, Provider<AppsNavigator> provider3) {
        this.module = fragmentModule;
        this.appsManagerProvider = provider;
        this.aptoideAccountManagerProvider = provider2;
        this.appsNavigatorProvider = provider3;
    }

    public static FragmentModule_ProvidesAppsPresenterFactory create(FragmentModule fragmentModule, Provider<AppsManager> provider, Provider<AptoideAccountManager> provider2, Provider<AppsNavigator> provider3) {
        return new FragmentModule_ProvidesAppsPresenterFactory(fragmentModule, provider, provider2, provider3);
    }

    public static AppsPresenter providesAppsPresenter(FragmentModule fragmentModule, AppsManager appsManager, AptoideAccountManager aptoideAccountManager, AppsNavigator appsNavigator) {
        return (AppsPresenter) f.b.b.c(fragmentModule.providesAppsPresenter(appsManager, aptoideAccountManager, appsNavigator));
    }

    @Override // javax.inject.Provider
    public AppsPresenter get() {
        return providesAppsPresenter(this.module, this.appsManagerProvider.get(), this.aptoideAccountManagerProvider.get(), this.appsNavigatorProvider.get());
    }
}
