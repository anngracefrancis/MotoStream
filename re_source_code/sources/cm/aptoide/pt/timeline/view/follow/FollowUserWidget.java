package cm.aptoide.pt.timeline.view.follow;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.networking.image.ImageLoader;
import cm.aptoide.pt.timeline.view.displayable.FollowUserDisplayable;
import cm.aptoide.pt.view.recycler.widget.Widget;

/* JADX INFO: loaded from: classes.dex */
public class FollowUserWidget extends Widget<FollowUserDisplayable> {
    private LinearLayout followNumbers;
    private TextView followersNumber;
    private TextView followingNumber;
    private ImageView mainIcon;
    private ImageView secondaryIcon;
    private View separatorView;
    private TextView storeNameTv;
    private TextView userNameTv;

    public FollowUserWidget(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$bindView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(FollowUserDisplayable followUserDisplayable, Void r2) {
        followUserDisplayable.viewClicked(getFragmentNavigator());
    }

    private void setupStoreNameTv(String str) {
        this.storeNameTv.setText(str);
        this.storeNameTv.setVisibility(0);
        Drawable drawable = Build.VERSION.SDK_INT >= 21 ? getContext().getResources().getDrawable(R.drawable.ic_store, null) : getContext().getResources().getDrawable(R.drawable.ic_store);
        drawable.setBounds(0, 0, 30, 30);
        drawable.mutate();
        this.storeNameTv.setCompoundDrawablePadding(5);
        this.storeNameTv.setCompoundDrawables(drawable, null, null, null);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.userNameTv = (TextView) view.findViewById(R.id.user_name);
        this.storeNameTv = (TextView) view.findViewById(R.id.store_name);
        this.followingNumber = (TextView) view.findViewById(R.id.following_number);
        this.followersNumber = (TextView) view.findViewById(R.id.followers_number);
        this.mainIcon = (ImageView) view.findViewById(R.id.main_icon);
        this.secondaryIcon = (ImageView) view.findViewById(R.id.secondary_icon);
        this.followNumbers = (LinearLayout) view.findViewById(R.id.followers_following_numbers);
        this.separatorView = view.findViewById(R.id.separator_vertical);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(final FollowUserDisplayable followUserDisplayable, int i2) {
        this.followNumbers.setVisibility(0);
        this.separatorView.setVisibility(0);
        this.followingNumber.setText(followUserDisplayable.getFollowing());
        this.followersNumber.setText(followUserDisplayable.getFollowers());
        androidx.fragment.app.d context = getContext();
        if (followUserDisplayable.hasStoreAndUser()) {
            ImageLoader.with(context).loadUsingCircleTransform(followUserDisplayable.getStoreAvatar(), this.mainIcon);
            ImageLoader.with(context).loadUsingCircleTransform(followUserDisplayable.getUserAvatar(), this.secondaryIcon);
            this.mainIcon.setVisibility(0);
            this.secondaryIcon.setVisibility(0);
        } else if (followUserDisplayable.hasUser()) {
            ImageLoader.with(context).loadUsingCircleTransform(followUserDisplayable.getUserAvatar(), this.mainIcon);
            this.secondaryIcon.setVisibility(8);
        } else if (followUserDisplayable.hasStore()) {
            ImageLoader.with(context).loadUsingCircleTransform(followUserDisplayable.getStoreAvatar(), this.mainIcon);
            this.secondaryIcon.setVisibility(8);
        } else {
            this.mainIcon.setVisibility(8);
            this.secondaryIcon.setVisibility(8);
        }
        if (followUserDisplayable.hasUser()) {
            this.userNameTv.setText(followUserDisplayable.getUserName());
            this.userNameTv.setVisibility(0);
        } else {
            this.userNameTv.setVisibility(8);
        }
        if (followUserDisplayable.hasStore()) {
            setupStoreNameTv(followUserDisplayable.storeName());
        } else {
            this.storeNameTv.setVisibility(8);
        }
        this.compositeSubscription.a(e.g.a.c.a.a(this.itemView).H0(new rx.m.b() { // from class: cm.aptoide.pt.timeline.view.follow.b
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f7789f.a(followUserDisplayable, (Void) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.timeline.view.follow.c
            @Override // rx.m.b
            public final void call(Object obj) {
                CrashReport.getInstance().log((Throwable) obj);
            }
        }));
    }
}
