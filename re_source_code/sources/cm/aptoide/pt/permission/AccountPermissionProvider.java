package cm.aptoide.pt.permission;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccountPermissionProvider {
    private final PermissionProvider permissionProvider;

    public AccountPermissionProvider(PermissionProvider permissionProvider) {
        this.permissionProvider = permissionProvider;
    }

    public rx.e<List<PermissionProvider.Permission>> permissionResultCamera(int i2) {
        return this.permissionProvider.permissionResults(i2);
    }

    public void requestCameraPermission(int i2) {
        this.permissionProvider.providePermissions(new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, i2);
    }

    public void requestGalleryPermission(int i2) {
        this.permissionProvider.providePermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, i2);
    }
}
