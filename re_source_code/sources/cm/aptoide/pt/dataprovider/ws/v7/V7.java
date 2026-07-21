package cm.aptoide.pt.dataprovider.ws.v7;

import android.accounts.NetworkErrorException;
import android.content.SharedPreferences;
import cm.aptoide.pt.dataprovider.BuildConfig;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.exception.NoNetworkConnectionException;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.EditorialCard;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.model.v7.GetFollowers;
import cm.aptoide.pt.dataprovider.model.v7.GetMySubscribedStoresResponse;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.GetUserInfo;
import cm.aptoide.pt.dataprovider.model.v7.ListAppCoinsCampaigns;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.model.v7.ListFullReviews;
import cm.aptoide.pt.dataprovider.model.v7.ListReviews;
import cm.aptoide.pt.dataprovider.model.v7.SetComment;
import cm.aptoide.pt.dataprovider.model.v7.TimelineStats;
import cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppVersions;
import cm.aptoide.pt.dataprovider.model.v7.listapp.ListAppsUpdates;
import cm.aptoide.pt.dataprovider.model.v7.search.ListSearchApps;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHome;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreDisplays;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.util.HashMapNotNull;
import cm.aptoide.pt.dataprovider.util.ToRetryThrowable;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.RefreshBody;
import cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.DownloadInstallAnalyticsBaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemResponse;
import cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppVersionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.listapps.ListAppsUpdatesRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.ClaimPromotionRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPackagePromotionsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionAppsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.promotions.GetPromotionsResponse;
import cm.aptoide.pt.dataprovider.ws.v7.store.ChangeStoreSubscriptionRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeBody;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreListRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetRecommendedStoresRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreBody;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreDisplaysRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreWidgetsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetUserRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.ListStoresRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.PostCommentForStore;
import cm.aptoide.pt.preferences.toolbox.ToolboxManager;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public abstract class V7<U, B extends RefreshBody> extends WebService<Interfaces, U> {
    private final String INVALID_ACCESS_TOKEN_CODE;
    private final int MAX_RETRY_COUNT;
    private boolean accessTokenRetry;
    protected final B body;
    protected final BodyInterceptor bodyInterceptor;
    private QueryStringMapper queryStringMapper;
    private final TokenInvalidator tokenInvalidator;

    public interface Interfaces {
        @POST("user/addEvent/name={name}/action={action}/context={context}")
        rx.e<BaseV7Response> addEvent(@Path("name") String str, @Path("action") String str2, @Path("context") String str3, @Body BiUtmAnalyticsRequestBody biUtmAnalyticsRequestBody);

        @POST("user/addEvent/name={name}/action={action}/context={context}")
        rx.e<BaseV7Response> addEvent(@Path("name") String str, @Path("action") String str2, @Path("context") String str3, @Body DownloadInstallAnalyticsBaseBody downloadInstallAnalyticsBaseBody);

        @POST("store/subscription/set")
        rx.e<ChangeStoreSubscriptionResponse> changeStoreSubscription(@Header(WebService.BYPASS_HEADER_KEY) boolean z, @Body ChangeStoreSubscriptionRequest.Body body);

        @POST("appcoins/promotions/claim")
        rx.e<BaseV7Response> claimPromotion(@Body ClaimPromotionRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("store/set")
        rx.e<BaseV7Response> editStore(@Body SimpleSetStoreRequest.Body body);

        @POST("store/set")
        @Multipart
        rx.e<BaseV7Response> editStore(@Part MultipartBody.Part part, @PartMap HashMapNotNull<String, RequestBody> hashMapNotNull);

        @POST("user/set")
        @Multipart
        rx.e<BaseV7Response> editUser(@Part MultipartBody.Part part, @PartMap HashMapNotNull<String, RequestBody> hashMapNotNull);

        @GET("{url}")
        rx.e<ActionItemResponse> getActionItem(@Path(encoded = true, value = "url") String str, @QueryMap(encoded = true) Map<String, String> map, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @GET("getApp")
        rx.e<GetApp> getApp(@Header("Cache-Control") String str, @QueryMap(encoded = true) Map<String, String> map);

        @POST("appcoins/catappult/campaigns/get/limit={limit}")
        rx.e<ListAppCoinsCampaigns> getAppCoinsAds(@Body GetAppCoinsCampaignsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z, @Path("limit") int i2, @Query("aab") boolean z2);

        @GET("getApp/{url}")
        rx.e<GetApp> getAppMeta(@Header(WebService.BYPASS_HEADER_KEY) boolean z, @Path(encoded = true, value = "url") String str);

        @POST("user/action/item/card/get/id={cardId}")
        rx.e<EditorialCard> getEditorialFromCardId(@Path("cardId") String str, @Body BaseBody baseBody, @Query("aab") boolean z);

        @POST("user/action/item/card/get/slug={slug}")
        rx.e<EditorialCard> getEditorialFromSlug(@Path("slug") String str, @Body BaseBody baseBody, @Query("aab") boolean z);

        @POST("user/action/item/cards/get/type=CURATION_1/limit={limit}")
        rx.e<EditorialListResponse> getEditorialList(@Path("limit") int i2, @Body EditorialListRequest.Body body);

        @POST("home/get")
        rx.e<GetHome> getHome(@Body GetHomeBody getHomeBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @GET("getStoreWidgets/")
        rx.e<GetStoreWidgets> getHomeBundles(@Header(WebService.BYPASS_HEADER_KEY) boolean z, @QueryMap(encoded = true) Map<String, String> map);

        @POST("home/getMeta{url}")
        rx.e<GetHomeMeta> getHomeMeta(@Path(encoded = true, value = "url") String str, @Body GetHomeMetaRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("my/stores/getSubscribed")
        rx.e<ListStores> getMyStoreList(@Body GetMyStoreListRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("{url}")
        rx.e<ListStores> getMyStoreList(@Path(encoded = true, value = "url") String str, @Body GetMyStoreListRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("{url}")
        rx.e<ListStores> getMyStoreListEndless(@Path(encoded = true, value = "url") String str, @Body GetMyStoreListRequest.EndlessBody endlessBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("my/store/getMeta")
        rx.e<GetStoreMeta> getMyStoreMeta(@Body BaseBody baseBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("my/stores/getSubscribed/")
        rx.e<GetMySubscribedStoresResponse> getMySubscribedStores(@Header(WebService.BYPASS_HEADER_KEY) boolean z, @Body GetMySubscribedStoresRequest.Body body);

        @POST("appcoins/promotions/promotion/get/limit={limit}")
        rx.e<GetPromotionAppsResponse> getPromotionApps(@Path("limit") int i2, @Body GetPromotionAppsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z, @Query("aab") boolean z2);

        @POST("appcoins/promotions/get")
        rx.e<GetPromotionsResponse> getPromotions(@Body GetPromotionsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z, @Query("aab") boolean z2);

        @POST("appcoins/promotions/packages/getPromotions")
        rx.e<GetPackagePromotionsResponse> getPromotionsForPackage(@Body GetPackagePromotionsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @GET("apps/getRecommended")
        rx.e<ListApps> getRecommended(@Header("Cache-Control") String str, @QueryMap(encoded = true) Map<String, String> map);

        @POST("{url}")
        rx.e<ListStores> getRecommendedStore(@Path(encoded = true, value = "url") String str, @Body GetRecommendedStoresRequest.EndlessBody endlessBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("getStore{url}")
        rx.e<GetStore> getStore(@Path(encoded = true, value = "url") String str, @Body GetStoreBody getStoreBody, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("getStoreDisplays{url}")
        rx.e<GetStoreDisplays> getStoreDisplays(@Path(encoded = true, value = "url") String str, @Body GetStoreDisplaysRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("store/getMeta")
        rx.e<GetStoreMeta> getStoreMeta(@Body GetHomeMetaRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("{url}")
        rx.e<GetStoreMeta> getStoreMeta(@Path(encoded = true, value = "url") String str, @Body GetHomeMetaRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("getStoreWidgets{url}")
        rx.e<GetStoreWidgets> getStoreWidgets(@Path(encoded = true, value = "url") String str, @Body GetStoreWidgetsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("user/getFollowers")
        rx.e<GetFollowers> getTimelineFollowers(@Body GetFollowersRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("user/getFollowing")
        rx.e<GetFollowers> getTimelineGetFollowing(@Body GetFollowersRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("user/getTimelineStats")
        rx.e<TimelineStats> getTimelineStats(@Body GetTimelineStatsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("user/get{url}")
        rx.e<GetStore> getUser(@Path(encoded = true, value = "url") String str, @Body GetUserRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("user/get")
        rx.e<GetUserInfo> getUserInfo(@Body GetUserInfoRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("listAppVersions")
        rx.e<ListAppVersions> listAppVersions(@Body ListAppVersionsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z, @Query("aab") boolean z2);

        @GET("listApps{url}")
        rx.e<ListApps> listApps(@Path(encoded = true, value = "url") String str, @Header("Cache-Control") String str2, @QueryMap(encoded = true) Map<String, String> map);

        @POST("listAppsUpdates")
        rx.e<ListAppsUpdates> listAppsUpdates(@Body ListAppsUpdatesRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z, @Query("aab") boolean z2);

        @POST("listComments")
        rx.e<ListComments> listComments(@Body ListCommentsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST
        rx.e<ListComments> listComments(@Url String str, @Body ListCommentsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("listFullReviews")
        rx.e<ListFullReviews> listFullReviews(@Body ListFullReviewsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("listFullReviews{url}")
        rx.e<ListFullReviews> listFullReviews(@Path(encoded = true, value = "url") String str, @Body ListFullReviewsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("listReviews")
        rx.e<ListReviews> listReviews(@Body ListReviewsRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @GET("listSearchApps")
        rx.e<ListSearchApps> listSearchApps(@Header("Cache-Control") String str, @QueryMap(encoded = true) Map<String, String> map);

        @POST("listStores{url}")
        rx.e<ListStores> listStores(@Path(encoded = true, value = "url") String str, @Body ListStoresRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("listStores/sort/{sort}/limit/{limit}")
        rx.e<ListStores> listTopStores(@Path(encoded = true, value = "sort") String str, @Path(encoded = true, value = "limit") int i2, @Body ListStoresRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("setReview")
        rx.e<BaseV7Response> postReview(@Body PostReviewRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("setComment")
        rx.e<BaseV7Response> postReviewComment(@Body PostCommentForReview.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("setComment")
        rx.e<SetComment> postStoreComment(@Body PostCommentForStore.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("review/set/access_token={accessToken}/card_uid={cardUid}/rating={rating}")
        rx.e<BaseV7Response> setReview(@Body BaseBody baseBody, @Path("cardUid") String str, @Path("accessToken") String str2, @Path("rating") String str3, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("setReviewVote")
        rx.e<BaseV7Response> setReviewVote(@Body SetReviewRatingRequest.Body body, @Header(WebService.BYPASS_HEADER_KEY) boolean z);

        @POST("user/set")
        rx.e<BaseV7Response> setUser(@Body SetUserRequest.Body body);

        @POST("user/settings/set")
        rx.e<BaseV7Response> setUserSettings(@Body SetUserSettings.Body body);
    }

    protected V7(B b2, String str, OkHttpClient okHttpClient, Converter.Factory factory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(Interfaces.class, okHttpClient, factory, str);
        this.INVALID_ACCESS_TOKEN_CODE = "AUTH-2";
        this.MAX_RETRY_COUNT = 3;
        this.accessTokenRetry = false;
        this.body = b2;
        this.bodyInterceptor = bodyInterceptor;
        this.tokenInvalidator = tokenInvalidator;
    }

    public static String getCacheHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_CACHE_HOST);
        sb.append("/api/7.20240701/");
        return sb.toString();
    }

    public static String getErrorMessage(BaseV7Response baseV7Response) {
        StringBuilder sb = new StringBuilder();
        if (baseV7Response == null || baseV7Response.getErrors() == null) {
            sb.append("Server returned null response.");
        } else {
            Iterator<BaseV7Response.Error> it = baseV7Response.getErrors().iterator();
            while (it.hasNext()) {
                sb.append(it.next().getDescription());
                sb.append(". ");
            }
            if (sb.length() == 0) {
                sb.append("Server failed with empty error list.");
            }
        }
        return sb.toString();
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? "http" : BuildConfig.APTOIDE_WEB_SERVICES_SCHEME);
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_V7_HOST);
        sb.append("/api/7.20240701/");
        return sb.toString();
    }

    private rx.e<U> handleToken(rx.e<U> eVar, final boolean z) {
        return eVar.o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4991f.c(z, (Throwable) obj);
            }
        });
    }

    public static boolean isUrlBaseCache(String str) {
        return str != null && str.contains(BuildConfig.APTOIDE_WEB_SERVICES_V7_CACHE_HOST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleToken$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(boolean z, Throwable th) {
        if (!(th instanceof AptoideWsV7Exception)) {
            return rx.e.C(th);
        }
        if (!"AUTH-2".equals(((AptoideWsV7Exception) th).getBaseResponse().getError().getCode())) {
            return rx.e.C(th);
        }
        if (this.accessTokenRetry) {
            return rx.e.C(new NetworkErrorException());
        }
        this.accessTokenRetry = true;
        return this.tokenInvalidator.invalidateAccessToken().j(500L, TimeUnit.MILLISECONDS).b(observe(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observe$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Object d(boolean z, Object obj) {
        return handleToken(retryOnTicket(super.observe(z)), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$retryOnTicket$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(Object obj) {
        BaseV7Response baseV7Response;
        if (obj instanceof Response) {
            Response response = (Response) obj;
            if (response.isSuccessful()) {
                baseV7Response = (BaseV7Response) response.body();
            } else {
                try {
                    BaseV7Response baseV7Response2 = (BaseV7Response) this.retrofit.responseBodyConverter(BaseV7Response.class, new Annotation[0]).convert(((Response) obj).errorBody());
                    if (response.code() == 401) {
                        AptoideWsV7Exception aptoideWsV7Exception = new AptoideWsV7Exception();
                        aptoideWsV7Exception.setBaseResponse(baseV7Response2);
                        return rx.e.C(aptoideWsV7Exception);
                    }
                    baseV7Response = baseV7Response2;
                } catch (IOException e2) {
                    return rx.e.C(e2);
                }
            }
        } else {
            baseV7Response = (BaseV7Response) obj;
        }
        return (baseV7Response.getInfo() == null || !BaseV7Response.Info.Status.QUEUED.equals(baseV7Response.getInfo().getStatus())) ? rx.e.S(obj) : rx.e.C(new ToRetryThrowable());
    }

    private /* synthetic */ Object lambda$retryOnTicket$2(Throwable th, Integer num) {
        if ((th instanceof ToRetryThrowable) && num.intValue() < 3) {
            return null;
        }
        if (isNoNetworkException(th)) {
            throw new NoNetworkConnectionException(th);
        }
        if (th instanceof AptoideWsV7Exception) {
            throw ((AptoideWsV7Exception) th);
        }
        if (!(th instanceof HttpException)) {
            throw new RuntimeException(th);
        }
        try {
            AptoideWsV7Exception aptoideWsV7Exception = new AptoideWsV7Exception(th);
            aptoideWsV7Exception.setBaseResponse((BaseV7Response) this.converterFactory.responseBodyConverter(BaseV7Response.class, null, null).convert(((HttpException) th).response().errorBody()));
            throw aptoideWsV7Exception;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$retryOnTicket$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(rx.e eVar) {
        return eVar.e1(rx.e.r0(1, 3), new rx.m.f() { // from class: cm.aptoide.pt.dataprovider.ws.v7.g
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                this.f5002f.f((Throwable) obj, (Integer) obj2);
                return null;
            }
        }).q(500L, TimeUnit.MILLISECONDS);
    }

    private rx.e<U> retryOnTicket(rx.e<U> eVar) {
        return eVar.I0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4988f.e(obj);
            }
        }).t0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4999f.g((rx.e) obj);
            }
        });
    }

    public /* synthetic */ Object f(Throwable th, Integer num) {
        lambda$retryOnTicket$2(th, num);
        return null;
    }

    public B getBody() {
        return this.body;
    }

    protected QueryStringMapper getQueryStringMapper() {
        if (this.queryStringMapper == null) {
            this.queryStringMapper = new QueryStringMapper();
        }
        return this.queryStringMapper;
    }

    protected TokenInvalidator getTokenInvalidator() {
        return this.tokenInvalidator;
    }

    public rx.e<U> observe(boolean z, boolean z2) {
        B b2 = this.body;
        if (b2 != null) {
            b2.setRefresh(z2);
        }
        return observe(z);
    }

    @Override // cm.aptoide.pt.dataprovider.WebService
    public rx.e<U> observe(final boolean z) {
        B b2 = this.body;
        if (b2 == null) {
            return handleToken(retryOnTicket(super.observe(z)), z);
        }
        return this.bodyInterceptor.intercept(b2).k(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4995f.d(z, obj);
            }
        });
    }
}
