package cm.aptoide.pt.home.more.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.ads.data.AptoideNativeAd;
import cm.aptoide.pt.home.more.base.ListAppsViewHolder;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.app.Application;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ListAppsMoreViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcm/aptoide/pt/home/more/apps/ListAppsMoreViewHolder;", "Lcm/aptoide/pt/home/more/base/ListAppsViewHolder;", "Lcm/aptoide/pt/view/app/Application;", "view", "Landroid/view/View;", "decimalFormatter", "Ljava/text/DecimalFormat;", "(Landroid/view/View;Ljava/text/DecimalFormat;)V", "bindApp", HttpUrl.FRAGMENT_ENCODE_SET, "app", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ListAppsMoreViewHolder extends ListAppsViewHolder<Application> {
    private final DecimalFormat decimalFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListAppsMoreViewHolder(View view, DecimalFormat decimalFormat) {
        super(view);
        m.f(view, "view");
        m.f(decimalFormat, "decimalFormatter");
        this.decimalFormatter = decimalFormat;
    }

    @Override // cm.aptoide.pt.home.more.base.ListAppsViewHolder
    public void bindApp(Application app) {
        m.f(app, "app");
        ((TextView) this.itemView.findViewById(R.id.name)).setText(app.getName());
        ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(app.getIcon(), 8, (ImageView) this.itemView.findViewById(R.id.icon), R.attr.placeholder_square);
        if (app.hasAppcBilling()) {
            ((LinearLayout) this.itemView.findViewById(R.id.appc_info_layout)).setVisibility(0);
            ((TextView) this.itemView.findViewById(R.id.appc_text)).setText(R.string.appc_card_short);
            ((LinearLayout) this.itemView.findViewById(R.id.rating_info_layout)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R.id.ad_label)).setVisibility(8);
            return;
        }
        if (app instanceof AptoideNativeAd) {
            ((TextView) this.itemView.findViewById(R.id.ad_label)).setVisibility(0);
            ((LinearLayout) this.itemView.findViewById(R.id.rating_info_layout)).setVisibility(0);
            ((LinearLayout) this.itemView.findViewById(R.id.appc_info_layout)).setVisibility(8);
            ((TextView) this.itemView.findViewById(R.id.rating_label)).setText(this.decimalFormatter.format(((AptoideNativeAd) app).getStars()));
            return;
        }
        if (app.getRating() == 0.0f) {
            ((TextView) this.itemView.findViewById(R.id.rating_label)).setText(R.string.appcardview_title_no_stars);
        } else {
            ((TextView) this.itemView.findViewById(R.id.rating_label)).setText(this.decimalFormatter.format(Float.valueOf(app.getRating())));
        }
        ((LinearLayout) this.itemView.findViewById(R.id.rating_info_layout)).setVisibility(0);
        ((LinearLayout) this.itemView.findViewById(R.id.appc_info_layout)).setVisibility(8);
        ((TextView) this.itemView.findViewById(R.id.ad_label)).setVisibility(8);
    }
}
