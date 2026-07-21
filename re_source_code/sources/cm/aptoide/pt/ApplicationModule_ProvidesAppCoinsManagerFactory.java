package cm.aptoide.pt;

import cm.aptoide.pt.bonus.BonusAppcService;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppCoinsManagerFactory implements Provider {
    private final Provider<BonusAppcService> bonusAppcServiceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppCoinsManagerFactory(ApplicationModule applicationModule, Provider<BonusAppcService> provider) {
        this.module = applicationModule;
        this.bonusAppcServiceProvider = provider;
    }

    public static ApplicationModule_ProvidesAppCoinsManagerFactory create(ApplicationModule applicationModule, Provider<BonusAppcService> provider) {
        return new ApplicationModule_ProvidesAppCoinsManagerFactory(applicationModule, provider);
    }

    public static AppCoinsManager providesAppCoinsManager(ApplicationModule applicationModule, BonusAppcService bonusAppcService) {
        return (AppCoinsManager) f.b.b.c(applicationModule.providesAppCoinsManager(bonusAppcService));
    }

    @Override // javax.inject.Provider
    public AppCoinsManager get() {
        return providesAppCoinsManager(this.module, this.bonusAppcServiceProvider.get());
    }
}
