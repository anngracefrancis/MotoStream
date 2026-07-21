package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideCachePathFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideCachePathFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideCachePathFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideCachePathFactory(applicationModule);
    }

    public static String provideCachePath(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideCachePath());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideCachePath(this.module);
    }
}
