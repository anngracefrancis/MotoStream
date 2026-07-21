package cm.aptoide.pt.app.migration;

import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class AppcMigrationManager {
    private static final long BDS_STORE_ID = 1966380;
    private AppcMigrationRepository appcMigrationRepository;
    private AptoideInstalledAppsRepository repository;

    public AppcMigrationManager(AptoideInstalledAppsRepository aptoideInstalledAppsRepository, AppcMigrationRepository appcMigrationRepository) {
        this.repository = aptoideInstalledAppsRepository;
        this.appcMigrationRepository = appcMigrationRepository;
    }

    public void addMigrationCandidate(String str) {
        this.appcMigrationRepository.addMigrationCandidate(str);
    }

    public e<Boolean> isAppMigrated(String str) {
        return this.appcMigrationRepository.isAppMigrated(str);
    }

    public e<Boolean> isMigrationApp(String str, final String str2, final int i2, final long j2, final boolean z) {
        return this.repository.getInstalled(str).X(new rx.m.e() { // from class: cm.aptoide.pt.app.migration.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                String str3 = str2;
                RoomInstalled roomInstalled = (RoomInstalled) obj;
                return Boolean.valueOf((roomInstalled == null || str3 == null || roomInstalled.getSignature() == null || str3.equals(roomInstalled.getSignature()) || roomInstalled.getVersionCode() > i2 || j2 != AppcMigrationManager.BDS_STORE_ID || !z) ? false : true);
            }
        });
    }

    public void persistCandidate(String str) {
        this.appcMigrationRepository.persistCandidate(str);
    }
}
