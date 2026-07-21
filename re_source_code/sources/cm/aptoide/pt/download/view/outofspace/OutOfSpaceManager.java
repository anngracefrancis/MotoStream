package cm.aptoide.pt.download.view.outofspace;

import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.install.InstallAppSizeValidator;
import cm.aptoide.pt.install.InstallManager;
import java.util.List;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: OutOfSpaceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcm/aptoide/pt/download/view/outofspace/OutOfSpaceManager;", HttpUrl.FRAGMENT_ENCODE_SET, "installManager", "Lcm/aptoide/pt/install/InstallManager;", "appSize", HttpUrl.FRAGMENT_ENCODE_SET, "uninstalledEnoughApps", "Lrx/subjects/PublishSubject;", "Ljava/lang/Void;", "installAppSizeValidator", "Lcm/aptoide/pt/install/InstallAppSizeValidator;", "(Lcm/aptoide/pt/install/InstallManager;JLrx/subjects/PublishSubject;Lcm/aptoide/pt/install/InstallAppSizeValidator;)V", "requiredSpace", "getInstalledAppSize", "Lrx/Single;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "getInstalledApps", "Lrx/Observable;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcm/aptoide/pt/download/view/outofspace/InstalledApp;", "getRequiredStorageSize", "uninstallApp", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OutOfSpaceManager {
    private final long appSize;
    private final InstallAppSizeValidator installAppSizeValidator;
    private final InstallManager installManager;
    private long requiredSpace;
    private final rx.s.b<Void> uninstalledEnoughApps;

    public OutOfSpaceManager(InstallManager installManager, long j2, rx.s.b<Void> bVar, InstallAppSizeValidator installAppSizeValidator) {
        kotlin.jvm.internal.m.f(installManager, "installManager");
        kotlin.jvm.internal.m.f(bVar, "uninstalledEnoughApps");
        kotlin.jvm.internal.m.f(installAppSizeValidator, "installAppSizeValidator");
        this.installManager = installManager;
        this.appSize = j2;
        this.uninstalledEnoughApps = bVar;
        this.installAppSizeValidator = installAppSizeValidator;
        this.requiredSpace = j2;
    }

    private final Single<Long> getInstalledAppSize(String packageName) {
        Single<Long> installedAppSize = this.installManager.getInstalledAppSize(packageName);
        kotlin.jvm.internal.m.e(installedAppSize, "installManager.getInstalledAppSize(packageName)");
        return installedAppSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getInstalledApps$lambda-2, reason: not valid java name */
    public static final rx.e m138getInstalledApps$lambda2(List list) {
        return rx.e.N(list).D(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.f0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceManager.m139getInstalledApps$lambda2$lambda0((RoomInstalled) obj);
            }
        }).X(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.b0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceManager.m140getInstalledApps$lambda2$lambda1((RoomInstalled) obj);
            }
        }).Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getInstalledApps$lambda-2$lambda-0, reason: not valid java name */
    public static final Boolean m139getInstalledApps$lambda2$lambda0(RoomInstalled roomInstalled) {
        return Boolean.valueOf((roomInstalled.getPackageName().equals("cm.aptoide.pt") || roomInstalled.getPackageName().equals(AptoideApplication.APPCOINS_WALLET_PACKAGE_NAME)) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getInstalledApps$lambda-2$lambda-1, reason: not valid java name */
    public static final InstalledApp m140getInstalledApps$lambda2$lambda1(RoomInstalled roomInstalled) {
        String name = roomInstalled.getName();
        kotlin.jvm.internal.m.e(name, "it.name");
        String packageName = roomInstalled.getPackageName();
        kotlin.jvm.internal.m.e(packageName, "it.packageName");
        String icon = roomInstalled.getIcon();
        kotlin.jvm.internal.m.e(icon, "it.icon");
        Long appSize = roomInstalled.getAppSize();
        kotlin.jvm.internal.m.e(appSize, "it.appSize");
        return new InstalledApp(name, packageName, icon, appSize.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRequiredStorageSize$lambda-6, reason: not valid java name */
    public static final void m141getRequiredStorageSize$lambda6(OutOfSpaceManager outOfSpaceManager, Long l) {
        kotlin.jvm.internal.m.f(outOfSpaceManager, "this$0");
        kotlin.jvm.internal.m.e(l, "it");
        outOfSpaceManager.requiredSpace = l.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-4, reason: not valid java name */
    public static final Single m142uninstallApp$lambda4(final OutOfSpaceManager outOfSpaceManager, String str, final Long l) {
        kotlin.jvm.internal.m.f(outOfSpaceManager, "this$0");
        return outOfSpaceManager.installManager.uninstallApp(str).c(Single.m(l)).g(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.e0
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceManager.m143uninstallApp$lambda4$lambda3(this.f5138f, l, (Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-4$lambda-3, reason: not valid java name */
    public static final void m143uninstallApp$lambda4$lambda3(OutOfSpaceManager outOfSpaceManager, Long l, Long l2) {
        kotlin.jvm.internal.m.f(outOfSpaceManager, "this$0");
        long j2 = outOfSpaceManager.requiredSpace;
        kotlin.jvm.internal.m.e(l, "appSize");
        if (j2 <= l.longValue()) {
            outOfSpaceManager.uninstalledEnoughApps.onNext(null);
        } else {
            outOfSpaceManager.requiredSpace -= l.longValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: uninstallApp$lambda-5, reason: not valid java name */
    public static final Long m144uninstallApp$lambda5(OutOfSpaceManager outOfSpaceManager, Long l) {
        kotlin.jvm.internal.m.f(outOfSpaceManager, "this$0");
        return Long.valueOf(outOfSpaceManager.requiredSpace);
    }

    public final rx.e<List<InstalledApp>> getInstalledApps() {
        rx.e eVarG = this.installManager.fetchInstalledExceptSystem().G(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.g0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceManager.m138getInstalledApps$lambda2((List) obj);
            }
        });
        kotlin.jvm.internal.m.e(eVarG, "installManager.fetchInst…      .toList()\n        }");
        return eVarG;
    }

    public final Single<Long> getRequiredStorageSize() {
        Single<Long> singleG = Single.m(Long.valueOf(this.appSize - this.installAppSizeValidator.getAvailableSpace())).g(new rx.m.b() { // from class: cm.aptoide.pt.download.view.outofspace.c0
            @Override // rx.m.b
            public final void call(Object obj) {
                OutOfSpaceManager.m141getRequiredStorageSize$lambda6(this.f5134f, (Long) obj);
            }
        });
        kotlin.jvm.internal.m.e(singleG, "just(appSize - installAp…ss { requiredSpace = it }");
        return singleG;
    }

    public final Single<Long> uninstallApp(final String packageName) {
        Single<Long> singleN = getInstalledAppSize(packageName).i(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.h0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceManager.m142uninstallApp$lambda4(this.f5145f, packageName, (Long) obj);
            }
        }).n(new rx.m.e() { // from class: cm.aptoide.pt.download.view.outofspace.d0
            @Override // rx.m.e
            public final Object call(Object obj) {
                return OutOfSpaceManager.m144uninstallApp$lambda5(this.f5136f, (Long) obj);
            }
        });
        kotlin.jvm.internal.m.e(singleN, "getInstalledAppSize(pack…  }.map { requiredSpace }");
        return singleN;
    }

    public final rx.e<Void> uninstalledEnoughApps() {
        return this.uninstalledEnoughApps;
    }
}
