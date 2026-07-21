package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.database.room.StoreDao;
import cm.aptoide.pt.store.StorePersistence;
import java.util.List;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomStorePersistence implements StorePersistence {
    private final StoreDao storeDao;

    public RoomStorePersistence(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    static /* synthetic */ RoomStore lambda$get$0(Throwable th) {
        return null;
    }

    static /* synthetic */ RoomStore lambda$get$1(Throwable th) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str) {
        this.storeDao.removeByStoreName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(RoomStore roomStore) {
        this.storeDao.insert(roomStore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveAll$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(List list) {
        this.storeDao.saveAll(list);
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public Single<RoomStore> get(String str) {
        return g.a.a.a.d.d(this.storeDao.getByStoreName(str)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.z0
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomStorePersistence.lambda$get$0((Throwable) obj);
                return null;
            }
        }).v(Schedulers.io());
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public rx.e<List<RoomStore>> getAll() {
        return g.a.a.a.d.b(this.storeDao.getAll(), h.a.a.BUFFER).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public rx.e<Boolean> isSubscribed(long j2) {
        return g.a.a.a.d.b(this.storeDao.isSubscribed(j2), h.a.a.BUFFER).X(new rx.m.e() { // from class: cm.aptoide.pt.database.y0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() > 0);
            }
        }).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public rx.b remove(final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.c1
            @Override // rx.m.a
            public final void call() {
                this.f4892f.a(str);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public rx.b save(final RoomStore roomStore) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.b1
            @Override // rx.m.a
            public final void call() {
                this.f4888f.b(roomStore);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public rx.b saveAll(final List<RoomStore> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.x0
            @Override // rx.m.a
            public final void call() {
                this.f4962f.c(list);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.store.StorePersistence
    public Single<RoomStore> get(long j2) {
        return g.a.a.a.d.d(this.storeDao.getByStoreId(j2)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.a1
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomStorePersistence.lambda$get$1((Throwable) obj);
                return null;
            }
        }).v(Schedulers.io());
    }
}
