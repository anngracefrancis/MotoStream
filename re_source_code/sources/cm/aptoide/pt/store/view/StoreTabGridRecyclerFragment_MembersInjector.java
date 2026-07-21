package cm.aptoide.pt.store.view;

import cm.aptoide.pt.store.RoomStoreRepository;
import javax.inject.Named;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class StoreTabGridRecyclerFragment_MembersInjector implements f.a<StoreTabGridRecyclerFragment> {
    private final Provider<String> marketNameProvider;
    private final Provider<RoomStoreRepository> storeRepositoryProvider;

    public StoreTabGridRecyclerFragment_MembersInjector(Provider<RoomStoreRepository> provider, Provider<String> provider2) {
        this.storeRepositoryProvider = provider;
        this.marketNameProvider = provider2;
    }

    public static f.a<StoreTabGridRecyclerFragment> create(Provider<RoomStoreRepository> provider, Provider<String> provider2) {
        return new StoreTabGridRecyclerFragment_MembersInjector(provider, provider2);
    }

    @Named
    public static void injectMarketName(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment, String str) {
        storeTabGridRecyclerFragment.marketName = str;
    }

    public static void injectStoreRepository(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment, RoomStoreRepository roomStoreRepository) {
        storeTabGridRecyclerFragment.storeRepository = roomStoreRepository;
    }

    public void injectMembers(StoreTabGridRecyclerFragment storeTabGridRecyclerFragment) {
        injectStoreRepository(storeTabGridRecyclerFragment, this.storeRepositoryProvider.get());
        injectMarketName(storeTabGridRecyclerFragment, this.marketNameProvider.get());
    }
}
