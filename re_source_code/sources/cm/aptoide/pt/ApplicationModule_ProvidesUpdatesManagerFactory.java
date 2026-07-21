package cm.aptoide.pt;

import cm.aptoide.pt.home.apps.UpdatesManager;
import cm.aptoide.pt.updates.UpdateRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUpdatesManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<UpdateRepository> updateRepositoryProvider;

    public ApplicationModule_ProvidesUpdatesManagerFactory(ApplicationModule applicationModule, Provider<UpdateRepository> provider) {
        this.module = applicationModule;
        this.updateRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesUpdatesManagerFactory create(ApplicationModule applicationModule, Provider<UpdateRepository> provider) {
        return new ApplicationModule_ProvidesUpdatesManagerFactory(applicationModule, provider);
    }

    public static UpdatesManager providesUpdatesManager(ApplicationModule applicationModule, UpdateRepository updateRepository) {
        return (UpdatesManager) f.b.b.c(applicationModule.providesUpdatesManager(updateRepository));
    }

    @Override // javax.inject.Provider
    public UpdatesManager get() {
        return providesUpdatesManager(this.module, this.updateRepositoryProvider.get());
    }
}
