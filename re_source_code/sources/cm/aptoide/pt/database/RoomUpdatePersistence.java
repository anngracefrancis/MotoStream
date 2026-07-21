package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.RoomUpdate;
import cm.aptoide.pt.database.room.UpdateDao;
import cm.aptoide.pt.updates.UpdatePersistence;
import java.util.ArrayList;
import java.util.List;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomUpdatePersistence implements UpdatePersistence {
    private final UpdateDao updateDao;

    public RoomUpdatePersistence(UpdateDao updateDao) {
        this.updateDao = updateDao;
    }

    static /* synthetic */ RoomUpdate lambda$contains$2(Throwable th) {
        return null;
    }

    static /* synthetic */ RoomUpdate lambda$get$0(Throwable th) {
        return null;
    }

    static /* synthetic */ List lambda$getAll$1(Throwable th) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str) {
        this.updateDao.deleteByPackageName(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removeAll$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(List list) {
        this.updateDao.deleteAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c(RoomUpdate roomUpdate) {
        this.updateDao.insert(roomUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$saveAll$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(List list) {
        this.updateDao.insertAll(list);
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public Single<Boolean> contains(String str, boolean z) {
        return g.a.a.a.d.d(this.updateDao.getByPackageAndExcluded(str, z)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.l1
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomUpdatePersistence.lambda$contains$2((Throwable) obj);
                return null;
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.database.g1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((RoomUpdate) obj) != null);
            }
        }).v(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public Single<RoomUpdate> get(String str) {
        return g.a.a.a.d.d(this.updateDao.get(str)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.k1
            @Override // rx.m.e
            public final Object call(Object obj) {
                RoomUpdatePersistence.lambda$get$0((Throwable) obj);
                return null;
            }
        }).v(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public Single<List<RoomUpdate>> getAll(boolean z) {
        return g.a.a.a.d.d(this.updateDao.getAllByExcluded(z)).r(new rx.m.e() { // from class: cm.aptoide.pt.database.j1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return RoomUpdatePersistence.lambda$getAll$1((Throwable) obj);
            }
        }).v(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public rx.e<List<RoomUpdate>> getAllSorted(boolean z) {
        return g.a.a.a.d.b(this.updateDao.getAllByExcludedSorted(z), h.a.a.BUFFER).I0(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public Single<Boolean> isExcluded(String str) {
        return g.a.a.a.d.d(this.updateDao.getByPackageAndExcluded(str, true).g(new h.a.y.f() { // from class: cm.aptoide.pt.database.h1
            @Override // h.a.y.f
            public final Object a(Object obj) {
                return Boolean.valueOf(((RoomUpdate) obj) != null);
            }
        })).r(new rx.m.e() { // from class: cm.aptoide.pt.database.m1
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.FALSE;
            }
        }).v(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public rx.b remove(final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.i1
            @Override // rx.m.a
            public final void call() {
                this.f4918f.a(str);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public rx.b removeAll(final List<RoomUpdate> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.n1
            @Override // rx.m.a
            public final void call() {
                this.f4937f.b(list);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public rx.b save(final RoomUpdate roomUpdate) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.f1
            @Override // rx.m.a
            public final void call() {
                this.f4906f.c(roomUpdate);
            }
        }).K(Schedulers.io());
    }

    @Override // cm.aptoide.pt.updates.UpdatePersistence
    public rx.b saveAll(final List<RoomUpdate> list) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.database.e1
            @Override // rx.m.a
            public final void call() {
                this.f4900f.d(list);
            }
        }).K(Schedulers.io());
    }
}
