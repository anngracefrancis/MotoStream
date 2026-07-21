package cm.aptoide.pt.search.view;

import cm.aptoide.pt.themes.ThemeManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class SearchResultFragment_MembersInjector implements f.a<SearchResultFragment> {
    private final Provider<SearchResultPresenter> searchResultPresenterProvider;
    private final Provider<ThemeManager> themeManagerProvider;

    public SearchResultFragment_MembersInjector(Provider<SearchResultPresenter> provider, Provider<ThemeManager> provider2) {
        this.searchResultPresenterProvider = provider;
        this.themeManagerProvider = provider2;
    }

    public static f.a<SearchResultFragment> create(Provider<SearchResultPresenter> provider, Provider<ThemeManager> provider2) {
        return new SearchResultFragment_MembersInjector(provider, provider2);
    }

    public static void injectSearchResultPresenter(SearchResultFragment searchResultFragment, SearchResultPresenter searchResultPresenter) {
        searchResultFragment.searchResultPresenter = searchResultPresenter;
    }

    public static void injectThemeManager(SearchResultFragment searchResultFragment, ThemeManager themeManager) {
        searchResultFragment.themeManager = themeManager;
    }

    public void injectMembers(SearchResultFragment searchResultFragment) {
        injectSearchResultPresenter(searchResultFragment, this.searchResultPresenterProvider.get());
        injectThemeManager(searchResultFragment, this.themeManagerProvider.get());
    }
}
