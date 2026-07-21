package cm.aptoide.pt.view.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.n {
    public static final int ALL = 7;
    public static final int BOTTOM = 4;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    private final int space;
    private final int spacingFlag;

    public DividerItemDecoration(Context context, float f2) {
        this(context, f2, 7);
    }

    private int getPixelsFromDips(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i2 = this.spacingFlag;
        if ((i2 & 1) == 1) {
            rect.left = this.space;
        }
        if ((i2 & 2) == 2) {
            rect.right = this.space;
        }
        if ((i2 & 4) == 4) {
            rect.bottom = this.space;
        }
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getOrientation() == 1 && linearLayoutManager.getPosition(view) == 0) {
                rect.top = this.space;
                return;
            }
            return;
        }
        if (!GridLayoutManager.class.isAssignableFrom(layoutManager.getClass())) {
            if (recyclerView.getChildPosition(view) == 0) {
                rect.top = this.space;
                return;
            }
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        if (gridLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildPosition(view) < gridLayoutManager.getSpanCount()) {
                rect.top = this.space;
            }
        }
    }

    public DividerItemDecoration(Context context, float f2, int i2) {
        this.space = getPixelsFromDips(context, f2);
        this.spacingFlag = i2;
    }
}
