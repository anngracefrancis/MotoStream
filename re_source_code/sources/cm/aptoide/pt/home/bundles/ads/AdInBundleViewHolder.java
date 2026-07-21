package cm.aptoide.pt.home.bundles.ads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.ads.data.Payout;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
class AdInBundleViewHolder extends RecyclerView.c0 {
    private final rx.s.b<AdHomeEvent> adClickedEvents;
    private final View appInfoLayout;
    private final View appcEarnLayout;
    private final ImageView iconView;
    private final TextView nameTextView;
    private final DecimalFormat oneDecimalFormatter;
    private final TextView rating;
    private final TextView rewardTextView;

    public AdInBundleViewHolder(View view, rx.s.b<AdHomeEvent> bVar, DecimalFormat decimalFormat) {
        super(view);
        this.nameTextView = (TextView) view.findViewById(R.id.name);
        this.iconView = (ImageView) view.findViewById(R.id.icon);
        this.rating = (TextView) view.findViewById(R.id.rating_label);
        this.appcEarnLayout = view.findViewById(R.id.appc_earn_layout);
        this.appInfoLayout = view.findViewById(R.id.app_info_layout);
        this.rewardTextView = (TextView) view.findViewById(R.id.reward_textview);
        this.adClickedEvents = bVar;
        this.oneDecimalFormatter = decimalFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(AdClick adClick, int i2, HomeBundle homeBundle, int i3, View view) {
        this.adClickedEvents.onNext(new AdHomeEvent(adClick, i2, homeBundle, i3, HomeEvent.Type.AD));
    }

    public void setApp(final AdClick adClick, final HomeBundle homeBundle, final int i2, final int i3) {
        this.nameTextView.setText(adClick.getAd().getAdTitle());
        ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(adClick.getAd().getIconUrl(), 8, this.iconView, R.attr.placeholder_square);
        if (adClick.getAd().hasAppcPayout()) {
            Payout appcPayout = adClick.getAd().getAppcPayout();
            this.appInfoLayout.setVisibility(8);
            this.appcEarnLayout.setVisibility(0);
            this.rewardTextView.setText(this.itemView.getContext().getString(R.string.poa_app_card_short, appcPayout.getFiatSymbol() + this.oneDecimalFormatter.format(appcPayout.getFiatAmount())));
        } else {
            this.appInfoLayout.setVisibility(0);
            this.appcEarnLayout.setVisibility(8);
            float fIntValue = adClick.getAd().getStars().intValue();
            if (fIntValue == 0.0f) {
                this.rating.setText(R.string.appcardview_title_no_stars);
            } else {
                this.rating.setText(this.oneDecimalFormatter.format(fIntValue));
            }
        }
        adClick.getAd().registerClickableView(this.itemView);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.ads.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5853f.a(adClick, i3, homeBundle, i2, view);
            }
        });
    }
}
