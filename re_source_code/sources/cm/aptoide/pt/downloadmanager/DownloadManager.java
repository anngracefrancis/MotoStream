package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.database.room.RoomDownload;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadManager {
    rx.b cancelDownload(String str);

    rx.e<List<RoomDownload>> getCurrentActiveDownloads();

    rx.e<RoomDownload> getCurrentInProgressDownload();

    rx.e<RoomDownload> getDownloadAsObservable(String str);

    Single<RoomDownload> getDownloadAsSingle(String str);

    rx.e<RoomDownload> getDownloadsByMd5(String str);

    rx.e<List<RoomDownload>> getDownloadsList();

    rx.b invalidateDatabase();

    rx.b pauseAllDownloads();

    rx.b pauseDownload(String str);

    void start();

    rx.b startDownload(RoomDownload roomDownload);

    void stop();
}
