package cm.aptoide.pt.view.recycler.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.FullReview;
import cm.aptoide.pt.dataprovider.model.v7.GetAppMeta;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.reviews.RowReviewDisplayable;
import cm.aptoide.pt.utils.AptoideUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class RowReviewWidget extends Widget<RowReviewDisplayable> {
    public ImageView appIcon;
    public TextView appName;
    private ImageView avatar;
    public TextView rating;
    private TextView reviewBody;
    private TextView reviewer;

    public RowReviewWidget(View view) {
        super(view);
    }

    static /* synthetic */ void lambda$bindView$0(RowReviewDisplayable rowReviewDisplayable, FragmentNavigator fragmentNavigator, GetAppMeta.App app, FullReview fullReview, Void r14) {
        if (rowReviewDisplayable.getStoreAnalytics() != null) {
            rowReviewDisplayable.getStoreAnalytics().sendStoreInteractEvent("View Review", "Latest Reviews", rowReviewDisplayable.getPojo().getData().getApp().getStore().getName());
        }
        fragmentNavigator.navigateTo(AptoideApplication.getFragmentProvider().newRateAndReviewsFragment(app.getId(), app.getName(), app.getStore().getName(), app.getPackageName(), fullReview.getId()), true);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.appIcon = (ImageView) view.findViewById(R.id.app_icon);
        this.rating = (TextView) view.findViewById(R.id.rating);
        this.appName = (TextView) view.findViewById(R.id.app_name);
        this.avatar = (ImageView) view.findViewById(R.id.avatar);
        this.reviewer = (TextView) view.findViewById(R.id.reviewer);
        this.reviewBody = (TextView) view.findViewById(R.id.description);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final RowReviewDisplayable rowReviewDisplayable, int i2) {
        androidx.fragment.app.d context = getContext();
        final FullReview pojo = rowReviewDisplayable.getPojo();
        final GetAppMeta.App app = pojo.getData().getApp();
        if (app != null) {
            this.appName.setText(app.getName());
            ImageLoader.with(context).load(app.getIcon(), this.appIcon);
        } else {
            this.appName.setVisibility(4);
            this.appIcon.setVisibility(4);
        }
        this.reviewBody.setText(pojo.getBody());
        this.reviewer.setText(AptoideUtils.StringU.getFormattedString(R.string.reviewed_by, getContext().getResources(), pojo.getUser().getName()));
        this.rating.setText(String.format(Locale.getDefault(), "%d", Long.valueOf((long) pojo.getStats().getRating())));
        ImageLoader.with(context).loadWithCircleTransformAndPlaceHolderAvatarSize(pojo.getUser().getAvatar(), this.avatar, R.drawable.layer_1);
        final FragmentNavigator fragmentNavigator = getFragmentNavigator();
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).G0(new rx.m.b() { // from class: cm.aptoide.pt.view.recycler.widget.e
            @Override // rx.m.b
            public final void call(Object obj) {
                RowReviewWidget.lambda$bindView$0(rowReviewDisplayable, fragmentNavigator, app, pojo, (Void) obj);
            }
        }));
    }
}
