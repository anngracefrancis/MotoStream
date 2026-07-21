package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesGmsStatusValueProviderFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesGmsStatusValueProviderFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesGmsStatusValueProviderFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesGmsStatusValueProviderFactory(applicationModule);
    }

    public static GmsStatusValueProvider providesGmsStatusValueProvider(ApplicationModule applicationModule) {
        return (GmsStatusValueProvider) f.b.b.c(applicationModule.providesGmsStatusValueProvider());
    }

    @Override // javax.inject.Provider
    public GmsStatusValueProvider get() {
        return providesGmsStatusValueProvider(this.module);
    }
}
