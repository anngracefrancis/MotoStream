package cm.aptoide.pt.install;

import cm.aptoide.pt.install.installer.InstallationState;

/* JADX INFO: loaded from: classes.dex */
public interface Installer {
    void dispatchInstallations();

    rx.b downgrade(String str, boolean z, boolean z2);

    rx.e<InstallationState> getState(String str, int i2);

    rx.b install(String str, boolean z, boolean z2);

    void stopDispatching();

    rx.b uninstall(String str);

    rx.b update(String str, boolean z, boolean z2);
}
