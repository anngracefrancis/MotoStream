package cm.aptoide.pt.database.room;

import h.a.m;
import h.a.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface UpdateDao {
    void deleteAll(List<RoomUpdate> list);

    void deleteByPackageName(String str);

    s<RoomUpdate> get(String str);

    s<List<RoomUpdate>> getAllByExcluded(boolean z);

    m<List<RoomUpdate>> getAllByExcludedSorted(boolean z);

    s<RoomUpdate> getByPackageAndExcluded(String str, boolean z);

    void insert(RoomUpdate roomUpdate);

    void insertAll(List<RoomUpdate> list);
}
