package cm.aptoide.pt.home.bundles.ads;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AdsInBundleAdapter extends RecyclerView.g<AdInBundleViewHolder> {
    private final rx.s.b<AdHomeEvent> adClickedEvents;
    private List<AdClick> ads;
    private final DecimalFormat oneDecimalFormatter;
    private HomeBundle homeBundle = null;
    private int bundlePosition = -1;

    public AdsInBundleAdapter(List<AdClick> list, DecimalFormat decimalFormat, rx.s.b<AdHomeEvent> bVar) {
        this.ads = list;
        this.oneDecimalFormatter = decimalFormat;
        this.adClickedEvents = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.ads.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return this.ads.get(i2).getAd().getNetwork().ordinal();
    }

    public void update(List<AdClick> list) {
        this.ads = list;
        notifyDataSetChanged();
    }

    public void updateBundle(HomeBundle homeBundle, int i2) {
        this.homeBundle = homeBundle;
        this.bundlePosition = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(AdInBundleViewHolder adInBundleViewHolder, int i2) {
        adInBundleViewHolder.setApp(this.ads.get(i2), this.homeBundle, this.bundlePosition, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public AdInBundleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new AdInBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.displayable_grid_ad, viewGroup, false), this.adClickedEvents, this.oneDecimalFormatter);
    }
}
