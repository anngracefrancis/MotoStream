package cm.aptoide.pt;

import cm.aptoide.pt.database.room.AptoideDatabase;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideDownloadPersistenceFactory implements Provider {
    private final Provider<AptoideDatabase> databaseProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideDownloadPersistenceFactory(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        this.module = applicationModule;
        this.databaseProvider = provider;
    }

    public static ApplicationModule_ProvideDownloadPersistenceFactory create(ApplicationModule applicationModule, Provider<AptoideDatabase> provider) {
        return new ApplicationModule_ProvideDownloadPersistenceFactory(applicationModule, provider);
    }

    public static DownloadPersistence provideDownloadPersistence(ApplicationModule applicationModule, AptoideDatabase aptoideDatabase) {
        return (DownloadPersistence) f.b.b.c(applicationModule.provideDownloadPersistence(aptoideDatabase));
    }

    @Override // javax.inject.Provider
    public DownloadPersistence get() {
        return provideDownloadPersistence(this.module, this.databaseProvider.get());
    }
}
