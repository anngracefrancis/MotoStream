package cm.aptoide.pt.comments.view;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.account.view.AccountNavigator;
import cm.aptoide.pt.comments.CommentDialogCallbackContract;
import cm.aptoide.pt.comments.CommentNode;
import cm.aptoide.pt.comments.ComplexComment;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import cm.aptoide.pt.dataprovider.model.v7.ListComments;
import cm.aptoide.pt.dataprovider.model.v7.SetComment;
import cm.aptoide.pt.dataprovider.util.CommentType;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.BaseRequestWithStore;
import cm.aptoide.pt.dataprovider.ws.v7.ListCommentsRequest;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.util.CommentOperations;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.custom.HorizontalDividerItemDecoration;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayableGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class CommentListFragment extends GridRecyclerSwipeFragment implements CommentDialogCallbackContract {
    private static final String COMMENT_TYPE = "comment_type";
    private static final String ELEMENT_ID_AS_LONG = "element_id_as_long";
    private static final String STORE_ANALYTICS_ACTION = "store_analytics_action";
    private static final String STORE_CONTEXT = "store_context";
    private static final String URL_VAL = "url_val";
    private AptoideAccountManager accountManager;
    private AccountNavigator accountNavigator;

    @Inject
    AnalyticsManager analyticsManager;
    private BodyInterceptor<BaseBody> bodyDecorator;
    private CommentOperations commentOperations;
    private CommentType commentType;
    private List<CommentNode> comments;
    private Converter.Factory converterFactory;
    private List<Displayable> displayables;
    private long elementIdAsLong;
    private FloatingActionButton floatingActionButton;
    private OkHttpClient httpClient;

    @Inject
    NavigationTracker navigationTracker;
    private SharedPreferences sharedPreferences;
    private StoreAnalytics storeAnalytics;
    private String storeAnalyticsAction;
    private StoreContext storeContext;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;
    private String storeName;

    @Inject
    ThemeManager themeManager;
    private TokenInvalidator tokenInvalidator;
    private String url;

    private rx.b createNewCommentFragment(final long j2, final long j3, final String str) {
        return this.accountManager.accountStatus().E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4837f.g(j2, j3, str, (Account) obj);
            }
        });
    }

    private ComplexComment getComplexComment(String str, Long l, long j2) {
        Comment comment = new Comment();
        Comment.User user = new Comment.User();
        if (!TextUtils.isEmpty(this.accountManager.getAccount().getAvatar())) {
            user.setAvatar(this.accountManager.getAccount().getAvatar());
        } else if (!TextUtils.isEmpty(this.accountManager.getAccount().getStore().getAvatar())) {
            user.setAvatar(this.accountManager.getAccount().getStore().getAvatar());
        }
        user.setName(this.accountManager.getAccount().getNickname());
        comment.setUser(user);
        comment.setBody(str);
        comment.setAdded(new Date());
        comment.setId(j2);
        CommentNode commentNode = new CommentNode(comment);
        if (l != null) {
            Comment.Parent parent = new Comment.Parent();
            parent.setId(l.longValue());
            comment.setParent(parent);
            commentNode.setLevel(2);
        }
        return new ComplexComment(commentNode, createNewCommentFragment(this.elementIdAsLong, commentNode.getComment().getId(), this.storeName));
    }

    private void insertChildCommentInsideParent(ComplexComment complexComment) {
        this.displayables.clear();
        ArrayList arrayList = new ArrayList(this.comments.size() + 1);
        boolean z = false;
        for (CommentNode commentNode : this.comments) {
            ComplexComment complexComment2 = new ComplexComment(commentNode, createNewCommentFragment(this.elementIdAsLong, commentNode.getComment().getId(), this.storeName));
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            arrayList.add(new CommentDisplayable(complexComment2, fragmentNavigator, AptoideApplication.getFragmentProvider()));
            if (commentNode.getComment().getId() == complexComment.getParent().getId() && !z) {
                FragmentNavigator fragmentNavigator2 = getFragmentNavigator();
                arrayList.add(new CommentDisplayable(complexComment, fragmentNavigator2, AptoideApplication.getFragmentProvider()));
                z = true;
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        this.displayables = arrayList2;
        arrayList2.add(new DisplayableGroup(arrayList, (WindowManager) getContext().getSystemService("window"), getContext().getResources()));
        clearDisplayables();
        addDisplayables(this.displayables);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$caseListStoreComments$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(long j2, String str, ListComments listComments) {
        if (listComments == null || listComments.getDataList() == null || listComments.getDataList().getList() == null) {
            return;
        }
        CommentOperations commentOperations = this.commentOperations;
        this.comments = commentOperations.flattenByDepth(commentOperations.transform(listComments.getDataList().getList()));
        ArrayList arrayList = new ArrayList(this.comments.size());
        for (CommentNode commentNode : this.comments) {
            ComplexComment complexComment = new ComplexComment(commentNode, createNewCommentFragment(j2, commentNode.getComment().getId(), str));
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            arrayList.add(new CommentDisplayable(complexComment, fragmentNavigator, AptoideApplication.getFragmentProvider()));
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        this.displayables = arrayList2;
        arrayList2.add(new DisplayableGroup(arrayList, (WindowManager) getContext().getSystemService("window"), getContext().getResources()));
        addDisplayables(this.displayables);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createNewCommentFragment$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(long j2, String str, Account account) {
        if (!account.isLoggedIn()) {
            return showSignInMessage();
        }
        final FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        final CommentDialogFragment commentDialogFragmentNewInstanceStoreComment = CommentDialogFragment.newInstanceStoreComment(j2, str);
        commentDialogFragmentNewInstanceStoreComment.setCommentDialogCallbackContract(this);
        return commentDialogFragmentNewInstanceStoreComment.lifecycle().y(new rx.m.a() { // from class: cm.aptoide.pt.comments.view.q
            @Override // rx.m.a
            public final void call() {
                commentDialogFragmentNewInstanceStoreComment.show(supportFragmentManager, "fragment_comment_dialog");
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((com.trello.rxlifecycle.g.b) obj).equals(com.trello.rxlifecycle.g.b.DESTROY_VIEW));
            }
        }).X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$createNewCommentFragment$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b g(long j2, long j3, String str, Account account) {
        if (!account.isLoggedIn()) {
            return showSignInMessage();
        }
        final FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        final CommentDialogFragment commentDialogFragmentNewInstanceStoreCommentReply = CommentDialogFragment.newInstanceStoreCommentReply(j2, j3, str);
        commentDialogFragmentNewInstanceStoreCommentReply.setCommentDialogCallbackContract(this);
        return commentDialogFragmentNewInstanceStoreCommentReply.lifecycle().y(new rx.m.a() { // from class: cm.aptoide.pt.comments.view.h
            @Override // rx.m.a
            public final void call() {
                commentDialogFragmentNewInstanceStoreCommentReply.show(supportFragmentManager, "fragment_comment_dialog");
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((com.trello.rxlifecycle.g.b) obj).equals(com.trello.rxlifecycle.g.b.DESTROY_VIEW));
            }
        }).X0();
    }

    private /* synthetic */ Void lambda$reloadComments$8() throws Exception {
        ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
        super.reload();
        return null;
    }

    static /* synthetic */ void lambda$setupViews$10(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupViews$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e i(Void r3) {
        return createNewCommentFragment(this.elementIdAsLong, this.storeName).M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showSignInMessage$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(View view) {
        this.accountNavigator.navigateToAccountView(AccountAnalytics.AccountOrigins.COMMENT_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showSignInMessage$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(FloatingActionButton floatingActionButton) {
        Snackbar.Z(floatingActionButton, R.string.you_need_to_be_logged_in, 0).b0(R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.comments.view.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f4842f.j(view);
            }
        }).P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showSignInMessage$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b l(final FloatingActionButton floatingActionButton) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.comments.view.s
            @Override // rx.m.a
            public final void call() {
                this.f4854f.k(floatingActionButton);
            }
        });
    }

    public static Fragment newInstanceUrl(CommentType commentType, String str, String str2, StoreContext storeContext) {
        Bundle bundle = new Bundle();
        bundle.putString(URL_VAL, str);
        bundle.putSerializable(STORE_CONTEXT, storeContext);
        bundle.putString(COMMENT_TYPE, commentType.name());
        bundle.putString(STORE_ANALYTICS_ACTION, str2);
        CommentListFragment commentListFragment = new CommentListFragment();
        commentListFragment.setArguments(bundle);
        return commentListFragment;
    }

    private rx.e<Void> reloadComments() {
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.comments.view.l
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.f4831f.h();
                return null;
            }
        });
    }

    private rx.b showSignInMessage() {
        return Single.m(this.floatingActionButton).j(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4856f.l((FloatingActionButton) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void bindViews(View view) {
        super.bindViews(view);
        this.commentOperations = new CommentOperations();
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabAdd);
        this.floatingActionButton = floatingActionButton;
        if (floatingActionButton != null) {
            this.floatingActionButton.setImageDrawable(Build.VERSION.SDK_INT >= 21 ? getContext().getDrawable(this.themeManager.getAttributeForTheme(R.attr.penDrawable).resourceId) : getActivity().getResources().getDrawable(this.themeManager.getAttributeForTheme(R.attr.penDrawable).resourceId));
            this.floatingActionButton.setVisibility(0);
        }
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [cm.aptoide.pt.view.recycler.BaseAdapter] */
    void caseListStoreComments(String str, BaseRequestWithStore.StoreCredentials storeCredentials, boolean z) {
        ListCommentsRequest listCommentsRequestOfStoreAction = ListCommentsRequest.ofStoreAction(str, z, storeCredentials, this.bodyDecorator, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
        if (storeCredentials == null || storeCredentials.getId() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Current store credentials does not have a store id");
            CrashReport.getInstance().log(illegalStateException);
            throw illegalStateException;
        }
        final long jLongValue = storeCredentials.getId() != null ? storeCredentials.getId().longValue() : -1L;
        final String name = storeCredentials.getName();
        rx.m.b bVar = new rx.m.b() { // from class: cm.aptoide.pt.comments.view.u
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4860f.e(jLongValue, name, (ListComments) obj);
            }
        };
        getRecyclerView().clearOnScrollListeners();
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), listCommentsRequestOfStoreAction, bVar, new ErrorRequestListener() { // from class: cm.aptoide.pt.comments.view.m
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                th.printStackTrace();
            }
        }, true, false);
        getRecyclerView().addOnScrollListener(endlessRecyclerOnScrollListener);
        endlessRecyclerOnScrollListener.onLoadMore(z, z);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.recycler_swipe_fragment_with_toolbar;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        String simpleName = getClass().getSimpleName();
        StoreContext storeContext = this.storeContext;
        return ScreenTagHistory.Builder.build(simpleName, HttpUrl.FRAGMENT_ENCODE_SET, storeContext != null ? storeContext.name() : null);
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerFragmentWithDecorator
    protected RecyclerView.n getItemDecoration() {
        return new HorizontalDividerItemDecoration(getActivity(), this.themeManager);
    }

    public /* synthetic */ Void h() throws Exception {
        lambda$reloadComments$8();
        return null;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
        if (z || z2) {
            refreshData();
        }
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        BaseRequestWithStore.StoreCredentials storeCredentialsFromUrl;
        super.loadExtras(bundle);
        this.storeContext = (StoreContext) bundle.getSerializable(STORE_CONTEXT);
        this.elementIdAsLong = bundle.getLong(ELEMENT_ID_AS_LONG);
        this.url = bundle.getString(URL_VAL);
        this.commentType = CommentType.valueOf(bundle.getString(COMMENT_TYPE));
        this.storeAnalyticsAction = bundle.getString(STORE_ANALYTICS_ACTION);
        if (this.commentType != CommentType.STORE || (storeCredentialsFromUrl = StoreUtils.getStoreCredentialsFromUrl(this.url, this.storeCredentialsProvider)) == null) {
            return;
        }
        Long id = storeCredentialsFromUrl.getId();
        if (id != null) {
            this.elementIdAsLong = id.longValue();
        }
        if (TextUtils.isEmpty(storeCredentialsFromUrl.getName())) {
            return;
        }
        this.storeName = storeCredentialsFromUrl.getName();
    }

    @Override // cm.aptoide.pt.comments.CommentDialogCallbackContract
    public void okSelected(BaseV7Response baseV7Response, long j2, Long l, String str) {
        if (baseV7Response instanceof SetComment) {
            SetComment setComment = (SetComment) baseV7Response;
            ComplexComment complexComment = getComplexComment(setComment.getData().getBody(), l, setComment.getData().getId());
            FragmentNavigator fragmentNavigator = getFragmentNavigator();
            CommentDisplayable commentDisplayable = new CommentDisplayable(complexComment, fragmentNavigator, AptoideApplication.getFragmentProvider());
            if (complexComment.getParent() != null) {
                insertChildCommentInsideParent(complexComment);
            } else {
                addDisplayable(0, (Displayable) commentDisplayable, true);
            }
            ManagerPreferences.setForceServerRefreshFlag(true, this.sharedPreferences);
            ShowMessage.asSnack(getActivity(), R.string.comment_submitted);
        }
    }

    @Override // cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        getFragmentComponent(bundle).inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.sharedPreferences = aptoideApplication.getDefaultSharedPreferences();
        this.tokenInvalidator = aptoideApplication.getTokenInvalidator();
        this.httpClient = aptoideApplication.getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
        this.bodyDecorator = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        this.accountNavigator = ((ActivityResultNavigator) getContext()).getAccountNavigator();
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
        return viewOnCreateView;
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.commentType == CommentType.STORE) {
            StoreAnalytics storeAnalytics = this.storeAnalytics;
            String str = this.storeAnalyticsAction;
            String str2 = this.storeName;
            if (str2 == null) {
                str2 = "unknown";
            }
            storeAnalytics.sendStoreInteractEvent(str, "Home", str2);
        }
    }

    void refreshData() {
        String str = this.url;
        caseListStoreComments(str, StoreUtils.getStoreCredentialsFromUrl(str, this.storeCredentialsProvider), true);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    public void setupToolbarDetails(Toolbar toolbar) {
        if (this.commentType != CommentType.STORE || TextUtils.isEmpty(this.storeName)) {
            toolbar.setTitle(R.string.comments_title_comments);
        } else {
            toolbar.setTitle(String.format(getString(R.string.commentlist_title_comment_on_store), this.storeName));
        }
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerFragmentWithDecorator, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        setupToolbar();
        e.g.a.c.a.a(this.floatingActionButton).G(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4814f.i((Void) obj);
            }
        }).f(bindUntilEvent(cm.aptoide.pt.presenter.View.LifecycleEvent.DESTROY)).G0(new rx.m.b() { // from class: cm.aptoide.pt.comments.view.p
            @Override // rx.m.b
            public final void call(Object obj) {
                CommentListFragment.lambda$setupViews$10(obj);
            }
        });
    }

    public rx.b createNewCommentFragment(final long j2, final String str) {
        return this.accountManager.accountStatus().E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.comments.view.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4825f.f(j2, str, (Account) obj);
            }
        });
    }
}
