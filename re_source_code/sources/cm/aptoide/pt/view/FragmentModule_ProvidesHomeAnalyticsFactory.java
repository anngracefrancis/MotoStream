package cm.aptoide.pt.view;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.home.HomeAnalytics;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesHomeAnalyticsFactory implements Provider {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final FragmentModule module;
    private final Provider<NavigationTracker> navigationTrackerProvider;

    public FragmentModule_ProvidesHomeAnalyticsFactory(FragmentModule fragmentModule, Provider<AnalyticsManager> provider, Provider<NavigationTracker> provider2) {
        this.module = fragmentModule;
        this.analyticsManagerProvider = provider;
        this.navigationTrackerProvider = provider2;
    }

    public static FragmentModule_ProvidesHomeAnalyticsFactory create(FragmentModule fragmentModule, Provider<AnalyticsManager> provider, Provider<NavigationTracker> provider2) {
        return new FragmentModule_ProvidesHomeAnalyticsFactory(fragmentModule, provider, provider2);
    }

    public static HomeAnalytics providesHomeAnalytics(FragmentModule fragmentModule, AnalyticsManager analyticsManager, NavigationTracker navigationTracker) {
        return (HomeAnalytics) f.b.b.c(fragmentModule.providesHomeAnalytics(analyticsManager, navigationTracker));
    }

    @Override // javax.inject.Provider
    public HomeAnalytics get() {
        return providesHomeAnalytics(this.module, this.analyticsManagerProvider.get(), this.navigationTrackerProvider.get());
    }
}
