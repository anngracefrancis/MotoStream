package cm.aptoide.pt.home.bundles.editorschoice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.app.FeatureGraphicApplication;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class FeatureGraphicInBundleViewHolder extends RecyclerView.c0 {
    private final rx.s.b<HomeEvent> appClickedEvents;
    private final ImageView appIcon;
    private final ImageView featureGraphic;
    private final TextView nameTextView;
    private final DecimalFormat oneDecimalFormatter;
    private final TextView rating;

    public FeatureGraphicInBundleViewHolder(View view, DecimalFormat decimalFormat, rx.s.b<HomeEvent> bVar) {
        super(view);
        this.oneDecimalFormatter = decimalFormat;
        this.appClickedEvents = bVar;
        this.nameTextView = (TextView) this.itemView.findViewById(R.id.app_name);
        this.featureGraphic = (ImageView) this.itemView.findViewById(R.id.featured_graphic);
        this.rating = (TextView) this.itemView.findViewById(R.id.rating_label);
        this.appIcon = (ImageView) this.itemView.findViewById(R.id.app_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setFeatureGraphicApplication$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(FeatureGraphicApplication featureGraphicApplication, int i2, HomeBundle homeBundle, int i3, View view) {
        this.appClickedEvents.onNext(new AppHomeEvent(featureGraphicApplication, i2, homeBundle, i3, HomeEvent.Type.APP));
    }

    public void setFeatureGraphicApplication(final FeatureGraphicApplication featureGraphicApplication, final HomeBundle homeBundle, final int i2, final int i3) {
        this.nameTextView.setText(featureGraphicApplication.getName());
        ImageLoader.with(this.itemView.getContext()).load(featureGraphicApplication.getFeatureGraphic(), R.attr.placeholder_brick, this.featureGraphic);
        ImageLoader.with(this.itemView.getContext()).load(featureGraphicApplication.getIcon(), R.attr.placeholder_square, this.appIcon);
        float rating = featureGraphicApplication.getRating();
        if (rating == 0.0f) {
            this.rating.setText(R.string.appcardview_title_no_stars);
        } else {
            this.rating.setText(this.oneDecimalFormatter.format(rating));
        }
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.editorschoice.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5917f.a(featureGraphicApplication, i3, homeBundle, i2, view);
            }
        });
    }
}
