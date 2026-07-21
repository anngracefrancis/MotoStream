package cm.aptoide.pt;

import cm.aptoide.pt.abtesting.ExperimentModel;
import java.util.HashMap;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAbTestLocalCacheFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAbTestLocalCacheFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAbTestLocalCacheFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAbTestLocalCacheFactory(applicationModule);
    }

    public static HashMap<String, ExperimentModel> providesAbTestLocalCache(ApplicationModule applicationModule) {
        return (HashMap) f.b.b.c(applicationModule.providesAbTestLocalCache());
    }

    @Override // javax.inject.Provider
    public HashMap<String, ExperimentModel> get() {
        return providesAbTestLocalCache(this.module);
    }
}
