package cm.aptoide.pt.database.room;

import androidx.room.a;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import c.u.a.b;
import c.u.a.c;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.account.AccountAnalytics;
import cm.aptoide.pt.download.DownloadAnalytics;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class AptoideDatabase_Impl extends AptoideDatabase {
    private volatile AppComingSoonRegistrationDAO _appComingSoonRegistrationDAO;
    private volatile AptoideInstallDao _aptoideInstallDao;
    private volatile DownloadDAO _downloadDAO;
    private volatile EventDAO _eventDAO;
    private volatile ExperimentDAO _experimentDAO;
    private volatile InstallationDao _installationDao;
    private volatile InstalledDao _installedDao;
    private volatile LocalNotificationSyncDao _localNotificationSyncDao;
    private volatile MigratedAppDAO _migratedAppDAO;
    private volatile NotificationDao _notificationDao;
    private volatile StoreDao _storeDao;
    private volatile StoredMinimalAdDAO _storedMinimalAdDAO;
    private volatile UpdateDao _updateDao;

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public AppComingSoonRegistrationDAO appComingSoonRegistrationDAO() {
        AppComingSoonRegistrationDAO appComingSoonRegistrationDAO;
        if (this._appComingSoonRegistrationDAO != null) {
            return this._appComingSoonRegistrationDAO;
        }
        synchronized (this) {
            if (this._appComingSoonRegistrationDAO == null) {
                this._appComingSoonRegistrationDAO = new AppComingSoonRegistrationDAO_Impl(this);
            }
            appComingSoonRegistrationDAO = this._appComingSoonRegistrationDAO;
        }
        return appComingSoonRegistrationDAO;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public AptoideInstallDao aptoideInstallDao() {
        AptoideInstallDao aptoideInstallDao;
        if (this._aptoideInstallDao != null) {
            return this._aptoideInstallDao;
        }
        synchronized (this) {
            if (this._aptoideInstallDao == null) {
                this._aptoideInstallDao = new AptoideInstallDao_Impl(this);
            }
            aptoideInstallDao = this._aptoideInstallDao;
        }
        return aptoideInstallDao;
    }

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        b bVarS0 = super.getOpenHelper().s0();
        try {
            super.beginTransaction();
            bVarS0.v("DELETE FROM `event`");
            bVarS0.v("DELETE FROM `experiment`");
            bVarS0.v("DELETE FROM `storedMinimalAd`");
            bVarS0.v("DELETE FROM `notification`");
            bVarS0.v("DELETE FROM `localNotificationSync`");
            bVarS0.v("DELETE FROM `installed`");
            bVarS0.v("DELETE FROM `installation`");
            bVarS0.v("DELETE FROM `migratedapp`");
            bVarS0.v("DELETE FROM `update`");
            bVarS0.v("DELETE FROM `download`");
            bVarS0.v("DELETE FROM `store`");
            bVarS0.v("DELETE FROM `aptoideinstallapp`");
            bVarS0.v("DELETE FROM `appComingSoonRegistration`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            bVarS0.u0("PRAGMA wal_checkpoint(FULL)").close();
            if (!bVarS0.P0()) {
                bVarS0.v("VACUUM");
            }
        }
    }

    @Override // androidx.room.j
    protected g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), "event", "experiment", "storedMinimalAd", "notification", "localNotificationSync", "installed", "installation", "migratedapp", "update", DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, AccountAnalytics.STORE, "aptoideinstallapp", "appComingSoonRegistration");
    }

    @Override // androidx.room.j
    protected c createOpenHelper(a aVar) {
        return aVar.a.a(c.b.a(aVar.f2117b).c(aVar.f2118c).b(new l(aVar, new l.a(109) { // from class: cm.aptoide.pt.database.room.AptoideDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(b bVar) {
                bVar.v("CREATE TABLE IF NOT EXISTS `event` (`timestamp` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `eventName` TEXT, `action` INTEGER NOT NULL, `context` TEXT, `data` TEXT)");
                bVar.v("CREATE TABLE IF NOT EXISTS `experiment` (`experimentName` TEXT NOT NULL, `requestTime` INTEGER NOT NULL, `assignment` TEXT, `payload` TEXT, `partOfExperiment` INTEGER NOT NULL, `experimentOver` INTEGER NOT NULL, PRIMARY KEY(`experimentName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `storedMinimalAd` (`packageName` TEXT NOT NULL, `referrer` TEXT, `cpcUrl` TEXT, `cpdUrl` TEXT, `cpiUrl` TEXT, `timestamp` INTEGER, `adId` INTEGER, PRIMARY KEY(`packageName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `notification` (`expire` INTEGER, `abTestingGroup` TEXT, `body` TEXT, `campaignId` INTEGER NOT NULL, `img` TEXT, `lang` TEXT, `title` TEXT, `url` TEXT, `urlTrack` TEXT, `notificationCenterUrlTrack` TEXT, `type` INTEGER NOT NULL, `timeStamp` INTEGER NOT NULL, `appName` TEXT, `graphic` TEXT, `ownerId` TEXT, `processed` INTEGER NOT NULL, `actionStringRes` INTEGER NOT NULL, `whitelistedPackages` TEXT, `key` TEXT NOT NULL, `dismissed` INTEGER NOT NULL, PRIMARY KEY(`key`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `localNotificationSync` (`notificationId` TEXT NOT NULL, `title` TEXT, `body` TEXT, `image` TEXT, `navigationUrl` TEXT, `trigger` INTEGER NOT NULL, `id` TEXT, `actionStringRes` INTEGER NOT NULL, `type` INTEGER NOT NULL, PRIMARY KEY(`notificationId`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `installed` (`packageAndVersionCode` TEXT NOT NULL, `icon` TEXT, `packageName` TEXT, `name` TEXT, `versionCode` INTEGER NOT NULL, `versionName` TEXT, `signature` TEXT, `systemApp` INTEGER NOT NULL, `storeName` TEXT, `status` INTEGER NOT NULL, `type` INTEGER NOT NULL, `enabled` INTEGER NOT NULL, `appSize` INTEGER NOT NULL, PRIMARY KEY(`packageAndVersionCode`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `installation` (`packageName` TEXT NOT NULL, `icon` TEXT, `name` TEXT, `versionCode` INTEGER NOT NULL, `versionName` TEXT, PRIMARY KEY(`packageName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `migratedapp` (`packageName` TEXT NOT NULL, PRIMARY KEY(`packageName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `update` (`packageName` TEXT NOT NULL, `appId` INTEGER NOT NULL, `label` TEXT, `icon` TEXT, `md5` TEXT, `apkPath` TEXT, `size` INTEGER NOT NULL, `updateVersionName` TEXT, `updateVersionCode` INTEGER NOT NULL, `excluded` INTEGER NOT NULL, `trustedBadge` TEXT, `alternativeApkPath` TEXT, `storeName` TEXT, `mainObbName` TEXT, `mainObbPath` TEXT, `mainObbMd5` TEXT, `patchObbName` TEXT, `patchObbPath` TEXT, `patchObbMd5` TEXT, `roomSplits` TEXT, `requiredSplits` TEXT, `hasAppc` INTEGER NOT NULL, `downloadCampaigns` TEXT, PRIMARY KEY(`packageName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `download` (`filesToDownload` TEXT, `overallDownloadStatus` INTEGER NOT NULL, `overallProgress` INTEGER NOT NULL, `md5` TEXT NOT NULL, `appName` TEXT, `Icon` TEXT, `timeStamp` INTEGER NOT NULL, `packageName` TEXT, `versionCode` INTEGER NOT NULL, `action` INTEGER NOT NULL, `versionName` TEXT, `hasAppc` INTEGER NOT NULL, `size` INTEGER NOT NULL, `storeName` TEXT, `trustedBadge` TEXT, `downloadError` INTEGER NOT NULL, `attributionId` TEXT, `averageApkDownloadSpeed` INTEGER NOT NULL, `averageObbDownloadSpeed` INTEGER NOT NULL, `averageSplitsDownloadSpeed` INTEGER NOT NULL, PRIMARY KEY(`md5`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `store` (`storeId` INTEGER NOT NULL, `iconPath` TEXT, `theme` TEXT, `downloads` INTEGER NOT NULL, `storeName` TEXT, `username` TEXT, `passwordSha1` TEXT, PRIMARY KEY(`storeId`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `aptoideinstallapp` (`packageName` TEXT NOT NULL, PRIMARY KEY(`packageName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS `appComingSoonRegistration` (`packageName` TEXT NOT NULL, PRIMARY KEY(`packageName`))");
                bVar.v("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.v("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7e316c0a1665c11b439c50fb81744638')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(b bVar) {
                bVar.v("DROP TABLE IF EXISTS `event`");
                bVar.v("DROP TABLE IF EXISTS `experiment`");
                bVar.v("DROP TABLE IF EXISTS `storedMinimalAd`");
                bVar.v("DROP TABLE IF EXISTS `notification`");
                bVar.v("DROP TABLE IF EXISTS `localNotificationSync`");
                bVar.v("DROP TABLE IF EXISTS `installed`");
                bVar.v("DROP TABLE IF EXISTS `installation`");
                bVar.v("DROP TABLE IF EXISTS `migratedapp`");
                bVar.v("DROP TABLE IF EXISTS `update`");
                bVar.v("DROP TABLE IF EXISTS `download`");
                bVar.v("DROP TABLE IF EXISTS `store`");
                bVar.v("DROP TABLE IF EXISTS `aptoideinstallapp`");
                bVar.v("DROP TABLE IF EXISTS `appComingSoonRegistration`");
                if (((j) AptoideDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) AptoideDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) AptoideDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(b bVar) {
                if (((j) AptoideDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) AptoideDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) AptoideDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(b bVar) {
                ((j) AptoideDatabase_Impl.this).mDatabase = bVar;
                AptoideDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((j) AptoideDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) AptoideDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) AptoideDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onPostMigrate(b bVar) {
            }

            @Override // androidx.room.l.a
            public void onPreMigrate(b bVar) {
                androidx.room.t.c.a(bVar);
            }

            @Override // androidx.room.l.a
            protected l.b onValidateSchema(b bVar) {
                HashMap map = new HashMap(5);
                map.put("timestamp", new androidx.room.t.g.a("timestamp", "INTEGER", true, 1, null, 1));
                map.put("eventName", new androidx.room.t.g.a("eventName", "TEXT", false, 0, null, 1));
                map.put("action", new androidx.room.t.g.a("action", "INTEGER", true, 0, null, 1));
                map.put("context", new androidx.room.t.g.a("context", "TEXT", false, 0, null, 1));
                map.put("data", new androidx.room.t.g.a("data", "TEXT", false, 0, null, 1));
                androidx.room.t.g gVar = new androidx.room.t.g("event", map, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA = androidx.room.t.g.a(bVar, "event");
                if (!gVar.equals(gVarA)) {
                    return new l.b(false, "event(cm.aptoide.pt.database.room.RoomEvent).\n Expected:\n" + gVar + "\n Found:\n" + gVarA);
                }
                HashMap map2 = new HashMap(6);
                map2.put("experimentName", new androidx.room.t.g.a("experimentName", "TEXT", true, 1, null, 1));
                map2.put("requestTime", new androidx.room.t.g.a("requestTime", "INTEGER", true, 0, null, 1));
                map2.put("assignment", new androidx.room.t.g.a("assignment", "TEXT", false, 0, null, 1));
                map2.put("payload", new androidx.room.t.g.a("payload", "TEXT", false, 0, null, 1));
                map2.put("partOfExperiment", new androidx.room.t.g.a("partOfExperiment", "INTEGER", true, 0, null, 1));
                map2.put("experimentOver", new androidx.room.t.g.a("experimentOver", "INTEGER", true, 0, null, 1));
                androidx.room.t.g gVar2 = new androidx.room.t.g("experiment", map2, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA2 = androidx.room.t.g.a(bVar, "experiment");
                if (!gVar2.equals(gVarA2)) {
                    return new l.b(false, "experiment(cm.aptoide.pt.database.room.RoomExperiment).\n Expected:\n" + gVar2 + "\n Found:\n" + gVarA2);
                }
                HashMap map3 = new HashMap(7);
                map3.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", true, 1, null, 1));
                map3.put("referrer", new androidx.room.t.g.a("referrer", "TEXT", false, 0, null, 1));
                map3.put("cpcUrl", new androidx.room.t.g.a("cpcUrl", "TEXT", false, 0, null, 1));
                map3.put("cpdUrl", new androidx.room.t.g.a("cpdUrl", "TEXT", false, 0, null, 1));
                map3.put("cpiUrl", new androidx.room.t.g.a("cpiUrl", "TEXT", false, 0, null, 1));
                map3.put("timestamp", new androidx.room.t.g.a("timestamp", "INTEGER", false, 0, null, 1));
                map3.put("adId", new androidx.room.t.g.a("adId", "INTEGER", false, 0, null, 1));
                androidx.room.t.g gVar3 = new androidx.room.t.g("storedMinimalAd", map3, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA3 = androidx.room.t.g.a(bVar, "storedMinimalAd");
                if (!gVar3.equals(gVarA3)) {
                    return new l.b(false, "storedMinimalAd(cm.aptoide.pt.database.room.RoomStoredMinimalAd).\n Expected:\n" + gVar3 + "\n Found:\n" + gVarA3);
                }
                HashMap map4 = new HashMap(20);
                map4.put("expire", new androidx.room.t.g.a("expire", "INTEGER", false, 0, null, 1));
                map4.put("abTestingGroup", new androidx.room.t.g.a("abTestingGroup", "TEXT", false, 0, null, 1));
                map4.put("body", new androidx.room.t.g.a("body", "TEXT", false, 0, null, 1));
                map4.put("campaignId", new androidx.room.t.g.a("campaignId", "INTEGER", true, 0, null, 1));
                map4.put("img", new androidx.room.t.g.a("img", "TEXT", false, 0, null, 1));
                map4.put("lang", new androidx.room.t.g.a("lang", "TEXT", false, 0, null, 1));
                map4.put("title", new androidx.room.t.g.a("title", "TEXT", false, 0, null, 1));
                map4.put("url", new androidx.room.t.g.a("url", "TEXT", false, 0, null, 1));
                map4.put("urlTrack", new androidx.room.t.g.a("urlTrack", "TEXT", false, 0, null, 1));
                map4.put("notificationCenterUrlTrack", new androidx.room.t.g.a("notificationCenterUrlTrack", "TEXT", false, 0, null, 1));
                map4.put("type", new androidx.room.t.g.a("type", "INTEGER", true, 0, null, 1));
                map4.put("timeStamp", new androidx.room.t.g.a("timeStamp", "INTEGER", true, 0, null, 1));
                map4.put("appName", new androidx.room.t.g.a("appName", "TEXT", false, 0, null, 1));
                map4.put("graphic", new androidx.room.t.g.a("graphic", "TEXT", false, 0, null, 1));
                map4.put("ownerId", new androidx.room.t.g.a("ownerId", "TEXT", false, 0, null, 1));
                map4.put("processed", new androidx.room.t.g.a("processed", "INTEGER", true, 0, null, 1));
                map4.put("actionStringRes", new androidx.room.t.g.a("actionStringRes", "INTEGER", true, 0, null, 1));
                map4.put("whitelistedPackages", new androidx.room.t.g.a("whitelistedPackages", "TEXT", false, 0, null, 1));
                map4.put(RoomNotification.KEY, new androidx.room.t.g.a(RoomNotification.KEY, "TEXT", true, 1, null, 1));
                map4.put("dismissed", new androidx.room.t.g.a("dismissed", "INTEGER", true, 0, null, 1));
                androidx.room.t.g gVar4 = new androidx.room.t.g("notification", map4, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA4 = androidx.room.t.g.a(bVar, "notification");
                if (!gVar4.equals(gVarA4)) {
                    return new l.b(false, "notification(cm.aptoide.pt.database.room.RoomNotification).\n Expected:\n" + gVar4 + "\n Found:\n" + gVarA4);
                }
                HashMap map5 = new HashMap(9);
                map5.put("notificationId", new androidx.room.t.g.a("notificationId", "TEXT", true, 1, null, 1));
                map5.put("title", new androidx.room.t.g.a("title", "TEXT", false, 0, null, 1));
                map5.put("body", new androidx.room.t.g.a("body", "TEXT", false, 0, null, 1));
                map5.put("image", new androidx.room.t.g.a("image", "TEXT", false, 0, null, 1));
                map5.put("navigationUrl", new androidx.room.t.g.a("navigationUrl", "TEXT", false, 0, null, 1));
                map5.put("trigger", new androidx.room.t.g.a("trigger", "INTEGER", true, 0, null, 1));
                map5.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, new androidx.room.t.g.a(DeepLinkIntentReceiver.DeepLinksKeys.ID, "TEXT", false, 0, null, 1));
                map5.put("actionStringRes", new androidx.room.t.g.a("actionStringRes", "INTEGER", true, 0, null, 1));
                map5.put("type", new androidx.room.t.g.a("type", "INTEGER", true, 0, null, 1));
                androidx.room.t.g gVar5 = new androidx.room.t.g("localNotificationSync", map5, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA5 = androidx.room.t.g.a(bVar, "localNotificationSync");
                if (!gVar5.equals(gVarA5)) {
                    return new l.b(false, "localNotificationSync(cm.aptoide.pt.database.room.RoomLocalNotificationSync).\n Expected:\n" + gVar5 + "\n Found:\n" + gVarA5);
                }
                HashMap map6 = new HashMap(13);
                map6.put("packageAndVersionCode", new androidx.room.t.g.a("packageAndVersionCode", "TEXT", true, 1, null, 1));
                map6.put(RoomInstalled.ICON, new androidx.room.t.g.a(RoomInstalled.ICON, "TEXT", false, 0, null, 1));
                map6.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", false, 0, null, 1));
                map6.put("name", new androidx.room.t.g.a("name", "TEXT", false, 0, null, 1));
                map6.put(RoomInstalled.VERSION_CODE, new androidx.room.t.g.a(RoomInstalled.VERSION_CODE, "INTEGER", true, 0, null, 1));
                map6.put(RoomInstalled.VERSION_NAME, new androidx.room.t.g.a(RoomInstalled.VERSION_NAME, "TEXT", false, 0, null, 1));
                map6.put(RoomInstalled.SIGNATURE, new androidx.room.t.g.a(RoomInstalled.SIGNATURE, "TEXT", false, 0, null, 1));
                map6.put("systemApp", new androidx.room.t.g.a("systemApp", "INTEGER", true, 0, null, 1));
                map6.put("storeName", new androidx.room.t.g.a("storeName", "TEXT", false, 0, null, 1));
                map6.put("status", new androidx.room.t.g.a("status", "INTEGER", true, 0, null, 1));
                map6.put("type", new androidx.room.t.g.a("type", "INTEGER", true, 0, null, 1));
                map6.put("enabled", new androidx.room.t.g.a("enabled", "INTEGER", true, 0, null, 1));
                map6.put("appSize", new androidx.room.t.g.a("appSize", "INTEGER", true, 0, null, 1));
                androidx.room.t.g gVar6 = new androidx.room.t.g("installed", map6, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA6 = androidx.room.t.g.a(bVar, "installed");
                if (!gVar6.equals(gVarA6)) {
                    return new l.b(false, "installed(cm.aptoide.pt.database.room.RoomInstalled).\n Expected:\n" + gVar6 + "\n Found:\n" + gVarA6);
                }
                HashMap map7 = new HashMap(5);
                map7.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", true, 1, null, 1));
                map7.put(RoomInstalled.ICON, new androidx.room.t.g.a(RoomInstalled.ICON, "TEXT", false, 0, null, 1));
                map7.put("name", new androidx.room.t.g.a("name", "TEXT", false, 0, null, 1));
                map7.put(RoomInstalled.VERSION_CODE, new androidx.room.t.g.a(RoomInstalled.VERSION_CODE, "INTEGER", true, 0, null, 1));
                map7.put(RoomInstalled.VERSION_NAME, new androidx.room.t.g.a(RoomInstalled.VERSION_NAME, "TEXT", false, 0, null, 1));
                androidx.room.t.g gVar7 = new androidx.room.t.g("installation", map7, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA7 = androidx.room.t.g.a(bVar, "installation");
                if (!gVar7.equals(gVarA7)) {
                    return new l.b(false, "installation(cm.aptoide.pt.database.room.RoomInstallation).\n Expected:\n" + gVar7 + "\n Found:\n" + gVarA7);
                }
                HashMap map8 = new HashMap(1);
                map8.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", true, 1, null, 1));
                androidx.room.t.g gVar8 = new androidx.room.t.g("migratedapp", map8, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA8 = androidx.room.t.g.a(bVar, "migratedapp");
                if (!gVar8.equals(gVarA8)) {
                    return new l.b(false, "migratedapp(cm.aptoide.pt.database.room.RoomMigratedApp).\n Expected:\n" + gVar8 + "\n Found:\n" + gVarA8);
                }
                HashMap map9 = new HashMap(23);
                map9.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", true, 1, null, 1));
                map9.put("appId", new androidx.room.t.g.a("appId", "INTEGER", true, 0, null, 1));
                map9.put("label", new androidx.room.t.g.a("label", "TEXT", false, 0, null, 1));
                map9.put(RoomInstalled.ICON, new androidx.room.t.g.a(RoomInstalled.ICON, "TEXT", false, 0, null, 1));
                map9.put("md5", new androidx.room.t.g.a("md5", "TEXT", false, 0, null, 1));
                map9.put("apkPath", new androidx.room.t.g.a("apkPath", "TEXT", false, 0, null, 1));
                map9.put("size", new androidx.room.t.g.a("size", "INTEGER", true, 0, null, 1));
                map9.put("updateVersionName", new androidx.room.t.g.a("updateVersionName", "TEXT", false, 0, null, 1));
                map9.put("updateVersionCode", new androidx.room.t.g.a("updateVersionCode", "INTEGER", true, 0, null, 1));
                map9.put("excluded", new androidx.room.t.g.a("excluded", "INTEGER", true, 0, null, 1));
                map9.put("trustedBadge", new androidx.room.t.g.a("trustedBadge", "TEXT", false, 0, null, 1));
                map9.put("alternativeApkPath", new androidx.room.t.g.a("alternativeApkPath", "TEXT", false, 0, null, 1));
                map9.put("storeName", new androidx.room.t.g.a("storeName", "TEXT", false, 0, null, 1));
                map9.put("mainObbName", new androidx.room.t.g.a("mainObbName", "TEXT", false, 0, null, 1));
                map9.put("mainObbPath", new androidx.room.t.g.a("mainObbPath", "TEXT", false, 0, null, 1));
                map9.put("mainObbMd5", new androidx.room.t.g.a("mainObbMd5", "TEXT", false, 0, null, 1));
                map9.put("patchObbName", new androidx.room.t.g.a("patchObbName", "TEXT", false, 0, null, 1));
                map9.put("patchObbPath", new androidx.room.t.g.a("patchObbPath", "TEXT", false, 0, null, 1));
                map9.put("patchObbMd5", new androidx.room.t.g.a("patchObbMd5", "TEXT", false, 0, null, 1));
                map9.put("roomSplits", new androidx.room.t.g.a("roomSplits", "TEXT", false, 0, null, 1));
                map9.put("requiredSplits", new androidx.room.t.g.a("requiredSplits", "TEXT", false, 0, null, 1));
                map9.put("hasAppc", new androidx.room.t.g.a("hasAppc", "INTEGER", true, 0, null, 1));
                map9.put("downloadCampaigns", new androidx.room.t.g.a("downloadCampaigns", "TEXT", false, 0, null, 1));
                androidx.room.t.g gVar9 = new androidx.room.t.g("update", map9, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA9 = androidx.room.t.g.a(bVar, "update");
                if (!gVar9.equals(gVarA9)) {
                    return new l.b(false, "update(cm.aptoide.pt.database.room.RoomUpdate).\n Expected:\n" + gVar9 + "\n Found:\n" + gVarA9);
                }
                HashMap map10 = new HashMap(20);
                map10.put("filesToDownload", new androidx.room.t.g.a("filesToDownload", "TEXT", false, 0, null, 1));
                map10.put("overallDownloadStatus", new androidx.room.t.g.a("overallDownloadStatus", "INTEGER", true, 0, null, 1));
                map10.put("overallProgress", new androidx.room.t.g.a("overallProgress", "INTEGER", true, 0, null, 1));
                map10.put("md5", new androidx.room.t.g.a("md5", "TEXT", true, 1, null, 1));
                map10.put("appName", new androidx.room.t.g.a("appName", "TEXT", false, 0, null, 1));
                map10.put("Icon", new androidx.room.t.g.a("Icon", "TEXT", false, 0, null, 1));
                map10.put("timeStamp", new androidx.room.t.g.a("timeStamp", "INTEGER", true, 0, null, 1));
                map10.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", false, 0, null, 1));
                map10.put(RoomInstalled.VERSION_CODE, new androidx.room.t.g.a(RoomInstalled.VERSION_CODE, "INTEGER", true, 0, null, 1));
                map10.put("action", new androidx.room.t.g.a("action", "INTEGER", true, 0, null, 1));
                map10.put(RoomInstalled.VERSION_NAME, new androidx.room.t.g.a(RoomInstalled.VERSION_NAME, "TEXT", false, 0, null, 1));
                map10.put("hasAppc", new androidx.room.t.g.a("hasAppc", "INTEGER", true, 0, null, 1));
                map10.put("size", new androidx.room.t.g.a("size", "INTEGER", true, 0, null, 1));
                map10.put("storeName", new androidx.room.t.g.a("storeName", "TEXT", false, 0, null, 1));
                map10.put("trustedBadge", new androidx.room.t.g.a("trustedBadge", "TEXT", false, 0, null, 1));
                map10.put("downloadError", new androidx.room.t.g.a("downloadError", "INTEGER", true, 0, null, 1));
                map10.put("attributionId", new androidx.room.t.g.a("attributionId", "TEXT", false, 0, null, 1));
                map10.put("averageApkDownloadSpeed", new androidx.room.t.g.a("averageApkDownloadSpeed", "INTEGER", true, 0, null, 1));
                map10.put("averageObbDownloadSpeed", new androidx.room.t.g.a("averageObbDownloadSpeed", "INTEGER", true, 0, null, 1));
                map10.put("averageSplitsDownloadSpeed", new androidx.room.t.g.a("averageSplitsDownloadSpeed", "INTEGER", true, 0, null, 1));
                androidx.room.t.g gVar10 = new androidx.room.t.g(DownloadAnalytics.RAKAM_DOWNLOAD_EVENT, map10, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA10 = androidx.room.t.g.a(bVar, DownloadAnalytics.RAKAM_DOWNLOAD_EVENT);
                if (!gVar10.equals(gVarA10)) {
                    return new l.b(false, "download(cm.aptoide.pt.database.room.RoomDownload).\n Expected:\n" + gVar10 + "\n Found:\n" + gVarA10);
                }
                HashMap map11 = new HashMap(7);
                map11.put(RoomStore.STORE_ID, new androidx.room.t.g.a(RoomStore.STORE_ID, "INTEGER", true, 1, null, 1));
                map11.put(RoomStore.ICON_PATH, new androidx.room.t.g.a(RoomStore.ICON_PATH, "TEXT", false, 0, null, 1));
                map11.put(RoomStore.THEME, new androidx.room.t.g.a(RoomStore.THEME, "TEXT", false, 0, null, 1));
                map11.put(RoomStore.DOWNLOADS, new androidx.room.t.g.a(RoomStore.DOWNLOADS, "INTEGER", true, 0, null, 1));
                map11.put("storeName", new androidx.room.t.g.a("storeName", "TEXT", false, 0, null, 1));
                map11.put("username", new androidx.room.t.g.a("username", "TEXT", false, 0, null, 1));
                map11.put(RoomStore.PASSWORD_SHA1, new androidx.room.t.g.a(RoomStore.PASSWORD_SHA1, "TEXT", false, 0, null, 1));
                androidx.room.t.g gVar11 = new androidx.room.t.g(AccountAnalytics.STORE, map11, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA11 = androidx.room.t.g.a(bVar, AccountAnalytics.STORE);
                if (!gVar11.equals(gVarA11)) {
                    return new l.b(false, "store(cm.aptoide.pt.database.room.RoomStore).\n Expected:\n" + gVar11 + "\n Found:\n" + gVarA11);
                }
                HashMap map12 = new HashMap(1);
                map12.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", true, 1, null, 1));
                androidx.room.t.g gVar12 = new androidx.room.t.g("aptoideinstallapp", map12, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA12 = androidx.room.t.g.a(bVar, "aptoideinstallapp");
                if (!gVar12.equals(gVarA12)) {
                    return new l.b(false, "aptoideinstallapp(cm.aptoide.pt.database.room.RoomAptoideInstallApp).\n Expected:\n" + gVar12 + "\n Found:\n" + gVarA12);
                }
                HashMap map13 = new HashMap(1);
                map13.put("packageName", new androidx.room.t.g.a("packageName", "TEXT", true, 1, null, 1));
                androidx.room.t.g gVar13 = new androidx.room.t.g("appComingSoonRegistration", map13, new HashSet(0), new HashSet(0));
                androidx.room.t.g gVarA13 = androidx.room.t.g.a(bVar, "appComingSoonRegistration");
                if (gVar13.equals(gVarA13)) {
                    return new l.b(true, null);
                }
                return new l.b(false, "appComingSoonRegistration(cm.aptoide.pt.database.room.RoomAppComingSoonRegistration).\n Expected:\n" + gVar13 + "\n Found:\n" + gVarA13);
            }
        }, "7e316c0a1665c11b439c50fb81744638", "d37fe27d97b8305241dccf817ceb2c1d")).a());
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public DownloadDAO downloadDAO() {
        DownloadDAO downloadDAO;
        if (this._downloadDAO != null) {
            return this._downloadDAO;
        }
        synchronized (this) {
            if (this._downloadDAO == null) {
                this._downloadDAO = new DownloadDAO_Impl(this);
            }
            downloadDAO = this._downloadDAO;
        }
        return downloadDAO;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public EventDAO eventDAO() {
        EventDAO eventDAO;
        if (this._eventDAO != null) {
            return this._eventDAO;
        }
        synchronized (this) {
            if (this._eventDAO == null) {
                this._eventDAO = new EventDAO_Impl(this);
            }
            eventDAO = this._eventDAO;
        }
        return eventDAO;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public ExperimentDAO experimentDAO() {
        ExperimentDAO experimentDAO;
        if (this._experimentDAO != null) {
            return this._experimentDAO;
        }
        synchronized (this) {
            if (this._experimentDAO == null) {
                this._experimentDAO = new ExperimentDAO_Impl(this);
            }
            experimentDAO = this._experimentDAO;
        }
        return experimentDAO;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public InstallationDao installationDao() {
        InstallationDao installationDao;
        if (this._installationDao != null) {
            return this._installationDao;
        }
        synchronized (this) {
            if (this._installationDao == null) {
                this._installationDao = new InstallationDao_Impl(this);
            }
            installationDao = this._installationDao;
        }
        return installationDao;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public InstalledDao installedDao() {
        InstalledDao installedDao;
        if (this._installedDao != null) {
            return this._installedDao;
        }
        synchronized (this) {
            if (this._installedDao == null) {
                this._installedDao = new InstalledDao_Impl(this);
            }
            installedDao = this._installedDao;
        }
        return installedDao;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public LocalNotificationSyncDao localNotificationSyncDao() {
        LocalNotificationSyncDao localNotificationSyncDao;
        if (this._localNotificationSyncDao != null) {
            return this._localNotificationSyncDao;
        }
        synchronized (this) {
            if (this._localNotificationSyncDao == null) {
                this._localNotificationSyncDao = new LocalNotificationSyncDao_Impl(this);
            }
            localNotificationSyncDao = this._localNotificationSyncDao;
        }
        return localNotificationSyncDao;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public MigratedAppDAO migratedAppDAO() {
        MigratedAppDAO migratedAppDAO;
        if (this._migratedAppDAO != null) {
            return this._migratedAppDAO;
        }
        synchronized (this) {
            if (this._migratedAppDAO == null) {
                this._migratedAppDAO = new MigratedAppDAO_Impl(this);
            }
            migratedAppDAO = this._migratedAppDAO;
        }
        return migratedAppDAO;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public NotificationDao notificationDao() {
        NotificationDao notificationDao;
        if (this._notificationDao != null) {
            return this._notificationDao;
        }
        synchronized (this) {
            if (this._notificationDao == null) {
                this._notificationDao = new NotificationDao_Impl(this);
            }
            notificationDao = this._notificationDao;
        }
        return notificationDao;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public StoreDao storeDao() {
        StoreDao storeDao;
        if (this._storeDao != null) {
            return this._storeDao;
        }
        synchronized (this) {
            if (this._storeDao == null) {
                this._storeDao = new StoreDao_Impl(this);
            }
            storeDao = this._storeDao;
        }
        return storeDao;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public StoredMinimalAdDAO storeMinimalAdDAO() {
        StoredMinimalAdDAO storedMinimalAdDAO;
        if (this._storedMinimalAdDAO != null) {
            return this._storedMinimalAdDAO;
        }
        synchronized (this) {
            if (this._storedMinimalAdDAO == null) {
                this._storedMinimalAdDAO = new StoredMinimalAdDAO_Impl(this);
            }
            storedMinimalAdDAO = this._storedMinimalAdDAO;
        }
        return storedMinimalAdDAO;
    }

    @Override // cm.aptoide.pt.database.room.AptoideDatabase
    public UpdateDao updateDao() {
        UpdateDao updateDao;
        if (this._updateDao != null) {
            return this._updateDao;
        }
        synchronized (this) {
            if (this._updateDao == null) {
                this._updateDao = new UpdateDao_Impl(this);
            }
            updateDao = this._updateDao;
        }
        return updateDao;
    }
}
