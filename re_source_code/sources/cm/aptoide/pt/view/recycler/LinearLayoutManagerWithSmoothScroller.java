package cm.aptoide.pt.view.recycler;

import android.content.Context;
import android.graphics.PointF;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManagerWithSmoothScroller extends LinearLayoutManager {

    private class TopSnappedSmoothScroller extends androidx.recyclerview.widget.j {
        TopSnappedSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.y
        public PointF computeScrollVectorForPosition(int i2) {
            return LinearLayoutManagerWithSmoothScroller.this.computeScrollVectorForPosition(i2);
        }

        @Override // androidx.recyclerview.widget.j
        protected int getVerticalSnapPreference() {
            return -1;
        }
    }

    public LinearLayoutManagerWithSmoothScroller(Context context) {
        super(context, 1, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        TopSnappedSmoothScroller topSnappedSmoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        topSnappedSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(topSnappedSmoothScroller);
    }

    public LinearLayoutManagerWithSmoothScroller(Context context, int i2, boolean z) {
        super(context, i2, z);
    }
}
