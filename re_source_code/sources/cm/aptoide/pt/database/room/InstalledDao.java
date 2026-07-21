package cm.aptoide.pt.database.room;

import h.a.b;
import h.a.m;
import h.a.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface InstalledDao {
    m<RoomInstalled> get(String str, int i2);

    m<List<RoomInstalled>> getAll();

    m<List<RoomInstalled>> getAllFilteringSystemApps();

    m<List<RoomInstalled>> getAllSortedAsc();

    m<List<RoomInstalled>> getAsList(String str, int i2);

    m<List<RoomInstalled>> getAsListByPackageName(String str);

    void insert(RoomInstalled roomInstalled);

    void insertAll(List<RoomInstalled> list);

    s<RoomInstalled> isInstalledByVersion(String str, int i2);

    b remove(String str);

    b remove(String str, int i2);

    void removeAll();
}
