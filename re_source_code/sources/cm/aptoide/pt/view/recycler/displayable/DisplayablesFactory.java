package cm.aptoide.pt.view.recycler.displayable;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.MyStoreManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.LoginDisplayable;
import cm.aptoide.pt.account.view.user.CreateStoreDisplayable;
import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.app.view.GridAppDisplayable;
import cm.aptoide.pt.app.view.GridAppListDisplayable;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v2.GetAdsResponse;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.Layout;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.model.v7.TimelineStats;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreDisplays;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.MyStore;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.store.view.BadgeDialogFactory;
import cm.aptoide.pt.store.view.GridDisplayDisplayable;
import cm.aptoide.pt.store.view.GridStoreDisplayable;
import cm.aptoide.pt.store.view.GridStoreMetaDisplayable;
import cm.aptoide.pt.store.view.StoreAddCommentDisplayable;
import cm.aptoide.pt.store.view.StoreGridHeaderDisplayable;
import cm.aptoide.pt.store.view.StoreLatestCommentsDisplayable;
import cm.aptoide.pt.store.view.StoreTabNavigator;
import cm.aptoide.pt.store.view.featured.AppBrickDisplayable;
import cm.aptoide.pt.store.view.my.StoreDisplayable;
import cm.aptoide.pt.store.view.recommended.RecommendedStoreDisplayable;
import cm.aptoide.pt.themes.StoreTheme;
import cm.aptoide.pt.themes.ThemeManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.e;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class DisplayablesFactory {

    /* JADX INFO: renamed from: cm.aptoide.pt.view.recycler.displayable.DisplayablesFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type = iArr;
            try {
                iArr[Type.APPS_GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORES_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.DISPLAYS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.ADS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.HOME_META.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.MY_STORE_META.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORE_META.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.STORES_RECOMMENDED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[Type.COMMENTS_GROUP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static List<Displayable> createCommentsGroup(String str, GetStoreWidgets.WSWidget wSWidget, StoreTheme storeTheme, String str2, StoreContext storeContext, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, ThemeManager themeManager) {
        LinkedList linkedList = new LinkedList();
        Pair pair = (Pair) wSWidget.getViewObject();
        ListComments listComments = (ListComments) pair.first;
        linkedList.add(new StoreGridHeaderDisplayable(str, wSWidget, storeTheme.getThemeName(), str2, storeContext, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(storeTheme.getThemeName(), R.attr.themeTextColor).data));
        if (listComments == null || listComments.getDataList() == null || listComments.getDataList().getList().size() <= 0) {
            linkedList.add(new StoreAddCommentDisplayable(((BaseRequestWithStore.StoreCredentials) pair.second).getId().longValue(), ((BaseRequestWithStore.StoreCredentials) pair.second).getName(), storeTheme, themeManager.getAttributeForTheme(storeTheme.getThemeName(), R.attr.raisedButtonSecondaryBackground).resourceId));
        } else {
            linkedList.add(new StoreLatestCommentsDisplayable(((BaseRequestWithStore.StoreCredentials) pair.second).getId().longValue(), ((BaseRequestWithStore.StoreCredentials) pair.second).getName(), listComments.getDataList().getList(), themeManager));
        }
        return linkedList;
    }

    private static List<Displayable> createMyStoreDisplayables(Object obj, StoreAnalytics storeAnalytics, StoreContext storeContext, AptoideAccountManager aptoideAccountManager, Context context, String str, ThemeManager themeManager) {
        LinkedList linkedList = new LinkedList();
        if (obj instanceof MyStore) {
            MyStore myStore = (MyStore) obj;
            if (!myStore.isCreateStore()) {
                TimelineStats.StatusData data = myStore.getTimelineStats().getData();
                linkedList.add(new StoreDisplayable(myStore.getGetHomeMeta().getData().getStore(), storeContext, data.getFollowing(), data.getFollowers(), R.string.storetab_short_followings, R.string.storetab_short_followers, true, getStoreDescriptionMessage(context, myStore.getGetHomeMeta().getData().getStore()), themeManager.getAttributeForTheme(str, R.attr.themeTextColor).data));
            } else if (!aptoideAccountManager.isLoggedIn()) {
                linkedList.add(new LoginDisplayable());
            } else if (MyStoreManager.shouldShowCreateStore()) {
                linkedList.add(new CreateStoreDisplayable(storeAnalytics, myStore.getTimelineStats(), themeManager.getAttributeForTheme(R.attr.themeTextColor).data));
            }
        }
        return linkedList;
    }

    private static Displayable createRecommendedStores(String str, GetStoreWidgets.WSWidget wSWidget, String str2, RoomStoreRepository roomStoreRepository, StoreCredentialsProvider storeCredentialsProvider, StoreContext storeContext, Context context, AptoideAccountManager aptoideAccountManager, StoreUtilsProxy storeUtilsProxy, WindowManager windowManager, Resources resources, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, ThemeManager themeManager) {
        ListStores listStores = (ListStores) wSWidget.getViewObject();
        if (listStores == null) {
            return new EmptyDisplayable();
        }
        List<Store> list = listStores.getDataList().getList();
        LinkedList linkedList = new LinkedList();
        linkedList.add(new StoreGridHeaderDisplayable(str, wSWidget, str2, wSWidget.getTag(), storeContext, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(str2, R.attr.themeTextColor).data));
        for (Store store : list) {
            if (wSWidget.getData().getLayout() == Layout.LIST) {
                linkedList.add(new RecommendedStoreDisplayable(store, roomStoreRepository, aptoideAccountManager, storeUtilsProxy, storeCredentialsProvider));
            } else {
                linkedList.add(new GridStoreDisplayable(store));
            }
        }
        return new DisplayableGroup(linkedList, windowManager, resources);
    }

    private static List<Displayable> createStoreDisplayables(Object obj, StoreContext storeContext, String str, ThemeManager themeManager) {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof GetStoreMeta) {
            Store data = ((GetStoreMeta) obj).getData();
            arrayList.add(new StoreDisplayable(data, storeContext, data.getStats().getApps(), data.getStats().getDownloads(), R.string.storehometab_short_apps, R.string.storehometab_short_downloads, false, data.getAppearance().getDescription(), themeManager.getAttributeForTheme(str, R.attr.themeTextColor).data));
        }
        return arrayList;
    }

    private static List<Displayable> getAds(GetStoreWidgets.WSWidget wSWidget, MinimalAdMapper minimalAdMapper, NavigationTracker navigationTracker) {
        GetAdsResponse getAdsResponse = (GetAdsResponse) wSWidget.getViewObject();
        if (getAdsResponse == null || getAdsResponse.getAds() == null || getAdsResponse.getAds().size() <= 0) {
            return Collections.emptyList();
        }
        List<GetAdsResponse.Ad> ads = getAdsResponse.getAds();
        ArrayList arrayList = new ArrayList(ads.size());
        Iterator<GetAdsResponse.Ad> it = ads.iterator();
        while (it.hasNext()) {
            arrayList.add(new GridAdDisplayable(minimalAdMapper.map(it.next()), wSWidget.getTag(), navigationTracker));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    private static Displayable getApps(String str, GetStoreWidgets.WSWidget wSWidget, String str2, StoreContext storeContext, Resources resources, WindowManager windowManager, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, ThemeManager themeManager) {
        boolean z;
        ListApps listApps = (ListApps) wSWidget.getViewObject();
        if (listApps == null) {
            return new EmptyDisplayable();
        }
        List<App> list = listApps.getDataList().getList();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<App> it = list.iterator();
        while (it.hasNext()) {
            it.next().getStore().setAppearance(new Store.Appearance(str2, null));
        }
        if (Layout.BRICK.equals(wSWidget.getData().getLayout())) {
            if (list.size() > 0) {
                boolean z2 = resources.getBoolean(R.bool.use_big_app_brick);
                int iMin = Math.min(resources.getInteger(R.integer.nr_small_app_bricks), list.size());
                if (list.size() == 1) {
                    z = true;
                } else if (list.size() == 2) {
                    z = z2;
                    z = false;
                }
                if (z) {
                    arrayList.add(new AppBrickDisplayable(list.get(0), wSWidget.getTag(), navigationTracker).setFullRow());
                    iMin++;
                }
                if (list.size() > 1) {
                    for (?? r0 = z; r0 < iMin; r0++) {
                        arrayList.add(new AppBrickDisplayable(list.get(r0), wSWidget.getTag(), navigationTracker));
                    }
                }
            }
        } else if (Layout.LIST.equals(wSWidget.getData().getLayout())) {
            if (list.size() > 0) {
                arrayList.add(new StoreGridHeaderDisplayable(str, wSWidget, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(str2, R.attr.themeTextColor).data));
            }
            Iterator<App> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(new GridAppListDisplayable(it2.next(), wSWidget.getTag()));
            }
        } else {
            if (list.size() > 0) {
                arrayList.add(new StoreGridHeaderDisplayable(str, wSWidget, str2, wSWidget.getTag(), storeContext, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(str2, R.attr.themeTextColor).data));
            }
            Iterator<App> it3 = list.iterator();
            while (it3.hasNext()) {
                arrayList.add(new GridAppDisplayable(it3.next(), wSWidget.getTag(), navigationTracker, storeContext));
            }
        }
        return new DisplayableGroup(arrayList, windowManager, resources);
    }

    private static Displayable getDisplays(GetStoreWidgets.WSWidget wSWidget, String str, StoreContext storeContext, WindowManager windowManager, Resources resources, AptoideInstalledAppsRepository aptoideInstalledAppsRepository) {
        GetStoreDisplays getStoreDisplays = (GetStoreDisplays) wSWidget.getViewObject();
        if (getStoreDisplays == null) {
            return new EmptyDisplayable();
        }
        List<GetStoreDisplays.EventImage> list = getStoreDisplays.getList();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<GetStoreDisplays.EventImage> it = list.iterator();
        while (it.hasNext()) {
            GridDisplayDisplayable gridDisplayDisplayable = new GridDisplayDisplayable(it.next(), str, wSWidget.getTag(), storeContext, aptoideInstalledAppsRepository);
            Event.Name name = gridDisplayDisplayable.getPojo().getEvent().getName();
            if (Event.Name.facebook.equals(name) || Event.Name.twitch.equals(name) || Event.Name.youtube.equals(name)) {
                gridDisplayDisplayable.setFullRow();
            }
            arrayList.add(gridDisplayDisplayable);
        }
        return new DisplayableGroup(arrayList, windowManager, resources);
    }

    private static e<Displayable> getMyStores(final String str, final GetStoreWidgets.WSWidget wSWidget, RoomStoreRepository roomStoreRepository, final String str2, final StoreContext storeContext, final WindowManager windowManager, final Resources resources, Context context, final StoreAnalytics storeAnalytics, final StoreTabNavigator storeTabNavigator, final NavigationTracker navigationTracker, final ThemeManager themeManager) {
        return loadLocalSubscribedStores(roomStoreRepository).X(new rx.m.e() { // from class: cm.aptoide.pt.view.recycler.displayable.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DisplayablesFactory.lambda$getMyStores$1(wSWidget, storeAnalytics, str, str2, storeContext, storeTabNavigator, navigationTracker, themeManager, windowManager, resources, (List) obj);
            }
        });
    }

    private static String getStoreDescriptionMessage(Context context, Store store) {
        return TextUtils.isEmpty(store.getAppearance().getDescription()) ? context.getString(R.string.create_store_displayable_empty_description_message) : store.getAppearance().getDescription();
    }

    private static Displayable getStores(String str, GetStoreWidgets.WSWidget wSWidget, String str2, StoreContext storeContext, WindowManager windowManager, Resources resources, Context context, StoreAnalytics storeAnalytics, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, ThemeManager themeManager) {
        ListStores listStores = (ListStores) wSWidget.getViewObject();
        if (listStores == null) {
            return new EmptyDisplayable();
        }
        List<Store> list = listStores.getDataList().getList();
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add(new StoreGridHeaderDisplayable(str, wSWidget, str2, wSWidget.getTag(), storeContext, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(str2, R.attr.themeTextColor).data));
        Iterator<Store> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GridStoreDisplayable(it.next(), "Home", storeAnalytics));
        }
        return new DisplayableGroup(arrayList, windowManager, resources);
    }

    static /* synthetic */ Displayable lambda$getMyStores$1(GetStoreWidgets.WSWidget wSWidget, StoreAnalytics storeAnalytics, String str, String str2, StoreContext storeContext, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, ThemeManager themeManager, WindowManager windowManager, Resources resources, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        if (wSWidget.getViewObject() instanceof ListStores) {
            ListStores listStores = (ListStores) wSWidget.getViewObject();
            list.addAll(listStores.getDataList().getList());
            size = listStores.getDataList().getLimit().intValue() > list.size() ? list.size() : listStores.getDataList().getLimit().intValue();
        }
        Collections.sort(list, new Comparator() { // from class: cm.aptoide.pt.view.recycler.displayable.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Store) obj).getName().compareTo(((Store) obj2).getName());
            }
        });
        for (int i2 = 0; i2 < list.size() && arrayList.size() < size; i2++) {
            if (i2 == 0 || ((Store) list.get(i2 - 1)).getId() != ((Store) list.get(i2)).getId()) {
                arrayList.add(new GridStoreDisplayable((Store) list.get(i2), "Open a Followed Store", storeAnalytics));
            }
        }
        if (arrayList.size() > 0) {
            StoreGridHeaderDisplayable storeGridHeaderDisplayable = new StoreGridHeaderDisplayable(str, wSWidget, str2, wSWidget.getTag(), storeContext, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(str2, R.attr.themeTextColor).data);
            if (list.size() <= size) {
                storeGridHeaderDisplayable.getModel().setMoreVisible(false);
            }
            arrayList.add(0, storeGridHeaderDisplayable);
        }
        return new DisplayableGroup(arrayList, windowManager, resources);
    }

    static /* synthetic */ Store lambda$loadLocalSubscribedStores$2(RoomStore roomStore) {
        Store store = new Store();
        store.setName(roomStore.getStoreName());
        store.setId(roomStore.getStoreId());
        store.setAvatar(roomStore.getIconPath());
        Store.Appearance appearance = new Store.Appearance();
        appearance.setTheme(roomStore.getTheme());
        store.setAppearance(appearance);
        return store;
    }

    public static e<List<Store>> loadLocalSubscribedStores(RoomStoreRepository roomStoreRepository) {
        return roomStoreRepository.getAll().E().j0(Schedulers.computation()).G(new rx.m.e() { // from class: cm.aptoide.pt.view.recycler.displayable.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return e.N((List) obj).X(new rx.m.e() { // from class: cm.aptoide.pt.view.recycler.displayable.b
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        return DisplayablesFactory.lambda$loadLocalSubscribedStores$2((RoomStore) obj2);
                    }
                }).Y0();
            }
        });
    }

    public static e<Displayable> parse(String str, GetStoreWidgets.WSWidget wSWidget, String str2, RoomStoreRepository roomStoreRepository, StoreCredentialsProvider storeCredentialsProvider, StoreContext storeContext, Context context, AptoideAccountManager aptoideAccountManager, StoreUtilsProxy storeUtilsProxy, WindowManager windowManager, Resources resources, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, StoreAnalytics storeAnalytics, StoreTabNavigator storeTabNavigator, NavigationTracker navigationTracker, BadgeDialogFactory badgeDialogFactory, FragmentNavigator fragmentNavigator, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, ThemeManager themeManager) {
        LinkedList linkedList = new LinkedList();
        if (wSWidget.getType() != null && wSWidget.getViewObject() != null) {
            switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Type[wSWidget.getType().ordinal()]) {
                case 1:
                    return e.S(getApps(str, wSWidget, str2, storeContext, context.getApplicationContext().getResources(), windowManager, storeTabNavigator, navigationTracker, themeManager));
                case 2:
                    return getMyStores(str, wSWidget, roomStoreRepository, str2, storeContext, windowManager, resources, context, storeAnalytics, storeTabNavigator, navigationTracker, themeManager);
                case 3:
                    return e.S(getStores(str, wSWidget, str2, storeContext, windowManager, resources, context, storeAnalytics, storeTabNavigator, navigationTracker, themeManager));
                case 4:
                    return e.S(getDisplays(wSWidget, str2, storeContext, windowManager, resources, aptoideInstalledAppsRepository));
                case 5:
                    List<Displayable> ads = getAds(wSWidget, new MinimalAdMapper(), navigationTracker);
                    if (ads.size() <= 0) {
                        return e.B();
                    }
                    DisplayableGroup displayableGroup = new DisplayableGroup(ads, windowManager, resources);
                    LinkedList linkedList2 = new LinkedList();
                    linkedList2.add(new GetStoreWidgets.WSWidget.Action().setEvent(new Event().setName(Event.Name.getAds)));
                    wSWidget.setActions(linkedList2);
                    linkedList.add(new StoreGridHeaderDisplayable(str, wSWidget, null, wSWidget.getTag(), StoreContext.meta, storeTabNavigator, navigationTracker, themeManager.getAttributeForTheme(str2, R.attr.themeTextColor).data));
                    linkedList.add(displayableGroup);
                    return e.N(linkedList);
                case 6:
                    return e.S(new GridStoreMetaDisplayable((GetHomeMeta) wSWidget.getViewObject(), storeCredentialsProvider, storeAnalytics, badgeDialogFactory, fragmentNavigator, roomStoreRepository, bodyInterceptor, okHttpClient, factory, tokenInvalidator, sharedPreferences, themeManager, storeUtilsProxy, aptoideAccountManager));
                case 7:
                    return e.N(createMyStoreDisplayables(wSWidget.getViewObject(), storeAnalytics, storeContext, aptoideAccountManager, context, str2, themeManager));
                case 8:
                    return e.N(createStoreDisplayables(wSWidget.getViewObject(), storeContext, str2, themeManager));
                case 9:
                    return e.S(createRecommendedStores(str, wSWidget, str2, roomStoreRepository, storeCredentialsProvider, storeContext, context, aptoideAccountManager, storeUtilsProxy, windowManager, resources, storeTabNavigator, navigationTracker, themeManager));
                case 10:
                    return e.N(createCommentsGroup(str, wSWidget, themeManager.getStoreTheme(str2), wSWidget.getTag(), storeContext, storeTabNavigator, navigationTracker, themeManager));
            }
        }
        return e.B();
    }
}
