package cm.aptoide.pt.editorial;

import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.pt.aab.DynamicSplitsManager;
import cm.aptoide.pt.aab.DynamicSplitsModel;
import cm.aptoide.pt.ads.MoPubAdsManager;
import cm.aptoide.pt.app.DownloadStateParser;
import cm.aptoide.pt.app.mmpcampaigns.CampaignManager;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.DownloadFactory;
import cm.aptoide.pt.download.SplitAnalyticsMapper;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallAnalytics;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.notification.NotificationAnalytics;
import cm.aptoide.pt.reactions.ReactionsManager;
import cm.aptoide.pt.reactions.network.LoadReactionModel;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import cm.aptoide.pt.view.EditorialConfiguration;
import java.util.List;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class EditorialManager {
    private final CampaignManager campaignManager;
    private final DownloadFactory downloadFactory;
    private final DownloadStateParser downloadStateParser;
    private final DynamicSplitsManager dynamicSplitsManager;
    private final EditorialAnalytics editorialAnalytics;
    private final EditorialConfiguration editorialConfiguration;
    private final EditorialRepository editorialRepository;
    private final InstallAnalytics installAnalytics;
    private final InstallManager installManager;
    private final MoPubAdsManager moPubAdsManager;
    private final NotificationAnalytics notificationAnalytics;
    private final ReactionsManager reactionsManager;
    private final SplitAnalyticsMapper splitAnalyticsMapper;

    public EditorialManager(EditorialRepository editorialRepository, EditorialConfiguration editorialConfiguration, InstallManager installManager, DownloadFactory downloadFactory, DownloadStateParser downloadStateParser, NotificationAnalytics notificationAnalytics, InstallAnalytics installAnalytics, EditorialAnalytics editorialAnalytics, ReactionsManager reactionsManager, MoPubAdsManager moPubAdsManager, DynamicSplitsManager dynamicSplitsManager, SplitAnalyticsMapper splitAnalyticsMapper, CampaignManager campaignManager) {
        this.editorialRepository = editorialRepository;
        this.editorialConfiguration = editorialConfiguration;
        this.installManager = installManager;
        this.downloadFactory = downloadFactory;
        this.downloadStateParser = downloadStateParser;
        this.notificationAnalytics = notificationAnalytics;
        this.installAnalytics = installAnalytics;
        this.editorialAnalytics = editorialAnalytics;
        this.reactionsManager = reactionsManager;
        this.moPubAdsManager = moPubAdsManager;
        this.dynamicSplitsManager = dynamicSplitsManager;
        this.splitAnalyticsMapper = splitAnalyticsMapper;
        this.campaignManager = campaignManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(EditorialDownloadEvent editorialDownloadEvent, DynamicSplitsModel dynamicSplitsModel) {
        return rx.e.S(this.downloadFactory.create(this.downloadStateParser.parseDownloadAction(editorialDownloadEvent.getAction()), editorialDownloadEvent.getAppName(), editorialDownloadEvent.getPackageName(), editorialDownloadEvent.getMd5(), editorialDownloadEvent.getIcon(), editorialDownloadEvent.getVerName(), editorialDownloadEvent.getVerCode(), editorialDownloadEvent.getPath(), editorialDownloadEvent.getPathAlt(), editorialDownloadEvent.getObb(), false, editorialDownloadEvent.getSize(), editorialDownloadEvent.getSplits(), editorialDownloadEvent.getRequiredSplits(), editorialDownloadEvent.getTrustedBadge(), editorialDownloadEvent.getTrustedBadge(), dynamicSplitsModel.getDynamicSplitsList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(EditorialDownloadEvent editorialDownloadEvent, RoomDownload roomDownload) {
        setupDownloadEvents(roomDownload, editorialDownloadEvent.getPackageName(), editorialDownloadEvent.getAppId(), editorialDownloadEvent.getTrustedBadge(), editorialDownloadEvent.getStoreName(), editorialDownloadEvent.getAction().toString(), editorialDownloadEvent.getBdsFlags().contains("STORE_BDS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$downloadApp$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(RoomDownload roomDownload) {
        return this.installManager.x(roomDownload);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDownloadModel$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ EditorialDownloadModel d(int i2, Install install) {
        return new EditorialDownloadModel(this.downloadStateParser.parseDownloadType(install.getType(), false), install.getProgress(), this.downloadStateParser.parseDownloadState(install.getState(), install.isIndeterminate()), i2, install.getAppSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str, long j2, String str2, List list, RoomDownload roomDownload) {
        setupDownloadEvents(roomDownload, str, j2, roomDownload.getTrustedBadge(), roomDownload.getStoreName(), str2, list.contains("STORE_BDS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$resumeDownload$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(RoomDownload roomDownload) {
        return this.installManager.x(roomDownload);
    }

    private void setupDownloadEvents(RoomDownload roomDownload, String str, long j2, String str2, String str3, String str4, boolean z) {
        int campaignId = this.notificationAnalytics.getCampaignId(str, j2);
        String abTestingGroup = this.notificationAnalytics.getAbTestingGroup(str, j2);
        this.editorialAnalytics.setupDownloadEvents(roomDownload, campaignId, abTestingGroup, AnalyticsManager.Action.CLICK, str2, str3, str4, z);
        this.installAnalytics.installStarted(roomDownload.getPackageName(), roomDownload.getVersionCode(), AnalyticsManager.Action.INSTALL, DownloadAnalytics.AppContext.EDITORIAL, this.downloadStateParser.getOrigin(roomDownload.getAction()), campaignId, abTestingGroup, false, roomDownload.hasAppc(), roomDownload.hasSplits(), roomDownload.getTrustedBadge(), roomDownload.getStoreName(), false, roomDownload.hasObbs(), this.splitAnalyticsMapper.getSplitTypesAsString(roomDownload.getSplits()), z, HttpUrl.FRAGMENT_ENCODE_SET, roomDownload.getSize());
    }

    public void allowRootInstall(Boolean bool) {
        this.installManager.rootInstallAllowed(bool.booleanValue());
    }

    public rx.b cancelDownload(String str, String str2, int i2) {
        return this.installManager.cancelInstall(str, str2, i2);
    }

    public rx.b convertCampaign(EditorialDownloadEvent editorialDownloadEvent) {
        return g.a.a.a.d.a(this.campaignManager.convertCampaign(editorialDownloadEvent.getCampaign(), "Editorial"));
    }

    public Single<ReactionsResponse> deleteReaction(String str, String str2) {
        return this.reactionsManager.deleteReaction(str, str2);
    }

    public rx.b downloadApp(final EditorialDownloadEvent editorialDownloadEvent) {
        return g.a.a.a.d.d(this.dynamicSplitsManager.getAppSplitsByMd5(editorialDownloadEvent.getMd5())).k(new rx.m.e() { // from class: cm.aptoide.pt.editorial.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5356f.a(editorialDownloadEvent, (DynamicSplitsModel) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.editorial.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5326f.b(editorialDownloadEvent, (RoomDownload) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.editorial.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5381f.c((RoomDownload) obj);
            }
        }).X0();
    }

    public Single<Boolean> isFirstReaction(String str, String str2) {
        return this.reactionsManager.isFirstReaction(str, str2);
    }

    public rx.e<EditorialDownloadModel> loadDownloadModel(String str, String str2, int i2, final int i3) {
        return this.installManager.getInstall(str, str2, i2).X(new rx.m.e() { // from class: cm.aptoide.pt.editorial.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5371f.d(i3, (Install) obj);
            }
        });
    }

    public Single<EditorialViewModel> loadEditorialViewModel() {
        return this.editorialRepository.loadEditorialViewModel(this.editorialConfiguration.getLoadSource());
    }

    public Single<LoadReactionModel> loadReactionModel(String str, String str2) {
        return this.reactionsManager.loadReactionModel(str, str2);
    }

    public rx.b pauseDownload(String str) {
        return this.installManager.pauseInstall(str);
    }

    public rx.b resumeDownload(String str, final String str2, final long j2, final String str3, final List<String> list) {
        return this.installManager.getDownload(str).g(new rx.m.b() { // from class: cm.aptoide.pt.editorial.g0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5335f.e(str2, j2, str3, list, (RoomDownload) obj);
            }
        }).j(new rx.m.e() { // from class: cm.aptoide.pt.editorial.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5347f.f((RoomDownload) obj);
            }
        });
    }

    public Single<ReactionsResponse> setReaction(String str, String str2, String str3) {
        return this.reactionsManager.setReaction(str, str2, str3);
    }

    public boolean shouldShowRootInstallWarningPopup() {
        return this.installManager.showWarning();
    }
}
