package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.database.room.RoomDownload;

/* JADX INFO: loaded from: classes.dex */
public class DownloadAppMapper {
    private DownloadAppFileMapper downloadAppFileMapper;

    public DownloadAppMapper(DownloadAppFileMapper downloadAppFileMapper) {
        this.downloadAppFileMapper = downloadAppFileMapper;
    }

    public DownloadApp mapDownload(RoomDownload roomDownload) {
        return new DownloadApp(roomDownload.getPackageName(), roomDownload.getVersionCode(), this.downloadAppFileMapper.mapFileToDownloadList(roomDownload.getFilesToDownload()), roomDownload.getMd5(), roomDownload.getSize(), roomDownload.getAttributionId());
    }
}
