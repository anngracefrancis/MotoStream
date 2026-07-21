package cm.aptoide.pt.database.room;

import h.a.m;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface EventDAO {
    void delete(RoomEvent roomEvent);

    m<List<RoomEvent>> getAll();

    void insert(RoomEvent roomEvent);
}
