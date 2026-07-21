package cm.aptoide.pt.view;

import androidx.fragment.app.Fragment;
import cm.aptoide.pt.app.view.AppViewFragment;
import cm.aptoide.pt.dataprovider.model.v7.Event;
import cm.aptoide.pt.dataprovider.ws.v7.store.StoreContext;
import cm.aptoide.pt.search.model.SearchAdResult;
import cm.aptoide.pt.store.view.StoreFragment;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentProvider {
    @Deprecated
    Fragment newAppViewFragment(long j2, String str, String str2);

    @Deprecated
    Fragment newAppViewFragment(long j2, String str, String str2, String str3, String str4);

    @Deprecated
    Fragment newAppViewFragment(long j2, String str, String str2, String str3, String str4, String str5);

    @Deprecated
    Fragment newAppViewFragment(SearchAdResult searchAdResult, String str);

    @Deprecated
    Fragment newAppViewFragment(String str, AppViewFragment.OpenType openType);

    @Deprecated
    Fragment newDescriptionFragment(String str, String str2, boolean z);

    @Deprecated
    Fragment newLatestReviewsFragment(long j2, StoreContext storeContext);

    @Deprecated
    Fragment newRateAndReviewsFragment(long j2, String str, String str2, String str3, long j3);

    @Deprecated
    Fragment newSettingsFragment();

    @Deprecated
    Fragment newStoreFragment(long j2, String str, StoreFragment.OpenType openType);

    @Deprecated
    Fragment newStoreFragment(String str, String str2);

    @Deprecated
    Fragment newStoreFragment(String str, String str2, StoreFragment.OpenType openType);

    @Deprecated
    Fragment newStoreTabGridRecyclerFragment(Event event, String str, String str2, StoreContext storeContext, boolean z, boolean z2);

    @Deprecated
    Fragment newStoreTabGridRecyclerFragment(Event event, String str, String str2, String str3, StoreContext storeContext, boolean z, boolean z2);

    @Deprecated
    Fragment newSubscribedStoresFragment(Event event, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowersFragment(String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowersUsingStoreIdFragment(Long l, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowersUsingUserIdFragment(Long l, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowingFragmentUsingStoreId(Long l, String str, String str2, StoreContext storeContext);

    @Deprecated
    Fragment newTimeLineFollowingFragmentUsingUserId(Long l, String str, String str2, StoreContext storeContext);
}
