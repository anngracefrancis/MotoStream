package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlavourApplicationModule_ProvidesSupportEmailFactory implements Provider {
    private final FlavourApplicationModule module;

    public FlavourApplicationModule_ProvidesSupportEmailFactory(FlavourApplicationModule flavourApplicationModule) {
        this.module = flavourApplicationModule;
    }

    public static FlavourApplicationModule_ProvidesSupportEmailFactory create(FlavourApplicationModule flavourApplicationModule) {
        return new FlavourApplicationModule_ProvidesSupportEmailFactory(flavourApplicationModule);
    }

    public static String providesSupportEmail(FlavourApplicationModule flavourApplicationModule) {
        return (String) f.b.b.c(flavourApplicationModule.providesSupportEmail());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesSupportEmail(this.module);
    }
}
