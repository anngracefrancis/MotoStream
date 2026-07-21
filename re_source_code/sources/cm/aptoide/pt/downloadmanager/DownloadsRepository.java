package cm.aptoide.pt.downloadmanager;

import cm.aptoide.pt.database.room.RoomDownload;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class DownloadsRepository {
    private final DownloadPersistence downloadPersistence;

    public DownloadsRepository(DownloadPersistence downloadPersistence) {
        this.downloadPersistence = downloadPersistence;
    }

    public rx.e<List<RoomDownload>> getAllDownloads() {
        return this.downloadPersistence.getAll();
    }

    public rx.e<List<RoomDownload>> getCurrentActiveDownloads() {
        return this.downloadPersistence.getRunningDownloads();
    }

    public rx.e<RoomDownload> getDownloadAsObservable(String str) {
        return this.downloadPersistence.getAsObservable(str);
    }

    public Single<RoomDownload> getDownloadAsSingle(String str) {
        return this.downloadPersistence.getAsSingle(str);
    }

    public rx.e<List<RoomDownload>> getDownloadListByMd5(String str) {
        return this.downloadPersistence.getAsList(str);
    }

    public rx.e<List<RoomDownload>> getDownloadsInProgress() {
        return this.downloadPersistence.getRunningDownloads();
    }

    public rx.e<List<RoomDownload>> getInProgressDownloadsList() {
        return this.downloadPersistence.getRunningDownloads().G(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.p1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return rx.e.N((List) obj).D(new rx.m.e() { // from class: cm.aptoide.pt.downloadmanager.o1
                    @Override // rx.m.e
                    public final Object call(Object obj2) {
                        RoomDownload roomDownload = (RoomDownload) obj2;
                        return Boolean.valueOf(roomDownload.getOverallDownloadStatus() == 5 || roomDownload.getOverallDownloadStatus() == 4);
                    }
                }).Y0();
            }
        });
    }

    public rx.e<List<RoomDownload>> getInQueueDownloads() {
        return this.downloadPersistence.getInQueueSortedDownloads();
    }

    public rx.e<List<RoomDownload>> getOutOfSpaceDownloads() {
        return this.downloadPersistence.getOutOfSpaceDownloads();
    }

    public rx.b remove(String str) {
        return this.downloadPersistence.delete(str);
    }

    public rx.b save(RoomDownload roomDownload) {
        return this.downloadPersistence.save(roomDownload);
    }

    public rx.b remove(String str, int i2) {
        return this.downloadPersistence.delete(str, i2);
    }
}
