package cm.aptoide.pt.store;

import cm.aptoide.pt.database.room.RoomStore;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class RoomStoreRepository {
    private final StorePersistence storePersistence;

    public RoomStoreRepository(StorePersistence storePersistence) {
        this.storePersistence = storePersistence;
    }

    public Single<RoomStore> get(Long l) {
        return this.storePersistence.get(l.longValue());
    }

    public rx.e<List<RoomStore>> getAll() {
        return this.storePersistence.getAll();
    }

    public rx.e<Boolean> isSubscribed(long j2) {
        return this.storePersistence.isSubscribed(j2);
    }

    public rx.b remove(String str) {
        return this.storePersistence.remove(str);
    }

    public rx.b save(RoomStore roomStore) {
        return this.storePersistence.save(roomStore);
    }

    public rx.b saveAll(List<RoomStore> list) {
        return this.storePersistence.saveAll(list);
    }

    public Single<RoomStore> get(String str) {
        return this.storePersistence.get(str);
    }
}
