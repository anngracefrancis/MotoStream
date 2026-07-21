package cm.aptoide.pt.search.view;

import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.widget.SearchView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.search.SuggestionCursorAdapter;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.search.analytics.SearchSource;
import cm.aptoide.pt.search.model.Suggestion;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;
import cm.aptoide.pt.view.fragment.FragmentView;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class AppSearchSuggestionsView implements SearchSuggestionsView {
    private static final int COMPLETION_THRESHOLD = 0;
    private final CrashReport crashReport;
    private final String currentQuery;
    private final FragmentView parentView;
    private final rx.s.b<SearchQueryEvent> queryTextChangedPublisher;
    private final SearchAnalytics searchAnalytics;
    private MenuItem searchMenuItem;
    private SearchView searchView;
    private final SuggestionCursorAdapter suggestionCursorAdapter;
    private final rx.e<Void> toolbarClickObservable;
    private rx.e<MenuItem> toolbarMenuItemClick;

    public AppSearchSuggestionsView(FragmentView fragmentView, rx.e<Void> eVar, CrashReport crashReport, SuggestionCursorAdapter suggestionCursorAdapter, rx.s.b<SearchQueryEvent> bVar, rx.e<MenuItem> eVar2, SearchAnalytics searchAnalytics) {
        this(fragmentView, eVar, crashReport, HttpUrl.FRAGMENT_ENCODE_SET, suggestionCursorAdapter, bVar, eVar2, searchAnalytics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$initialize$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a(View.LifecycleEvent lifecycleEvent) {
        return e.g.a.b.c.a.d.a(this.searchView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$initialize$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(e.g.a.b.c.a.g gVar) {
        this.queryTextChangedPublisher.onNext(new SearchQueryEvent(gVar.d().toString(), gVar.c()));
    }

    static /* synthetic */ void lambda$initialize$3(e.g.a.b.c.a.g gVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$initialize$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchMenuItemClickExpandsSearch$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(View.LifecycleEvent lifecycleEvent) {
        return this.toolbarMenuItemClick;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchMenuItemClickExpandsSearch$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(MenuItem menuItem) {
        return Boolean.valueOf(menuItem.getItemId() == this.searchMenuItem.getItemId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchMenuItemClickExpandsSearch$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(MenuItem menuItem) {
        this.searchAnalytics.searchStart(SearchSource.SEARCH_ICON, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchMenuItemClickExpandsSearch$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(MenuItem menuItem) {
        focusInSearchBar();
    }

    static /* synthetic */ void lambda$searchMenuItemClickExpandsSearch$16(MenuItem menuItem) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$searchMenuItemClickExpandsSearch$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$toolbarClickExpandsSearch$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$toolbarClickExpandsSearch$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e j(View.LifecycleEvent lifecycleEvent) {
        return this.toolbarClickObservable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$toolbarClickExpandsSearch$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Void r3) {
        this.searchAnalytics.searchStart(SearchSource.SEARCH_TOOLBAR, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$toolbarClickExpandsSearch$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l(Void r1) {
        focusInSearchBar();
    }

    static /* synthetic */ void lambda$toolbarClickExpandsSearch$9(Void r0) {
    }

    private void searchMenuItemClickExpandsSearch() {
        getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.RESUME);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7369f.d((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7342f.e((MenuItem) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.l
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7429f.f((MenuItem) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.k
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7420f.g((MenuItem) obj);
            }
        }).f(bindUntilEvent(View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.b
            @Override // rx.m.b
            public final void call(Object obj) {
                AppSearchSuggestionsView.lambda$searchMenuItemClickExpandsSearch$16((MenuItem) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.m
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7438f.h((Throwable) obj);
            }
        });
    }

    private void toolbarClickExpandsSearch() {
        getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.RESUME);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7465f.j((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.j
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7411f.k((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.q
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7475f.l((Void) obj);
            }
        }).f(bindUntilEvent(View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.e
            @Override // rx.m.b
            public final void call(Object obj) {
                AppSearchSuggestionsView.lambda$toolbarClickExpandsSearch$9((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7396f.i((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.View
    public void attachPresenter(Presenter presenter) {
        this.parentView.attachPresenter(presenter);
    }

    @Override // cm.aptoide.pt.presenter.View
    public <T> com.trello.rxlifecycle.b<T> bindUntilEvent(View.LifecycleEvent lifecycleEvent) {
        return this.parentView.bindUntilEvent(lifecycleEvent);
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void collapseSearchBar(boolean z) {
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem != null) {
            menuItem.collapseActionView();
        }
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void focusInSearchBar() {
        MenuItem menuItem = this.searchMenuItem;
        if (menuItem != null) {
            menuItem.expandActionView();
        }
        if (this.searchView == null || getCurrentQuery().isEmpty()) {
            return;
        }
        this.searchView.d0(getCurrentQuery(), false);
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public String getCurrentQuery() {
        String str = this.currentQuery;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // cm.aptoide.pt.presenter.View
    public rx.e<View.LifecycleEvent> getLifecycleEvent() {
        return this.parentView.getLifecycleEvent();
    }

    public void initialize(MenuItem menuItem) {
        this.searchMenuItem = menuItem;
        SearchView searchView = (SearchView) menuItem.getActionView();
        this.searchView = searchView;
        searchView.setSuggestionsAdapter(this.suggestionCursorAdapter);
        this.searchView.setOnSuggestionListener(new SearchView.m() { // from class: cm.aptoide.pt.search.view.AppSearchSuggestionsView.1
            @Override // androidx.appcompat.widget.SearchView.m
            public boolean onSuggestionClick(int i2) {
                AppSearchSuggestionsView.this.queryTextChangedPublisher.onNext(new SearchQueryEvent(AppSearchSuggestionsView.this.suggestionCursorAdapter.getSuggestionAt(i2).toString(), i2, true, true));
                return true;
            }

            @Override // androidx.appcompat.widget.SearchView.m
            public boolean onSuggestionSelect(int i2) {
                return false;
            }
        });
        ((AutoCompleteTextView) this.searchView.findViewById(R.id.search_src_text)).setThreshold(0);
        getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.RESUME);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7456f.a((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.g
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7378f.b((e.g.a.b.c.a.g) obj);
            }
        }).f(bindUntilEvent(View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.d
            @Override // rx.m.b
            public final void call(Object obj) {
                AppSearchSuggestionsView.lambda$initialize$3((e.g.a.b.c.a.g) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.r
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7484f.c((Throwable) obj);
            }
        });
        toolbarClickExpandsSearch();
        searchMenuItemClickExpandsSearch();
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public rx.e<SearchQueryEvent> onQueryTextChanged() {
        return this.queryTextChangedPublisher;
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void setSuggestionsList(List<String> list) {
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void setTrendingCursor(List<String> list) {
        this.suggestionCursorAdapter.setData(list);
    }

    @Override // cm.aptoide.pt.search.view.SearchSuggestionsView
    public void setTrendingList(List<Suggestion> list) {
    }

    public AppSearchSuggestionsView(FragmentView fragmentView, rx.e<Void> eVar, CrashReport crashReport, String str, SuggestionCursorAdapter suggestionCursorAdapter, rx.s.b<SearchQueryEvent> bVar, rx.e<MenuItem> eVar2, SearchAnalytics searchAnalytics) {
        this.parentView = fragmentView;
        this.toolbarClickObservable = eVar;
        this.crashReport = crashReport;
        this.currentQuery = str;
        this.suggestionCursorAdapter = suggestionCursorAdapter;
        this.queryTextChangedPublisher = bVar;
        this.toolbarMenuItemClick = eVar2;
        this.searchAnalytics = searchAnalytics;
    }
}
