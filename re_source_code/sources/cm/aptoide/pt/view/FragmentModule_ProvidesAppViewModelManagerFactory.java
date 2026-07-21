package cm.aptoide.pt.view;

import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.account.view.store.StoreManager;
import cm.aptoide.pt.app.AppCoinsAdvertisingManager;
import cm.aptoide.pt.app.AppViewModelManager;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.view.app.AppCenter;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAppViewModelManagerFactory implements Provider {
    private final Provider<AppCenter> appCenterProvider;
    private final Provider<AppCoinsAdvertisingManager> appCoinsAdvertisingManagerProvider;
    private final Provider<AppCoinsManager> appCoinsManagerProvider;
    private final Provider<AppViewConfiguration> appViewConfigurationProvider;
    private final Provider<AppcMigrationManager> appcMigrationManagerProvider;
    private final Provider<DownloadStateParser> downloadStateParserProvider;
    private final Provider<InstallManager> installManagerProvider;
    private final Provider<String> marketNameProvider;
    private final FragmentModule module;
    private final Provider<StoreManager> storeManagerProvider;

    public FragmentModule_ProvidesAppViewModelManagerFactory(FragmentModule fragmentModule, Provider<AppViewConfiguration> provider, Provider<StoreManager> provider2, Provider<String> provider3, Provider<AppCenter> provider4, Provider<DownloadStateParser> provider5, Provider<InstallManager> provider6, Provider<AppcMigrationManager> provider7, Provider<AppCoinsAdvertisingManager> provider8, Provider<AppCoinsManager> provider9) {
        this.module = fragmentModule;
        this.appViewConfigurationProvider = provider;
        this.storeManagerProvider = provider2;
        this.marketNameProvider = provider3;
        this.appCenterProvider = provider4;
        this.downloadStateParserProvider = provider5;
        this.installManagerProvider = provider6;
        this.appcMigrationManagerProvider = provider7;
        this.appCoinsAdvertisingManagerProvider = provider8;
        this.appCoinsManagerProvider = provider9;
    }

    public static FragmentModule_ProvidesAppViewModelManagerFactory create(FragmentModule fragmentModule, Provider<AppViewConfiguration> provider, Provider<StoreManager> provider2, Provider<String> provider3, Provider<AppCenter> provider4, Provider<DownloadStateParser> provider5, Provider<InstallManager> provider6, Provider<AppcMigrationManager> provider7, Provider<AppCoinsAdvertisingManager> provider8, Provider<AppCoinsManager> provider9) {
        return new FragmentModule_ProvidesAppViewModelManagerFactory(fragmentModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static AppViewModelManager providesAppViewModelManager(FragmentModule fragmentModule, AppViewConfiguration appViewConfiguration, StoreManager storeManager, String str, AppCenter appCenter, DownloadStateParser downloadStateParser, InstallManager installManager, AppcMigrationManager appcMigrationManager, AppCoinsAdvertisingManager appCoinsAdvertisingManager, AppCoinsManager appCoinsManager) {
        return (AppViewModelManager) f.b.b.c(fragmentModule.providesAppViewModelManager(appViewConfiguration, storeManager, str, appCenter, downloadStateParser, installManager, appcMigrationManager, appCoinsAdvertisingManager, appCoinsManager));
    }

    @Override // javax.inject.Provider
    public AppViewModelManager get() {
        return providesAppViewModelManager(this.module, this.appViewConfigurationProvider.get(), this.storeManagerProvider.get(), this.marketNameProvider.get(), this.appCenterProvider.get(), this.downloadStateParserProvider.get(), this.installManagerProvider.get(), this.appcMigrationManagerProvider.get(), this.appCoinsAdvertisingManagerProvider.get(), this.appCoinsManagerProvider.get());
    }
}
