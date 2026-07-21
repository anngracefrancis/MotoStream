package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.database.room.RoomDownload;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadPersistence {
    rx.b delete(String str);

    rx.b delete(String str, int i2);

    rx.e<List<RoomDownload>> getAll();

    rx.e<List<RoomDownload>> getAsList(String str);

    rx.e<RoomDownload> getAsObservable(String str);

    Single<RoomDownload> getAsSingle(String str);

    rx.e<List<RoomDownload>> getInQueueSortedDownloads();

    rx.e<List<RoomDownload>> getOutOfSpaceDownloads();

    rx.e<List<RoomDownload>> getRunningDownloads();

    rx.b save(RoomDownload roomDownload);
}
