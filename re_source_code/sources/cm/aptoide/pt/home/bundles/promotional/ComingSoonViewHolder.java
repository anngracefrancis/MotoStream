package cm.aptoide.pt.home.bundles.promotional;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import cm.aptoide.aptoideviews.skeleton.Skeleton;
import cm.aptoide.aptoideviews.skeleton.SkeletonView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.home.bundles.base.AppBundleViewHolder;
import cm.aptoide.pt.home.bundles.base.AppComingSoonPromotionalBundle;
import cm.aptoide.pt.home.bundles.base.HomeBundle;
import cm.aptoide.pt.home.bundles.base.HomeEvent;
import cm.aptoide.pt.networking.image.ImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ComingSoonViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcm/aptoide/pt/home/bundles/promotional/ComingSoonViewHolder;", "Lcm/aptoide/pt/home/bundles/base/AppBundleViewHolder;", "view", "Landroid/view/View;", "uiEventsListener", "Lrx/subjects/PublishSubject;", "Lcm/aptoide/pt/home/bundles/base/HomeEvent;", "(Landroid/view/View;Lrx/subjects/PublishSubject;)V", "skeleton", "Lcm/aptoide/aptoideviews/skeleton/Skeleton;", "getUiEventsListener", "()Lrx/subjects/PublishSubject;", "getView", "()Landroid/view/View;", "fireAppClickEvent", HttpUrl.FRAGMENT_ENCODE_SET, "homeBundle", "Lcm/aptoide/pt/home/bundles/base/AppComingSoonPromotionalBundle;", "type", "Lcm/aptoide/pt/home/bundles/base/HomeEvent$Type;", "setBundle", "Lcm/aptoide/pt/home/bundles/base/HomeBundle;", "position", HttpUrl.FRAGMENT_ENCODE_SET, "toggleSkeleton", "showSkeleton", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComingSoonViewHolder extends AppBundleViewHolder {
    private Skeleton skeleton;
    private final rx.s.b<HomeEvent> uiEventsListener;
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComingSoonViewHolder(View view, rx.s.b<HomeEvent> bVar) {
        super(view);
        m.f(view, "view");
        m.f(bVar, "uiEventsListener");
        this.view = view;
        this.uiEventsListener = bVar;
    }

    private final void fireAppClickEvent(AppComingSoonPromotionalBundle homeBundle, HomeEvent.Type type) {
        this.uiEventsListener.onNext(new HomeEvent(homeBundle, 0, type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setBundle$lambda-2$lambda-0, reason: not valid java name */
    public static final void m171setBundle$lambda2$lambda0(ComingSoonViewHolder comingSoonViewHolder, AppComingSoonPromotionalBundle appComingSoonPromotionalBundle, View view) {
        m.f(comingSoonViewHolder, "this$0");
        m.f(appComingSoonPromotionalBundle, "$bundle");
        comingSoonViewHolder.fireAppClickEvent(appComingSoonPromotionalBundle, HomeEvent.Type.CANCEL_NOTIFY_ME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setBundle$lambda-2$lambda-1, reason: not valid java name */
    public static final void m172setBundle$lambda2$lambda1(ComingSoonViewHolder comingSoonViewHolder, AppComingSoonPromotionalBundle appComingSoonPromotionalBundle, View view) {
        m.f(comingSoonViewHolder, "this$0");
        m.f(appComingSoonPromotionalBundle, "$bundle");
        comingSoonViewHolder.fireAppClickEvent(appComingSoonPromotionalBundle, HomeEvent.Type.NOTIFY_ME);
    }

    private final void toggleSkeleton(boolean showSkeleton) {
        if (!showSkeleton) {
            Skeleton skeleton = this.skeleton;
            if (skeleton != null) {
                skeleton.showOriginal();
            }
            ((SkeletonView) this.itemView.findViewById(R.id.card_title_label_skeletonview)).setVisibility(4);
            ((SkeletonView) this.itemView.findViewById(R.id.app_name_skeletonview)).setVisibility(4);
            ((TextView) this.itemView.findViewById(R.id.app_name)).setVisibility(0);
            ((SkeletonView) this.itemView.findViewById(R.id.aptoide_icon_skeleton)).setVisibility(4);
            ((ImageView) this.itemView.findViewById(R.id.aptoide_icon)).setVisibility(0);
            ((SkeletonView) this.itemView.findViewById(R.id.text_skeleton_1)).setVisibility(4);
            ((SkeletonView) this.itemView.findViewById(R.id.text_skeleton_2)).setVisibility(4);
            ((TextView) this.itemView.findViewById(R.id.coming_soon_text)).setVisibility(0);
            ((SkeletonView) this.itemView.findViewById(R.id.action_button_skeleton)).setVisibility(4);
            ((Button) this.itemView.findViewById(R.id.action_button)).setVisibility(0);
            return;
        }
        Skeleton skeleton2 = this.skeleton;
        if (skeleton2 != null) {
            skeleton2.showSkeleton();
        }
        ((SkeletonView) this.itemView.findViewById(R.id.card_title_label_skeletonview)).setVisibility(0);
        ((CardView) this.itemView.findViewById(R.id.card_title_label)).setVisibility(4);
        ((SkeletonView) this.itemView.findViewById(R.id.app_name_skeletonview)).setVisibility(0);
        ((TextView) this.itemView.findViewById(R.id.app_name)).setVisibility(4);
        ((SkeletonView) this.itemView.findViewById(R.id.aptoide_icon_skeleton)).setVisibility(0);
        ((ImageView) this.itemView.findViewById(R.id.aptoide_icon)).setVisibility(4);
        ((SkeletonView) this.itemView.findViewById(R.id.text_skeleton_1)).setVisibility(0);
        ((SkeletonView) this.itemView.findViewById(R.id.text_skeleton_2)).setVisibility(0);
        ((TextView) this.itemView.findViewById(R.id.coming_soon_text)).setVisibility(4);
        ((SkeletonView) this.itemView.findViewById(R.id.action_button_skeleton)).setVisibility(0);
        ((Button) this.itemView.findViewById(R.id.action_button)).setVisibility(4);
    }

    public final rx.s.b<HomeEvent> getUiEventsListener() {
        return this.uiEventsListener;
    }

    public final View getView() {
        return this.view;
    }

    @Override // cm.aptoide.pt.home.bundles.base.AppBundleViewHolder
    public void setBundle(HomeBundle homeBundle, int position) {
        boolean z = homeBundle instanceof AppComingSoonPromotionalBundle;
        if (!z) {
            throw new IllegalStateException(ComingSoonViewHolder.class.getName() + " is getting non AppComingSoonPromotionalBundle instance!");
        }
        final AppComingSoonPromotionalBundle appComingSoonPromotionalBundle = z ? (AppComingSoonPromotionalBundle) homeBundle : null;
        if (appComingSoonPromotionalBundle != null) {
            AppComingSoonPromotionalBundle appComingSoonPromotionalBundle2 = (AppComingSoonPromotionalBundle) homeBundle;
            if (appComingSoonPromotionalBundle2.getContent() == null) {
                toggleSkeleton(true);
                return;
            }
            toggleSkeleton(false);
            ((TextView) this.itemView.findViewById(R.id.card_title_label_text)).setText(appComingSoonPromotionalBundle2.getTitle());
            ImageLoader.with(this.itemView.getContext()).load(appComingSoonPromotionalBundle2.getActionItem().getFeatureGraphic(), (ImageView) this.itemView.findViewById(R.id.app_background_image));
            ((TextView) this.itemView.findViewById(R.id.app_name)).setText(appComingSoonPromotionalBundle2.getActionItem().getTitle());
            if (appComingSoonPromotionalBundle.getIsRegisteredForNotification()) {
                View view = this.itemView;
                int i2 = R.id.action_button;
                ((Button) view.findViewById(i2)).setBackground(this.itemView.getContext().getResources().getDrawable(R.drawable.btn_ghost_theme_grey_fog_light));
                ((Button) this.itemView.findViewById(i2)).setTextColor(this.itemView.getContext().getResources().getColor(R.color.grey));
                ((TextView) this.itemView.findViewById(R.id.coming_soon_text)).setText(this.itemView.getContext().getString(R.string.promotional_new_active));
                ((Button) this.itemView.findViewById(i2)).setText(this.itemView.getContext().getString(R.string.cancel));
                ((Button) this.itemView.findViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.promotional.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ComingSoonViewHolder.m171setBundle$lambda2$lambda0(this.f5961f, appComingSoonPromotionalBundle, view2);
                    }
                });
                return;
            }
            View view2 = this.itemView;
            int i3 = R.id.action_button;
            ((Button) view2.findViewById(i3)).setBackground(this.itemView.getContext().getResources().getDrawable(R.drawable.btn_ghost_theme_normal));
            ((Button) this.itemView.findViewById(i3)).setTextColor(this.itemView.getContext().getResources().getColor(R.color.default_orange_gradient_end));
            ((TextView) this.itemView.findViewById(R.id.coming_soon_text)).setText(this.itemView.getContext().getString(R.string.promotional_soon_in_aptoide));
            ((Button) this.itemView.findViewById(i3)).setText(this.itemView.getContext().getString(R.string.promotional_notify_button));
            ((Button) this.itemView.findViewById(i3)).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.home.bundles.promotional.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    ComingSoonViewHolder.m172setBundle$lambda2$lambda1(this.f5963f, appComingSoonPromotionalBundle, view3);
                }
            });
        }
    }
}
