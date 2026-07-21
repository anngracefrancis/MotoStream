package cm.aptoide.pt.editorialList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.aptoideviews.errors.ErrorView;
import cm.aptoide.aptoideviews.skeleton.Skeleton;
import cm.aptoide.aptoideviews.skeleton.SkeletonUtils;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.editorial.CaptionBackgroundPainter;
import cm.aptoide.pt.editorial.EditorialFragment;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.home.bundles.editorial.EditorialBundleViewHolder;
import cm.aptoide.pt.home.bundles.editorial.EditorialHomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.reactions.ReactionsHomeEvent;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class EditorialListFragment extends NavigationTrackFragment implements EditorialListView {
    private static final int VISIBLE_THRESHOLD = 1;
    private EditorialListAdapter adapter;
    private BottomNavigationActivity bottomNavigationActivity;

    @Inject
    CaptionBackgroundPainter captionBackgroundPainter;
    private RecyclerView editorialList;
    private ErrorView errorView;
    private ScrollControlLinearLayoutManager layoutManager;

    @Inject
    public EditorialListPresenter presenter;
    private ProgressBar progressBar;
    private Skeleton skeleton;
    private rx.s.b<Void> snackListener;
    private c.v.a.c swipeRefreshLayout;

    @Inject
    ThemeManager themeAttributeProvider;
    private rx.s.b<HomeEvent> uiEventsListener;
    private ImageView userAvatar;
    private static final String TAG = EditorialFragment.class.getName();
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.CURATION;

    private EditorialBundleViewHolder getViewHolderForAdapterPosition(int i2) {
        if (i2 == -1) {
            return null;
        }
        EditorialBundleViewHolder editorialBundleViewHolder = (EditorialBundleViewHolder) this.editorialList.findViewHolderForAdapterPosition(i2);
        if (editorialBundleViewHolder == null) {
            Log.e(TAG, "Unable to find editorialBundleViewHolder");
        }
        return editorialBundleViewHolder;
    }

    private boolean isEndReached() {
        return this.layoutManager.getItemCount() - this.layoutManager.findLastVisibleItemPosition() <= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$reachesBottom$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean e(e.g.a.b.c.a.a aVar) {
        return Boolean.valueOf(isEndReached());
    }

    static /* synthetic */ Boolean lambda$reachesBottom$3(Boolean bool) {
        return bool;
    }

    private /* synthetic */ EditorialHomeEvent lambda$reactionButtonLongPress$9(EditorialHomeEvent editorialHomeEvent) {
        setScrollEnabled(Boolean.FALSE);
        return editorialHomeEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showLogInDialog$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(View view) {
        this.snackListener.onNext(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$visibleCards$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer h(e.g.a.b.c.a.a aVar) {
        return Integer.valueOf(this.layoutManager.findFirstVisibleItemPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$visibleCards$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ EditorialListEvent i(Integer num) {
        return new EditorialListEvent(this.adapter.getCard(num.intValue()).getId(), num.intValue());
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<EditorialHomeEvent> editorialCardClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.EDITORIAL));
            }
        }).b(EditorialHomeEvent.class);
    }

    public /* synthetic */ EditorialHomeEvent f(EditorialHomeEvent editorialHomeEvent) {
        lambda$reactionButtonLongPress$9(editorialHomeEvent);
        return editorialHomeEvent;
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void hideLoadMore() {
        EditorialListAdapter editorialListAdapter = this.adapter;
        if (editorialListAdapter != null) {
            editorialListAdapter.removeLoadMore();
        }
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void hideLoading() {
        this.errorView.setVisibility(8);
        this.skeleton.showOriginal();
        this.swipeRefreshLayout.setVisibility(0);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void hideRefresh() {
        this.swipeRefreshLayout.setRefreshing(false);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<Void> imageClick() {
        return e.g.a.c.a.a(this.userAvatar);
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
        this.uiEventsListener = rx.s.b.g1();
        this.snackListener = rx.s.b.g1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.fragment_editorial_list, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.FragmentView, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.uiEventsListener = null;
        this.snackListener = null;
        super.onDestroy();
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.editorialList = null;
        this.adapter = null;
        this.layoutManager = null;
        this.progressBar = null;
        this.errorView = null;
        this.userAvatar = null;
        this.swipeRefreshLayout = null;
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDetach() {
        this.bottomNavigationActivity = null;
        super.onDetach();
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<EditorialHomeEvent> onPopupDismiss() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.POPUP_DISMISS));
            }
        }).b(EditorialHomeEvent.class);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BottomNavigationActivity bottomNavigationActivity = this.bottomNavigationActivity;
        if (bottomNavigationActivity != null) {
            bottomNavigationActivity.requestFocus(BOTTOM_NAVIGATION_ITEM);
        }
        this.userAvatar = (ImageView) view.findViewById(R.id.user_actionbar_icon);
        this.layoutManager = new ScrollControlLinearLayoutManager(getContext());
        this.adapter = new EditorialListAdapter(new ArrayList(), new ProgressCard(), this.uiEventsListener, this.captionBackgroundPainter, this.themeAttributeProvider);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.editorial_list);
        this.editorialList = recyclerView;
        recyclerView.setLayoutManager(this.layoutManager);
        this.editorialList.setAdapter(this.adapter);
        this.editorialList.getItemAnimator().setChangeDuration(0L);
        this.swipeRefreshLayout = (c.v.a.c) view.findViewById(R.id.refresh_layout);
        this.errorView = (ErrorView) view.findViewById(R.id.error_view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.skeleton = SkeletonUtils.applySkeleton(this.editorialList, R.layout.editorial_list_action_item_skeleton, 4);
        attachPresenter(this.presenter);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void populateView(List<CurationCard> list, BonusAppcModel bonusAppcModel) {
        this.editorialList.setVisibility(0);
        this.adapter.add(list, bonusAppcModel);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<Object> reachesBottom() {
        return e.g.a.b.c.a.c.a(this.editorialList).X(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5577f.e((e.g.a.b.c.a.a) obj);
            }
        }).t().D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                EditorialListFragment.lambda$reachesBottom$3(bool);
                return bool;
            }
        }).b(Object.class);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<EditorialHomeEvent> reactionButtonLongPress() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.REACT_LONG_PRESS));
            }
        }).b(EditorialHomeEvent.class).X(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                EditorialHomeEvent editorialHomeEvent = (EditorialHomeEvent) obj;
                this.f5610f.f(editorialHomeEvent);
                return editorialHomeEvent;
            }
        });
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<ReactionsHomeEvent> reactionClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.REACTION));
            }
        }).b(ReactionsHomeEvent.class);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<EditorialHomeEvent> reactionsButtonClicked() {
        return this.uiEventsListener.D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((HomeEvent) obj).getType().equals(HomeEvent.Type.REACT_SINGLE_PRESS));
            }
        }).b(EditorialHomeEvent.class);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<Void> refreshes() {
        return e.g.a.b.b.a.c.a(this.swipeRefreshLayout);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<Void> retryClicked() {
        return this.errorView.retryClick();
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void setDefaultUserImage() {
        ImageLoader.with(getContext()).loadUsingCircleTransform(R.drawable.ic_account_circle, this.userAvatar);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void setScrollEnabled(Boolean bool) {
        this.layoutManager.setScrollEnabled(bool.booleanValue());
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void setUserImage(String str) {
        ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(str, this.userAvatar, R.drawable.ic_account_circle);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showAvatar() {
        this.userAvatar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showGenericError() {
        this.errorView.setError(ErrorView.Error.GENERIC);
        this.errorView.setVisibility(0);
        this.editorialList.setVisibility(8);
        this.progressBar.setVisibility(8);
        if (this.swipeRefreshLayout.isRefreshing()) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showGenericErrorToast() {
        Snackbar.a0(getView(), getString(R.string.error_occured), 0).P();
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showLoadMore() {
        EditorialListAdapter editorialListAdapter = this.adapter;
        if (editorialListAdapter != null) {
            editorialListAdapter.addLoadMore();
        }
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showLoading() {
        this.errorView.setVisibility(8);
        this.skeleton.showSkeleton();
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showLogInDialog() {
        ShowMessage.asSnack(getActivity(), R.string.editorial_reactions_login_short, R.string.login, new View.OnClickListener() { // from class: cm.aptoide.pt.editorialList.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5618f.g(view);
            }
        }, -1);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showNetworkError() {
        this.errorView.setError(ErrorView.Error.NO_NETWORK);
        this.errorView.setVisibility(0);
        this.editorialList.setVisibility(8);
        this.progressBar.setVisibility(8);
        if (this.swipeRefreshLayout.isRefreshing()) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showNetworkErrorToast() {
        Snackbar.a0(getView(), getString(R.string.connection_error), 0).P();
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void showReactionsPopup(String str, String str2, int i2) {
        EditorialBundleViewHolder viewHolderForAdapterPosition = getViewHolderForAdapterPosition(i2);
        if (viewHolderForAdapterPosition != null) {
            viewHolderForAdapterPosition.showReactions(str, str2, i2);
        }
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<Void> snackLogInClick() {
        return this.snackListener;
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void update(List<CurationCard> list) {
        this.editorialList.setVisibility(0);
        EditorialListAdapter editorialListAdapter = this.adapter;
        if (editorialListAdapter != null) {
            editorialListAdapter.update(list);
        }
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public void updateEditorialCard(CurationCard curationCard) {
        this.adapter.updateEditorialCard(curationCard);
    }

    @Override // cm.aptoide.pt.editorialList.EditorialListView
    public rx.e<EditorialListEvent> visibleCards() {
        return e.g.a.b.c.a.c.a(this.editorialList).I0(rx.l.c.a.b()).X(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5586f.h((e.g.a.b.c.a.a) obj);
            }
        }).D(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() != -1);
            }
        }).t().X(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5602f.i((Integer) obj);
            }
        });
    }
}
