package cm.aptoide.pt;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.store.StoreAnalytics;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesStoreAnalyticsFactory implements Provider {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final ApplicationModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    public ApplicationModule_ProvidesStoreAnalyticsFactory(ApplicationModule applicationModule, Provider<AnalyticsManager> provider, Provider<NavigationTracker> provider2) {
        this.module = applicationModule;
        this.analyticsManagerProvider = provider;
        this.navigationTrackerProvider = provider2;
    }

    public static ApplicationModule_ProvidesStoreAnalyticsFactory create(ApplicationModule applicationModule, Provider<AnalyticsManager> provider, Provider<NavigationTracker> provider2) {
        return new ApplicationModule_ProvidesStoreAnalyticsFactory(applicationModule, provider, provider2);
    }

    public static StoreAnalytics providesStoreAnalytics(ApplicationModule applicationModule, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return (StoreAnalytics) f.b.b.c(applicationModule.providesStoreAnalytics(analyticsManager, navigationTracker));
    }

    @Override // javax.inject.Provider
    public StoreAnalytics get() {
        return providesStoreAnalytics(this.module, this.analyticsManagerProvider.get(), this.navigationTrackerProvider.get());
    }
}
