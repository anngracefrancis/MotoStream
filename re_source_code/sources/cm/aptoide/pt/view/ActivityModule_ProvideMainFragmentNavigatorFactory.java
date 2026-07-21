package cm.aptoide.pt.view;

import androidx.fragment.app.FragmentManager;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideMainFragmentNavigatorFactory implements Provider {
    private final Provider<FragmentManager> fragmentManagerProvider;
    private final Provider<Map<Integer, Result>> fragmentResultMapProvider;
    private final Provider<e.g.b.a<Map<Integer, Result>>> fragmentResultRelayProvider;
    private final ActivityModule module;

    public ActivityModule_ProvideMainFragmentNavigatorFactory(ActivityModule activityModule, Provider<Map<Integer, Result>> provider, Provider<e.g.b.a<Map<Integer, Result>>> provider2, Provider<FragmentManager> provider3) {
        this.module = activityModule;
        this.fragmentResultMapProvider = provider;
        this.fragmentResultRelayProvider = provider2;
        this.fragmentManagerProvider = provider3;
    }

    public static ActivityModule_ProvideMainFragmentNavigatorFactory create(ActivityModule activityModule, Provider<Map<Integer, Result>> provider, Provider<e.g.b.a<Map<Integer, Result>>> provider2, Provider<FragmentManager> provider3) {
        return new ActivityModule_ProvideMainFragmentNavigatorFactory(activityModule, provider, provider2, provider3);
    }

    public static FragmentNavigator provideMainFragmentNavigator(ActivityModule activityModule, Map<Integer, Result> map, e.g.b.a<Map<Integer, Result>> aVar, FragmentManager fragmentManager) {
        return (FragmentNavigator) f.b.b.c(activityModule.provideMainFragmentNavigator(map, aVar, fragmentManager));
    }

    @Override // javax.inject.Provider
    public FragmentNavigator get() {
        return provideMainFragmentNavigator(this.module, this.fragmentResultMapProvider.get(), this.fragmentResultRelayProvider.get(), this.fragmentManagerProvider.get());
    }
}
