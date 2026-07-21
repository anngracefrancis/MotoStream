package cm.aptoide.pt.view.app;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.BackButtonFragment;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class ListStoreAppsFragment extends BackButtonFragment implements ListStoreAppsView {
    private static final String LIST_STATE_KEY = "cm.aptoide.pt.ListStoreAppsFragment.ListState";
    public static final int LOAD_THRESHOLD = 5;
    public static final String STORE_ID = "cm.aptoide.pt.ListStoreAppsFragment.storeId";
    private ListStoreAppsAdapter adapter;

    @Inject
    AppCenter appCenter;
    private rx.s.b<Application> appClicks;
    private ErrorView errorView;
    private GridLayoutManager layoutManager;
    private Parcelable listState;

    @Inject
    ListStoreAppsNavigator listStoreAppsNavigator;
    private RecyclerView recyclerView;
    private rx.s.b<Void> refreshEvent;
    private ProgressBar startingLoadingLayout;
    private long storeId;
    private c.v.a.c swipeRefreshLayout;

    private boolean isEndReached() {
        return this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onViewCreated$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        this.refreshEvent.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$reachesBottom$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean f(e.g.a.b.c.a.a aVar) {
        return Boolean.valueOf(isEndReached());
    }

    public static Fragment newInstance(long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong(STORE_ID, j2);
        ListStoreAppsFragment listStoreAppsFragment = new ListStoreAppsFragment();
        listStoreAppsFragment.setArguments(bundle);
        return listStoreAppsFragment;
    }

    private void showApps() {
        this.recyclerView.setVisibility(0);
        this.startingLoadingLayout.setVisibility(8);
        this.errorView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void addApps(List<Application> list) {
        this.adapter.addApps(list);
        showApps();
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public rx.e<Application> getAppClick() {
        return this.appClicks;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public rx.s.b<Void> getRefreshEvent() {
        return this.refreshEvent;
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public rx.e<Void> getRetryEvent() {
        return this.errorView.retryClick();
    }

    public int getSpanSize(int i2) {
        return (int) ((AptoideUtils.ScreenU.getScreenWidthInDip((WindowManager) getContext().getSystemService("window"), getContext().getResources()) / 360.0f) * i2);
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void hideLoading() {
        this.adapter.hideLoading();
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void hideRefreshLoading() {
        this.swipeRefreshLayout.setRefreshing(false);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.storeId = getArguments().getLong(STORE_ID);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return layoutInflater.inflate(R.layout.list_store_apps_fragment_layout, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.listState = this.layoutManager.onSaveInstanceState();
        this.recyclerView = null;
        this.adapter = null;
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.a());
        this.layoutManager = null;
        this.startingLoadingLayout = null;
        this.swipeRefreshLayout = null;
        this.appClicks = null;
        this.refreshEvent = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.adapter != null) {
            bundle.putParcelable(LIST_STATE_KEY, this.layoutManager.onSaveInstanceState());
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null && bundle.containsKey(LIST_STATE_KEY)) {
            this.listState = bundle.getParcelable(LIST_STATE_KEY);
            bundle.putParcelable(LIST_STATE_KEY, null);
        }
        this.appClicks = rx.s.b.g1();
        this.refreshEvent = rx.s.b.g1();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.recyclerView = recyclerView;
        recyclerView.setVisibility(8);
        this.swipeRefreshLayout = (c.v.a.c) view.findViewById(R.id.swipe_container);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.swipeRefreshLayout.setOnRefreshListener(new c.v.a.c.j() { // from class: cm.aptoide.pt.view.app.a1
            @Override // c.v.a.c.j
            public final void a() {
                this.a.e();
            }
        });
        setupToolbar(view);
        ListStoreAppsAdapter listStoreAppsAdapter = new ListStoreAppsAdapter(new ArrayList(), this.appClicks);
        this.adapter = listStoreAppsAdapter;
        this.recyclerView.setAdapter(listStoreAppsAdapter);
        final int spanSize = getSpanSize(3);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), spanSize);
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.c() { // from class: cm.aptoide.pt.view.app.ListStoreAppsFragment.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.c
            public int getSpanSize(int i2) {
                if (ListStoreAppsFragment.this.adapter == null || !(ListStoreAppsFragment.this.adapter.getItem(i2) instanceof AppLoading)) {
                    return 1;
                }
                return spanSize;
            }
        });
        this.recyclerView.setLayoutManager(this.layoutManager);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.startingLoadingLayout = progressBar;
        progressBar.setVisibility(0);
        this.recyclerView.addItemDecoration(new RecyclerView.n() { // from class: cm.aptoide.pt.view.app.ListStoreAppsFragment.2
            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView2, RecyclerView.z zVar) {
                if (ListStoreAppsFragment.this.getHost() != null) {
                    int pixelsForDip = AptoideUtils.ScreenU.getPixelsForDip(5, ListStoreAppsFragment.this.getResources());
                    rect.set(pixelsForDip, pixelsForDip, pixelsForDip, pixelsForDip);
                }
            }
        });
        attachPresenter(new ListStoreAppsPresenter(this, this.storeId, rx.l.c.a.b(), this.appCenter, CrashReport.getInstance(), this.listStoreAppsNavigator, spanSize * 10));
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public rx.e<Object> reachesBottom() {
        return e.g.a.b.c.a.c.a(this.recyclerView).t().D(new rx.m.e() { // from class: cm.aptoide.pt.view.app.b1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7923f.f((e.g.a.b.c.a.a) obj);
            }
        }).b(Object.class);
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void setApps(List<Application> list) {
        this.adapter.setApps(list);
        Parcelable parcelable = this.listState;
        if (parcelable != null) {
            this.layoutManager.onRestoreInstanceState(parcelable);
            this.listState = null;
        }
        showApps();
    }

    public void setupToolbar(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((androidx.appcompat.app.d) getActivity()).setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = ((androidx.appcompat.app.d) getActivity()).getSupportActionBar();
        supportActionBar.r(true);
        toolbar.setTitle(R.string.list_store_apps_fragment_title);
        supportActionBar.v(toolbar.getTitle());
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void showGenericError() {
        this.errorView.setError(ErrorView.Error.GENERIC);
        this.errorView.setVisibility(0);
        this.startingLoadingLayout.setVisibility(8);
        this.recyclerView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void showLoading() {
        this.adapter.showLoading();
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void showNetworkError() {
        this.errorView.setError(ErrorView.Error.NO_NETWORK);
        this.errorView.setVisibility(0);
        this.startingLoadingLayout.setVisibility(8);
        this.recyclerView.setVisibility(8);
    }

    @Override // cm.aptoide.pt.view.app.ListStoreAppsView
    public void showStartingLoading() {
        this.startingLoadingLayout.setVisibility(0);
        this.recyclerView.setVisibility(8);
        this.errorView.setVisibility(8);
    }
}
