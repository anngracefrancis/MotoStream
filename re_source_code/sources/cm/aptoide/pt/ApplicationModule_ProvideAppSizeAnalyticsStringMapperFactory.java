package cm.aptoide.pt;

import cm.aptoide.pt.analytics.AppSizeAnalyticsStringMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideAppSizeAnalyticsStringMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvideAppSizeAnalyticsStringMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideAppSizeAnalyticsStringMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideAppSizeAnalyticsStringMapperFactory(applicationModule);
    }

    public static AppSizeAnalyticsStringMapper provideAppSizeAnalyticsStringMapper(ApplicationModule applicationModule) {
        return (AppSizeAnalyticsStringMapper) f.b.b.c(applicationModule.provideAppSizeAnalyticsStringMapper());
    }

    @Override // javax.inject.Provider
    public AppSizeAnalyticsStringMapper get() {
        return provideAppSizeAnalyticsStringMapper(this.module);
    }
}
