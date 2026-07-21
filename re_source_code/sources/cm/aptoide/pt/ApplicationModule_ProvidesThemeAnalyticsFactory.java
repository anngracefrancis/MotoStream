package cm.aptoide.pt;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.themes.ThemeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesThemeAnalyticsFactory implements Provider {
    private final Provider<AnalyticsManager> analyticsManagerProvider;
    private final Provider<FirebaseAnalytics> firebaseAnalyticsProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidesThemeAnalyticsFactory(ApplicationModule applicationModule, Provider<AnalyticsManager> provider, Provider<FirebaseAnalytics> provider2) {
        this.module = applicationModule;
        this.analyticsManagerProvider = provider;
        this.firebaseAnalyticsProvider = provider2;
    }

    public static ApplicationModule_ProvidesThemeAnalyticsFactory create(ApplicationModule applicationModule, Provider<AnalyticsManager> provider, Provider<FirebaseAnalytics> provider2) {
        return new ApplicationModule_ProvidesThemeAnalyticsFactory(applicationModule, provider, provider2);
    }

    public static ThemeAnalytics providesThemeAnalytics(ApplicationModule applicationModule, AnalyticsManager analyticsManager, FirebaseAnalytics firebaseAnalytics) {
        return (ThemeAnalytics) f.b.b.c(applicationModule.providesThemeAnalytics(analyticsManager, firebaseAnalytics));
    }

    @Override // javax.inject.Provider
    public ThemeAnalytics get() {
        return providesThemeAnalytics(this.module, this.analyticsManagerProvider.get(), this.firebaseAnalyticsProvider.get());
    }
}
