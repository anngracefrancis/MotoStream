package cm.aptoide.pt.dataprovider.ws.v7;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.util.Pair;
import android.view.WindowManager;
import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.Layout;
import cm.aptoide.pt.dataprovider.model.v7.ListAppCoinsCampaigns;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.model.v7.ListFullReviews;
import cm.aptoide.pt.dataprovider.model.v7.TimelineStats;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreDisplays;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.AdsApplicationVersionCodeProvider;
import cm.aptoide.pt.dataprovider.ws.v2.aptwords.GetAdsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.home.ActionItemResponse;
import cm.aptoide.pt.dataprovider.ws.v7.home.BonusAppcBundle;
import cm.aptoide.pt.dataprovider.ws.v7.home.EditorialActionItem;
import cm.aptoide.pt.dataprovider.ws.v7.home.GetActionItemRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreListRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetMyStoreMetaRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreDisplaysRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreMetaRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.ListStoresRequest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class WSWidgetsUtils {
    private static final String USER_DONT_HAVE_STORE_ERROR = "MYSTORE-1";
    private static final String USER_NOT_LOGGED_ERROR = "AUTH-5";

    /* JADX INFO: renamed from: cm.aptoide.pt.dataprovider.ws.v7.WSWidgetsUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type = iArr;
            try {
                iArr[Type.APPCOINS_FEATURED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_TOP_GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPS_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.DISPLAYS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ADS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APPCOINS_ADS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.HOME_META.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.COMMENTS_GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.REVIEWS_GROUP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORES_SUBSCRIBED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_RECOMMENDED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORE_META.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORE_META.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.NEW_APP_VERSION.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.NEW_APP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.NEWS_ITEM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.IN_GAME_EVENT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ACTION_ITEM.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.APP_COMING_SOON.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    private TimelineStats createErrorTimelineStatus() {
        TimelineStats timelineStats = new TimelineStats();
        TimelineStats.StatusData statusData = new TimelineStats.StatusData();
        statusData.setFollowers(0L);
        statusData.setFollowing(0L);
        timelineStats.setData(statusData);
        return timelineStats;
    }

    static /* synthetic */ BonusAppcBundle lambda$loadWidgetNode$0(ListApps listApps, BonusAppcModel bonusAppcModel) {
        return new BonusAppcBundle(listApps, bonusAppcModel);
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$12(GetStoreWidgets.WSWidget wSWidget, GetStoreDisplays getStoreDisplays) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$15(GetStoreWidgets.WSWidget wSWidget, GetAdsResponse getAdsResponse) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$18(GetStoreWidgets.WSWidget wSWidget, ListAppCoinsCampaigns listAppCoinsCampaigns) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$21(GetStoreWidgets.WSWidget wSWidget, GetHomeMeta getHomeMeta) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$24(GetStoreWidgets.WSWidget wSWidget, ListComments listComments) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$27(GetStoreWidgets.WSWidget wSWidget, ListFullReviews listFullReviews) {
        return wSWidget;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadWidgetNode$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(GetStoreWidgets.WSWidget wSWidget, Throwable th) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(USER_NOT_LOGGED_ERROR);
        if ((th instanceof AptoideWsV7Exception) && shouldAddObjectView(linkedList, th)) {
            wSWidget.setViewObject(((AptoideWsV7Exception) th).getBaseResponse());
        }
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$3(GetStoreWidgets.WSWidget wSWidget, BonusAppcBundle bonusAppcBundle) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$31(GetStoreWidgets.WSWidget wSWidget, ListStores listStores) {
        return wSWidget;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadWidgetNode$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ TimelineStats b(Throwable th) {
        return createErrorTimelineStatus();
    }

    static /* synthetic */ GetHomeMeta lambda$loadWidgetNode$33(GetStoreMeta getStoreMeta) {
        GetHomeMeta.Data data = new GetHomeMeta.Data();
        data.setStore(getStoreMeta.getData());
        GetHomeMeta getHomeMeta = new GetHomeMeta();
        getHomeMeta.setData(data);
        return getHomeMeta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadWidgetNode$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(Throwable th) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(USER_NOT_LOGGED_ERROR);
        linkedList.add(USER_DONT_HAVE_STORE_ERROR);
        return shouldAddObjectView(linkedList, th) ? rx.e.S(null) : rx.e.C(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadWidgetNode$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ MyStore d(TimelineStats timelineStats, GetHomeMeta getHomeMeta) {
        return timelineStats.getData() == null ? new MyStore(createErrorTimelineStatus(), getHomeMeta) : new MyStore(timelineStats, getHomeMeta);
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$38(GetStoreWidgets.WSWidget wSWidget, MyStore myStore) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$41(GetStoreWidgets.WSWidget wSWidget, GetStoreMeta getStoreMeta) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$43(GetStoreWidgets.WSWidget wSWidget, AppPromoItem appPromoItem) {
        return wSWidget;
    }

    static /* synthetic */ NewAppCoinsAppPromoItem lambda$loadWidgetNode$44(GetApp getApp, BonusAppcModel bonusAppcModel) {
        return new NewAppCoinsAppPromoItem(getApp, bonusAppcModel);
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$47(GetStoreWidgets.WSWidget wSWidget, NewAppCoinsAppPromoItem newAppCoinsAppPromoItem) {
        return wSWidget;
    }

    static /* synthetic */ EditorialActionItem lambda$loadWidgetNode$48(ActionItemResponse actionItemResponse, BonusAppcModel bonusAppcModel) {
        return new EditorialActionItem(actionItemResponse, bonusAppcModel);
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$52(GetStoreWidgets.WSWidget wSWidget, EditorialActionItem editorialActionItem) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$55(GetStoreWidgets.WSWidget wSWidget, ActionItemResponse actionItemResponse) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$58(GetStoreWidgets.WSWidget wSWidget, ActionItemResponse actionItemResponse) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$6(GetStoreWidgets.WSWidget wSWidget, ListApps listApps) {
        return wSWidget;
    }

    static /* synthetic */ GetStoreWidgets.WSWidget lambda$loadWidgetNode$9(GetStoreWidgets.WSWidget wSWidget, ListStores listStores) {
        return wSWidget;
    }

    private rx.e<ActionItemResponse> loadActionItem(String str, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, boolean z, boolean z2) {
        return GetActionItemRequest.ofAction(str, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z2).j0(Schedulers.io());
    }

    private rx.e<BonusAppcModel> loadAppcBonusModel(AppCoinsManager appCoinsManager) {
        return g.a.a.a.d.d(appCoinsManager.getBonusAppc()).A().w(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    private rx.e<ListApps> loadListApps(String str, BaseRequestWithStore.StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, boolean z, boolean z2) {
        return ListAppsRequest.ofAction(str, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, resources, windowManager).observe(z, z2);
    }

    public rx.e<GetStoreWidgets.WSWidget> loadWidgetNode(final GetStoreWidgets.WSWidget wSWidget, final BaseRequestWithStore.StoreCredentials storeCredentials, boolean z, String str, boolean z2, String str2, boolean z3, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, String str3, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager, ConnectivityManager connectivityManager, AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider, boolean z4, int i2, List<String> list, AppCoinsManager appCoinsManager) {
        if (wSWidget.getType() == null) {
            return rx.e.B();
        }
        String strReplace = null;
        if (wSWidget.getView() != null) {
            strReplace = V7.isUrlBaseCache(wSWidget.getView()) ? wSWidget.getView().replace(V7.getCacheHost(sharedPreferences), HttpUrl.FRAGMENT_ENCODE_SET) : wSWidget.getView().replace(V7.getHost(sharedPreferences), HttpUrl.FRAGMENT_ENCODE_SET);
        }
        String str4 = strReplace;
        if (wSWidget.getTag().equals("appcoins-iab-featured")) {
            wSWidget.setType(Type.APPCOINS_FEATURED);
        }
        switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[wSWidget.getType().ordinal()]) {
            case 1:
                return rx.e.d1(loadListApps(str4, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, resources, windowManager, z, z4), loadAppcBonusModel(appCoinsManager), new rx.m.f() { // from class: cm.aptoide.pt.dataprovider.ws.v7.m
                    @Override // rx.m.f
                    public final Object a(Object obj, Object obj2) {
                        return WSWidgetsUtils.lambda$loadWidgetNode$0((ListApps) obj, (BonusAppcModel) obj2);
                    }
                }).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.g1
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((BonusAppcBundle) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.x
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.n
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$3(wSWidget2, (BonusAppcBundle) obj);
                        return wSWidget2;
                    }
                });
            case 2:
            case 3:
                return loadListApps(str4, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, resources, windowManager, z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.v
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ListApps) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.w
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.l1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$6(wSWidget2, (ListApps) obj);
                        return wSWidget2;
                    }
                });
            case 4:
                return ListStoresRequest.ofAction(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.j0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ListStores) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.j
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.k1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$9(wSWidget2, (ListStores) obj);
                        return wSWidget2;
                    }
                });
            case 5:
                return GetStoreDisplaysRequest.ofAction(str4, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.f0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((GetStoreDisplays) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.x0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.b0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$12(wSWidget2, (GetStoreDisplays) obj);
                        return wSWidget2;
                    }
                });
            case 6:
                return GetAdsRequest.ofHomepage(str, z2, str2, z3, okHttpClient, factory, str3, sharedPreferences, resources, connectivityManager, adsApplicationVersionCodeProvider, i2).observe(z).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.h0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((GetAdsResponse) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.p
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.p0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$15(wSWidget2, (GetAdsResponse) obj);
                        return wSWidget2;
                    }
                });
            case 7:
                return new GetAppCoinsCampaignsRequest(new GetAppCoinsCampaignsRequest.Body(0, i2), okHttpClient, factory, bodyInterceptor, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.s
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ListAppCoinsCampaigns) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.r
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.n1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$18(wSWidget2, (ListAppCoinsCampaigns) obj);
                        return wSWidget2;
                    }
                });
            case 8:
                return GetHomeMetaRequest.ofAction(str4, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.a0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((GetHomeMeta) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.t0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.i1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$21(wSWidget2, (GetHomeMeta) obj);
                        return wSWidget2;
                    }
                });
            case 9:
                return ListCommentsRequest.ofStoreAction(str4, z, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.h1
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject(new Pair((ListComments) obj, storeCredentials));
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.o
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.i0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$24(wSWidget2, (ListComments) obj);
                        return wSWidget2;
                    }
                });
            case 10:
                return ListFullReviewsRequest.ofAction(str4, z, storeCredentials, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.v0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ListFullReviews) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.f1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.y
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$27(wSWidget2, (ListFullReviews) obj);
                        return wSWidget2;
                    }
                });
            case 11:
            case 12:
                return GetMyStoreListRequest.of(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, resources, windowManager).observe(z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.j1
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ListStores) obj);
                    }
                }).w(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.o0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        this.f5041f.a(wSWidget, (Throwable) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.s0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.a1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$31(wSWidget2, (ListStores) obj);
                        return wSWidget2;
                    }
                });
            case 13:
                return rx.e.d1(GetTimelineStatsRequest.of(bodyInterceptor, null, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).p0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.d0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return this.f4993f.b((Throwable) obj);
                    }
                }), GetMyStoreMetaRequest.of(bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.h
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return WSWidgetsUtils.lambda$loadWidgetNode$33((GetStoreMeta) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.m0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return this.f5035f.c((Throwable) obj);
                    }
                }), new rx.m.f() { // from class: cm.aptoide.pt.dataprovider.ws.v7.q
                    @Override // rx.m.f
                    public final Object a(Object obj, Object obj2) {
                        return this.f5046f.d((TimelineStats) obj, (GetHomeMeta) obj2);
                    }
                }).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.u0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((MyStore) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.z
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.g0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$38(wSWidget2, (MyStore) obj);
                        return wSWidget2;
                    }
                });
            case 14:
                return GetStoreMetaRequest.ofAction(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.c1
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((GetStoreMeta) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.w0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.k0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$41(wSWidget2, (GetStoreMeta) obj);
                        return wSWidget2;
                    }
                });
            case 15:
                return GetAppMetaRequest.ofAction(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4).j0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.b
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return new AppPromoItem((GetApp) obj);
                    }
                }).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.a
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((AppPromoItem) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.i
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.e0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$43(wSWidget2, (AppPromoItem) obj);
                        return wSWidget2;
                    }
                });
            case 16:
                return rx.e.d1(GetAppMetaRequest.ofAction(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences).observe(z, z4), loadAppcBonusModel(appCoinsManager), new rx.m.f() { // from class: cm.aptoide.pt.dataprovider.ws.v7.t
                    @Override // rx.m.f
                    public final Object a(Object obj, Object obj2) {
                        return WSWidgetsUtils.lambda$loadWidgetNode$44((GetApp) obj, (BonusAppcModel) obj2);
                    }
                }).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.l
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((NewAppCoinsAppPromoItem) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.z0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.c0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$47(wSWidget2, (NewAppCoinsAppPromoItem) obj);
                        return wSWidget2;
                    }
                });
            case 17:
            case 18:
            case 19:
                return (wSWidget.getData().getLayout().equals(Layout.CURATION_1) || wSWidget.getData().getLayout().equals(Layout.PROMO_GRAPHIC)) ? rx.e.d1(loadActionItem(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, z, z4), loadAppcBonusModel(appCoinsManager), new rx.m.f() { // from class: cm.aptoide.pt.dataprovider.ws.v7.u
                    @Override // rx.m.f
                    public final Object a(Object obj, Object obj2) {
                        return WSWidgetsUtils.lambda$loadWidgetNode$48((ActionItemResponse) obj, (BonusAppcModel) obj2);
                    }
                }).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.d1
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((EditorialActionItem) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.k
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).w(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.r0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        ((Throwable) obj).printStackTrace();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.e1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$52(wSWidget2, (EditorialActionItem) obj);
                        return wSWidget2;
                    }
                }) : loadActionItem(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.n0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ActionItemResponse) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.b1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.q0
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$55(wSWidget2, (ActionItemResponse) obj);
                        return wSWidget2;
                    }
                });
            case 20:
                return loadActionItem(str4, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, z, z4).j0(Schedulers.io()).x(new rx.m.b() { // from class: cm.aptoide.pt.dataprovider.ws.v7.y0
                    @Override // rx.m.b
                    public final void call(Object obj) {
                        wSWidget.setViewObject((ActionItemResponse) obj);
                    }
                }).o0(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.o1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        return rx.e.B();
                    }
                }).X(new rx.m.e() { // from class: cm.aptoide.pt.dataprovider.ws.v7.m1
                    @Override // rx.m.e
                    public final Object call(Object obj) {
                        GetStoreWidgets.WSWidget wSWidget2 = wSWidget;
                        WSWidgetsUtils.lambda$loadWidgetNode$58(wSWidget2, (ActionItemResponse) obj);
                        return wSWidget2;
                    }
                });
            default:
                return rx.e.B();
        }
    }

    @Deprecated
    public boolean shouldAddObjectView(List<String> list, Throwable th) {
        if (!(th instanceof AptoideWsV7Exception)) {
            return false;
        }
        Iterator<BaseV7Response.Error> it = ((AptoideWsV7Exception) th).getBaseResponse().getErrors().iterator();
        while (it.hasNext()) {
            if (list.contains(it.next().getCode())) {
                return true;
            }
        }
        return false;
    }
}
