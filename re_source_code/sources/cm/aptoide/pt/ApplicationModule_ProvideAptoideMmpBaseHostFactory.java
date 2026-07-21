package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAptoideMmpBaseHostFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideAptoideMmpBaseHostFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideAptoideMmpBaseHostFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideAptoideMmpBaseHostFactory(applicationModule);
    }

    public static String provideAptoideMmpBaseHost(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideAptoideMmpBaseHost());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideAptoideMmpBaseHost(this.module);
    }
}
