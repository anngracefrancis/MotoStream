package cm.aptoide.pt;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesReactionsHostFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesReactionsHostFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesReactionsHostFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesReactionsHostFactory(applicationModule);
    }

    public static String providesReactionsHost(ApplicationModule applicationModule) {
        return (String) f.b.b.c(applicationModule.providesReactionsHost());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesReactionsHost(this.module);
    }
}
