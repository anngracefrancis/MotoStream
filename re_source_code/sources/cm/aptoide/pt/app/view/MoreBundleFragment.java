package cm.aptoide.pt.app.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.home.ScrollableView;
import cm.aptoide.pt.home.bundles.BundlesAdapter;
import cm.aptoide.pt.home.bundles.ads.AdHomeEvent;
import cm.aptoide.pt.home.bundles.ads.AdsBundlesViewHolderFactory;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.misc.ErrorHomeBundle;
import cm.aptoide.pt.home.bundles.misc.ProgressBundle;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.Translator;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class MoreBundleFragment extends NavigationTrackFragment implements MoreBundleView, ScrollableView {
    private static final String MORE_LIST_STATE_KEY = "cm.aptoide.pt.more.ListState";
    private static final int VISIBLE_THRESHOLD = 1;
    private rx.s.b<AdHomeEvent> adClickedEvents;
    private BundlesAdapter adapter;
    private RecyclerView bundlesList;

    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private ErrorView errorView;
    private LinearLayoutManager layoutManager;
    private Parcelable listState;

    @Inject
    @Named
    String marketName;
    private rx.s.b<Boolean> notifyItemsAdded;
    private DecimalFormat oneDecimalFormatter;

    @Inject
    MoreBundlePresenter presenter;
    private ProgressBar progressBar;
    private c.v.a.c swipeRefreshLayout;

    @Inject
    ThemeManager themeAttributeProvider;
    private Toolbar toolbar;
    private View toolbarElement;
    private rx.s.b<HomeEvent> uiEventsListener;

    private boolean isEndReached() {
        return this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 1;
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
    /* JADX INFO: renamed from: lambda$visibleBundles$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer f(e.g.a.b.c.a.a aVar) {
        return Integer.valueOf(this.layoutManager.findFirstVisibleItemPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$visibleBundles$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ HomeEvent g(Integer num) {
        return new HomeEvent(this.adapter.getBundle(num.intValue()), num.intValue(), null);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<AdHomeEvent> adClicked() {
        return this.adClickedEvents;
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<AppHomeEvent> appClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.vd
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.APP));
            }
        }).b(AppHomeEvent.class);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<HomeEvent> bundleScrolled() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.xd
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.SCROLL_RIGHT));
            }
        }).m(200L, TimeUnit.MILLISECONDS);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName(), HttpUrl.FRAGMENT_ENCODE_SET, StoreContext.home.name());
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

    @Override // cm.aptoide.pt.home.ScrollableView
    public boolean isAtTop() {
        return ((LinearLayoutManager) this.bundlesList.getLayoutManager()).findFirstVisibleItemPosition() == 0;
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<HomeEvent> moreClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.rd
            @Override // rx.m.e
            public final Object call(Object obj) {
                HomeEvent homeEvent = (HomeEvent) obj;
                return Boolean.valueOf(homeEvent.getType().equals(HomeEvent.Type.MORE) || homeEvent.getType().equals(HomeEvent.Type.MORE_TOP));
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uiEventsListener = rx.s.b.g1();
        this.adClickedEvents = rx.s.b.g1();
        this.notifyItemsAdded = rx.s.b.g1();
        this.oneDecimalFormatter = new DecimalFormat("0.0");
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.more_bundles_view, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.uiEventsListener = null;
        this.oneDecimalFormatter = null;
        this.adClickedEvents = null;
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
        this.toolbar = null;
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        RecyclerView recyclerView = this.bundlesList;
        if (recyclerView != null) {
            bundle.putParcelable(MORE_LIST_STATE_KEY, recyclerView.getLayoutManager().onSaveInstanceState());
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getFragmentComponent(bundle).inject(this);
        if (bundle != null && bundle.containsKey(MORE_LIST_STATE_KEY)) {
            this.listState = bundle.getParcelable(MORE_LIST_STATE_KEY);
            bundle.putParcelable(MORE_LIST_STATE_KEY, null);
        }
        this.bundlesList = (RecyclerView) view.findViewById(R.id.more_bundles_list);
        this.toolbarElement = view.findViewById(R.id.action_bar);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.swipeRefreshLayout = (c.v.a.c) view.findViewById(R.id.more_refresh_layout);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ArrayList arrayList = new ArrayList();
        ProgressBundle progressBundle = new ProgressBundle();
        ErrorHomeBundle errorHomeBundle = new ErrorHomeBundle();
        DecimalFormat decimalFormat = this.oneDecimalFormatter;
        rx.s.b<HomeEvent> bVar = this.uiEventsListener;
        this.adapter = new BundlesAdapter(arrayList, progressBundle, errorHomeBundle, decimalFormat, bVar, new AdsBundlesViewHolderFactory(bVar, this.adClickedEvents, decimalFormat, this.marketName), this.captionBackgroundPainter, this.marketName, this.themeAttributeProvider);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        this.bundlesList.setLayoutManager(linearLayoutManager);
        this.bundlesList.setAdapter(this.adapter);
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        if (getArguments().getBoolean(StoreTabGridRecyclerFragment.BundleCons.TOOLBAR, true)) {
            dVar.setSupportActionBar(this.toolbar);
            androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.r(true);
            }
        } else {
            this.toolbarElement.setVisibility(8);
        }
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<Object> reachesBottom() {
        return rx.e.a0(e.g.a.b.c.a.c.a(this.bundlesList).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.qd
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4536f.e((e.g.a.b.c.a.a) obj);
            }
        }), this.notifyItemsAdded).t().D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.sd
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                MoreBundleFragment.lambda$reachesBottom$1(bool);
                return bool;
            }
        }).b(Object.class);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<Void> refreshes() {
        return e.g.a.b.b.a.c.a(this.swipeRefreshLayout);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public rx.e<Void> retryClicked() {
        return this.errorView.retryClick();
    }

    @Override // cm.aptoide.pt.home.ScrollableView
    public void scrollToTop() {
        if (((LinearLayoutManager) this.bundlesList.getLayoutManager()).findLastVisibleItemPosition() > 10) {
            this.bundlesList.scrollToPosition(10);
        }
        this.bundlesList.smoothScrollToPosition(0);
    }

    @Override // cm.aptoide.pt.app.view.MoreBundleView
    public void setToolbarInfo(String str) {
        this.toolbar.setTitle(Translator.translate(str, getContext(), HttpUrl.FRAGMENT_ENCODE_SET));
        this.toolbar.setLogo(R.drawable.logo_toolbar);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showBundles(List<HomeBundle> list) {
        this.adapter.update(list);
        if (this.listState != null) {
            this.bundlesList.getLayoutManager().onRestoreInstanceState(this.listState);
            this.listState = null;
        }
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

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showLoadMore() {
        this.adapter.addLoadMore();
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showLoading() {
        this.bundlesList.setVisibility(8);
        this.errorView.setVisibility(8);
        this.progressBar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.apps.BundleView
    public void showMoreHomeBundles(List<HomeBundle> list) {
        this.adapter.add(list);
        this.notifyItemsAdded.onNext(Boolean.FALSE);
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
        return e.g.a.b.c.a.c.a(this.bundlesList).I0(rx.l.c.a.b()).X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.ud
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4620f.f((e.g.a.b.c.a.a) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.app.view.td
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() != -1);
            }
        }).t().X(new rx.m.e() { // from class: cm.aptoide.pt.app.view.wd
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4656f.g((Integer) obj);
            }
        });
    }
}
