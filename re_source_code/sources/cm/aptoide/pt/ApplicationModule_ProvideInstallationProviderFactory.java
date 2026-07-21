package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.installer.InstallationProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideInstallationProviderFactory implements Provider {
    private final Provider<AptoideInstalledAppsRepository> aptoideInstalledAppsRepositoryProvider;
    private final Provider<AptoideDownloadManager> downloadManagerProvider;
    private final Provider<DownloadPersistence> downloadPersistenceProvider;
    private final ApplicationModule module;
    private final Provider<RoomStoredMinimalAdPersistence> roomStoredMinimalAdPersistenceProvider;

    public ApplicationModule_ProvideInstallationProviderFactory(ApplicationModule applicationModule, Provider<AptoideDownloadManager> provider, Provider<DownloadPersistence> provider2, Provider<AptoideInstalledAppsRepository> provider3, Provider<RoomStoredMinimalAdPersistence> provider4) {
        this.module = applicationModule;
        this.downloadManagerProvider = provider;
        this.downloadPersistenceProvider = provider2;
        this.aptoideInstalledAppsRepositoryProvider = provider3;
        this.roomStoredMinimalAdPersistenceProvider = provider4;
    }

    public static ApplicationModule_ProvideInstallationProviderFactory create(ApplicationModule applicationModule, Provider<AptoideDownloadManager> provider, Provider<DownloadPersistence> provider2, Provider<AptoideInstalledAppsRepository> provider3, Provider<RoomStoredMinimalAdPersistence> provider4) {
        return new ApplicationModule_ProvideInstallationProviderFactory(applicationModule, provider, provider2, provider3, provider4);
    }

    public static InstallationProvider provideInstallationProvider(ApplicationModule applicationModule, AptoideDownloadManager aptoideDownloadManager, DownloadPersistence downloadPersistence, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) {
        return (InstallationProvider) f.b.b.c(applicationModule.provideInstallationProvider(aptoideDownloadManager, downloadPersistence, aptoideInstalledAppsRepository, roomStoredMinimalAdPersistence));
    }

    @Override // javax.inject.Provider
    public InstallationProvider get() {
        return provideInstallationProvider(this.module, this.downloadManagerProvider.get(), this.downloadPersistenceProvider.get(), this.aptoideInstalledAppsRepositoryProvider.get(), this.roomStoredMinimalAdPersistenceProvider.get());
    }
}
