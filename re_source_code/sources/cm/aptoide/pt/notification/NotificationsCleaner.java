package cm.aptoide.pt.notification;

import cm.aptoide.accountmanager.Account;
import cm.aptoide.accountmanager.AptoideAccountManager;
import cm.aptoide.pt.crashreports.CrashReport;
import cm.aptoide.pt.database.RoomNotificationPersistence;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class NotificationsCleaner {
    public static final int MAX_NUMBER_NOTIFICATIONS_SAVED = 50;
    private AptoideAccountManager accountManager;
    private final Calendar calendar;
    private CrashReport crashReport;
    private NotificationProvider notificationProvider;
    private final RoomNotificationPersistence roomNotificationPersistence;
    private final rx.t.b subscriptions = new rx.t.b();

    public NotificationsCleaner(RoomNotificationPersistence roomNotificationPersistence, Calendar calendar, AptoideAccountManager aptoideAccountManager, NotificationProvider notificationProvider, CrashReport crashReport) {
        this.roomNotificationPersistence = roomNotificationPersistence;
        this.calendar = calendar;
        this.accountManager = aptoideAccountManager;
        this.notificationProvider = notificationProvider;
        this.crashReport = crashReport;
    }

    private boolean isNotificationExpired(RoomNotification roomNotification) {
        Long expire = roomNotification.getExpire();
        return expire != null && this.calendar.getTimeInMillis() > expire.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeExceededLimitNotifications$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e a() {
        return this.roomNotificationPersistence.getAllSortedDesc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeExceededLimitNotifications$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(int i2, List list) {
        return list.size() > i2 ? lambda$removeExpiredNotifications$10(list.subList(i2, list.size())) : rx.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeExpiredNotifications$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e d() {
        return this.roomNotificationPersistence.getAllSortedDesc();
    }

    static /* synthetic */ Iterable lambda$removeExpiredNotifications$8(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeExpiredNotifications$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e e(RoomNotification roomNotification) {
        return isNotificationExpired(roomNotification) ? rx.e.S(roomNotification) : rx.e.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeNotifications$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b f(List list) {
        return this.roomNotificationPersistence.delete(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setup$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b g(Account account) {
        return cleanOtherUsersNotifications(account.getId());
    }

    static /* synthetic */ void lambda$setup$2(Account account) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setup$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(Throwable th) {
        this.crashReport.log(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setup$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b i(List list) {
        return cleanLimitExceededNotifications(50);
    }

    static /* synthetic */ void lambda$setup$5(List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$setup$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void j(Throwable th) {
        this.crashReport.log(th);
    }

    private rx.b removeExceededLimitNotifications(final int i2) {
        return rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.notification.p0
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f6766f.a();
            }
        }).E().H(new rx.m.e() { // from class: cm.aptoide.pt.notification.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6703f.b(i2, (List) obj);
            }
        }).X0();
    }

    private rx.b removeExpiredNotifications() {
        return rx.e.p(new rx.m.d() { // from class: cm.aptoide.pt.notification.m0
            @Override // rx.m.d, java.util.concurrent.Callable
            public final Object call() {
                return this.f6747f.d();
            }
        }).E().J(new rx.m.e() { // from class: cm.aptoide.pt.notification.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                NotificationsCleaner.lambda$removeExpiredNotifications$8(list);
                return list;
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.notification.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6714f.e((RoomNotification) obj);
            }
        }).Y0().H(new rx.m.e() { // from class: cm.aptoide.pt.notification.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6679f.c((List) obj);
            }
        }).X0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: removeNotifications, reason: merged with bridge method [inline-methods] */
    public rx.b c(List<RoomNotification> list) {
        return rx.e.N(list).X(new rx.m.e() { // from class: cm.aptoide.pt.notification.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((RoomNotification) obj).getKey();
            }
        }).Y0().D(new rx.m.e() { // from class: cm.aptoide.pt.notification.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(!((List) obj).isEmpty());
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6734f.f((List) obj);
            }
        }).X0();
    }

    public rx.b cleanLimitExceededNotifications(int i2) {
        return removeExpiredNotifications().a(removeExceededLimitNotifications(i2));
    }

    public rx.b cleanOtherUsersNotifications(String str) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(str);
        arrayList.add(HttpUrl.FRAGMENT_ENCODE_SET);
        return this.roomNotificationPersistence.deleteAllExcluding(arrayList);
    }

    public void setup() {
        this.subscriptions.a(this.accountManager.accountStatus().D(new rx.m.e() { // from class: cm.aptoide.pt.notification.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Account) obj).isLoggedIn());
            }
        }).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6694f.g((Account) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.l0
            @Override // rx.m.b
            public final void call(Object obj) {
                NotificationsCleaner.lambda$setup$2((Account) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6688f.h((Throwable) obj);
            }
        }));
        this.subscriptions.a(this.notificationProvider.getNotifications(1).H(new rx.m.e() { // from class: cm.aptoide.pt.notification.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6725f.i((List) obj);
            }
        }).H0(new rx.m.b() { // from class: cm.aptoide.pt.notification.o0
            @Override // rx.m.b
            public final void call(Object obj) {
                NotificationsCleaner.lambda$setup$5((List) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.notification.i0
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f6718f.j((Throwable) obj);
            }
        }));
    }
}
