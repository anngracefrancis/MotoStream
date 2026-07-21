package cm.aptoide.pt.view.recycler.displayable;

/* JADX INFO: loaded from: classes.dex */
public abstract class SelectableDisplayablePojo<T> extends DisplayablePojo<T> {
    private boolean selected;

    public SelectableDisplayablePojo() {
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public SelectableDisplayablePojo(T t) {
        super(t);
    }
}
