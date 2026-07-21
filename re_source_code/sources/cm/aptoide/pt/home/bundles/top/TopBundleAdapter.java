package cm.aptoide.pt.home.bundles.top;

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
public class TopBundleAdapter extends RecyclerView.g<RecyclerView.c0> {
    private static final int TOP_APP = 2131493206;
    private final rx.s.b<HomeEvent> appClickedEvents;
    private List<Application> apps;
    private final DecimalFormat oneDecimalFormatter;
    private HomeBundle homeBundle = null;
    private int bundlePosition = -1;

    TopBundleAdapter(List<Application> list, DecimalFormat decimalFormat, rx.s.b<HomeEvent> bVar) {
        this.apps = list;
        this.oneDecimalFormatter = decimalFormat;
        this.appClickedEvents = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.apps.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return R.layout.top_app_item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.c0 c0Var, int i2) {
        ((AppViewHolder) c0Var).setApp(this.apps.get(i2), this.homeBundle, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.c0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new TopAppViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_app_item, viewGroup, false), this.appClickedEvents, this.oneDecimalFormatter);
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
