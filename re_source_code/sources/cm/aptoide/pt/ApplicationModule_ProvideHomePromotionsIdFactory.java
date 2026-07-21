package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideHomePromotionsIdFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideHomePromotionsIdFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideHomePromotionsIdFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideHomePromotionsIdFactory(applicationModule);
    }

    public static String provideHomePromotionsId(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.provideHomePromotionsId());
    }

    @Override // javax.inject.Provider
    public String get() {
        return provideHomePromotionsId(this.module);
    }
}
