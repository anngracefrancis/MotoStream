package cm.aptoide.pt.home.bundles.ads;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.AppBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class AdsBundlesViewHolderFactory {
    private static final int ADS = 2131492898;
    private final rx.s.b<AdHomeEvent> adClickedEvents;
    private final String marketName;
    private final DecimalFormat oneDecimalFormatter;
    private final rx.s.b<HomeEvent> uiEventsListener;

    public AdsBundlesViewHolderFactory(rx.s.b<HomeEvent> bVar, rx.s.b<AdHomeEvent> bVar2, DecimalFormat decimalFormat, String str) {
        this.uiEventsListener = bVar;
        this.adClickedEvents = bVar2;
        this.oneDecimalFormatter = decimalFormat;
        this.marketName = str;
    }

    public AppBundleViewHolder createViewHolder(ViewGroup viewGroup) {
        return new AdsBundleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ads_bundle_item, viewGroup, false), this.uiEventsListener, this.oneDecimalFormatter, this.adClickedEvents, this.marketName);
    }
}
