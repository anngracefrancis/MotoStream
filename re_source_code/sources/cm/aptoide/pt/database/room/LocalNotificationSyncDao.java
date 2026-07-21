package cm.aptoide.pt.database.room;

import h.a.m;

/* JADX INFO: loaded from: classes.dex */
public interface LocalNotificationSyncDao {
    void delete(String str);

    m<RoomLocalNotificationSync> get(String str);

    void save(RoomLocalNotificationSync roomLocalNotificationSync);
}
