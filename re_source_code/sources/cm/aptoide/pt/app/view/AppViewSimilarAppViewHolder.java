package cm.aptoide.pt.app.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.app.AppViewSimilarApp;
import cm.aptoide.pt.app.view.similar.SimilarAppClickEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class AppViewSimilarAppViewHolder extends RecyclerView.c0 {
    private final TextView adLabel;
    private rx.s.b<SimilarAppClickEvent> appClicked;
    private final LinearLayout appInfoLayout;
    private final LinearLayout appcInfoLayout;
    private final ImageView iconView;
    private final View itemView;
    private final TextView nameTextView;
    private DecimalFormat oneDecimalFormatter;
    private final TextView rating;

    public AppViewSimilarAppViewHolder(View view, DecimalFormat decimalFormat, rx.s.b<SimilarAppClickEvent> bVar) {
        super(view);
        this.itemView = view;
        this.oneDecimalFormatter = decimalFormat;
        this.appClicked = bVar;
        this.appInfoLayout = (LinearLayout) view.findViewById(R.id.app_info_layout);
        this.appcInfoLayout = (LinearLayout) view.findViewById(R.id.appc_info_layout);
        this.nameTextView = (TextView) view.findViewById(R.id.name);
        this.iconView = (ImageView) view.findViewById(R.id.icon);
        this.rating = (TextView) view.findViewById(R.id.rating_label);
        this.adLabel = (TextView) view.findViewById(R.id.ad_label);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setSimilarApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(AppViewSimilarApp appViewSimilarApp, AppViewSimilarAppsAdapter.SimilarAppType similarAppType, View view) {
        this.appClicked.onNext(new SimilarAppClickEvent(appViewSimilarApp, similarAppType, getLayoutPosition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setSimilarApp$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(AppViewSimilarApp appViewSimilarApp, AppViewSimilarAppsAdapter.SimilarAppType similarAppType, View view) {
        this.appClicked.onNext(new SimilarAppClickEvent(appViewSimilarApp, similarAppType, getLayoutPosition()));
    }

    public void setSimilarApp(final AppViewSimilarApp appViewSimilarApp, final AppViewSimilarAppsAdapter.SimilarAppType similarAppType) {
        if (appViewSimilarApp.isAd()) {
            this.adLabel.setVisibility(0);
            this.nameTextView.setText(appViewSimilarApp.getAd().getAdTitle());
            ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(appViewSimilarApp.getAd().getIconUrl(), 8, this.iconView, R.attr.placeholder_square);
            appViewSimilarApp.getAd().registerClickableView(this.itemView);
            float fIntValue = appViewSimilarApp.getAd().getStars().intValue();
            if (fIntValue == 0.0f) {
                this.rating.setText(R.string.appcardview_title_no_stars);
            } else {
                this.rating.setText(this.oneDecimalFormatter.format(fIntValue));
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.id
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4374f.a(appViewSimilarApp, similarAppType, view);
                }
            });
            return;
        }
        if (appViewSimilarApp.getApp() != null) {
            this.adLabel.setVisibility(8);
            this.nameTextView.setText(appViewSimilarApp.getApp().getName());
            ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(appViewSimilarApp.getApp().getIcon(), 8, this.iconView, R.attr.placeholder_square);
            if (appViewSimilarApp.getApp().hasAppcBilling()) {
                this.appcInfoLayout.setVisibility(0);
                this.appInfoLayout.setVisibility(8);
            } else {
                this.appcInfoLayout.setVisibility(8);
                this.appInfoLayout.setVisibility(0);
                float rating = appViewSimilarApp.getApp().getRating();
                if (rating == 0.0f) {
                    this.rating.setText(R.string.appcardview_title_no_stars);
                } else {
                    this.rating.setText(this.oneDecimalFormatter.format(rating));
                }
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.app.view.jd
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4394f.b(appViewSimilarApp, similarAppType, view);
                }
            });
        }
    }
}
