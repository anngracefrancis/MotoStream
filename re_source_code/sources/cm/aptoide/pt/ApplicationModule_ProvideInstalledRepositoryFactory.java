package cm.aptoide.pt;

import cm.aptoide.pt.database.RoomInstalledPersistence;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.utils.FileUtils;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideInstalledRepositoryFactory implements Provider {
    private final Provider<FileUtils> fileUtilsProvider;
    private final ApplicationModule module;
    private final Provider<RoomInstalledPersistence> roomInstalledPersistenceProvider;

    public ApplicationModule_ProvideInstalledRepositoryFactory(ApplicationModule applicationModule, Provider<RoomInstalledPersistence> provider, Provider<FileUtils> provider2) {
        this.module = applicationModule;
        this.roomInstalledPersistenceProvider = provider;
        this.fileUtilsProvider = provider2;
    }

    public static ApplicationModule_ProvideInstalledRepositoryFactory create(ApplicationModule applicationModule, Provider<RoomInstalledPersistence> provider, Provider<FileUtils> provider2) {
        return new ApplicationModule_ProvideInstalledRepositoryFactory(applicationModule, provider, provider2);
    }

    public static AptoideInstalledAppsRepository provideInstalledRepository(ApplicationModule applicationModule, RoomInstalledPersistence roomInstalledPersistence, FileUtils fileUtils) {
        return (AptoideInstalledAppsRepository) f.b.b.c(applicationModule.provideInstalledRepository(roomInstalledPersistence, fileUtils));
    }

    @Override // javax.inject.Provider
    public AptoideInstalledAppsRepository get() {
        return provideInstalledRepository(this.module, this.roomInstalledPersistenceProvider.get(), this.fileUtilsProvider.get());
    }
}
