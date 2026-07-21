package cm.aptoide.pt;

import cm.aptoide.pt.notification.RoomLocalNotificationSyncPersistence;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideSyncStorageFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<RoomLocalNotificationSyncPersistence> persistenceProvider;

    public ApplicationModule_ProvideSyncStorageFactory(ApplicationModule applicationModule, Provider<RoomLocalNotificationSyncPersistence> provider) {
        this.module = applicationModule;
        this.persistenceProvider = provider;
    }

    public static ApplicationModule_ProvideSyncStorageFactory create(ApplicationModule applicationModule, Provider<RoomLocalNotificationSyncPersistence> provider) {
        return new ApplicationModule_ProvideSyncStorageFactory(applicationModule, provider);
    }

    public static SyncStorage provideSyncStorage(ApplicationModule applicationModule, RoomLocalNotificationSyncPersistence roomLocalNotificationSyncPersistence) {
        return (SyncStorage) f.b.b.c(applicationModule.provideSyncStorage(roomLocalNotificationSyncPersistence));
    }

    @Override // javax.inject.Provider
    public SyncStorage get() {
        return provideSyncStorage(this.module, this.persistenceProvider.get());
    }
}
