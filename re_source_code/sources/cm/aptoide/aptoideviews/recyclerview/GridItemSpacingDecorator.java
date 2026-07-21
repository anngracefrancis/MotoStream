package cm.aptoide.aptoideviews.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: GridItemSpacingDecorator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcm/aptoide/aptoideviews/recyclerview/GridItemSpacingDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spacingPx", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "getSpacingPx", "()I", "setSpacingPx", "getItemOffsets", HttpUrl.FRAGMENT_ENCODE_SET, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridItemSpacingDecorator extends RecyclerView.n {
    private int spacingPx;

    public GridItemSpacingDecorator() {
        this(0, 1, null);
    }

    public GridItemSpacingDecorator(int i2) {
        this.spacingPx = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        m.f(rect, "outRect");
        m.f(view, "view");
        m.f(recyclerView, "parent");
        m.f(zVar, "state");
        rect.setEmpty();
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.set(childAdapterPosition % gridLayoutManager.getSpanCount() != 0 ? this.spacingPx : 0, childAdapterPosition / gridLayoutManager.getSpanCount() != 0 ? this.spacingPx : 0, 0, 0);
    }

    public final int getSpacingPx() {
        return this.spacingPx;
    }

    public final void setSpacingPx(int i2) {
        this.spacingPx = i2;
    }

    public /* synthetic */ GridItemSpacingDecorator(int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? 0 : i2);
    }
}
