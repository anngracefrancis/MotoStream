package cm.aptoide.pt.store.view;

import android.content.res.Resources;
import android.text.ParcelableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.R;
import cm.aptoide.pt.account.view.store.ManageStoreFragment;
import cm.aptoide.pt.account.view.store.ManageStoreViewModel;
import cm.aptoide.pt.dataprovider.model.v7.store.GetStoreMeta;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.themes.StoreTheme;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowersFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowingFragment;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.app.ListStoreAppsFragment;
import cm.aptoide.pt.view.recycler.widget.Widget;
import cm.aptoide.pt.view.spannable.SpannableFactory;
import com.google.android.material.snackbar.Snackbar;

/* JADX INFO: loaded from: classes.dex */
public class GridStoreMetaWidget extends Widget<GridStoreMetaDisplayable> {
    private AptoideAccountManager accountManager;
    private TextView appsCountTv;
    private BadgeDialogFactory badgeDialogFactory;
    private ImageView badgeIcon;
    private View buttonsLayout;
    private TextView description;
    private View editStoreButton;
    private Button followStoreButton;
    private TextView followersCountTv;
    private TextView followingCountTv;
    private ImageView mainIcon;
    private TextView mainName;
    private ImageView secondaryIcon;
    private TextView secondaryName;
    private SpannableFactory spannableFactory;
    private StoreUtilsProxy storeUtilsProxy;

