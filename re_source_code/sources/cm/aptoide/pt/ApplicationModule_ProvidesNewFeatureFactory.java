package cm.aptoide.pt;

import cm.aptoide.pt.themes.NewFeature;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesNewFeatureFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesNewFeatureFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesNewFeatureFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesNewFeatureFactory(applicationModule);
    }

    public static NewFeature providesNewFeature(ApplicationModule applicationModule) {
        return (NewFeature) f.b.b.c(applicationModule.providesNewFeature());
    }

    @Override // javax.inject.Provider
    public NewFeature get() {
        return providesNewFeature(this.module);
    }
}
