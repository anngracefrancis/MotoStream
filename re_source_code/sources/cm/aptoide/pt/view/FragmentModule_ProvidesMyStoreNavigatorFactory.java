package cm.aptoide.pt.view;

import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.store.view.my.MyStoresNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesMyStoreNavigatorFactory implements Provider {
    private final Provider<BottomNavigationMapper> bottomNavigationMapperProvider;
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesMyStoreNavigatorFactory(FragmentModule fragmentModule, Provider<FragmentNavigator> provider, Provider<BottomNavigationMapper> provider2) {
        this.module = fragmentModule;
        this.fragmentNavigatorProvider = provider;
        this.bottomNavigationMapperProvider = provider2;
    }

    public static FragmentModule_ProvidesMyStoreNavigatorFactory create(FragmentModule fragmentModule, Provider<FragmentNavigator> provider, Provider<BottomNavigationMapper> provider2) {
        return new FragmentModule_ProvidesMyStoreNavigatorFactory(fragmentModule, provider, provider2);
    }

    public static MyStoresNavigator providesMyStoreNavigator(FragmentModule fragmentModule, FragmentNavigator fragmentNavigator, BottomNavigationMapper bottomNavigationMapper) {
        return (MyStoresNavigator) f.b.b.c(fragmentModule.providesMyStoreNavigator(fragmentNavigator, bottomNavigationMapper));
    }

    @Override // javax.inject.Provider
    public MyStoresNavigator get() {
        return providesMyStoreNavigator(this.module, this.fragmentNavigatorProvider.get(), this.bottomNavigationMapperProvider.get());
    }
}
