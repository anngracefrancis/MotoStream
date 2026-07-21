package cm.aptoide.pt.home.bundles.editorschoice;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.view.app.Application;
import cm.aptoide.pt.view.app.FeatureGraphicApplication;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class EditorsAppsAdapter extends RecyclerView.g<FeatureGraphicInBundleViewHolder> {
    private final rx.s.b<HomeEvent> appClickedEvents;
    private List<Application> apps;
    private final DecimalFormat oneDecimalFormatter;
    private HomeBundle homeBundle = null;
    private int bundlePosition = -1;

    public EditorsAppsAdapter(List<Application> list, DecimalFormat decimalFormat, rx.s.b<HomeEvent> bVar) {
        this.apps = list;
        this.oneDecimalFormatter = decimalFormat;
        this.appClickedEvents = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.apps.size();
    }

    public void update(List<Application> list) {
        this.apps = list;
        notifyDataSetChanged();
    }

    public void updateBundle(HomeBundle homeBundle, int i2) {
        this.homeBundle = homeBundle;
        this.bundlePosition = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(FeatureGraphicInBundleViewHolder featureGraphicInBundleViewHolder, int i2) {
        featureGraphicInBundleViewHolder.setFeatureGraphicApplication((FeatureGraphicApplication) this.apps.get(i2), this.homeBundle, this.bundlePosition, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public FeatureGraphicInBundleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FeatureGraphicInBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feature_graphic_home_item, viewGroup, false), this.oneDecimalFormatter, this.appClickedEvents);
    }
}
