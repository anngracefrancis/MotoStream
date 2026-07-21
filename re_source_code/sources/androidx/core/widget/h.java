package androidx.core.widget;

import android.widget.ListView;

/* JADX INFO: compiled from: ListViewAutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends c {
    private final ListView x;

    public h(ListView listView) {
        super(listView);
        this.x = listView;
    }

    @Override // androidx.core.widget.c
    public boolean a(int i2) {
        return false;
    }

    @Override // androidx.core.widget.c
    public boolean b(int i2) {
        ListView listView = this.x;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i3 = firstVisiblePosition + childCount;
        if (i2 > 0) {
            if (i3 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i2 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.c
    public void j(int i2, int i3) {
        i.b(this.x, i3);
    }
}
