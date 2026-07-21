package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.AppComingSoonRegistrationDAO;
import cm.aptoide.pt.database.room.RoomAppComingSoonRegistration;
import cm.aptoide.pt.home.AppComingSoonRegistrationPersistence;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomAppComingSoonPersistence implements AppComingSoonRegistrationPersistence {
    private final AppComingSoonRegistrationDAO appComingSoonRegistrationDAO;

    public RoomAppComingSoonPersistence(AppComingSoonRegistrationDAO appComingSoonRegistrationDAO) {
        this.appComingSoonRegistrationDAO = appComingSoonRegistrationDAO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$registerForAppNotification$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(RoomAppComingSoonRegistration roomAppComingSoonRegistration) {
        this.appComingSoonRegistrationDAO.save(roomAppComingSoonRegistration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$unregisterForAppNotification$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(RoomAppComingSoonRegistration roomAppComingSoonRegistration) {
        this.appComingSoonRegistrationDAO.remove(roomAppComingSoonRegistration);
    }

    @Override // cm.aptoide.pt.home.AppComingSoonRegistrationPersistence
    public rx.e<Boolean> isRegisteredForApp(String str) {
        return g.a.a.a.d.b(this.appComingSoonRegistrationDAO.isRegisteredForApp(str), h.a.a.BUFFER).I0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.database.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() > 0);
            }
        });
    }

    @Override // cm.aptoide.pt.home.AppComingSoonRegistrationPersistence
    public rx.b registerForAppNotification(final RoomAppComingSoonRegistration roomAppComingSoonRegistration) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.b
            @Override // rx.m.a
            public final void call() {
                this.f4884f.a(roomAppComingSoonRegistration);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.home.AppComingSoonRegistrationPersistence
    public rx.b unregisterForAppNotification(final RoomAppComingSoonRegistration roomAppComingSoonRegistration) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.a
            @Override // rx.m.a
            public final void call() {
                this.f4879f.b(roomAppComingSoonRegistration);
            }
        }).K(Schedulers.io());
    }
}
