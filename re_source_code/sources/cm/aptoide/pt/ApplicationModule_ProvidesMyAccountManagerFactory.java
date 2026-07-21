package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesMyAccountManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesMyAccountManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesMyAccountManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesMyAccountManagerFactory(applicationModule);
    }

    public static MyAccountManager providesMyAccountManager(ApplicationModule applicationModule) {
        return (MyAccountManager) f.b.b.c(applicationModule.providesMyAccountManager());
    }

    @Override // javax.inject.Provider
    public MyAccountManager get() {
        return providesMyAccountManager(this.module);
    }
}
