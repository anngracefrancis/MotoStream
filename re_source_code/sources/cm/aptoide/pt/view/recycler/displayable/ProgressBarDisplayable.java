package cm.aptoide.pt.view.recycler.displayable;

import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public class ProgressBarDisplayable extends Displayable {
    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.row_progress_bar;
    }
}
