package cm.aptoide.pt.notification;

import cm.aptoide.pt.database.room.LocalNotificationSyncDao;
import cm.aptoide.pt.database.room.RoomLocalNotificationSync;
import cm.aptoide.pt.notification.sync.LocalNotificationSync;
import cm.aptoide.pt.sync.Sync;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomLocalNotificationSyncPersistence implements LocalNotificationSyncPersistence {
    private LocalNotificationSyncDao localNotificationSyncDao;
    private RoomLocalNotificationSyncMapper mapper;
    private NotificationProvider provider;

    public RoomLocalNotificationSyncPersistence(RoomLocalNotificationSyncMapper roomLocalNotificationSyncMapper, NotificationProvider notificationProvider, LocalNotificationSyncDao localNotificationSyncDao) {
        this.mapper = roomLocalNotificationSyncMapper;
        this.provider = notificationProvider;
        this.localNotificationSyncDao = localNotificationSyncDao;
    }

    static /* synthetic */ RoomLocalNotificationSync lambda$get$0(Throwable th) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$get$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Sync a(RoomLocalNotificationSync roomLocalNotificationSync) {
        if (roomLocalNotificationSync != null) {
            return this.mapper.map(roomLocalNotificationSync, this.provider);
        }
        return null;
    }

    @Override // cm.aptoide.pt.notification.LocalNotificationSyncPersistence
    public rx.e<Sync> get(String str) {
        return g.a.a.a.d.b(this.localNotificationSyncDao.get(str), h.a.a.BUFFER).I0(Schedulers.io()).p0(new rx.m.e() { // from class: cm.aptoide.pt.notification.d1
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomLocalNotificationSyncPersistence.lambda$get$0((Throwable) obj);
                return null;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.c1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6689f.a((RoomLocalNotificationSync) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.notification.LocalNotificationSyncPersistence
    public void remove(String str) {
        this.localNotificationSyncDao.delete(str);
    }

    @Override // cm.aptoide.pt.notification.LocalNotificationSyncPersistence
    public void save(LocalNotificationSync localNotificationSync) {
        this.localNotificationSyncDao.save(this.mapper.map(localNotificationSync));
    }
}
