package cm.aptoide.pt.autoupdate;

import android.content.SharedPreferences;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallManager;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: AutoUpdateManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017H\u0002J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0015J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180!H\u0002J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0018H\u0002J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\u0006\u0010'\u001a\u00020\u001cR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcm/aptoide/pt/autoupdate/AutoUpdateManager;", HttpUrl.FRAGMENT_ENCODE_SET, "downloadFactory", "Lcm/aptoide/pt/download/DownloadFactory;", "permissionManager", "Lcm/aptoide/pt/actions/PermissionManager;", "installManager", "Lcm/aptoide/pt/install/InstallManager;", "downloadAnalytics", "Lcm/aptoide/pt/download/DownloadAnalytics;", "localVersionCode", HttpUrl.FRAGMENT_ENCODE_SET, "autoUpdateRepository", "Lcm/aptoide/pt/autoupdate/AutoUpdateRepository;", "localVersionSdk", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Lcm/aptoide/pt/download/DownloadFactory;Lcm/aptoide/pt/actions/PermissionManager;Lcm/aptoide/pt/install/InstallManager;Lcm/aptoide/pt/download/DownloadAnalytics;ILcm/aptoide/pt/autoupdate/AutoUpdateRepository;ILandroid/content/SharedPreferences;)V", "AUTO_UPDATE_SHOW", HttpUrl.FRAGMENT_ENCODE_SET, "clearAutoUpdateShow", HttpUrl.FRAGMENT_ENCODE_SET, "getAutoUpdateModel", "Lrx/Observable;", "Lcm/aptoide/pt/autoupdate/AutoUpdateModel;", "getInstall", "Lcm/aptoide/pt/install/Install;", "hasDownloadPermissions", HttpUrl.FRAGMENT_ENCODE_SET, "permissionService", "Lcm/aptoide/pt/actions/PermissionService;", "incrementAutoUpdateShow", "isDownloadComplete", "Lrx/Single;", "loadAutoUpdateModel", "shouldShowAutoUpdateDialog", "shouldUpdate", "autoUpdateModel", "startUpdate", "shouldInstall", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AutoUpdateManager {
    private final String AUTO_UPDATE_SHOW;
    private final AutoUpdateRepository autoUpdateRepository;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadFactory downloadFactory;
    private final InstallManager installManager;
    private final int localVersionCode;
    private final int localVersionSdk;
    private final PermissionManager permissionManager;
    private final SharedPreferences sharedPreferences;

    public AutoUpdateManager(DownloadFactory downloadFactory, PermissionManager permissionManager, InstallManager installManager, DownloadAnalytics downloadAnalytics, int i2, AutoUpdateRepository autoUpdateRepository, int i3, SharedPreferences sharedPreferences) {
        kotlin.jvm.internal.m.f(downloadFactory, "downloadFactory");
        kotlin.jvm.internal.m.f(permissionManager, "permissionManager");
        kotlin.jvm.internal.m.f(installManager, "installManager");
        kotlin.jvm.internal.m.f(downloadAnalytics, "downloadAnalytics");
        kotlin.jvm.internal.m.f(autoUpdateRepository, "autoUpdateRepository");
        kotlin.jvm.internal.m.f(sharedPreferences, "sharedPreferences");
        this.downloadFactory = downloadFactory;
        this.permissionManager = permissionManager;
        this.installManager = installManager;
        this.downloadAnalytics = downloadAnalytics;
        this.localVersionCode = i2;
        this.autoUpdateRepository = autoUpdateRepository;
        this.localVersionSdk = i3;
        this.sharedPreferences = sharedPreferences;
        this.AUTO_UPDATE_SHOW = "showAutoUpdate";
    }

    private final rx.e<AutoUpdateModel> getAutoUpdateModel() {
        rx.e<AutoUpdateModel> eVarA = this.autoUpdateRepository.loadAutoUpdateModel().A();
        kotlin.jvm.internal.m.e(eVarA, "autoUpdateRepository.loa…ateModel().toObservable()");
        return eVarA;
    }

    private final rx.e<Install> getInstall() {
        rx.e eVarG = getAutoUpdateModel().G(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m61getInstall$lambda7(this.f4754f, (AutoUpdateModel) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarG, "getAutoUpdateModel().fla…DownloadStarted() }\n    }");
        return eVarG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getInstall$lambda-7, reason: not valid java name */
    public static final rx.e m61getInstall$lambda7(AutoUpdateManager autoUpdateManager, AutoUpdateModel autoUpdateModel) {
        kotlin.jvm.internal.m.f(autoUpdateManager, "this$0");
        return autoUpdateManager.installManager.getInstall(autoUpdateModel.getMd5(), autoUpdateModel.getPackageName(), autoUpdateModel.getVersionCode()).F(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m62getInstall$lambda7$lambda6((Install) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getInstall$lambda-7$lambda-6, reason: not valid java name */
    public static final Boolean m62getInstall$lambda7$lambda6(Install install) {
        return Boolean.valueOf(install.hasDownloadStarted());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isDownloadComplete$lambda-3, reason: not valid java name */
    public static final Single m63isDownloadComplete$lambda3(AutoUpdateManager autoUpdateManager, AutoUpdateModel autoUpdateModel) {
        kotlin.jvm.internal.m.f(autoUpdateManager, "this$0");
        return autoUpdateManager.installManager.getDownload(autoUpdateModel.getMd5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isDownloadComplete$lambda-4, reason: not valid java name */
    public static final Boolean m64isDownloadComplete$lambda4(RoomDownload roomDownload) {
        return Boolean.valueOf(roomDownload != null && roomDownload.getOverallDownloadStatus() == 1);
    }

    private final Single<AutoUpdateModel> loadAutoUpdateModel() {
        Single singleI = this.autoUpdateRepository.loadFreshAutoUpdateModel().i(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m65loadAutoUpdateModel$lambda5(this.f4749f, (AutoUpdateModel) obj);
            }
        });
        kotlin.jvm.internal.m.e(singleI, "autoUpdateRepository.loa…utoUpdateModel)\n        }");
        return singleI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadAutoUpdateModel$lambda-5, reason: not valid java name */
    public static final Single m65loadAutoUpdateModel$lambda5(AutoUpdateManager autoUpdateManager, AutoUpdateModel autoUpdateModel) {
        kotlin.jvm.internal.m.f(autoUpdateManager, "this$0");
        if (!autoUpdateModel.wasSuccess()) {
            Single.h(new Throwable(autoUpdateModel.getStatus().toString()));
        }
        kotlin.jvm.internal.m.e(autoUpdateModel, "it");
        if (autoUpdateManager.shouldUpdate(autoUpdateModel)) {
            autoUpdateModel = autoUpdateModel.copy((223 & 1) != 0 ? autoUpdateModel.versionCode : 0, (223 & 2) != 0 ? autoUpdateModel.uri : null, (223 & 4) != 0 ? autoUpdateModel.md5 : null, (223 & 8) != 0 ? autoUpdateModel.minSdk : null, (223 & 16) != 0 ? autoUpdateModel.packageName : null, (223 & 32) != 0 ? autoUpdateModel.shouldUpdate : true, (223 & 64) != 0 ? autoUpdateModel.status : null, (223 & 128) != 0 ? autoUpdateModel.loading : false);
        }
        return Single.m(autoUpdateModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: shouldUpdate$lambda-0, reason: not valid java name */
    public static final Boolean m66shouldUpdate$lambda0(AutoUpdateModel autoUpdateModel) {
        return Boolean.valueOf(autoUpdateModel.getShouldUpdate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startUpdate$lambda-2, reason: not valid java name */
    public static final rx.e m67startUpdate$lambda2(final AutoUpdateManager autoUpdateManager, final boolean z, AutoUpdateModel autoUpdateModel) {
        kotlin.jvm.internal.m.f(autoUpdateManager, "this$0");
        return rx.e.S(autoUpdateManager.downloadFactory.create(autoUpdateModel.getMd5(), autoUpdateModel.getVersionCode(), autoUpdateModel.getPackageName(), autoUpdateModel.getUri(), false)).H(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m68startUpdate$lambda2$lambda1(this.f4755f, z, (RoomDownload) obj);
            }
        }).X0().b(autoUpdateManager.getInstall());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startUpdate$lambda-2$lambda-1, reason: not valid java name */
    public static final rx.b m68startUpdate$lambda2$lambda1(AutoUpdateManager autoUpdateManager, boolean z, RoomDownload roomDownload) {
        kotlin.jvm.internal.m.f(autoUpdateManager, "this$0");
        return autoUpdateManager.installManager.install(roomDownload, z);
    }

    public final void clearAutoUpdateShow() {
        this.sharedPreferences.edit().putInt(this.AUTO_UPDATE_SHOW, 0).apply();
    }

    public final rx.e<Boolean> hasDownloadPermissions(PermissionService permissionService) {
        kotlin.jvm.internal.m.f(permissionService, "permissionService");
        rx.e<Boolean> eVarHasDownloadAccess = this.permissionManager.hasDownloadAccess(permissionService);
        kotlin.jvm.internal.m.e(eVarHasDownloadAccess, "permissionManager.hasDow…Access(permissionService)");
        return eVarHasDownloadAccess;
    }

    public final void incrementAutoUpdateShow() {
        this.sharedPreferences.edit().putInt(this.AUTO_UPDATE_SHOW, this.sharedPreferences.getInt(this.AUTO_UPDATE_SHOW, 0) + 1).apply();
    }

    public final Single<Boolean> isDownloadComplete() {
        Single<Boolean> singleZ0 = loadAutoUpdateModel().A().L(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m63isDownloadComplete$lambda3(this.f4753f, (AutoUpdateModel) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m64isDownloadComplete$lambda4((RoomDownload) obj);
            }
        }).Z0();
        kotlin.jvm.internal.m.e(singleZ0, "loadAutoUpdateModel().to…TED }\n        .toSingle()");
        return singleZ0;
    }

    public final rx.e<Boolean> shouldShowAutoUpdateDialog() {
        int i2 = this.sharedPreferences.getInt(this.AUTO_UPDATE_SHOW, 0);
        rx.e<Boolean> eVarS = rx.e.S(Boolean.valueOf(i2 % 5 == 0 || i2 == 1));
        kotlin.jvm.internal.m.e(eVarS, "just(result % 5 == 0 || result == 1)");
        return eVarS;
    }

    public final rx.e<Boolean> shouldUpdate() {
        rx.e eVarX = loadAutoUpdateModel().A().X(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m66shouldUpdate$lambda0((AutoUpdateModel) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "loadAutoUpdateModel().to…).map { it.shouldUpdate }");
        return eVarX;
    }

    public final rx.e<Install> startUpdate(final boolean z) {
        rx.e eVarG = getAutoUpdateModel().G(new rx.m.e() { // from class: cm.aptoide.pt.autoupdate.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AutoUpdateManager.m67startUpdate$lambda2(this.f4750f, z, (AutoUpdateModel) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarG, "getAutoUpdateModel().fla…dThen(getInstall())\n    }");
        return eVarG;
    }

    private final boolean shouldUpdate(AutoUpdateModel autoUpdateModel) {
        return autoUpdateModel.getVersionCode() > this.localVersionCode && this.localVersionSdk >= Integer.parseInt(autoUpdateModel.getMinSdk());
    }
}
