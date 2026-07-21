package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideStoreNameFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideStoreNameFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideStoreNameFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideStoreNameFactory(applicationModule);
    }

    public static String provideStoreName(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideStoreName());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideStoreName(this.module);
    }
}
