package cm.aptoide.pt.install;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.app.CampaignAnalytics;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomStoredMinimalAd;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.root.RootAvailabilityManager;
import cm.aptoide.pt.updates.UpdateRepository;
import cm.aptoide.pt.util.ReferrerUtils;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.FileUtils;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class InstalledIntentService extends IntentService {
    private static final String TAG = InstalledIntentService.class.getName();
    private MinimalAdMapper adMapper;

    @Inject
    AppcMigrationManager appcMigrationManager;

    @Inject
    AptoideInstallManager aptoideInstallManager;

    @Inject
    CampaignAnalytics campaignAnalytics;

    @Inject
    FileUtils fileUtils;

    @Inject
    InstallAnalytics installAnalytics;
    private InstallManager installManager;
    private PackageManager packageManager;

    @Inject
    RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence;
    private RootAvailabilityManager rootAvailabilityManager;
    private SharedPreferences sharedPreferences;
    private rx.t.b subscriptions;

    @Inject
    UpdateRepository updatesRepository;

    public InstalledIntentService() {
        super("InstalledIntentService");
    }

    private void checkAndBroadcastReferrer(final String str) {
        this.subscriptions.a(this.roomStoredMinimalAdPersistence.get(str).j0(Schedulers.io()).H(new rx.m.e() { // from class: cm.aptoide.pt.install.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6530f.a(str, (RoomStoredMinimalAd) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.install.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                InstalledIntentService.lambda$checkAndBroadcastReferrer$3((RoomStoredMinimalAd) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.h2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }

    private boolean checkAndLogNullPackageInfo(PackageInfo packageInfo, String str) {
        if (packageInfo != null) {
            return false;
        }
        CrashReport.getInstance().log(new IllegalArgumentException("PackageName null for package " + str));
        return true;
    }

    private PackageInfo databaseOnPackageAdded(String str) {
        PackageInfo packageInfo = AptoideUtils.SystemU.getPackageInfo(str, getPackageManager());
        if (checkAndLogNullPackageInfo(packageInfo, str)) {
            return packageInfo;
        }
        this.installManager.onAppInstalled(new RoomInstalled(packageInfo, this.packageManager, this.fileUtils)).I(new rx.m.a() { // from class: cm.aptoide.pt.install.d2
            @Override // rx.m.a
            public final void call() {
                InstalledIntentService.lambda$databaseOnPackageAdded$0();
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.k2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        return packageInfo;
    }

    private void databaseOnPackageRemoved(final String str) {
        this.installManager.onAppRemoved(str).a(this.updatesRepository.remove(str)).I(new rx.m.a() { // from class: cm.aptoide.pt.install.f2
            @Override // rx.m.a
            public final void call() {
                Logger.getInstance().d(InstalledIntentService.TAG, "databaseOnPackageRemoved: " + str);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.i2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    private PackageInfo databaseOnPackageReplaced(final String str) {
        PackageInfo packageInfo = AptoideUtils.SystemU.getPackageInfo(str, getPackageManager());
        if (checkAndLogNullPackageInfo(packageInfo, str)) {
            return packageInfo;
        }
        this.installManager.onUpdateConfirmed(new RoomInstalled(packageInfo, this.packageManager, this.fileUtils)).a(this.updatesRepository.remove(str)).I(new rx.m.a() { // from class: cm.aptoide.pt.install.g2
            @Override // rx.m.a
            public final void call() {
                Logger.getInstance().d(InstalledIntentService.TAG, "databaseOnPackageReplaced: " + str);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.install.e2
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
        return packageInfo;
    }

    private rx.b knockCpi(final String str, final RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence, final RoomStoredMinimalAd roomStoredMinimalAd) {
        return rx.b.u(new Callable() { // from class: cm.aptoide.pt.install.m2
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.f6550f.b(str, roomStoredMinimalAd, roomStoredMinimalAdPersistence);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$checkAndBroadcastReferrer$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(String str, RoomStoredMinimalAd roomStoredMinimalAd) {
        if (roomStoredMinimalAd != null) {
            return knockCpi(str, this.roomStoredMinimalAdPersistence, roomStoredMinimalAd);
        }
        return null;
    }

    static /* synthetic */ void lambda$checkAndBroadcastReferrer$3(RoomStoredMinimalAd roomStoredMinimalAd) {
    }

    static /* synthetic */ void lambda$databaseOnPackageAdded$0() {
    }

    private /* synthetic */ Object lambda$knockCpi$9(String str, RoomStoredMinimalAd roomStoredMinimalAd, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) throws Exception {
        ReferrerUtils.broadcastReferrer(str, roomStoredMinimalAd.getReferrer(), getApplicationContext());
        AdNetworkUtils.knockCpi(this.adMapper.map(roomStoredMinimalAd));
        roomStoredMinimalAdPersistence.remove(roomStoredMinimalAd);
        return null;
    }

    private void reportPackageInfoNullEvent() {
        CrashReport.getInstance().log(new NullPointerException("PackageInfo is null."));
    }

    private void sendCampaignConversion(String str, PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.campaignAnalytics.convertCampaignEvent(str, packageInfo.versionCode);
        } else {
            reportPackageInfoNullEvent();
        }
    }

    private void sendInstallEvent(String str, PackageInfo packageInfo) {
        if (packageInfo != null) {
            this.installAnalytics.installCompleted(str, packageInfo.versionCode, this.rootAvailabilityManager.isRootAvailable().y().b().booleanValue(), ManagerPreferences.allowRootInstallation(this.sharedPreferences));
        } else {
            reportPackageInfoNullEvent();
        }
    }

    private void sendUninstallEvent(String str) {
        this.installAnalytics.uninstallCompleted(str);
    }

    public /* synthetic */ Object b(String str, RoomStoredMinimalAd roomStoredMinimalAd, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) throws Exception {
        lambda$knockCpi$9(str, roomStoredMinimalAd, roomStoredMinimalAdPersistence);
        return null;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        ((AptoideApplication) getApplicationContext()).getApplicationComponent().inject(this);
        this.adMapper = new MinimalAdMapper();
        this.sharedPreferences = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        this.subscriptions = new rx.t.b();
        this.installManager = ((AptoideApplication) getApplicationContext()).getInstallManager();
        this.rootAvailabilityManager = ((AptoideApplication) getApplicationContext()).getRootAvailabilityManager();
        this.packageManager = getPackageManager();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
            if (TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") || !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                action.hashCode();
                switch (action) {
                    case "android.intent.action.PACKAGE_REPLACED":
                        onPackageReplaced(encodedSchemeSpecificPart);
                        break;
                    case "android.intent.action.PACKAGE_REMOVED":
                        onPackageRemoved(encodedSchemeSpecificPart);
                        break;
                    case "android.intent.action.PACKAGE_ADDED":
                        onPackageAdded(encodedSchemeSpecificPart);
                        break;
                }
            }
        }
    }

    protected void onPackageAdded(String str) {
        Logger.getInstance().d(TAG, "Package added: " + str);
        PackageInfo packageInfoDatabaseOnPackageAdded = databaseOnPackageAdded(str);
        checkAndBroadcastReferrer(str);
        sendInstallEvent(str, packageInfoDatabaseOnPackageAdded);
        sendCampaignConversion(str, packageInfoDatabaseOnPackageAdded);
        this.appcMigrationManager.persistCandidate(str);
        this.aptoideInstallManager.persistCandidate(str);
    }

    protected void onPackageRemoved(String str) {
        Logger.getInstance().d(TAG, "Packaged removed: " + str);
        sendUninstallEvent(str);
        databaseOnPackageRemoved(str);
    }

    protected void onPackageReplaced(String str) {
        Logger.getInstance().d(TAG, "Packaged replaced: " + str);
        PackageInfo packageInfoDatabaseOnPackageReplaced = databaseOnPackageReplaced(str);
        sendInstallEvent(str, packageInfoDatabaseOnPackageReplaced);
        sendCampaignConversion(str, packageInfoDatabaseOnPackageReplaced);
        this.aptoideInstallManager.persistCandidate(str);
    }
}
