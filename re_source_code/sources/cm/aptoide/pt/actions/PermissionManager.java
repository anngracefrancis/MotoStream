package cm.aptoide.pt.actions;

/* JADX INFO: loaded from: classes.dex */
public class PermissionManager {
    public rx.e<Boolean> hasDownloadAccess(PermissionService permissionService) {
        return rx.e.l(new HasDownloadAccessOnSubscribe(permissionService));
    }

    public rx.e<Void> requestDownloadAccess(PermissionService permissionService) {
        return rx.e.l(new RequestDownloadAccessOnSubscribe(permissionService, false, false, -1L));
    }

    public rx.e<Void> requestDownloadAccessWithWifiBypass(PermissionService permissionService, long j2) {
        return rx.e.l(new RequestDownloadAccessOnSubscribe(permissionService, false, true, j2));
    }

    public rx.e<Void> requestDownloadAllowingMobileData(PermissionService permissionService) {
        return rx.e.l(new RequestDownloadAccessOnSubscribe(permissionService, true, false, -1L));
    }

    public rx.e<Void> requestExternalStoragePermission(PermissionService permissionService) {
        return rx.e.l(new RequestAccessToExternalFileSystemOnSubscribe(permissionService));
    }
}
