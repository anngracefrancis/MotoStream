package cm.aptoide.pt.app;

import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.account.view.store.StoreManager;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.app.view.AppCoinsViewModel;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.view.AppViewConfiguration;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.AppStats;
import cm.aptoide.pt.view.app.DetailedApp;
import cm.aptoide.pt.view.app.DetailedAppRequestResult;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppViewModelManager {
    private final AppCenter appCenter;
    private final AppCoinsAdvertisingManager appCoinsAdvertisingManager;
    private final AppCoinsManager appCoinsManager;
    private final AppViewConfiguration appViewConfiguration;
    private final AppcMigrationManager appcMigrationManager;
    private AppModel cachedApp;
    private AppCoinsViewModel cachedAppCoinsViewModel;
    private final DownloadStateParser downloadStateParser;
    private final InstallManager installManager;
    private final String marketName;
    private final StoreManager storeManager;

    public AppViewModelManager(AppViewConfiguration appViewConfiguration, StoreManager storeManager, String str, AppCenter appCenter, DownloadStateParser downloadStateParser, InstallManager installManager, AppcMigrationManager appcMigrationManager, AppCoinsAdvertisingManager appCoinsAdvertisingManager, AppCoinsManager appCoinsManager) {
        this.appViewConfiguration = appViewConfiguration;
        this.storeManager = storeManager;
        this.marketName = str;
        this.appCenter = appCenter;
        this.downloadStateParser = downloadStateParser;
        this.installManager = installManager;
        this.appcMigrationManager = appcMigrationManager;
        this.appCoinsAdvertisingManager = appCoinsAdvertisingManager;
        this.appCoinsManager = appCoinsManager;
    }

    private Single<AppModel> createAppViewViewModel(final DetailedApp detailedApp) {
        final AppStats stats = detailedApp.getStats();
        return isStoreFollowed(detailedApp.getStore().getId()).n(new rx.m.e() { // from class: cm.aptoide.pt.app.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4140f.b(detailedApp, stats, (Boolean) obj);
            }
        });
    }

    private rx.e<AppCoinsViewModel> getAppCoinsViewModel(final AppModel appModel) {
        AppCoinsViewModel appCoinsViewModel = this.cachedAppCoinsViewModel;
        if (appCoinsViewModel != null) {
            return rx.e.S(appCoinsViewModel);
        }
        Single singleM = Single.m(new BonusAppcModel(false, 0));
        Single<AppCoinsAdvertisingModel> singleM2 = Single.m(new AppCoinsAdvertisingModel());
        if (appModel.hasBilling()) {
            singleM = g.a.a.a.d.d(this.appCoinsManager.getBonusAppc());
        }
        if (appModel.hasAdvertising()) {
            singleM2 = this.appCoinsAdvertisingManager.getAdvertising(appModel.getPackageName(), appModel.getVersionCode());
        }
        return Single.C(singleM2, singleM, new rx.m.f() { // from class: cm.aptoide.pt.app.n0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return this.f4155f.c(appModel, (AppCoinsAdvertisingModel) obj, (BonusAppcModel) obj2);
            }
        }).A();
    }

    private rx.e<DownloadModel> getDownloadModel(AppModel appModel) {
        return loadDownloadModel(appModel.getMd5(), appModel.getPackageName(), appModel.getVersionCode(), appModel.getSignature(), appModel.getStore().getId(), appModel.hasAdvertising() || appModel.hasBilling());
    }

    private rx.e<MigrationModel> getMigrationModel(AppModel appModel) {
        return this.appcMigrationManager.isAppMigrated(appModel.getPackageName()).X(new rx.m.e() { // from class: cm.aptoide.pt.app.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return new MigrationModel(((Boolean) obj).booleanValue());
            }
        });
    }

    private Single<Boolean> isStoreFollowed(long j2) {
        return this.storeManager.isSubscribed(j2).E().Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createAppViewViewModel$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ AppModel b(DetailedApp detailedApp, AppStats appStats, Boolean bool) {
        AppModel appModel = new AppModel(detailedApp.getId(), detailedApp.getName(), detailedApp.getStore(), this.appViewConfiguration.getStoreTheme(), detailedApp.isGoodApp(), detailedApp.getMalware(), detailedApp.getAppFlags(), detailedApp.getTags(), detailedApp.getUsedFeatures(), detailedApp.getUsedPermissions(), detailedApp.getFileSize(), detailedApp.getMd5(), detailedApp.getPath(), detailedApp.getPathAlt(), detailedApp.getVersionCode(), detailedApp.getVersionName(), detailedApp.getPackageName(), detailedApp.getSize(), appStats.getDownloads(), appStats.getGlobalRating(), appStats.getPackageDownloads(), appStats.getRating(), detailedApp.getDeveloper(), detailedApp.getGraphic(), detailedApp.getIcon(), detailedApp.getMedia(), detailedApp.getModified(), detailedApp.getAdded(), detailedApp.getObb(), detailedApp.isLatestTrustedVersion(), detailedApp.getUniqueName(), this.appViewConfiguration.shouldInstall(), this.appViewConfiguration.getAppc(), this.appViewConfiguration.getMinimalAd(), this.appViewConfiguration.getEditorsChoice(), this.appViewConfiguration.getOriginTag(), bool.booleanValue(), this.marketName, detailedApp.hasBilling(), detailedApp.hasAdvertising(), detailedApp.getBdsFlags(), this.appViewConfiguration.getCampaignUrl(), detailedApp.getSignature(), detailedApp.isMature(), detailedApp.getSplits(), detailedApp.getRequiredSplits(), this.appViewConfiguration.getOemId(), detailedApp.isBeta(), detailedApp.getAppCategory(), detailedApp.getCampaign());
        this.cachedApp = appModel;
        return appModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAppCoinsViewModel$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ AppCoinsViewModel c(AppModel appModel, AppCoinsAdvertisingModel appCoinsAdvertisingModel, BonusAppcModel bonusAppcModel) {
        AppCoinsViewModel appCoinsViewModel = new AppCoinsViewModel(false, appModel.hasBilling(), appCoinsAdvertisingModel, bonusAppcModel);
        this.cachedAppCoinsViewModel = appCoinsViewModel;
        return appCoinsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDownloadModel$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DownloadModel f(Install install, Boolean bool) {
        return new DownloadModel(this.downloadStateParser.parseDownloadType(install.getType(), bool.booleanValue()), install.getProgress(), this.downloadStateParser.parseDownloadState(install.getState(), install.isIndeterminate()), install.getAppSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeAppViewModel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(final AppModel appModel) {
        return rx.e.d(getDownloadModel(appModel), getAppCoinsViewModel(appModel), getMigrationModel(appModel), new rx.m.g() { // from class: cm.aptoide.pt.app.l0
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return this.a.g(appModel, (DownloadModel) obj, (AppCoinsViewModel) obj2, (MigrationModel) obj3);
            }
        });
    }

    private Single<AppModel> loadAppModel(long j2, String str, String str2) {
        AppModel appModel = this.cachedApp;
        return appModel != null ? Single.m(appModel) : this.appCenter.loadDetailedApp(j2, str, str2).i(new rx.m.e() { // from class: cm.aptoide.pt.app.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4149f.d((DetailedAppRequestResult) obj);
            }
        });
    }

    private Single<AppModel> loadAppModelFromMd5(String str) {
        AppModel appModel = this.cachedApp;
        return (appModel == null || !appModel.getMd5().equals(str)) ? this.appCenter.loadDetailedAppFromMd5(str).i(new i0(this)) : Single.m(this.cachedApp);
    }

    private Single<AppModel> loadAppViewViewModelFromUniqueName(String str) {
        AppModel appModel = this.cachedApp;
        return (appModel == null || !appModel.getUniqueName().equals(str)) ? this.appCenter.loadDetailedAppFromUniqueName(str).i(new i0(this)) : Single.m(this.cachedApp);
    }

    private rx.e<DownloadModel> loadDownloadModel(String str, String str2, int i2, String str3, long j2, boolean z) {
        return rx.e.e(this.installManager.getInstall(str, str2, i2), this.appcMigrationManager.isMigrationApp(str2, str3, i2, j2, z), new rx.m.f() { // from class: cm.aptoide.pt.app.k0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return this.f4145f.f((Install) obj, (Boolean) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: map, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Single<AppModel> e(DetailedAppRequestResult detailedAppRequestResult) {
        if (detailedAppRequestResult.getDetailedApp() != null) {
            return createAppViewViewModel(detailedAppRequestResult.getDetailedApp());
        }
        if (detailedAppRequestResult.isLoading()) {
            return Single.m(new AppModel(detailedAppRequestResult.isLoading()));
        }
        return detailedAppRequestResult.hasError() ? Single.m(new AppModel(detailedAppRequestResult.getError())) : Single.m(new AppModel(DetailedAppRequestResult.Error.GENERIC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mergeToAppViewModel, reason: merged with bridge method [inline-methods] */
    public AppViewModel g(AppModel appModel, DownloadModel downloadModel, AppCoinsViewModel appCoinsViewModel, MigrationModel migrationModel) {
        return new AppViewModel(appModel, downloadModel, appCoinsViewModel, migrationModel);
    }

    public Single<AppModel> getAppModel() {
        if (this.appViewConfiguration.getAppId() >= 0) {
            return loadAppModel(this.appViewConfiguration.getAppId(), this.appViewConfiguration.getStoreName(), this.appViewConfiguration.getPackageName());
        }
        if (this.appViewConfiguration.hasMd5()) {
            return loadAppModelFromMd5(this.appViewConfiguration.getMd5());
        }
        return this.appViewConfiguration.hasUniqueName() ? loadAppViewViewModelFromUniqueName(this.appViewConfiguration.getUniqueName()) : loadAppModel(this.appViewConfiguration.getPackageName(), this.appViewConfiguration.getStoreName());
    }

    public Single<AppViewModel> getAppViewModel() {
        return observeAppViewModel().E().Z0();
    }

    public rx.e<AppViewModel> observeAppViewModel() {
        return getAppModel().A().G(new rx.m.e() { // from class: cm.aptoide.pt.app.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4166f.h((AppModel) obj);
            }
        });
    }

    private Single<AppModel> loadAppModel(String str, String str2) {
        AppModel appModel = this.cachedApp;
        if (appModel != null && appModel.getPackageName().equals(str)) {
            return Single.m(this.cachedApp);
        }
        return this.appCenter.loadDetailedApp(str, str2).i(new rx.m.e() { // from class: cm.aptoide.pt.app.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4163f.e((DetailedAppRequestResult) obj);
            }
        });
    }
}
