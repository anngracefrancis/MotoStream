package cm.aptoide.pt.database;

import cm.aptoide.pt.app.migration.AppcMigrationPersistence;
import cm.aptoide.pt.database.room.MigratedAppDAO;
import cm.aptoide.pt.database.room.RoomMigratedApp;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomAppcMigrationPersistence implements AppcMigrationPersistence {
    private MigratedAppDAO migratedAppDAO;

    public RoomAppcMigrationPersistence(MigratedAppDAO migratedAppDAO) {
        this.migratedAppDAO = migratedAppDAO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insert$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str) {
        this.migratedAppDAO.save(new RoomMigratedApp(str));
    }

    @Override // cm.aptoide.pt.app.migration.AppcMigrationPersistence
    public void insert(final String str) {
        new Thread(new Runnable() { // from class: cm.aptoide.pt.database.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f4894f.a(str);
            }
        }).start();
    }

    @Override // cm.aptoide.pt.app.migration.AppcMigrationPersistence
    public rx.e<Boolean> isAppMigrated(String str) {
        return g.a.a.a.d.b(this.migratedAppDAO.isAppMigrated(str), h.a.a.BUFFER).X(new rx.m.e() { // from class: cm.aptoide.pt.database.e
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() > 0);
            }
        }).I0(Schedulers.io());
    }
}
