package cm.aptoide.pt.notification;

import cm.aptoide.pt.database.RoomNotificationPersistence;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class NotificationProvider {
    private final RoomNotificationPersistence roomNotificationPersistence;
    private final rx.h scheduler;

    public NotificationProvider(RoomNotificationPersistence roomNotificationPersistence, rx.h hVar) {
        this.scheduler = hVar;
        this.roomNotificationPersistence = roomNotificationPersistence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToAptoideNotification, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public AptoideNotification e(RoomNotification roomNotification) {
        return new AptoideNotification(roomNotification.getBody(), roomNotification.getImg(), roomNotification.getTitle(), roomNotification.getUrl(), roomNotification.getType(), roomNotification.getAppName(), roomNotification.getGraphic(), roomNotification.getDismissed(), roomNotification.getOwnerId(), roomNotification.getUrlTrack(), roomNotification.getNotificationCenterUrlTrack(), roomNotification.isProcessed(), roomNotification.getTimeStamp(), roomNotification.getExpire(), roomNotification.getAbTestingGroup(), roomNotification.getCampaignId(), roomNotification.getLang(), roomNotification.getActionStringRes(), roomNotification.getWhitelistedPackages());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToNotification, reason: merged with bridge method [inline-methods] */
    public RoomNotification g(AptoideNotification aptoideNotification) {
        return new RoomNotification(aptoideNotification.getExpire(), aptoideNotification.getAbTestingGroup(), aptoideNotification.getBody(), aptoideNotification.getCampaignId(), aptoideNotification.getImg(), aptoideNotification.getLang(), aptoideNotification.getTitle(), aptoideNotification.getUrl(), aptoideNotification.getUrlTrack(), aptoideNotification.getNotificationCenterUrlTrack(), aptoideNotification.getTimeStamp(), aptoideNotification.getType(), aptoideNotification.getDismissed(), aptoideNotification.getAppName(), aptoideNotification.getGraphic(), aptoideNotification.getOwnerId(), aptoideNotification.isProcessed(), aptoideNotification.getActionStringRes(), aptoideNotification.getWhitelistedPackages());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getAptoideNotifications$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(List list) {
        return rx.e.N(list).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6774f.a((RoomNotification) obj);
            }
        }).Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getDismissedNotifications$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single d(List list) {
        return rx.e.N(list).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6761f.c((RoomNotification) obj);
            }
        }).Y0().Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getNotifications$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e f(int i2, List list) {
        return rx.e.N(list).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.r
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6777f.e((RoomNotification) obj);
            }
        }).N0(i2).Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b h(List list) {
        return this.roomNotificationPersistence.insertAll(list);
    }

    public rx.b deleteAllForType(int i2) {
        return this.roomNotificationPersistence.deleteAllOfType(i2);
    }

    public rx.e<List<AptoideNotification>> getAptoideNotifications() {
        return this.roomNotificationPersistence.getAll().G(new rx.m.e() { // from class: cm.aptoide.pt.notification.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6788f.b((List) obj);
            }
        });
    }

    public Single<List<AptoideNotification>> getDismissedNotifications(Integer[] numArr, long j2, long j3) {
        return this.roomNotificationPersistence.getDismissed(numArr, j2, j3).i(new rx.m.e() { // from class: cm.aptoide.pt.notification.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6765f.d((List) obj);
            }
        });
    }

    public Single<RoomNotification> getLastShowed(Integer[] numArr) {
        return this.roomNotificationPersistence.getLastShowed(numArr);
    }

    public rx.e<List<AptoideNotification>> getNotifications(final int i2) {
        return this.roomNotificationPersistence.getAllSortedDesc().G(new rx.m.e() { // from class: cm.aptoide.pt.notification.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6756f.f(i2, (List) obj);
            }
        });
    }

    public rx.b save(List<AptoideNotification> list) {
        return rx.e.N(list).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6785f.g((AptoideNotification) obj);
            }
        }).Y0().H(new rx.m.e() { // from class: cm.aptoide.pt.notification.s
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6781f.h((List) obj);
            }
        }).X0();
    }

    public rx.e<List<RoomNotification>> getNotifications() {
        return this.roomNotificationPersistence.getAll();
    }

    public rx.b save(RoomNotification roomNotification) {
        return this.roomNotificationPersistence.insert(roomNotification).K(this.scheduler);
    }

    public rx.b save(AptoideNotification aptoideNotification) {
        return save(lambda$save$2(aptoideNotification));
    }
}
