package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideMarketNameFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideMarketNameFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideMarketNameFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideMarketNameFactory(applicationModule);
    }

    public static String provideMarketName(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideMarketName());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideMarketName(this.module);
    }
}
