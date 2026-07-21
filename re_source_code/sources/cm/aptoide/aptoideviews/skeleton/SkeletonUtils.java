package cm.aptoide.aptoideviews.skeleton;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.aptoideviews.skeleton.recyclerview.SkeletonRecyclerViewWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SkeletonExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"applySkeleton", "Lcm/aptoide/aptoideviews/skeleton/Skeleton;", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "skeletonLayoutResId", HttpUrl.FRAGMENT_ENCODE_SET, "Landroidx/recyclerview/widget/RecyclerView;", "listItemLayoutResId", "itemCount", "aptoide-views_prodRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SkeletonUtils {
    public static final Skeleton applySkeleton(RecyclerView recyclerView, int i2) {
        m.f(recyclerView, "<this>");
        return applySkeleton$default(recyclerView, i2, 0, 2, null);
    }

    public static final Skeleton applySkeleton(RecyclerView recyclerView, int i2, int i3) {
        m.f(recyclerView, "<this>");
        return new SkeletonRecyclerViewWrapper(recyclerView, i2, i3);
    }

    public static /* synthetic */ Skeleton applySkeleton$default(RecyclerView recyclerView, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 9;
        }
        return applySkeleton(recyclerView, i2, i3);
    }

    public static final Skeleton applySkeleton(View view, ViewGroup viewGroup, int i2) {
        m.f(view, "<this>");
        m.f(viewGroup, "parent");
        return new SkeletonViewWrapper(view, viewGroup, i2);
    }
}
