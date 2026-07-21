package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.blacklist.BlacklistPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesBlacklistPersistenceFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvidesBlacklistPersistenceFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.sharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesBlacklistPersistenceFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesBlacklistPersistenceFactory(applicationModule, provider);
    }

    public static BlacklistPersistence providesBlacklistPersistence(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (BlacklistPersistence) f.b.b.c(applicationModule.providesBlacklistPersistence(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public BlacklistPersistence get() {
        return providesBlacklistPersistence(this.module, this.sharedPreferencesProvider.get());
    }
}
