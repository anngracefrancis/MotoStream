package cm.aptoide.pt.install;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import cm.aptoide.pt.database.RoomInstalledPersistence;
import cm.aptoide.pt.database.room.RoomInstallation;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import rx.Single;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class AptoideInstalledAppsRepository implements InstalledAppsRepository {
    private final FileUtils fileUtils;
    private final RoomInstalledPersistence installedPersistence;
    private final PackageManager packageManager;
    private boolean synced = false;

    public AptoideInstalledAppsRepository(RoomInstalledPersistence roomInstalledPersistence, PackageManager packageManager, FileUtils fileUtils) {
        this.installedPersistence = roomInstalledPersistence;
        this.packageManager = packageManager;
        this.fileUtils = fileUtils;
    }

    private <T> List<T> combineLists(List<T> list, List<T> list2, rx.m.b<T> bVar) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        for (T t : list2) {
            if (!arrayList.contains(t)) {
                if (bVar != null) {
                    bVar.call(t);
                }
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    static /* synthetic */ RoomInstalled lambda$getAsList$12(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return (RoomInstalled) list.get(0);
    }

    static /* synthetic */ Iterable lambda$getInstalledAppsNames$13(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ PackageInfo a(String str) throws Exception {
        return AptoideUtils.SystemU.getPackageInfo(str, this.packageManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(PackageInfo packageInfo, Boolean bool) {
        return !bool.booleanValue() ? this.installedPersistence.insert(new RoomInstalled(packageInfo, this.packageManager, this.fileUtils)) : rx.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e c(final List list) {
        return this.installedPersistence.getAll().E().X(new rx.m.e() { // from class: cm.aptoide.pt.install.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6442f.h(list, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        this.synced = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b e(String str, final PackageInfo packageInfo) {
        return packageInfo != null ? this.installedPersistence.isInstalled(str, packageInfo.versionCode).j(new rx.m.e() { // from class: cm.aptoide.pt.install.d
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6419f.b(packageInfo, (Boolean) obj);
            }
        }) : this.installedPersistence.remove(str);
    }

    static /* synthetic */ int lambda$syncWithDevice$4(PackageInfo packageInfo, PackageInfo packageInfo2) {
        return (int) ((packageInfo.firstInstallTime - packageInfo2.firstInstallTime) / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List f() throws Exception {
        List<PackageInfo> allInstalledApps = AptoideUtils.SystemU.getAllInstalledApps(this.packageManager);
        Logger.getInstance().v("InstalledRepository", "Found " + allInstalledApps.size() + " user installed apps.");
        Collections.sort(allInstalledApps, new Comparator() { // from class: cm.aptoide.pt.install.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AptoideInstalledAppsRepository.lambda$syncWithDevice$4((PackageInfo) obj, (PackageInfo) obj2);
            }
        });
        return allInstalledApps;
    }

    static /* synthetic */ Iterable lambda$syncWithDevice$6(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ RoomInstalled g(PackageInfo packageInfo) {
        return new RoomInstalled(packageInfo, this.packageManager, this.fileUtils);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$syncWithDevice$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ List h(List list, List list2) {
        return combineLists(list, list2, new rx.m.b() { // from class: cm.aptoide.pt.install.o
            @Override // rx.m.b
            public final void call(Object obj) {
                ((RoomInstalled) obj).setStatus(1);
            }
        });
    }

    public boolean contains(String str) {
        return this.installedPersistence.isInstalled(str).W0().b().booleanValue();
    }

    public rx.e<RoomInstalled> get(String str, int i2) {
        return this.installedPersistence.get(str, i2);
    }

    public rx.e<List<RoomInstalled>> getAllInstalled() {
        return this.installedPersistence.getAllInstalled();
    }

    public rx.e<List<RoomInstalled>> getAllInstalledSorted() {
        return this.installedPersistence.getAllInstalledSorted();
    }

    public rx.e<List<RoomInstalled>> getAllInstalling() {
        return this.installedPersistence.getAllInstalling();
    }

    public Single<List<RoomInstalled>> getAllSyncedInstalled() {
        return !this.synced ? syncWithDevice().c(getAllInstalled().E().Z0()) : getAllInstalled().E().Z0();
    }

    public rx.e<RoomInstalled> getAsList(String str, int i2) {
        return this.installedPersistence.getAsList(str, i2).j0(Schedulers.io()).X(new rx.m.e() { // from class: cm.aptoide.pt.install.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return AptoideInstalledAppsRepository.lambda$getAsList$12((List) obj);
            }
        });
    }

    public rx.e<List<RoomInstallation>> getInstallationsHistory() {
        return this.installedPersistence.getInstallationsHistory();
    }

    public rx.e<RoomInstalled> getInstalled(String str) {
        return this.installedPersistence.getInstalled(str);
    }

    public rx.e<List<RoomInstalled>> getInstalledAppsFilterSystem() {
        return this.installedPersistence.getInstalledFilteringSystemApps();
    }

    @Override // cm.aptoide.pt.install.InstalledAppsRepository
    public h.a.s<List<String>> getInstalledAppsNames() {
        return g.a.a.a.d.f(getAllInstalled().E().J(new rx.m.e() { // from class: cm.aptoide.pt.install.g
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                AptoideInstalledAppsRepository.lambda$getInstalledAppsNames$13(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.install.j3
            @Override // rx.m.e
            public final Object call(Object obj) {
                return ((RoomInstalled) obj).getPackageName();
            }
        }).Y0().Z0());
    }

    public rx.e<Boolean> isInstalled(String str) {
        return this.installedPersistence.isInstalled(str);
    }

    public rx.b remove(String str, int i2) {
        return this.installedPersistence.remove(str, i2);
    }

    public rx.b save(RoomInstalled roomInstalled) {
        return this.installedPersistence.insert(roomInstalled);
    }

    public rx.b syncWithDevice(final String str) {
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6412f.a(str);
            }
        }).p0(null).H(new rx.m.e() { // from class: cm.aptoide.pt.install.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6401f.e(str, (PackageInfo) obj);
            }
        }).w(new rx.m.b() { // from class: cm.aptoide.pt.install.e
            @Override // rx.m.b
            public final void call(Object obj) {
                ((Throwable) obj).printStackTrace();
            }
        }).X0();
    }

    public Single<Boolean> isInstalled(String str, int i2) {
        return this.installedPersistence.isInstalled(str, i2);
    }

    public rx.e<List<RoomInstalled>> getAsList(String str) {
        return this.installedPersistence.getAllAsList(str);
    }

    public rx.b syncWithDevice() {
        rx.e eVarG = rx.e.P(new Callable() { // from class: cm.aptoide.pt.install.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f6448f.f();
            }
        }).J(new rx.m.e() { // from class: cm.aptoide.pt.install.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                List list = (List) obj;
                AptoideInstalledAppsRepository.lambda$syncWithDevice$6(list);
                return list;
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.install.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6523f.g((PackageInfo) obj);
            }
        }).Y0().G(new rx.m.e() { // from class: cm.aptoide.pt.install.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6431f.c((List) obj);
            }
        });
        final RoomInstalledPersistence roomInstalledPersistence = this.installedPersistence;
        roomInstalledPersistence.getClass();
        return eVarG.H(new rx.m.e() { // from class: cm.aptoide.pt.install.n2
            @Override // rx.m.e
            public final Object call(Object obj) {
                return roomInstalledPersistence.replaceAllBy((List) obj);
            }
        }).X0().m(new rx.m.a() { // from class: cm.aptoide.pt.install.l
            @Override // rx.m.a
            public final void call() {
                this.f6539f.d();
            }
        });
    }
}
