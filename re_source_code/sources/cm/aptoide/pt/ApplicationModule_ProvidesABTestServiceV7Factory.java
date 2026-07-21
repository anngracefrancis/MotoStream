package cm.aptoide.pt;

import cm.aptoide.pt.abtesting.ABTestService;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesABTestServiceV7Factory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesABTestServiceV7Factory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesABTestServiceV7Factory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesABTestServiceV7Factory(applicationModule, provider);
    }

    public static ABTestService.ABTestingService providesABTestServiceV7(ApplicationModule applicationModule, Retrofit retrofit) {
        return (ABTestService.ABTestingService) f.b.b.c(applicationModule.providesABTestServiceV7(retrofit));
    }

    @Override // javax.inject.Provider
    public ABTestService.ABTestingService get() {
        return providesABTestServiceV7(this.module, this.retrofitProvider.get());
    }
}
