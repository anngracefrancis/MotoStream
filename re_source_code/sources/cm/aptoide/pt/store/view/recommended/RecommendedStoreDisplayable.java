package cm.aptoide.pt.store.view.recommended;

import android.content.Context;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import cm.aptoide.pt.navigator.FragmentNavigator;
import cm.aptoide.pt.store.RoomStoreRepository;
import cm.aptoide.pt.store.StoreCredentialsProvider;
import cm.aptoide.pt.store.StoreUtils;
import cm.aptoide.pt.store.StoreUtilsProxy;
import cm.aptoide.pt.view.recycler.displayable.Displayable;
import cm.aptoide.pt.view.recycler.displayable.DisplayablePojo;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class RecommendedStoreDisplayable extends DisplayablePojo<Store> {
    private AptoideAccountManager accountManager;
    private String origin;
    private StoreCredentialsProvider storeCredentialsProvider;
    private RoomStoreRepository storeRepository;
    private StoreUtilsProxy storeUtilsProxy;

    public RecommendedStoreDisplayable() {
        this.origin = HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    protected Displayable.Configs getConfig() {
        return new Displayable.Configs(1, false);
    }

    public String getOrigin() {
        return this.origin;
    }

    @Override // cm.aptoide.pt.view.recycler.displayable.Displayable
    public int getViewLayout() {
        return R.layout.displayable_recommended_store;
    }

    rx.e<Boolean> isFollowing() {
        return this.storeRepository.isSubscribed(getPojo().getId());
    }

    void openStoreFragment(FragmentNavigator fragmentNavigator) {
        fragmentNavigator.navigateTo(AptoideApplication.getFragmentProvider().newStoreFragment(getPojo().getName(), getPojo().getAppearance().getTheme()), true);
    }

    public void subscribeStore() {
        this.storeUtilsProxy.subscribeStore(getPojo().getName());
    }

    void unsubscribeStore(Context context) {
        if (this.accountManager.isLoggedIn()) {
            this.accountManager.unsubscribeStore(getPojo().getName(), this.storeCredentialsProvider.get(getPojo().getName()).getName(), this.storeCredentialsProvider.get(getPojo().getName()).getPasswordSha1());
        }
        StoreUtils.unSubscribeStore(getPojo().getName(), this.accountManager, this.storeCredentialsProvider, this.storeRepository);
    }

    public RecommendedStoreDisplayable(Store store, RoomStoreRepository roomStoreRepository, AptoideAccountManager aptoideAccountManager, StoreUtilsProxy storeUtilsProxy, StoreCredentialsProvider storeCredentialsProvider) {
        super(store);
        this.origin = HttpUrl.FRAGMENT_ENCODE_SET;
        this.storeRepository = roomStoreRepository;
        this.accountManager = aptoideAccountManager;
        this.storeUtilsProxy = storeUtilsProxy;
        this.storeCredentialsProvider = storeCredentialsProvider;
    }

    public RecommendedStoreDisplayable(Store store, RoomStoreRepository roomStoreRepository, AptoideAccountManager aptoideAccountManager, StoreUtilsProxy storeUtilsProxy, StoreCredentialsProvider storeCredentialsProvider, String str) {
        super(store);
        this.origin = HttpUrl.FRAGMENT_ENCODE_SET;
        this.storeRepository = roomStoreRepository;
        this.accountManager = aptoideAccountManager;
        this.storeUtilsProxy = storeUtilsProxy;
        this.storeCredentialsProvider = storeCredentialsProvider;
        this.origin = str;
    }
}
