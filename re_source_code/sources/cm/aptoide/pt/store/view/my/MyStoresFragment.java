package cm.aptoide.pt.store.view.my;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.accountmanager.Account;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.bottomNavigation.BottomNavigationActivity;
import cm.aptoide.pt.bottomNavigation.BottomNavigationItem;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.view.GridStoreDisplayable;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import cm.aptoide.pt.timeline.view.displayable.FollowStoreDisplayable;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayableGroup;
import java.util.List;
import javax.inject.Inject;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class MyStoresFragment extends StoreTabWidgetsGridRecyclerFragment implements MyStoresView {
    private BottomNavigationActivity bottomNavigationActivity;

    @Inject
    MyStoresPresenter myStoresPresenter;

    @Inject
    RoomStoreRepository storeRepository;
    private ImageView userAvatar;
    private static final String TAG = MyStoresFragment.class.getSimpleName();
    private static final BottomNavigationItem BOTTOM_NAVIGATION_ITEM = BottomNavigationItem.STORES;

    /* JADX INFO: Access modifiers changed from: private */
    public List<Displayable> addFollowStoreDisplayable(List<Displayable> list) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                i3 = 0;
                break;
            }
            if (list.get(i3) instanceof DisplayableGroup) {
                break;
            }
            i3++;
        }
        List<Displayable> children = ((DisplayableGroup) list.get(i3)).getChildren();
        for (int i4 = 0; i4 < children.size(); i4++) {
            if (children.get(i4) instanceof GridStoreDisplayable) {
                i2 = i4;
                break;
            }
        }
        ((DisplayableGroup) list.get(i3)).getChildren().add(i2, new FollowStoreDisplayable());
        if (children.size() > 6) {
            ((DisplayableGroup) list.get(i3)).getChildren().remove(children.size() - 1);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$registerForViewChanges$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Account account) {
        reloadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$registerForViewChanges$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(List list) {
        Logger.getInstance().d(TAG, "Store database changed, reloading...");
        reloadData();
    }

    static /* synthetic */ void lambda$registerForViewChanges$2(Object obj) {
    }

    public static MyStoresFragment newInstance(Event event, String str, String str2, StoreContext storeContext) {
        Bundle bundleBuildBundle = StoreTabGridRecyclerFragment.buildBundle(event, HomeEvent.Type.NO_OP, null, str, str2, storeContext, false);
        MyStoresFragment myStoresFragment = new MyStoresFragment();
        myStoresFragment.setArguments(bundleBuildBundle);
        return myStoresFragment;
    }

    private void registerForViewChanges() {
        rx.e.a0(((AptoideApplication) getContext().getApplicationContext()).getAccountManager().accountStatus().x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.e
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7649f.h((Account) obj);
            }
        }), this.storeRepository.getAll().y0(1).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7641f.i((List) obj);
            }
        })).j0(rx.l.c.a.b()).f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.b
            @Override // rx.m.b
            public final void call(Object obj) {
                MyStoresFragment.lambda$registerForViewChanges$2(obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.f
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        });
    }

    private void reloadData() {
        super.load(false, true, null);
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment
    protected rx.e<List<Displayable>> buildDisplayables(boolean z, String str, boolean z2) {
        return this.requestFactoryCdnPool.newStoreWidgets(str).observe(z, z2).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7637f.parseDisplayables((GetStoreWidgets) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.my.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7645f.addFollowStoreDisplayable((List) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return false;
    }

    @Override // cm.aptoide.pt.store.view.my.MyStoresView
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

    @Override // cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment, cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        return layoutInflater.inflate(R.layout.my_stores, viewGroup, false);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.userAvatar = null;
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDetach() {
        this.bottomNavigationActivity = null;
        super.onDetach();
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.BaseFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BottomNavigationActivity bottomNavigationActivity = this.bottomNavigationActivity;
        if (bottomNavigationActivity != null) {
            bottomNavigationActivity.requestFocus(BOTTOM_NAVIGATION_ITEM);
        }
        registerForViewChanges();
        if (getView() != null) {
            this.userAvatar = (ImageView) getView().findViewById(R.id.user_actionbar_icon);
        }
        attachPresenter(this.myStoresPresenter);
    }

    @Override // cm.aptoide.pt.store.view.my.MyStoresView
    public void scrollToTop() {
        RecyclerView recyclerView = getRecyclerView();
        if (((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition() > 10) {
            recyclerView.scrollToPosition(10);
        }
        recyclerView.smoothScrollToPosition(0);
    }

    @Override // cm.aptoide.pt.store.view.my.MyStoresView
    public void setDefaultUserImage() {
        ImageLoader.with(getContext()).loadUsingCircleTransform(R.drawable.ic_account_circle, this.userAvatar);
    }

    @Override // cm.aptoide.pt.store.view.my.MyStoresView
    public void setUserImage(String str) {
        if (this.userAvatar != null) {
            ImageLoader.with(getContext()).loadWithShadowCircleTransformWithPlaceholder(str, this.userAvatar, R.drawable.ic_account_circle);
        }
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    public void setupToolbarDetails(Toolbar toolbar) {
        toolbar.setTitle((CharSequence) null);
        toolbar.setLogo((Drawable) null);
    }

    @Override // cm.aptoide.pt.store.view.my.MyStoresView
    public void showAvatar() {
        ImageView imageView = this.userAvatar;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public static Fragment newInstance() {
        return new MyStoresFragment();
    }
}
