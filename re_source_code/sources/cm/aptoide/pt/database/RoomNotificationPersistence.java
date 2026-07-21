package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.NotificationDao;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Iterator;
import java.util.List;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomNotificationPersistence {
    private NotificationDao notificationDao;

    public RoomNotificationPersistence(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$delete$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(List list) {
        this.notificationDao.deleteByKey(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$deleteAllExcluding$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(List list) {
        this.notificationDao.deleteAllExcluding(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$deleteAllOfType$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(int i2) {
        this.notificationDao.deleteAllByType(i2);
    }

    static /* synthetic */ Single lambda$getLastShowed$0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RoomNotification roomNotification = (RoomNotification) it.next();
            if (!roomNotification.isDismissed()) {
                return Single.m(roomNotification);
            }
        }
        return Single.m(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insert$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(RoomNotification roomNotification) {
        this.notificationDao.insert(roomNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insertAll$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(List list) {
        this.notificationDao.insertAll(list);
    }

    public rx.b delete(final List<String> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.u0
            @Override // rx.m.a
            public final void call() {
                this.f4953f.a(list);
            }
        }).K(Schedulers.io());
    }

    public rx.b deleteAllExcluding(final List<String> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.w0
            @Override // rx.m.a
            public final void call() {
                this.f4959f.b(list);
            }
        }).K(Schedulers.io());
    }

    public rx.b deleteAllOfType(final int i2) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.r0
            @Override // rx.m.a
            public final void call() {
                this.f4946f.c(i2);
            }
        }).K(Schedulers.io());
    }

    public rx.e<List<RoomNotification>> getAll() {
        return g.a.a.a.d.b(this.notificationDao.getAll(), h.a.a.BUFFER).I0(Schedulers.io());
    }

    public rx.e<List<RoomNotification>> getAllSortedDesc() {
        return g.a.a.a.d.b(this.notificationDao.getAllSortedDesc(), h.a.a.BUFFER).I0(Schedulers.io());
    }

    public Single<List<RoomNotification>> getAllSortedDescByType(Integer[] numArr) {
        return g.a.a.a.d.d(this.notificationDao.getAllSortedDescByType(numArr)).v(Schedulers.io());
    }

    public Single<List<RoomNotification>> getDismissed(Integer[] numArr, long j2, long j3) {
        return g.a.a.a.d.d(this.notificationDao.getDismissed(numArr, j2, j3)).v(Schedulers.io());
    }

    public Single<RoomNotification> getLastShowed(Integer[] numArr) {
        return getAllSortedDescByType(numArr).i(new rx.m.e() { // from class: cm.aptoide.pt.database.t0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomNotificationPersistence.lambda$getLastShowed$0((List) obj);
            }
        });
    }

    public rx.b insert(final RoomNotification roomNotification) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.v0
            @Override // rx.m.a
            public final void call() {
                this.f4956f.d(roomNotification);
            }
        }).K(Schedulers.io());
    }

    public rx.b insertAll(final List<RoomNotification> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.s0
            @Override // rx.m.a
            public final void call() {
                this.f4949f.e(list);
            }
        }).K(Schedulers.io());
    }
}
