package cm.aptoide.pt.view;

import cm.aptoide.pt.download.view.DownloadNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesDownloadNavigatorFactory implements Provider {
    private final Provider<FragmentNavigator> fragmentNavigatorProvider;
    private final FragmentModule module;

    public FragmentModule_ProvidesDownloadNavigatorFactory(FragmentModule fragmentModule, Provider<FragmentNavigator> provider) {
        this.module = fragmentModule;
        this.fragmentNavigatorProvider = provider;
    }

    public static FragmentModule_ProvidesDownloadNavigatorFactory create(FragmentModule fragmentModule, Provider<FragmentNavigator> provider) {
        return new FragmentModule_ProvidesDownloadNavigatorFactory(fragmentModule, provider);
    }

    public static DownloadNavigator providesDownloadNavigator(FragmentModule fragmentModule, FragmentNavigator fragmentNavigator) {
        return (DownloadNavigator) f.b.b.c(fragmentModule.providesDownloadNavigator(fragmentNavigator));
    }

    @Override // javax.inject.Provider
    public DownloadNavigator get() {
        return providesDownloadNavigator(this.module, this.fragmentNavigatorProvider.get());
    }
}
