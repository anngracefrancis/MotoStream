package cm.aptoide.pt.home.bundles.ads;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.aptoideviews.skeleton.Skeleton;
import cm.aptoide.aptoideviews.skeleton.SkeletonUtils;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.ActionBundle;
import cm.aptoide.pt.home.bundles.base.ActionItem;
import cm.aptoide.pt.home.bundles.base.AppBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;

/* JADX INFO: loaded from: classes.dex */
public class WalletAdsOfferViewHolder extends AppBundleViewHolder {
    private final Button dismissButton;
    private final ImageView icon;
    private View infoLayout;
    private final Button installWalletButton;
    private final TextView message;
    private Skeleton skeleton;
    private final TextView title;
    private final rx.s.b<HomeEvent> uiEventsListener;

    public WalletAdsOfferViewHolder(View view, rx.s.b<HomeEvent> bVar) {
        super(view);
        this.uiEventsListener = bVar;
        this.installWalletButton = (Button) view.findViewById(R.id.action_button);
        this.dismissButton = (Button) view.findViewById(R.id.dismiss_button);
        this.icon = (ImageView) view.findViewById(R.id.icon);
        this.title = (TextView) view.findViewById(R.id.title);
        this.message = (TextView) view.findViewById(R.id.message);
        View viewFindViewById = view.findViewById(R.id.card_info_layout);
        this.infoLayout = viewFindViewById;
        this.skeleton = SkeletonUtils.applySkeleton(viewFindViewById, (ViewGroup) view.findViewById(R.id.root_layout), R.layout.info_action_item_card_skeleton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setBundle$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(HomeBundle homeBundle, View view) {
        this.uiEventsListener.onNext(new HomeEvent(homeBundle, getAdapterPosition(), HomeEvent.Type.INSTALL_WALLET));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setBundle$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(HomeBundle homeBundle, View view) {
        this.uiEventsListener.onNext(new HomeEvent(homeBundle, getAdapterPosition(), HomeEvent.Type.DISMISS_BUNDLE));
    }

    @Override // cm.aptoide.pt.home.bundles.base.AppBundleViewHolder
    public void setBundle(final HomeBundle homeBundle, int i2) {
        ActionItem actionItem = ((ActionBundle) homeBundle).getActionItem();
        if (actionItem == null) {
            this.skeleton.showSkeleton();
            return;
        }
        this.skeleton.showOriginal();
        ImageLoader.with(this.itemView.getContext()).load(actionItem.getIcon(), this.icon);
        this.installWalletButton.setText(R.string.wallet_promotion_install_button);
        this.dismissButton.setText(R.string.wallet_promotion_no_button);
        this.title.setText(actionItem.getTitle());
        this.message.setText(actionItem.getSubTitle());
        this.installWalletButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.ads.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5860f.a(homeBundle, view);
            }
        });
        this.dismissButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.ads.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5862f.b(homeBundle, view);
            }
        });
    }
}
