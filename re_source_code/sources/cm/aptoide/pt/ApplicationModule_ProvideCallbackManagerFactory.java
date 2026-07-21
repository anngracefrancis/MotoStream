package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideCallbackManagerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideCallbackManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideCallbackManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideCallbackManagerFactory(applicationModule);
    }

    public static com.facebook.y provideCallbackManager(ApplicationModule applicationModule) {
        return (com.facebook.y) f.b.b.c(applicationModule.provideCallbackManager());
    }

    @Override // javax.inject.Provider
    public com.facebook.y get() {
        return provideCallbackManager(this.module);
    }
}
