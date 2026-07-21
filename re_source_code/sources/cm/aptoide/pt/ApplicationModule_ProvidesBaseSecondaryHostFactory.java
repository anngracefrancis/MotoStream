package cm.aptoide.pt;

import android.content.SharedPreferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBaseSecondaryHostFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesBaseSecondaryHostFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesBaseSecondaryHostFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesBaseSecondaryHostFactory(applicationModule, provider);
    }

    public static String providesBaseSecondaryHost(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (String) f.b.b.c(applicationModule.providesBaseSecondaryHost(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesBaseSecondaryHost(this.module, this.sharedPreferencesProvider.get());
    }
}
