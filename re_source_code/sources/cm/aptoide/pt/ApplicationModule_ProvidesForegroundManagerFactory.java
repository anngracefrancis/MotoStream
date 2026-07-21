package cm.aptoide.pt;

import cm.aptoide.pt.install.ForegroundManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesForegroundManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesForegroundManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesForegroundManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesForegroundManagerFactory(applicationModule);
    }

    public static ForegroundManager providesForegroundManager(ApplicationModule applicationModule) {
        return (ForegroundManager) f.b.b.c(applicationModule.providesForegroundManager());
    }

    @Override // javax.inject.Provider
    public ForegroundManager get() {
        return providesForegroundManager(this.module);
    }
}
