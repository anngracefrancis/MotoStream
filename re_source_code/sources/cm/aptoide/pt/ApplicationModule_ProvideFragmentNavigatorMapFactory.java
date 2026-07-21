package cm.aptoide.pt;

import cm.aptoide.pt.navigator.Result;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideFragmentNavigatorMapFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideFragmentNavigatorMapFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideFragmentNavigatorMapFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideFragmentNavigatorMapFactory(applicationModule);
    }

    public static Map<Integer, Result> provideFragmentNavigatorMap(ApplicationModule applicationModule) {
        return (Map) f.b.b.c(applicationModule.provideFragmentNavigatorMap());
    }

    @Override // javax.inject.Provider
    public Map<Integer, Result> get() {
        return provideFragmentNavigatorMap(this.module);
    }
}
