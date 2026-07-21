package cm.aptoide.pt;

import android.content.SharedPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBaseHostCacheFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesBaseHostCacheFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesBaseHostCacheFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesBaseHostCacheFactory(applicationModule, provider);
    }

    public static String providesBaseHostCache(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (String) f.b.b.c(applicationModule.providesBaseHostCache(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesBaseHostCache(this.module, this.sharedPreferencesProvider.get());
    }
}
