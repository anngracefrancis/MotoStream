package cm.aptoide.pt.download.view;

import cm.aptoide.pt.app.migration.AppcMigrationManager;
import cm.aptoide.pt.database.room.RoomInstalled;
import cm.aptoide.pt.database.room.RoomStore;
import cm.aptoide.pt.install.Install;
import cm.aptoide.pt.install.InstallManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DownloadStatusManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J@\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcm/aptoide/pt/download/view/DownloadStatusManager;", HttpUrl.FRAGMENT_ENCODE_SET, "installManager", "Lcm/aptoide/pt/install/InstallManager;", "appcMigrationManager", "Lcm/aptoide/pt/app/migration/AppcMigrationManager;", "(Lcm/aptoide/pt/install/InstallManager;Lcm/aptoide/pt/app/migration/AppcMigrationManager;)V", "loadDownloadModel", "Lrx/Observable;", "Lcm/aptoide/pt/download/view/DownloadStatusModel;", "md5", HttpUrl.FRAGMENT_ENCODE_SET, "packageName", RoomInstalled.VERSION_CODE, HttpUrl.FRAGMENT_ENCODE_SET, RoomInstalled.SIGNATURE, RoomStore.STORE_ID, HttpUrl.FRAGMENT_ENCODE_SET, "hasAppc", HttpUrl.FRAGMENT_ENCODE_SET, "parseStatusDownloadState", "Lcm/aptoide/pt/download/view/DownloadStatusModel$DownloadState;", "state", "Lcm/aptoide/pt/install/Install$InstallationStatus;", "isIndeterminate", "parseStatusDownloadType", "Lcm/aptoide/pt/download/view/DownloadStatusModel$Action;", "type", "Lcm/aptoide/pt/install/Install$InstallationType;", "isMigration", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DownloadStatusManager {
    private final AppcMigrationManager appcMigrationManager;
    private final InstallManager installManager;

    /* JADX INFO: compiled from: DownloadStatusManager.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Install.InstallationType.values().length];
            iArr[Install.InstallationType.INSTALLED.ordinal()] = 1;
            iArr[Install.InstallationType.DOWNGRADE.ordinal()] = 2;
            iArr[Install.InstallationType.UPDATE.ordinal()] = 3;
            iArr[Install.InstallationType.INSTALL.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Install.InstallationStatus.values().length];
            iArr2[Install.InstallationStatus.INSTALLATION_TIMEOUT.ordinal()] = 1;
            iArr2[Install.InstallationStatus.GENERIC_ERROR.ordinal()] = 2;
            iArr2[Install.InstallationStatus.NOT_ENOUGH_SPACE_ERROR.ordinal()] = 3;
            iArr2[Install.InstallationStatus.IN_QUEUE.ordinal()] = 4;
            iArr2[Install.InstallationStatus.PAUSED.ordinal()] = 5;
            iArr2[Install.InstallationStatus.DOWNLOADING.ordinal()] = 6;
            iArr2[Install.InstallationStatus.INITIAL_STATE.ordinal()] = 7;
            iArr2[Install.InstallationStatus.INSTALLED.ordinal()] = 8;
            iArr2[Install.InstallationStatus.UNINSTALLED.ordinal()] = 9;
            iArr2[Install.InstallationStatus.INSTALLING.ordinal()] = 10;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DownloadStatusManager(InstallManager installManager, AppcMigrationManager appcMigrationManager) {
        kotlin.jvm.internal.m.f(installManager, "installManager");
        kotlin.jvm.internal.m.f(appcMigrationManager, "appcMigrationManager");
        this.installManager = installManager;
        this.appcMigrationManager = appcMigrationManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadDownloadModel$lambda-0, reason: not valid java name */
    public static final DownloadStatusModel m80loadDownloadModel$lambda0(DownloadStatusManager downloadStatusManager, Install install, Boolean bool) {
        kotlin.jvm.internal.m.f(downloadStatusManager, "this$0");
        Install.InstallationType type = install.getType();
        kotlin.jvm.internal.m.e(bool, "isMigration");
        return new DownloadStatusModel(downloadStatusManager.parseStatusDownloadType(type, bool.booleanValue()), install.getProgress(), downloadStatusManager.parseStatusDownloadState(install.getState(), install.isIndeterminate()));
    }

    private final DownloadStatusModel.DownloadState parseStatusDownloadState(Install.InstallationStatus state, boolean isIndeterminate) {
        if (isIndeterminate) {
            return DownloadStatusModel.DownloadState.IN_QUEUE;
        }
        switch (state == null ? -1 : WhenMappings.$EnumSwitchMapping$1[state.ordinal()]) {
            case 1:
            case 2:
                return DownloadStatusModel.DownloadState.GENERIC_ERROR;
            case 3:
                return DownloadStatusModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR;
            case 4:
                return DownloadStatusModel.DownloadState.IN_QUEUE;
            case 5:
                return DownloadStatusModel.DownloadState.PAUSE;
            case 6:
                return DownloadStatusModel.DownloadState.ACTIVE;
            case 7:
            case 8:
            case 9:
                return DownloadStatusModel.DownloadState.STANDBY;
            case 10:
                return DownloadStatusModel.DownloadState.INSTALLING;
            default:
                throw new IllegalStateException("Wrong type of download state");
        }
    }

    private final DownloadStatusModel.Action parseStatusDownloadType(Install.InstallationType type, boolean isMigration) {
        if (isMigration) {
            return DownloadStatusModel.Action.MIGRATE;
        }
        int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 1) {
            return DownloadStatusModel.Action.OPEN;
        }
        if (i2 == 2) {
            return DownloadStatusModel.Action.DOWNGRADE;
        }
        if (i2 != 3) {
            return i2 != 4 ? DownloadStatusModel.Action.INSTALL : DownloadStatusModel.Action.INSTALL;
        }
        return DownloadStatusModel.Action.UPDATE;
    }

    public final rx.e<DownloadStatusModel> loadDownloadModel(String str, String str2, int i2, String str3, long j2, boolean z) {
        kotlin.jvm.internal.m.f(str, "md5");
        kotlin.jvm.internal.m.f(str2, "packageName");
        return rx.e.e(this.installManager.getInstall(str, str2, i2), this.appcMigrationManager.isMigrationApp(str2, str3, i2, j2, z), new rx.m.f() { // from class: cm.aptoide.pt.download.view.f
            @Override // rx.m.f
            public final Object a(Object obj, Object obj2) {
                return DownloadStatusManager.m80loadDownloadModel$lambda0(this.f5105f, (Install) obj, (Boolean) obj2);
            }
        }).R0(200L, TimeUnit.MILLISECONDS);
    }
}
