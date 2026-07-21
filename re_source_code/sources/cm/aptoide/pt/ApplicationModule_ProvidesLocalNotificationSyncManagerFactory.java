package cm.aptoide.pt;

import cm.aptoide.pt.notification.NotificationProvider;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import cm.aptoide.pt.sync.SyncScheduler;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesLocalNotificationSyncManagerFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<NotificationProvider> providerProvider;
    private final Provider<SyncScheduler> syncSchedulerProvider;

    public ApplicationModule_ProvidesLocalNotificationSyncManagerFactory(ApplicationModule applicationModule, Provider<SyncScheduler> provider, Provider<NotificationProvider> provider2) {
        this.module = applicationModule;
        this.syncSchedulerProvider = provider;
        this.providerProvider = provider2;
    }

    public static ApplicationModule_ProvidesLocalNotificationSyncManagerFactory create(ApplicationModule applicationModule, Provider<SyncScheduler> provider, Provider<NotificationProvider> provider2) {
        return new ApplicationModule_ProvidesLocalNotificationSyncManagerFactory(applicationModule, provider, provider2);
    }

    public static LocalNotificationSyncManager providesLocalNotificationSyncManager(ApplicationModule applicationModule, SyncScheduler syncScheduler, NotificationProvider notificationProvider) {
        return (LocalNotificationSyncManager) f.b.b.c(applicationModule.providesLocalNotificationSyncManager(syncScheduler, notificationProvider));
    }

    @Override // javax.inject.Provider
    public LocalNotificationSyncManager get() {
        return providesLocalNotificationSyncManager(this.module, this.syncSchedulerProvider.get(), this.providerProvider.get());
    }
}
