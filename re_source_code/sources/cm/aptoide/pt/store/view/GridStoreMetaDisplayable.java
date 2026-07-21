package cm.aptoide.pt.store.view;

import android.content.SharedPreferences;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.R;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.store.GetHomeMeta;
import cm.aptoide.pt.dataprovider.model.v7.store.HomeUser;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.store.GetHomeMetaRequest;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.navigator.Result;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;
import java.util.Iterator;
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class GridStoreMetaDisplayable extends DisplayablePojo<GetHomeMeta> {
    public static final int REQUEST_CODE = 53298475;
    private AptoideAccountManager aptoideAccountManager;
    private BadgeDialogFactory badgeDialogFactory;
    private BodyInterceptor<BaseBody> bodyInterceptorV7;
    private OkHttpClient client;
    private Converter.Factory converter;
    private FragmentNavigator fragmentNavigator;
    private SharedPreferences sharedPreferences;
    private StoreAnalytics storeAnalytics;
    private StoreCredentialsProvider storeCredentialsProvider;
    private RoomStoreRepository storeRepository;
    private StoreUtilsProxy storeUtilsProxy;
    private ThemeManager themeManager;
    private TokenInvalidator tokenInvalidator;

    /* JADX INFO: renamed from: cm.aptoide.pt.store.view.GridStoreMetaDisplayable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType;

        static {
            int[] iArr = new int[Store.BadgeType.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType = iArr;
            try {
                iArr[Store.BadgeType.BRONZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType[Store.BadgeType.SILVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType[Store.BadgeType.GOLD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType[Store.BadgeType.PLATINUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType[Store.BadgeType.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public GridStoreMetaDisplayable() {
    }

    private Store getStore() {
        return getPojo().getData().getStore();
    }

    private HomeUser getUser() {
        return getPojo().getData().getUser();
    }

    private String getUserName() {
        if (getUser() == null) {
            return null;
        }
        return getUser().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getHomeMeta$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(GetHomeMeta getHomeMeta) {
        return isFollowingStore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getHomeMeta$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ GridStoreMetaWidget.HomeMeta b(Boolean bool, Boolean bool2) {
        return new GridStoreMetaWidget.HomeMeta(getMainIcon(), getSecondaryIcon(), getMainName(), getSecondaryName(), bool2.booleanValue(), hasStore(), bool.booleanValue(), getAppsCount(), getFollowersCount(), getFollowingsCount(), getDescription(), this.themeManager.getStoreTheme(getStoreThemeName()), this.themeManager.getAttributeForTheme(R.attr.themeTextColor).data, getStoreId(), hasStore(), getBadge());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getHomeMeta$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(AptoideAccountManager aptoideAccountManager, final Boolean bool) {
        return isStoreOwner(aptoideAccountManager).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7620f.b(bool, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$isFollowingStore$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((RoomStore) it.next()).getStoreName().equals(getStoreName())) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$isStoreOwner$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(Account account) {
        return Boolean.valueOf((getStore() == null || account.getStore() == null || !account.getStore().getName().equals(getStore().getName())) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateStoreMeta$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(Result result) {
        return GetHomeMetaRequest.of(this.storeCredentialsProvider.get(getStoreId()), this.bodyInterceptorV7, this.client, this.converter, this.tokenInvalidator, this.sharedPreferences).observe(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateStoreMeta$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(GetHomeMeta getHomeMeta) {
        setPojo(getHomeMeta);
    }

    private rx.e<GetHomeMeta> updateStoreMeta() {
        return this.fragmentNavigator.results(REQUEST_CODE).D(new rx.m.e() { // from class: cm.aptoide.pt.store.view.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Result) obj).getResultCode() == -1);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7614f.f((Result) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7624f.g((GetHomeMeta) obj);
            }
        });
    }

    public long getAppsCount() {
        Store store = getStore();
        if (store != null) {
            return store.getStats().getApps();
        }
        return 0L;
    }

    public AptoideAccountManager getAptoideAccountManager() {
        return this.aptoideAccountManager;
    }

    public GridStoreMetaWidget.HomeMeta.Badge getBadge() {
        if (!hasStore()) {
            return GridStoreMetaWidget.HomeMeta.Badge.NONE;
        }
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$store$Store$BadgeType[getPojo().getData().getStore().getBadge().getName().ordinal()];
        if (i2 == 1) {
            return GridStoreMetaWidget.HomeMeta.Badge.BRONZE;
        }
        if (i2 == 2) {
            return GridStoreMetaWidget.HomeMeta.Badge.SILVER;
        }
        if (i2 == 3) {
            return GridStoreMetaWidget.HomeMeta.Badge.GOLD;
        }
        if (i2 != 4) {
            return i2 != 5 ? GridStoreMetaWidget.HomeMeta.Badge.NONE : GridStoreMetaWidget.HomeMeta.Badge.TIN;
        }
        return GridStoreMetaWidget.HomeMeta.Badge.PLATINUM;
    }

    public BadgeDialogFactory getBadgeDialogFactory() {
        return this.badgeDialogFactory;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public String getDescription() {
        Store store = getStore();
        if (store != null) {
            return store.getAppearance().getDescription();
        }
        return null;
    }

    public long getFollowersCount() {
        return getPojo().getData().getStats().getFollowers();
    }

    public long getFollowingsCount() {
        return getPojo().getData().getStats().getFollowing();
    }

    public rx.e<GridStoreMetaWidget.HomeMeta> getHomeMeta(final AptoideAccountManager aptoideAccountManager) {
        return rx.e.a0(isFollowingStore(), updateStoreMeta().G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7630f.a((GetHomeMeta) obj);
            }
        }).E()).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7601f.c(aptoideAccountManager, (Boolean) obj);
            }
        });
    }

    public String getMainIcon() {
        return getStore() != null ? getStore().getAvatar() : getUserIcon();
    }

    public String getMainName() {
        Store store = getStore();
        return store != null ? store.getName() : getUserName();
    }

    public int getRaisedButtonBackground() {
        return this.themeManager.getAttributeForTheme(R.attr.raisedButtonSecondaryBackground).resourceId;
    }

    public int getRequestCode() {
        return REQUEST_CODE;
    }

    public String getSecondaryIcon() {
        if (getStore() == null) {
            return null;
        }
        return getUserIcon();
    }

    public String getSecondaryName() {
        if (getStore() != null) {
            return getUserName();
        }
        return null;
    }

    public StoreAnalytics getStoreAnalytics() {
        return this.storeAnalytics;
    }

    public StoreCredentialsProvider getStoreCredentialsProvider() {
        return this.storeCredentialsProvider;
    }

    public long getStoreId() {
        if (getStore() == null) {
            return 0L;
        }
        return getStore().getId();
    }

    public String getStoreName() {
        return getStore().getName();
    }

    public String getStoreThemeName() {
        Store store = getStore();
        return (store == null || store.getAppearance() == null) ? BuildConfig.APTOIDE_THEME : store.getAppearance().getTheme();
    }

    public StoreUtilsProxy getStoreUtilsProxy() {
        return this.storeUtilsProxy;
    }

    public String getUserIcon() {
        if (getUser() != null) {
            return getUser().getAvatar();
        }
        return null;
    }

    public long getUserId() {
        return getUser().getId();
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_store_meta;
    }

    public boolean hasStore() {
        return getStore() != null;
    }

    public boolean hasUser() {
        return getUser() != null;
    }

    public rx.e<Boolean> isFollowingStore() {
        return getStore() != null ? this.storeRepository.getAll().X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7627f.d((List) obj);
            }
        }).t() : rx.e.S(Boolean.FALSE);
    }

    public rx.e<Boolean> isStoreOwner(AptoideAccountManager aptoideAccountManager) {
        return aptoideAccountManager.accountStatus().E().X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7605f.e((Account) obj);
            }
        });
    }

    public GridStoreMetaDisplayable(GetHomeMeta getHomeMeta, StoreCredentialsProvider storeCredentialsProvider, StoreAnalytics storeAnalytics, BadgeDialogFactory badgeDialogFactory, FragmentNavigator fragmentNavigator, RoomStoreRepository roomStoreRepository, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okHttpClient, Converter.Factory factory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, ThemeManager themeManager, StoreUtilsProxy storeUtilsProxy, AptoideAccountManager aptoideAccountManager) {
        super(getHomeMeta);
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.storeAnalytics = storeAnalytics;
        this.badgeDialogFactory = badgeDialogFactory;
        this.fragmentNavigator = fragmentNavigator;
        this.storeRepository = roomStoreRepository;
        this.bodyInterceptorV7 = bodyInterceptor;
        this.client = okHttpClient;
        this.converter = factory;
        this.tokenInvalidator = tokenInvalidator;
        this.sharedPreferences = sharedPreferences;
        this.themeManager = themeManager;
        this.storeUtilsProxy = storeUtilsProxy;
        this.aptoideAccountManager = aptoideAccountManager;
    }
}
