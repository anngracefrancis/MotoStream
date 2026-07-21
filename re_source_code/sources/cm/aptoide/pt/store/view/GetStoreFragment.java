package cm.aptoide.pt.store.view;

import androidx.fragment.app.Fragment;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStore;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import java.util.List;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class GetStoreFragment extends StoreTabWidgetsGridRecyclerFragment {
    private rx.e<GetStore> getStoreObservable(boolean z, String str, boolean z2) {
        return this.name == Event.Name.getUser ? this.requestFactoryCdnPool.newGetUser(str).observe(z, z2) : this.requestFactoryCdnPool.newStore(str).observe(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildDisplayables$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e g(GetStore getStore) {
        return parseDisplayables(getStore.getNodes().getWidgets());
    }

    public static Fragment newInstance() {
        return new GetStoreFragment();
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment
    protected rx.e<List<Displayable>> buildDisplayables(boolean z, String str, boolean z2) {
        return getStoreObservable(z, str, z2).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7594f.g((GetStore) obj);
            }
        });
    }
}
