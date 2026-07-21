package cm.aptoide.pt.reviews;

import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.FullReview;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class RowReviewDisplayable extends DisplayablePojo<FullReview> {
    private StoreAnalytics storeAnalytics;

    public RowReviewDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    public StoreAnalytics getStoreAnalytics() {
        return this.storeAnalytics;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_row_review;
    }

    public RowReviewDisplayable(FullReview fullReview, StoreAnalytics storeAnalytics) {
        super(fullReview);
        this.storeAnalytics = storeAnalytics;
    }
}
