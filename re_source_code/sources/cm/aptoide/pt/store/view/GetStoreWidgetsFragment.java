package cm.aptoide.pt.store.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.dataprovider.model.v7.GetStoreWidgets;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;

/* JADX INFO: loaded from: classes.dex */
public class GetStoreWidgetsFragment extends GetStoreEndlessFragment<GetStoreWidgets> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(GetStoreWidgets getStoreWidgets) {
        addDisplayables(parseDisplayables(getStoreWidgets).W0().b());
    }

    public static Fragment newInstance() {
        return new GetStoreWidgetsFragment();
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected rx.m.b<GetStoreWidgets> buildAction() {
        return new rx.m.b() { // from class: cm.aptoide.pt.store.view.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7597f.h((GetStoreWidgets) obj);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected V7<GetStoreWidgets, ? extends Endless> buildRequest(boolean z, String str) {
        return this.requestFactoryCdnPool.newStoreWidgets(str);
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment, cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderFragment, cm.aptoide.pt.view.LoadInterface
    public void load(boolean z, boolean z2, Bundle bundle) {
        super.load(z, z2, bundle);
    }

    @Override // cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment, cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
