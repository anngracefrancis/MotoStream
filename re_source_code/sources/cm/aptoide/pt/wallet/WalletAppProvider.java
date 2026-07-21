package cm.aptoide.pt.wallet;

import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.aab.Split;
import cm.aptoide.pt.app.DownloadModel;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.dataprovider.model.v7.Obb;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.promotions.WalletApp;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.DetailedApp;
import cm.aptoide.pt.view.app.DetailedAppRequestResult;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: WalletAppProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J0\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lcm/aptoide/pt/wallet/WalletAppProvider;", HttpUrl.FRAGMENT_ENCODE_SET, "appCenter", "Lcm/aptoide/pt/view/app/AppCenter;", "aptoideInstalledAppsRepository", "Lcm/aptoide/pt/install/AptoideInstalledAppsRepository;", "installManager", "Lcm/aptoide/pt/install/InstallManager;", "downloadStateParser", "Lcm/aptoide/pt/app/DownloadStateParser;", "(Lcm/aptoide/pt/view/app/AppCenter;Lcm/aptoide/pt/install/AptoideInstalledAppsRepository;Lcm/aptoide/pt/install/InstallManager;Lcm/aptoide/pt/app/DownloadStateParser;)V", "getAppCenter", "()Lcm/aptoide/pt/view/app/AppCenter;", "getAptoideInstalledAppsRepository", "()Lcm/aptoide/pt/install/AptoideInstalledAppsRepository;", "getDownloadStateParser", "()Lcm/aptoide/pt/app/DownloadStateParser;", "getInstallManager", "()Lcm/aptoide/pt/install/InstallManager;", "getWalletApp", "Lrx/Observable;", "Lcm/aptoide/pt/promotions/WalletApp;", "mapToDownloadModel", "Lcm/aptoide/pt/app/DownloadModel;", "type", "Lcm/aptoide/pt/install/Install$InstallationType;", "progress", HttpUrl.FRAGMENT_ENCODE_SET, "state", "Lcm/aptoide/pt/install/Install$InstallationStatus;", "isIndeterminate", HttpUrl.FRAGMENT_ENCODE_SET, "appSize", HttpUrl.FRAGMENT_ENCODE_SET, "mapToWalletApp", "result", "Lcm/aptoide/pt/view/app/DetailedAppRequestResult;", "mergeToWalletApp", "walletApp", "isInstalled", "walletDownload", "Lcm/aptoide/pt/install/Install;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAppProvider {
    private final AppCenter appCenter;
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final DownloadStateParser downloadStateParser;
    private final InstallManager installManager;

    public WalletAppProvider(AppCenter appCenter, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, InstallManager installManager, DownloadStateParser downloadStateParser) {
        kotlin.jvm.internal.m.f(appCenter, "appCenter");
        kotlin.jvm.internal.m.f(aptoideInstalledAppsRepository, "aptoideInstalledAppsRepository");
        kotlin.jvm.internal.m.f(installManager, "installManager");
        kotlin.jvm.internal.m.f(downloadStateParser, "downloadStateParser");
        this.appCenter = appCenter;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
        this.installManager = installManager;
        this.downloadStateParser = downloadStateParser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getWalletApp$lambda-0, reason: not valid java name */
    public static final WalletApp m312getWalletApp$lambda0(WalletAppProvider walletAppProvider, DetailedAppRequestResult detailedAppRequestResult) {
        kotlin.jvm.internal.m.f(walletAppProvider, "this$0");
        kotlin.jvm.internal.m.e(detailedAppRequestResult, "app");
        return walletAppProvider.mapToWalletApp(detailedAppRequestResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getWalletApp$lambda-2, reason: not valid java name */
    public static final rx.e m313getWalletApp$lambda2(final WalletAppProvider walletAppProvider, WalletApp walletApp) {
        kotlin.jvm.internal.m.f(walletAppProvider, "this$0");
        return rx.e.d(rx.e.S(walletApp), walletAppProvider.aptoideInstalledAppsRepository.isInstalled(walletApp.getPackageName()), walletAppProvider.installManager.getInstall(walletApp.getMd5sum(), walletApp.getPackageName(), walletApp.getVersionCode()), new rx.m.g() { // from class: cm.aptoide.pt.wallet.b
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return WalletAppProvider.m314getWalletApp$lambda2$lambda1(this.a, (WalletApp) obj, (Boolean) obj2, (Install) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getWalletApp$lambda-2$lambda-1, reason: not valid java name */
    public static final WalletApp m314getWalletApp$lambda2$lambda1(WalletAppProvider walletAppProvider, WalletApp walletApp, Boolean bool, Install install) {
        kotlin.jvm.internal.m.f(walletAppProvider, "this$0");
        kotlin.jvm.internal.m.e(walletApp, "walletApp");
        kotlin.jvm.internal.m.e(bool, "isInstalled");
        boolean zBooleanValue = bool.booleanValue();
        kotlin.jvm.internal.m.e(install, "walletDownload");
        return walletAppProvider.mergeToWalletApp(walletApp, zBooleanValue, install);
    }

    private final DownloadModel mapToDownloadModel(Install.InstallationType type, int progress, Install.InstallationStatus state, boolean isIndeterminate, long appSize) {
        return new DownloadModel(this.downloadStateParser.parseDownloadType(type, false), progress, this.downloadStateParser.parseDownloadState(state, isIndeterminate), appSize);
    }

    private final WalletApp mapToWalletApp(DetailedAppRequestResult result) {
        if (result.hasError() || result.isLoading()) {
            return new WalletApp(null, false, null, null, 0L, null, null, 0, null, null, null, null, 0L, null, 0.0f, null, null, null, null, 524287, null);
        }
        DetailedApp detailedApp = result.getDetailedApp();
        String name = detailedApp.getName();
        kotlin.jvm.internal.m.e(name, "app.name");
        String icon = detailedApp.getIcon();
        kotlin.jvm.internal.m.e(icon, "app.icon");
        long id = detailedApp.getId();
        String packageName = detailedApp.getPackageName();
        kotlin.jvm.internal.m.e(packageName, "app.packageName");
        String md5 = detailedApp.getMd5();
        int versionCode = detailedApp.getVersionCode();
        String versionName = detailedApp.getVersionName();
        String path = detailedApp.getPath();
        String pathAlt = detailedApp.getPathAlt();
        Obb obb = detailedApp.getObb();
        long size = detailedApp.getSize();
        String name2 = detailedApp.getDeveloper().getName();
        kotlin.jvm.internal.m.e(name2, "app.developer.name");
        float average = detailedApp.getStats().getRating().getAverage();
        List<Split> splits = detailedApp.getSplits();
        kotlin.jvm.internal.m.e(splits, "app.splits");
        List<String> requiredSplits = detailedApp.getRequiredSplits();
        kotlin.jvm.internal.m.e(requiredSplits, "app.requiredSplits");
        return new WalletApp(null, false, name, icon, id, packageName, md5, versionCode, versionName, path, pathAlt, obb, size, name2, average, splits, requiredSplits, null, null, 393216, null);
    }

    private final WalletApp mergeToWalletApp(WalletApp walletApp, boolean isInstalled, Install walletDownload) {
        Install.InstallationType type = walletDownload.getType();
        kotlin.jvm.internal.m.e(type, "walletDownload.type");
        int progress = walletDownload.getProgress();
        Install.InstallationStatus state = walletDownload.getState();
        kotlin.jvm.internal.m.e(state, "walletDownload.state");
        walletApp.setDownloadModel(mapToDownloadModel(type, progress, state, walletDownload.isIndeterminate(), walletDownload.getAppSize()));
        walletApp.setInstalled(isInstalled);
        return walletApp;
    }

    public final AppCenter getAppCenter() {
        return this.appCenter;
    }

    public final AptoideInstalledAppsRepository getAptoideInstalledAppsRepository() {
        return this.aptoideInstalledAppsRepository;
    }

    public final DownloadStateParser getDownloadStateParser() {
        return this.downloadStateParser;
    }

    public final InstallManager getInstallManager() {
        return this.installManager;
    }

    public final rx.e<WalletApp> getWalletApp() {
        rx.e<WalletApp> eVarG = this.appCenter.loadDetailedApp(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME, "catappult").A().X(new rx.m.e() { // from class: cm.aptoide.pt.wallet.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletAppProvider.m312getWalletApp$lambda0(this.f8317f, (DetailedAppRequestResult) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.wallet.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return WalletAppProvider.m313getWalletApp$lambda2(this.f8321f, (WalletApp) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarG, "appCenter.loadDetailedAp…wnload)\n        }\n      }");
        return eVarG;
    }
}
