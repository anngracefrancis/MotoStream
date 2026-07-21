package cm.aptoide.pt.actions;

import android.annotation.TargetApi;

/* JADX INFO: loaded from: classes.dex */
public interface PermissionService {
    @TargetApi(23)
    void hasDownloadAccess(rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestAccessToAccounts(rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestAccessToAccounts(boolean z, rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestAccessToCamera(rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestAccessToExternalFileSystem(rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestAccessToExternalFileSystem(boolean z, int i2, rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestAccessToExternalFileSystem(boolean z, rx.m.a aVar, rx.m.a aVar2);

    @TargetApi(23)
    void requestDownloadAccess(rx.m.a aVar, rx.m.a aVar2, boolean z, boolean z2, long j2);
}
