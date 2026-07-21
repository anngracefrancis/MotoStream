package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppsFlyerBaseUrlFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppsFlyerBaseUrlFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAppsFlyerBaseUrlFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAppsFlyerBaseUrlFactory(applicationModule);
    }

    public static String providesAppsFlyerBaseUrl(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.providesAppsFlyerBaseUrl());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesAppsFlyerBaseUrl(this.module);
    }
}
