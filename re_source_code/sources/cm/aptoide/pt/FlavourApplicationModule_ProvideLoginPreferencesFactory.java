package cm.aptoide.pt;

import cm.aptoide.pt.account.LoginPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FlavourApplicationModule_ProvideLoginPreferencesFactory implements Provider {
    private final FlavourApplicationModule module;

    public FlavourApplicationModule_ProvideLoginPreferencesFactory(FlavourApplicationModule flavourApplicationModule) {
        this.module = flavourApplicationModule;
    }

    public static FlavourApplicationModule_ProvideLoginPreferencesFactory create(FlavourApplicationModule flavourApplicationModule) {
        return new FlavourApplicationModule_ProvideLoginPreferencesFactory(flavourApplicationModule);
    }

    public static LoginPreferences provideLoginPreferences(FlavourApplicationModule flavourApplicationModule) {
        return (LoginPreferences) f.b.b.c(flavourApplicationModule.provideLoginPreferences());
    }

    @Override // javax.inject.Provider
    public LoginPreferences get() {
        return provideLoginPreferences(this.module);
    }
}
