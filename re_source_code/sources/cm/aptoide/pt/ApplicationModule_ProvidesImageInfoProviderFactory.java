package cm.aptoide.pt;

import cm.aptoide.pt.account.view.ImageInfoProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesImageInfoProviderFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesImageInfoProviderFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesImageInfoProviderFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesImageInfoProviderFactory(applicationModule);
    }

    public static ImageInfoProvider providesImageInfoProvider(ApplicationModule applicationModule) {
        return (ImageInfoProvider) f.b.b.c(applicationModule.providesImageInfoProvider());
    }

    @Override // javax.inject.Provider
    public ImageInfoProvider get() {
        return providesImageInfoProvider(this.module);
    }
}
