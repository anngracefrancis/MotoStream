package cm.aptoide.pt.timeline.view.follow;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import cm.aptoide.analytics.implementation.navigation.ScreenTagHistory;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener;
import cm.aptoide.pt.dataprovider.model.v7.GetFollowers;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment;
import cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.MessageWhiteBgDisplayable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeLineFollowFragment extends GridRecyclerSwipeWithToolbarFragment {
    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener;
    private StoreContext storeContext;

    public class BundleKeys {
        public static final String STORE_CONTEXT = "STORE_CONTEXT";
        public static final String STORE_ID = "STORE_ID";
        public static final String USER_ID = "user_id";

        public BundleKeys() {
        }
    }

    protected static Bundle buildBundle(StoreContext storeContext) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKeys.STORE_CONTEXT, storeContext);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$load$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(int[] iArr, LinkedList linkedList, GetFollowers getFollowers) {
        iArr[0] = iArr[0] + getFollowers.getDataList().getHidden();
        Iterator<GetFollowers.TimelineUser> it = getFollowers.getDataList().getList().iterator();
        while (it.hasNext()) {
            linkedList.add(createUserDisplayable(it.next()));
        }
        addDisplayables(linkedList);
        linkedList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$load$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(int[] iArr, EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener) {
        addDisplayable(new MessageWhiteBgDisplayable(getFooterMessage(iArr[0])));
    }

    protected abstract V7 buildRequest();

    protected abstract Displayable createUserDisplayable(GetFollowers.TimelineUser timelineUser);

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment
    protected boolean displayHomeUpAsEnabled() {
        return true;
    }

    protected abstract EndlessRecyclerOnScrollListener.BooleanAction<GetFollowers> getFirstResponseAction(List<Displayable> list);

    protected abstract String getFooterMessage(int i2);

    protected abstract String getHeaderMessage();

    @Override // cm.aptoide.pt.view.fragment.NavigationTrackFragment
    public ScreenTagHistory getHistoryTracker() {
        String simpleName = getClass().getSimpleName();
        StoreContext storeContext = this.storeContext;
        return ScreenTagHistory.Builder.build(simpleName, HttpUrl.FRAGMENT_ENCODE_SET, storeContext != null ? storeContext.name() : null);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
        if (!z && !z2) {
            getRecyclerView().addOnScrollListener(this.endlessRecyclerOnScrollListener);
            return;
        }
        V7 v7BuildRequest = buildRequest();
        final LinkedList linkedList = new LinkedList();
        final int[] iArr = {0};
        rx.m.b bVar = new rx.m.b() { // from class: cm.aptoide.pt.timeline.view.follow.e
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7793f.e(iArr, linkedList, (GetFollowers) obj);
            }
        };
        EndlessRecyclerOnScrollListener.BooleanAction<GetFollowers> firstResponseAction = getFirstResponseAction(linkedList);
        getRecyclerView().clearOnScrollListeners();
        EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener(getAdapter(), v7BuildRequest, bVar, new ErrorRequestListener() { // from class: cm.aptoide.pt.timeline.view.follow.h
            @Override // cm.aptoide.pt.dataprovider.interfaces.ErrorRequestListener
            public final void onError(Throwable th) {
                th.printStackTrace();
            }
        }, 6, true, firstResponseAction, null);
        this.endlessRecyclerOnScrollListener = endlessRecyclerOnScrollListener;
        endlessRecyclerOnScrollListener.addOnEndlessFinishListener(new EndlessRecyclerOnScrollListener.OnEndlessFinish() { // from class: cm.aptoide.pt.timeline.view.follow.d
            @Override // cm.aptoide.pt.view.recycler.EndlessRecyclerOnScrollListener.OnEndlessFinish
            public final void onEndlessFinish(EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener2) {
                this.a.f(iArr, endlessRecyclerOnScrollListener2);
            }
        });
        getRecyclerView().addOnScrollListener(this.endlessRecyclerOnScrollListener);
        this.endlessRecyclerOnScrollListener.onLoadMore(z2, z2);
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void loadExtras(Bundle bundle) {
        super.loadExtras(bundle);
        this.storeContext = (StoreContext) bundle.getSerializable(BundleKeys.STORE_CONTEXT);
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.menu_empty, menu);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.endlessRecyclerOnScrollListener.removeListeners();
        super.onDestroyView();
    }

    @Override // cm.aptoide.pt.view.fragment.GridRecyclerSwipeWithToolbarFragment, cm.aptoide.pt.view.fragment.FragmentView, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getActivity().onBackPressed();
        return true;
    }
}
