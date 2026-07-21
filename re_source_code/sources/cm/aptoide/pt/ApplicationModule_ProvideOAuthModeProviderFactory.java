package cm.aptoide.pt;

import cm.aptoide.pt.account.OAuthModeProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideOAuthModeProviderFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideOAuthModeProviderFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideOAuthModeProviderFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideOAuthModeProviderFactory(applicationModule);
    }

    public static OAuthModeProvider provideOAuthModeProvider(ApplicationModule applicationModule) {
        return (OAuthModeProvider) f.b.b.c(applicationModule.provideOAuthModeProvider());
    }

    @Override // javax.inject.Provider
    public OAuthModeProvider get() {
        return provideOAuthModeProvider(this.module);
    }
}
