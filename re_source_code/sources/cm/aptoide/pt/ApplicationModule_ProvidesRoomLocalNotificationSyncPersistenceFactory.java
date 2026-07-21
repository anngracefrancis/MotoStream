package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.RoomLocalNotificationSyncPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesRoomLocalNotificationSyncPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;
    private final Provider<NotificationProvider> providerProvider;

    public ApplicationModule_ProvidesRoomLocalNotificationSyncPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<NotificationProvider> provider2) {
        this.module = applicationModule;
        this.databaseProvider = provider;
        this.providerProvider = provider2;
    }

    public static ApplicationModule_ProvidesRoomLocalNotificationSyncPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider, Provider<NotificationProvider> provider2) {
        return new ApplicationModule_ProvidesRoomLocalNotificationSyncPersistenceFactory(applicationModule, provider, provider2);
    }

    public static RoomLocalNotificationSyncPersistence providesRoomLocalNotificationSyncPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase, NotificationProvider notificationProvider) {
        return (RoomLocalNotificationSyncPersistence) f.b.b.c(applicationModule.providesRoomLocalNotificationSyncPersistence(aptoideDatabase, notificationProvider));
    }

    @Override // javax.inject.Provider
    public RoomLocalNotificationSyncPersistence get() {
        return providesRoomLocalNotificationSyncPersistence(this.module, this.databaseProvider.get(), this.providerProvider.get());
    }
}
