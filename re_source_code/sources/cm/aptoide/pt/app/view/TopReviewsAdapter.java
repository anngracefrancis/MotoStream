package cm.aptoide.pt.app.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.AppReview;

/* JADX INFO: loaded from: classes.dex */
public class TopReviewsAdapter extends RecyclerView.g<MiniTopReviewViewHolder> {
    private final AppReview[] reviews;

    public TopReviewsAdapter() {
        this(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        AppReview[] appReviewArr = this.reviews;
        if (appReviewArr == null) {
            return 0;
        }
        return appReviewArr.length;
    }

    public TopReviewsAdapter(AppReview[] appReviewArr) {
        this.reviews = appReviewArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(MiniTopReviewViewHolder miniTopReviewViewHolder, int i2) {
        miniTopReviewViewHolder.setup(this.reviews[i2]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public MiniTopReviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new MiniTopReviewViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mini_top_comment, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onViewRecycled(MiniTopReviewViewHolder miniTopReviewViewHolder) {
        miniTopReviewViewHolder.cancelImageLoad();
        super.onViewRecycled(miniTopReviewViewHolder);
    }
}
