package cm.aptoide.pt.app;

import cm.aptoide.pt.download.InstallType;
import cm.aptoide.pt.download.Origin;
import cm.aptoide.pt.install.Install;

/* JADX INFO: loaded from: classes.dex */
public class DownloadStateParser {

    /* JADX INFO: renamed from: cm.aptoide.pt.app.DownloadStateParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus;
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$install$Install$InstallationType;

        static {
            int[] iArr = new int[DownloadModel.Action.values().length];
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = iArr;
            try {
                iArr[DownloadModel.Action.INSTALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.DOWNGRADE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[DownloadModel.Action.MIGRATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Install.InstallationType.values().length];
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationType = iArr2;
            try {
                iArr2[Install.InstallationType.INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[Install.InstallationType.INSTALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[Install.InstallationType.DOWNGRADE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationType[Install.InstallationType.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Install.InstallationStatus.values().length];
            $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus = iArr3;
            try {
                iArr3[Install.InstallationStatus.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.IN_QUEUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.INITIAL_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.INSTALLED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.UNINSTALLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.INSTALLATION_TIMEOUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.GENERIC_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.NOT_ENOUGH_SPACE_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[Install.InstallationStatus.INSTALLING.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public InstallType getInstallType(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? InstallType.INSTALL : InstallType.DOWNGRADE;
        }
        return InstallType.UPDATE;
    }

    public Origin getOrigin(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? Origin.INSTALL : Origin.DOWNGRADE;
        }
        return Origin.UPDATE;
    }

    public int parseDownloadAction(DownloadModel.Action action) {
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[action.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 3 || i2 == 4) {
            return 2;
        }
        throw new IllegalArgumentException("Invalid action " + action.toString());
    }

    public DownloadModel.DownloadState parseDownloadState(Install.InstallationStatus installationStatus, boolean z) {
        if (z && installationStatus != Install.InstallationStatus.INSTALLING) {
            return DownloadModel.DownloadState.INDETERMINATE;
        }
        switch (AnonymousClass1.$SwitchMap$cm$aptoide$pt$install$Install$InstallationStatus[installationStatus.ordinal()]) {
            case 1:
                return DownloadModel.DownloadState.ACTIVE;
            case 2:
                return DownloadModel.DownloadState.PAUSE;
            case 3:
            case 4:
                return DownloadModel.DownloadState.INDETERMINATE;
            case 5:
            case 6:
                return DownloadModel.DownloadState.COMPLETE;
            case 7:
            case 8:
                return DownloadModel.DownloadState.ERROR;
            case 9:
                return DownloadModel.DownloadState.NOT_ENOUGH_STORAGE_ERROR;
            case 10:
                return DownloadModel.DownloadState.INSTALLING;
            default:
                throw new IllegalStateException("Wrong type of download state");
        }
    }

    public DownloadModel.Action parseDownloadType(Install.InstallationType installationType, boolean z) {
        if (z) {
            return DownloadModel.Action.MIGRATE;
        }
        int i2 = AnonymousClass1.$SwitchMap$cm$aptoide$pt$install$Install$InstallationType[installationType.ordinal()];
        if (i2 == 1) {
            return DownloadModel.Action.OPEN;
        }
        if (i2 == 2) {
            return DownloadModel.Action.INSTALL;
        }
        if (i2 != 3) {
            return i2 != 4 ? DownloadModel.Action.INSTALL : DownloadModel.Action.UPDATE;
        }
        return DownloadModel.Action.DOWNGRADE;
    }
}
