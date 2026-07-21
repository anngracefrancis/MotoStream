package cm.aptoide.pt.view.custom;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class DrawableItemDecoration extends RecyclerView.n {
    private final int customHorizontalPadding;
    private final Drawable dividerDrawable;

    DrawableItemDecoration(Drawable drawable, int i2) {
        this.dividerDrawable = drawable;
        this.customHorizontalPadding = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i2 = this.customHorizontalPadding;
        int width = recyclerView.getWidth() - this.customHorizontalPadding;
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount - 1; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) childAt.getLayoutParams())).bottomMargin;
            this.dividerDrawable.setBounds(i2, bottom, width, this.dividerDrawable.getIntrinsicHeight() + bottom);
            this.dividerDrawable.draw(canvas);
        }
    }
}
