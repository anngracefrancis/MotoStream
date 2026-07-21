package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.InstallationDao;
import cm.aptoide.pt.database.room.RoomInstallation;
import cm.aptoide.pt.install.InstallationPersistence;
import java.util.List;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomInstallationPersistence implements InstallationPersistence {
    private InstallationDao installationDao;

    public RoomInstallationPersistence(InstallationDao installationDao) {
        this.installationDao = installationDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insert$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(RoomInstallation roomInstallation) {
        this.installationDao.insert(roomInstallation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insertAll$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(List list) {
        this.installationDao.insertAll(list);
    }

    @Override // cm.aptoide.pt.install.InstallationPersistence
    public rx.e<List<RoomInstallation>> getInstallationsHistory() {
        return g.a.a.a.d.b(this.installationDao.getAll(), h.a.a.BUFFER).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstallationPersistence
    public rx.b insert(final RoomInstallation roomInstallation) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.a0
            @Override // rx.m.a
            public final void call() {
                this.f4881f.a(roomInstallation);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.install.InstallationPersistence
    public rx.b insertAll(final List<RoomInstallation> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.b0
            @Override // rx.m.a
            public final void call() {
                this.f4886f.b(list);
            }
        }).K(Schedulers.io());
    }
}
