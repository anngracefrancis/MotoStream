package cm.aptoide.pt.view.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class SimpleDividerItemDecoration extends RecyclerView.n {
    private final int space;

    public SimpleDividerItemDecoration(Context context, int i2) {
        this.space = getPixelsFromDips(context, i2);
    }

    private int getPixelsFromDips(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i2 = this.space;
        rect.right = i2;
        rect.left = i2;
        rect.bottom = i2;
        rect.top = i2;
    }
}
