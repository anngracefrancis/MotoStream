package cm.aptoide.pt.app.view.displayable;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.listapp.App;
import cm.aptoide.pt.themes.ThemeManager;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class OtherVersionDisplayable extends DisplayablePojo<App> {
    private ThemeManager themeManager;

    public OtherVersionDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    public ThemeManager getThemeManager() {
        return this.themeManager;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.other_version_row;
    }

    public OtherVersionDisplayable(App app, ThemeManager themeManager) {
        super(app);
        this.themeManager = themeManager;
    }
}
