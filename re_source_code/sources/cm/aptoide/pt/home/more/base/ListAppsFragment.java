package cm.aptoide.pt.home.more.base;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.aptoideviews.recyclerview.GridRecyclerView;
import cm.aptoide.aptoideviews.swipe.AptoideSwipeRefresh;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.home.more.base.ListAppsViewHolder;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.Translator;
import cm.aptoide.pt.view.app.Application;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ListAppsFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u001a\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00028\u00010\u0013H&J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0 H\u0016J\b\u0010\"\u001a\u00020\u0015H'J\b\u0010#\u001a\u00020\u0015H'J\b\u0010$\u001a\u00020\u0015H\u0014J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0012\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u0010.\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00142\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u0002012\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u000fH\u0002J\u0016\u0010;\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\b\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u000fH\u0016J\b\u0010>\u001a\u00020\u000fH\u0016J\b\u0010?\u001a\u00020\u000fH\u0016J\b\u0010@\u001a\u00020\u000fH\u0016J\b\u0010A\u001a\u00020\u000fH\u0016R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006B"}, d2 = {"Lcm/aptoide/pt/home/more/base/ListAppsFragment;", "T", "Lcm/aptoide/pt/view/app/Application;", "V", "Lcm/aptoide/pt/home/more/base/ListAppsViewHolder;", "Lcm/aptoide/pt/view/fragment/NavigationTrackFragment;", "Lcm/aptoide/pt/home/more/base/ListAppsView;", "()V", "adapter", "Lcm/aptoide/pt/home/more/base/ListAppsAdapter;", "getAdapter", "()Lcm/aptoide/pt/home/more/base/ListAppsAdapter;", "setAdapter", "(Lcm/aptoide/pt/home/more/base/ListAppsAdapter;)V", "addApps", HttpUrl.FRAGMENT_ENCODE_SET, DeepLinkIntentReceiver.DeepLinksTargets.APPS, HttpUrl.FRAGMENT_ENCODE_SET, "createViewHolder", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", HttpUrl.FRAGMENT_ENCODE_SET, "errorRetryClick", "Lrx/Observable;", "Ljava/lang/Void;", "getAdapterStrategy", "Lcm/aptoide/aptoideviews/recyclerview/GridRecyclerView$AdaptStrategy;", "getContainerPaddingDp", "Landroid/graphics/Rect;", "getHistoryTracker", "Lcm/aptoide/analytics/implementation/navigation/ScreenTagHistory;", "getItemClickEvents", "Lrx/subjects/PublishSubject;", "Lcm/aptoide/pt/home/more/base/ListAppsClickEvent;", "getItemSizeHeight", "getItemSizeWidth", "getItemSpacingDp", "getPixels", "dp", "onBottomReached", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "refreshEvents", "setToolbarInfo", "title", HttpUrl.FRAGMENT_ENCODE_SET, "setupToolbar", "showApps", "showErrorVisibility", "showGenericError", "showHeader", "showLoading", "showNoNetworkError", "showResultsVisibility", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ListAppsFragment<T extends Application, V extends ListAppsViewHolder<? super T>> extends NavigationTrackFragment implements ListAppsView<T> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    protected ListAppsAdapter<T, V> adapter;

    private final int getPixels(int dp) {
        View view = getView();
        return AptoideUtils.ScreenU.getPixelsForDip(dp, view != null ? view.getResources() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onBottomReached$lambda-0, reason: not valid java name */
    public static final Boolean m240onBottomReached$lambda0(ListAppsFragment listAppsFragment, e.g.a.b.c.a.a aVar) {
        kotlin.jvm.internal.m.f(listAppsFragment, "this$0");
        return Boolean.valueOf(((GridRecyclerView) listAppsFragment._$_findCachedViewById(R.id.apps_list)).isEndReached(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onBottomReached$lambda-1, reason: not valid java name */
    public static final Boolean m241onBottomReached$lambda1(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onBottomReached$lambda-2, reason: not valid java name */
    public static final Void m242onBottomReached$lambda2(Boolean bool) {
        return null;
    }

    private final void setupToolbar() {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) activity;
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && arguments.getBoolean(StoreTabGridRecyclerFragment.BundleCons.TOOLBAR, true)) {
            z = true;
        }
        if (!z) {
            _$_findCachedViewById(R.id.action_bar).setVisibility(8);
            return;
        }
        dVar.setSupportActionBar((Toolbar) _$_findCachedViewById(R.id.toolbar));
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View viewFindViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (viewFindViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void addApps(List<? extends T> apps) {
        kotlin.jvm.internal.m.f(apps, DeepLinkIntentReceiver.DeepLinksTargets.APPS);
        showResultsVisibility();
        getAdapter().addData(apps);
    }

    public abstract Function2<ViewGroup, Integer, V> createViewHolder();

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public rx.e<Void> errorRetryClick() {
        return ((ErrorView) _$_findCachedViewById(R.id.error_view)).retryClick();
    }

    protected final ListAppsAdapter<T, V> getAdapter() {
        ListAppsAdapter<T, V> listAppsAdapter = this.adapter;
        if (listAppsAdapter != null) {
            return listAppsAdapter;
        }
        kotlin.jvm.internal.m.w("adapter");
        return null;
    }

    public abstract GridRecyclerView.AdaptStrategy getAdapterStrategy();

    protected Rect getContainerPaddingDp() {
        return new Rect(8, 8, 8, 8);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName(), HttpUrl.FRAGMENT_ENCODE_SET, StoreContext.home.name());
    }

    public abstract int getItemSizeHeight();

    public abstract int getItemSizeWidth();

    protected int getItemSpacingDp() {
        return 8;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public rx.e<Void> onBottomReached() {
        rx.e<Void> eVarX = e.g.a.b.c.a.c.a((GridRecyclerView) _$_findCachedViewById(R.id.apps_list)).X(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsFragment.m240onBottomReached$lambda0(this.f6214f, (e.g.a.b.c.a.a) obj);
            }
        }).t().D(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsFragment.m241onBottomReached$lambda1((Boolean) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.home.more.base.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ListAppsFragment.m242onBottomReached$lambda2((Boolean) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarX, "scrollEvents(apps_list)\n…d -> isEnd }.map { null }");
        return eVarX;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setAdapter(new ListAppsAdapter<>(createViewHolder()));
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        kotlin.jvm.internal.m.f(menu, "menu");
        kotlin.jvm.internal.m.f(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_list_apps, container, false);
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.m.f(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int i2 = R.id.apps_list;
        ((GridRecyclerView) _$_findCachedViewById(i2)).setLayoutManager(new GridLayoutManager(view.getContext(), 3));
        ((GridRecyclerView) _$_findCachedViewById(i2)).setAdaptiveLayout(getItemSizeWidth(), getItemSizeHeight(), getAdapterStrategy());
        ((GridRecyclerView) _$_findCachedViewById(i2)).setIntendedItemSpacing(getItemSpacingDp());
        Rect pixels = getPixels(getContainerPaddingDp());
        ((GridRecyclerView) _$_findCachedViewById(i2)).setPadding(pixels.left, pixels.top, pixels.right, pixels.bottom);
        ((GridRecyclerView) _$_findCachedViewById(i2)).setAdapter(getAdapter());
        setupToolbar();
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public rx.e<Void> refreshEvents() {
        rx.e<Void> eVarA = e.g.a.b.b.a.c.a((AptoideSwipeRefresh) _$_findCachedViewById(R.id.swipe_container));
        kotlin.jvm.internal.m.e(eVarA, "refreshes(swipe_container)");
        return eVarA;
    }

    protected final void setAdapter(ListAppsAdapter<T, V> listAppsAdapter) {
        kotlin.jvm.internal.m.f(listAppsAdapter, "<set-?>");
        this.adapter = listAppsAdapter;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void setToolbarInfo(String title) {
        kotlin.jvm.internal.m.f(title, "title");
        int i2 = R.id.toolbar;
        ((Toolbar) _$_findCachedViewById(i2)).setTitle(Translator.translate(title, getContext(), HttpUrl.FRAGMENT_ENCODE_SET));
        ((Toolbar) _$_findCachedViewById(i2)).setLogo(R.drawable.logo_toolbar);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void showApps(List<? extends T> apps) {
        kotlin.jvm.internal.m.f(apps, DeepLinkIntentReceiver.DeepLinksTargets.APPS);
        showResultsVisibility();
        getAdapter().setData(apps);
        ((GridRecyclerView) _$_findCachedViewById(R.id.apps_list)).scheduleLayoutAnimation();
    }

    public void showErrorVisibility() {
        ((ErrorView) _$_findCachedViewById(R.id.error_view)).setVisibility(0);
        ((GridRecyclerView) _$_findCachedViewById(R.id.apps_list)).setVisibility(8);
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ((AptoideSwipeRefresh) _$_findCachedViewById(R.id.swipe_container)).setRefreshing(false);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void showGenericError() {
        ((ErrorView) _$_findCachedViewById(R.id.error_view)).setError(ErrorView.Error.GENERIC);
        showErrorVisibility();
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void showHeader() {
        ((ImageView) _$_findCachedViewById(R.id.bundle_image)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.bundle_title_1)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.bundle_title_2)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.bundle_description)).setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void showLoading() {
        ((GridRecyclerView) _$_findCachedViewById(R.id.apps_list)).setVisibility(8);
        ((ErrorView) _$_findCachedViewById(R.id.error_view)).setVisibility(8);
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public void showNoNetworkError() {
        ((ErrorView) _$_findCachedViewById(R.id.error_view)).setError(ErrorView.Error.NO_NETWORK);
        showErrorVisibility();
    }

    public void showResultsVisibility() {
        ((GridRecyclerView) _$_findCachedViewById(R.id.apps_list)).setVisibility(0);
        ((ErrorView) _$_findCachedViewById(R.id.error_view)).setVisibility(8);
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        ((AptoideSwipeRefresh) _$_findCachedViewById(R.id.swipe_container)).setRefreshing(false);
    }

    private final Rect getPixels(Rect dp) {
        return new Rect(getPixels(dp.left), getPixels(dp.top), getPixels(dp.right), getPixels(dp.bottom));
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsView
    public rx.s.b<ListAppsClickEvent<T>> getItemClickEvents() {
        return getAdapter().getClickListener();
    }
}
