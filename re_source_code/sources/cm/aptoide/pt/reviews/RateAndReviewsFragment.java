package cm.aptoide.pt.reviews;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.UserFeedbackAnalytics;
import cm.aptoide.pt.app.AppNavigator;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.comments.ListFullReviewsSuccessRequestListener;
import cm.aptoide.pt.comments.view.CommentDisplayable;
import cm.aptoide.pt.comments.view.CommentsAdapter;
import cm.aptoide.pt.comments.view.CommentsReadMoreDisplayable;
import cm.aptoide.pt.comments.view.ItemCommentAdderView;
import cm.aptoide.pt.comments.view.RateAndReviewCommentDisplayable;
import cm.aptoide.pt.comments.view.SimpleReviewCommentAdder;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.dataprovider.model.v7.GetApp;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.dataprovider.model.v7.Review;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.GetAppRequest;
import cm.aptoide.pt.dataprovider.ws.v7.ListReviewsRequest;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.MarketResourceFormatter;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.dialog.DialogUtils;
import cm.aptoide.pt.view.fragment.AptoideBaseFragment;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.ProgressBarDisplayable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RateAndReviewsFragment extends AptoideBaseFragment<CommentsAdapter> implements ItemCommentAdderView<Review, CommentsAdapter> {
    private static final String TAG = RateAndReviewsFragment.class.getSimpleName();
    private long appId;
    private String appName;

    @Inject
    AppNavigator appNavigator;

    @Inject
    AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Converter.Factory converterFactory;

    @Inject
    DialogUtils dialogUtils;
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private OkHttpClient httpClient;
    private MenuItem installMenuItem;

    @Inject
    @Named
    String marketName;

    @Inject
    MarketResourceFormatter marketResourceFormatter;
    private String packageName;
    private SharedPreferences preferences;
    private long reviewId;
    private ReviewsLanguageFilterDisplayable reviewsLanguageFilterDisplayable;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;
    private String storeTheme;

    @Inject
    ThemeManager themeManager;
    private TokenInvalidator tokenInvalidator;

    @Inject
    UserFeedbackAnalytics userFeedbackAnalytics;

    public static class BundleCons {
        public static final String APP_ID = "app_id";
        public static final String APP_NAME = "app_name";
        public static final String PACKAGE_NAME = "package_name";
        public static final String REVIEW_ID = "review_id";
        public static final String STORE_NAME = "store_name";
        public static final String STORE_THEME = "store_theme";
    }

    private ListReviewsRequest createListReviewsRequest(String str) {
        String str2 = this.storeName;
        return ListReviewsRequest.of(str2, this.packageName, this.storeCredentialsProvider.get(str2), this.baseBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences(), str);
    }

    private void fetchRating(boolean z) {
        GetAppRequest.of(this.packageName, this.baseBodyInterceptor, this.appId, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences()).observe(z, ManagerPreferences.getAndResetForceServerRefresh(this.preferences)).I0(Schedulers.io()).j0(rx.l.c.a.b()).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).H0(new rx.m.b() { // from class: cm.aptoide.pt.reviews.i
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7258f.g((GetApp) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.reviews.e
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindViews$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(Void r5) {
        return this.dialogUtils.showRateDialog(getActivity(), this.appName, this.packageName, this.storeName);
    }

    static /* synthetic */ void lambda$bindViews$3(GenericDialogs.EResponse eResponse) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$fetchRating$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(LanguageFilterHelper.LanguageFilter languageFilter) {
        removeDisplayables(1, getDisplayablesSize() - 1);
        fetchReviews(languageFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$fetchRating$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(GetApp getApp) {
        if (getApp.isOk()) {
            GetAppMeta.App data = getApp.getNodes().getMeta().getData();
            setupTitle(data.getName());
            addDisplayable(0, new ReviewsRatingDisplayable(data), true);
            ReviewsLanguageFilterDisplayable reviewsLanguageFilterDisplayable = new ReviewsLanguageFilterDisplayable(new LanguageFilterSpinnerHelper.OnItemSelected() { // from class: cm.aptoide.pt.reviews.j
                @Override // cm.aptoide.pt.reviews.LanguageFilterSpinnerHelper.OnItemSelected
                public final void onItemSelected(LanguageFilterHelper.LanguageFilter languageFilter) {
                    this.a.f(languageFilter);
                }
            });
            this.reviewsLanguageFilterDisplayable = reviewsLanguageFilterDisplayable;
            addDisplayable(reviewsLanguageFilterDisplayable);
        }
        finishLoading();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$fetchReviews$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(LanguageFilterHelper.LanguageFilter languageFilter, EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener) {
        if (languageFilter.hasMoreCountryCodes()) {
            this.endlessRecyclerOnScrollListener.reset(createListReviewsRequest(languageFilter.inc().getValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$onCreateOptionsMenu$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(RoomInstalled roomInstalled) {
        if (roomInstalled != null) {
            this.installMenuItem.setTitle(R.string.reviewappview_button_open);
        }
    }

    public static RateAndReviewsFragment newInstance(long j2, String str, String str2, String str3, String str4) {
        RateAndReviewsFragment rateAndReviewsFragment = new RateAndReviewsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(BundleCons.APP_ID, j2);
        bundle.putString("app_name", str);
        bundle.putString("store_name", str2);
        bundle.putString("package_name", str3);
        bundle.putString(BundleCons.STORE_THEME, str4);
        rateAndReviewsFragment.setArguments(bundle);
        return rateAndReviewsFragment;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        e.g.a.c.a.a((FloatingActionButton) view.findViewById(R.id.fab)).G(new rx.m.e() { // from class: cm.aptoide.pt.reviews.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7255f.e((Void) obj);
            }
        }).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).H0(new rx.m.b() { // from class: cm.aptoide.pt.reviews.g
            @Override // rx.m.b
            public final void call(Object obj) {
                RateAndReviewsFragment.lambda$bindViews$3((GenericDialogs.EResponse) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.reviews.h
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void checkAndRemoveProgressBarDisplayable() {
        for (int i2 = 0; i2 < ((CommentsAdapter) getAdapter()).getItemCount(); i2++) {
            if (((CommentsAdapter) getAdapter()).getDisplayable(i2) instanceof ProgressBarDisplayable) {
                ((CommentsAdapter) getAdapter()).removeDisplayable(i2);
                ((CommentsAdapter) getAdapter()).notifyItemRemoved(i2);
            }
        }
    }

    @Override // cm.aptoide.pt.comments.view.CommentAdderView
    public void createDisplayableComments(List<Comment> list, List<Displayable> list2) {
        for (Comment comment : list) {
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            list2.add(new CommentDisplayable(comment, fragmentNavigator, AptoideApplication.getFragmentProvider()));
        }
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [cm.aptoide.pt.view.recycler.BaseAdapter] */
    void fetchReviews(final LanguageFilterHelper.LanguageFilter languageFilter) {
        addDisplayable(this.reviewsLanguageFilterDisplayable);
        ListReviewsRequest listReviewsRequestCreateListReviewsRequest = createListReviewsRequest(languageFilter.getValue());
        getRecyclerView().removeOnScrollListener(this.endlessRecyclerOnScrollListener);
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), listReviewsRequestCreateListReviewsRequest, new ListFullReviewsSuccessRequestListener(this, this.storeCredentialsProvider, this.baseBodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences(), this.userFeedbackAnalytics), new ErrorRequestListener() { // from class: cm.aptoide.pt.reviews.d
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                th.printStackTrace();
            }
        });
        this.endlessRecyclerOnScrollListener = endlessRecyclerOnScrollListener;
        endlessRecyclerOnScrollListener.addOnEndlessFinishListener(new EndlessRecyclerOnScrollListener.OnEndlessFinish() { // from class: cm.aptoide.pt.reviews.m
            @Override // cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener.OnEndlessFinish
            public final void onEndlessFinish(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2) {
                this.a.h(languageFilter, endlessRecyclerOnScrollListener2);
            }
        });
        getRecyclerView().addOnScrollListener(this.endlessRecyclerOnScrollListener);
        this.endlessRecyclerOnScrollListener.onLoadMore(false, false);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.comments.view.CommentAdderView
    public /* bridge */ /* synthetic */ CommentsAdapter getAdapter() {
        return (CommentsAdapter) super.getAdapter();
    }

    public String getAppName() {
        return this.appName;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.fragment_rate_and_reviews;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    public long getReviewId() {
        return this.reviewId;
    }

    public String getStoreName() {
        return this.storeName;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
        Logger.getInstance().d(TAG, "Other versions should refresh? " + z);
        fetchRating(z2);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        this.appId = bundle.getLong(BundleCons.APP_ID);
        this.reviewId = bundle.getLong(BundleCons.REVIEW_ID);
        this.packageName = bundle.getString("package_name");
        this.storeName = bundle.getString("store_name");
        this.appName = bundle.getString("app_name");
        this.storeTheme = bundle.getString(BundleCons.STORE_THEME);
    }

    @Override // cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.preferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        this.tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        this.baseBodyInterceptor = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        this.httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_install, menu);
        this.installMenuItem = menu.findItem(R.id.menu_install);
        this.aptoideInstalledAppsRepository.getInstalled(this.packageName).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).j0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.reviews.k
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7259f.i((RoomInstalled) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.reviews.l
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.themeManager.resetToBaseTheme();
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            getActivity().onBackPressed();
            return true;
        }
        if (itemId != R.id.menu_install) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.appNavigator.navigateWithPackageAndStoreNames(this.packageName, this.storeName, AppViewFragment.OpenType.OPEN_AND_INSTALL);
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String str = this.storeTheme;
        if (str != null) {
            this.themeManager.setTheme(str);
        }
    }

    public void setupTitle(String str) {
        if (hasToolbar()) {
            getToolbar().setTitle(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.view.fragment.GridRecyclerFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment
    public CommentsAdapter createAdapter() {
        return new CommentsAdapter(RateAndReviewCommentDisplayable.class);
    }

    @Override // cm.aptoide.pt.comments.view.ItemCommentAdderView
    public CommentsReadMoreDisplayable createReadMoreDisplayable(int i2, Review review) {
        return new CommentsReadMoreDisplayable(review.getId(), true, review.getCommentList().getDataList().getNext(), new SimpleReviewCommentAdder(i2, this));
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.LifecycleSchim
    public void onViewCreated() {
        super.onViewCreated();
    }

    public static RateAndReviewsFragment newInstance(long j2, String str, String str2, String str3, long j3) {
        RateAndReviewsFragment rateAndReviewsFragment = new RateAndReviewsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(BundleCons.APP_ID, j2);
        bundle.putString("app_name", str);
        bundle.putString("store_name", str2);
        bundle.putString("package_name", str3);
        bundle.putLong(BundleCons.REVIEW_ID, j3);
        rateAndReviewsFragment.setArguments(bundle);
        return rateAndReviewsFragment;
    }
}
