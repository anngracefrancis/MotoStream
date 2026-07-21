package cm.aptoide.pt.home;

import android.os.Bundle;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.view.AppCoinsInfoFragment;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.home.bundles.base.AppBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.link.CustomTabsHelper;
import cm.aptoide.pt.navigator.ActivityNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.promotions.PromotionsFragment;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.settings.MyAccountFragment;

/* JADX INFO: loaded from: classes.dex */
public class HomeNavigator {
    private static final String TAG = "HomeNavigator";
    private final AccountNavigator accountNavigator;
    private final ActivityNavigator activityNavigator;
    private final AppNavigator appNavigator;
    private final AptoideBottomNavigator aptoideBottomNavigator;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final FragmentNavigator fragmentNavigator;
    private final ThemeManager themeManager;

    public HomeNavigator(FragmentNavigator fragmentNavigator, AptoideBottomNavigator aptoideBottomNavigator, BottomNavigationMapper bottomNavigationMapper, AppNavigator appNavigator, ActivityNavigator activityNavigator, AccountNavigator accountNavigator, ThemeManager themeManager) {
        this.fragmentNavigator = fragmentNavigator;
        this.aptoideBottomNavigator = aptoideBottomNavigator;
        this.bottomNavigationMapper = bottomNavigationMapper;
        this.appNavigator = appNavigator;
        this.activityNavigator = activityNavigator;
        this.accountNavigator = accountNavigator;
        this.themeManager = themeManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bottomNavigation$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean a(Integer num) {
        return Boolean.valueOf(this.bottomNavigationMapper.mapItemClicked(num).equals(BottomNavigationItem.HOME));
    }

    public rx.e<Integer> bottomNavigation() {
        return this.aptoideBottomNavigator.navigationEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.home.w3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6351f.a((Integer) obj);
            }
        });
    }

    public void navigateToAppCoinsInformationView() {
        this.fragmentNavigator.navigateTo(AppCoinsInfoFragment.newInstance(), true);
    }

    public void navigateToAppView(long j2, String str, String str2) {
        this.appNavigator.navigateWithAppId(j2, str, AppViewFragment.OpenType.OPEN_ONLY, str2);
    }

    public void navigateToEditorial(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("cardId", str);
        bundle.putBoolean(EditorialFragment.FROM_HOME, true);
        EditorialFragment editorialFragment = new EditorialFragment();
        editorialFragment.setArguments(bundle);
        this.fragmentNavigator.navigateTo(editorialFragment, true);
    }

    public void navigateToLogIn() {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.EDITORIAL);
    }

    public void navigateToMyAccount() {
        this.fragmentNavigator.navigateTo(MyAccountFragment.newInstance(), true);
    }

    public void navigateToPrivacyPolicy() {
        CustomTabsHelper.getInstance().openInChromeCustomTab(this.activityNavigator.getActivity().getString(R.string.all_url_privacy_policy), this.activityNavigator.getActivity(), this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    public void navigateToPromotions() {
        this.fragmentNavigator.navigateTo(new PromotionsFragment(), true);
    }

    public void navigateToTermsAndConditions() {
        CustomTabsHelper.getInstance().openInChromeCustomTab(this.activityNavigator.getActivity().getString(R.string.all_url_terms_conditions), this.activityNavigator.getActivity(), this.themeManager.getAttributeForTheme(R.attr.colorPrimary).resourceId);
    }

    public void navigateWithAction(HomeEvent homeEvent) {
        String tag = homeEvent.getBundle().getTag();
        if (homeEvent.getBundle() instanceof AppBundle) {
            tag = ((AppBundle) homeEvent.getBundle()).getActionTag();
        }
        this.fragmentNavigator.navigateTo(StoreTabGridRecyclerFragment.newInstance(homeEvent.getBundle().getEvent(), homeEvent.getType(), homeEvent.getBundle().getTitle(), BuildConfig.APTOIDE_THEME, tag, StoreContext.home, true), true);
    }

    public void navigateWithDownloadUrlAndReward(long j2, String str, String str2, String str3, float f2) {
        this.appNavigator.navigateWithDownloadUrlAndReward(j2, str, str2, str3, f2);
    }

    public void navigateWithEditorsPosition(long j2, String str, String str2, String str3, String str4, String str5) {
        this.appNavigator.navigatewithEditorsPosition(j2, str, str2, str3, str4, str5);
    }

    public void navigateToAppView(String str, SearchAdResult searchAdResult) {
        this.appNavigator.navigateWithAdAndTag(searchAdResult, str);
    }
}
