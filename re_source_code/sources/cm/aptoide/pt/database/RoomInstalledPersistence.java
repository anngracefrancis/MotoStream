package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.InstalledDao;
import cm.aptoide.pt.database.room.RoomInstallation;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.install.InstallationPersistence;
import cm.aptoide.pt.install.InstalledPersistence;
import java.util.ArrayList;
import java.util.List;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomInstalledPersistence implements InstalledPersistence {
    private final RoomInstallationMapper installationMapper;
    private final InstalledDao installedDao;
    private final InstallationPersistence roomInstallationPersistence;

    public RoomInstalledPersistence(InstalledDao installedDao, RoomInstallationPersistence roomInstallationPersistence, RoomInstallationMapper roomInstallationMapper) {
        this.installedDao = installedDao;
        this.roomInstallationPersistence = roomInstallationPersistence;
        this.installationMapper = roomInstallationMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: filterCompleted, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public rx.e<List<RoomInstalled>> e(List<RoomInstalled> list) {
        return rx.e.N(list).D(new rx.m.e() { // from class: cm.aptoide.pt.database.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((RoomInstalled) obj).getStatus() == 4);
            }
        }).Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: filterInstalling, reason: merged with bridge method [inline-methods] */
    public rx.e<List<RoomInstalled>> c(List<RoomInstalled> list) {
        return rx.e.N(list).D(new rx.m.e() { // from class: cm.aptoide.pt.database.j0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((RoomInstalled) obj).getStatus() == 3);
            }
        }).Y0();
    }

    private rx.e<List<RoomInstalled>> getInstalledAsList(String str) {
        return g.a.a.a.d.b(this.installedDao.getAsListByPackageName(str), h.a.a.BUFFER).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.c0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomInstalledPersistence.lambda$getInstalledAsList$13((Throwable) obj);
            }
        }).G(new rx.m.e() { // from class: cm.aptoide.pt.database.k0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4924f.d((List) obj);
            }
        }).I0(Schedulers.io());
    }

    static /* synthetic */ List lambda$getAsList$4(Throwable th) {
        return new ArrayList();
    }

    static /* synthetic */ RoomInstalled lambda$getInstalled$3(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return (RoomInstalled) list.get(0);
    }

    static /* synthetic */ List lambda$getInstalledAsList$13(Throwable th) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insert$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(RoomInstalled roomInstalled) {
        this.installedDao.insert(roomInstalled);
    }

    static /* synthetic */ RoomInstalled lambda$isInstalled$8(Throwable th) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$replaceAllBy$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(List list) {
        this.installedDao.removeAll();
        this.installedDao.insertAll(list);
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<RoomInstalled> get(String str, int i2) {
        return g.a.a.a.d.b(this.installedDao.get(str, i2), h.a.a.BUFFER).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getAll() {
        return g.a.a.a.d.b(this.installedDao.getAll(), h.a.a.BUFFER).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getAllAsList(String str) {
        return g.a.a.a.d.b(this.installedDao.getAsListByPackageName(str), h.a.a.BUFFER).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getAllInstalled() {
        return g.a.a.a.d.b(this.installedDao.getAll(), h.a.a.BUFFER).G(new rx.m.e() { // from class: cm.aptoide.pt.database.l0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4927f.a((List) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getAllInstalledSorted() {
        return g.a.a.a.d.b(this.installedDao.getAllSortedAsc(), h.a.a.BUFFER).G(new rx.m.e() { // from class: cm.aptoide.pt.database.n0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4936f.b((List) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getAllInstalling() {
        return g.a.a.a.d.b(this.installedDao.getAll(), h.a.a.BUFFER).G(new rx.m.e() { // from class: cm.aptoide.pt.database.m0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4931f.c((List) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getAsList(String str, int i2) {
        return g.a.a.a.d.b(this.installedDao.getAsList(str, i2), h.a.a.BUFFER).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.p0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomInstalledPersistence.lambda$getAsList$4((Throwable) obj);
            }
        }).I0(Schedulers.io());
    }

    public rx.e<List<RoomInstallation>> getInstallationsHistory() {
        return this.roomInstallationPersistence.getInstallationsHistory();
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<RoomInstalled> getInstalled(String str) {
        return getInstalledAsList(str).X(new rx.m.e() { // from class: cm.aptoide.pt.database.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomInstalledPersistence.lambda$getInstalled$3((List) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<List<RoomInstalled>> getInstalledFilteringSystemApps() {
        return g.a.a.a.d.b(this.installedDao.getAllFilteringSystemApps(), h.a.a.BUFFER).G(new rx.m.e() { // from class: cm.aptoide.pt.database.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f4909f.e((List) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.b insert(final RoomInstalled roomInstalled) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.f0
            @Override // rx.m.a
            public final void call() {
                this.f4904f.f(roomInstalled);
            }
        }).a(this.roomInstallationPersistence.insert(this.installationMapper.map(roomInstalled))).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.e<Boolean> isInstalled(String str) {
        return getInstalled(str).X(new rx.m.e() { // from class: cm.aptoide.pt.database.q0
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomInstalled roomInstalled = (RoomInstalled) obj;
                return Boolean.valueOf(roomInstalled != null && roomInstalled.getStatus() == 4);
            }
        });
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.b remove(String str, int i2) {
        return g.a.a.a.d.a(this.installedDao.remove(str, i2)).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public rx.b replaceAllBy(final List<RoomInstalled> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.i0
            @Override // rx.m.a
            public final void call() {
                this.f4916f.g(list);
            }
        }).a(this.roomInstallationPersistence.insertAll(this.installationMapper.map(list))).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstalledPersistence
    public Single<Boolean> isInstalled(String str, int i2) {
        return g.a.a.a.d.d(this.installedDao.isInstalledByVersion(str, i2)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.e0
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomInstalledPersistence.lambda$isInstalled$8((Throwable) obj);
                return null;
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.database.o0
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomInstalled roomInstalled = (RoomInstalled) obj;
                return Boolean.valueOf(roomInstalled != null && roomInstalled.getStatus() == 4);
            }
        }).v(Schedulers.io());
    }

    public rx.b remove(String str) {
        return g.a.a.a.d.a(this.installedDao.remove(str)).K(Schedulers.io());
    }
}
