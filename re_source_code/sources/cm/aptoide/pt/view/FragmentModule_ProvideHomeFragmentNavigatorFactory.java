package cm.aptoide.pt.view;

import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvideHomeFragmentNavigatorFactory implements Provider {
    private final Provider<Map<Integer, Result>> fragmentResultMapProvider;
    private final Provider<e.g.b.a<Map<Integer, Result>>> fragmentResultRelayProvider;
    private final FragmentModule module;

    public FragmentModule_ProvideHomeFragmentNavigatorFactory(FragmentModule fragmentModule, Provider<Map<Integer, Result>> provider, Provider<e.g.b.a<Map<Integer, Result>>> provider2) {
        this.module = fragmentModule;
        this.fragmentResultMapProvider = provider;
        this.fragmentResultRelayProvider = provider2;
    }

    public static FragmentModule_ProvideHomeFragmentNavigatorFactory create(FragmentModule fragmentModule, Provider<Map<Integer, Result>> provider, Provider<e.g.b.a<Map<Integer, Result>>> provider2) {
        return new FragmentModule_ProvideHomeFragmentNavigatorFactory(fragmentModule, provider, provider2);
    }

    public static FragmentNavigator provideHomeFragmentNavigator(FragmentModule fragmentModule, Map<Integer, Result> map, e.g.b.a<Map<Integer, Result>> aVar) {
        return (FragmentNavigator) f.b.b.c(fragmentModule.provideHomeFragmentNavigator(map, aVar));
    }

    @Override // javax.inject.Provider
    public FragmentNavigator get() {
        return provideHomeFragmentNavigator(this.module, this.fragmentResultMapProvider.get(), this.fragmentResultRelayProvider.get());
    }
}
