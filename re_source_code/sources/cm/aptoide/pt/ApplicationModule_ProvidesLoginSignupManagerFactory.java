package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesLoginSignupManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesLoginSignupManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesLoginSignupManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesLoginSignupManagerFactory(applicationModule);
    }

    public static LoginSignupManager providesLoginSignupManager(ApplicationModule applicationModule) {
        return (LoginSignupManager) f.b.b.c(applicationModule.providesLoginSignupManager());
    }

    @Override // javax.inject.Provider
    public LoginSignupManager get() {
        return providesLoginSignupManager(this.module);
    }
}
