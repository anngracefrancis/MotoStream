package cm.aptoide.pt;

import cm.aptoide.pt.download.AppValidationAnalytics;
import cm.aptoide.pt.download.AppValidator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAppValidatorFactory implements Provider {
    private final Provider<AppValidationAnalytics> appValidationAnalyticsProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAppValidatorFactory(ApplicationModule applicationModule, Provider<AppValidationAnalytics> provider) {
        this.module = applicationModule;
        this.appValidationAnalyticsProvider = provider;
    }

    public static ApplicationModule_ProvidesAppValidatorFactory create(ApplicationModule applicationModule, Provider<AppValidationAnalytics> provider) {
        return new ApplicationModule_ProvidesAppValidatorFactory(applicationModule, provider);
    }

    public static AppValidator providesAppValidator(ApplicationModule applicationModule, AppValidationAnalytics appValidationAnalytics) {
        return (AppValidator) f.b.b.c(applicationModule.providesAppValidator(appValidationAnalytics));
    }

    @Override // javax.inject.Provider
    public AppValidator get() {
        return providesAppValidator(this.module, this.appValidationAnalyticsProvider.get());
    }
}
