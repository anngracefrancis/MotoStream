package cm.aptoide.pt.reviews;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.utils.AptoideUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RatingTotalsLayout {
    private AppCompatRatingBar ratingBar;
    private TextView ratingValue;
    private TextView usersVoted;

    public RatingTotalsLayout(View view) {
        this.usersVoted = (TextView) view.findViewById(R.id.users_voted);
        this.ratingValue = (TextView) view.findViewById(R.id.rating_value);
        this.ratingBar = (AppCompatRatingBar) view.findViewById(R.id.rating_bar);
    }

    public void setup(GetAppMeta.Stats.Rating rating) {
        this.usersVoted.setText(AptoideUtils.StringU.withSuffix(rating.getTotal()));
        this.ratingValue.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(rating.getAvg())));
        this.ratingBar.setRating(rating.getAvg());
    }
}
