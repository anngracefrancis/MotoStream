package cm.aptoide.pt.editorialList;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: classes.dex */
public class ScrollControlLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled;

    public ScrollControlLinearLayoutManager(Context context) {
        super(context);
        this.isScrollEnabled = true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.isScrollEnabled && super.canScrollVertically();
    }

    public void setScrollEnabled(boolean z) {
        this.isScrollEnabled = z;
    }
}
