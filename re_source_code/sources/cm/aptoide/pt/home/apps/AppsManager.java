package cm.aptoide.pt.home.apps;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsModel;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.aptoideinstall.AptoideInstallManager;
import cm.aptoide.pt.app.mmpcampaigns.Campaign;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignUrl;
import cm.aptoide.pt.database.room.RoomCampaignUrl;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.InstallType;
import cm.aptoide.pt.download.Origin;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.home.apps.model.DownloadApp;
import cm.aptoide.pt.home.apps.model.InstalledApp;
import cm.aptoide.pt.home.apps.model.StateApp;
import cm.aptoide.pt.home.apps.model.UpdateApp;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.notification.UpdatesNotificationManager;
import cm.aptoide.pt.preferences.secure.SecurePreferences;
import cm.aptoide.pt.updates.UpdatesAnalytics;
import cm.aptoide.pt.utils.AptoideUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppsManager {
    private final AppMapper appMapper;
    private final AptoideInstallManager aptoideInstallManager;
    private final CampaignManager campaignManager;
    private final Context context;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadFactory downloadFactory;
    private final DynamicSplitsManager dynamicSplitsManager;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final MoPubAdsManager moPubAdsManager;
    private final PackageManager packageManager;
    private final SharedPreferences secureSharedPreferences;
    private final SplitAnalyticsMapper splitAnalyticsMapper;
    private final UpdatesAnalytics updatesAnalytics;
    private final UpdatesManager updatesManager;
    private final UpdatesNotificationManager updatesNotificationManager;

    public AppsManager(UpdatesManager updatesManager, InstallManager installManager, AppMapper appMapper, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, UpdatesAnalytics updatesAnalytics, PackageManager packageManager, Context context, DownloadFactory downloadFactory, MoPubAdsManager moPubAdsManager, AptoideInstallManager aptoideInstallManager, UpdatesNotificationManager updatesNotificationManager, SharedPreferences sharedPreferences, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        this.updatesManager = updatesManager;
        this.installManager = installManager;
        this.appMapper = appMapper;
        this.downloadAnalytics = downloadAnalytics;
        this.installAnalytics = installAnalytics;
        this.updatesAnalytics = updatesAnalytics;
        this.packageManager = packageManager;
        this.context = context;
        this.downloadFactory = downloadFactory;
        this.moPubAdsManager = moPubAdsManager;
        this.aptoideInstallManager = aptoideInstallManager;
        this.updatesNotificationManager = updatesNotificationManager;
        this.secureSharedPreferences = sharedPreferences;
        this.dynamicSplitsManager = dynamicSplitsManager;
        this.splitAnalyticsMapper = splitAnalyticsMapper;
        this.campaignManager = campaignManager;
    }

    private rx.e<List<UpdateApp>> getAllUpdatesList() {
        return this.updatesManager.getUpdatesList().t().G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5750f.d((List) obj);
            }
        });
    }

    private Origin getOrigin(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? Origin.INSTALL : Origin.DOWNGRADE;
        }
        return Origin.UPDATE;
    }

    private rx.e<List<UpdateApp>> getUpdateDownloadsList() {
        return this.installManager.getInstallations().t().R0(200L, TimeUnit.MILLISECONDS).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5800f.h((List) obj);
            }
        });
    }

    private void handleNotEnoughSpaceError(String str) {
        this.downloadAnalytics.sendNotEnoughSpaceError(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAllUpdatesList$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ UpdateApp b(RoomUpdate roomUpdate, Boolean bool) {
        return this.appMapper.mapUpdateToUpdateApp(roomUpdate, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAllUpdatesList$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(final RoomUpdate roomUpdate) {
        return this.aptoideInstallManager.isInstalledWithAptoide(roomUpdate.getPackageName()).n(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5782f.b(roomUpdate, (Boolean) obj);
            }
        });
    }

    static /* synthetic */ Integer lambda$getAllUpdatesList$2(UpdateApp updateApp, UpdateApp updateApp2) {
        if (!updateApp.isInstalledWithAptoide() || updateApp2.isInstalledWithAptoide()) {
            return (updateApp.isInstalledWithAptoide() || !updateApp2.isInstalledWithAptoide()) ? 0 : 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAllUpdatesList$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(List list) {
        return rx.e.N(list).M(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5723f.c((RoomUpdate) obj);
            }
        }, false, 1).a1(new rx.m.f() { // from class: cm.aptoide.pt.home.apps.j0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return AppsManager.lambda$getAllUpdatesList$2((UpdateApp) obj, (UpdateApp) obj2);
            }
        });
    }

    static /* synthetic */ Iterable lambda$getDownloadApps$11(List list) {
        return list;
    }

    static /* synthetic */ Boolean lambda$getDownloadApps$12(Install install) {
        Install.InstallationType type = install.getType();
        Install.InstallationType installationType = Install.InstallationType.UPDATE;
        return Boolean.valueOf(type != installationType || (install.getType() == installationType && install.getState() == Install.InstallationStatus.UNINSTALLED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getDownloadApps$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(List list) {
        if (list == null || list.isEmpty()) {
            return rx.e.S(Collections.emptyList());
        }
        rx.e eVarD = rx.e.S(list).J(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list2 = (List) obj;
                AppsManager.lambda$getDownloadApps$11(list2);
                return list2;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AppsManager.lambda$getDownloadApps$12((Install) obj);
            }
        });
        final InstallManager installManager = this.installManager;
        installManager.getClass();
        rx.e eVarX = eVarD.L(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.x3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return installManager.filterInstalled((Install) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.s0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Install) obj) != null);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.m0
            @Override // rx.m.b
            public final void call(Object obj) {
                Install install = (Install) obj;
                Logger.getInstance().d("Apps", "filtered installed - is not installed -> " + install.getPackageName() + " " + install.getMd5() + " " + install.getVersionName());
            }
        }).Y0().x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.r
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().d("Apps", "emit list of installs from getDownloadApps - after toList");
            }
        });
        final AppMapper appMapper = this.appMapper;
        appMapper.getClass();
        return eVarX.X(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.q3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return appMapper.getDownloadApps((List) obj);
            }
        });
    }

    static /* synthetic */ Iterable lambda$getInstalledApps$9(List list) {
        return list;
    }

    static /* synthetic */ Iterable lambda$getUpdateDownloadsList$4(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getUpdateDownloadsList$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ UpdateApp f(Install install, Boolean bool) {
        return this.appMapper.mapInstallToUpdateApp(install, bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getUpdateDownloadsList$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single g(final Install install) {
        return this.aptoideInstallManager.isInstalledWithAptoide(install.getPackageName()).n(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5795f.f(install, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getUpdateDownloadsList$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(List list) {
        return (list == null || list.isEmpty()) ? rx.e.S(new ArrayList()) : rx.e.S(list).J(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list2 = (List) obj;
                AppsManager.lambda$getUpdateDownloadsList$4(list2);
                return list2;
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Install) obj).getType() == Install.InstallationType.UPDATE);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5734f.g((Install) obj);
            }
        }).Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleDownloadAbort$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(String str, RoomUpdate roomUpdate) {
        this.downloadAnalytics.sendDownloadAbortEvent(str, roomUpdate.getUpdateVersionCode(), InstallType.UPDATE, false, roomUpdate.hasSplits(), roomUpdate.hasAppc(), roomUpdate.getTrustedBadge(), roomUpdate.getStoreName(), false, (roomUpdate.getMainObbMd5() == null || roomUpdate.getMainObbMd5().isEmpty()) ? false : true, roomUpdate.getStoreName().equals("catappult"), HttpUrl.FRAGMENT_ENCODE_SET, roomUpdate.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$installApp$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b j(App app, Install install) {
        if (install.getState() != Install.InstallationStatus.INSTALLED) {
            return resumeDownload(app, install.getType().toString());
        }
        AptoideUtils.SystemU.openApp(((DownloadApp) app).getPackageName(), this.packageManager, this.context);
        return rx.b.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeOutOfSpaceApps$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(List list) {
        handleNotEnoughSpaceError((String) list.get(list.size() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAll$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(List list) {
        this.updatesAnalytics.sendUpdateAllClickEvent();
    }

    static /* synthetic */ Iterable lambda$updateAll$25(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAll$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(RoomUpdate roomUpdate, RoomDownload roomDownload) {
        this.updatesAnalytics.sendUpdateClickedEvent(roomUpdate.getPackageName(), roomUpdate.hasSplits(), roomUpdate.hasAppc(), false, roomUpdate.getTrustedBadge(), null, roomUpdate.getStoreName(), "update_all", (roomUpdate.getMainObbMd5() == null || roomUpdate.getMainObbMd5().isEmpty()) ? false : true, roomUpdate.getSize());
        setupUpdateEvents(roomDownload, Origin.UPDATE_ALL, null, roomUpdate.getTrustedBadge(), roomUpdate.getStoreName(), "update_all");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAll$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(final RoomUpdate roomUpdate, DynamicSplitsModel dynamicSplitsModel) {
        return rx.e.S(this.downloadFactory.create(roomUpdate, false, dynamicSplitsModel.getDynamicSplitsList())).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.n0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5771f.n(roomUpdate, (RoomDownload) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAll$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e p(final RoomUpdate roomUpdate) {
        return g.a.a.a.d.d(this.dynamicSplitsManager.getAppSplitsByMd5(roomUpdate.getMd5())).k(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5784f.o(roomUpdate, (DynamicSplitsModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateApp$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single q(RoomUpdate roomUpdate) {
        return g.a.a.a.d.a(this.campaignManager.convertCampaign(recreateCampaign(roomUpdate), "Apps")).c(Single.m(roomUpdate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateApp$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single r(RoomUpdate roomUpdate, String str, DynamicSplitsModel dynamicSplitsModel) {
        RoomDownload roomDownloadCreate = this.downloadFactory.create(roomUpdate, false, dynamicSplitsModel.getDynamicSplitsList());
        this.updatesAnalytics.sendUpdateClickedEvent(str, roomUpdate.hasSplits(), roomUpdate.hasAppc(), false, roomUpdate.getTrustedBadge(), null, roomUpdate.getStoreName(), "update", (roomUpdate.getMainObbMd5() == null || roomUpdate.getMainObbMd5().isEmpty()) ? false : true, roomUpdate.getSize());
        setupUpdateEvents(roomDownloadCreate, Origin.UPDATE, roomUpdate.getTrustedBadge(), null, roomUpdate.getStoreName(), "update");
        return Single.m(roomDownloadCreate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateApp$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single s(final String str, final RoomUpdate roomUpdate) {
        return g.a.a.a.d.d(this.dynamicSplitsManager.getAppSplitsByMd5(roomUpdate.getMd5())).i(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5763f.r(roomUpdate, str, (DynamicSplitsModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateApp$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b t(RoomDownload roomDownload) {
        return this.installManager.x(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateFirstLoadUpdatesSettings$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        SecurePreferences.setUpdatesFirstLoad(false, this.secureSharedPreferences);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<UpdateApp> mergeUpdates(List<UpdateApp> list, List<UpdateApp> list2) {
        ArrayList arrayList = new ArrayList(list);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            UpdateApp updateApp = list.get(i2);
            for (UpdateApp updateApp2 : list2) {
                if (updateApp.getMd5().equals(updateApp2.getMd5())) {
                    arrayList.set(i2, updateApp2);
                    break;
                }
            }
        }
        return arrayList;
    }

    private rx.e<List<UpdateApp>> observeAllUpdates() {
        return rx.e.e(getAllUpdatesList(), getUpdateDownloadsList(), new rx.m.f() { // from class: cm.aptoide.pt.home.apps.e0
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return this.f5712f.mergeUpdates((List) obj, (List) obj2);
            }
        });
    }

    private Campaign recreateCampaign(RoomUpdate roomUpdate) {
        ArrayList arrayList = new ArrayList();
        for (RoomCampaignUrl roomCampaignUrl : roomUpdate.getDownloadCampaigns()) {
            arrayList.add(new CampaignUrl(roomCampaignUrl.getName(), roomCampaignUrl.getUrl()));
        }
        return new Campaign(Collections.emptyList(), Collections.emptyList(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setupDownloadEvents, reason: merged with bridge method [inline-methods] */
    public void l(RoomDownload roomDownload, String str) {
        DownloadAnalytics downloadAnalytics = this.downloadAnalytics;
        String md5 = roomDownload.getMd5();
        String packageName = roomDownload.getPackageName();
        int versionCode = roomDownload.getVersionCode();
        AnalyticsManager.Action action = AnalyticsManager.Action.INSTALL;
        downloadAnalytics.installClicked(md5, packageName, versionCode, action, false, roomDownload.hasAppc(), roomDownload.hasSplits(), roomDownload.getTrustedBadge(), (String) null, roomDownload.getStoreName(), str, roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), roomDownload.getStoreName().equals("catappult"), HttpUrl.FRAGMENT_ENCODE_SET, roomDownload.getSize());
        this.installAnalytics.installStarted(roomDownload.getPackageName(), roomDownload.getVersionCode(), action, DownloadAnalytics.AppContext.APPS_FRAGMENT, getOrigin(roomDownload.getAction()), false, roomDownload.hasAppc(), roomDownload.hasSplits(), roomDownload.getTrustedBadge(), roomDownload.getStoreName(), roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), roomDownload.getStoreName().equals("catappult"), HttpUrl.FRAGMENT_ENCODE_SET, roomDownload.getSize());
    }

    private void setupUpdateEvents(RoomDownload roomDownload, Origin origin, String str, String str2, String str3, String str4) {
        DownloadAnalytics downloadAnalytics = this.downloadAnalytics;
        String md5 = roomDownload.getMd5();
        String packageName = roomDownload.getPackageName();
        int versionCode = roomDownload.getVersionCode();
        AnalyticsManager.Action action = AnalyticsManager.Action.INSTALL;
        downloadAnalytics.installClicked(md5, packageName, versionCode, action, false, roomDownload.hasAppc(), roomDownload.hasSplits(), str, str2, str3, str4, roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), roomDownload.getStoreName().equals("catappult"), HttpUrl.FRAGMENT_ENCODE_SET, roomDownload.getSize());
        this.installAnalytics.installStarted(roomDownload.getPackageName(), roomDownload.getVersionCode(), action, DownloadAnalytics.AppContext.APPS_FRAGMENT, origin, false, roomDownload.hasAppc(), roomDownload.hasSplits(), roomDownload.getTrustedBadge(), roomDownload.getStoreName(), roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), roomDownload.getStoreName().equals("catappult"), HttpUrl.FRAGMENT_ENCODE_SET, roomDownload.getSize());
    }

    private rx.b startUpdatesNotification() {
        return this.updatesNotificationManager.setUpNotification();
    }

    private rx.b updateFirstLoadUpdatesSettings() {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.home.apps.o0
            @Override // rx.m.a
            public final void call() {
                this.f5778f.u();
            }
        });
    }

    public rx.b cancelDownload(App app) {
        StateApp stateApp = (StateApp) app;
        return this.installManager.cancelInstall(stateApp.getMd5(), stateApp.getPackageName(), stateApp.getVersionCode());
    }

    public rx.b excludeUpdate(App app) {
        return this.updatesManager.excludeUpdate(((UpdateApp) app).getPackageName());
    }

    public rx.e<List<DownloadApp>> getDownloadApps() {
        return this.installManager.getInstallations().R0(200L, TimeUnit.MILLISECONDS).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5830f.e((List) obj);
            }
        });
    }

    public rx.e<List<InstalledApp>> getInstalledApps() {
        rx.e<R> eVarJ = this.installManager.fetchInstalled().t().J(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                AppsManager.lambda$getInstalledApps$9(list);
                return list;
            }
        });
        final UpdatesManager updatesManager = this.updatesManager;
        updatesManager.getClass();
        rx.e eVarY0 = eVarJ.L(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.z3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return updatesManager.filterUpdates((RoomInstalled) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((RoomInstalled) obj) != null);
            }
        }).Y0();
        final AppMapper appMapper = this.appMapper;
        appMapper.getClass();
        return eVarY0.X(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return appMapper.mapInstalledToInstalledApps((List) obj);
            }
        });
    }

    public rx.e<List<UpdateApp>> getUpdatesList() {
        return SecurePreferences.isUpdatesFirstLoad(this.secureSharedPreferences) ? this.updatesManager.refreshUpdates().G(updateFirstLoadUpdatesSettings()).a(startUpdatesNotification()).b(observeAllUpdates()) : observeAllUpdates();
    }

    public rx.b handleDownloadAbort(final String str) {
        return this.updatesManager.getUpdate(str).g(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5717f.i(str, (RoomUpdate) obj);
            }
        }).z().A();
    }

    public rx.b installApp(final App app) {
        DownloadApp downloadApp = (DownloadApp) app;
        return this.installManager.getInstall(downloadApp.getMd5(), downloadApp.getPackageName(), downloadApp.getVersionCode()).E().H(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5809f.j(app, (Install) obj);
            }
        }).X0();
    }

    public rx.e<List<String>> observeOutOfSpaceApps() {
        return this.installManager.getDownloadOutOfSpaceMd5List().t().x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5690f.k((List) obj);
            }
        });
    }

    public rx.b pauseDownload(App app) {
        return this.installManager.pauseInstall(((StateApp) app).getMd5());
    }

    public rx.b refreshAllUpdates() {
        return this.updatesManager.refreshUpdates();
    }

    public rx.b resumeDownload(App app, final String str) {
        Single<RoomDownload> singleG = this.installManager.getDownload(((StateApp) app).getMd5()).g(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.o
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5776f.l(str, (RoomDownload) obj);
            }
        });
        final InstallManager installManager = this.installManager;
        installManager.getClass();
        return singleG.j(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return installManager.x((RoomDownload) obj);
            }
        });
    }

    public void setAppViewAnalyticsEvent() {
        this.updatesAnalytics.updates(UpdatesAnalytics.OPEN_APP_VIEW);
    }

    public boolean showWarning() {
        return this.installManager.showWarning();
    }

    public void storeRootAnswer(boolean z) {
        this.installManager.rootInstallAllowed(z);
    }

    public rx.b updateAll() {
        rx.e eVarY0 = this.updatesManager.getUpdatesList().E().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((List) obj).isEmpty());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.home.apps.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5745f.m((List) obj);
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                AppsManager.lambda$updateAll$25(list);
                return list;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5789f.p((RoomUpdate) obj);
            }
        }).Y0();
        final InstallManager installManager = this.installManager;
        installManager.getClass();
        return eVarY0.G(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.r3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return installManager.startInstalls((List) obj);
            }
        }).X0();
    }

    public rx.b updateApp(App app) {
        final String packageName = ((UpdateApp) app).getPackageName();
        return this.updatesManager.getUpdate(packageName).i(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5790f.q((RoomUpdate) obj);
            }
        }).i(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5728f.s(packageName, (RoomUpdate) obj);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5770f.t((RoomDownload) obj);
            }
        }).A();
    }
}
