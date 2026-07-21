package cm.aptoide.pt.reviews;

import android.view.View;
import android.widget.Spinner;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class ReviewsLanguageFilterWidget extends Widget<ReviewsLanguageFilterDisplayable> {
    private Spinner spinner;

    public ReviewsLanguageFilterWidget(View view) {
        super(view);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.spinner = (Spinner) view.findViewById(R.id.comments_filter_language_spinner);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(ReviewsLanguageFilterDisplayable reviewsLanguageFilterDisplayable, int i2) {
        reviewsLanguageFilterDisplayable.setup(this.spinner);
    }
}
