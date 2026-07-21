package cm.aptoide.pt.database.room;

import androidx.room.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class AptoideDatabase extends j {
    static final int VERSION = 109;

    public abstract AppComingSoonRegistrationDAO appComingSoonRegistrationDAO();

    public abstract AptoideInstallDao aptoideInstallDao();

    public abstract DownloadDAO downloadDAO();

    public abstract EventDAO eventDAO();

    public abstract ExperimentDAO experimentDAO();

    public abstract InstallationDao installationDao();

    public abstract InstalledDao installedDao();

    public abstract LocalNotificationSyncDao localNotificationSyncDao();

    public abstract MigratedAppDAO migratedAppDAO();

    public abstract NotificationDao notificationDao();

    public abstract StoreDao storeDao();

    public abstract StoredMinimalAdDAO storeMinimalAdDAO();

    public abstract UpdateDao updateDao();
}
