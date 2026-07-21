package cm.aptoide.pt.database.room;

import h.a.m;
import h.a.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface StoreDao {
    m<List<RoomStore>> getAll();

    s<RoomStore> getByStoreId(long j2);

    s<RoomStore> getByStoreName(String str);

    void insert(RoomStore roomStore);

    m<Integer> isSubscribed(long j2);

    void removeByStoreName(String str);

    void saveAll(List<RoomStore> list);
}
