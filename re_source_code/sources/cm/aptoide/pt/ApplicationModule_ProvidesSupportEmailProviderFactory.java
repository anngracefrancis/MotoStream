package cm.aptoide.pt;

import cm.aptoide.pt.view.settings.SupportEmailProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesSupportEmailProviderFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<String> supportEmailProvider;

    public ApplicationModule_ProvidesSupportEmailProviderFactory(ApplicationModule applicationModule, Provider<String> provider) {
        this.module = applicationModule;
        this.supportEmailProvider = provider;
    }

    public static ApplicationModule_ProvidesSupportEmailProviderFactory create(ApplicationModule applicationModule, Provider<String> provider) {
        return new ApplicationModule_ProvidesSupportEmailProviderFactory(applicationModule, provider);
    }

    public static SupportEmailProvider providesSupportEmailProvider(ApplicationModule applicationModule, String str) {
        return (SupportEmailProvider) f.b.b.c(applicationModule.providesSupportEmailProvider(str));
    }

    @Override // javax.inject.Provider
    public SupportEmailProvider get() {
        return providesSupportEmailProvider(this.module, this.supportEmailProvider.get());
    }
}
