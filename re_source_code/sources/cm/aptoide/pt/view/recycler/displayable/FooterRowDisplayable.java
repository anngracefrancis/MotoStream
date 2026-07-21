package cm.aptoide.pt.view.recycler.displayable;

import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public class FooterRowDisplayable extends DisplayablePojo<String> {
    public FooterRowDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_grid_footer_text;
    }

    public FooterRowDisplayable(String str) {
        super(str);
    }
}
