package cm.aptoide.pt.updates.view.excluded;

import cm.aptoide.pt.R;
import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class ExcludedUpdateDisplayable extends DisplayablePojo<RoomUpdate> {
    private boolean selected;

    public ExcludedUpdateDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.row_excluded_update;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public ExcludedUpdateDisplayable(RoomUpdate roomUpdate) {
        super(roomUpdate);
    }
}
