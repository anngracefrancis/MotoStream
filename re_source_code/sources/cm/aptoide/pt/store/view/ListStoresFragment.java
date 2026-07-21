package cm.aptoide.pt.store.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cm.aptoide.analytics.AnalyticsManager;
import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.store.StoreAnalytics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class ListStoresFragment extends GetStoreEndlessFragment<ListStores> {

    @Inject
    AnalyticsManager analyticsManager;

    @Inject
    NavigationTracker navigationTracker;
    private StoreAnalytics storeAnalytics;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(ListStores listStores) {
        List<Store> list = listStores.getDataList().getList();
        LinkedList linkedList = new LinkedList();
        Iterator<Store> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(new GridStoreDisplayable(it.next(), "Home " + getToolbar().getTitle().toString(), this.storeAnalytics));
        }
        addDisplayables(linkedList);
    }

    public static Fragment newInstance() {
        return new ListStoresFragment();
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected rx.m.b<ListStores> buildAction() {
        return new rx.m.b() { // from class: cm.aptoide.pt.store.view.y0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7771f.h((ListStores) obj);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected V7<ListStores, ? extends Endless> buildRequest(boolean z, String str) {
        return this.requestFactoryCdnPool.newListStoresRequest(str);
    }

    @Override // cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment, cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.storeAnalytics = new StoreAnalytics(this.analyticsManager, this.navigationTracker);
    }
}
