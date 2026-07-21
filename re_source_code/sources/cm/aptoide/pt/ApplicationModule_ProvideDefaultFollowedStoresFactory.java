package cm.aptoide.pt;

import java.util.List;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideDefaultFollowedStoresFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideDefaultFollowedStoresFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideDefaultFollowedStoresFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideDefaultFollowedStoresFactory(applicationModule);
    }

    public static List<String> provideDefaultFollowedStores(ApplicationModule applicationModule) {
        return (List) f.b.b.c(applicationModule.provideDefaultFollowedStores());
    }

    @Override // javax.inject.Provider
    public List<String> get() {
        return provideDefaultFollowedStores(this.module);
    }
}
