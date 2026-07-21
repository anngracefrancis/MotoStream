package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlavourApplicationModule_ProvidePartnerIDFactory implements Provider {
    private final FlavourApplicationModule module;

    public FlavourApplicationModule_ProvidePartnerIDFactory(FlavourApplicationModule flavourApplicationModule) {
        this.module = flavourApplicationModule;
    }

    public static FlavourApplicationModule_ProvidePartnerIDFactory create(FlavourApplicationModule flavourApplicationModule) {
        return new FlavourApplicationModule_ProvidePartnerIDFactory(flavourApplicationModule);
    }

    public static String providePartnerID(FlavourApplicationModule flavourApplicationModule) {
        return (String) f.b.b.c(flavourApplicationModule.providePartnerID());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providePartnerID(this.module);
    }
}
