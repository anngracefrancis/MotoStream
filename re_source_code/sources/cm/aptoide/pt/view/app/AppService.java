package cm.aptoide.pt.view.app;

import android.content.SharedPreferences;
import cm.aptoide.pt.aab.SplitsMapper;
import cm.aptoide.pt.app.mmpcampaigns.CampaignMapper;
import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.Malware;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.model.v7.listapp.File;
import cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppVersions;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest;
import cm.aptoide.pt.dataprovider.ws.v7.GetRecommendedRequest;
import cm.aptoide.pt.dataprovider.ws.v7.ListAppsRequest;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppService {
    private static final int MATURE_APP_RATING = 18;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;
    private final CampaignMapper campaignMapper;
    private final Converter.Factory converterFactory;
    private final OkHttpClient httpClient;
    private boolean loadingAppcSimilarApps;
    private boolean loadingApps;
    private boolean loadingSimilarApps;
    private final SharedPreferences sharedPreferences;
    private final SplitsMapper splitsMapper;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    /* JADX INFO: renamed from: cm.aptoide.pt.view.app.AppService$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type;

        static {
            int[] iArr = new int[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type = iArr;
            try {
                iArr[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.FAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.GOOD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.VIRUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.FREEZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[GetAppMeta.GetAppMetaFile.Flags.Vote.Type.LICENSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public AppService(StoreCredentialsProvider storeCredentialsProvider, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, SplitsMapper splitsMapper, CampaignMapper campaignMapper) {
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.bodyInterceptorV7 = bodyInterceptor;
        this.httpClient = okHttpClient;
        this.converterFactory = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.splitsMapper = splitsMapper;
        this.campaignMapper = campaignMapper;
    }

    private boolean canCompare(ListAppVersions listAppVersions) {
        return (listAppVersions == null || listAppVersions.getList() == null || listAppVersions.getList().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createDetailedAppRequestResultError, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public DetailedAppRequestResult N(Throwable th) {
        return th instanceof NoNetworkConnectionException ? new DetailedAppRequestResult(DetailedAppRequestResult.Error.NETWORK) : new DetailedAppRequestResult(DetailedAppRequestResult.Error.GENERIC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createErrorAppsList, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AppsList I(Throwable th) {
        return th instanceof NoNetworkConnectionException ? new AppsList(AppsList.Error.NETWORK) : new AppsList(AppsList.Error.GENERIC);
    }

    private String getCategory(GetApp.Nodes nodes) {
        try {
            return !nodes.getGroups().getDataList().getList().isEmpty() ? nodes.getGroups().getDataList().getList().get(0).getParent().getName() : HttpUrl.FRAGMENT_ENCODE_SET;
        } catch (Exception e2) {
            e2.printStackTrace();
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    private boolean isBeta(List<String> list, String str) {
        for (String str2 : list) {
            if ("beta".equals(str2) || "alpha".equals(str2)) {
                return true;
            }
        }
        return str.contains("alpha") || str.contains("beta");
    }

    private boolean isLatestTrustedVersion(ListAppVersions listAppVersions, File file) {
        return canCompare(listAppVersions) && file.getMd5sum().equals(listAppVersions.getList().get(0).getFile().getMd5sum()) && file.getMalware().getRank() == Malware.Rank.TRUSTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAppcRecommendedApps$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a() {
        this.loadingAppcSimilarApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAppcRecommendedApps$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        this.loadingAppcSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadAppcRecommendedApps$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c() {
        this.loadingAppcSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadApps$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadApps$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadApps$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e n(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e s(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedApp$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DetailedAppRequestResult t(Throwable th) {
        th.printStackTrace();
        return lambda$unsafeLoadDetailedApp$14(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromMd5$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromMd5$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromMd5$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromMd5$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e x(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromUniqueName$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void z() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromUniqueName$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadDetailedAppFromUniqueName$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadRecommendedApps$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E() {
        this.loadingSimilarApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadRecommendedApps$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F() {
        this.loadingSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadRecommendedApps$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G() {
        this.loadingSimilarApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$unsafeLoadDetailedApp$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J() {
        this.loadingApps = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$unsafeLoadDetailedApp$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$unsafeLoadDetailedApp$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L() {
        this.loadingApps = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$unsafeLoadDetailedApp$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e M(GetApp getApp) {
        return lambda$loadDetailedAppFromUniqueName$28(getApp, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private Single<AppsList> loadApps(long j2, boolean z, int i2, int i3) {
        if (this.loadingApps) {
            return Single.m(new AppsList(true));
        }
        ListAppsRequest.Body body = new ListAppsRequest.Body(this.storeCredentialsProvider.get(j2), i3, this.sharedPreferences);
        body.setOffset(i2);
        body.setStoreId(j2);
        return new ListAppsRequest(body, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(z, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.v0
            @Override // rx.m.a
            public final void call() {
                this.f7990f.f();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.n0
            @Override // rx.m.a
            public final void call() {
                this.f7966f.g();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.a0
            @Override // rx.m.a
            public final void call() {
                this.f7919f.h();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7959f.i((ListApps) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7931f.j((Throwable) obj);
            }
        });
    }

    private FlagsVote.VoteType map(GetAppMeta.GetAppMetaFile.Flags.Vote.Type type) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$GetAppMeta$GetAppMetaFile$Flags$Vote$Type[type.ordinal()];
        if (i2 == 1) {
            return FlagsVote.VoteType.FAKE;
        }
        if (i2 == 2) {
            return FlagsVote.VoteType.GOOD;
        }
        if (i2 == 3) {
            return FlagsVote.VoteType.VIRUS;
        }
        if (i2 == 4) {
            return FlagsVote.VoteType.FREEZE;
        }
        if (i2 != 5) {
            return null;
        }
        return FlagsVote.VoteType.LICENSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapApp, reason: merged with bridge method [inline-methods] */
    public rx.e<DetailedAppRequestResult> C(GetApp getApp, String str) {
        if (!getApp.isOk()) {
            return rx.e.C(new IllegalStateException("Could not obtain request from server."));
        }
        GetAppMeta.App data = getApp.getNodes().getMeta().getData();
        ListAppVersions versions = getApp.getNodes().getVersions();
        GetAppMeta.GetAppMetaFile file = data.getFile();
        GetAppMeta.GetAppMetaFile.Flags flags = data.getFile().getFlags();
        GetAppMeta.Developer developer = data.getDeveloper();
        GetAppMeta.Stats stats = data.getStats();
        GetAppMeta.Stats.Rating rating = stats.getRating();
        GetAppMeta.Stats.Rating globalRating = stats.getGlobalRating();
        GetAppMeta.Media media = data.getMedia();
        AppFlags appFlags = new AppFlags(flags.getReview(), mapToFlagsVote(flags.getVotes()));
        AppDeveloper appDeveloper = new AppDeveloper(developer.getName(), developer.getEmail(), developer.getPrivacy(), developer.getWebsite());
        AppStats appStats = new AppStats(new AppRating(rating.getAvg(), rating.getTotal(), mapToRatingsVote(rating.getVotes())), new AppRating(globalRating.getAvg(), globalRating.getTotal(), mapToRatingsVote(globalRating.getVotes())), stats.getDownloads(), stats.getPdownloads());
        return rx.e.S(new DetailedAppRequestResult(new DetailedApp(data.getId(), data.getName(), data.getPackageName(), data.getSize(), data.getIcon(), data.getGraphic(), data.getAdded(), data.getModified(), file.isGoodApp(), file.getMalware(), appFlags, file.getTags(), file.getUsedFeatures(), file.getUsedPermissions(), file.getFilesize(), data.getMd5(), file.getPath(), file.getPathAlt(), file.getVercode(), file.getVername(), appDeveloper, data.getStore(), new AppMedia(media.getDescription(), media.getKeywords(), media.getNews(), mapToScreenShots(media.getScreenshots()), mapToVideo(media.getVideos())), appStats, data.getObb(), isLatestTrustedVersion(versions, file), data.getUname(), data.hasBilling(), data.hasAdvertising(), data.getBdsFlags(), data.getAge().getRating() == 18, data.getFile().getSignature().getSha1(), data.hasSplits() ? this.splitsMapper.mapSplits(data.getAab().getSplits()) : Collections.emptyList(), data.hasSplits() ? data.getAab().getRequiredSplits() : Collections.emptyList(), isBeta(file.getTags(), file.getVername()), getCategory(getApp.getNodes()), this.campaignMapper.mapCampaign(data.getUrls()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mapListApps, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public rx.e<AppsList> H(ListApps listApps) {
        if (!listApps.isOk()) {
            return rx.e.C(new IllegalStateException("Could not obtain request from server."));
        }
        ArrayList arrayList = new ArrayList();
        for (App app : listApps.getDataList().getList()) {
            arrayList.add(new Application(app.getName(), app.getIcon(), app.getStats().getRating().getAvg(), app.getStats().getDownloads(), app.getPackageName(), app.getId(), HttpUrl.FRAGMENT_ENCODE_SET, app.getAppcoins() != null && app.getAppcoins().hasBilling()));
        }
        return rx.e.S(new AppsList(arrayList, false, listApps.getDataList().getNext()));
    }

    private List<FlagsVote> mapToFlagsVote(List<GetAppMeta.GetAppMetaFile.Flags.Vote> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GetAppMeta.GetAppMetaFile.Flags.Vote vote : list) {
                arrayList.add(new FlagsVote(vote.getCount(), map(vote.getType())));
            }
        }
        return arrayList;
    }

    private List<RatingVote> mapToRatingsVote(List<GetAppMeta.Stats.Rating.Vote> list) {
        ArrayList arrayList = new ArrayList();
        for (GetAppMeta.Stats.Rating.Vote vote : list) {
            arrayList.add(new RatingVote(vote.getCount(), vote.getValue()));
        }
        return arrayList;
    }

    private List<AppScreenshot> mapToScreenShots(List<GetAppMeta.Media.Screenshot> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GetAppMeta.Media.Screenshot screenshot : list) {
                arrayList.add(new AppScreenshot(screenshot.getHeight(), screenshot.getWidth(), screenshot.getOrientation(), screenshot.getUrl()));
            }
        }
        return arrayList;
    }

    private List<AppVideo> mapToVideo(List<GetAppMeta.Media.Video> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (GetAppMeta.Media.Video video : list) {
                arrayList.add(new AppVideo(video.getThumbnail(), video.getType(), video.getUrl()));
            }
        }
        return arrayList;
    }

    public Single<AppsList> loadAppcRecommendedApps(int i2, String str) {
        return this.loadingAppcSimilarApps ? Single.m(new AppsList(true)) : new GetRecommendedRequest(new GetRecommendedRequest.Body(i2, str, "appc"), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.k0
            @Override // rx.m.a
            public final void call() {
                this.f7956f.a();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.p0
            @Override // rx.m.a
            public final void call() {
                this.f7972f.b();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.x
            @Override // rx.m.a
            public final void call() {
                this.f7995f.c();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7946f.d((ListApps) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7983f.e((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(long j2, String str, String str2) {
        return this.loadingApps ? Single.m(new DetailedAppRequestResult(true)) : GetAppRequest.of(j2, null, StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.g0
            @Override // rx.m.a
            public final void call() {
                this.f7943f.p();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.t0
            @Override // rx.m.a
            public final void call() {
                this.f7984f.q();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.q0
            @Override // rx.m.a
            public final void call() {
                this.f7975f.r();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7987f.s((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7993f.t((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromMd5(String str) {
        return this.loadingApps ? Single.m(new DetailedAppRequestResult(true)) : GetAppRequest.ofMd5(str, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, ManagerPreferences.getAndResetForceServerRefresh(this.sharedPreferences)).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.s0
            @Override // rx.m.a
            public final void call() {
                this.f7981f.u();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.v
            @Override // rx.m.a
            public final void call() {
                this.f7989f.v();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.l
            @Override // rx.m.a
            public final void call() {
                this.f7958f.w();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7980f.x((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8001f.y((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName(final String str) {
        return this.loadingApps ? Single.m(new DetailedAppRequestResult(true)) : GetAppRequest.ofUname(str, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.m0
            @Override // rx.m.a
            public final void call() {
                this.f7962f.z();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.y0
            @Override // rx.m.a
            public final void call() {
                this.f7999f.A();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.u
            @Override // rx.m.a
            public final void call() {
                this.f7986f.B();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7964f.C(str, (GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7935f.D((Throwable) obj);
            }
        });
    }

    public Single<AppsList> loadFreshApps(long j2, int i2) {
        return loadApps(j2, true, 0, i2);
    }

    public Single<AppsList> loadRecommendedApps(int i2, String str) {
        return this.loadingSimilarApps ? Single.m(new AppsList(true)) : new GetRecommendedRequest(new GetRecommendedRequest.Body(i2, str), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(true, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.w
            @Override // rx.m.a
            public final void call() {
                this.f7992f.E();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.r
            @Override // rx.m.a
            public final void call() {
                this.f7977f.F();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.y
            @Override // rx.m.a
            public final void call() {
                this.f7998f.G();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7922f.H((ListApps) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.r0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7978f.I((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> unsafeLoadDetailedApp(long j2, String str, String str2) {
        return GetAppRequest.of(j2, null, StoreUtils.getStoreCredentials(str, this.storeCredentialsProvider), str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.o0
            @Override // rx.m.a
            public final void call() {
                this.f7969f.J();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.m
            @Override // rx.m.a
            public final void call() {
                this.f7961f.K();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.x0
            @Override // rx.m.a
            public final void call() {
                this.f7996f.L();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7939f.M((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7971f.N((Throwable) obj);
            }
        });
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(String str, String str2) {
        if (this.loadingApps) {
            return Single.m(new DetailedAppRequestResult(true));
        }
        return GetAppRequest.of(str, str2, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences).observe(false, false).y(new rx.m.a() { // from class: cm.aptoide.pt.view.app.q
            @Override // rx.m.a
            public final void call() {
                this.f7974f.k();
            }
        }).A(new rx.m.a() { // from class: cm.aptoide.pt.view.app.j0
            @Override // rx.m.a
            public final void call() {
                this.f7953f.l();
            }
        }).z(new rx.m.a() { // from class: cm.aptoide.pt.view.app.c0
            @Override // rx.m.a
            public final void call() {
                this.f7926f.m();
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.view.app.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7968f.n((GetApp) obj);
            }
        }).Z0().r(new rx.m.e() { // from class: cm.aptoide.pt.view.app.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7950f.o((Throwable) obj);
            }
        });
    }

    public Single<AppsList> loadApps(long j2, int i2, int i3) {
        return loadApps(j2, false, i2, i3);
    }
}
