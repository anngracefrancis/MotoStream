package cm.aptoide.pt;

import cm.aptoide.pt.account.AndroidAccountProvider;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAuthenticationPersistenceFactory implements Provider {
    private final Provider<AndroidAccountProvider> androidAccountProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideAuthenticationPersistenceFactory(ApplicationModule applicationModule, Provider<AndroidAccountProvider> provider) {
        this.module = applicationModule;
        this.androidAccountProvider = provider;
    }

    public static ApplicationModule_ProvideAuthenticationPersistenceFactory create(ApplicationModule applicationModule, Provider<AndroidAccountProvider> provider) {
        return new ApplicationModule_ProvideAuthenticationPersistenceFactory(applicationModule, provider);
    }

    public static AuthenticationPersistence provideAuthenticationPersistence(ApplicationModule applicationModule, AndroidAccountProvider androidAccountProvider) {
        return (AuthenticationPersistence) f.b.b.c(applicationModule.provideAuthenticationPersistence(androidAccountProvider));
    }

    @Override // javax.inject.Provider
    public AuthenticationPersistence get() {
        return provideAuthenticationPersistence(this.module, this.androidAccountProvider.get());
    }
}
