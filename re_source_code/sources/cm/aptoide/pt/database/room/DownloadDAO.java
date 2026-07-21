package cm.aptoide.pt.database.room;

import h.a.m;
import h.a.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadDAO {
    m<List<RoomDownload>> getAll();

    m<List<RoomDownload>> getAsList(String str);

    m<RoomDownload> getAsObservable(String str);

    s<RoomDownload> getAsSingle(String str);

    m<List<RoomDownload>> getInQueueSortedDownloads();

    m<List<RoomDownload>> getOutOfSpaceDownloads();

    m<List<RoomDownload>> getRunningDownloads();

    void insert(RoomDownload roomDownload);

    void insertAll(List<RoomDownload> list);

    void remove(String str);

    void remove(String str, int i2);
}
