package cm.aptoide.pt;

import cm.aptoide.pt.bonus.BonusAppcRemoteService;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBonusAppcServiceApiFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ApplicationModule_ProvidesBonusAppcServiceApiFactory(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        this.module = applicationModule;
        this.retrofitProvider = provider;
    }

    public static ApplicationModule_ProvidesBonusAppcServiceApiFactory create(ApplicationModule applicationModule, Provider<Retrofit> provider) {
        return new ApplicationModule_ProvidesBonusAppcServiceApiFactory(applicationModule, provider);
    }

    public static BonusAppcRemoteService.ServiceApi providesBonusAppcServiceApi(ApplicationModule applicationModule, Retrofit retrofit) {
        return (BonusAppcRemoteService.ServiceApi) f.b.b.c(applicationModule.providesBonusAppcServiceApi(retrofit));
    }

    @Override // javax.inject.Provider
    public BonusAppcRemoteService.ServiceApi get() {
        return providesBonusAppcServiceApi(this.module, this.retrofitProvider.get());
    }
}
