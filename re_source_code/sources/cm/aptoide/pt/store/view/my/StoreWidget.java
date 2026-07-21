package cm.aptoide.pt.store.view.my;

import android.text.ParcelableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.store.StoreAnalytics;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowersFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.recycler.widget.Widget;
import cm.aptoide.pt.view.spannable.SpannableFactory;

/* JADX INFO: loaded from: classes.dex */
public class StoreWidget extends Widget<StoreDisplayable> {
    private Button exploreButton;
    private TextView firstStat;
    private TextView secondStat;
    private StoreAnalytics storeAnalytics;
    private ImageView storeIcon;
    private TextView storeName;
    private TextView suggestionMessage;

    public StoreWidget(View view) {
        super(view);
        this.storeAnalytics = new StoreAnalytics(((AptoideApplication) getContext().getApplicationContext()).getAnalyticsManager(), ((AptoideApplication) getContext().getApplicationContext()).getNavigationTracker());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(Store store, String str, Void r5) {
        getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newStoreFragment(store.getName(), str), true);
        this.storeAnalytics.sendStoreTabInteractEvent("View Store", false);
        this.storeAnalytics.sendStoreOpenEvent("View Own Store", store.getName(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, StoreDisplayable storeDisplayable, Void r8) {
        this.storeAnalytics.sendFollowingStoresInteractEvent();
        getFragmentNavigator().navigateTo(TimeLineFollowingFragment.newInstanceUsingUser(str, AptoideUtils.StringU.getFormattedString(R.string.social_timeline_following_fragment_title, getContext().getResources(), Long.valueOf(storeDisplayable.getFirstStatsNumber())), storeDisplayable.getStoreContext()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(String str, StoreDisplayable storeDisplayable, Void r8) {
        this.storeAnalytics.sendFollowersStoresInteractEvent();
        getFragmentNavigator().navigateTo(TimeLineFollowersFragment.newInstanceUsingUser(str, AptoideUtils.StringU.getFormattedString(R.string.social_timeline_followers_fragment_title, getContext().getResources(), Long.valueOf(storeDisplayable.getSecondStatsNumber())), storeDisplayable.getStoreContext()), true);
    }

    private void showStats(StoreDisplayable storeDisplayable) {
        SpannableFactory spannableFactory = new SpannableFactory();
        ParcelableSpan[] parcelableSpanArr = {new StyleSpan(1), new ForegroundColorSpan(storeDisplayable.getTextColor())};
        this.firstStat.setText(spannableFactory.createMultiSpan(String.format(getContext().getString(storeDisplayable.getFirstStatsLabel()), String.valueOf(storeDisplayable.getFirstStatsNumber())), parcelableSpanArr, String.valueOf(storeDisplayable.getFirstStatsNumber())));
        this.secondStat.setText(spannableFactory.createMultiSpan(String.format(getContext().getString(storeDisplayable.getSecondStatsLabel()), String.valueOf(storeDisplayable.getSecondStatsNumber())), parcelableSpanArr, String.valueOf(storeDisplayable.getSecondStatsNumber())));
    }

    private void showStoreDescription(StoreDisplayable storeDisplayable, androidx.fragment.app.d dVar) {
        String suggestionMessage = storeDisplayable.getSuggestionMessage(dVar);
        if (suggestionMessage.isEmpty()) {
            this.suggestionMessage.setVisibility(8);
        } else {
            this.suggestionMessage.setText(suggestionMessage);
            this.suggestionMessage.setVisibility(0);
        }
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.storeIcon = (ImageView) view.findViewById(R.id.store_icon);
        this.storeName = (TextView) view.findViewById(R.id.store_name);
        this.suggestionMessage = (TextView) view.findViewById(R.id.create_store_text);
        this.firstStat = (TextView) view.findViewById(R.id.first_stat);
        this.secondStat = (TextView) view.findViewById(R.id.second_stat);
        this.exploreButton = (Button) view.findViewById(R.id.explore_button);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final StoreDisplayable storeDisplayable, int i2) {
        androidx.fragment.app.d context = getContext();
        final Store store = storeDisplayable.getStore();
        showStoreDescription(storeDisplayable, context);
        this.exploreButton.setText(storeDisplayable.getExploreButtonText());
        final String theme = store.getAppearance().getTheme();
        ImageLoader.with(context).loadWithShadowCircleTransform(store.getAvatar(), this.storeIcon);
        this.storeName.setText(store.getName());
        this.compositeSubscription.a(e.g.a.c.a.a(this.exploreButton).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.d0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7646f.a(store, theme, (Void) obj);
            }
        }));
        showStats(storeDisplayable);
        if (storeDisplayable.isStatsClickable()) {
            this.compositeSubscription.a(e.g.a.c.a.a(this.firstStat).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.c0
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f7642f.b(theme, storeDisplayable, (Void) obj);
                }
            }));
            this.compositeSubscription.a(e.g.a.c.a.a(this.secondStat).G0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.my.e0
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f7650f.c(theme, storeDisplayable, (Void) obj);
                }
            }));
        }
    }
}
