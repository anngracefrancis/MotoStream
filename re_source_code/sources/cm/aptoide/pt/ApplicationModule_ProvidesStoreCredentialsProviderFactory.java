package cm.aptoide.pt;

import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvidesStoreCredentialsProviderFactory implements Provider {
    private final ApplicationModule module;
    private final Provider<RoomStoreRepository> storeRepositoryProvider;

    public ApplicationModule_ProvidesStoreCredentialsProviderFactory(ApplicationModule applicationModule, Provider<RoomStoreRepository> provider) {
        this.module = applicationModule;
        this.storeRepositoryProvider = provider;
    }

    public static ApplicationModule_ProvidesStoreCredentialsProviderFactory create(ApplicationModule applicationModule, Provider<RoomStoreRepository> provider) {
        return new ApplicationModule_ProvidesStoreCredentialsProviderFactory(applicationModule, provider);
    }

    public static StoreCredentialsProvider providesStoreCredentialsProvider(ApplicationModule applicationModule, RoomStoreRepository roomStoreRepository) {
        return (StoreCredentialsProvider) f.b.b.c(applicationModule.providesStoreCredentialsProvider(roomStoreRepository));
    }

    @Override // javax.inject.Provider
    public StoreCredentialsProvider get() {
        return providesStoreCredentialsProvider(this.module, this.storeRepositoryProvider.get());
    }
}
