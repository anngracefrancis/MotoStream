package cm.aptoide.pt.home.bundles.apps;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.view.app.AppViewHolder;
import cm.aptoide.pt.view.app.Application;
import java.text.DecimalFormat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AppsInBundleAdapter extends RecyclerView.g<RecyclerView.c0> {
    private static final int APP = 2131492901;
    private static final int REWARD_APP = 2131493160;
    private final rx.s.b<HomeEvent> appClickedEvents;
    private List<Application> apps;
    private ExperimentClicked experimentClickedEvent;
    private final DecimalFormat oneDecimalFormatter;
    private HomeBundle homeBundle = null;
    private int bundlePosition = -1;

    AppsInBundleAdapter(List<Application> list, DecimalFormat decimalFormat, rx.s.b<HomeEvent> bVar, ExperimentClicked experimentClicked) {
        this.apps = list;
        this.oneDecimalFormatter = decimalFormat;
        this.appClickedEvents = bVar;
        this.experimentClickedEvent = experimentClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.apps.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return this.apps.get(i2) instanceof RewardApp ? R.layout.reward_app_home_item : R.layout.app_home_item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.c0 c0Var, int i2) {
        ((AppViewHolder) c0Var).setApp(this.apps.get(i2), this.homeBundle, this.bundlePosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.c0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == R.layout.app_home_item) {
            return new AppInBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_home_item, viewGroup, false), this.appClickedEvents, this.oneDecimalFormatter);
        }
        if (i2 == R.layout.reward_app_home_item) {
            return new RewardAppInBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reward_app_home_item, viewGroup, false), this.appClickedEvents);
        }
        throw new IllegalArgumentException("Wrong type of App");
    }

    public void update(List<Application> list) {
        this.apps = list;
        notifyDataSetChanged();
    }

    public void updateBundle(HomeBundle homeBundle, int i2) {
        this.homeBundle = homeBundle;
        this.bundlePosition = i2;
    }
}
