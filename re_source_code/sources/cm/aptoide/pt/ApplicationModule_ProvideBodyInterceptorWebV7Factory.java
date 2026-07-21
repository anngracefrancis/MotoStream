package cm.aptoide.pt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.networking.AuthenticationPersistence;
import cm.aptoide.pt.networking.IdsRepository;
import cm.aptoide.pt.preferences.AptoideMd5Manager;
import cm.aptoide.pt.utils.q.QManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ApplicationModule_ProvideBodyInterceptorWebV7Factory implements Provider {
    private final Provider<AptoideMd5Manager> aptoideMd5ManagerProvider;
    private final Provider<String> aptoidePackageProvider;
    private final Provider<AuthenticationPersistence> authenticationPersistenceProvider;
    private final Provider<IdsRepository> idsRepositoryProvider;
    private final ApplicationModule module;
    private final Provider<QManager> qManagerProvider;
    private final Provider<Resources> resourcesProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public ApplicationModule_ProvideBodyInterceptorWebV7Factory(ApplicationModule applicationModule, Provider<AuthenticationPersistence> provider, Provider<IdsRepository> provider2, Provider<SharedPreferences> provider3, Provider<Resources> provider4, Provider<QManager> provider5, Provider<String> provider6, Provider<AptoideMd5Manager> provider7) {
        this.module = applicationModule;
        this.authenticationPersistenceProvider = provider;
        this.idsRepositoryProvider = provider2;
        this.sharedPreferencesProvider = provider3;
        this.resourcesProvider = provider4;
        this.qManagerProvider = provider5;
        this.aptoidePackageProvider = provider6;
        this.aptoideMd5ManagerProvider = provider7;
    }

    public static ApplicationModule_ProvideBodyInterceptorWebV7Factory create(ApplicationModule applicationModule, Provider<AuthenticationPersistence> provider, Provider<IdsRepository> provider2, Provider<SharedPreferences> provider3, Provider<Resources> provider4, Provider<QManager> provider5, Provider<String> provider6, Provider<AptoideMd5Manager> provider7) {
        return new ApplicationModule_ProvideBodyInterceptorWebV7Factory(applicationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static BodyInterceptor<BaseBody> provideBodyInterceptorWebV7(ApplicationModule applicationModule, AuthenticationPersistence authenticationPersistence, IdsRepository idsRepository, SharedPreferences sharedPreferences, Resources resources, QManager qManager, String str, AptoideMd5Manager aptoideMd5Manager) {
        return (BodyInterceptor) f.b.b.c(applicationModule.provideBodyInterceptorWebV7(authenticationPersistence, idsRepository, sharedPreferences, resources, qManager, str, aptoideMd5Manager));
    }

    @Override // javax.inject.Provider
    public BodyInterceptor<BaseBody> get() {
        return provideBodyInterceptorWebV7(this.module, this.authenticationPersistenceProvider.get(), this.idsRepositoryProvider.get(), this.sharedPreferencesProvider.get(), this.resourcesProvider.get(), this.qManagerProvider.get(), this.aptoidePackageProvider.get(), this.aptoideMd5ManagerProvider.get());
    }
}
