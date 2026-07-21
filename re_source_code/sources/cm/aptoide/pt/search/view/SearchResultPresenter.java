package cm.aptoide.pt.search.view;

import android.content.DialogInterface;
import android.view.MenuItem;
import cm.aptoide.aptoideviews.filters.Filter;
import cm.aptoide.pt.app.view.screenshots.ScreenShotClickEvent;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.bottomNavigation.BottomNavigationMapper;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.download.DownloadAnalytics;
import cm.aptoide.pt.download.view.DownloadStatusModel;
import cm.aptoide.pt.download.view.DownloadViewActionPresenter;
import cm.aptoide.pt.home.AptoideBottomNavigator;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import cm.aptoide.pt.search.SearchManager;
import cm.aptoide.pt.search.SearchNavigator;
import cm.aptoide.pt.search.analytics.SearchAnalytics;
import cm.aptoide.pt.search.analytics.SearchSource;
import cm.aptoide.pt.search.model.SearchAppResultWrapper;
import cm.aptoide.pt.search.model.SearchQueryModel;
import cm.aptoide.pt.search.model.SearchResult;
import cm.aptoide.pt.search.model.Source;
import cm.aptoide.pt.search.suggestions.SearchQueryEvent;
import cm.aptoide.pt.search.suggestions.SearchSuggestionManager;
import cm.aptoide.pt.search.suggestions.TrendingManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.HttpUrl;
import rx.Single;
import rx.exceptions.OnErrorNotImplementedException;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class SearchResultPresenter implements Presenter {
    private static final String TAG = "cm.aptoide.pt.search.view.SearchResultPresenter";
    private final SearchAnalytics analytics;
    private final BottomNavigationMapper bottomNavigationMapper;
    private final AptoideBottomNavigator bottomNavigator;
    private final CrashReport crashReport;
    private final DownloadViewActionPresenter downloadActionPresenter;
    private final rx.h ioScheduler;
    private final SearchNavigator navigator;
    private final SearchManager searchManager;
    private final SearchSuggestionManager suggestionManager;
    private final TrendingManager trendingManager;
    private final SearchResultView view;
    private final rx.h viewScheduler;

    public SearchResultPresenter(SearchResultView searchResultView, SearchAnalytics searchAnalytics, SearchNavigator searchNavigator, CrashReport crashReport, rx.h hVar, SearchManager searchManager, TrendingManager trendingManager, SearchSuggestionManager searchSuggestionManager, AptoideBottomNavigator aptoideBottomNavigator, BottomNavigationMapper bottomNavigationMapper, rx.h hVar2, DownloadViewActionPresenter downloadViewActionPresenter) {
        this.view = searchResultView;
        this.analytics = searchAnalytics;
        this.navigator = searchNavigator;
        this.crashReport = crashReport;
        this.viewScheduler = hVar;
        this.searchManager = searchManager;
        this.trendingManager = trendingManager;
        this.suggestionManager = searchSuggestionManager;
        this.bottomNavigator = aptoideBottomNavigator;
        this.bottomNavigationMapper = bottomNavigationMapper;
        this.ioScheduler = hVar2;
        this.downloadActionPresenter = downloadViewActionPresenter;
    }

    private rx.e<SearchQueryEvent> getDebouncedQueryChanges() {
        return this.view.onQueryTextChanged().m(250L, TimeUnit.MILLISECONDS);
    }

    private void handleAdultContentDialogNegativeClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.h3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.f6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7376f.l((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.a6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7331f.m((DialogInterface) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.m2
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleAdultContentDialogNegativeClick$73((DialogInterface) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.w5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7534f.n((Throwable) obj);
            }
        });
    }

    private void handleAdultContentDialogPositiveClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.e2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7504f.o((View.LifecycleEvent) obj);
            }
        }).j0(Schedulers.io()).H(new rx.m.e() { // from class: cm.aptoide.pt.search.view.h4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7392f.p((DialogInterface) obj);
            }
        }).j0(this.viewScheduler).w(new rx.m.b() { // from class: cm.aptoide.pt.search.view.f5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7375f.q((Throwable) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.q4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleAdultContentDialogPositiveClick$68((DialogInterface) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.l4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7434f.r((Throwable) obj);
            }
        });
    }

    private void handleAdultContentDialogWithPinPositiveClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.q3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.a1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7326f.u((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.j1
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleAdultContentDialogWithPinPositiveClick$79(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.x3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7540f.v((Throwable) obj);
            }
        });
    }

    private void handleClickOnScreenshot() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.v1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7522f.K((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.t2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((ScreenShotClickEvent) obj).isVideo());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.q2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7478f.L((ScreenShotClickEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.k4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickOnScreenshot$17((ScreenShotClickEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.n5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7453f.M((Throwable) obj);
            }
        });
    }

    private void handleErrorRetryClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7347f.Q((View.LifecycleEvent) obj);
            }
        }).j0(this.viewScheduler).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.x4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7541f.R((Void) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.search.view.v2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7523f.S((SearchResultView.Model) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        a4 a4Var = new rx.m.b() { // from class: cm.aptoide.pt.search.view.a4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleErrorRetryClick$23((SearchResultView.Model) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(a4Var, new a(crashReport));
    }

    private void handleFiltersClick() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.v4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7525f.T((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.w2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7531f.U((SearchResultView.Model) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        s3 s3Var = new rx.m.b() { // from class: cm.aptoide.pt.search.view.s3
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleFiltersClick$12((SearchResultView.Model) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(s3Var, new a(crashReport));
    }

    private void handleNewSearchResults() {
        rx.e eVarF = this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.a5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7330f.c0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.s1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7495f.f0((SearchResultView.Model) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY));
        s0 s0Var = new rx.m.b() { // from class: cm.aptoide.pt.search.view.s0
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleNewSearchResults$5((SearchResult) obj);
            }
        };
        CrashReport crashReport = this.crashReport;
        crashReport.getClass();
        eVarF.H0(s0Var, new a(crashReport));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$doFirstSearch$82, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResultView.Model a(View.LifecycleEvent lifecycleEvent) {
        return this.view.getViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$doFirstSearch$83, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(SearchResultView.Model model) {
        return search(model, model.hasLoadedResults());
    }

    static /* synthetic */ void lambda$doFirstSearch$84(SearchResultView.Model model) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$doFirstSearch$85, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$focusInSearchBar$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchSetup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$focusInSearchBar$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(Void r1) {
        return Boolean.valueOf(this.view.shouldFocusInSearchBar());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$focusInSearchBar$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Void r1) {
        this.view.focusInSearchBar();
    }

    static /* synthetic */ void lambda$focusInSearchBar$40(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$focusInSearchBar$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getTrendingOnStart$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchSetup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getTrendingOnStart$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(List list) {
        this.view.setTrendingList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getTrendingOnStart$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single j(Void r2) {
        return this.trendingManager.getTrendingListSuggestions().p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.search.view.d3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7355f.i((List) obj);
            }
        });
    }

    static /* synthetic */ void lambda$getTrendingOnStart$34(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getTrendingOnStart$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogNegativeClick$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e l(View.LifecycleEvent lifecycleEvent) {
        return rx.e.a0(this.view.adultContentPinDialogNegativeClick(), this.view.adultContentDialogNegativeClick());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogNegativeClick$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m(DialogInterface dialogInterface) {
        this.view.disableAdultContent();
    }

    static /* synthetic */ void lambda$handleAdultContentDialogNegativeClick$73(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogNegativeClick$74, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogPositiveClick$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o(View.LifecycleEvent lifecycleEvent) {
        return this.view.adultContentDialogPositiveClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogPositiveClick$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b p(DialogInterface dialogInterface) {
        return this.searchManager.enableAdultContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogPositiveClick$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void q(Throwable th) {
        this.view.disableAdultContent();
    }

    static /* synthetic */ void lambda$handleAdultContentDialogPositiveClick$68(DialogInterface dialogInterface) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogPositiveClick$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void r(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogWithPinPositiveClick$76, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s(Throwable th) {
        if (th instanceof SecurityException) {
            this.view.showWrongPinErrorMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogWithPinPositiveClick$77, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e t(CharSequence charSequence) {
        return this.searchManager.enableAdultContentWithPin(charSequence.toString().isEmpty() ? 0 : Integer.valueOf(charSequence.toString()).intValue()).M().j0(this.viewScheduler).w(new rx.m.b() { // from class: cm.aptoide.pt.search.view.y0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7545f.s((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogWithPinPositiveClick$78, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e u(View.LifecycleEvent lifecycleEvent) {
        return this.view.adultContentWithPinDialogPositiveClick().j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.h6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7394f.t((CharSequence) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleAdultContentDialogWithPinPositiveClick$79(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleAdultContentDialogWithPinPositiveClick$80, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void v(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAdultContentSwitch$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e w(View.LifecycleEvent lifecycleEvent) {
        return this.view.clickAdultContentSwitch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAdultContentSwitch$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void x(Throwable th) {
        this.view.enableAdultContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAdultContentSwitch$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e y(Boolean bool) {
        return !bool.booleanValue() ? this.searchManager.disableAdultContent().z(this.viewScheduler).n(new rx.m.b() { // from class: cm.aptoide.pt.search.view.j6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7418f.x((Throwable) obj);
            }
        }).M().X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.z3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.FALSE;
            }
        }) : rx.e.S(Boolean.TRUE);
    }

    static /* synthetic */ Boolean lambda$handleClickOnAdultContentSwitch$59(Boolean bool) {
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAdultContentSwitch$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z(Boolean bool) {
        return this.searchManager.isAdultContentPinRequired();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAdultContentSwitch$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(Boolean bool) {
        if (bool.booleanValue()) {
            this.view.showAdultContentConfirmationDialogWithPin();
        } else {
            this.view.showAdultContentConfirmationDialog();
        }
    }

    static /* synthetic */ void lambda$handleClickOnAdultContentSwitch$62(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnAdultContentSwitch$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithResults$145, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean C(Integer num) {
        return Boolean.valueOf(this.bottomNavigationMapper.mapItemClicked(num).equals(BottomNavigationItem.SEARCH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithResults$146, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean D(Integer num) {
        return Boolean.valueOf(this.view.hasResults());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithResults$147, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(Integer num) {
        this.view.scrollToTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithResults$148, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e F(View.LifecycleEvent lifecycleEvent) {
        return this.bottomNavigator.navigationEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.o2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7459f.C((Integer) obj);
            }
        }).j0(this.viewScheduler).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.n3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7451f.D((Integer) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.u5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7518f.E((Integer) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleClickOnBottomNavWithResults$149(Integer num) {
    }

    static /* synthetic */ void lambda$handleClickOnBottomNavWithResults$150(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithoutResults$152, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean G(Integer num) {
        return Boolean.valueOf(this.bottomNavigationMapper.mapItemClicked(num).equals(BottomNavigationItem.SEARCH));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithoutResults$153, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean H(Integer num) {
        return Boolean.valueOf(!this.view.hasResults());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithoutResults$154, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(Integer num) {
        this.view.focusInSearchBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnBottomNavWithoutResults$155, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e J(View.LifecycleEvent lifecycleEvent) {
        return this.bottomNavigator.navigationEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7402f.G((Integer) obj);
            }
        }).j0(this.viewScheduler).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.w0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7529f.H((Integer) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.p2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7469f.I((Integer) obj);
            }
        }).s0();
    }

    static /* synthetic */ void lambda$handleClickOnBottomNavWithoutResults$156(Integer num) {
    }

    static /* synthetic */ void lambda$handleClickOnBottomNavWithoutResults$157(Throwable th) {
        throw new OnErrorNotImplementedException(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnScreenshot$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e K(View.LifecycleEvent lifecycleEvent) {
        return this.view.getScreenshotClickEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnScreenshot$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void L(ScreenShotClickEvent screenShotClickEvent) {
        this.navigator.navigateToScreenshots(screenShotClickEvent.getImagesUris(), screenShotClickEvent.getImagesIndex());
    }

    static /* synthetic */ void lambda$handleClickOnScreenshot$17(ScreenShotClickEvent screenShotClickEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickOnScreenshot$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickToOpenAppViewFromItem$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e N(View.LifecycleEvent lifecycleEvent) {
        return this.view.onViewItemClicked();
    }

    static /* synthetic */ void lambda$handleClickToOpenAppViewFromItem$52(SearchAppResultWrapper searchAppResultWrapper) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleClickToOpenAppViewFromItem$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void P(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleErrorRetryClick$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e Q(View.LifecycleEvent lifecycleEvent) {
        return this.view.retryClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleErrorRetryClick$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResultView.Model R(Void r1) {
        return this.view.getViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleErrorRetryClick$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b S(SearchResultView.Model model) {
        return search(model, false);
    }

    static /* synthetic */ void lambda$handleErrorRetryClick$23(SearchResultView.Model model) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFiltersClick$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e T(View.LifecycleEvent lifecycleEvent) {
        return this.view.filtersChangeEvents().X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.g6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7385f.V((List) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.r3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7488f.W((SearchResultView.Model) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.search.view.u3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7516f.X((SearchResultView.Model) obj);
            }
        }).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFiltersClick$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(SearchResultView.Model model) {
        this.view.getViewModel();
    }

    static /* synthetic */ void lambda$handleFiltersClick$12(SearchResultView.Model model) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFiltersClick$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResultView.Model V(List list) {
        return this.view.getViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFiltersClick$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(SearchResultView.Model model) {
        this.view.showResultsLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFiltersClick$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b X(SearchResultView.Model model) {
        return loadData(model.getSearchQueryModel().getFinalQuery(), model.getStoreName(), model.getFilters(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFragmentRestorationVisibility$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e Y(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchSetup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFragmentRestorationVisibility$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean Z(Void r1) {
        return Boolean.valueOf(!this.view.shouldFocusInSearchBar() && this.view.shouldShowSuggestions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFragmentRestorationVisibility$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a0(Void r1) {
        this.view.setVisibilityOnRestore();
    }

    static /* synthetic */ void lambda$handleFragmentRestorationVisibility$28(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleFragmentRestorationVisibility$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNewSearchResults$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResultView.Model c0(View.LifecycleEvent lifecycleEvent) {
        return this.view.getViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNewSearchResults$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d0(SearchResult searchResult) {
        this.view.addAllStoresResult(searchResult.getQuery(), searchResult.getSearchResultsList(), searchResult.isFreshResult(), searchResult.hasMore(), searchResult.hasError(), searchResult.getError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNewSearchResults$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e0(SearchResultView.Model model, SearchResult searchResult) {
        if (searchResult.hasError() || searchResult.getSearchResultsList().size() != 0) {
            return;
        }
        this.analytics.searchNoResults(model.getSearchQueryModel());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleNewSearchResults$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f0(final SearchResultView.Model model) {
        return this.searchManager.observeSearchResults().j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.d6
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7358f.d0((SearchResult) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.p1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7467f.e0(model, (SearchResult) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleNewSearchResults$5(SearchResult searchResult) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextChanged$109, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g0(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchSetup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextChanged$110, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e h0(Void r1) {
        return getDebouncedQueryChanges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextChanged$113, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i0(String str) {
        this.view.setUnsubmittedQuery(str);
    }

    static /* synthetic */ Single lambda$handleQueryTextChanged$114(Throwable th) {
        if (th instanceof TimeoutException) {
            Logger.getInstance().i(TAG, "Timeout reached while waiting for application suggestions");
        }
        return Single.h(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextChanged$115, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j0(List list) {
        this.view.setSuggestionsList(list);
        this.view.toggleSuggestionsView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextChanged$116, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single k0(String str) {
        return this.suggestionManager.getSuggestionsForApp(str).q(new rx.m.e() { // from class: cm.aptoide.pt.search.view.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return SearchResultPresenter.lambda$handleQueryTextChanged$114((Throwable) obj);
            }
        }).p(this.viewScheduler).g(new rx.m.b() { // from class: cm.aptoide.pt.search.view.t1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7505f.j0((List) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleQueryTextChanged$117(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextChanged$118, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void l0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextCleaned$103, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean m0(SearchQueryEvent searchQueryEvent) {
        return Boolean.valueOf(!searchQueryEvent.hasQuery() && this.view.isSearchViewExpanded());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextCleaned$104, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void n0(SearchQueryEvent searchQueryEvent) {
        this.view.clearUnsubmittedQuery();
        this.view.toggleTrendingView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextCleaned$105, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e o0(View.LifecycleEvent lifecycleEvent) {
        return getDebouncedQueryChanges().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.b2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7336f.m0((SearchQueryEvent) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.r5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7490f.n0((SearchQueryEvent) obj);
            }
        });
    }

    static /* synthetic */ void lambda$handleQueryTextCleaned$106(SearchQueryEvent searchQueryEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextCleaned$107, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void p0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextSubmitted$120, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e q0(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchSetup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextSubmitted$121, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e r0(Void r1) {
        return getDebouncedQueryChanges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextSubmitted$123, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s0(SearchQueryEvent searchQueryEvent) {
        this.view.collapseSearchBar(false);
        this.view.hideSuggestionsViews();
        SearchQueryModel searchQueryModel = new SearchQueryModel(searchQueryEvent.getQuery());
        this.analytics.search(searchQueryModel);
        this.navigator.navigate(searchQueryModel);
    }

    static /* synthetic */ void lambda$handleQueryTextSubmitted$124(SearchQueryEvent searchQueryEvent) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleQueryTextSubmitted$125, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void t0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchListReachedBottom$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e u0(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchResultsReachedBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchListReachedBottom$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResultView.Model v0(Void r1) {
        return this.view.getViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchListReachedBottom$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w0(SearchResultView.Model model) {
        this.view.showMoreLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchListReachedBottom$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b x0(SearchResultView.Model model) {
        return loadData(model.getSearchQueryModel().getFinalQuery(), model.getStoreName(), model.getFilters(), false);
    }

    static /* synthetic */ void lambda$handleSearchListReachedBottom$47(SearchResultView.Model model) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchListReachedBottom$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchMenuItemClick$139, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e z0(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchMenuItemClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchMenuItemClick$140, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A0(MenuItem menuItem) {
        if (this.view.shouldFocusInSearchBar()) {
            return;
        }
        this.analytics.searchStart(SearchSource.SEARCH_ICON, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchMenuItemClick$141, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B0(MenuItem menuItem) {
        this.view.focusInSearchBar();
    }

    static /* synthetic */ void lambda$handleSearchMenuItemClick$142(MenuItem menuItem) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSearchMenuItemClick$143, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSuggestionClicked$127, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e D0(View.LifecycleEvent lifecycleEvent) {
        return this.view.listenToSuggestionClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$handleSuggestionClicked$129, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E0(c.i.j.e eVar) {
        this.view.collapseSearchBar(false);
        this.view.hideSuggestionsViews();
        SearchQueryModel searchQueryModel = new SearchQueryModel((String) eVar.a, ((SearchQueryEvent) eVar.f3281b).getQuery(), ((String) eVar.a).isEmpty() ? Source.FROM_TRENDING : Source.FROM_AUTOCOMPLETE);
        this.navigator.navigate(searchQueryModel);
        this.analytics.searchFromSuggestion(searchQueryModel, ((SearchQueryEvent) eVar.f3281b).getPosition());
    }

    static /* synthetic */ void lambda$handleSuggestionClicked$130(c.i.j.e eVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleSuggestionClicked$131, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleToolbarClick$133, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e G0(View.LifecycleEvent lifecycleEvent) {
        return this.view.toolbarClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleToolbarClick$134, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void H0(Void r3) {
        if (this.view.shouldFocusInSearchBar()) {
            return;
        }
        this.analytics.searchStart(SearchSource.SEARCH_TOOLBAR, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleToolbarClick$135, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I0(Void r1) {
        this.view.focusInSearchBar();
    }

    static /* synthetic */ void lambda$handleToolbarClick$136(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleToolbarClick$137, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void J0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$listenToSearchQueries$159, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e K0(View.LifecycleEvent lifecycleEvent) {
        return this.view.searchSetup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$listenToSearchQueries$160, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e L0(Void r1) {
        return this.view.queryChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$listenToSearchQueries$161, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M0(e.g.a.b.c.a.g gVar) {
        this.view.queryEvent(gVar);
    }

    static /* synthetic */ void lambda$listenToSearchQueries$162(e.g.a.b.c.a.g gVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$listenToSearchQueries$163, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void N0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$redoSearchAfterAdultContentSwitch$87, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e O0(View.LifecycleEvent lifecycleEvent) {
        return rx.e.a0(this.view.adultContentDialogPositiveClick(), this.view.adultContentWithPinDialogPositiveClick());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$redoSearchAfterAdultContentSwitch$88, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ SearchResultView.Model P0(Object obj) {
        return this.view.getViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$redoSearchAfterAdultContentSwitch$89, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b Q0(SearchResultView.Model model) {
        return search(model, false);
    }

    static /* synthetic */ void lambda$redoSearchAfterAdultContentSwitch$90(SearchResultView.Model model) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$redoSearchAfterAdultContentSwitch$91, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void R0(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$search$100, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(SearchResultView.Model model) {
        this.view.showLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$search$101, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b T0(boolean z, SearchResultView.Model model) {
        return loadData(model.getSearchQueryModel().getFinalQuery(), model.getStoreName(), model.getFilters(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$search$98, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean U0(SearchResultView.Model model) {
        return Boolean.valueOf(hasValidQuery(model));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$search$99, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void V0(SearchResultView.Model model) {
        this.view.hideSuggestionsViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAdultContentSwitchOnNoResults$93, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e W0(View.LifecycleEvent lifecycleEvent) {
        return this.view.viewHasNoResults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAdultContentSwitchOnNoResults$94, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e X0(Void r1) {
        return this.searchManager.isAdultContentEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAdultContentSwitchOnNoResults$95, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y0(Boolean bool) {
        this.view.setAdultContentSwitch(bool);
    }

    static /* synthetic */ void lambda$updateAdultContentSwitchOnNoResults$96(Boolean bool) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$updateAdultContentSwitchOnNoResults$97, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Z0(Throwable th) {
        this.crashReport.log(th);
    }

    private rx.b loadData(String str, String str2, List<Filter> list, boolean z) {
        return (str2 == null || str2.trim().equals(HttpUrl.FRAGMENT_ENCODE_SET)) ? this.searchManager.searchAppInStores(str, list, z) : this.searchManager.searchInStore(str, str2, list, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: openAppView, reason: merged with bridge method [inline-methods] */
    public void O(SearchAppResultWrapper searchAppResultWrapper) {
        String packageName = searchAppResultWrapper.getSearchAppResult().getPackageName();
        long appId = searchAppResultWrapper.getSearchAppResult().getAppId();
        String storeName = searchAppResultWrapper.getSearchAppResult().getStoreName();
        this.analytics.searchAppClick(this.view.getViewModel().getSearchQueryModel(), packageName, searchAppResultWrapper.getPosition(), searchAppResultWrapper.getSearchAppResult().isAppcApp(), searchAppResultWrapper.getSearchAppResult().getDownloadModel() != null && searchAppResultWrapper.getSearchAppResult().getDownloadModel().getAction() == DownloadStatusModel.Action.MIGRATE, !searchAppResultWrapper.getSearchAppResult().getSplits().isEmpty(), searchAppResultWrapper.getSearchAppResult().getObb() != null, searchAppResultWrapper.getSearchAppResult().getVersionCode(), searchAppResultWrapper.getSearchAppResult().isInCatappult(), searchAppResultWrapper.getSearchAppResult().getAppCategory());
        this.navigator.goToAppView(appId, packageName, this.view.getViewModel().getStoreTheme(), storeName);
    }

    public void doFirstSearch() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.f3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.m5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7444f.a((View.LifecycleEvent) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.search.view.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7380f.b((SearchResultView.Model) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.h0
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$doFirstSearch$84((SearchResultView.Model) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.r0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7485f.c((Throwable) obj);
            }
        });
    }

    public void focusInSearchBar() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7349f.d((View.LifecycleEvent) obj);
            }
        }).E().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.f1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7371f.e((Void) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.o4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7461f.f((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.v0
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$focusInSearchBar$40((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.k5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7426f.g((Throwable) obj);
            }
        });
    }

    public void getTrendingOnStart() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.o3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.e4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7365f.h((View.LifecycleEvent) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.search.view.r4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7489f.j((Void) obj);
            }
        }).s0().f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.g4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$getTrendingOnStart$34((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.f0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7370f.k((Throwable) obj);
            }
        });
    }

    public void handleClickOnAdultContentSwitch() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.v3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.q5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7481f.w((View.LifecycleEvent) obj);
            }
        }).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.y1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7546f.y((Boolean) obj);
            }
        }).j0(this.viewScheduler).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.b3
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                SearchResultPresenter.lambda$handleClickOnAdultContentSwitch$59(bool);
                return bool;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.b1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7335f.z((Boolean) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.u2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7515f.A((Boolean) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.v5
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickOnAdultContentSwitch$62((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.a3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7328f.B((Throwable) obj);
            }
        });
    }

    public void handleClickOnBottomNavWithResults() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.k3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7424f.F((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.f2
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickOnBottomNavWithResults$149((Integer) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.b4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickOnBottomNavWithResults$150((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickOnBottomNavWithoutResults() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.g2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.k6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7427f.J((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.s4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickOnBottomNavWithoutResults$156((Integer) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.o1
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickOnBottomNavWithoutResults$157((Throwable) obj);
                throw null;
            }
        });
    }

    public void handleClickToOpenAppViewFromItem() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.h1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7389f.N((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.s2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7496f.O((SearchAppResultWrapper) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.y4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleClickToOpenAppViewFromItem$52((SearchAppResultWrapper) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.x2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7539f.P((Throwable) obj);
            }
        });
    }

    public void handleFragmentRestorationVisibility() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.j4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.b6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7340f.Y((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.a2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7327f.Z((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.u1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7514f.a0((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.u4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleFragmentRestorationVisibility$28((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.z0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7553f.b0((Throwable) obj);
            }
        });
    }

    public void handleQueryTextChanged() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.x5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.p3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7470f.g0((View.LifecycleEvent) obj);
            }
        }).E().G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7439f.h0((Void) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.z5
            @Override // rx.m.e
            public final Object call(Object obj) {
                SearchQueryEvent searchQueryEvent = (SearchQueryEvent) obj;
                return Boolean.valueOf(searchQueryEvent.hasQuery() && !searchQueryEvent.isSubmitted());
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.g5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((SearchQueryEvent) obj).getQuery();
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.r2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7487f.i0((String) obj);
            }
        }).L(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7401f.k0((String) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.m3
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleQueryTextChanged$117((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.w1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7530f.l0((Throwable) obj);
            }
        });
    }

    public void handleQueryTextCleaned() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.z1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7554f.o0((View.LifecycleEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.n4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleQueryTextCleaned$106((SearchQueryEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.t4
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7508f.p0((Throwable) obj);
            }
        });
    }

    public void handleQueryTextSubmitted() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.l3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.r1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7486f.q0((View.LifecycleEvent) obj);
            }
        }).E().G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.u0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7513f.r0((Void) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                SearchQueryEvent searchQueryEvent = (SearchQueryEvent) obj;
                return Boolean.valueOf(searchQueryEvent.hasQuery() && searchQueryEvent.isSubmitted());
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.n2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7450f.s0((SearchQueryEvent) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.z4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleQueryTextSubmitted$124((SearchQueryEvent) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7476f.t0((Throwable) obj);
            }
        });
    }

    public void handleSearchListReachedBottom() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.l5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).j0(this.viewScheduler).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.m4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7443f.u0((View.LifecycleEvent) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.j5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7417f.v0((Void) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.g3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7382f.w0((SearchResultView.Model) obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.search.view.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7412f.x0((SearchResultView.Model) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.e5
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleSearchListReachedBottom$47((SearchResultView.Model) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.w3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7532f.y0((Throwable) obj);
            }
        });
    }

    public void handleSearchMenuItemClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.y3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.RESUME);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.z2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7555f.z0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.j3
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7415f.A0((MenuItem) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.h2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7390f.B0((MenuItem) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.PAUSE)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.f4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleSearchMenuItemClick$142((MenuItem) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.d5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7357f.C0((Throwable) obj);
            }
        });
    }

    public void handleSuggestionClicked() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.p4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.t5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7509f.D0((View.LifecycleEvent) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.n1
            @Override // rx.m.e
            public final Object call(Object obj) {
                c.i.j.e eVar = (c.i.j.e) obj;
                return Boolean.valueOf(((SearchQueryEvent) eVar.f3281b).hasQuery() && ((SearchQueryEvent) eVar.f3281b).isSubmitted());
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.l1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7431f.E0((c.i.j.e) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.x0
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleSuggestionClicked$130((c.i.j.e) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.m1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7440f.F0((Throwable) obj);
            }
        });
    }

    public void handleToolbarClick() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.d4
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.CREATE);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.m6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7445f.G0((View.LifecycleEvent) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.x1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7538f.H0((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7457f.I0((Void) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.b5
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$handleToolbarClick$136((Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.d2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7354f.J0((Throwable) obj);
            }
        });
    }

    public boolean hasValidQuery(SearchResultView.Model model) {
        return (model.getSearchQueryModel() == null || model.getSearchQueryModel().getFinalQuery().isEmpty()) ? false : true;
    }

    public void listenToSearchQueries() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.l6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj) == View.LifecycleEvent.RESUME);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.o5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7462f.K0((View.LifecycleEvent) obj);
            }
        }).E().G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.y2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7547f.L0((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.l2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7432f.M0((e.g.a.b.c.a.g) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.w4
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$listenToSearchQueries$162((e.g.a.b.c.a.g) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.k2
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7423f.N0((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.presenter.Presenter
    public void present() {
        handleNewSearchResults();
        getTrendingOnStart();
        handleToolbarClick();
        handleSearchMenuItemClick();
        focusInSearchBar();
        handleSuggestionClicked();
        handleFragmentRestorationVisibility();
        doFirstSearch();
        handleClickToOpenAppViewFromItem();
        handleSearchListReachedBottom();
        handleQueryTextSubmitted();
        handleQueryTextChanged();
        handleQueryTextCleaned();
        handleClickOnBottomNavWithResults();
        handleClickOnBottomNavWithoutResults();
        handleErrorRetryClick();
        handleFiltersClick();
        handleClickOnScreenshot();
        listenToSearchQueries();
        handleClickOnAdultContentSwitch();
        handleAdultContentDialogPositiveClick();
        handleAdultContentDialogNegativeClick();
        handleAdultContentDialogWithPinPositiveClick();
        redoSearchAfterAdultContentSwitch();
        updateAdultContentSwitchOnNoResults();
        this.downloadActionPresenter.setContextParams(DownloadAnalytics.AppContext.SEARCH, false, null);
        this.downloadActionPresenter.present(this.view.getDownloadClickEvents(), this.view);
    }

    public void redoSearchAfterAdultContentSwitch() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.p5
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.e6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7367f.O0((View.LifecycleEvent) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.search.view.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7430f.P0(obj);
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.search.view.e3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7364f.Q0((SearchResultView.Model) obj);
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.s5
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$redoSearchAfterAdultContentSwitch$90((SearchResultView.Model) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.h5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7393f.R0((Throwable) obj);
            }
        });
    }

    public rx.b search(SearchResultView.Model model, final boolean z) {
        return rx.e.S(model).D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.q1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7477f.U0((SearchResultView.Model) obj);
            }
        }).j0(this.viewScheduler).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.k0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7421f.V0((SearchResultView.Model) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.e1
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7362f.S0((SearchResultView.Model) obj);
            }
        }).j0(this.ioScheduler).E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.search.view.i6
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7403f.T0(z, (SearchResultView.Model) obj);
            }
        });
    }

    public void updateAdultContentSwitchOnNoResults() {
        this.view.getLifecycleEvent().D(new rx.m.e() { // from class: cm.aptoide.pt.search.view.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((View.LifecycleEvent) obj).equals(View.LifecycleEvent.CREATE));
            }
        }).f(this.view.bindUntilEvent(View.LifecycleEvent.DESTROY)).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.j2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7414f.W0((View.LifecycleEvent) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.search.view.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7344f.X0((Void) obj);
            }
        }).x(new rx.m.b() { // from class: cm.aptoide.pt.search.view.y5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7550f.Y0((Boolean) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.search.view.t3
            @Override // rx.m.b
            public final void call(Object obj) {
                SearchResultPresenter.lambda$updateAdultContentSwitchOnNoResults$96((Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.search.view.c5
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7348f.Z0((Throwable) obj);
            }
        });
    }
}
