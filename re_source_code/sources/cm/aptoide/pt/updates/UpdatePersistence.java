package cm.aptoide.pt.updates;

import cm.aptoide.pt.database.room.RoomUpdate;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface UpdatePersistence {
    Single<Boolean> contains(String str, boolean z);

    Single<RoomUpdate> get(String str);

    Single<List<RoomUpdate>> getAll(boolean z);

    rx.e<List<RoomUpdate>> getAllSorted(boolean z);

    Single<Boolean> isExcluded(String str);

    rx.b remove(String str);

    rx.b removeAll(List<RoomUpdate> list);

    rx.b save(RoomUpdate roomUpdate);

    rx.b saveAll(List<RoomUpdate> list);
}
