package cm.aptoide.pt.app.view;

import androidx.fragment.app.Fragment;
import cm.aptoide.pt.dataprovider.model.v7.Layout;
import cm.aptoide.pt.dataprovider.model.v7.ListApps;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.dataprovider.ws.v7.Endless;
import cm.aptoide.pt.dataprovider.ws.v7.V7;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.store.view.GetStoreEndlessFragment;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import cm.aptoide.pt.store.view.StoreTabWidgetsGridRecyclerFragment;
import cm.aptoide.pt.store.view.featured.AppBrickListDisplayable;
import cm.aptoide.pt.store.view.top.TopAppListDisplayable;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListAppsFragment extends GetStoreEndlessFragment<ListApps> {

    /* JADX INFO: renamed from: cm.aptoide.pt.app.view.ListAppsFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout;

        static {
            int[] iArr = new int[Layout.values().length];
            $SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout = iArr;
            try {
                iArr[Layout.GRAPHIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$buildAction$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(ListApps listApps) {
        List<App> list = listApps.getDataList().getList();
        LinkedList linkedList = new LinkedList();
        if (this.homeEventType.equals(HomeEvent.Type.MORE_TOP)) {
            for (App app : list) {
                app.getStore().setAppearance(new Store.Appearance(((StoreTabGridRecyclerFragment) this).storeTheme, null));
                linkedList.add(new TopAppListDisplayable(app, this.tag, ((StoreTabWidgetsGridRecyclerFragment) this).navigationTracker, this.storeContext));
            }
        } else {
            Layout layout = this.layout;
            if (layout == null) {
                for (App app2 : list) {
                    app2.getStore().setAppearance(new Store.Appearance(((StoreTabGridRecyclerFragment) this).storeTheme, null));
                    linkedList.add(new GridAppDisplayable(app2, this.tag, ((StoreTabWidgetsGridRecyclerFragment) this).navigationTracker, this.storeContext));
                }
            } else if (AnonymousClass1.$SwitchMap$cm$aptoide$pt$dataprovider$model$v7$Layout[layout.ordinal()] != 1) {
                for (App app3 : list) {
                    app3.getStore().setAppearance(new Store.Appearance(((StoreTabGridRecyclerFragment) this).storeTheme, null));
                    linkedList.add(new GridAppDisplayable(app3, this.tag, ((StoreTabWidgetsGridRecyclerFragment) this).navigationTracker, this.storeContext));
                }
            } else {
                for (App app4 : list) {
                    app4.getStore().setAppearance(new Store.Appearance(((StoreTabGridRecyclerFragment) this).storeTheme, null));
                    linkedList.add(new AppBrickListDisplayable(app4, this.tag, ((StoreTabWidgetsGridRecyclerFragment) this).navigationTracker, this.storeContext));
                }
            }
        }
        addDisplayables(linkedList);
    }

    public static Fragment newInstance() {
        return new ListAppsFragment();
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected rx.m.b<ListApps> buildAction() {
        return new rx.m.b() { // from class: cm.aptoide.pt.app.view.pd
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f4517f.h((ListApps) obj);
            }
        };
    }

    @Override // cm.aptoide.pt.store.view.GetStoreEndlessFragment
    protected V7<ListApps, ? extends Endless> buildRequest(boolean z, String str) {
        return this.requestFactoryCdnPool.newListAppsRequest(str);
    }
}
