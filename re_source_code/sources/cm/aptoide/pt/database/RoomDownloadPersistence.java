package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.DownloadDAO;
import cm.aptoide.pt.database.room.RoomDownload;
import cm.aptoide.pt.downloadmanager.DownloadPersistence;
import java.util.ArrayList;
import java.util.List;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomDownloadPersistence implements DownloadPersistence {
    private final DownloadDAO downloadDAO;

    public RoomDownloadPersistence(DownloadDAO downloadDAO) {
        this.downloadDAO = downloadDAO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$delete$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str) {
        this.downloadDAO.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$delete$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(String str, int i2) {
        this.downloadDAO.remove(str, i2);
    }

    static /* synthetic */ List lambda$getAsList$6(Throwable th) {
        return new ArrayList();
    }

    static /* synthetic */ RoomDownload lambda$getAsObservable$1(Throwable th) {
        return null;
    }

    static /* synthetic */ RoomDownload lambda$getAsSingle$0(Throwable th) {
        return null;
    }

    static /* synthetic */ List lambda$getInQueueSortedDownloads$5(Throwable th) {
        return new ArrayList();
    }

    static /* synthetic */ List lambda$getOutOfSpaceDownloads$8(Throwable th) {
        return new ArrayList();
    }

    static /* synthetic */ List lambda$getRunningDownloads$4(Throwable th) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(RoomDownload roomDownload) {
        this.downloadDAO.insert(roomDownload);
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.b delete(final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.i
            @Override // rx.m.a
            public final void call() {
                this.f4914f.a(str);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.e<List<RoomDownload>> getAll() {
        return g.a.a.a.d.b(this.downloadDAO.getAll(), h.a.a.BUFFER).o(new ArrayList()).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.e<List<RoomDownload>> getAsList(String str) {
        return g.a.a.a.d.b(this.downloadDAO.getAsList(str), h.a.a.BUFFER).o(new ArrayList()).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomDownloadPersistence.lambda$getAsList$6((Throwable) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.e<RoomDownload> getAsObservable(String str) {
        return g.a.a.a.d.b(this.downloadDAO.getAsObservable(str), h.a.a.BUFFER).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.o
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomDownloadPersistence.lambda$getAsObservable$1((Throwable) obj);
                return null;
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public Single<RoomDownload> getAsSingle(String str) {
        return g.a.a.a.d.d(this.downloadDAO.getAsSingle(str)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomDownloadPersistence.lambda$getAsSingle$0((Throwable) obj);
                return null;
            }
        }).v(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.e<List<RoomDownload>> getInQueueSortedDownloads() {
        return g.a.a.a.d.b(this.downloadDAO.getInQueueSortedDownloads(), h.a.a.BUFFER).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.q
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomDownloadPersistence.lambda$getInQueueSortedDownloads$5((Throwable) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.e<List<RoomDownload>> getOutOfSpaceDownloads() {
        return g.a.a.a.d.b(this.downloadDAO.getOutOfSpaceDownloads(), h.a.a.BUFFER).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomDownloadPersistence.lambda$getOutOfSpaceDownloads$8((Throwable) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.e<List<RoomDownload>> getRunningDownloads() {
        return g.a.a.a.d.b(this.downloadDAO.getRunningDownloads(), h.a.a.BUFFER).p0(new rx.m.e() { // from class: cm.aptoide.pt.database.p
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomDownloadPersistence.lambda$getRunningDownloads$4((Throwable) obj);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.b save(final RoomDownload roomDownload) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.m
            @Override // rx.m.a
            public final void call() {
                this.f4929f.c(roomDownload);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.downloadmanager.DownloadPersistence
    public rx.b delete(final String str, final int i2) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.n
            @Override // rx.m.a
            public final void call() {
                this.f4933f.b(str, i2);
            }
        });
    }
}
