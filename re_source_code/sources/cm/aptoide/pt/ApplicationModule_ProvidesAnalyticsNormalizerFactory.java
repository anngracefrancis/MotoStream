package cm.aptoide.pt;

import cm.aptoide.analytics.implementation.utils.AnalyticsEventParametersNormalizer;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAnalyticsNormalizerFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesAnalyticsNormalizerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesAnalyticsNormalizerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesAnalyticsNormalizerFactory(applicationModule);
    }

    public static AnalyticsEventParametersNormalizer providesAnalyticsNormalizer(ApplicationModule applicationModule) {
        return (AnalyticsEventParametersNormalizer) f.b.b.c(applicationModule.providesAnalyticsNormalizer());
    }

    @Override // javax.inject.Provider
    public AnalyticsEventParametersNormalizer get() {
        return providesAnalyticsNormalizer(this.module);
    }
}
