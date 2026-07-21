package cm.aptoide.pt.database.room;

import h.a.m;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface InstallationDao {
    m<List<RoomInstallation>> getAll();

    void insert(RoomInstallation roomInstallation);

    void insertAll(List<RoomInstallation> list);
}
