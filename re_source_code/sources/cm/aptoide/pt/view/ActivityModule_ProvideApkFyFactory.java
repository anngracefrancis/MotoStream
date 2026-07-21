package cm.aptoide.pt.view;

import android.content.SharedPreferences;
import cm.aptoide.pt.analytics.FirstLaunchAnalytics;
import cm.aptoide.pt.apkfy.ApkFyParser;
import cm.aptoide.pt.apkfy.ApkfyManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideApkFyFactory implements Provider {
    private final Provider<ApkfyManager> apkfyManagerProvider;
    private final Provider<FirstLaunchAnalytics> firstLaunchAnalyticsProvider;
    private final ActivityModule module;
    private final Provider<SharedPreferences> securePreferencesProvider;

    public ActivityModule_ProvideApkFyFactory(ActivityModule activityModule, Provider<SharedPreferences> provider, Provider<ApkfyManager> provider2, Provider<FirstLaunchAnalytics> provider3) {
        this.module = activityModule;
        this.securePreferencesProvider = provider;
        this.apkfyManagerProvider = provider2;
        this.firstLaunchAnalyticsProvider = provider3;
    }

    public static ActivityModule_ProvideApkFyFactory create(ActivityModule activityModule, Provider<SharedPreferences> provider, Provider<ApkfyManager> provider2, Provider<FirstLaunchAnalytics> provider3) {
        return new ActivityModule_ProvideApkFyFactory(activityModule, provider, provider2, provider3);
    }

    public static ApkFyParser provideApkFy(ActivityModule activityModule, SharedPreferences sharedPreferences, ApkfyManager apkfyManager, FirstLaunchAnalytics firstLaunchAnalytics) {
        return (ApkFyParser) f.b.b.c(activityModule.provideApkFy(sharedPreferences, apkfyManager, firstLaunchAnalytics));
    }

    @Override // javax.inject.Provider
    public ApkFyParser get() {
        return provideApkFy(this.module, this.securePreferencesProvider.get(), this.apkfyManagerProvider.get(), this.firstLaunchAnalyticsProvider.get());
    }
}
