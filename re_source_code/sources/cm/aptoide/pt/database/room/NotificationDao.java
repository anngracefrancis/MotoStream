package cm.aptoide.pt.database.room;

import h.a.m;
import h.a.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface NotificationDao {
    void deleteAllByType(int i2);

    void deleteAllExcluding(List<String> list);

    void deleteByKey(List<String> list);

    m<List<RoomNotification>> getAll();

    m<List<RoomNotification>> getAllSortedDesc();

    s<List<RoomNotification>> getAllSortedDescByType(Integer[] numArr);

    s<List<RoomNotification>> getDismissed(Integer[] numArr, long j2, long j3);

    void insert(RoomNotification roomNotification);

    void insertAll(List<RoomNotification> list);
}
