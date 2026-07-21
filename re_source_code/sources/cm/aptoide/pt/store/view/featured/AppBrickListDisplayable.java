package cm.aptoide.pt.store.view.featured;

import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class AppBrickListDisplayable extends DisplayablePojo<App> {
    private NavigationTracker navigationTracker;
    private StoreContext storeContext;
    private String tag;

    public AppBrickListDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    public NavigationTracker getNavigationTracker() {
        return this.navigationTracker;
    }

    public StoreContext getStoreContext() {
        return this.storeContext;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.brick_app_item_list;
    }

    public AppBrickListDisplayable(App app, String str, NavigationTracker navigationTracker, StoreContext storeContext) {
        super(app);
        this.tag = str;
        this.navigationTracker = navigationTracker;
        this.storeContext = storeContext;
    }
}
