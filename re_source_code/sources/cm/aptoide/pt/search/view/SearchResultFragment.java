package cm.aptoide.pt.search.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.aptoideviews.filters.Filter;
import cm.aptoide.aptoideviews.filters.FiltersView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.download.view.DownloadClick;
import cm.aptoide.pt.search.model.SearchAppResult;
import cm.aptoide.pt.search.model.SearchAppResultWrapper;
import cm.aptoide.pt.search.model.SearchFilterType;
import cm.aptoide.pt.search.model.SearchQueryModel;
import cm.aptoide.pt.search.model.SearchResultError;
import cm.aptoide.pt.search.model.SearchViewModel;
import cm.aptoide.pt.search.model.Suggestion;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.BackButtonFragment;
import cm.aptoide.pt.view.rx.RxAlertDialog;
import cm.aptoide.pt.view.settings.InputDialog;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class SearchResultFragment extends BackButtonFragment implements SearchResultView, SearchSuggestionsView {
    private static final String ALL_STORES_SEARCH_LIST_STATE = "all_stores_search_list_state";
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.SEARCH;
    private static final int COMPLETION_THRESHOLD = 0;
    private static final String FOCUS_IN_SEARCH = "focus_in_search";
    private static final int LAYOUT = 2131493049;
    private static final String UNSUBMITTED_QUERY = "unsubmitted_query";
    private static final String VIEW_MODEL = "view_model";
    private static final int VISIBLE_THRESHOLD = 2;
    private androidx.appcompat.app.a actionBar;
    private BottomNavigationActivity bottomNavigationActivity;
    private String currentQuery;
    private rx.s.b<DownloadClick> downloadClickPublishSubject;
    private RxAlertDialog enableAdultContentDialog;
    private InputDialog enableAdultContentDialogWithPin;
    private ErrorView errorView;
    private CardView filtersCardView;
    private rx.s.b<Void> filtersChanged;
    private FiltersView filtersView;
    private boolean focusInSearchBar;
    private boolean isFreshLoading = false;
    private boolean isSearchExpanded;
    private boolean networkError;
    private boolean noResults;
    private rx.s.b<Boolean> noResultsAdultContentSubject;
    private rx.s.b<Void> noResultsPublishSubject;
    private SwitchCompat noSearchAdultContentSwitch;
    private View noSearchLayout;
    private rx.s.b<SearchAppResultWrapper> onItemViewClickSubject;
    private ProgressBar progressBar;
    private ProgressBar progressBarResults;
    private rx.s.b<SearchQueryEvent> queryTextChangedPublisher;
    private rx.s.b<ScreenShotClickEvent> screenShotClick;
    private rx.s.b<Void> searchHasNoResults;
    private MenuItem searchMenuItem;
    private RecyclerView searchResultList;

    @Inject
    SearchResultPresenter searchResultPresenter;
    private SearchResultAdapter searchResultsAdapter;
    private View searchResultsLayout;
    private rx.s.b<Void> searchSetupPublishSubject;
    private SearchSuggestionsAdapter searchSuggestionsAdapter;
    private SearchSuggestionsAdapter searchTrendingAdapter;
    private SearchView searchView;
    private rx.s.b<SearchQueryEvent> suggestionClickedPublishSubject;
    private RecyclerView suggestionsResultList;

    @Inject
    ThemeManager themeManager;
    private Toolbar toolbar;
    private RecyclerView trendingResultList;
    private String unsubmittedQuery;
    private SearchViewModel viewModel;

    private void attachAllStoresResultListDependencies() {
        this.searchResultList.setAdapter(this.searchResultsAdapter);
        this.searchResultList.setLayoutManager(getDefaultLayoutManager());
    }

    private rx.e<Void> filtersChanged() {
        return this.filtersChanged;
    }

    private void findChildViews(View view) {
        this.filtersCardView = (CardView) view.findViewById(R.id.filters_card_view);
        this.searchResultList = (RecyclerView) view.findViewById(R.id.fragment_search_result_all_stores_app_list);
        this.suggestionsResultList = (RecyclerView) view.findViewById(R.id.suggestions_list);
        this.trendingResultList = (RecyclerView) view.findViewById(R.id.trending_list);
        this.searchResultsLayout = view.findViewById(R.id.fragment_search_result_layout);
        this.noSearchLayout = view.findViewById(R.id.no_search_results_layout);
        this.noSearchAdultContentSwitch = (SwitchCompat) view.findViewById(R.id.no_search_adult_switch);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.progressBarResults = (ProgressBar) view.findViewById(R.id.progress_bar_results);
        this.toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.filtersView = (FiltersView) view.findViewById(R.id.filters_view);
        this.noSearchAdultContentSwitch.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.search.view.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f7520f.h(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceSuggestions() {
        this.noSearchLayout.setVisibility(8);
        this.errorView.setVisibility(8);
        this.searchResultsLayout.setVisibility(8);
        this.trendingResultList.setVisibility(0);
        this.suggestionsResultList.setVisibility(8);
    }

    private LinearLayoutManager getDefaultLayoutManager() {
        return new LinearLayoutManager(getContext(), 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasSearchResults() {
        return this.searchResultsAdapter.getItemCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEndReached(e.g.a.b.c.a.a aVar) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) aVar.a().getLayoutManager();
        return linearLayoutManager.getItemCount() - linearLayoutManager.findLastVisibleItemPosition() <= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$filtersChangeEvents$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(List list) {
        this.viewModel.setFilters(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$filtersChangeEvents$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(List list) {
        this.filtersChanged.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$findChildViews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(View view) {
        this.noResultsAdultContentSubject.onNext(Boolean.valueOf(this.noSearchAdultContentSwitch.isChecked()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$listenToSuggestionClick$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ c.i.j.e i(SearchQueryEvent searchQueryEvent) {
        return new c.i.j.e(this.unsubmittedQuery, searchQueryEvent);
    }

    static /* synthetic */ Boolean lambda$recyclerViewReachedBottom$3(Boolean bool) {
        return bool;
    }

    static /* synthetic */ Void lambda$recyclerViewReachedBottom$4(Boolean bool) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchMenuItemClick$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean j(MenuItem menuItem) {
        return Boolean.valueOf(menuItem.getItemId() == this.searchMenuItem.getItemId());
    }

    public static SearchResultFragment newInstance(SearchQueryModel searchQueryModel) {
        return newInstance(searchQueryModel, false);
    }

    private rx.e<Void> recyclerViewReachedBottom(RecyclerView recyclerView) {
        return rx.e.b0(e.g.a.b.c.a.c.a(recyclerView).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.z
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(this.f7552f.isEndReached((e.g.a.b.c.a.a) obj));
            }
        }), filtersChanged().X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.y
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.FALSE;
            }
        }), searchHasNoResults().X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.x
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.TRUE;
            }
        })).t().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                SearchResultFragment.lambda$recyclerViewReachedBottom$3(bool);
                return bool;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.a0
            @Override // rx.m.e
            public final Object call(Object obj) {
                SearchResultFragment.lambda$recyclerViewReachedBottom$4((Boolean) obj);
                return null;
            }
        });
    }

    private void restoreViewState(Parcelable parcelable) {
        if (parcelable != null) {
            RecyclerView.o layoutManager = this.searchResultList.getLayoutManager();
            if (layoutManager == null) {
                layoutManager = getDefaultLayoutManager();
                this.searchResultList.setLayoutManager(layoutManager);
            }
            layoutManager.onRestoreInstanceState(parcelable);
        }
        showResultsView();
    }

    private rx.e<Void> searchHasNoResults() {
        return this.searchHasNoResults;
    }

    private void setupDefaultTheme() {
        this.themeManager.resetToBaseTheme();
    }

    private void setupFilters() {
        SearchViewModel searchViewModel = this.viewModel;
        this.filtersView.setFilters((searchViewModel == null || searchViewModel.getStoreName() == null || this.viewModel.getStoreName().isEmpty()) ? Arrays.asList(new Filter(getString(R.string.search_filters_followed_stores), false, SearchFilterType.FOLLOWED_STORES.name()), new Filter(getString(R.string.search_filters_trusted), false, SearchFilterType.TRUSTED.name()), new Filter(getString(R.string.search_filters_beta), false, SearchFilterType.BETA.name()), new Filter(getString(R.string.search_filters_appcoins), false, SearchFilterType.APPC.name())) : Arrays.asList(new Filter(getString(R.string.search_filters_trusted), false, SearchFilterType.TRUSTED.name()), new Filter(getString(R.string.search_filters_beta), false, SearchFilterType.BETA.name()), new Filter(getString(R.string.search_filters_appcoins), false, SearchFilterType.APPC.name())));
    }

    private void setupTheme() {
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel == null || !storeThemeExists(searchViewModel.getStoreTheme())) {
            this.themeManager.resetToBaseTheme();
            String themeName = this.themeManager.getBaseTheme().getThemeName();
            this.filtersView.setFiltersBackgroundRes(this.themeManager.getAttributeForTheme(themeName, R.attr.homeChips).resourceId);
            this.filtersView.setFiltersTextColorStateList(this.themeManager.getAttributeForTheme(themeName, R.attr.homeChipsTextColorSelector).resourceId);
            return;
        }
        String storeTheme = this.viewModel.getStoreTheme();
        this.themeManager.setTheme(storeTheme);
        this.toolbar.setBackgroundResource(this.themeManager.getAttributeForTheme(storeTheme, R.attr.toolbarBackground).resourceId);
        if (Build.VERSION.SDK_INT < 21) {
            Drawable drawableR = androidx.core.graphics.drawable.a.r(this.progressBar.getIndeterminateDrawable());
            androidx.core.graphics.drawable.a.n(drawableR, this.themeManager.getAttributeForTheme(R.attr.colorPrimary).data);
            this.progressBar.setIndeterminateDrawable(androidx.core.graphics.drawable.a.q(drawableR));
        } else {
            this.progressBar.getIndeterminateDrawable().setColorFilter(this.themeManager.getAttributeForTheme(R.attr.colorPrimary).data, PorterDuff.Mode.SRC_IN);
        }
        this.filtersView.setFiltersBackgroundRes(this.themeManager.getAttributeForTheme(storeTheme, R.attr.homeChips).resourceId);
        this.filtersView.setFiltersTextColorStateList(this.themeManager.getAttributeForTheme(storeTheme, R.attr.homeChipsTextColorSelector).resourceId);
    }

    private void setupToolbar() {
        String finalQuery = this.viewModel.getSearchQueryModel().getFinalQuery();
        if (finalQuery.isEmpty() && !this.noResults) {
            this.toolbar.setTitle(R.string.search_hint_title);
            this.toolbar.setTitleMarginStart(100);
        } else if (finalQuery.isEmpty()) {
            this.toolbar.setTitle(R.string.search_hint_title);
        } else {
            this.toolbar.setTitle(finalQuery);
        }
        androidx.appcompat.app.d dVar = (androidx.appcompat.app.d) getActivity();
        dVar.setSupportActionBar(this.toolbar);
        androidx.appcompat.app.a supportActionBar = dVar.getSupportActionBar();
        this.actionBar = supportActionBar;
        if (supportActionBar != null) {
            supportActionBar.r(true);
            this.actionBar.v(this.toolbar.getTitle());
        }
    }

    private boolean storeThemeExists(String str) {
        return str != null && str.length() > 0;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void addAllStoresResult(String str, List<SearchAppResult> list, boolean z, boolean z2, boolean z3, SearchResultError searchResultError) {
        if (z) {
            this.isFreshLoading = false;
            this.searchResultsAdapter.setResultForSearch(this.searchResultList, str, list, z2);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_disappear);
            animationLoadAnimation.setFillAfter(true);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: cm.aptoide.pt.search.view.SearchResultFragment.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    SearchResultFragment.this.progressBarResults.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.progressBarResults.startAnimation(animationLoadAnimation);
            this.searchResultList.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(getContext(), R.anim.list_apps_anim));
            this.searchResultList.scheduleLayoutAnimation();
        } else {
            this.searchResultsAdapter.addResultForSearch(str, list, z2);
        }
        this.viewModel.setLoadedResults(true);
        hideLoading();
        if (z3) {
            if (searchResultError == SearchResultError.NO_NETWORK) {
                showNoNetworkView();
                return;
            } else {
                showGenericErrorView();
                return;
            }
        }
        if (list.size() <= 0) {
            showNoResultsView();
        } else {
            showResultsView();
        }
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<DialogInterface> adultContentDialogNegativeClick() {
        return this.enableAdultContentDialog.negativeClicks();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<DialogInterface> adultContentDialogPositiveClick() {
        return this.enableAdultContentDialog.positiveClicks();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<DialogInterface> adultContentPinDialogNegativeClick() {
        return this.enableAdultContentDialogWithPin.negativeClicks();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<CharSequence> adultContentWithPinDialogPositiveClick() {
        return this.enableAdultContentDialogWithPin.positiveClicks();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void clearUnsubmittedQuery() {
        this.unsubmittedQuery = HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<Boolean> clickAdultContentSwitch() {
        return this.noResultsAdultContentSubject;
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void collapseSearchBar(boolean z) {
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem != null) {
            menuItem.collapseActionView();
        }
        if (hasResults()) {
            return;
        }
        this.toolbar.setTitle(R.string.search_hint_title);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void disableAdultContent() {
        this.noSearchAdultContentSwitch.setChecked(false);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void disableUpNavigation() {
        androidx.appcompat.app.a aVar = this.actionBar;
        if (aVar != null) {
            aVar.t(false);
            this.actionBar.r(false);
            this.actionBar.s(false);
        }
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void enableAdultContent() {
        this.noSearchAdultContentSwitch.setChecked(true);
    }

    public void enableUpNavigation() {
        androidx.appcompat.app.a aVar = this.actionBar;
        if (aVar != null) {
            aVar.t(true);
            this.actionBar.r(true);
            this.actionBar.s(true);
        }
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<List<Filter>> filtersChangeEvents() {
        return this.filtersView.filtersChangedEvents().x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7352f.f((List) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.w
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7528f.g((List) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void focusInSearchBar() {
        String str;
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem != null) {
            menuItem.expandActionView();
        }
        SearchView searchView = this.searchView;
        if (searchView != null && (str = this.unsubmittedQuery) != null) {
            searchView.d0(str, false);
        } else if (searchView != null && !getCurrentQuery().isEmpty()) {
            this.searchView.d0(getCurrentQuery(), false);
        }
        showSuggestionsView();
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public String getCurrentQuery() {
        String str = this.currentQuery;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<DownloadClick> getDownloadClickEvents() {
        return this.downloadClickPublishSubject;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<ScreenShotClickEvent> getScreenshotClickEvent() {
        return this.screenShotClick;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public SearchResultView.Model getViewModel() {
        return this.viewModel;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public boolean hasResults() {
        return (this.searchResultsAdapter.getItemCount() == 0 || this.searchMenuItem.isActionViewExpanded()) ? false : true;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void hideLoading() {
        this.progressBar.setVisibility(8);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void hideSuggestionsViews() {
        this.suggestionsResultList.setVisibility(8);
        this.trendingResultList.setVisibility(8);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public boolean isSearchViewExpanded() {
        return this.searchMenuItem.isActionViewExpanded();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<c.i.j.e<String, SearchQueryEvent>> listenToSuggestionClick() {
        return this.suggestionClickedPublishSubject.X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7361f.i((SearchQueryEvent) obj);
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
        CrashReport crashReport = CrashReport.getInstance();
        if (this.viewModel == null && bundle != null && bundle.containsKey(VIEW_MODEL)) {
            this.viewModel = (SearchViewModel) org.parceler.d.a(bundle.getParcelable(VIEW_MODEL));
        } else if (this.viewModel == null && getArguments().containsKey(VIEW_MODEL)) {
            this.viewModel = (SearchViewModel) org.parceler.d.a(getArguments().getParcelable(VIEW_MODEL));
        }
        if (bundle != null && bundle.containsKey(FOCUS_IN_SEARCH)) {
            this.focusInSearchBar = bundle.getBoolean(FOCUS_IN_SEARCH);
        } else if (getArguments().containsKey(FOCUS_IN_SEARCH) && bundle == null) {
            this.focusInSearchBar = getArguments().getBoolean(FOCUS_IN_SEARCH);
        }
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel != null) {
            this.currentQuery = searchViewModel.getSearchQueryModel().getFinalQuery();
        }
        this.noResults = false;
        this.networkError = false;
        this.onItemViewClickSubject = rx.s.b.g1();
        this.downloadClickPublishSubject = rx.s.b.g1();
        this.screenShotClick = rx.s.b.g1();
        this.suggestionClickedPublishSubject = rx.s.b.g1();
        this.searchSetupPublishSubject = rx.s.b.g1();
        this.queryTextChangedPublisher = rx.s.b.g1();
        this.noResultsAdultContentSubject = rx.s.b.g1();
        this.noResultsPublishSubject = rx.s.b.g1();
        this.filtersChanged = rx.s.b.g1();
        this.searchHasNoResults = rx.s.b.g1();
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(this.onItemViewClickSubject, this.downloadClickPublishSubject, this.screenShotClick, new ArrayList(), crashReport);
        this.searchResultsAdapter = searchResultAdapter;
        searchResultAdapter.registerAdapterDataObserver(new RecyclerView.i() { // from class: cm.aptoide.pt.search.view.SearchResultFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void onItemRangeInserted(int i2, int i3) {
                RecyclerView.o layoutManager;
                if (i2 != 0 || (layoutManager = SearchResultFragment.this.searchResultList.getLayoutManager()) == null) {
                    return;
                }
                layoutManager.scrollToPosition(0);
            }
        });
        this.searchSuggestionsAdapter = new SearchSuggestionsAdapter(new ArrayList(), this.suggestionClickedPublishSubject);
        this.searchTrendingAdapter = new SearchSuggestionsAdapter(new ArrayList(), this.suggestionClickedPublishSubject);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.fragment_search_result, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_item_search);
        this.searchMenuItem = menuItemFindItem;
        SearchView searchView = (SearchView) menuItemFindItem.getActionView();
        this.searchView = searchView;
        searchView.setMaxWidth(Integer.MAX_VALUE);
        boolean z = false;
        ((AutoCompleteTextView) this.searchView.findViewById(R.id.search_src_text)).setThreshold(0);
        androidx.core.view.h.g(this.searchMenuItem, new androidx.core.view.h.b() { // from class: cm.aptoide.pt.search.view.SearchResultFragment.4
            @Override // androidx.core.view.h.b
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                if (SearchResultFragment.this.hasSearchResults()) {
                    SearchResultFragment.this.showResultsView();
                } else if (SearchResultFragment.this.networkError) {
                    SearchResultFragment.this.showNoNetworkView();
                } else if (SearchResultFragment.this.noResults) {
                    SearchResultFragment.this.showNoResultsView();
                } else {
                    SearchResultFragment.this.forceSuggestions();
                }
                if (SearchResultFragment.this.shouldHideUpNavigation()) {
                    SearchResultFragment.this.disableUpNavigation();
                }
                SearchResultFragment.this.isSearchExpanded = false;
                return true;
            }

            @Override // androidx.core.view.h.b
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                SearchResultFragment.this.enableUpNavigation();
                SearchResultFragment.this.isSearchExpanded = true;
                return true;
            }
        });
        if (this.currentQuery.isEmpty() && !this.noResults) {
            z = true;
        }
        this.focusInSearchBar = z;
        this.searchSetupPublishSubject.onNext(null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.global_search_fragment, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.noResultsAdultContentSubject = null;
        this.noResultsPublishSubject = null;
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.searchResultList.clearAnimation();
        setupDefaultTheme();
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDetach() {
        this.bottomNavigationActivity = null;
        super.onDetach();
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public rx.e<SearchQueryEvent> onQueryTextChanged() {
        return this.queryTextChangedPublisher;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(VIEW_MODEL, org.parceler.d.c(this.viewModel));
        RecyclerView recyclerView = this.searchResultList;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            bundle.putParcelable(ALL_STORES_SEARCH_LIST_STATE, this.searchResultList.getLayoutManager().onSaveInstanceState());
        }
        bundle.putString(UNSUBMITTED_QUERY, this.unsubmittedQuery);
        if (this.isSearchExpanded) {
            bundle.putBoolean(FOCUS_IN_SEARCH, true);
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BottomNavigationActivity bottomNavigationActivity = this.bottomNavigationActivity;
        if (bottomNavigationActivity != null) {
            bottomNavigationActivity.requestFocus(BOTTOM_NAVIGATION_ITEM);
        }
        findChildViews(view);
        attachAllStoresResultListDependencies();
        setupToolbar();
        setupTheme();
        setupFilters();
        this.searchResultList.setItemAnimator(new androidx.recyclerview.widget.e() { // from class: cm.aptoide.pt.search.view.SearchResultFragment.2
            @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.l
            public boolean canReuseUpdatedViewHolder(RecyclerView.c0 c0Var) {
                return true;
            }
        });
        this.suggestionsResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.trendingResultList.setLayoutManager(new LinearLayoutManager(getContext()));
        this.suggestionsResultList.setAdapter(this.searchSuggestionsAdapter);
        this.trendingResultList.setAdapter(this.searchTrendingAdapter);
        if (this.viewModel != null) {
            restoreViewState(bundle != null ? bundle.getParcelable(ALL_STORES_SEARCH_LIST_STATE) : null);
        }
        SearchViewModel searchViewModel = this.viewModel;
        if (searchViewModel != null) {
            if (searchViewModel.getFilters() != null) {
                this.filtersView.setFilters(this.viewModel.getFilters());
            } else {
                this.viewModel.setFilters(this.filtersView.getFilters());
            }
        }
        if (bundle != null) {
            this.unsubmittedQuery = bundle.containsKey(UNSUBMITTED_QUERY) ? bundle.getString(UNSUBMITTED_QUERY) : HttpUrl.FRAGMENT_ENCODE_SET;
        }
        this.enableAdultContentDialog = new RxAlertDialog.Builder(getContext(), this.themeManager).setMessage(R.string.are_you_adult).setPositiveButton(R.string.yes).setNegativeButton(R.string.no).build();
        this.enableAdultContentDialogWithPin = new InputDialog.Builder(getContext(), this.themeManager).setMessage(R.string.request_adult_pin).setPositiveButton(R.string.all_button_ok).setNegativeButton(R.string.cancel).setView(R.layout.dialog_request_input).setEditText(R.id.input).build();
        attachPresenter(this.searchResultPresenter);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<SearchAppResultWrapper> onViewItemClicked() {
        return this.onItemViewClickSubject;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<e.g.a.b.c.a.g> queryChanged() {
        return e.g.a.b.c.a.d.a(this.searchView);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void queryEvent(e.g.a.b.c.a.g gVar) {
        this.queryTextChangedPublisher.onNext(new SearchQueryEvent(gVar.d().toString(), gVar.c()));
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<Void> retryClicked() {
        return this.errorView.retryClick();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void scrollToTop() {
        RecyclerView recyclerView = this.searchResultList;
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() > 10) {
            recyclerView.scrollToPosition(10);
        }
        recyclerView.smoothScrollToPosition(0);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<MenuItem> searchMenuItemClick() {
        return e.g.a.b.c.a.e.a(this.toolbar).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7334f.j((MenuItem) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<Void> searchResultsReachedBottom() {
        return recyclerViewReachedBottom(this.searchResultList);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<Void> searchSetup() {
        return this.searchSetupPublishSubject;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void setAdultContentSwitch(Boolean bool) {
        this.noSearchAdultContentSwitch.setChecked(bool.booleanValue());
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void setSuggestionsList(List<String> list) {
        this.searchSuggestionsAdapter.addSuggestionsFromString(list);
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void setTrendingCursor(List<String> list) {
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void setTrendingList(List<Suggestion> list) {
        this.searchTrendingAdapter.addSuggestions(list);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void setUnsubmittedQuery(String str) {
        this.unsubmittedQuery = str;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void setVisibilityOnRestore() {
        if (this.focusInSearchBar) {
            return;
        }
        if (hasSearchResults()) {
            showResultsView();
        } else {
            showSuggestionsView();
        }
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public boolean shouldFocusInSearchBar() {
        return this.focusInSearchBar;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public boolean shouldHideUpNavigation() {
        return this.searchResultsAdapter.getItemCount() == 0 && !(this.noSearchLayout.getVisibility() == 0 && this.errorView.getVisibility() == 0);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public boolean shouldShowSuggestions() {
        return this.toolbar.getTitle().equals(getResources().getString(R.string.search_hint_title));
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showAdultContentConfirmationDialog() {
        this.enableAdultContentDialog.show();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showAdultContentConfirmationDialogWithPin() {
        this.enableAdultContentDialogWithPin.show();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showBannerAd() {
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showGenericErrorView() {
        this.errorView.setError(ErrorView.Error.GENERIC);
        this.errorView.setVisibility(0);
        this.noSearchLayout.setVisibility(8);
        this.searchResultsLayout.setVisibility(0);
        this.filtersCardView.setVisibility(0);
        this.searchResultList.setVisibility(8);
        this.suggestionsResultList.setVisibility(8);
        this.trendingResultList.setVisibility(8);
        this.networkError = true;
        this.noResults = true;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showLoading() {
        this.progressBar.setVisibility(0);
        this.noSearchLayout.setVisibility(8);
        this.errorView.setVisibility(8);
        this.searchResultsLayout.setVisibility(8);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showMoreLoading() {
        this.searchResultsAdapter.setMoreLoading();
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showNativeAds() {
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showNoNetworkView() {
        this.errorView.setError(ErrorView.Error.NO_NETWORK);
        this.errorView.setVisibility(0);
        this.noSearchLayout.setVisibility(8);
        this.searchResultsLayout.setVisibility(0);
        this.filtersCardView.setVisibility(0);
        this.searchResultList.setVisibility(8);
        this.suggestionsResultList.setVisibility(8);
        this.trendingResultList.setVisibility(8);
        this.networkError = true;
        this.noResults = true;
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showNoResultsView() {
        this.searchHasNoResults.onNext(null);
        this.noSearchLayout.setVisibility(0);
        this.searchResultsLayout.setVisibility(0);
        this.filtersCardView.setVisibility(0);
        this.searchResultList.setVisibility(8);
        this.suggestionsResultList.setVisibility(8);
        this.trendingResultList.setVisibility(8);
        this.noResults = true;
        this.noResultsPublishSubject.onNext(null);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showResultsLoading() {
        this.errorView.setVisibility(8);
        this.noSearchLayout.setVisibility(8);
        if (this.isFreshLoading) {
            return;
        }
        this.isFreshLoading = true;
        LayoutAnimationController layoutAnimationControllerLoadLayoutAnimation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.exit_list_apps_anim);
        layoutAnimationControllerLoadLayoutAnimation.getAnimation().setFillAfter(true);
        this.searchResultList.setLayoutAnimation(layoutAnimationControllerLoadLayoutAnimation);
        this.searchResultList.scheduleLayoutAnimation();
        this.progressBarResults.setVisibility(0);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_appear);
        animationLoadAnimation.setFillAfter(true);
        this.progressBarResults.startAnimation(animationLoadAnimation);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showResultsView() {
        this.noResults = false;
        this.noSearchLayout.setVisibility(8);
        this.errorView.setVisibility(8);
        this.suggestionsResultList.setVisibility(8);
        this.trendingResultList.setVisibility(8);
        this.searchResultList.setVisibility(0);
        this.searchResultsLayout.setVisibility(0);
    }

    public void showSuggestionsView() {
        if (this.searchView.getQuery().toString().isEmpty()) {
            this.noSearchLayout.setVisibility(8);
            this.errorView.setVisibility(8);
            this.searchResultsLayout.setVisibility(8);
            this.trendingResultList.setVisibility(0);
            this.suggestionsResultList.setVisibility(8);
            return;
        }
        this.noSearchLayout.setVisibility(8);
        this.errorView.setVisibility(8);
        this.searchResultsLayout.setVisibility(8);
        this.suggestionsResultList.setVisibility(0);
        this.trendingResultList.setVisibility(8);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void showWrongPinErrorMessage() {
        Snackbar.Z(getView(), R.string.adult_pin_wrong, 0);
        this.noSearchAdultContentSwitch.setChecked(false);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void toggleSuggestionsView() {
        this.suggestionsResultList.setVisibility(0);
        this.trendingResultList.setVisibility(8);
        this.noSearchLayout.setVisibility(8);
        this.errorView.setVisibility(8);
        this.searchResultList.setVisibility(8);
        this.searchResultsLayout.setVisibility(8);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public void toggleTrendingView() {
        this.suggestionsResultList.setVisibility(8);
        this.trendingResultList.setVisibility(0);
        this.noSearchLayout.setVisibility(8);
        this.errorView.setVisibility(8);
        this.searchResultList.setVisibility(8);
        this.searchResultsLayout.setVisibility(8);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<Void> toolbarClick() {
        return e.g.a.c.a.a(this.toolbar);
    }

    @Override // cm.aptoide.pt.search.view.SearchResultView
    public rx.e<Void> viewHasNoResults() {
        return this.noResultsPublishSubject;
    }

    public static SearchResultFragment newInstance(boolean z) {
        return newInstance(new SearchQueryModel(), false, z);
    }

    public static SearchResultFragment newInstance(SearchQueryModel searchQueryModel, boolean z) {
        SearchViewModel searchViewModel = new SearchViewModel(searchQueryModel, z);
        Bundle bundle = new Bundle();
        bundle.putParcelable(VIEW_MODEL, org.parceler.d.c(searchViewModel));
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        searchResultFragment.setArguments(bundle);
        return searchResultFragment;
    }

    public static SearchResultFragment newInstance(SearchQueryModel searchQueryModel, boolean z, boolean z2) {
        SearchViewModel searchViewModel = new SearchViewModel(searchQueryModel, z);
        Bundle bundle = new Bundle();
        bundle.putParcelable(VIEW_MODEL, org.parceler.d.c(searchViewModel));
        bundle.putBoolean(FOCUS_IN_SEARCH, z2);
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        searchResultFragment.setArguments(bundle);
        return searchResultFragment;
    }

    public static SearchResultFragment newInstance(SearchQueryModel searchQueryModel, String str, String str2) {
        SearchViewModel searchViewModel = new SearchViewModel(searchQueryModel, str, str2);
        Bundle bundle = new Bundle();
        bundle.putParcelable(VIEW_MODEL, org.parceler.d.c(searchViewModel));
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        searchResultFragment.setArguments(bundle);
        return searchResultFragment;
    }
}
