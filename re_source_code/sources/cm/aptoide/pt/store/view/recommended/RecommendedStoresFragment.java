package cm.aptoide.pt.store.view.recommended;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.dataprovider.model.v7.store.ListStores;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.store.view.GetStoreEndlessFragment;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes.dex */
public class RecommendedStoresFragment extends GetStoreEndlessFragment<ListStores> {
    private AptoideAccountManager accountManager;

    @Inject
    StoreCredentialsProvider storeCredentialsProvider;

    @Inject
    RoomStoreRepository storeRepository;

    @Inject
    StoreUtilsProxy storeUtilsProxy;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ RecommendedStoreDisplayable h(Store store) {
        return new RecommendedStoreDisplayable(store, this.storeRepository, this.accountManager, this.storeUtilsProxy, this.storeCredentialsProvider, "Recommended Stores More");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(List list) {
        addDisplayables((List<? extends Displayable>) new ArrayList(list), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(ListStores listStores) {
        rx.e.S(listStores).J(new rx.m.e() { // from class: cm.aptoide.pt.store.view.recommended.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((ListStores) obj).getDataList().getList();
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.recommended.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7714f.h((Store) obj);
            }
        }).Y0().f(bindUntilEvent(com.trello.rxlifecycle.g.b.DESTROY_VIEW)).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.h
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7713f.i((List) obj);
            }
        });
    }

    public static Fragment newInstance() {
        return new RecommendedStoresFragment();
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected rx.m.b<ListStores> buildAction() {
        return new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.k
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7716f.j((ListStores) obj);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected V7<ListStores, ? extends Endless> buildRequest(boolean z, String str) {
        return this.requestFactoryCdnPool.newGetRecommendedStores(str);
    }

    @Override // cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment, cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentComponent(bundle).inject(this);
        this.accountManager = ((AptoideApplication) getContext().getApplicationContext()).getAccountManager();
    }
}
