package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideObbPathFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideObbPathFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideObbPathFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideObbPathFactory(applicationModule);
    }

    public static String provideObbPath(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideObbPath());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideObbPath(this.module);
    }
}
