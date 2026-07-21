package cm.aptoide.pt.app;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ReviewsViewModel {
    private final ReviewRequestResult.Error error;
    private final boolean loading;
    private final List<AppReview> reviewsList;

    public ReviewsViewModel(List<AppReview> list, boolean z, ReviewRequestResult.Error error) {
        this.reviewsList = list;
        this.loading = z;
        this.error = error;
    }

    public ReviewRequestResult.Error getError() {
        return this.error;
    }

    public List<AppReview> getReviewsList() {
        return this.reviewsList;
    }

    public boolean hasError() {
        return this.error != null;
    }

    public boolean isLoading() {
        return this.loading;
    }
}
