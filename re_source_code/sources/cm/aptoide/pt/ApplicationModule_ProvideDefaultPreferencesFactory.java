package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.Preferences;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideDefaultPreferencesFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvideDefaultPreferencesFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvideDefaultPreferencesFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvideDefaultPreferencesFactory(applicationModule, provider);
    }

    public static Preferences provideDefaultPreferences(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (Preferences) f.b.b.c(applicationModule.provideDefaultPreferences(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideDefaultPreferences(this.module, this.sharedPreferencesProvider.get());
    }
}
