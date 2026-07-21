package cm.aptoide.pt.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AppShortcutsAnalytics;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.DeepLinkAnalytics;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.account.view.store.ManageStoreFragment;
import cm.aptoide.pt.account.view.store.ManageStoreViewModel;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.view.AppCoinsInfoFragment;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.bottomNavigation.BottomNavigationNavigator;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.model.v7.Layout;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.home.more.appcoins.EarnAppcListFragment;
import cm.aptoide.pt.install.InstallManager;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.notification.ReadyToInstallNotificationManager;
import cm.aptoide.pt.promotions.PromotionsFragment;
import cm.aptoide.pt.search.SearchNavigator;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.search.analytics.SearchSource;
import cm.aptoide.pt.search.model.SearchQueryModel;
import cm.aptoide.pt.search.model.Source;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.store.view.StoreTabFragmentChooser;
import cm.aptoide.pt.themes.NewFeature;
import cm.aptoide.pt.themes.ThemeAnalytics;
import cm.aptoide.pt.themes.ThemeManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class DeepLinkManager {
    private static final String APP_SHORTCUT = "App_Shortcut";
    public static final String DEEPLINK_KEY = "Deeplink";
    private static final String TAG = "cm.aptoide.pt.view.DeepLinkManager";
    private final AptoideAccountManager accountManager;
    private final AdsRepository adsRepository;
    private final AppNavigator appNavigator;
    private final AppShortcutsAnalytics appShortcutsAnalytics;
    private final BottomNavigationNavigator bottomNavigationNavigator;
    private final DeepLinkAnalytics deepLinkAnalytics;
    private final DeepLinkView deepLinkView;
    private final FragmentNavigator fragmentNavigator;
    private final InstallManager installManager;
    private final NavigationTracker navigationTracker;
    private final NewFeature newFeature;
    private final ReadyToInstallNotificationManager readyToInstallNotificationManager;
    private final SearchAnalytics searchAnalytics;
    private final SearchNavigator searchNavigator;
    private final SharedPreferences sharedPreferences;
    private final StoreAnalytics storeAnalytics;
    private final RoomStoreRepository storeRepository;
    private final StoreUtilsProxy storeUtilsProxy;
    private final rx.t.b subscriptions = new rx.t.b();
    private final ThemeAnalytics themeAnalytics;
    private final ThemeManager themeManager;

    public interface DeepLinkView {
        void showStoreAlreadyAdded();

        void showStoreFollowed(String str);
    }

    private static final class ShortcutDestinations {
        private static final String MY_STORE = "My_Store";
        private static final String MY_STORE_NOT_LOGGED_IN = "My_Store_Not_Logged_In";
        private static final String SEARCH = "Search";

        private ShortcutDestinations() {
        }
    }

    public DeepLinkManager(StoreUtilsProxy storeUtilsProxy, FragmentNavigator fragmentNavigator, BottomNavigationNavigator bottomNavigationNavigator, SearchNavigator searchNavigator, DeepLinkView deepLinkView, SharedPreferences sharedPreferences, RoomStoreRepository roomStoreRepository, NavigationTracker navigationTracker, SearchAnalytics searchAnalytics, AppShortcutsAnalytics appShortcutsAnalytics, AptoideAccountManager aptoideAccountManager, DeepLinkAnalytics deepLinkAnalytics, StoreAnalytics storeAnalytics, AdsRepository adsRepository, AppNavigator appNavigator, InstallManager installManager, NewFeature newFeature, ThemeManager themeManager, ThemeAnalytics themeAnalytics, ReadyToInstallNotificationManager readyToInstallNotificationManager) {
        this.storeUtilsProxy = storeUtilsProxy;
        this.fragmentNavigator = fragmentNavigator;
        this.bottomNavigationNavigator = bottomNavigationNavigator;
        this.searchNavigator = searchNavigator;
        this.deepLinkView = deepLinkView;
        this.sharedPreferences = sharedPreferences;
        this.storeRepository = roomStoreRepository;
        this.navigationTracker = navigationTracker;
        this.searchAnalytics = searchAnalytics;
        this.appShortcutsAnalytics = appShortcutsAnalytics;
        this.accountManager = aptoideAccountManager;
        this.deepLinkAnalytics = deepLinkAnalytics;
        this.storeAnalytics = storeAnalytics;
        this.adsRepository = adsRepository;
        this.appNavigator = appNavigator;
        this.installManager = installManager;
        this.newFeature = newFeature;
        this.themeManager = themeManager;
        this.themeAnalytics = themeAnalytics;
        this.readyToInstallNotificationManager = readyToInstallNotificationManager;
    }

    private void appViewDeepLink(String str) {
        this.appNavigator.navigateWithMd5(str);
    }

    private void appViewDeepLinkAutoInstall(long j2, String str) {
        this.appNavigator.navigateWithAppId(j2, str, AppViewFragment.OpenType.OPEN_AND_INSTALL, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private void appViewDeepLinkUname(String str) {
        this.appNavigator.navigateWithUname(str);
    }

    private void appcAdsDeepLink() {
        this.fragmentNavigator.navigateTo(EarnAppcListFragment.INSTANCE.newInstance("Earn AppCoins Credits", "appcoins-ads"), true);
    }

    private void appcInfoDeepLink() {
        this.fragmentNavigator.navigateTo(AppCoinsInfoFragment.newInstance(), true);
    }

    private void downloadNotificationDeepLink() {
        this.deepLinkAnalytics.downloadingUpdates();
        this.bottomNavigationNavigator.navigateToApps();
    }

    private void editorialDeepLinkFromCardId(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cardId", str);
        EditorialFragment editorialFragment = new EditorialFragment();
        editorialFragment.setArguments(bundle);
        this.fragmentNavigator.navigateTo(editorialFragment, true);
    }

    private void editorialDeepLinkFromSlug(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("slug", str);
        EditorialFragment editorialFragment = new EditorialFragment();
        editorialFragment.setArguments(bundle);
        this.fragmentNavigator.navigateTo(editorialFragment, true);
    }

    private void fromHomeDeepLink() {
        this.bottomNavigationNavigator.navigateToHome();
    }

    private void genericDeepLink(Uri uri) {
        Event event = new Event();
        String queryParameter = uri.getQueryParameter("type");
        String queryParameter2 = uri.getQueryParameter("layout");
        String queryParameter3 = uri.getQueryParameter("name");
        String queryParameter4 = uri.getQueryParameter("action");
        if (validateDeepLinkRequiredArgs(queryParameter, queryParameter2, queryParameter3, queryParameter4)) {
            try {
                String strDecode = URLDecoder.decode(queryParameter4, "UTF-8");
                event.setAction(strDecode != null ? replaceActionUrl(strDecode, this.sharedPreferences) : null);
                event.setType(Event.Type.valueOf(queryParameter));
                event.setName(Event.Name.valueOf(queryParameter3));
                GetStoreWidgets.WSWidget.Data data = new GetStoreWidgets.WSWidget.Data();
                data.setLayout(Layout.valueOf(queryParameter2));
                event.setData(data);
                this.fragmentNavigator.navigateTo(AptoideApplication.getFragmentProvider().newStoreTabGridRecyclerFragment(event, uri.getQueryParameter("title"), uri.getQueryParameter(DeepLinkIntentReceiver.DeepLinksKeys.STORE_THEME), HttpUrl.FRAGMENT_ENCODE_SET, StoreContext.home, true, true), true);
            } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private AppViewFragment.OpenType getOpenType(String str) {
        if (str == null) {
            return AppViewFragment.OpenType.OPEN_ONLY;
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2033901212:
                if (str.equals("open_with_install_popup")) {
                    b2 = 1;
                }
                break;
            case -534321986:
                if (str.equals("open_and_install")) {
                    b2 = 0;
                }
                break;
            case 1546195073:
                if (str.equals("open_only")) {
                    b2 = 4;
                }
                break;
            case 2132954296:
                if (str.equals("apkfy_install_popup")) {
                    b2 = 2;
                }
                break;
        }
        if (b2 == 0) {
            return AppViewFragment.OpenType.OPEN_AND_INSTALL;
        }
        if (b2 != 1) {
            return b2 != 2 ? AppViewFragment.OpenType.OPEN_ONLY : AppViewFragment.OpenType.APK_FY_INSTALL_POPUP;
        }
        return AppViewFragment.OpenType.OPEN_WITH_INSTALL_POPUP;
    }

    private void goToAppsDownloadsSection() {
        this.bottomNavigationNavigator.navigateToApps();
    }

    static /* synthetic */ Account lambda$myStoreDeepLink$11(Account account) {
        if (account.isLoggedIn()) {
            return account;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$myStoreDeepLink$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Account account) {
        if (account == null) {
            this.appShortcutsAnalytics.shortcutNavigation("My_Store_Not_Logged_In");
            this.bottomNavigationNavigator.navigateToStore();
            return;
        }
        this.appShortcutsAnalytics.shortcutNavigation("My_Store");
        if (!account.hasStore()) {
            this.fragmentNavigator.navigateTo(ManageStoreFragment.newInstance(new ManageStoreViewModel(), true), true);
        } else {
            this.storeAnalytics.sendStoreOpenEvent(APP_SHORTCUT, account.getStore().getName(), false);
            this.fragmentNavigator.navigateTo(StoreFragment.newInstance(account.getStore().getName(), account.getStore().getTheme(), StoreFragment.OpenType.GetHome), true);
        }
    }

    private /* synthetic */ GetStoreMeta lambda$newRepoDeepLink$0() throws Exception {
        this.deepLinkView.showStoreAlreadyAdded();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$newRepoDeepLink$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(String str, GetStoreMeta getStoreMeta) {
        this.deepLinkView.showStoreFollowed(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$newRepoDeepLink$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final String str, Boolean bool) {
        return bool.booleanValue() ? rx.e.P(new Callable() { // from class: cm.aptoide.pt.view.k0
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.f8070f.b();
                return null;
            }
        }) : this.storeUtilsProxy.subscribeStoreObservable(str).x(new rx.m.b() { // from class: cm.aptoide.pt.view.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8072f.c(str, (GetStoreMeta) obj);
            }
        });
    }

    static /* synthetic */ String lambda$newRepoDeepLink$3(String str, GetStoreMeta getStoreMeta) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$newRepoDeepLink$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(RoomStoreRepository roomStoreRepository, final String str) {
        return StoreUtils.isSubscribedStore(str, roomStoreRepository).A().j0(rx.l.c.a.b()).G(new rx.m.e() { // from class: cm.aptoide.pt.view.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8064f.d(str, (Boolean) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.view.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                String str2 = str;
                DeepLinkManager.lambda$newRepoDeepLink$3(str2, (GetStoreMeta) obj);
                return str2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$newRepoDeepLink$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(List list, RoomStore roomStore) {
        return openStore(roomStore).b(rx.e.S(list));
    }

    static /* synthetic */ List lambda$newRepoDeepLink$6(List list, Object obj) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$newRepoDeepLink$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(RoomStoreRepository roomStoreRepository, final List list) {
        return list.size() == 1 ? roomStoreRepository.get((String) list.get(0)).k(new rx.m.e() { // from class: cm.aptoide.pt.view.v0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8297f.f(list, (RoomStore) obj);
            }
        }) : navigateToStores().M().X(new rx.m.e() { // from class: cm.aptoide.pt.view.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list2 = list;
                DeepLinkManager.lambda$newRepoDeepLink$6(list2, obj);
                return list2;
            }
        });
    }

    static /* synthetic */ void lambda$newRepoDeepLink$9(Throwable th) {
        Logger.getInstance().e(TAG, "newrepoDeepLink: " + th);
        CrashReport.getInstance().log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$openStore$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(RoomStore roomStore) {
        this.fragmentNavigator.navigateTo(AptoideApplication.getFragmentProvider().newStoreFragment(roomStore.getStoreName(), roomStore.getTheme()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$pickAppDeeplink$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(MinimalAd minimalAd) {
        appViewDeepLink(minimalAd.getAppId(), minimalAd.getPackageName(), false, false, null);
    }

    private void myStoreDeepLink() {
        this.subscriptions.a(this.accountManager.accountStatus().E().X(new rx.m.e() { // from class: cm.aptoide.pt.view.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return DeepLinkManager.lambda$myStoreDeepLink$11((Account) obj);
            }
        }).j0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8084f.a((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().e(DeepLinkManager.TAG, "myStoreDeepLink: " + ((Throwable) obj));
            }
        }));
    }

    private rx.b navigateToStores() {
        final BottomNavigationNavigator bottomNavigationNavigator = this.bottomNavigationNavigator;
        bottomNavigationNavigator.getClass();
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.view.w0
            @Override // rx.m.a
            public final void call() {
                bottomNavigationNavigator.navigateToStore();
            }
        });
    }

    private void newRepoDeepLink(Intent intent, ArrayList<String> arrayList, final RoomStoreRepository roomStoreRepository) {
        if (arrayList != null) {
            this.subscriptions.a(rx.e.N(arrayList).G(new rx.m.e() { // from class: cm.aptoide.pt.view.j0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f8067f.e(roomStoreRepository, (String) obj);
                }
            }).Y0().G(new rx.m.e() { // from class: cm.aptoide.pt.view.n0
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f8077f.g(roomStoreRepository, (List) obj);
                }
            }).H0(new rx.m.b() { // from class: cm.aptoide.pt.view.h0
                @Override // rx.m.b
                public final void call(Object obj) {
                    Logger.getInstance().d(DeepLinkManager.TAG, "newrepoDeepLink: all stores added");
                }
            }, new rx.m.b() { // from class: cm.aptoide.pt.view.m0
                @Override // rx.m.b
                public final void call(Object obj) {
                    DeepLinkManager.lambda$newRepoDeepLink$9((Throwable) obj);
                }
            }));
            intent.removeExtra(DeepLinkIntentReceiver.DeepLinksTargets.NEW_REPO);
        }
    }

    private void newUpdatesDeepLink() {
        this.deepLinkAnalytics.newUpdatesNotification();
        this.bottomNavigationNavigator.navigateToApps();
    }

    private rx.b openStore(final RoomStore roomStore) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.view.u0
            @Override // rx.m.a
            public final void call() {
                this.f8294f.h(roomStore);
            }
        });
    }

    private void openUserProfile(long j2) {
        this.fragmentNavigator.navigateTo(StoreFragment.newInstance(j2, BuildConfig.APTOIDE_THEME, StoreFragment.OpenType.GetHome), true);
    }

    private void pauseDownloadFromNotification(String str) {
        this.installManager.pauseInstall(str).H();
    }

    private void pickAppDeeplink() {
        this.subscriptions.a(this.adsRepository.getAdForShortcut().H0(new rx.m.b() { // from class: cm.aptoide.pt.view.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f8138f.i((MinimalAd) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.view.r0
            @Override // rx.m.b
            public final void call(Object obj) {
                Logger.getInstance().e(DeepLinkManager.TAG, "pickAppDeepLink: " + ((Throwable) obj));
            }
        }));
    }

    private void promotionalDeeplink(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cardId", str);
        EditorialFragment editorialFragment = new EditorialFragment();
        editorialFragment.setArguments(bundle);
        this.fragmentNavigator.navigateTo(editorialFragment, true);
    }

    private void promotionsDeepLink() {
        this.fragmentNavigator.navigateTo(new PromotionsFragment(), true);
    }

    private String replaceActionUrl(String str, SharedPreferences sharedPreferences) {
        return V7.isUrlBaseCache(str) ? str.replace(V7.getCacheHost(sharedPreferences), HttpUrl.FRAGMENT_ENCODE_SET) : str.replace(V7.getHost(sharedPreferences), HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private void searchDeepLink(String str, boolean z) {
        this.bottomNavigationNavigator.navigateToSearch(this.searchNavigator.resolveFragment(new SearchQueryModel(str, str, Source.DEEPLINK)));
        if (str != null && !str.isEmpty()) {
            this.searchAnalytics.searchStart(SearchSource.DEEP_LINK, false);
        } else if (!z) {
            this.searchAnalytics.searchStart(SearchSource.WIDGET, false);
        } else {
            this.searchAnalytics.searchStart(SearchSource.SHORTCUT, false);
            this.appShortcutsAnalytics.shortcutNavigation(SearchAnalytics.SEARCH);
        }
    }

    private void sendFeatureAction(String str, String str2) {
        if (str.equals(this.newFeature.getId()) && str2.equals(this.newFeature.getActionId())) {
            this.themeManager.setThemeOption(ThemeManager.ThemeOption.DARK);
            this.themeManager.resetToBaseTheme();
            this.themeAnalytics.setDarkThemeUserProperty(this.themeManager.getDarkThemeMode());
        }
    }

    private boolean validateDeepLinkRequiredArgs(String str, String str2, String str3, String str4) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || !StoreTabFragmentChooser.validateAcceptedName(Event.Name.valueOf(str3))) ? false : true;
    }

    public /* synthetic */ GetStoreMeta b() throws Exception {
        lambda$newRepoDeepLink$0();
        return null;
    }

    public void freeSubscriptions() {
        if (!this.subscriptions.c() || this.subscriptions.isUnsubscribed()) {
            return;
        }
        this.subscriptions.unsubscribe();
    }

    public boolean showDeepLink(Intent intent) {
        if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.APP_VIEW_FRAGMENT)) {
            if (intent.getBooleanExtra(DeepLinkIntentReceiver.DeepLinksKeys.FROM_NOTIFICATION_READY_TO_INSTALL, false)) {
                this.readyToInstallNotificationManager.setIsNotificationDisplayed(false);
                appViewDeepLinkAutoInstall(intent.getLongExtra("appId", -1L), intent.getStringExtra("packageName"));
            } else if (intent.hasExtra("md5")) {
                appViewDeepLink(intent.getStringExtra("md5"));
            } else if (intent.hasExtra("appId")) {
                appViewDeepLink(intent.getLongExtra("appId", -1L), intent.getStringExtra("packageName"), true, intent.getBooleanExtra(DeepLinkIntentReceiver.DeepLinksKeys.APK_FY, false), intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY));
            } else if (intent.hasExtra("packageName")) {
                boolean booleanExtra = intent.getBooleanExtra(DeepLinkIntentReceiver.DeepLinksKeys.APK_FY, false);
                if (booleanExtra) {
                    appViewDeepLink(intent.getStringExtra("packageName"), true, booleanExtra, intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY));
                } else {
                    appViewDeepLink(intent.getStringExtra("packageName"), intent.getStringExtra("storeName"), intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.OPEN_TYPE));
                }
            } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksKeys.UNAME)) {
                appViewDeepLinkUname(intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.UNAME));
            }
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.SEARCH_FRAGMENT)) {
            searchDeepLink(intent.getStringExtra("query"), intent.getBooleanExtra(DeepLinkIntentReceiver.FROM_SHORTCUT, false));
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.NEW_REPO)) {
            newRepoDeepLink(intent, intent.getExtras().getStringArrayList(DeepLinkIntentReceiver.DeepLinksTargets.NEW_REPO), this.storeRepository);
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.FROM_DOWNLOAD_NOTIFICATION)) {
            downloadNotificationDeepLink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.HOME_DEEPLINK)) {
            fromHomeDeepLink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.NEW_UPDATES)) {
            newUpdatesDeepLink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.APPS)) {
            if (intent.getBooleanExtra(DeepLinkIntentReceiver.DeepLinksKeys.FROM_NOTIFICATION_READY_TO_INSTALL, false)) {
                this.readyToInstallNotificationManager.setIsNotificationDisplayed(false);
                goToAppsDownloadsSection();
            }
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.GENERIC_DEEPLINK)) {
            genericDeepLink((Uri) intent.getParcelableExtra(DeepLinkIntentReceiver.DeepLinksKeys.URI));
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.USER_DEEPLINK)) {
            openUserProfile(intent.getLongExtra(DeepLinkIntentReceiver.DeepLinksTargets.USER_DEEPLINK, -1L));
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.MY_STORE_DEEPLINK)) {
            myStoreDeepLink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.PICK_APP_DEEPLINK)) {
            pickAppDeeplink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.PROMOTIONS_DEEPLINK)) {
            promotionsDeepLink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.EDITORIAL_DEEPLINK)) {
            String stringExtra = intent.getStringExtra("cardId");
            String stringExtra2 = intent.getStringExtra("slug");
            if (stringExtra != null) {
                editorialDeepLinkFromCardId(stringExtra);
            } else if (stringExtra2 != null) {
                editorialDeepLinkFromSlug(stringExtra2);
            }
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.PROMOTIONAL_DEEPLINK)) {
            promotionalDeeplink(intent.getStringExtra("cardId"));
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.APPC_INFO_VIEW)) {
            appcInfoDeepLink();
        } else if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.APPC_ADS)) {
            appcAdsDeepLink();
        } else {
            if (!intent.hasExtra(DeepLinkIntentReceiver.DeepLinksTargets.FEATURE)) {
                this.deepLinkAnalytics.launcher();
                return false;
            }
            if (intent.hasExtra(DeepLinkIntentReceiver.DeepLinksKeys.ID) && intent.hasExtra("action")) {
                sendFeatureAction(intent.getStringExtra(DeepLinkIntentReceiver.DeepLinksKeys.ID), intent.getStringExtra("action"));
            }
        }
        List<ScreenTagHistory> historyList = this.navigationTracker.getHistoryList();
        if (historyList == null || historyList.size() <= 0 || !historyList.get(historyList.size() - 1).getFragment().equals("Notification")) {
            this.navigationTracker.registerScreen(ScreenTagHistory.Builder.build(DEEPLINK_KEY));
        } else {
            this.navigationTracker.registerScreen(ScreenTagHistory.Builder.build("Notification"));
        }
        return true;
    }

    private void appViewDeepLink(long j2, String str, boolean z, boolean z2, String str2) {
        AppViewFragment.OpenType openType;
        if (z2) {
            openType = AppViewFragment.OpenType.APK_FY_INSTALL_POPUP;
        } else {
            openType = z ? AppViewFragment.OpenType.OPEN_WITH_INSTALL_POPUP : AppViewFragment.OpenType.OPEN_ONLY;
        }
        this.appNavigator.navigateWithAppId(j2, str, openType, HttpUrl.FRAGMENT_ENCODE_SET, str2);
    }

    private void appViewDeepLink(String str, boolean z, boolean z2, String str2) {
        AppViewFragment.OpenType openType;
        if (z2) {
            openType = AppViewFragment.OpenType.APK_FY_INSTALL_POPUP;
        } else if (z) {
            openType = AppViewFragment.OpenType.OPEN_WITH_INSTALL_POPUP;
        } else {
            openType = AppViewFragment.OpenType.OPEN_ONLY;
        }
        this.appNavigator.navigateWithPackageName(str, openType, str2);
    }

    private void appViewDeepLink(String str, String str2, String str3) {
        this.appNavigator.navigateWithPackageAndStoreNames(str, str2, getOpenType(str3));
    }
}
