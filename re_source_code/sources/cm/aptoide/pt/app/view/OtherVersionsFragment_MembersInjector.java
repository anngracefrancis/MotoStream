package cm.aptoide.pt.app.view;

import cm.aptoide.pt.store.RoomStoreRepository;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class OtherVersionsFragment_MembersInjector implements f.a<OtherVersionsFragment> {
    private final Provider<RoomStoreRepository> storeRepositoryProvider;

    public OtherVersionsFragment_MembersInjector(Provider<RoomStoreRepository> provider) {
        this.storeRepositoryProvider = provider;
    }

    public static f.a<OtherVersionsFragment> create(Provider<RoomStoreRepository> provider) {
        return new OtherVersionsFragment_MembersInjector(provider);
    }

    public static void injectStoreRepository(OtherVersionsFragment otherVersionsFragment, RoomStoreRepository roomStoreRepository) {
        otherVersionsFragment.storeRepository = roomStoreRepository;
    }

    public void injectMembers(OtherVersionsFragment otherVersionsFragment) {
        injectStoreRepository(otherVersionsFragment, this.storeRepositoryProvider.get());
    }
}
