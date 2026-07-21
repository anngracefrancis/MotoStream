package cm.aptoide.pt;

import cm.aptoide.pt.ads.MoPubAnalytics;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesMoPubAnalyticsFactory implements Provider {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesMoPubAnalyticsFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesMoPubAnalyticsFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesMoPubAnalyticsFactory(applicationModule);
    }

    public static MoPubAnalytics providesMoPubAnalytics(ApplicationModule applicationModule) {
        return (MoPubAnalytics) f.b.b.c(applicationModule.providesMoPubAnalytics());
    }

    @Override // javax.inject.Provider
    public MoPubAnalytics get() {
        return providesMoPubAnalytics(this.module);
    }
}
