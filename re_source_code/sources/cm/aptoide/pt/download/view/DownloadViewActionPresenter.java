package cm.aptoide.pt.download.view;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.aab.DynamicSplit;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsModel;
import cm.aptoide.pt.actions.PermissionManager;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.database.room.RoomFileToDownload;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.InstallType;
import cm.aptoide.pt.download.InvalidAppException;
import cm.aptoide.pt.download.Origin;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.download.view.outofspace.OutOfSpaceNavigatorWrapper;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.presenter.ActionPresenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: DownloadViewActionPresenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J$\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\u0010\u00106\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u00101\u001a\u000202H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0010\u0010=\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\u000e\u0010B\u001a\u00020;2\u0006\u0010:\u001a\u00020AJ\u0010\u0010C\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J\b\u0010D\u001a\u00020EH\u0014J\u0010\u0010F\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0002H\u0002J \u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(J8\u0010J\u001a\u00020E2\u0006\u00101\u001a\u0002002\u0006\u0010K\u001a\u00020L2\u0006\u0010@\u001a\u00020A2\b\u0010M\u001a\u0004\u0018\u00010(2\u0006\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020(R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcm/aptoide/pt/download/view/DownloadViewActionPresenter;", "Lcm/aptoide/pt/presenter/ActionPresenter;", "Lcm/aptoide/pt/download/view/DownloadClick;", "installManager", "Lcm/aptoide/pt/install/InstallManager;", "moPubAdsManager", "Lcm/aptoide/pt/ads/MoPubAdsManager;", "permissionManager", "Lcm/aptoide/pt/actions/PermissionManager;", "appcMigrationManager", "Lcm/aptoide/pt/app/migration/AppcMigrationManager;", "downloadDialogProvider", "Lcm/aptoide/pt/download/view/DownloadDialogProvider;", "downloadNavigator", "Lcm/aptoide/pt/download/view/DownloadNavigator;", "permissionService", "Lcm/aptoide/pt/actions/PermissionService;", "ioScheduler", "Lrx/Scheduler;", "viewScheduler", "downloadFactory", "Lcm/aptoide/pt/download/DownloadFactory;", "downloadAnalytics", "Lcm/aptoide/pt/download/DownloadAnalytics;", "installAnalytics", "Lcm/aptoide/pt/install/InstallAnalytics;", "notificationAnalytics", "Lcm/aptoide/pt/notification/NotificationAnalytics;", "crashReport", "Lcm/aptoide/pt/crashreports/CrashReport;", "dynamicSplitsManager", "Lcm/aptoide/pt/aab/DynamicSplitsManager;", "splitAnalyticsMapper", "Lcm/aptoide/pt/download/SplitAnalyticsMapper;", "campaignManager", "Lcm/aptoide/pt/app/mmpcampaigns/CampaignManager;", "(Lcm/aptoide/pt/install/InstallManager;Lcm/aptoide/pt/ads/MoPubAdsManager;Lcm/aptoide/pt/actions/PermissionManager;Lcm/aptoide/pt/app/migration/AppcMigrationManager;Lcm/aptoide/pt/download/view/DownloadDialogProvider;Lcm/aptoide/pt/download/view/DownloadNavigator;Lcm/aptoide/pt/actions/PermissionService;Lrx/Scheduler;Lrx/Scheduler;Lcm/aptoide/pt/download/DownloadFactory;Lcm/aptoide/pt/download/DownloadAnalytics;Lcm/aptoide/pt/install/InstallAnalytics;Lcm/aptoide/pt/notification/NotificationAnalytics;Lcm/aptoide/pt/crashreports/CrashReport;Lcm/aptoide/pt/aab/DynamicSplitsManager;Lcm/aptoide/pt/download/SplitAnalyticsMapper;Lcm/aptoide/pt/app/mmpcampaigns/CampaignManager;)V", "analyticsContext", "Lcm/aptoide/pt/download/DownloadAnalytics$AppContext;", "editorsChoicePosition", HttpUrl.FRAGMENT_ENCODE_SET, "isInApkfyContext", HttpUrl.FRAGMENT_ENCODE_SET, "cancelDownload", "Lrx/Completable;", "downloadClick", "createDownload", "Lrx/Observable;", "Lcm/aptoide/pt/database/room/RoomDownload;", DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, "Lcm/aptoide/pt/download/view/Download;", "dynamicSplitsList", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/aab/DynamicSplit;", "downgradeApp", "downloadApp", "getOrigin", "Lcm/aptoide/pt/download/Origin;", "action", HttpUrl.FRAGMENT_ENCODE_SET, "handleOutOfSpaceError", "installApp", "mapDownloadAction", "Lcm/aptoide/pt/download/InstallType;", "downloadAction", "Lcm/aptoide/pt/download/view/DownloadStatusModel$Action;", "parseDownloadAction", "pauseDownload", "present", HttpUrl.FRAGMENT_ENCODE_SET, "resumeDownload", "setContextParams", "context", "isApkfy", "setupDownloadEvents", "appId", HttpUrl.FRAGMENT_ENCODE_SET, "storeName", "malwareRank", "appCategory", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DownloadViewActionPresenter extends ActionPresenter<DownloadClick> {
    private DownloadAnalytics.AppContext analyticsContext;
    private final AppcMigrationManager appcMigrationManager;
    private final CampaignManager campaignManager;
    private final CrashReport crashReport;
    private final DownloadAnalytics downloadAnalytics;
    private final DownloadDialogProvider downloadDialogProvider;
    private final DownloadFactory downloadFactory;
    private final DownloadNavigator downloadNavigator;
    private final DynamicSplitsManager dynamicSplitsManager;
    private String editorsChoicePosition;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final rx.h ioScheduler;
    private boolean isInApkfyContext;
    private final MoPubAdsManager moPubAdsManager;
    private final NotificationAnalytics notificationAnalytics;
    private final PermissionManager permissionManager;
    private final PermissionService permissionService;
    private final SplitAnalyticsMapper splitAnalyticsMapper;
    private final rx.h viewScheduler;

    /* JADX INFO: compiled from: DownloadViewActionPresenter.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DownloadEvent.values().length];
            iArr[DownloadEvent.INSTALL.ordinal()] = 1;
            iArr[DownloadEvent.RESUME.ordinal()] = 2;
            iArr[DownloadEvent.PAUSE.ordinal()] = 3;
            iArr[DownloadEvent.CANCEL.ordinal()] = 4;
            iArr[DownloadEvent.GENERIC_ERROR.ordinal()] = 5;
            iArr[DownloadEvent.OUT_OF_SPACE_ERROR.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DownloadStatusModel.Action.values().length];
            iArr2[DownloadStatusModel.Action.MIGRATE.ordinal()] = 1;
            iArr2[DownloadStatusModel.Action.UPDATE.ordinal()] = 2;
            iArr2[DownloadStatusModel.Action.INSTALL.ordinal()] = 3;
            iArr2[DownloadStatusModel.Action.DOWNGRADE.ordinal()] = 4;
            iArr2[DownloadStatusModel.Action.OPEN.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DownloadViewActionPresenter(InstallManager installManager, MoPubAdsManager moPubAdsManager, PermissionManager permissionManager, AppcMigrationManager appcMigrationManager, DownloadDialogProvider downloadDialogProvider, DownloadNavigator downloadNavigator, PermissionService permissionService, rx.h hVar, rx.h hVar2, DownloadFactory downloadFactory, DownloadAnalytics downloadAnalytics, InstallAnalytics installAnalytics, NotificationAnalytics notificationAnalytics, CrashReport crashReport, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        kotlin.jvm.internal.m.f(installManager, "installManager");
        kotlin.jvm.internal.m.f(moPubAdsManager, "moPubAdsManager");
        kotlin.jvm.internal.m.f(permissionManager, "permissionManager");
        kotlin.jvm.internal.m.f(appcMigrationManager, "appcMigrationManager");
        kotlin.jvm.internal.m.f(downloadDialogProvider, "downloadDialogProvider");
        kotlin.jvm.internal.m.f(downloadNavigator, "downloadNavigator");
        kotlin.jvm.internal.m.f(permissionService, "permissionService");
        kotlin.jvm.internal.m.f(hVar, "ioScheduler");
        kotlin.jvm.internal.m.f(hVar2, "viewScheduler");
        kotlin.jvm.internal.m.f(downloadFactory, "downloadFactory");
        kotlin.jvm.internal.m.f(downloadAnalytics, "downloadAnalytics");
        kotlin.jvm.internal.m.f(installAnalytics, "installAnalytics");
        kotlin.jvm.internal.m.f(notificationAnalytics, "notificationAnalytics");
        kotlin.jvm.internal.m.f(crashReport, "crashReport");
        kotlin.jvm.internal.m.f(dynamicSplitsManager, "dynamicSplitsManager");
        kotlin.jvm.internal.m.f(splitAnalyticsMapper, "splitAnalyticsMapper");
        kotlin.jvm.internal.m.f(campaignManager, "campaignManager");
        this.installManager = installManager;
        this.moPubAdsManager = moPubAdsManager;
        this.permissionManager = permissionManager;
        this.appcMigrationManager = appcMigrationManager;
        this.downloadDialogProvider = downloadDialogProvider;
        this.downloadNavigator = downloadNavigator;
        this.permissionService = permissionService;
        this.ioScheduler = hVar;
        this.viewScheduler = hVar2;
        this.downloadFactory = downloadFactory;
        this.downloadAnalytics = downloadAnalytics;
        this.installAnalytics = installAnalytics;
        this.notificationAnalytics = notificationAnalytics;
        this.crashReport = crashReport;
        this.dynamicSplitsManager = dynamicSplitsManager;
        this.splitAnalyticsMapper = splitAnalyticsMapper;
        this.campaignManager = campaignManager;
    }

    private final rx.b cancelDownload(final DownloadClick downloadClick) {
        rx.b bVarA = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.view.t
            @Override // rx.m.a
            public final void call() {
                DownloadViewActionPresenter.m81cancelDownload$lambda28(this.f5170f, downloadClick);
            }
        }).a(this.installManager.cancelInstall(downloadClick.getDownload().getMd5(), downloadClick.getDownload().getPackageName(), downloadClick.getDownload().getVersionCode()));
        kotlin.jvm.internal.m.e(bVarA, "fromAction {\n      downl…versionCode\n      )\n    )");
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: cancelDownload$lambda-28, reason: not valid java name */
    public static final void m81cancelDownload$lambda28(DownloadViewActionPresenter downloadViewActionPresenter, DownloadClick downloadClick) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(downloadClick, "$downloadClick");
        downloadViewActionPresenter.downloadAnalytics.downloadInteractEvent(downloadClick.getDownload().getPackageName(), "cancel");
    }

    private final rx.e<RoomDownload> createDownload(final Download download, final List<DynamicSplit> list) {
        rx.e<RoomDownload> eVarW = rx.e.S(list).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m82createDownload$lambda22(this.f5102f, download, list, (List) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.download.view.v
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m83createDownload$lambda23(this.f5173f, download, list, (Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarW, "just(dynamicSplitsList)\n…      )\n        }\n      }");
        return eVarW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createDownload$lambda-22, reason: not valid java name */
    public static final rx.e m82createDownload$lambda22(DownloadViewActionPresenter downloadViewActionPresenter, Download download, List list, List list2) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        kotlin.jvm.internal.m.f(list, "$dynamicSplitsList");
        DownloadFactory downloadFactory = downloadViewActionPresenter.downloadFactory;
        DownloadStatusModel downloadModel = download.getDownloadModel();
        kotlin.jvm.internal.m.c(downloadModel);
        return rx.e.S(downloadFactory.create(downloadViewActionPresenter.parseDownloadAction(downloadModel.getAction()), download.getAppName(), download.getPackageName(), download.getMd5(), download.getIcon(), download.getVersionName(), download.getVersionCode(), download.getPath(), download.getPathAlt(), download.getObb(), download.getHasAdvertising() || download.getHasBilling(), download.getSize(), download.getSplits(), download.getRequiredSplits(), download.getMalware().getRank().toString(), download.getStoreName(), download.getOemId(), list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createDownload$lambda-23, reason: not valid java name */
    public static final void m83createDownload$lambda23(DownloadViewActionPresenter downloadViewActionPresenter, Download download, List list, Throwable th) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        kotlin.jvm.internal.m.f(list, "$dynamicSplitsList");
        if (th instanceof InvalidAppException) {
            DownloadAnalytics downloadAnalytics = downloadViewActionPresenter.downloadAnalytics;
            String packageName = download.getPackageName();
            int versionCode = download.getVersionCode();
            DownloadStatusModel downloadModel = download.getDownloadModel();
            kotlin.jvm.internal.m.c(downloadModel);
            downloadAnalytics.sendAppNotValidError(packageName, versionCode, downloadViewActionPresenter.mapDownloadAction(downloadModel.getAction()), download.getDownloadModel().getAction() == DownloadStatusModel.Action.MIGRATE, !download.getSplits().isEmpty(), download.getHasAdvertising() || download.getHasBilling(), download.getMalware().getRank().toString(), download.getStoreName(), downloadViewActionPresenter.isInApkfyContext, th, download.getObb() != null, downloadViewActionPresenter.splitAnalyticsMapper.getSplitTypesAsString(!download.getSplits().isEmpty(), list), kotlin.jvm.internal.m.a(download.getStoreName(), "catappult"), download.getAppCategory(), download.getSize());
        }
    }

    private final rx.b downgradeApp(final Download download) {
        rx.b bVarX0 = this.downloadDialogProvider.showDowngradeDialog().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m86downgradeApp$lambda9((Boolean) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m84downgradeApp$lambda10(this.f5099f, (Boolean) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.download.view.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m85downgradeApp$lambda11(this.f5126f, download, (Boolean) obj);
            }
        }).X0();
        kotlin.jvm.internal.m.e(bVarX0, "downloadDialogProvider.s… }\n      .toCompletable()");
        return bVarX0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downgradeApp$lambda-10, reason: not valid java name */
    public static final void m84downgradeApp$lambda10(DownloadViewActionPresenter downloadViewActionPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        downloadViewActionPresenter.downloadDialogProvider.showDowngradingSnackBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downgradeApp$lambda-11, reason: not valid java name */
    public static final rx.b m85downgradeApp$lambda11(DownloadViewActionPresenter downloadViewActionPresenter, Download download, Boolean bool) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        return downloadViewActionPresenter.downloadApp(download);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downgradeApp$lambda-9, reason: not valid java name */
    public static final Boolean m86downgradeApp$lambda9(Boolean bool) {
        return bool;
    }

    private final rx.b downloadApp(final Download download) {
        rx.b bVarX0 = rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.download.view.b0
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return DownloadViewActionPresenter.m87downloadApp$lambda14(this.f5092f, download);
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m90downloadApp$lambda21(this.f5179f, download, (Download) obj);
            }
        }).X0();
        kotlin.jvm.internal.m.e(bVarX0, "defer {\n      if (instal… }\n      .toCompletable()");
        return bVarX0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-14, reason: not valid java name */
    public static final rx.e m87downloadApp$lambda14(final DownloadViewActionPresenter downloadViewActionPresenter, final Download download) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        return downloadViewActionPresenter.installManager.showWarning() ? downloadViewActionPresenter.downloadDialogProvider.showRootInstallWarningPopup().x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.p
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m88downloadApp$lambda14$lambda12(this.f5165f, (Boolean) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.download.view.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m89downloadApp$lambda14$lambda13(download, (Boolean) obj);
            }
        }) : rx.e.S(download);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-14$lambda-12, reason: not valid java name */
    public static final void m88downloadApp$lambda14$lambda12(DownloadViewActionPresenter downloadViewActionPresenter, Boolean bool) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        InstallManager installManager = downloadViewActionPresenter.installManager;
        kotlin.jvm.internal.m.e(bool, "answer");
        installManager.rootInstallAllowed(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-14$lambda-13, reason: not valid java name */
    public static final Download m89downloadApp$lambda14$lambda13(Download download, Boolean bool) {
        kotlin.jvm.internal.m.f(download, "$download");
        return download;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21, reason: not valid java name */
    public static final rx.e m90downloadApp$lambda21(final DownloadViewActionPresenter downloadViewActionPresenter, final Download download, Download download2) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        return downloadViewActionPresenter.permissionManager.requestDownloadAccessWithWifiBypass(downloadViewActionPresenter.permissionService, download.getSize()).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m91downloadApp$lambda21$lambda16(this.f5110f, download, (Void) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.download.view.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m93downloadApp$lambda21$lambda17(this.f5115f, download, (Void) obj);
            }
        }).j0(downloadViewActionPresenter.ioScheduler).H(new rx.m.e() { // from class: cm.aptoide.pt.download.view.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m94downloadApp$lambda21$lambda20(this.f5168f, download, (DynamicSplitsModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21$lambda-16, reason: not valid java name */
    public static final rx.e m91downloadApp$lambda21$lambda16(final DownloadViewActionPresenter downloadViewActionPresenter, final Download download, Void r3) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        return downloadViewActionPresenter.permissionManager.requestExternalStoragePermission(downloadViewActionPresenter.permissionService).w(new rx.m.b() { // from class: cm.aptoide.pt.download.view.m
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m92downloadApp$lambda21$lambda16$lambda15(this.f5123f, download, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21$lambda-16$lambda-15, reason: not valid java name */
    public static final void m92downloadApp$lambda21$lambda16$lambda15(DownloadViewActionPresenter downloadViewActionPresenter, Download download, Throwable th) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        DownloadAnalytics downloadAnalytics = downloadViewActionPresenter.downloadAnalytics;
        String packageName = download.getPackageName();
        int versionCode = download.getVersionCode();
        DownloadStatusModel downloadModel = download.getDownloadModel();
        kotlin.jvm.internal.m.c(downloadModel);
        downloadAnalytics.sendDownloadAbortEvent(packageName, versionCode, downloadViewActionPresenter.mapDownloadAction(downloadModel.getAction()), download.getDownloadModel().getAction() == DownloadStatusModel.Action.MIGRATE, !download.getSplits().isEmpty(), download.getHasBilling() || download.getHasAdvertising(), download.getMalware().getRank().name(), download.getStoreName(), downloadViewActionPresenter.isInApkfyContext, download.getObb() != null, kotlin.jvm.internal.m.a(download.getStoreName(), "catappult"), download.getAppCategory(), download.getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21$lambda-17, reason: not valid java name */
    public static final Single m93downloadApp$lambda21$lambda17(DownloadViewActionPresenter downloadViewActionPresenter, Download download, Void r2) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        return g.a.a.a.d.d(downloadViewActionPresenter.dynamicSplitsManager.getAppSplitsByMd5(download.getMd5()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21$lambda-20, reason: not valid java name */
    public static final rx.b m94downloadApp$lambda21$lambda20(final DownloadViewActionPresenter downloadViewActionPresenter, final Download download, DynamicSplitsModel dynamicSplitsModel) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        return downloadViewActionPresenter.createDownload(download, dynamicSplitsModel.getDynamicSplitsList()).x(new rx.m.b() { // from class: cm.aptoide.pt.download.view.i
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m95downloadApp$lambda21$lambda20$lambda18(this.f5112f, download, (RoomDownload) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.download.view.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m96downloadApp$lambda21$lambda20$lambda19(this.f5172f, (RoomDownload) obj);
            }
        }).X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21$lambda-20$lambda-18, reason: not valid java name */
    public static final void m95downloadApp$lambda21$lambda20$lambda18(DownloadViewActionPresenter downloadViewActionPresenter, Download download, RoomDownload roomDownload) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(download, "$download");
        kotlin.jvm.internal.m.e(roomDownload, "roomDownload");
        long appId = download.getAppId();
        DownloadStatusModel downloadModel = download.getDownloadModel();
        kotlin.jvm.internal.m.c(downloadModel);
        downloadViewActionPresenter.setupDownloadEvents(roomDownload, appId, downloadModel.getAction(), download.getStoreName(), download.getMalware().getRank().name(), download.getAppCategory());
        if (DownloadStatusModel.Action.MIGRATE == download.getDownloadModel().getAction()) {
            InstallAnalytics installAnalytics = downloadViewActionPresenter.installAnalytics;
            String packageName = download.getPackageName();
            AnalyticsManager.Action action = AnalyticsManager.Action.INSTALL;
            DownloadAnalytics.AppContext appContext = downloadViewActionPresenter.analyticsContext;
            if (appContext == null) {
                kotlin.jvm.internal.m.w("analyticsContext");
                appContext = null;
            }
            installAnalytics.uninstallStarted(packageName, action, appContext);
            downloadViewActionPresenter.appcMigrationManager.addMigrationCandidate(download.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: downloadApp$lambda-21$lambda-20$lambda-19, reason: not valid java name */
    public static final rx.b m96downloadApp$lambda21$lambda20$lambda19(DownloadViewActionPresenter downloadViewActionPresenter, RoomDownload roomDownload) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        return downloadViewActionPresenter.installManager.x(roomDownload);
    }

    private final Origin getOrigin(int action) {
        if (action == 0) {
            return Origin.INSTALL;
        }
        if (action != 1) {
            return action != 2 ? Origin.INSTALL : Origin.DOWNGRADE;
        }
        return Origin.UPDATE;
    }

    private final rx.b handleOutOfSpaceError(final DownloadClick downloadClick) {
        rx.b bVarN = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.view.k
            @Override // rx.m.a
            public final void call() {
                DownloadViewActionPresenter.m97handleOutOfSpaceError$lambda6(this.f5119f, downloadClick);
            }
        }).a(this.downloadNavigator.openOutOfSpaceDialog(downloadClick.getDownload().getSize(), downloadClick.getDownload().getPackageName())).b(this.downloadNavigator.outOfSpaceDialogResult().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m98handleOutOfSpaceError$lambda7((OutOfSpaceNavigatorWrapper) obj);
            }
        })).E().X0().a(resumeDownload(downloadClick)).n(new rx.m.b() { // from class: cm.aptoide.pt.download.view.w
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m99handleOutOfSpaceError$lambda8((Throwable) obj);
            }
        });
        kotlin.jvm.internal.m.e(bVarN, "fromAction {\n      downl…printStackTrace()\n      }");
        return bVarN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceError$lambda-6, reason: not valid java name */
    public static final void m97handleOutOfSpaceError$lambda6(DownloadViewActionPresenter downloadViewActionPresenter, DownloadClick downloadClick) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(downloadClick, "$downloadClick");
        downloadViewActionPresenter.downloadAnalytics.sendNotEnoughSpaceError(downloadClick.getDownload().getMd5());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceError$lambda-7, reason: not valid java name */
    public static final Boolean m98handleOutOfSpaceError$lambda7(OutOfSpaceNavigatorWrapper outOfSpaceNavigatorWrapper) {
        return Boolean.valueOf(outOfSpaceNavigatorWrapper.getClearedSuccessfully());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: handleOutOfSpaceError$lambda-8, reason: not valid java name */
    public static final void m99handleOutOfSpaceError$lambda8(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    private final rx.b installApp(DownloadClick downloadClick) {
        DownloadStatusModel downloadModel = downloadClick.getDownload().getDownloadModel();
        DownloadAnalytics.AppContext appContext = null;
        DownloadStatusModel.Action action = downloadModel != null ? downloadModel.getAction() : null;
        int i2 = action == null ? -1 : WhenMappings.$EnumSwitchMapping$1[action.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            rx.b bVarDownloadApp = downloadApp(downloadClick.getDownload());
            DownloadAnalytics.AppContext appContext2 = this.analyticsContext;
            if (appContext2 == null) {
                kotlin.jvm.internal.m.w("analyticsContext");
            } else {
                appContext = appContext2;
            }
            rx.b bVarA = bVarDownloadApp.a(appContext.equals(DownloadAnalytics.AppContext.SEARCH) ? g.a.a.a.d.a(this.campaignManager.convertCampaign(downloadClick.getDownload().getCampaign(), SearchAnalytics.SEARCH)) : rx.b.e());
            kotlin.jvm.internal.m.e(bVarA, "downloadApp(downloadClic…            }\n          )");
            return bVarA;
        }
        if (i2 != 4) {
            if (i2 == 5) {
                return this.downloadNavigator.openApp(downloadClick.getDownload().getPackageName());
            }
            rx.b bVarE = rx.b.e();
            kotlin.jvm.internal.m.e(bVarE, "complete()");
            return bVarE;
        }
        rx.b bVarDowngradeApp = downgradeApp(downloadClick.getDownload());
        DownloadAnalytics.AppContext appContext3 = this.analyticsContext;
        if (appContext3 == null) {
            kotlin.jvm.internal.m.w("analyticsContext");
        } else {
            appContext = appContext3;
        }
        rx.b bVarA2 = bVarDowngradeApp.a(appContext.equals(DownloadAnalytics.AppContext.SEARCH) ? g.a.a.a.d.a(this.campaignManager.convertCampaign(downloadClick.getDownload().getCampaign(), SearchAnalytics.SEARCH)) : rx.b.e());
        kotlin.jvm.internal.m.e(bVarA2, "downgradeApp(downloadCli…            }\n          )");
        return bVarA2;
    }

    private final InstallType mapDownloadAction(DownloadStatusModel.Action downloadAction) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[downloadAction.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return InstallType.UPDATE;
            }
            if (i2 == 3) {
                return InstallType.INSTALL;
            }
            if (i2 == 4) {
                return InstallType.DOWNGRADE;
            }
            if (i2 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        throw new IllegalStateException("Mapping an invalid download action " + downloadAction.name());
    }

    private final rx.b pauseDownload(final DownloadClick downloadClick) {
        rx.b bVarA = rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.download.view.l
            @Override // rx.m.a
            public final void call() {
                DownloadViewActionPresenter.m100pauseDownload$lambda27(this.f5121f, downloadClick);
            }
        }).a(this.installManager.pauseInstall(downloadClick.getDownload().getMd5()));
        kotlin.jvm.internal.m.e(bVarA, "fromAction {\n      downl…nloadClick.download.md5))");
        return bVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: pauseDownload$lambda-27, reason: not valid java name */
    public static final void m100pauseDownload$lambda27(DownloadViewActionPresenter downloadViewActionPresenter, DownloadClick downloadClick) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        kotlin.jvm.internal.m.f(downloadClick, "$downloadClick");
        downloadViewActionPresenter.downloadAnalytics.downloadInteractEvent(downloadClick.getDownload().getPackageName(), "pause");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present$lambda-0, reason: not valid java name */
    public static final Boolean m101present$lambda0(View.LifecycleEvent lifecycleEvent) {
        return Boolean.valueOf(lifecycleEvent == View.LifecycleEvent.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present$lambda-3, reason: not valid java name */
    public static final rx.e m102present$lambda3(final DownloadViewActionPresenter downloadViewActionPresenter, View.LifecycleEvent lifecycleEvent) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        return downloadViewActionPresenter.getEventObservable().B0(new rx.m.e() { // from class: cm.aptoide.pt.download.view.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m103present$lambda3$lambda1((DownloadClick) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.download.view.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m104present$lambda3$lambda2(this.f5109f, (DownloadClick) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present$lambda-3$lambda-1, reason: not valid java name */
    public static final Boolean m103present$lambda3$lambda1(DownloadClick downloadClick) {
        return Boolean.valueOf(downloadClick.getAction() == DownloadEvent.GENERIC_ERROR || downloadClick.getAction() == DownloadEvent.OUT_OF_SPACE_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present$lambda-3$lambda-2, reason: not valid java name */
    public static final rx.b m104present$lambda3$lambda2(DownloadViewActionPresenter downloadViewActionPresenter, DownloadClick downloadClick) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        switch (WhenMappings.$EnumSwitchMapping$0[downloadClick.getAction().ordinal()]) {
            case 1:
                kotlin.jvm.internal.m.e(downloadClick, "event");
                return downloadViewActionPresenter.installApp(downloadClick);
            case 2:
                kotlin.jvm.internal.m.e(downloadClick, "event");
                return downloadViewActionPresenter.resumeDownload(downloadClick);
            case 3:
                kotlin.jvm.internal.m.e(downloadClick, "event");
                return downloadViewActionPresenter.pauseDownload(downloadClick);
            case 4:
                kotlin.jvm.internal.m.e(downloadClick, "event");
                return downloadViewActionPresenter.cancelDownload(downloadClick);
            case 5:
                return downloadViewActionPresenter.downloadDialogProvider.showGenericError();
            case 6:
                kotlin.jvm.internal.m.e(downloadClick, "event");
                return downloadViewActionPresenter.handleOutOfSpaceError(downloadClick);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present$lambda-4, reason: not valid java name */
    public static final void m105present$lambda4(DownloadClick downloadClick) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: present$lambda-5, reason: not valid java name */
    public static final void m106present$lambda5(DownloadViewActionPresenter downloadViewActionPresenter, Throwable th) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        downloadViewActionPresenter.crashReport.log(th);
    }

    private final rx.b resumeDownload(final DownloadClick downloadClick) {
        rx.b bVarJ = this.installManager.getDownload(downloadClick.getDownload().getMd5()).g(new rx.m.b() { // from class: cm.aptoide.pt.download.view.a0
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m107resumeDownload$lambda24(downloadClick, this, (RoomDownload) obj);
            }
        }).e(new rx.m.b() { // from class: cm.aptoide.pt.download.view.g
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.download.view.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m109resumeDownload$lambda26(this.f5106f, (RoomDownload) obj);
            }
        });
        kotlin.jvm.internal.m.e(bVarJ, "installManager.getDownlo…nager.install(download) }");
        return bVarJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resumeDownload$lambda-24, reason: not valid java name */
    public static final void m107resumeDownload$lambda24(DownloadClick downloadClick, DownloadViewActionPresenter downloadViewActionPresenter, RoomDownload roomDownload) {
        kotlin.jvm.internal.m.f(downloadClick, "$downloadClick");
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        Download download = downloadClick.getDownload();
        kotlin.jvm.internal.m.e(roomDownload, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT);
        long appId = download.getAppId();
        DownloadStatusModel downloadModel = download.getDownloadModel();
        kotlin.jvm.internal.m.c(downloadModel);
        downloadViewActionPresenter.setupDownloadEvents(roomDownload, appId, downloadModel.getAction(), download.getStoreName(), download.getMalware().getRank().name(), download.getAppCategory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resumeDownload$lambda-26, reason: not valid java name */
    public static final rx.b m109resumeDownload$lambda26(DownloadViewActionPresenter downloadViewActionPresenter, RoomDownload roomDownload) {
        kotlin.jvm.internal.m.f(downloadViewActionPresenter, "this$0");
        return downloadViewActionPresenter.installManager.x(roomDownload);
    }

    public final int parseDownloadAction(DownloadStatusModel.Action action) {
        kotlin.jvm.internal.m.f(action, "action");
        int i2 = WhenMappings.$EnumSwitchMapping$1[action.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 0;
            }
            if (i2 != 4) {
                throw new IllegalArgumentException("Invalid action " + action);
            }
        }
        return 2;
    }

    @Override // cm.aptoide.pt.presenter.ActionPresenter
    protected void present() {
        if (this.analyticsContext == null) {
            throw new IllegalStateException("setContextParams must be called!");
        }
        getLifecycleView().getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m101present$lambda0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DownloadViewActionPresenter.m102present$lambda3(this.f5167f, (View.LifecycleEvent) obj);
            }
        }).f(getLifecycleView().bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.view.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m105present$lambda4((DownloadClick) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.view.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadViewActionPresenter.m106present$lambda5(this.f5097f, (Throwable) obj);
            }
        });
    }

    public final void setContextParams(DownloadAnalytics.AppContext context, boolean isApkfy, String editorsChoicePosition) {
        kotlin.jvm.internal.m.f(context, "context");
        this.analyticsContext = context;
        this.isInApkfyContext = isApkfy;
        this.editorsChoicePosition = editorsChoicePosition;
    }

    public final void setupDownloadEvents(RoomDownload download, long appId, DownloadStatusModel.Action downloadAction, String storeName, String malwareRank, String appCategory) {
        DownloadAnalytics.AppContext appContext;
        kotlin.jvm.internal.m.f(download, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT);
        kotlin.jvm.internal.m.f(downloadAction, "downloadAction");
        kotlin.jvm.internal.m.f(malwareRank, "malwareRank");
        kotlin.jvm.internal.m.f(appCategory, "appCategory");
        int campaignId = this.notificationAnalytics.getCampaignId(download.getPackageName(), appId);
        String abTestingGroup = this.notificationAnalytics.getAbTestingGroup(download.getPackageName(), appId);
        InstallAnalytics installAnalytics = this.installAnalytics;
        String packageName = download.getPackageName();
        int versionCode = download.getVersionCode();
        AnalyticsManager.Action action = AnalyticsManager.Action.INSTALL;
        DownloadAnalytics.AppContext appContext2 = this.analyticsContext;
        if (appContext2 == null) {
            kotlin.jvm.internal.m.w("analyticsContext");
            appContext = null;
        } else {
            appContext = appContext2;
        }
        Origin origin = getOrigin(download.getAction());
        DownloadStatusModel.Action action2 = DownloadStatusModel.Action.MIGRATE;
        boolean z = downloadAction == action2;
        boolean zHasAppc = download.hasAppc();
        boolean zHasSplits = download.hasSplits();
        boolean z2 = this.isInApkfyContext;
        boolean zHasObbs = download.hasObbs();
        SplitAnalyticsMapper splitAnalyticsMapper = this.splitAnalyticsMapper;
        List<RoomFileToDownload> splits = download.getSplits();
        kotlin.jvm.internal.m.e(splits, "download.splits");
        installAnalytics.installStarted(packageName, versionCode, action, appContext, origin, campaignId, abTestingGroup, z, zHasAppc, zHasSplits, malwareRank, storeName, z2, zHasObbs, splitAnalyticsMapper.getSplitTypesAsString(splits), kotlin.text.u.r(storeName, "catappult", false, 2, null), appCategory, download.getSize());
        if (action2 == downloadAction) {
            DownloadAnalytics downloadAnalytics = this.downloadAnalytics;
            String md5 = download.getMd5();
            int versionCode2 = download.getVersionCode();
            String packageName2 = download.getPackageName();
            String str = this.editorsChoicePosition;
            InstallType installType = InstallType.UPDATE_TO_APPC;
            boolean zHasAppc2 = download.hasAppc();
            boolean zHasSplits2 = download.hasSplits();
            boolean z3 = this.isInApkfyContext;
            boolean zHasObbs2 = download.hasObbs();
            SplitAnalyticsMapper splitAnalyticsMapper2 = this.splitAnalyticsMapper;
            List<RoomFileToDownload> splits2 = download.getSplits();
            kotlin.jvm.internal.m.e(splits2, "download.splits");
            downloadAnalytics.migrationClicked(md5, versionCode2, packageName2, malwareRank, str, installType, action, zHasAppc2, zHasSplits2, storeName, z3, zHasObbs2, splitAnalyticsMapper2.getSplitTypesAsString(splits2), kotlin.text.u.r(storeName, "catappult", false, 2, null), appCategory, download.getSize());
            return;
        }
        DownloadAnalytics downloadAnalytics2 = this.downloadAnalytics;
        String md6 = download.getMd5();
        int versionCode3 = download.getVersionCode();
        String packageName3 = download.getPackageName();
        String str2 = this.editorsChoicePosition;
        InstallType installTypeMapDownloadAction = mapDownloadAction(downloadAction);
        boolean zHasAppc3 = download.hasAppc();
        boolean zHasSplits3 = download.hasSplits();
        boolean z4 = this.isInApkfyContext;
        boolean zHasObbs3 = download.hasObbs();
        SplitAnalyticsMapper splitAnalyticsMapper3 = this.splitAnalyticsMapper;
        List<RoomFileToDownload> splits3 = download.getSplits();
        kotlin.jvm.internal.m.e(splits3, "download.splits");
        downloadAnalytics2.installClicked(md6, versionCode3, packageName3, malwareRank, str2, installTypeMapDownloadAction, action, zHasAppc3, zHasSplits3, storeName, z4, zHasObbs3, splitAnalyticsMapper3.getSplitTypesAsString(splits3), kotlin.text.u.r(storeName, "catappult", false, 2, null), appCategory, download.getSize());
    }
}
