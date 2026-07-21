package cm.aptoide.pt.search.view;

import android.content.DialogInterface;
import android.view.MenuItem;
import cm.aptoide.aptoideviews.filters.Filter;
import cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent;
import cm.aptoide.pt.download.view.DownloadClick;
import cm.aptoide.pt.search.model.SearchAppResult;
import cm.aptoide.pt.search.model.SearchAppResultWrapper;
import cm.aptoide.pt.search.model.SearchQueryModel;
import cm.aptoide.pt.search.model.SearchResultError;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SearchResultView extends SearchSuggestionsView {

    public interface Model {
        List<Filter> getFilters();

        SearchQueryModel getSearchQueryModel();

        String getStoreName();

        String getStoreTheme();

        boolean hasLoadedAds();

        boolean hasLoadedResults();
    }

    void addAllStoresResult(String str, List<SearchAppResult> list, boolean z, boolean z2, boolean z3, SearchResultError searchResultError);

    rx.e<DialogInterface> adultContentDialogNegativeClick();

    rx.e<DialogInterface> adultContentDialogPositiveClick();

    rx.e<DialogInterface> adultContentPinDialogNegativeClick();

    rx.e<CharSequence> adultContentWithPinDialogPositiveClick();

    void clearUnsubmittedQuery();

    rx.e<Boolean> clickAdultContentSwitch();

    void disableAdultContent();

    void disableUpNavigation();

    void enableAdultContent();

    rx.e<List<Filter>> filtersChangeEvents();

    rx.e<DownloadClick> getDownloadClickEvents();

    rx.e<ScreenShotClickEvent> getScreenshotClickEvent();

    Model getViewModel();

    boolean hasResults();

    void hideLoading();

    void hideSuggestionsViews();

    boolean isSearchViewExpanded();

    rx.e<c.i.j.e<String, SearchQueryEvent>> listenToSuggestionClick();

    rx.e<SearchAppResultWrapper> onViewItemClicked();

    rx.e<e.g.a.b.c.a.g> queryChanged();

    void queryEvent(e.g.a.b.c.a.g gVar);

    rx.e<Void> retryClicked();

    void scrollToTop();

    rx.e<MenuItem> searchMenuItemClick();

    rx.e<Void> searchResultsReachedBottom();

    rx.e<Void> searchSetup();

    void setAdultContentSwitch(Boolean bool);

    void setUnsubmittedQuery(String str);

    void setVisibilityOnRestore();

    boolean shouldFocusInSearchBar();

    boolean shouldHideUpNavigation();

    boolean shouldShowSuggestions();

    void showAdultContentConfirmationDialog();

    void showAdultContentConfirmationDialogWithPin();

    void showBannerAd();

    void showGenericErrorView();

    void showLoading();

    void showMoreLoading();

    void showNativeAds();

    void showNoNetworkView();

    void showNoResultsView();

    void showResultsLoading();

    void showResultsView();

    void showWrongPinErrorMessage();

    void toggleSuggestionsView();

    void toggleTrendingView();

    rx.e<Void> toolbarClick();

    rx.e<Void> viewHasNoResults();
}
