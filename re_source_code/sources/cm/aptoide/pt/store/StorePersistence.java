package cm.aptoide.pt.store;

import cm.aptoide.pt.database.room.RoomStore;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface StorePersistence {
    Single<RoomStore> get(long j2);

    Single<RoomStore> get(String str);

    rx.e<List<RoomStore>> getAll();

    rx.e<Boolean> isSubscribed(long j2);

    rx.b remove(String str);

    rx.b save(RoomStore roomStore);

    rx.b saveAll(List<RoomStore> list);
}
