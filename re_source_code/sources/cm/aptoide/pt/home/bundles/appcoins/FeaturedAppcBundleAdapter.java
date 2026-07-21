package cm.aptoide.pt.home.bundles.appcoins;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.apps.AppInBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.view.app.AppViewHolder;
import cm.aptoide.pt.view.app.Application;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FeaturedAppcBundleAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0016J\u0014\u0010!\u001a\u00020\u001a2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcm/aptoide/pt/home/bundles/appcoins/FeaturedAppcBundleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", DeepLinkIntentReceiver.DeepLinksTargets.APPS, HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/view/app/Application;", "oneDecimalFormatter", "Ljava/text/DecimalFormat;", "appClickedEvents", "Lrx/subjects/PublishSubject;", "Lcm/aptoide/pt/home/bundles/base/HomeEvent;", "(Ljava/util/List;Ljava/text/DecimalFormat;Lrx/subjects/PublishSubject;)V", "getAppClickedEvents", "()Lrx/subjects/PublishSubject;", "getApps", "()Ljava/util/List;", "setApps", "(Ljava/util/List;)V", "bundlePosition", HttpUrl.FRAGMENT_ENCODE_SET, "homeBundle", "Lcm/aptoide/pt/home/bundles/base/HomeBundle;", "getOneDecimalFormatter", "()Ljava/text/DecimalFormat;", "getItemCount", "onBindViewHolder", HttpUrl.FRAGMENT_ENCODE_SET, "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "updateBundle", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedAppcBundleAdapter extends RecyclerView.g<RecyclerView.c0> {
    private final rx.s.b<HomeEvent> appClickedEvents;
    private List<? extends Application> apps;
    private int bundlePosition;
    private HomeBundle homeBundle;
    private final DecimalFormat oneDecimalFormatter;

    public FeaturedAppcBundleAdapter(List<? extends Application> list, DecimalFormat decimalFormat, rx.s.b<HomeEvent> bVar) {
        m.f(list, DeepLinkIntentReceiver.DeepLinksTargets.APPS);
        m.f(decimalFormat, "oneDecimalFormatter");
        m.f(bVar, "appClickedEvents");
        this.apps = list;
        this.oneDecimalFormatter = decimalFormat;
        this.appClickedEvents = bVar;
        this.bundlePosition = -1;
    }

    public final rx.s.b<HomeEvent> getAppClickedEvents() {
        return this.appClickedEvents;
    }

    public final List<Application> getApps() {
        return this.apps;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.apps.size();
    }

    public final DecimalFormat getOneDecimalFormatter() {
        return this.oneDecimalFormatter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.c0 c0Var, int i2) {
        m.f(c0Var, "holder");
        ((AppViewHolder) c0Var).setApp(this.apps.get(i2), this.homeBundle, this.bundlePosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.c0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        m.f(viewGroup, "parent");
        return new AppInBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bonus_appc_home_item, viewGroup, false), this.appClickedEvents, this.oneDecimalFormatter);
    }

    public final void setApps(List<? extends Application> list) {
        m.f(list, "<set-?>");
        this.apps = list;
    }

    public final void update(List<? extends Application> apps) {
        m.f(apps, DeepLinkIntentReceiver.DeepLinksTargets.APPS);
        this.apps = apps;
        notifyDataSetChanged();
    }

    public final void updateBundle(HomeBundle homeBundle, int position) {
        m.f(homeBundle, "homeBundle");
        this.homeBundle = homeBundle;
        this.bundlePosition = position;
    }
}
