package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideExtraIDFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideExtraIDFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideExtraIDFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideExtraIDFactory(applicationModule);
    }

    public static String provideExtraID(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideExtraID());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideExtraID(this.module);
    }
}
