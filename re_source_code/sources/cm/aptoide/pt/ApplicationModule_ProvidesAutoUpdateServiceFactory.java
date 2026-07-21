package cm.aptoide.pt;

import cm.aptoide.pt.autoupdate.Service;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAutoUpdateServiceFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesAutoUpdateServiceFactory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesAutoUpdateServiceFactory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesAutoUpdateServiceFactory(applicationModule, provider);
    }

    public static Service providesAutoUpdateService(ApplicationModule applicationModule, Retrofit retrofit) {
        return (Service) f.b.b.c(applicationModule.providesAutoUpdateService(retrofit));
    }

    @Override // javax.inject.Provider
    public Service get() {
        return providesAutoUpdateService(this.module, this.retrofitProvider.get());
    }
}
