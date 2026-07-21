package cm.aptoide.pt.timeline.view.follow;

import android.os.Bundle;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.WebService;
import cm.aptoide.pt.dataprovider.interfaces.TokenInvalidator;
import cm.aptoide.pt.dataprovider.model.v7.BaseV7Response;
import cm.aptoide.pt.dataprovider.model.v7.GetFollowers;
import cm.aptoide.pt.dataprovider.ws.BodyInterceptor;
import cm.aptoide.pt.dataprovider.ws.v7.BaseBody;
import cm.aptoide.pt.dataprovider.ws.v7.GetFollowingRequest;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.timeline.view.displayable.FollowUserDisplayable;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.MessageWhiteBgDisplayable;
import java.util.List;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes.dex */
public class TimeLineFollowingFragment extends TimeLineFollowFragment {
    private BodyInterceptor<BaseBody> baseBodyInterceptor;
    private Converter.Factory converterFactory;
    private OkHttpClient httpClient;
    private Long storeId;

    @Inject
    ThemeManager themeManager;
    private TokenInvalidator tokenInvalidator;
    private Long userId;

    private static Bundle buildBundle(String str, String str2, StoreContext storeContext) {
        Bundle bundleBuildBundle = TimeLineFollowFragment.buildBundle(storeContext);
        bundleBuildBundle.putString(GridRecyclerSwipeWithToolbarFragment.TITLE_KEY, str2);
        bundleBuildBundle.putString("storeTheme", str);
        return bundleBuildBundle;
    }

    private String getUserStoreTheme(GetFollowers.TimelineUser timelineUser) {
        return timelineUser.getStore() != null ? timelineUser.getStore().getAppearance().getTheme() : this.themeManager.getBaseTheme().getThemeName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getFirstResponseAction$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean g(List list, GetFollowers getFollowers) {
        list.add(0, new MessageWhiteBgDisplayable(getHeaderMessage()));
        return false;
    }

    public static TimeLineFollowFragment newInstanceUsingStoreId(Long l, String str, String str2, StoreContext storeContext) {
        Bundle bundleBuildBundle = buildBundle(str, str2, storeContext);
        if (l != null) {
            bundleBuildBundle.putLong(TimeLineFollowFragment.BundleKeys.STORE_ID, l.longValue());
        }
        TimeLineFollowingFragment timeLineFollowingFragment = new TimeLineFollowingFragment();
        timeLineFollowingFragment.setArguments(bundleBuildBundle);
        return timeLineFollowingFragment;
    }

    public static TimeLineFollowFragment newInstanceUsingUser(String str, String str2, StoreContext storeContext) {
        Bundle bundleBuildBundle = buildBundle(str, str2, storeContext);
        TimeLineFollowingFragment timeLineFollowingFragment = new TimeLineFollowingFragment();
        timeLineFollowingFragment.setArguments(bundleBuildBundle);
        return timeLineFollowingFragment;
    }

    public static TimeLineFollowFragment newInstanceUsingUserId(Long l, String str, String str2, StoreContext storeContext) {
        Bundle bundleBuildBundle = buildBundle(str, str2, storeContext);
        if (l != null) {
            bundleBuildBundle.putLong(TimeLineFollowFragment.BundleKeys.USER_ID, l.longValue());
        }
        TimeLineFollowingFragment timeLineFollowingFragment = new TimeLineFollowingFragment();
        timeLineFollowingFragment.setArguments(bundleBuildBundle);
        return timeLineFollowingFragment;
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment
    protected V7 buildRequest() {
        return GetFollowingRequest.of(this.baseBodyInterceptor, this.userId, this.storeId, this.httpClient, this.converterFactory, this.tokenInvalidator, ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences());
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment
    protected Displayable createUserDisplayable(GetFollowers.TimelineUser timelineUser) {
        return new FollowUserDisplayable(timelineUser, getUserStoreTheme(timelineUser));
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment
    protected EndlessRecyclerOnScrollListener.BooleanAction<GetFollowers> getFirstResponseAction(final List<Displayable> list) {
        return new EndlessRecyclerOnScrollListener.BooleanAction() { // from class: cm.aptoide.pt.timeline.view.follow.g
            @Override // cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener.BooleanAction
            public final boolean call(BaseV7Response baseV7Response) {
                return this.a.g(list, (GetFollowers) baseV7Response);
            }
        };
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment
    public String getFooterMessage(int i2) {
        return getString(R.string.private_following_message, Integer.valueOf(i2));
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment
    public String getHeaderMessage() {
        return getString(R.string.social_timeline_share_bar_following);
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment, cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        if (bundle.containsKey(TimeLineFollowFragment.BundleKeys.USER_ID)) {
            this.userId = Long.valueOf(bundle.getLong(TimeLineFollowFragment.BundleKeys.USER_ID));
        }
        if (bundle.containsKey(TimeLineFollowFragment.BundleKeys.STORE_ID)) {
            this.storeId = Long.valueOf(bundle.getLong(TimeLineFollowFragment.BundleKeys.STORE_ID));
        }
    }

    @Override // cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment, cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        AptoideApplication aptoideApplication = (AptoideApplication) getContext().getApplicationContext();
        this.baseBodyInterceptor = aptoideApplication.getAccountSettingsBodyInterceptorPoolV7();
        this.httpClient = aptoideApplication.getDefaultClient();
        this.converterFactory = WebService.getDefaultConverter();
        this.tokenInvalidator = aptoideApplication.getTokenInvalidator();
    }
}