    /* JADX INFO: renamed from: cm.aptoide.pt.store.view.GridStoreMetaWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge;

        static {
            int[] iArr = new int[HomeMeta.Badge.values().length];
            $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge = iArr;
            try {
                iArr[HomeMeta.Badge.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[HomeMeta.Badge.TIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[HomeMeta.Badge.BRONZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[HomeMeta.Badge.SILVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[HomeMeta.Badge.GOLD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[HomeMeta.Badge.PLATINUM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class HomeMeta {
        private final long appsCount;
        private final Badge badge;
        private final String description;
        private final long followersCount;
        private final long followingCount;
        private final boolean followingStore;
        private final String mainIcon;
        private final String mainName;
        private final boolean owner;
        private final String secondaryIcon;
        private final String secondaryName;
        private final boolean showApps;
        private final boolean showButton;
        private final long storeId;
        private final StoreTheme storeTheme;
        private final int themeColor;

        enum Badge {
            NONE,
            TIN,
            BRONZE,
            SILVER,
            GOLD,
            PLATINUM
        }

        public HomeMeta(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3, long j2, long j3, long j4, String str5, StoreTheme storeTheme, int i2, long j5, boolean z4, Badge badge) {
            this.mainIcon = str;
            this.secondaryIcon = str2;
            this.mainName = str3;
            this.secondaryName = str4;
            this.owner = z;
            this.showButton = z2;
            this.followingStore = z3;
            this.appsCount = j2;
            this.followersCount = j3;
            this.followingCount = j4;
            this.description = str5;
            this.storeTheme = storeTheme;
            this.themeColor = i2;
            this.storeId = j5;
            this.showApps = z4;
            this.badge = badge;
        }

        public long getAppsCount() {
            return this.appsCount;
        }

        public Badge getBadge() {
            return this.badge;
        }

        public String getDescription() {
            return this.description;
        }

        public long getFollowersCount() {
            return this.followersCount;
        }

        public long getFollowingCount() {
            return this.followingCount;
        }

        public String getMainIcon() {
            return this.mainIcon;
        }

        public String getMainName() {
            return this.mainName;
        }

        public String getSecondaryIcon() {
            return this.secondaryIcon;
        }

        public String getSecondaryName() {
            return this.secondaryName;
        }

        public long getStoreId() {
            return this.storeId;
        }

        public StoreTheme getStoreTheme() {
            return this.storeTheme;
        }

        public int getThemeColor() {
            return this.themeColor;
        }

        public boolean isFollowingStore() {
            return this.followingStore;
        }

        public boolean isOwner() {
            return this.owner;
        }

        public boolean isShowApps() {
            return this.showApps;
        }

        public boolean isShowButton() {
            return this.showButton;
        }
    }

    public GridStoreMetaWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(GridStoreMetaDisplayable gridStoreMetaDisplayable, Resources resources, FragmentNavigator fragmentNavigator, View view) {
        navigateToFollowersScreen(gridStoreMetaDisplayable, resources, fragmentNavigator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(GridStoreMetaDisplayable gridStoreMetaDisplayable, FragmentNavigator fragmentNavigator, Resources resources, View view) {
        navigateToFollowingScreen(gridStoreMetaDisplayable, fragmentNavigator, resources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(GridStoreMetaDisplayable gridStoreMetaDisplayable, HomeMeta homeMeta) {
        ParcelableSpan[] parcelableSpanArr = {new StyleSpan(1), new ForegroundColorSpan(homeMeta.getThemeColor())};
        showMainIcon(homeMeta.getMainIcon());
        showSecondaryIcon(homeMeta.getSecondaryIcon());
        showMainName(homeMeta.getMainName());
        showSecondaryName(homeMeta.getSecondaryName());
        setupActionButton(homeMeta.isShowButton(), homeMeta.isOwner(), homeMeta.getStoreId(), homeMeta.getStoreTheme(), homeMeta.getMainName(), homeMeta.getDescription(), homeMeta.getMainIcon(), homeMeta.isFollowingStore(), gridStoreMetaDisplayable.getRequestCode(), gridStoreMetaDisplayable.getRaisedButtonBackground());
        showAppsCount(homeMeta.getAppsCount(), parcelableSpanArr, homeMeta.isShowApps(), homeMeta.getStoreId());
        showFollowersCount(homeMeta.getFollowersCount(), parcelableSpanArr);
        showFollowingCount(homeMeta.getFollowingCount(), parcelableSpanArr);
        showDescription(homeMeta.getDescription());
        showBadge(homeMeta.getBadge(), homeMeta.isOwner());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupEditButton$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(long j2, StoreTheme storeTheme, String str, String str2, String str3, int i2, View view) {
        navigateToEditStore(j2, storeTheme, str, str2, str3, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupFollowButton$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e() {
        this.followStoreButton.setText(R.string.unfollow);
        this.followStoreButton.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupFollowButton$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(GetStoreMeta getStoreMeta) {
        if (!getStoreMeta.isOk()) {
            showFollowStoreError();
        } else {
            this.followStoreButton.setText(R.string.unfollow);
            this.followStoreButton.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupFollowButton$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(Throwable th) {
        showFollowStoreError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupFollowButton$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(String str, View view) {
        this.storeUtilsProxy.subscribeStoreObservable(str).j0(rx.l.c.a.b()).y(new rx.m.a() { // from class: cm.aptoide.pt.store.view.v0
            @Override // rx.m.a
            public final void call() {
                this.f7756f.e();
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.store.view.p0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7684f.f((GetStoreMeta) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.store.view.w0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7763f.g((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setupUnfollowButton$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i(String str, View view) {
        this.storeUtilsProxy.unSubscribeStore(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showAppsCount$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(long j2, View view) {
        navigateToAppsListScreen(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$showBadge$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k(HomeMeta.Badge badge, boolean z, View view) {
        this.badgeDialogFactory.create(badge, z).show();
    }

    private void navigateToAppsListScreen(long j2) {
        getFragmentNavigator().navigateTo(ListStoreAppsFragment.newInstance(j2), true);
    }

    private void navigateToEditStore(long j2, StoreTheme storeTheme, String str, String str2, String str3, int i2) {
        getFragmentNavigator().navigateForResult(ManageStoreFragment.newInstance(new ManageStoreViewModel(j2, storeTheme, str, str2, str3), false), i2, true);
    }

    private void navigateToFollowersScreen(GridStoreMetaDisplayable gridStoreMetaDisplayable, Resources resources, FragmentNavigator fragmentNavigator) {
        String formattedString = AptoideUtils.StringU.getFormattedString(R.string.social_timeline_followers_fragment_title, resources, Long.valueOf(gridStoreMetaDisplayable.getFollowersCount()));
        if (gridStoreMetaDisplayable.hasUser()) {
            fragmentNavigator.navigateTo(TimeLineFollowersFragment.newInstanceUsingUser(Long.valueOf(gridStoreMetaDisplayable.getUserId()), gridStoreMetaDisplayable.getStoreThemeName(), formattedString, StoreContext.meta), true);
        } else {
            fragmentNavigator.navigateTo(TimeLineFollowersFragment.newInstanceUsingStore(Long.valueOf(gridStoreMetaDisplayable.getStoreId()), gridStoreMetaDisplayable.getStoreThemeName(), formattedString, StoreContext.meta), true);
        }
    }

    private void navigateToFollowingScreen(GridStoreMetaDisplayable gridStoreMetaDisplayable, FragmentNavigator fragmentNavigator, Resources resources) {
        String formattedString = AptoideUtils.StringU.getFormattedString(R.string.social_timeline_following_fragment_title, resources, Long.valueOf(gridStoreMetaDisplayable.getFollowingsCount()));
        if (gridStoreMetaDisplayable.hasStore()) {
            fragmentNavigator.navigateTo(TimeLineFollowingFragment.newInstanceUsingStoreId(Long.valueOf(gridStoreMetaDisplayable.getStoreId()), gridStoreMetaDisplayable.getStoreThemeName(), formattedString, StoreContext.meta), true);
        } else {
            fragmentNavigator.navigateTo(TimeLineFollowingFragment.newInstanceUsingUserId(Long.valueOf(gridStoreMetaDisplayable.getUserId()), gridStoreMetaDisplayable.getStoreThemeName(), formattedString, StoreContext.meta), true);
        }
    }

    private void setupActionButton(boolean z, boolean z2, long j2, StoreTheme storeTheme, String str, String str2, String str3, boolean z3, int i2, int i3) {
        if (!z) {
            this.buttonsLayout.setVisibility(8);
            return;
        }
        this.buttonsLayout.setVisibility(0);
        if (z2) {
            setupEditButton(j2, storeTheme, str, str2, str3, i2);
        } else {
            setupFollowButton(str, z3, i3);
        }
    }

    private void setupEditButton(final long j2, final StoreTheme storeTheme, final String str, final String str2, final String str3, final int i2) {
        this.editStoreButton.setVisibility(0);
        this.followStoreButton.setVisibility(8);
        this.editStoreButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7730f.d(j2, storeTheme, str, str2, str3, i2, view);
            }
        });
    }

    private void setupFollowButton(String str, boolean z, int i2) {
        this.editStoreButton.setVisibility(8);
        this.followStoreButton.setVisibility(0);
        this.followStoreButton.setBackgroundResource(i2);
        if (z) {
            setupUnfollowButton(str);
        } else {
            setupFollowButton(str);
        }
    }

    private void setupUnfollowButton(final String str) {
        this.followStoreButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7674f.i(str, view);
            }
        });
        this.followStoreButton.setText(R.string.unfollow);
    }

    private void showAppsCount(long j2, ParcelableSpan[] parcelableSpanArr, boolean z, final long j3) {
        if (!z) {
            this.appsCountTv.setVisibility(8);
            return;
        }
        this.appsCountTv.setVisibility(0);
        String strWithSuffix = AptoideUtils.StringU.withSuffix(j2);
        this.appsCountTv.setText(this.spannableFactory.createMultiSpan(String.format(getContext().getString(R.string.storehometab_short_apps), strWithSuffix), parcelableSpanArr, strWithSuffix));
        this.appsCountTv.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7722f.j(j3, view);
            }
        });
    }

    private void showBadge(final HomeMeta.Badge badge, final boolean z) {
        switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$store$view$GridStoreMetaWidget$HomeMeta$Badge[badge.ordinal()]) {
            case 1:
                this.badgeIcon.setVisibility(8);
                break;
            case 2:
                this.badgeIcon.setImageResource(R.drawable.tin_medal_gradient);
                this.badgeIcon.setVisibility(0);
                break;
            case 3:
                this.badgeIcon.setImageResource(R.drawable.bronze_medal_gradient);
                this.badgeIcon.setVisibility(0);
                break;
            case 4:
                this.badgeIcon.setImageResource(R.drawable.silver_medal_gradient);
                this.badgeIcon.setVisibility(0);
                break;
            case 5:
                this.badgeIcon.setImageResource(R.drawable.gold_medal_gradient);
                this.badgeIcon.setVisibility(0);
                break;
            case 6:
                this.badgeIcon.setImageResource(R.drawable.platinum_medal_gradient);
                this.badgeIcon.setVisibility(0);
                break;
        }
        this.badgeIcon.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7679f.k(badge, z, view);
            }
        });
    }

    private void showDescription(String str) {
        if (str == null || str.isEmpty()) {
            this.description.setVisibility(8);
        } else {
            this.description.setText(str);
            this.description.setVisibility(0);
        }
    }

    private void showFollowStoreError() {
        this.followStoreButton.setText(R.string.follow);
        this.followStoreButton.setEnabled(true);
        Snackbar.Z(this.itemView, R.string.storetab_short_follow_error, 0).P();
    }

    private void showFollowersCount(long j2, ParcelableSpan[] parcelableSpanArr) {
        String strWithSuffix = AptoideUtils.StringU.withSuffix(j2);
        this.followersCountTv.setText(this.spannableFactory.createMultiSpan(String.format(getContext().getString(R.string.storehometab_short_subscribers), strWithSuffix), parcelableSpanArr, strWithSuffix));
    }

    private void showFollowingCount(long j2, ParcelableSpan[] parcelableSpanArr) {
        String strWithSuffix = AptoideUtils.StringU.withSuffix(j2);
        this.followingCountTv.setText(this.spannableFactory.createMultiSpan(String.format(getContext().getString(R.string.storehometab_short_following), strWithSuffix), parcelableSpanArr, strWithSuffix));
    }

    private void showMainIcon(String str) {
        ImageLoader.with(getContext()).loadWithShadowCircleTransform(str, this.mainIcon);
    }

    private void showMainName(String str) {
        if (str != null) {
            this.mainName.setText(str);
        }
    }

    private void showSecondaryIcon(String str) {
        if (str == null) {
            this.secondaryIcon.setVisibility(8);
        } else {
            ImageLoader.with(getContext()).loadWithShadowCircleTransform(str, this.secondaryIcon);
            this.secondaryIcon.setVisibility(0);
        }
    }

    private void showSecondaryName(String str) {
        TextView textView = this.secondaryName;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.mainIcon = (ImageView) view.findViewById(R.id.main_icon);
        this.secondaryIcon = (ImageView) view.findViewById(R.id.secondary_icon);
        this.mainName = (TextView) view.findViewById(R.id.main_name);
        this.secondaryName = (TextView) view.findViewById(R.id.secondary_name);
        this.description = (TextView) view.findViewById(R.id.description);
        this.followStoreButton = (Button) view.findViewById(R.id.follow_store_button);
        this.editStoreButton = view.findViewById(R.id.edit_store_button);
        this.badgeIcon = (ImageView) view.findViewById(R.id.medal_icon);
        this.appsCountTv = (TextView) view.findViewById(R.id.apps_text_view);
        this.followingCountTv = (TextView) view.findViewById(R.id.following_text_view);
        this.buttonsLayout = view.findViewById(R.id.action_button_layout);
        this.followersCountTv = (TextView) view.findViewById(R.id.followers_text_view);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final GridStoreMetaDisplayable gridStoreMetaDisplayable, int i2) {
        this.badgeDialogFactory = gridStoreMetaDisplayable.getBadgeDialogFactory();
        this.accountManager = gridStoreMetaDisplayable.getAptoideAccountManager();
        this.storeUtilsProxy = gridStoreMetaDisplayable.getStoreUtilsProxy();
        this.spannableFactory = new SpannableFactory();
        final FragmentNavigator fragmentNavigator = getFragmentNavigator();
        final Resources resources = getContext().getResources();
        this.followersCountTv.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7746f.a(gridStoreMetaDisplayable, resources, fragmentNavigator, view);
            }
        });
        this.followingCountTv.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7695f.b(gridStoreMetaDisplayable, fragmentNavigator, resources, view);
            }
        });
        this.compositeSubscription.a(gridStoreMetaDisplayable.getHomeMeta(this.accountManager).j0(rx.l.c.a.b()).x(new rx.m.b() { // from class: cm.aptoide.pt.store.view.q0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7687f.c(gridStoreMetaDisplayable, (GridStoreMetaWidget.HomeMeta) obj);
            }
        }).D0());
    }

    private void setupFollowButton(final String str) {
        this.followStoreButton.setText(R.string.follow);
        this.followStoreButton.setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.pt.store.view.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7634f.h(str, view);
            }
        });
    }
}
