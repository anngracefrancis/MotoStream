package cm.aptoide.pt;

import cm.aptoide.pt.bonus.BonusAppcRemoteService;
import cm.aptoide.pt.bonus.BonusAppcService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBonusAppcServiceFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<BonusAppcRemoteService.ServiceApi> serviceApiProvider;

    public ApplicationModule_ProvidesBonusAppcServiceFactory(ApplicationModule applicationModule, Provider<BonusAppcRemoteService.ServiceApi> provider) {
        this.module = applicationModule;
        this.serviceApiProvider = provider;
    }

    public static ApplicationModule_ProvidesBonusAppcServiceFactory create(ApplicationModule applicationModule, Provider<BonusAppcRemoteService.ServiceApi> provider) {
        return new ApplicationModule_ProvidesBonusAppcServiceFactory(applicationModule, provider);
    }

    public static BonusAppcService providesBonusAppcService(ApplicationModule applicationModule, BonusAppcRemoteService.ServiceApi serviceApi) {
        return (BonusAppcService) f.b.b.c(applicationModule.providesBonusAppcService(serviceApi));
    }

    @Override // javax.inject.Provider
    public BonusAppcService get() {
        return providesBonusAppcService(this.module, this.serviceApiProvider.get());
    }
}
