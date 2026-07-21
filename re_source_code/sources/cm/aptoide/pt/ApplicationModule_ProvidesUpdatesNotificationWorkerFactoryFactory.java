package cm.aptoide.pt;

import android.content.SharedPreferences;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.notification.AptoideWorkerFactory;
import cm.aptoide.pt.sync.SyncScheduler;
import cm.aptoide.pt.sync.alarm.SyncStorage;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.view.app.AppCenter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesUpdatesNotificationWorkerFactoryFactory implements Provider {
    private final Provider<AppCenter> appCenterProvider;
    private final Provider<AptoideInstallManager> aptoideInstallManagerProvider;
    private final Provider<CrashReport> crashReportProvider;
    private final ApplicationModule module;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<SyncScheduler> syncSchedulerProvider;
    private final Provider<SyncStorage> syncStorageProvider;
    private final Provider<UpdateRepository> updateRepositoryProvider;

    public ApplicationModule_ProvidesUpdatesNotificationWorkerFactoryFactory(ApplicationModule applicationModule, Provider<UpdateRepository> provider, Provider<SharedPreferences> provider2, Provider<AptoideInstallManager> provider3, Provider<SyncScheduler> provider4, Provider<SyncStorage> provider5, Provider<CrashReport> provider6, Provider<AppCenter> provider7) {
        this.module = applicationModule;
        this.updateRepositoryProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.aptoideInstallManagerProvider = provider3;
        this.syncSchedulerProvider = provider4;
        this.syncStorageProvider = provider5;
        this.crashReportProvider = provider6;
        this.appCenterProvider = provider7;
    }

    public static ApplicationModule_ProvidesUpdatesNotificationWorkerFactoryFactory create(ApplicationModule applicationModule, Provider<UpdateRepository> provider, Provider<SharedPreferences> provider2, Provider<AptoideInstallManager> provider3, Provider<SyncScheduler> provider4, Provider<SyncStorage> provider5, Provider<CrashReport> provider6, Provider<AppCenter> provider7) {
        return new ApplicationModule_ProvidesUpdatesNotificationWorkerFactoryFactory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AptoideWorkerFactory providesUpdatesNotificationWorkerFactory(ApplicationModule applicationModule, UpdateRepository updateRepository, SharedPreferences sharedPreferences, AptoideInstallManager aptoideInstallManager, SyncScheduler syncScheduler, SyncStorage syncStorage, CrashReport crashReport, AppCenter appCenter) {
        return (AptoideWorkerFactory) f.b.b.c(applicationModule.providesUpdatesNotificationWorkerFactory(updateRepository, sharedPreferences, aptoideInstallManager, syncScheduler, syncStorage, crashReport, appCenter));
    }

    @Override // javax.inject.Provider
    public AptoideWorkerFactory get() {
        return providesUpdatesNotificationWorkerFactory(this.module, this.updateRepositoryProvider.get(), this.sharedPreferencesProvider.get(), this.aptoideInstallManagerProvider.get(), this.syncSchedulerProvider.get(), this.syncStorageProvider.get(), this.crashReportProvider.get(), this.appCenterProvider.get());
    }
}
