package cm.aptoide.pt.view;

import cm.aptoide.pt.home.HomeContainerNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesHomeContainerNavigatorFactory implements Provider {
    private final Provider<FragmentNavigator> childFragmentNavigatorProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesHomeContainerNavigatorFactory(FragmentModule fragmentModule, Provider<FragmentNavigator> provider) {
        this.module = fragmentModule;
        this.childFragmentNavigatorProvider = provider;
    }

    public static FragmentModule_ProvidesHomeContainerNavigatorFactory create(FragmentModule fragmentModule, Provider<FragmentNavigator> provider) {
        return new FragmentModule_ProvidesHomeContainerNavigatorFactory(fragmentModule, provider);
    }

    public static HomeContainerNavigator providesHomeContainerNavigator(FragmentModule fragmentModule, FragmentNavigator fragmentNavigator) {
        return (HomeContainerNavigator) f.b.b.c(fragmentModule.providesHomeContainerNavigator(fragmentNavigator));
    }

    @Override // javax.inject.Provider
    public HomeContainerNavigator get() {
        return providesHomeContainerNavigator(this.module, this.childFragmentNavigatorProvider.get());
    }
}
