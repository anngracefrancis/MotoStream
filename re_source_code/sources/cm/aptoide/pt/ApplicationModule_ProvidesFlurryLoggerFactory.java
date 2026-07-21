package cm.aptoide.pt;

import cm.aptoide.analytics.AnalyticsLogger;
import cm.aptoide.analytics.implementation.loggers.FlurryEventLogger;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesFlurryLoggerFactory implements Provider {
    private final Provider<AnalyticsLogger> loggerProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesFlurryLoggerFactory(ApplicationModule applicationModule, Provider<AnalyticsLogger> provider) {
        this.module = applicationModule;
        this.loggerProvider = provider;
    }

    public static ApplicationModule_ProvidesFlurryLoggerFactory create(ApplicationModule applicationModule, Provider<AnalyticsLogger> provider) {
        return new ApplicationModule_ProvidesFlurryLoggerFactory(applicationModule, provider);
    }

    public static FlurryEventLogger providesFlurryLogger(ApplicationModule applicationModule, AnalyticsLogger analyticsLogger) {
        return (FlurryEventLogger) f.b.b.c(applicationModule.providesFlurryLogger(analyticsLogger));
    }

    @Override // javax.inject.Provider
    public FlurryEventLogger get() {
        return providesFlurryLogger(this.module, this.loggerProvider.get());
    }
}
