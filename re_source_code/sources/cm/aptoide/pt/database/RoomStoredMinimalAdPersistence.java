package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.RoomStoredMinimalAd;
import cm.aptoide.pt.database.room.StoredMinimalAdDAO;

/* JADX INFO: loaded from: classes.dex */
public class RoomStoredMinimalAdPersistence implements StoredMinimalAdPersistence {
    private final StoredMinimalAdDAO storedMinimalAdDAO;

    public RoomStoredMinimalAdPersistence(StoredMinimalAdDAO storedMinimalAdDAO) {
        this.storedMinimalAdDAO = storedMinimalAdDAO;
    }

    static /* synthetic */ RoomStoredMinimalAd lambda$get$0(Throwable th) throws Exception {
        return null;
    }

    @Override // cm.aptoide.pt.database.StoredMinimalAdPersistence
    public rx.e<RoomStoredMinimalAd> get(String str) {
        return g.a.a.a.d.b(this.storedMinimalAdDAO.get(str).y(h.a.b0.a.b()).w(new h.a.y.f() { // from class: cm.aptoide.pt.database.d1
            @Override // h.a.y.f
            public final Object a(Object obj) throws Exception {
                RoomStoredMinimalAdPersistence.lambda$get$0((Throwable) obj);
                return null;
            }
        }).e(new h.a.y.e() { // from class: cm.aptoide.pt.database.p1
            @Override // h.a.y.e
            public final void a(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }), h.a.a.BUFFER);
    }

    @Override // cm.aptoide.pt.database.StoredMinimalAdPersistence
    public void insert(RoomStoredMinimalAd roomStoredMinimalAd) {
        this.storedMinimalAdDAO.insert(roomStoredMinimalAd);
    }

    @Override // cm.aptoide.pt.database.StoredMinimalAdPersistence
    public void remove(RoomStoredMinimalAd roomStoredMinimalAd) {
        this.storedMinimalAdDAO.delete(roomStoredMinimalAd);
    }
}
