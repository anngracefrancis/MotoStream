package cm.aptoide.pt;

import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import cm.aptoide.pt.downloadmanager.DownloadsRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideDownloadsRepositoryFactory implements Provider {
    private final Provider<DownloadPersistence> downloadPersistenceProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideDownloadsRepositoryFactory(ApplicationModule applicationModule, Provider<DownloadPersistence> provider) {
        this.module = applicationModule;
        this.downloadPersistenceProvider = provider;
    }

    public static ApplicationModule_ProvideDownloadsRepositoryFactory create(ApplicationModule applicationModule, Provider<DownloadPersistence> provider) {
        return new ApplicationModule_ProvideDownloadsRepositoryFactory(applicationModule, provider);
    }

    public static DownloadsRepository provideDownloadsRepository(ApplicationModule applicationModule, DownloadPersistence downloadPersistence) {
        return (DownloadsRepository) f.b.b.c(applicationModule.provideDownloadsRepository(downloadPersistence));
    }

    @Override // javax.inject.Provider
    public DownloadsRepository get() {
        return provideDownloadsRepository(this.module, this.downloadPersistenceProvider.get());
    }
}
