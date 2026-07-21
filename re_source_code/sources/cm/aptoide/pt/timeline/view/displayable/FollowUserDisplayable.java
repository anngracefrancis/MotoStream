package cm.aptoide.pt.timeline.view.displayable;

import android.text.TextUtils;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.GetFollowers;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.store.view.StoreFragment;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;

/* JADX INFO: loaded from: classes.dex */
public class FollowUserDisplayable extends DisplayablePojo<GetFollowers.TimelineUser> {
    private String theme;

    public FollowUserDisplayable() {
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    public String getFollowers() {
        return String.valueOf(getPojo().getStats() != null ? getPojo().getStats().getFollowers() : 0L);
    }

    public String getFollowing() {
        return String.valueOf(getPojo().getStats() != null ? getPojo().getStats().getFollowing() : 0L);
    }

    public String getStoreAvatar() {
        return getPojo().getStore().getAvatar();
    }

    public String getStoreName() {
        if (getPojo().getStore() == null) {
            return null;
        }
        return getPojo().getStore().getName();
    }

    public String getUserAvatar() {
        return getPojo().getAvatar();
    }

    public String getUserName() {
        return getPojo().getName();
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.timeline_follow_user;
    }

    public boolean hasStore() {
        return (getPojo().getStore() == null || (TextUtils.isEmpty(getPojo().getStore().getName()) && TextUtils.isEmpty(getPojo().getStore().getAvatar()))) ? false : true;
    }

    public boolean hasStoreAndUser() {
        return hasStore() && hasUser();
    }

    public boolean hasUser() {
        return (TextUtils.isEmpty(getPojo().getName()) && TextUtils.isEmpty(getPojo().getAvatar())) ? false : true;
    }

    public String storeName() {
        return getPojo().getStore().getName();
    }

    public void viewClicked(FragmentNavigator fragmentNavigator) {
        Store store = getPojo().getStore();
        if (store != null) {
            fragmentNavigator.navigateTo(AptoideApplication.getFragmentProvider().newStoreFragment(store.getName(), this.theme, StoreFragment.OpenType.GetHome), true);
        } else {
            fragmentNavigator.navigateTo(AptoideApplication.getFragmentProvider().newStoreFragment(getPojo().getId(), this.theme, StoreFragment.OpenType.GetHome), true);
        }
    }

    public FollowUserDisplayable(GetFollowers.TimelineUser timelineUser, String str) {
        super(timelineUser);
        this.theme = str;
    }
}
