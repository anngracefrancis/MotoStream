package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.database.room.RoomFileToDownload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DownloadAppFileMapper {
    private DownloadAppFile.FileType mapFileType(int i2) {
        if (i2 == 0) {
            return DownloadAppFile.FileType.APK;
        }
        if (i2 == 1) {
            return DownloadAppFile.FileType.OBB;
        }
        if (i2 == 2) {
            return DownloadAppFile.FileType.GENERIC;
        }
        if (i2 == 3) {
            return DownloadAppFile.FileType.SPLIT;
        }
        throw new IllegalStateException("Invalid file type");
    }

    public List<DownloadAppFile> mapFileToDownloadList(List<RoomFileToDownload> list) {
        ArrayList arrayList = new ArrayList();
        for (RoomFileToDownload roomFileToDownload : list) {
            arrayList.add(new DownloadAppFile(roomFileToDownload.getLink(), roomFileToDownload.getAltLink(), roomFileToDownload.getMd5(), roomFileToDownload.getVersionCode(), roomFileToDownload.getPackageName(), roomFileToDownload.getFileName(), mapFileType(roomFileToDownload.getFileType())));
        }
        return arrayList;
    }
}
