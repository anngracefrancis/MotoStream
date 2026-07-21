package cm.aptoide.pt.home.bundles.apps;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.AppHomeEvent;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.view.app.AppViewHolder;
import cm.aptoide.pt.view.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class RewardAppInBundleViewHolder extends AppViewHolder {
    private final rx.s.b<HomeEvent> appClicks;
    private final ImageView appIcon;
    private final TextView appName;
    private final TextView appReward;

    public RewardAppInBundleViewHolder(View view, rx.s.b<HomeEvent> bVar) {
        super(view);
        this.appIcon = (ImageView) view.findViewById(R.id.icon);
        this.appName = (TextView) view.findViewById(R.id.name);
        this.appReward = (TextView) view.findViewById(R.id.appc_text);
        this.appClicks = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setApp$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Application application, HomeBundle homeBundle, int i2, View view) {
        this.appClicks.onNext(new AppHomeEvent(application, getAdapterPosition(), homeBundle, i2, HomeEvent.Type.REWARD_APP));
    }

    @Override // cm.aptoide.pt.view.app.AppViewHolder
    public void setApp(final Application application, final HomeBundle homeBundle, final int i2) {
        ImageLoader.with(this.itemView.getContext()).loadWithRoundCorners(application.getIcon(), 8, this.appIcon, R.attr.placeholder_square);
        this.appName.setText(application.getName());
        this.appReward.setText(this.itemView.getResources().getString(R.string.appc_card_short));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.apps.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5882f.a(application, homeBundle, i2, view);
            }
        });
    }
}
