package cm.aptoide.pt;

import cm.aptoide.pt.aab.DynamicSplitsRemoteService;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesDynamicSplitsApiFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesDynamicSplitsApiFactory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesDynamicSplitsApiFactory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesDynamicSplitsApiFactory(applicationModule, provider);
    }

    public static DynamicSplitsRemoteService.DynamicSplitsApi providesDynamicSplitsApi(ApplicationModule applicationModule, Retrofit retrofit) {
        return (DynamicSplitsRemoteService.DynamicSplitsApi) f.b.b.c(applicationModule.providesDynamicSplitsApi(retrofit));
    }

    @Override // javax.inject.Provider
    public DynamicSplitsRemoteService.DynamicSplitsApi get() {
        return providesDynamicSplitsApi(this.module, this.retrofitProvider.get());
    }
}
