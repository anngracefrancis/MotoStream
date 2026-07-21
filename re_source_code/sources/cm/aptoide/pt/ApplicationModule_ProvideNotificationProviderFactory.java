package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomNotificationPersistence;
import cm.aptoide.pt.notification.NotificationProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideNotificationProviderFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<RoomNotificationPersistence> notificationPersistenceProvider;

    public ApplicationModule_ProvideNotificationProviderFactory(ApplicationModule applicationModule, Provider<RoomNotificationPersistence> provider) {
        this.module = applicationModule;
        this.notificationPersistenceProvider = provider;
    }

    public static ApplicationModule_ProvideNotificationProviderFactory create(ApplicationModule applicationModule, Provider<RoomNotificationPersistence> provider) {
        return new ApplicationModule_ProvideNotificationProviderFactory(applicationModule, provider);
    }

    public static NotificationProvider provideNotificationProvider(ApplicationModule applicationModule, RoomNotificationPersistence roomNotificationPersistence) {
        return (NotificationProvider) f.b.b.c(applicationModule.provideNotificationProvider(roomNotificationPersistence));
    }

    @Override // javax.inject.Provider
    public NotificationProvider get() {
        return provideNotificationProvider(this.module, this.notificationPersistenceProvider.get());
    }
}
