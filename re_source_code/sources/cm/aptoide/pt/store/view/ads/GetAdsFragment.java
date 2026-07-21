package cm.aptoide.pt.store.view.ads;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.ads.AdsRepository;
import cm.aptoide.pt.ads.MinimalAd;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayableGroup;
import cm.aptoide.pt.view.recycler.displayable.GridAdDisplayable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class GetAdsFragment extends StoreTabGridRecyclerFragment {
    private AdsRepository adsRepository;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildDisplayables$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List f(List list) {
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(new GridAdDisplayable((MinimalAd) it.next(), this.tag, this.navigationTracker));
        }
        return Collections.singletonList(new DisplayableGroup(linkedList, (WindowManager) getContext().getSystemService("window"), getContext().getResources()));
    }

    public static Fragment newInstance() {
        return new GetAdsFragment();
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment
    protected e<List<Displayable>> buildDisplayables(boolean z, String str, boolean z2) {
        return this.adsRepository.getAdsFromHomepageMore(z).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.ads.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7591f.f((List) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment, cm.aptoide.pt.view.fragment.AptoideBaseFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.NavigationTrackFragment, cm.aptoide.pt.view.fragment.FragmentView, com.trello.rxlifecycle.h.a.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.adsRepository = ((AptoideApplication) getContext().getApplicationContext()).getAdsRepository();
    }
}
