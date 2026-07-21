package cm.aptoide.pt.store.view.featured;

import cm.aptoide.analytics.implementation.navigation.NavigationTracker;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class AppBrickDisplayable extends DisplayablePojo<App> {
    private NavigationTracker navigationTracker;
    private String tag;

    public AppBrickDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(2, true);
    }

    public NavigationTracker getNavigationTracker() {
        return this.navigationTracker;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.brick_app_item;
    }

    public AppBrickDisplayable(App app, String str, NavigationTracker navigationTracker) {
        super(app);
        this.tag = str;
        this.navigationTracker = navigationTracker;
    }
}
