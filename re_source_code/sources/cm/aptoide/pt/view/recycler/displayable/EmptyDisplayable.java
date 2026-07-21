package cm.aptoide.pt.view.recycler.displayable;

import android.content.res.Resources;
import android.view.WindowManager;
import cm.aptoide.pt.R;

/* JADX INFO: loaded from: classes.dex */
public class EmptyDisplayable extends Displayable {
    private int spanSize;

    public EmptyDisplayable() {
        this.spanSize = 1;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, true);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getDefaultPerLineCount() {
        return 1;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getSpanSize(WindowManager windowManager, Resources resources) {
        return this.spanSize;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_empty;
    }

    public EmptyDisplayable(int i2) {
        this.spanSize = 1;
        this.spanSize = i2;
    }
}
