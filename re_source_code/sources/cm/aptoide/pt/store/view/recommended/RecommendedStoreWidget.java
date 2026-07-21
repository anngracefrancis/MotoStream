package cm.aptoide.pt.store.view.recommended;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.design.ShowMessage;
import cm.aptoide.pt.view.recycler.widget.Widget;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RecommendedStoreWidget extends Widget<RecommendedStoreDisplayable> {
    private AppCompatButton followButton;
    private TextView followingUsers;
    private TextView numberStoreApps;
    private StoreAnalytics storeAnalytics;
    private ImageView storeIcon;
    private TextView storeName;

    public RecommendedStoreWidget(View view) {
        super(view);
        this.storeAnalytics = new StoreAnalytics(((AptoideApplication) getContext().getApplicationContext()).getAnalyticsManager(), ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(RecommendedStoreDisplayable recommendedStoreDisplayable, Store store, Void r4) {
        recommendedStoreDisplayable.openStoreFragment(getFragmentNavigator());
        if (recommendedStoreDisplayable.getOrigin().isEmpty()) {
            this.storeAnalytics.sendStoreOpenEvent("Recommended Stores", store.getName(), false);
            this.storeAnalytics.sendStoreTabInteractEvent("Open a Recommended Store", false);
        } else {
            this.storeAnalytics.sendStoreOpenEvent(recommendedStoreDisplayable.getOrigin(), store.getName(), false);
            this.storeAnalytics.sendStoreTabInteractEvent("More Recommended Stores", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setButtonText$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(RecommendedStoreDisplayable recommendedStoreDisplayable, Boolean bool) {
        this.followButton.setText(AptoideUtils.StringU.getFormattedString(bool.booleanValue() ? R.string.followed : R.string.follow, getContext().getResources(), recommendedStoreDisplayable.getPojo().getName()));
        this.followButton.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setFollowButtonListener$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean c(RecommendedStoreDisplayable recommendedStoreDisplayable, Boolean bool) {
        if (bool.booleanValue()) {
            recommendedStoreDisplayable.unsubscribeStore(getContext().getApplicationContext());
        } else {
            recommendedStoreDisplayable.subscribeStore();
        }
        return Boolean.valueOf(!bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setFollowButtonListener$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d(final RecommendedStoreDisplayable recommendedStoreDisplayable, Void r5) {
        this.followButton.setEnabled(false);
        this.storeAnalytics.sendStoreTabInteractEvent("Follow a Recommended Store", recommendedStoreDisplayable.getPojo().getStats().getApps(), recommendedStoreDisplayable.getPojo().getStats().getSubscribers());
        return recommendedStoreDisplayable.isFollowing().E().j0(Schedulers.computation()).X(new rx.m.e() { // from class: cm.aptoide.pt.store.view.recommended.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7711f.c(recommendedStoreDisplayable, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setFollowButtonListener$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(RecommendedStoreDisplayable recommendedStoreDisplayable, Boolean bool) {
        this.followButton.setEnabled(true);
        ShowMessage.asSnack(this.itemView, AptoideUtils.StringU.getFormattedString(bool.booleanValue() ? R.string.store_followed : R.string.unfollowing_store_message, getContext().getResources(), recommendedStoreDisplayable.getPojo().getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setFollowButtonListener$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(Throwable th) {
        CrashReport.getInstance().log(th);
        ShowMessage.asSnack(this.itemView, R.string.error_occured);
    }

    private void setButtonText(final RecommendedStoreDisplayable recommendedStoreDisplayable) {
        this.followButton.setVisibility(8);
        this.compositeSubscription.a(recommendedStoreDisplayable.isFollowing().j0(rx.l.c.a.b()).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.c
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7705f.b(recommendedStoreDisplayable, (Boolean) obj);
            }
        }));
    }

    private void setFollowButtonListener(final RecommendedStoreDisplayable recommendedStoreDisplayable) {
        this.compositeSubscription.a(e.g.a.c.a.a(this.followButton).G(new rx.m.e() { // from class: cm.aptoide.pt.store.view.recommended.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f7700f.d(recommendedStoreDisplayable, (Void) obj);
            }
        }).j0(rx.l.c.a.b()).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.f
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7709f.e(recommendedStoreDisplayable, (Boolean) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.e
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7708f.f((Throwable) obj);
            }
        }));
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.storeName = (TextView) view.findViewById(R.id.recommended_store_name);
        this.followingUsers = (TextView) view.findViewById(R.id.recommended_store_users);
        this.numberStoreApps = (TextView) view.findViewById(R.id.recommended_store_apps);
        this.storeIcon = (ImageView) view.findViewById(R.id.store_avatar_row);
        this.followButton = (AppCompatButton) view.findViewById(R.id.recommended_store_action);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final RecommendedStoreDisplayable recommendedStoreDisplayable, int i2) {
        final Store pojo = recommendedStoreDisplayable.getPojo();
        this.storeName.setText(pojo.getName());
        this.followingUsers.setText(String.valueOf(pojo.getStats().getSubscribers()));
        this.numberStoreApps.setText(String.valueOf(pojo.getStats().getApps()));
        ImageLoader.with(getContext()).loadUsingCircleTransform(pojo.getAvatar(), this.storeIcon);
        setFollowButtonListener(recommendedStoreDisplayable);
        setButtonText(recommendedStoreDisplayable);
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7702f.a(recommendedStoreDisplayable, pojo, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.recommended.d
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
