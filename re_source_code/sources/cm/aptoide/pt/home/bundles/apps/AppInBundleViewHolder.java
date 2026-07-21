package cm.aptoide.pt.home.bundles.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.AppSecondaryInfoViewHolder;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.app.AppViewHolder;
import cm.aptoide.pt.view.app.Application;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public class AppInBundleViewHolder extends AppViewHolder {
    private final rx.s.b<HomeEvent> appClicks;
    private AppSecondaryInfoViewHolder appInfoViewHolder;
    private final ImageView iconView;
    private final TextView nameTextView;

    public AppInBundleViewHolder(View view, rx.s.b<HomeEvent> bVar, DecimalFormat decimalFormat) {
        super(view);
        this.appInfoViewHolder = new AppSecondaryInfoViewHolder(view, decimalFormat);
        this.nameTextView = (TextView) view.findViewById(R.id.name);
        this.iconView = (ImageView) view.findViewById(R.id.icon);
        this.appClicks = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Application application, HomeBundle homeBundle, int i2, View view) {
        this.appClicks.onNext(new AppHomeEvent(application, getAdapterPosition(), homeBundle, i2, HomeEvent.Type.APP));
    }

    @Override // cm.aptoide.pt.view.app.AppViewHolder
    public void setApp(final Application application, final HomeBundle homeBundle, final int i2) {
        this.nameTextView.setText(application.getName());
        ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(application.getIcon(), 8, this.iconView, R.attr.placeholder_square);
        this.appInfoViewHolder.setInfo(application.hasAppcBilling(), application.getRating(), true, false);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.apps.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5876f.a(application, homeBundle, i2, view);
            }
        });
    }
}
