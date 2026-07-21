package cm.aptoide.pt.download;

import cm.aptoide.pt.ads.MinimalAdMapper;
import cm.aptoide.pt.database.RoomStoredMinimalAdPersistence;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomStoredMinimalAd;
import cm.aptoide.pt.dataprovider.ads.AdNetworkUtils;
import cm.aptoide.pt.downloadmanager.AptoideDownloadManager;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import cm.aptoide.pt.install.exception.InstallationException;
import cm.aptoide.pt.install.installer.DownloadInstallationAdapter;
import cm.aptoide.pt.install.installer.Installation;
import cm.aptoide.pt.install.installer.InstallationProvider;
import cm.aptoide.pt.logger.Logger;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class DownloadInstallationProvider implements InstallationProvider {
    private static final String TAG = "DownloadInstallationPro";
    private final MinimalAdMapper adMapper;
    private final AptoideInstalledAppsRepository aptoideInstalledAppsRepository;
    private final AptoideDownloadManager downloadManager;
    private final DownloadPersistence downloadPersistence;
    private final RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence;

    public DownloadInstallationProvider(AptoideDownloadManager aptoideDownloadManager, DownloadPersistence downloadPersistence, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, MinimalAdMapper minimalAdMapper, RoomStoredMinimalAdPersistence roomStoredMinimalAdPersistence) {
        this.downloadManager = aptoideDownloadManager;
        this.downloadPersistence = downloadPersistence;
        this.adMapper = minimalAdMapper;
        this.aptoideInstalledAppsRepository = aptoideInstalledAppsRepository;
        this.roomStoredMinimalAdPersistence = roomStoredMinimalAdPersistence;
    }

    private RoomInstalled convertDownloadToInstalled(RoomDownload roomDownload) {
        RoomInstalled roomInstalled = new RoomInstalled();
        roomInstalled.setPackageAndVersionCode(roomDownload.getPackageName() + roomDownload.getVersionCode());
        roomInstalled.setVersionCode(roomDownload.getVersionCode());
        roomInstalled.setVersionName(roomDownload.getVersionName());
        roomInstalled.setAppSize(Long.valueOf(roomDownload.getSize()));
        roomInstalled.setStatus(1);
        roomInstalled.setType(-1);
        roomInstalled.setPackageName(roomDownload.getPackageName());
        return roomInstalled;
    }

    private rx.m.b<RoomStoredMinimalAd> handleCpd() {
        return new rx.m.b() { // from class: cm.aptoide.pt.download.d
            @Override // rx.m.b
            public final void call(Object obj) {
                this.f5080f.d((RoomStoredMinimalAd) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getInstallation$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ DownloadInstallationAdapter a(RoomDownload roomDownload, RoomInstalled roomInstalled) {
        if (roomInstalled == null) {
            roomInstalled = convertDownloadToInstalled(roomDownload);
        }
        return new DownloadInstallationAdapter(roomDownload, this.downloadPersistence, this.aptoideInstalledAppsRepository, roomInstalled);
    }

    static /* synthetic */ void lambda$getInstallation$1(RoomStoredMinimalAd roomStoredMinimalAd) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getInstallation$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(DownloadInstallationAdapter downloadInstallationAdapter) {
        this.roomStoredMinimalAdPersistence.get(downloadInstallationAdapter.getPackageName()).x(handleCpd()).I0(Schedulers.io()).H0(new rx.m.b() { // from class: cm.aptoide.pt.download.b
            @Override // rx.m.b
            public final void call(Object obj) {
                DownloadInstallationProvider.lambda$getInstallation$1((RoomStoredMinimalAd) obj);
            }
        }, new rx.m.b() { // from class: cm.aptoide.pt.download.j
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getInstallation$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(final RoomDownload roomDownload) {
        if (roomDownload.getOverallDownloadStatus() == 1) {
            return this.aptoideInstalledAppsRepository.get(roomDownload.getPackageName(), roomDownload.getVersionCode()).X(new rx.m.e() { // from class: cm.aptoide.pt.download.a
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return this.f5076f.a(roomDownload, (RoomInstalled) obj);
                }
            }).x(new rx.m.b() { // from class: cm.aptoide.pt.download.e
                @Override // rx.m.b
                public final void call(Object obj) {
                    this.f5081f.b((DownloadInstallationAdapter) obj);
                }
            });
        }
        return rx.e.C(new InstallationException("Installation file not available. download is " + roomDownload.getMd5() + " and the state is : " + roomDownload.getOverallDownloadStatus()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$handleCpd$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(RoomStoredMinimalAd roomStoredMinimalAd) {
        if (roomStoredMinimalAd == null || roomStoredMinimalAd.getCpdUrl() == null) {
            return;
        }
        AdNetworkUtils.knockCpd(this.adMapper.map(roomStoredMinimalAd));
        roomStoredMinimalAd.setCpdUrl(null);
        this.roomStoredMinimalAdPersistence.insert(roomStoredMinimalAd);
    }

    @Override // cm.aptoide.pt.install.installer.InstallationProvider
    public rx.e<Installation> getInstallation(String str) {
        Logger.getInstance().d(TAG, "Getting the installation " + str);
        return this.downloadManager.getDownloadAsSingle(str).A().G(new rx.m.e() { // from class: cm.aptoide.pt.download.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5079f.c((RoomDownload) obj);
            }
        });
    }
}
