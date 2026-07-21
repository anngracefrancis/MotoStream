package cm.aptoide.pt.install.installer;

import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.database.room.RoomFileToDownload;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import cm.aptoide.pt.install.AptoideInstalledAppsRepository;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DownloadInstallationAdapter implements Installation {
    private final RoomDownload download;
    private DownloadPersistence downloadPersistence;
    private RoomInstalled installed;
    private AptoideInstalledAppsRepository ongoingInstallProvider;

    public DownloadInstallationAdapter(RoomDownload roomDownload, DownloadPersistence downloadPersistence, AptoideInstalledAppsRepository aptoideInstalledAppsRepository, RoomInstalled roomInstalled) {
        this.download = roomDownload;
        this.downloadPersistence = downloadPersistence;
        this.ongoingInstallProvider = aptoideInstalledAppsRepository;
        this.installed = roomInstalled;
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public File getFile() {
        return new File(this.download.getFilesToDownload().get(0).getFilePath());
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public List<RoomFileToDownload> getFiles() {
        return this.download.getFilesToDownload();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public String getId() {
        return this.download.getMd5();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public String getPackageName() {
        return this.download.getFilesToDownload().get(0).getPackageName();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public int getStatus() {
        return this.installed.getStatus();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public int getType() {
        return this.installed.getType();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public int getVersionCode() {
        return this.download.getFilesToDownload().get(0).getVersionCode();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public String getVersionName() {
        return this.download.getVersionName();
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public rx.b save() {
        return this.ongoingInstallProvider.save(this.installed);
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public rx.b saveFileChanges() {
        return this.downloadPersistence.save(this.download);
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public void setStatus(int i2) {
        this.installed.setStatus(i2);
    }

    @Override // cm.aptoide.pt.install.installer.Installation
    public void setType(int i2) {
        this.installed.setType(i2);
    }
}
