package cm.aptoide.pt.store.view;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.view.fragment.GridRecyclerFragmentWithDecorator;
import cm.aptoide.pt.view.recycler.BaseAdapter;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class TopStoresFragment extends GridRecyclerFragmentWithDecorator<BaseAdapter> implements Endless {
    public static final int STORES_LIMIT_PER_REQUEST = 10;
    public static String TAG = TopStoresFragment.class.getSimpleName();

    @Inject
    AnalyticsManager analyticsManager;

    @Inject
    NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;
    private int offset = 0;
    private SuccessRequestListener<ListStores> listener = new SuccessRequestListener() { // from class: cm.aptoide.pt.store.view.v1
        @Override // cm.aptoide.pt.dataprovider.interfaces.SuccessRequestListener, rx.m.b
        public final void call(Object obj) {
            this.f7757f.g((ListStores) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createDisplayables, reason: merged with bridge method [inline-methods] */
    public List<Displayable> e(ListStores listStores) {
        ArrayList arrayList = new ArrayList();
        Iterator<Store> it = listStores.getDataList().getList().iterator();
        while (it.hasNext()) {
            arrayList.add(new GridStoreDisplayable(it.next(), "Add Store Dialog Top Stores", this.storeAnalytics));
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [cm.aptoide.pt.view.recycler.BaseAdapter] */
    private void fetchStores() {
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), this.requestFactoryCdnPool.newListStoresRequest(this.offset, 10), this.listener, new ErrorRequestListener() { // from class: cm.aptoide.pt.store.view.w1
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                th.printStackTrace();
            }
        });
        getRecyclerView().addOnScrollListener(endlessRecyclerOnScrollListener);
        endlessRecyclerOnScrollListener.onLoadMore(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(List list) {
        addDisplayables(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(final ListStores listStores) {
        rx.e.P(new Callable() { // from class: cm.aptoide.pt.store.view.x1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f7768f.e(listStores);
            }
        }).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.u1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7750f.f((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.y1
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    public static TopStoresFragment newInstance() {
        return new TopStoresFragment();
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_with_toolbar_no_theme;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
    public Integer getLimit() {
        return 10;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
    public int getOffset() {
        return this.offset;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
        fetchStores();
    }

    @Override // cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // cm.aptoide.pt.dataprovider.ws.v7.Endless
    public void setOffset(int i2) {
        this.offset = i2;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    public void setupToolbarDetails(Toolbar toolbar) {
        toolbar.setTitle(R.string.top_stores_fragment_title);
        toolbar.setLogo(R.drawable.logo_toolbar);
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerFragmentWithDecorator, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        setupToolbar();
    }
}
