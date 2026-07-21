package cm.aptoide.aptoideviews.skeleton.recyclerview;

import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.aptoideviews.skeleton.Skeleton;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SkeletonRecyclerViewWrapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R0\u0010\b\u001a$\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u0001 \u000b*\u000b\u0012\u0002\b\u0003\u0018\u00010\t¨\u0006\u00010\t¨\u0006\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcm/aptoide/aptoideviews/skeleton/recyclerview/SkeletonRecyclerViewWrapper;", "Lcm/aptoide/aptoideviews/skeleton/Skeleton;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "listItemLayoutResId", HttpUrl.FRAGMENT_ENCODE_SET, "itemCount", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "originalAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "kotlin.jvm.PlatformType", "skeletonAdapter", "Lcm/aptoide/aptoideviews/skeleton/recyclerview/SkeletonAdapter;", "showOriginal", HttpUrl.FRAGMENT_ENCODE_SET, "showSkeleton", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SkeletonRecyclerViewWrapper implements Skeleton {
    private final RecyclerView.g originalAdapter;
    private final RecyclerView recyclerView;
    private final SkeletonAdapter skeletonAdapter;

    public SkeletonRecyclerViewWrapper(RecyclerView recyclerView, int i2, int i3) {
        m.f(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.originalAdapter = recyclerView.getAdapter();
        this.skeletonAdapter = new SkeletonAdapter(i2, i3);
    }

    @Override // cm.aptoide.aptoideviews.skeleton.Skeleton
    public void showOriginal() {
        RecyclerView.o layoutManager;
        RecyclerView.o layoutManager2 = this.recyclerView.getLayoutManager();
        Parcelable parcelableOnSaveInstanceState = layoutManager2 != null ? layoutManager2.onSaveInstanceState() : null;
        this.recyclerView.setAdapter(this.originalAdapter);
        if (parcelableOnSaveInstanceState == null || (layoutManager = this.recyclerView.getLayoutManager()) == null) {
            return;
        }
        layoutManager.onRestoreInstanceState(parcelableOnSaveInstanceState);
    }

    @Override // cm.aptoide.aptoideviews.skeleton.Skeleton
    public void showSkeleton() {
        this.recyclerView.setAdapter(this.skeletonAdapter);
    }
}
