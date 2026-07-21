package cm.aptoide.pt.timeline.view.displayable;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.Type;
import cm.aptoide.pt.view.recycler.displayable.Displayable;

/* JADX INFO: loaded from: classes.dex */
public class FollowStoreDisplayable extends Displayable {
    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        Type type = Type.FOLLOW_STORE;
        return new Displayable.Configs(type.getDefaultPerLineCount(), type.isFixedPerLineCount());
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_grid_follow_store;
    }
}
