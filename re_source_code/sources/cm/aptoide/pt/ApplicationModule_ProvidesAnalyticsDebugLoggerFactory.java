package cm.aptoide.pt;

import cm.aptoide.analytics.AnalyticsLogger;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAnalyticsDebugLoggerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAnalyticsDebugLoggerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAnalyticsDebugLoggerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAnalyticsDebugLoggerFactory(applicationModule);
    }

    public static AnalyticsLogger providesAnalyticsDebugLogger(ApplicationModule applicationModule) {
        return (AnalyticsLogger) f.b.b.c(applicationModule.providesAnalyticsDebugLogger());
    }

    @Override // javax.inject.Provider
    public AnalyticsLogger get() {
        return providesAnalyticsDebugLogger(this.module);
    }
}
