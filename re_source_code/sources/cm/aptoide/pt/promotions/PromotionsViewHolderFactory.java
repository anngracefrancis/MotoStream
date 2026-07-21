package cm.aptoide.pt.promotions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.themes.ThemeManager;

/* JADX INFO: loaded from: classes.dex */
public class PromotionsViewHolderFactory {
    private final rx.s.b<PromotionAppClick> promotionAppClick;
    private final ThemeManager themeManager;

    public PromotionsViewHolderFactory(rx.s.b<PromotionAppClick> bVar, ThemeManager themeManager) {
        this.promotionAppClick = bVar;
        this.themeManager = themeManager;
    }

    public RecyclerView.c0 createViewHolder(ViewGroup viewGroup, int i2) {
        switch (i2) {
            case 0:
                return new PromotionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_inactive, viewGroup, false), 0, this.promotionAppClick, this.themeManager);
            case 1:
                return new PromotionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_inactive, viewGroup, false), 1, this.promotionAppClick, this.themeManager);
            case 2:
                return new PromotionAppDownloadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_active_download, viewGroup, false), this.promotionAppClick);
            case 3:
                return new PromotionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_inactive, viewGroup, false), 3, this.promotionAppClick, this.themeManager);
            case 4:
                return new PromotionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_inactive, viewGroup, false), 4, this.promotionAppClick, this.themeManager);
            case 5:
                return new PromotionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_inactive, viewGroup, false), 5, this.promotionAppClick, this.themeManager);
            case 6:
                return new PromotionAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_app_inactive, viewGroup, false), 6, this.promotionAppClick, this.themeManager);
            default:
                throw new IllegalArgumentException("Wrong view type of promotion app");
        }
    }
}
