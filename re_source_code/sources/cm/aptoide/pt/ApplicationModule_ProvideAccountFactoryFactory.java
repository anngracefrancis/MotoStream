package cm.aptoide.pt;

import cm.aptoide.accountmanager.AccountFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAccountFactoryFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideAccountFactoryFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideAccountFactoryFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideAccountFactoryFactory(applicationModule);
    }

    public static AccountFactory provideAccountFactory(ApplicationModule applicationModule) {
        return (AccountFactory) f.b.b.c(applicationModule.provideAccountFactory());
    }

    @Override // javax.inject.Provider
    public AccountFactory get() {
        return provideAccountFactory(this.module);
    }
}
