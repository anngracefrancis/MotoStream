package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.appview.PreferencesPersister;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUserPreferencesPersisterFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesUserPreferencesPersisterFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesUserPreferencesPersisterFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesUserPreferencesPersisterFactory(applicationModule, provider);
    }

    public static PreferencesPersister providesUserPreferencesPersister(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (PreferencesPersister) f.b.b.c(applicationModule.providesUserPreferencesPersister(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public PreferencesPersister get() {
        return providesUserPreferencesPersister(this.module, this.sharedPreferencesProvider.get());
    }
}
