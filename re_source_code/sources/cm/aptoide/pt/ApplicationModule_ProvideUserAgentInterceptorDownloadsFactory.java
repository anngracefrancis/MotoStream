package cm.aptoide.pt;

import cm.aptoide.pt.networking.IdsRepository;
import javax.inject.Provider;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideUserAgentInterceptorDownloadsFactory implements Provider {
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<String> partnerIdProvider;

    public ApplicationModule_ProvideUserAgentInterceptorDownloadsFactory(ApplicationModule applicationModule, Provider<IdsRepository> provider, Provider<String> provider2) {
        this.module = applicationModule;
        this.idsRepositoryProvider = provider;
        this.partnerIdProvider = provider2;
    }

    public static ApplicationModule_ProvideUserAgentInterceptorDownloadsFactory create(ApplicationModule applicationModule, Provider<IdsRepository> provider, Provider<String> provider2) {
        return new ApplicationModule_ProvideUserAgentInterceptorDownloadsFactory(applicationModule, provider, provider2);
    }

    public static Interceptor provideUserAgentInterceptorDownloads(ApplicationModule applicationModule, IdsRepository idsRepository, String str) {
        return (Interceptor) f.b.b.c(applicationModule.provideUserAgentInterceptorDownloads(idsRepository, str));
    }

    @Override // javax.inject.Provider
    public Interceptor get() {
        return provideUserAgentInterceptorDownloads(this.module, this.idsRepositoryProvider.get(), this.partnerIdProvider.get());
    }
}
