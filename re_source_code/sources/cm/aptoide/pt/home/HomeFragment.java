package cm.aptoide.pt.home;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.home.bundles.BundlesAdapter;
import cm.aptoide.pt.home.bundles.HomeBundlesModel;
import cm.aptoide.pt.home.bundles.ads.AdHomeEvent;
import cm.aptoide.pt.home.bundles.ads.AdsBundlesViewHolderFactory;
import cm.aptoide.pt.home.bundles.base.AppComingSoonPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.editorial.EditorialBundleViewHolder;
import cm.aptoide.pt.home.bundles.editorial.EditorialHomeEvent;
import cm.aptoide.pt.home.bundles.misc.ErrorHomeBundle;
import cm.aptoide.pt.home.bundles.misc.ProgressBundle;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.reactions.ReactionsHomeEvent;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import com.google.android.material.snackbar.Snackbar;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class HomeFragment extends NavigationTrackFragment implements HomeView, ScrollableView {
    private static final String LIST_STATE_KEY = "cm.aptoide.pt.BottomHomeFragment.ListState";
    private static final int VISIBLE_THRESHOLD = 2;
    private rx.s.b<AdHomeEvent> adClickedEvents;
    private BundlesAdapter adapter;
    private BottomNavigationActivity bottomNavigationActivity;
    private RecyclerView bundlesList;

    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private ErrorView errorView;
    private rx.s.b<Boolean> firstBundleLoadListener;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;

    @Inject
    @Named
    String marketName;
    private DecimalFormat oneDecimalFormatter;

    @Inject
    HomePresenter presenter;
    private ProgressBar progressBar;
    private rx.s.b<Void> snackListener;
    private c.v.a.c swipeRefreshLayout;

    @Inject
    ThemeManager themeManager;
    private rx.s.b<HomeEvent> uiEventsListener;
    private ImageView userAvatar;
    private static final String TAG = EditorialFragment.class.getName();
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.HOME;

    private void fireFirstBundleLoadedEvent(HomeBundlesModel homeBundlesModel) {
        try {
            if (homeBundlesModel.getList().get(0).getContent() != null) {
                this.firstBundleLoadListener.onNext(Boolean.TRUE);
            }
        } catch (Exception unused) {
        }
    }

    private EditorialBundleViewHolder getViewHolderForAdapterPosition(int i2) {
        try {
            return (EditorialBundleViewHolder) this.bundlesList.findViewHolderForAdapterPosition(i2);
        } catch (Exception unused) {
            Log.e(TAG, "Unable to find editorialViewHolder");
            return null;
        }
    }

    private boolean isEndReached() {
        return this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 2 && this.adapter.isLoaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$reachesBottom$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(e.g.a.b.c.a.a aVar) {
        return Boolean.valueOf(isEndReached());
    }

    static /* synthetic */ Boolean lambda$reachesBottom$1(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showLogInDialog$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(View view) {
        this.snackListener.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$visibleBundles$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ HomeEvent g(Integer num) {
        return new HomeEvent(this.adapter.getBundle(num.intValue()), num.intValue(), null);
    }

    static /* synthetic */ Boolean lambda$visibleBundles$5(Boolean bool) {
        return bool;
    }

    static /* synthetic */ Integer lambda$visibleBundles$6(Boolean bool) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$visibleBundles$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer h(Object obj) {
        return Integer.valueOf(this.layoutManager.findFirstVisibleItemPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$visibleBundles$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean i(Integer num) {
        return Boolean.valueOf(this.adapter.getBundle(num.intValue()).getContent() != null);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<AdHomeEvent> adClicked() {
        return this.adClickedEvents;
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<AppHomeEvent> appClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.s3
            @Override // rx.m.e
            public final Object call(Object obj) {
                HomeEvent homeEvent = (HomeEvent) obj;
                return Boolean.valueOf(homeEvent.getType().equals(HomeEvent.Type.APP) || homeEvent.getType().equals(HomeEvent.Type.REWARD_APP) || homeEvent.getType().equals(HomeEvent.Type.INSTALL_PROMOTIONAL));
            }
        }).b(AppHomeEvent.class);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<HomeEvent> bundleScrolled() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.i3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.SCROLL_RIGHT));
            }
        }).m(200L, TimeUnit.MILLISECONDS);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<HomeEvent> cancelNotifyMeClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.n3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.CANCEL_NOTIFY_ME));
            }
        });
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<HomeEvent> dismissBundleClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.q3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.DISMISS_BUNDLE));
            }
        });
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<EditorialHomeEvent> editorialCardClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.f3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.EDITORIAL));
            }
        }).b(EditorialHomeEvent.class);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName(), HttpUrl.FRAGMENT_ENCODE_SET, StoreContext.home.name());
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void hideBundle(int i2) {
        this.adapter.remove(i2);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void hideLoading() {
        this.bundlesList.setVisibility(0);
        this.errorView.setVisibility(8);
        this.progressBar.setVisibility(8);
        this.swipeRefreshLayout.setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void hideRefresh() {
        this.swipeRefreshLayout.setRefreshing(false);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void hideShowMore() {
        BundlesAdapter bundlesAdapter = this.adapter;
        if (bundlesAdapter != null) {
            bundlesAdapter.removeLoadMore();
        }
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<Void> imageClick() {
        return e.g.a.c.a.a(this.userAvatar);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<HomeEvent> infoBundleKnowMoreClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.l3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.APPC_KNOW_MORE));
            }
        });
    }

    @Override // cm.aptoide.pt.home.ScrollableView
    public boolean isAtTop() {
        return ((LinearLayoutManager) this.bundlesList.getLayoutManager()).findFirstVisibleItemPosition() == 0;
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<HomeEvent> moreClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.v3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.MORE));
            }
        });
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<HomeEvent> notifyMeClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.a3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.NOTIFY_ME));
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BottomNavigationActivity) {
            this.bottomNavigationActivity = (BottomNavigationActivity) activity;
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.uiEventsListener = rx.s.b.g1();
        this.adClickedEvents = rx.s.b.g1();
        this.snackListener = rx.s.b.g1();
        this.firstBundleLoadListener = rx.s.b.g1();
        this.oneDecimalFormatter = new DecimalFormat("0.0");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.uiEventsListener = null;
        this.oneDecimalFormatter = null;
        this.adClickedEvents = null;
        this.userAvatar = null;
        this.snackListener = null;
        super.onDestroy();
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.listState = this.bundlesList.getLayoutManager().onSaveInstanceState();
        this.bundlesList = null;
        this.adapter = null;
        this.layoutManager = null;
        this.swipeRefreshLayout = null;
        this.errorView = null;
        this.progressBar = null;
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDetach() {
        this.bottomNavigationActivity = null;
        super.onDetach();
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<HomeEvent> onLoadMoreRetryClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.o3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.LOAD_MORE_RETRY));
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        RecyclerView recyclerView = this.bundlesList;
        if (recyclerView != null) {
            bundle.putParcelable(LIST_STATE_KEY, recyclerView.getLayoutManager().onSaveInstanceState());
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BottomNavigationActivity bottomNavigationActivity = this.bottomNavigationActivity;
        if (bottomNavigationActivity != null) {
            bottomNavigationActivity.requestFocus(BOTTOM_NAVIGATION_ITEM);
        }
        if (bundle != null && bundle.containsKey(LIST_STATE_KEY)) {
            this.listState = bundle.getParcelable(LIST_STATE_KEY);
            bundle.putParcelable(LIST_STATE_KEY, null);
        }
        this.userAvatar = (ImageView) view.findViewById(R.id.user_actionbar_icon);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bundles_list);
        this.bundlesList = recyclerView;
        recyclerView.getItemAnimator().setChangeDuration(0L);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.swipeRefreshLayout = (c.v.a.c) view.findViewById(R.id.refresh_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        this.bundlesList.setLayoutManager(linearLayoutManager);
        ArrayList arrayList = new ArrayList();
        ProgressBundle progressBundle = new ProgressBundle();
        ErrorHomeBundle errorHomeBundle = new ErrorHomeBundle();
        DecimalFormat decimalFormat = this.oneDecimalFormatter;
        rx.s.b<HomeEvent> bVar = this.uiEventsListener;
        BundlesAdapter bundlesAdapter = new BundlesAdapter(arrayList, progressBundle, errorHomeBundle, decimalFormat, bVar, new AdsBundlesViewHolderFactory(bVar, this.adClickedEvents, decimalFormat, this.marketName), this.captionBackgroundPainter, this.marketName, this.themeManager);
        this.adapter = bundlesAdapter;
        this.bundlesList.setAdapter(bundlesAdapter);
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<Object> reachesBottom() {
        return e.g.a.b.c.a.c.a(this.bundlesList).X(new rx.m.e() { // from class: cm.aptoide.pt.home.p3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6273f.e((e.g.a.b.c.a.a) obj);
            }
        }).t().D(new rx.m.e() { // from class: cm.aptoide.pt.home.d3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                HomeFragment.lambda$reachesBottom$1(bool);
                return bool;
            }
        }).b(Object.class);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<EditorialHomeEvent> reactionButtonLongPress() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.g3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.REACT_LONG_PRESS));
            }
        }).b(EditorialHomeEvent.class);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<ReactionsHomeEvent> reactionClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.m3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.REACTION));
            }
        }).b(ReactionsHomeEvent.class);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<EditorialHomeEvent> reactionsButtonClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.h3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.REACT_SINGLE_PRESS));
            }
        }).b(EditorialHomeEvent.class);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<Void> refreshes() {
        return e.g.a.b.b.a.c.a(this.swipeRefreshLayout);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void removeLoadMoreError() {
        this.adapter.removeLoadMoreError();
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<Void> retryClicked() {
        return this.errorView.retryClick();
    }

    @Override // cm.aptoide.pt.home.HomeView, cm.aptoide.pt.home.ScrollableView
    public void scrollToTop() {
        if (((LinearLayoutManager) this.bundlesList.getLayoutManager()).findLastVisibleItemPosition() > 10) {
            this.bundlesList.scrollToPosition(10);
        }
        this.bundlesList.smoothScrollToPosition(0);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void sendDeeplinkToWalletAppView(String str) {
        Intent intent = new Intent(getContext(), (Class<?>) DeepLinkIntentReceiver.class);
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void setAdsTest(boolean z) {
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void setUserImage(String str) {
        ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(str, this.userAvatar, R.drawable.ic_account_circle);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showBundles(List<HomeBundle> list) {
        this.adapter.update(list);
        if (this.listState != null) {
            this.bundlesList.getLayoutManager().onRestoreInstanceState(this.listState);
            this.listState = null;
        }
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showBundlesSkeleton(HomeBundlesModel homeBundlesModel) {
        fireFirstBundleLoadedEvent(homeBundlesModel);
        this.adapter.update(homeBundlesModel.getList());
        if (this.listState != null) {
            this.bundlesList.getLayoutManager().onRestoreInstanceState(this.listState);
            this.listState = null;
        }
        hideLoading();
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showConsentDialog() {
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showGenericError() {
        this.errorView.setError(ErrorView.Error.GENERIC);
        this.errorView.setVisibility(0);
        this.bundlesList.setVisibility(8);
        this.progressBar.setVisibility(8);
        if (this.swipeRefreshLayout.isRefreshing()) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showGenericErrorToast() {
        Snackbar.a0(getView(), getString(R.string.error_occured), 0).P();
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showLoadMore() {
        this.adapter.addLoadMore();
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showLoadMoreError() {
        this.adapter.showLoadMoreError();
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showLoading() {
        this.bundlesList.setVisibility(8);
        this.errorView.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showLogInDialog() {
        ShowMessage.asSnack(getActivity(), R.string.editorial_reactions_login_short, R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.home.r3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f6296f.f(view);
            }
        }, -1);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showMoreHomeBundles(List<HomeBundle> list) {
        this.adapter.add(list);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showNetworkError() {
        this.errorView.setError(ErrorView.Error.NO_NETWORK);
        this.errorView.setVisibility(0);
        this.bundlesList.setVisibility(8);
        this.progressBar.setVisibility(8);
        if (this.swipeRefreshLayout.isRefreshing()) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showNetworkErrorToast() {
        Snackbar.a0(getView(), getString(R.string.connection_error), 0).P();
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void showReactionsPopup(String str, String str2, int i2) {
        EditorialBundleViewHolder viewHolderForAdapterPosition = getViewHolderForAdapterPosition(i2);
        if (viewHolderForAdapterPosition != null) {
            viewHolderForAdapterPosition.showReactions(str, str2, i2);
        }
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<Void> snackLogInClick() {
        return this.snackListener;
    }

    @Override // cm.aptoide.pt.home.HomeView
    public void updateAppComingSoonStatus(AppComingSoonPromotionalBundle appComingSoonPromotionalBundle, boolean z) {
        this.adapter.updateAppComingSoonCard(appComingSoonPromotionalBundle, z);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void updateEditorialCards() {
        this.adapter.updateEditorials();
        if (this.listState != null) {
            this.bundlesList.getLayoutManager().onRestoreInstanceState(this.listState);
            this.listState = null;
        }
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<HomeEvent> visibleBundles() {
        return rx.e.a0(e.g.a.b.c.a.c.a(this.bundlesList), this.firstBundleLoadListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.u3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                HomeFragment.lambda$visibleBundles$5(bool);
                return bool;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.k3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return HomeFragment.lambda$visibleBundles$6((Boolean) obj);
            }
        })).X(new rx.m.e() { // from class: cm.aptoide.pt.home.c3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6012f.h(obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.t3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() != -1);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.home.b3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5844f.i((Integer) obj);
            }
        }).t().X(new rx.m.e() { // from class: cm.aptoide.pt.home.e3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6036f.g((Integer) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.home.HomeView
    public rx.e<HomeEvent> walletOfferCardInstallWalletClick() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.home.j3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.INSTALL_WALLET));
            }
        });
    }
}
