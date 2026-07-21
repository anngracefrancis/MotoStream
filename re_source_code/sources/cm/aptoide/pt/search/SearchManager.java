package cm.aptoide.pt.search;

import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.aptoideviews.filters.Filter;
import cm.aptoide.pt.app.mmpcampaigns.Campaign;
import cm.aptoide.pt.download.view.DownloadStatusManager;
import cm.aptoide.pt.download.view.DownloadStatusModel;
import cm.aptoide.pt.search.model.SearchAppResult;
import cm.aptoide.pt.search.model.SearchFilterType;
import cm.aptoide.pt.search.model.SearchFilters;
import cm.aptoide.pt.search.model.SearchResult;
import cm.aptoide.pt.view.app.AppCenter;
import cm.aptoide.pt.view.app.AppScreenshot;
import cm.aptoide.pt.view.app.DetailedAppRequestResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SearchManager {
    private final AptoideAccountManager accountManager;
    private final AppCenter appCenter;
    private final DownloadStatusManager downloadStatusManager;
    private final SearchRepository searchRepository;

    public SearchManager(AptoideAccountManager aptoideAccountManager, SearchRepository searchRepository, DownloadStatusManager downloadStatusManager, AppCenter appCenter) {
        this.accountManager = aptoideAccountManager;
        this.searchRepository = searchRepository;
        this.downloadStatusManager = downloadStatusManager;
        this.appCenter = appCenter;
    }

    private rx.e<SearchResult> getHighlightedSearchResult(SearchResult searchResult) {
        return rx.e.S(new SearchResult(searchResult.getQuery(), searchResult.getSpecificStore(), searchResult.getSearchResultsList(), searchResult.getFilters(), searchResult.getCurrentOffset(), searchResult.getNextOffset(), searchResult.getTotal(), searchResult.getLoading(), false, searchResult.getError()));
    }

    static /* synthetic */ List lambda$loadAppScreenShots$4(DetailedAppRequestResult detailedAppRequestResult) {
        List listEmptyList = Collections.emptyList();
        return (detailedAppRequestResult == null || detailedAppRequestResult.getDetailedApp() == null || detailedAppRequestResult.getDetailedApp().getMedia() == null || detailedAppRequestResult.getDetailedApp().getMedia().getScreenshots() == null) ? listEmptyList : detailedAppRequestResult.getDetailedApp().getMedia().getScreenshots();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeHighlightedSearchResult$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResult a(DetailedAppRequestResult detailedAppRequestResult, SearchResult searchResult, DownloadStatusModel downloadStatusModel, List list) {
        return mergeSearchResult(searchResult, downloadStatusModel, list, detailedAppRequestResult.getDetailedApp().getBdsFlags().contains("STORE_BDS"), detailedAppRequestResult.getDetailedApp().getAppCategory(), detailedAppRequestResult.getDetailedApp().getCampaign());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeHighlightedSearchResult$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(SearchResult searchResult, SearchAppResult searchAppResult, final DetailedAppRequestResult detailedAppRequestResult) {
        return rx.e.d(getHighlightedSearchResult(searchResult), this.downloadStatusManager.loadDownloadModel(searchAppResult.getMd5(), searchAppResult.getPackageName(), searchAppResult.getVersionCode(), detailedAppRequestResult.getDetailedApp().getSignature(), searchAppResult.getStoreId().longValue(), searchAppResult.hasAdvertising() || searchAppResult.hasBilling()), loadAppScreenShots(searchAppResult.getAppId(), searchAppResult.getStoreName(), searchAppResult.getPackageName()), new rx.m.g() { // from class: cm.aptoide.pt.search.c
            @Override // rx.m.g
            public final Object a(Object obj, Object obj2, Object obj3) {
                return this.a.a(detailedAppRequestResult, (SearchResult) obj, (DownloadStatusModel) obj2, (List) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$observeSearchResults$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(SearchResult searchResult) {
        List<SearchAppResult> searchResultsList = searchResult.getSearchResultsList();
        if (searchResultsList.isEmpty() || !searchResultsList.get(0).isHighlightedResult()) {
            return rx.e.S(searchResult);
        }
        return searchResult.isFreshResult() ? rx.e.f0(rx.e.S(searchResult), observeHighlightedSearchResult(searchResult)) : observeHighlightedSearchResult(searchResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchAppInStores$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b d(String str, List list, boolean z, Boolean bool) {
        return this.searchRepository.generalSearch(str, getSearchFilters(list), bool.booleanValue(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchInStore$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(String str, List list, String str2, boolean z, Boolean bool) {
        return this.searchRepository.searchInStore(str, getSearchFilters(list), bool.booleanValue(), str2, z);
    }

    private rx.e<List<AppScreenshot>> loadAppScreenShots(long j2, String str, String str2) {
        return rx.e.f0(rx.e.S(null), this.appCenter.unsafeLoadDetailedApp(j2, str, str2).A()).X(new rx.m.e() { // from class: cm.aptoide.pt.search.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SearchManager.lambda$loadAppScreenShots$4((DetailedAppRequestResult) obj);
            }
        }).R0(700L, TimeUnit.MILLISECONDS);
    }

    private SearchResult mergeSearchResult(SearchResult searchResult, DownloadStatusModel downloadStatusModel, List<AppScreenshot> list, boolean z, String str, Campaign campaign) {
        ArrayList arrayList = new ArrayList(searchResult.getSearchResultsList());
        arrayList.set(0, new SearchAppResult((SearchAppResult) arrayList.get(0), downloadStatusModel, list, z, str, campaign));
        return new SearchResult(searchResult.getQuery(), searchResult.getSpecificStore(), arrayList, searchResult.getFilters(), searchResult.getCurrentOffset(), searchResult.getNextOffset(), searchResult.getTotal(), searchResult.getLoading(), searchResult.isFreshResult(), searchResult.getError());
    }

    public rx.b disableAdultContent() {
        return this.accountManager.disable();
    }

    public rx.b enableAdultContent() {
        return this.accountManager.enable();
    }

    public rx.b enableAdultContentWithPin(int i2) {
        return this.accountManager.enable(i2);
    }

    public SearchFilters getSearchFilters(List<Filter> list) {
        boolean selected = false;
        boolean selected2 = false;
        boolean selected3 = false;
        boolean selected4 = false;
        for (Filter filter : list) {
            if (filter.getIdentifier() != null) {
                if (filter.getIdentifier().equals(SearchFilterType.FOLLOWED_STORES.name())) {
                    selected = filter.getSelected();
                } else if (filter.getIdentifier().equals(SearchFilterType.TRUSTED.name())) {
                    selected2 = filter.getSelected();
                } else if (filter.getIdentifier().equals(SearchFilterType.BETA.name())) {
                    selected3 = filter.getSelected();
                } else if (filter.getIdentifier().equals(SearchFilterType.APPC.name())) {
                    selected4 = filter.getSelected();
                }
            }
        }
        return new SearchFilters(selected, selected2, selected3, selected4);
    }

    public rx.e<Boolean> isAdultContentEnabled() {
        return this.accountManager.hasMatureContentEnabled();
    }

    public rx.e<Boolean> isAdultContentPinRequired() {
        return this.accountManager.pinRequired();
    }

    public rx.e<SearchResult> observeHighlightedSearchResult(final SearchResult searchResult) {
        final SearchAppResult searchAppResult = searchResult.getSearchResultsList().get(0);
        return this.appCenter.unsafeLoadDetailedApp(searchAppResult.getAppId(), searchAppResult.getStoreName(), searchAppResult.getPackageName()).A().G(new rx.m.e() { // from class: cm.aptoide.pt.search.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7263f.b(searchResult, searchAppResult, (DetailedAppRequestResult) obj);
            }
        });
    }

    public rx.e<SearchResult> observeSearchResults() {
        return this.searchRepository.observeSearchResults().L0(new rx.m.e() { // from class: cm.aptoide.pt.search.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7277f.c((SearchResult) obj);
            }
        });
    }

    public rx.b searchAppInStores(final String str, final List<Filter> list, final boolean z) {
        return this.accountManager.hasMatureContentEnabled().E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.search.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7273f.d(str, list, z, (Boolean) obj);
            }
        });
    }

    public rx.b searchInStore(final String str, final String str2, final List<Filter> list, final boolean z) {
        return this.accountManager.hasMatureContentEnabled().E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.search.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7268f.e(str, list, str2, z, (Boolean) obj);
            }
        });
    }
}
