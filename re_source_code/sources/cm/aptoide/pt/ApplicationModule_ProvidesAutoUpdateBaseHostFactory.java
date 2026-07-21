package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAutoUpdateBaseHostFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAutoUpdateBaseHostFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAutoUpdateBaseHostFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAutoUpdateBaseHostFactory(applicationModule);
    }

    public static String providesAutoUpdateBaseHost(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.providesAutoUpdateBaseHost());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesAutoUpdateBaseHost(this.module);
    }
}
