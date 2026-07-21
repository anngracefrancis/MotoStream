package cm.aptoide.pt;

import cm.aptoide.pt.navigator.Result;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideFragmentNavigatorRelayFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideFragmentNavigatorRelayFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideFragmentNavigatorRelayFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideFragmentNavigatorRelayFactory(applicationModule);
    }

    public static e.g.b.a<Map<Integer, Result>> provideFragmentNavigatorRelay(ApplicationModule applicationModule) {
        return (e.g.b.a) f.b.b.c(applicationModule.provideFragmentNavigatorRelay());
    }

    @Override // javax.inject.Provider
    public e.g.b.a<Map<Integer, Result>> get() {
        return provideFragmentNavigatorRelay(this.module);
    }
}
