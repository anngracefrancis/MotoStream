package cm.aptoide.pt;

import cm.aptoide.pt.download.OemidProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesOemidProviderFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesOemidProviderFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesOemidProviderFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesOemidProviderFactory(applicationModule);
    }

    public static OemidProvider providesOemidProvider(ApplicationModule applicationModule) {
        return (OemidProvider) f.b.b.c(applicationModule.providesOemidProvider());
    }

    @Override // javax.inject.Provider
    public OemidProvider get() {
        return providesOemidProvider(this.module);
    }
}
