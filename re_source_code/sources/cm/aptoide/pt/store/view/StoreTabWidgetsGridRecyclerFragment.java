package cm.aptoide.pt.store.view;

import android.os.Bundle;
import android.view.WindowManager;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablesFactory;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: classes.dex */
public abstract class StoreTabWidgetsGridRecyclerFragment extends StoreTabGridRecyclerFragment {
    protected AptoideAccountManager accountManager;

    @Inject
    AnalyticsManager analyticsManager;

    @Inject
    AptoideInstalledAppsRepository aptoideInstalledAppsRepository;

    @Inject
    @Named
    String marketName;
    protected NavigationTracker navigationTracker;
    protected StoreAnalytics storeAnalytics;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;

    @Inject
    RoomStoreRepository storeRepository;
    private StoreTabNavigator storeTabNavigator;

    @Inject
    StoreUtilsProxy storeUtilsProxy;

    @Inject
    ThemeManager themeManager;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$parseDisplayables$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(GetStoreWidgets.WSWidget wSWidget) {
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        return DisplayablesFactory.parse(this.marketName, wSWidget, ((StoreTabGridRecyclerFragment) this).storeTheme, this.storeRepository, this.storeCredentialsProvider, this.storeContext, getContext(), this.accountManager, this.storeUtilsProxy, (WindowManager) getContext().getSystemService("window"), getContext().getResources(), this.aptoideInstalledAppsRepository, this.storeAnalytics, this.storeTabNavigator, this.navigationTracker, new BadgeDialogFactory(getActivity(), this.themeManager), ((ActivityResultNavigator) getContext()).getFragmentNavigator(), aptoideApplication.getBodyInterceptorPoolV7(), aptoideApplication.getDefaultClient(), WebService.getDefaultConverter(), aptoideApplication.getTokenInvalidator(), aptoideApplication.getDefaultSharedPreferences(), this.themeManager);
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.navigationTracker = ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker();
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        this.storeTabNavigator = new StoreTabNavigator(getFragmentNavigator());
    }

    public rx.e<List<Displayable>> parseDisplayables(GetStoreWidgets getStoreWidgets) {
        int i2 = getContext().getResources().getConfiguration().uiMode & 48;
        return rx.e.N(getStoreWidgets.getDataList().getList()).j(new rx.m.e() { // from class: cm.aptoide.pt.store.view.t1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7736f.f((GetStoreWidgets.WSWidget) obj);
            }
        }).Y0().E();
    }
}
