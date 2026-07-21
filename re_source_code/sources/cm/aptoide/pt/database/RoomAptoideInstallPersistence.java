package cm.aptoide.pt.database;

import cm.aptoide.pt.database.room.AptoideInstallDao;
import cm.aptoide.pt.database.room.RoomAptoideInstallApp;
import cm.aptoide.pt.install.AptoideInstallPersistence;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class RoomAptoideInstallPersistence implements AptoideInstallPersistence {
    private final AptoideInstallDao aptoideInstallDao;

    public RoomAptoideInstallPersistence(AptoideInstallDao aptoideInstallDao) {
        this.aptoideInstallDao = aptoideInstallDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$insert$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a(String str) {
        this.aptoideInstallDao.insert(new RoomAptoideInstallApp(str));
    }

    @Override // cm.aptoide.pt.install.AptoideInstallPersistence
    public void insert(final String str) {
        new Thread(new Runnable() { // from class: cm.aptoide.pt.database.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f4902f.a(str);
            }
        }).start();
    }

    @Override // cm.aptoide.pt.install.AptoideInstallPersistence
    public Single<Boolean> isInstalledWithAptoide(String str) {
        return g.a.a.a.d.d(this.aptoideInstallDao.get(str)).n(new rx.m.e() { // from class: cm.aptoide.pt.database.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.TRUE;
            }
        }).r(new rx.m.e() { // from class: cm.aptoide.pt.database.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.FALSE;
            }
        }).v(Schedulers.io());
    }
}
