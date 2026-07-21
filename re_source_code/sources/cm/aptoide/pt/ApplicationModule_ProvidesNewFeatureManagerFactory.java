package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.themes.NewFeature;
import cm.aptoide.pt.themes.NewFeatureManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesNewFeatureManagerFactory implements Provider {
    private final Provider<LocalNotificationSyncManager> localNotificationSyncManagerProvider;
    private final ApplicationModule module;
    private final Provider<NewFeature> newFeatureProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesNewFeatureManagerFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider, Provider<NewFeature> provider2, Provider<LocalNotificationSyncManager> provider3) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
        this.newFeatureProvider = provider2;
        this.localNotificationSyncManagerProvider = provider3;
    }

    public static ApplicationModule_ProvidesNewFeatureManagerFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider, Provider<NewFeature> provider2, Provider<LocalNotificationSyncManager> provider3) {
        return new ApplicationModule_ProvidesNewFeatureManagerFactory(applicationModule, provider, provider2, provider3);
    }

    public static NewFeatureManager providesNewFeatureManager(ApplicationModule applicationModule, SharedPreferences sharedPreferences, NewFeature newFeature, LocalNotificationSyncManager localNotificationSyncManager) {
        return (NewFeatureManager) f.b.b.c(applicationModule.providesNewFeatureManager(sharedPreferences, newFeature, localNotificationSyncManager));
    }

    @Override // javax.inject.Provider
    public NewFeatureManager get() {
        return providesNewFeatureManager(this.module, this.sharedPreferencesProvider.get(), this.newFeatureProvider.get(), this.localNotificationSyncManagerProvider.get());
    }
}
