package cm.aptoide.pt;

import cm.aptoide.pt.sync.SyncScheduler;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideSyncSchedulerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<SyncStorage> syncStorageProvider;

    public ApplicationModule_ProvideSyncSchedulerFactory(ApplicationModule applicationModule, Provider<SyncStorage> provider) {
        this.module = applicationModule;
        this.syncStorageProvider = provider;
    }

    public static ApplicationModule_ProvideSyncSchedulerFactory create(ApplicationModule applicationModule, Provider<SyncStorage> provider) {
        return new ApplicationModule_ProvideSyncSchedulerFactory(applicationModule, provider);
    }

    public static SyncScheduler provideSyncScheduler(ApplicationModule applicationModule, SyncStorage syncStorage) {
        return (SyncScheduler) f.b.b.c(applicationModule.provideSyncScheduler(syncStorage));
    }

    @Override // javax.inject.Provider
    public SyncScheduler get() {
        return provideSyncScheduler(this.module, this.syncStorageProvider.get());
    }
}
