package cm.aptoide.pt.view;

import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.home.apps.AppsNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAppsNavigatorFactory implements Provider {
    private final Provider<AppNavigator> appNavigatorProvider;
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesAppsNavigatorFactory(FragmentModule fragmentModule, Provider<FragmentNavigator> provider, Provider<BottomNavigationMapper> provider2, Provider<AppNavigator> provider3) {
        this.module = fragmentModule;
        this.fragmentNavigatorProvider = provider;
        this.bottomNavigationMapperProvider = provider2;
        this.appNavigatorProvider = provider3;
    }

    public static FragmentModule_ProvidesAppsNavigatorFactory create(FragmentModule fragmentModule, Provider<FragmentNavigator> provider, Provider<BottomNavigationMapper> provider2, Provider<AppNavigator> provider3) {
        return new FragmentModule_ProvidesAppsNavigatorFactory(fragmentModule, provider, provider2, provider3);
    }

    public static AppsNavigator providesAppsNavigator(FragmentModule fragmentModule, FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator) {
        return (AppsNavigator) f.b.b.c(fragmentModule.providesAppsNavigator(fragmentNavigator, bottomNavigationMapper, appNavigator));
    }

    @Override // javax.inject.Provider
    public AppsNavigator get() {
        return providesAppsNavigator(this.module, this.fragmentNavigatorProvider.get(), this.bottomNavigationMapperProvider.get(), this.appNavigatorProvider.get());
    }
}
