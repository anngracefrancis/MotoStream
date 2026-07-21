package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAppEventsLoggerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideAppEventsLoggerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideAppEventsLoggerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideAppEventsLoggerFactory(applicationModule);
    }

    public static com.facebook.o0.a0 provideAppEventsLogger(ApplicationModule applicationModule) {
        return (com.facebook.o0.a0) f.b.b.c(applicationModule.provideAppEventsLogger());
    }

    @Override // javax.inject.Provider
    public com.facebook.o0.a0 get() {
        return provideAppEventsLogger(this.module);
    }
}
