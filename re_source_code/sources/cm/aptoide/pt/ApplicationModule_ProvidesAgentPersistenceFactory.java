package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.account.AgentPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesAgentPersistenceFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SharedPreferences> secureSharedPreferencesProvider;

    public ApplicationModule_ProvidesAgentPersistenceFactory(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        this.module = applicationModule;
        this.secureSharedPreferencesProvider = provider;
    }

    public static ApplicationModule_ProvidesAgentPersistenceFactory create(ApplicationModule applicationModule, Provider<SharedPreferences> provider) {
        return new ApplicationModule_ProvidesAgentPersistenceFactory(applicationModule, provider);
    }

    public static AgentPersistence providesAgentPersistence(ApplicationModule applicationModule, SharedPreferences sharedPreferences) {
        return (AgentPersistence) f.b.b.c(applicationModule.providesAgentPersistence(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public AgentPersistence get() {
        return providesAgentPersistence(this.module, this.secureSharedPreferencesProvider.get());
    }
}
