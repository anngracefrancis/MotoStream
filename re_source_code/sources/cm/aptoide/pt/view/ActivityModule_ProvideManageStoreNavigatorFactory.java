package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.store.ManageStoreNavigator;
import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideManageStoreNavigatorFactory implements Provider {
    private final Provider<BottomNavigationNavigator> bottomNavigationNavigatorProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final ActivityModule module;

    public ActivityModule_ProvideManageStoreNavigatorFactory(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<BottomNavigationNavigator> provider2) {
        this.module = activityModule;
        this.fragmentNavigatorProvider = provider;
        this.bottomNavigationNavigatorProvider = provider2;
    }

    public static ActivityModule_ProvideManageStoreNavigatorFactory create(ActivityModule activityModule, Provider<FragmentNavigator> provider, Provider<BottomNavigationNavigator> provider2) {
        return new ActivityModule_ProvideManageStoreNavigatorFactory(activityModule, provider, provider2);
    }

    public static ManageStoreNavigator provideManageStoreNavigator(ActivityModule activityModule, FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator) {
        return (ManageStoreNavigator) f.b.b.c(activityModule.provideManageStoreNavigator(fragmentNavigator, bottomNavigationNavigator));
    }

    @Override // javax.inject.Provider
    public ManageStoreNavigator get() {
        return provideManageStoreNavigator(this.module, this.fragmentNavigatorProvider.get(), this.bottomNavigationNavigatorProvider.get());
    }
}
