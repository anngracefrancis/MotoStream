package cm.aptoide.pt.reviews;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.utils.AptoideUtils;

/* JADX INFO: loaded from: classes.dex */
public class RatingBarsLayout {
    private ProgressAndTextLayout[] progressAndTextLayouts;

    private static class ProgressAndTextLayout {
        private ProgressBar progressBar;
        private TextView text;

        public ProgressAndTextLayout(int i2, int i3, View view) {
            this.progressBar = (ProgressBar) view.findViewById(i2);
            this.text = (TextView) view.findViewById(i3);
        }

        public void setup(int i2, int i3) {
            this.progressBar.setMax(i2);
            this.progressBar.setProgress(i3);
            this.text.setText(AptoideUtils.StringU.withSuffix(i3));
        }
    }

    public RatingBarsLayout(View view) {
        ProgressAndTextLayout[] progressAndTextLayoutArr = new ProgressAndTextLayout[5];
        this.progressAndTextLayouts = progressAndTextLayoutArr;
        progressAndTextLayoutArr[0] = new ProgressAndTextLayout(R.id.one_rate_star_progress, R.id.one_rate_star_count, view);
        this.progressAndTextLayouts[1] = new ProgressAndTextLayout(R.id.two_rate_star_progress, R.id.two_rate_star_count, view);
        this.progressAndTextLayouts[2] = new ProgressAndTextLayout(R.id.three_rate_star_progress, R.id.three_rate_star_count, view);
        this.progressAndTextLayouts[3] = new ProgressAndTextLayout(R.id.four_rate_star_progress, R.id.four_rate_star_count, view);
        this.progressAndTextLayouts[4] = new ProgressAndTextLayout(R.id.five_rate_star_progress, R.id.five_rate_star_count, view);
    }

    public void setup(GetAppMeta.Stats.Rating rating) {
        int total = rating.getTotal();
        for (GetAppMeta.Stats.Rating.Vote vote : rating.getVotes()) {
            this.progressAndTextLayouts[vote.getValue() - 1].setup(total, vote.getCount());
        }
    }
}
