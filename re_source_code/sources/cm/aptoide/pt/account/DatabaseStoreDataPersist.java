package cm.aptoide.pt.account;

import cm.aptoide.accountmanager.Store;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.store.RoomStoreRepository;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseStoreDataPersist {
    private final DatabaseStoreMapper databaseStoreMapper;
    private final RoomStoreRepository storeRepository;

    public static class DatabaseStoreMapper {
        public Store fromDatabase(RoomStore roomStore) {
            return new Store(roomStore.getDownloads(), roomStore.getIconPath(), roomStore.getStoreId(), roomStore.getStoreName(), roomStore.getTheme(), roomStore.getUsername(), roomStore.getPasswordSha1(), true);
        }

        public RoomStore toDatabase(Store store) {
            RoomStore roomStore = new RoomStore();
            roomStore.setDownloads(store.getDownloadCount());
            roomStore.setIconPath(store.getAvatar());
            roomStore.setStoreId(store.getId());
            roomStore.setStoreName(store.getName());
            roomStore.setTheme(store.getTheme());
            roomStore.setUsername(store.getUsername());
            roomStore.setPasswordSha1(store.getPassword());
            return roomStore;
        }
    }

    public DatabaseStoreDataPersist(DatabaseStoreMapper databaseStoreMapper, RoomStoreRepository roomStoreRepository) {
        this.storeRepository = roomStoreRepository;
        this.databaseStoreMapper = databaseStoreMapper;
    }

    static /* synthetic */ Iterable lambda$get$2(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$get$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Store a(RoomStore roomStore) {
        return this.databaseStoreMapper.fromDatabase(roomStore);
    }

    static /* synthetic */ void lambda$get$4(List list) {
        Logger logger = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("nr stores= ");
        sb.append(list != null ? list.size() : 0);
        logger.d("DatabaseStoreDataPersist", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$persist$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ RoomStore b(Store store) {
        return this.databaseStoreMapper.toDatabase(store);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$persist$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b c(List list) {
        return this.storeRepository.saveAll(list);
    }

    public Single<List<Store>> get() {
        return this.storeRepository.getAll().E().J(new rx.m.e() { // from class: cm.aptoide.pt.account.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                DatabaseStoreDataPersist.lambda$get$2(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.account.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3810f.a((RoomStore) obj);
            }
        }).Y0().Z0().g(new rx.m.b() { // from class: cm.aptoide.pt.account.j0
            @Override // rx.m.b
            public final void call(Object obj) {
                DatabaseStoreDataPersist.lambda$get$4((List) obj);
            }
        });
    }

    public rx.b persist(List<Store> list) {
        return rx.e.N(list).X(new rx.m.e() { // from class: cm.aptoide.pt.account.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3812f.b((Store) obj);
            }
        }).Y0().H(new rx.m.e() { // from class: cm.aptoide.pt.account.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f3806f.c((List) obj);
            }
        }).X0();
    }
}
