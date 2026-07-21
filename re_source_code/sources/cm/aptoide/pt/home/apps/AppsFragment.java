package cm.aptoide.pt.home.apps;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.home.apps.list.AppsController;
import cm.aptoide.pt.home.apps.model.InstalledApp;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.view.fragment.NavigationTrackFragment;
import cm.aptoide.pt.view.rx.RxAlertDialog;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
import javax.inject.Inject;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppsFragment extends NavigationTrackFragment implements AppsFragmentView {
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.APPS;
    private AppsController appsController;

    @Inject
    AppsPresenter appsPresenter;
    private EpoxyRecyclerView appsRecyclerView;
    private BottomNavigationActivity bottomNavigationActivity;
    private RxAlertDialog ignoreUpdateDialog;
    private ProgressBar progressBar;
    private c.v.a.c swipeRefreshLayout;

    @Inject
    ThemeManager themeManager;
    private ImageView userAvatar;

    private void buildIgnoreUpdatesDialog() {
        this.ignoreUpdateDialog = new RxAlertDialog.Builder(getContext(), this.themeManager).setTitle(R.string.apps_title_ignore_updates).setPositiveButton(R.string.apps_button_ignore_updates_yes).setNegativeButton(R.string.apps_button_ignore_updates_no).build();
    }

    private void hideLoadingProgressBar() {
        this.progressBar.setVisibility(8);
    }

    public static AppsFragment newInstance() {
        return new AppsFragment();
    }

    private void setupRecyclerView() {
        AppsController appsController = new AppsController(this.themeManager);
        this.appsController = appsController;
        this.appsRecyclerView.setController(appsController);
        this.appsController.getAdapter().registerAdapterDataObserver(new RecyclerView.i() { // from class: cm.aptoide.pt.home.apps.AppsFragment.1
            @Override // androidx.recyclerview.widget.RecyclerView.i
            public void onItemRangeInserted(int i2, int i3) {
                if (i2 == 0) {
                    AppsFragment.this.appsRecyclerView.scrollToPosition(0);
                }
            }
        });
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> cancelDownload() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.CANCEL_CLICK);
            }
        }).X(w3.f5824f);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> cardClick() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.CARD_CLICK);
            }
        }).X(w3.f5824f);
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        return ScreenTagHistory.Builder.build(getClass().getSimpleName());
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void hidePullToRefresh() {
        if (this.swipeRefreshLayout.isRefreshing()) {
            this.swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<Void> imageClick() {
        return e.g.a.c.a.a(this.userAvatar);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> installApp() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.INSTALL_CLICK);
            }
        }).X(w3.f5824f);
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
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.fragment_apps, viewGroup, false);
    }

    @Override // com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.progressBar = null;
        this.swipeRefreshLayout = null;
        this.ignoreUpdateDialog = null;
        this.appsRecyclerView = null;
        this.userAvatar = null;
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDetach() {
        this.bottomNavigationActivity = null;
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        AppsController appsController = this.appsController;
        if (appsController != null) {
            appsController.onSaveInstanceState(bundle);
        }
    }

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BottomNavigationActivity bottomNavigationActivity = this.bottomNavigationActivity;
        if (bottomNavigationActivity != null) {
            bottomNavigationActivity.requestFocus(BOTTOM_NAVIGATION_ITEM);
        }
        this.appsRecyclerView = (EpoxyRecyclerView) view.findViewById(R.id.fragment_apps_recycler_view);
        setupRecyclerView();
        this.swipeRefreshLayout = (c.v.a.c) view.findViewById(R.id.fragment_apps_swipe_container);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        this.progressBar = progressBar;
        progressBar.setVisibility(0);
        buildIgnoreUpdatesDialog();
        this.userAvatar = (ImageView) view.findViewById(R.id.user_actionbar_icon);
        attachPresenter(this.appsPresenter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        AppsController appsController = this.appsController;
        if (appsController != null) {
            appsController.onRestoreInstanceState(bundle);
        }
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> pauseDownload() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.PAUSE_CLICK);
            }
        }).X(w3.f5824f);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<Void> refreshApps() {
        return e.g.a.b.b.a.c.a(this.swipeRefreshLayout);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> resumeDownload() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.RESUME_CLICK);
            }
        }).X(w3.f5824f);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void scrollToTop() {
        if (((LinearLayoutManager) this.appsRecyclerView.getLayoutManager()).findLastVisibleItemPosition() > 10) {
            this.appsRecyclerView.scrollToPosition(10);
        }
        this.appsRecyclerView.smoothScrollToPosition(0);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void setDefaultUserImage() {
        ImageLoader.with(getContext()).loadUsingCircleTransform(R.drawable.ic_account_circle, this.userAvatar);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void setUserImage(String str) {
        ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(str, this.userAvatar, R.drawable.ic_account_circle);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void showAvatar() {
        this.userAvatar.setVisibility(0);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public Single<RxAlertDialog.Result> showIgnoreUpdateDialog() {
        return this.ignoreUpdateDialog.showWithResult();
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void showModel(AppsModel appsModel) {
        hideLoadingProgressBar();
        this.appsController.setData2(appsModel.getUpdates(), (List<? extends InstalledApp>) appsModel.getInstalled(), appsModel.getDownloads());
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<Boolean> showRootWarning() {
        return GenericDialogs.createGenericYesNoCancelMessage(getContext(), HttpUrl.FRAGMENT_ENCODE_SET, AptoideUtils.StringU.getFormattedString(R.string.root_access_dialog, getResources(), new Object[0]), this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).X(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((GenericDialogs.EResponse) obj).equals(GenericDialogs.EResponse.YES));
            }
        });
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public void showUnknownErrorMessage() {
        Snackbar.Z(getView(), R.string.unknown_error, -1).P();
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> startDownload() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.DOWNLOAD_ACTION_CLICK);
            }
        }).X(w3.f5824f);
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<Void> updateAll() {
        return this.appsController.getUpdateAllEvent();
    }

    @Override // cm.aptoide.pt.home.apps.AppsFragmentView
    public rx.e<App> updateLongClick() {
        return this.appsController.getAppEventListener().D(new rx.m.e() { // from class: cm.aptoide.pt.home.apps.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((AppClick) obj).getClickType() == AppClick.ClickType.CARD_LONG_CLICK);
            }
        }).X(w3.f5824f);
    }
}
