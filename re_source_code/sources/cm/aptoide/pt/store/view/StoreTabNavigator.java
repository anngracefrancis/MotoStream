package cm.aptoide.pt.store.view;

import cm.aptoide.pt.comments.view.CommentListFragment;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.util.CommentType;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.navigator.FragmentNavigator;

/* JADX INFO: loaded from: classes.dex */
public class StoreTabNavigator {
    private final FragmentNavigator fragmentNavigator;

    public StoreTabNavigator(FragmentNavigator fragmentNavigator) {
        this.fragmentNavigator = fragmentNavigator;
    }

    public void navigateToCommentGridRecyclerView(CommentType commentType, String str, String str2, StoreContext storeContext) {
        this.fragmentNavigator.navigateTo(CommentListFragment.newInstanceUrl(commentType, str, str2, storeContext), true);
    }

    public void navigateToStoreTabGridRecyclerView(Event event, String str, String str2, String str3, StoreContext storeContext, boolean z) {
        this.fragmentNavigator.navigateTo(StoreTabGridRecyclerFragment.newInstance(event, str, str2, str3, storeContext, z), true);
    }
}
