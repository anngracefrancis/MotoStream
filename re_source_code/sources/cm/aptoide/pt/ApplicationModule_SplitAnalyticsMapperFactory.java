package cm.aptoide.pt;

import cm.aptoide.pt.download.SplitAnalyticsMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_SplitAnalyticsMapperFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_SplitAnalyticsMapperFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_SplitAnalyticsMapperFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_SplitAnalyticsMapperFactory(applicationModule);
    }

    public static SplitAnalyticsMapper splitAnalyticsMapper(ApplicationModule applicationModule) {
        return (SplitAnalyticsMapper) f.b.b.c(applicationModule.splitAnalyticsMapper());
    }

    @Override // javax.inject.Provider
    public SplitAnalyticsMapper get() {
        return splitAnalyticsMapper(this.module);
    }
}
