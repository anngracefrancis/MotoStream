package cm.aptoide.pt.app.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.AppReview;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.utils.AptoideUtils;

/* JADX INFO: loaded from: classes.dex */
public class MiniTopReviewViewHolder extends RecyclerView.c0 {
    public static final int LAYOUT_ID = 2131493066;
    private TextView addedDate;
    private TextView commentText;
    private TextView commentTitle;
    private com.bumptech.glide.p.l.i<Drawable> imageLoadingTarget;
    private RatingBar ratingBar;
    private ImageView userIconImageView;
    private TextView userName;

    public MiniTopReviewViewHolder(View view) {
        super(view);
        bindViews(view);
    }

    private void bindViews(View view) {
        this.userIconImageView = (ImageView) view.findViewById(R.id.user_icon);
        this.ratingBar = (RatingBar) view.findViewById(R.id.rating_bar);
        this.commentTitle = (TextView) view.findViewById(R.id.comment_title);
        this.userName = (TextView) view.findViewById(R.id.user_name);
        this.addedDate = (TextView) view.findViewById(R.id.added_date);
        this.commentText = (TextView) view.findViewById(R.id.comment);
    }

    public void cancelImageLoad() {
        if (this.imageLoadingTarget != null) {
            ImageLoader.cancel(this.itemView.getContext().getApplicationContext(), this.imageLoadingTarget);
        }
    }

    public void setup(AppReview appReview) {
        String avatar = appReview.getReviewUser().getAvatar();
        Context context = this.itemView.getContext();
        this.imageLoadingTarget = ImageLoader.with(context).loadWithCircleTransformAndPlaceHolderAvatarSize(avatar, this.userIconImageView, R.drawable.layer_1);
        this.userName.setText(appReview.getReviewUser().getName());
        this.ratingBar.setRating(appReview.getReviewStats().getRating());
        this.commentTitle.setText(appReview.getTitle());
        this.commentText.setText(appReview.getBody());
        this.addedDate.setText(AptoideUtils.DateTimeU.getInstance(context).getTimeDiffString(appReview.getAdded().getTime(), context, context.getResources()));
    }
}
