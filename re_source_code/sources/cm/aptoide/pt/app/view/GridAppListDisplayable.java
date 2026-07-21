package cm.aptoide.pt.app.view;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class GridAppListDisplayable extends DisplayablePojo<App> {
    private String tag;

    public GridAppListDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    public String getTag() {
        return this.tag;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_list_app;
    }

    public GridAppListDisplayable(App app, String str) {
        super(app);
        this.tag = str;
    }
}
