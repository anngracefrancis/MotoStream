package cm.aptoide.pt.social.commentslist;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class ItemDividerDecoration extends RecyclerView.n {
    private final DisplayMetrics displayMetrics;

    public ItemDividerDecoration(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics = this.displayMetrics;
        int iApplyDimension = 0;
        if (displayMetrics != null) {
            iApplyDimension = (int) TypedValue.applyDimension(1, 0.5f, displayMetrics);
            i2 = iApplyDimension;
            i3 = i2;
            i4 = i3;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        rect.set(iApplyDimension, i2, i3, i4);
    }
}
