package cm.aptoide.pt.permission;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import cm.aptoide.pt.AptoideApplication;
import cm.aptoide.pt.R;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.logger.Logger;
import cm.aptoide.pt.navigator.ActivityResultNavigator;
import cm.aptoide.pt.preferences.managed.ManagerPreferences;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.utils.GenericDialogs;
import cm.aptoide.pt.utils.SimpleSubscriber;
import cm.aptoide.pt.utils.design.ShowMessage;
import com.facebook.a0;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class PermissionServiceActivity extends ActivityResultNavigator implements PermissionService {
    private static final int ACCESS_TO_ACCOUNTS_REQUEST_ID = 62;
    private static final int ACCESS_TO_EXTERNAL_FS_REQUEST_ID = 61;
    private static final int PERMISSIONS_REQUEST_ACCESS_CAMERA = 101;
    private static final String TAG = PermissionServiceActivity.class.getName();
    private ConnectivityManager connectivityManager;
    private SharedPreferences sharedPreferences;
    private rx.m.a toRunWhenAccessToAccountsIsDenied;
    private rx.m.a toRunWhenAccessToAccountsIsGranted;
    private rx.m.a toRunWhenAccessToFileSystemIsDenied;
    private rx.m.a toRunWhenAccessToFileSystemIsGranted;

    private void showBypassWifiMessage(long j2, SimpleSubscriber<GenericDialogs.EResponse> simpleSubscriber) {
        GenericDialogs.createGenericOkCancelMessageWithColorButton(this, HttpUrl.FRAGMENT_ENCODE_SET, getString(R.string.general_downloads_dialog_only_wifi_message), getString(R.string.general_downloads_dialog_only_wifi_install_button, new Object[]{AptoideUtils.StringU.formatBytes(j2, false)}), getString(R.string.cancel)).E0(simpleSubscriber);
    }

    private void showMessageOKCancel(int i2, SimpleSubscriber<GenericDialogs.EResponse> simpleSubscriber) {
        showMessageOKCancel(getString(i2), simpleSubscriber);
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void hasDownloadAccess(rx.m.a aVar, rx.m.a aVar2) {
        if (androidx.core.content.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0 || (AptoideUtils.SystemU.getConnectionType(this.connectivityManager).equals("mobile") && !ManagerPreferences.getDownloadsWifiOnly(this.sharedPreferences))) {
            if (aVar2 != null) {
                aVar2.call();
            }
        } else if (aVar != null) {
            aVar.call();
        }
    }

    @Override // cm.aptoide.pt.navigator.ActivityResultNavigator, cm.aptoide.pt.view.BaseActivity, com.trello.rxlifecycle.h.a.a, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        this.sharedPreferences = ((AptoideApplication) getApplicationContext()).getDefaultSharedPreferences();
        if (a0.w()) {
            return;
        }
        a0.M(getApplicationContext());
    }

    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (iArr.length == 0) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
        if (i2 == 61) {
            if (iArr[0] != 0) {
                rx.m.a aVar = this.toRunWhenAccessToFileSystemIsDenied;
                if (aVar != null) {
                    aVar.call();
                }
                ShowMessage.asSnack(findViewById(android.R.id.content), "access to read and write to external storage was denied");
                return;
            }
            Logger.getInstance().v(TAG, "access to read and write to external storage was granted");
            rx.m.a aVar2 = this.toRunWhenAccessToFileSystemIsGranted;
            if (aVar2 != null) {
                aVar2.call();
                return;
            }
            return;
        }
        if (i2 != 62) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr[0] != 0) {
            rx.m.a aVar3 = this.toRunWhenAccessToAccountsIsDenied;
            if (aVar3 != null) {
                aVar3.call();
            }
            ShowMessage.asSnack(findViewById(android.R.id.content), "access to get accounts was denied");
            return;
        }
        Logger.getInstance().v(TAG, "access to get accounts was granted");
        rx.m.a aVar4 = this.toRunWhenAccessToAccountsIsGranted;
        if (aVar4 != null) {
            aVar4.call();
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToAccounts(rx.m.a aVar, rx.m.a aVar2) {
        requestAccessToAccounts(true, aVar, aVar2);
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    public void requestAccessToCamera(rx.m.a aVar, rx.m.a aVar2) {
        if (androidx.core.content.a.a(this, "android.permission.CAMERA") == 0) {
            Logger.getInstance().v(TAG, "already has permission to access camera");
            if (aVar != null) {
                aVar.call();
                return;
            }
            return;
        }
        this.toRunWhenAccessToFileSystemIsGranted = aVar;
        this.toRunWhenAccessToFileSystemIsDenied = aVar2;
        if (androidx.core.app.a.t(this, "android.permission.CAMERA")) {
            Logger.getInstance().v(TAG, "showing rationale and requesting permission to access camera");
            showMessageOKCancel(R.string.camera_access_permission_request_message, new SimpleSubscriber<GenericDialogs.EResponse>() { // from class: cm.aptoide.pt.permission.PermissionServiceActivity.4
                @Override // cm.aptoide.pt.utils.SimpleSubscriber, rx.f
                public void onNext(GenericDialogs.EResponse eResponse) {
                    super.onNext(eResponse);
                    if (eResponse == GenericDialogs.EResponse.YES) {
                        androidx.core.app.a.q(PermissionServiceActivity.this, new String[]{"android.permission.CAMERA"}, 101);
                    } else if (PermissionServiceActivity.this.toRunWhenAccessToFileSystemIsDenied != null) {
                        PermissionServiceActivity.this.toRunWhenAccessToFileSystemIsDenied.call();
                    }
                }
            });
        } else {
            androidx.core.app.a.q(this, new String[]{"android.permission.CAMERA"}, 101);
            Logger.getInstance().v(TAG, "requesting permission to access camera");
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToExternalFileSystem(rx.m.a aVar, rx.m.a aVar2) {
        requestAccessToExternalFileSystem(true, aVar, aVar2);
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    public void requestDownloadAccess(final rx.m.a aVar, final rx.m.a aVar2, boolean z, boolean z2, long j2) {
        if (z || !AptoideUtils.SystemU.getConnectionType(this.connectivityManager).equals("mobile") || ManagerPreferences.getDownloadsWifiOnly(this.sharedPreferences)) {
            if (aVar != null) {
                aVar.call();
            }
        } else if (z2) {
            showBypassWifiMessage(j2, new SimpleSubscriber<GenericDialogs.EResponse>() { // from class: cm.aptoide.pt.permission.PermissionServiceActivity.2
                @Override // cm.aptoide.pt.utils.SimpleSubscriber, rx.f
                public void onNext(GenericDialogs.EResponse eResponse) {
                    super.onNext(eResponse);
                    if (eResponse == GenericDialogs.EResponse.YES) {
                        rx.m.a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.call();
                            return;
                        }
                        return;
                    }
                    rx.m.a aVar4 = aVar2;
                    if (aVar4 != null) {
                        aVar4.call();
                    }
                }
            });
        } else {
            showMessageOKCancel(R.string.general_downloads_dialog_only_wifi_message, new SimpleSubscriber<GenericDialogs.EResponse>() { // from class: cm.aptoide.pt.permission.PermissionServiceActivity.3
                @Override // cm.aptoide.pt.utils.SimpleSubscriber, rx.f
                public void onNext(GenericDialogs.EResponse eResponse) {
                    super.onNext(eResponse);
                    if (eResponse == GenericDialogs.EResponse.YES) {
                        PermissionServiceActivity.this.getFragmentNavigator().navigateTo(AptoideApplication.getFragmentProvider().newSettingsFragment(), true);
                        return;
                    }
                    rx.m.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.call();
                    }
                }
            });
        }
    }

    private void showMessageOKCancel(String str, SimpleSubscriber<GenericDialogs.EResponse> simpleSubscriber) {
        GenericDialogs.createGenericOkCancelMessage(this, HttpUrl.FRAGMENT_ENCODE_SET, str, this.themeManager.getAttributeForTheme(R.attr.dialogsTheme).resourceId).E0(simpleSubscriber);
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToAccounts(boolean z, rx.m.a aVar, rx.m.a aVar2) {
        if (androidx.core.content.a.a(this, "android.permission.GET_ACCOUNTS") == 0) {
            Logger.getInstance().v(TAG, "already has permission to access accounts");
            if (aVar != null) {
                aVar.call();
                return;
            }
            return;
        }
        this.toRunWhenAccessToAccountsIsGranted = aVar;
        this.toRunWhenAccessToAccountsIsDenied = aVar2;
        if (z || androidx.core.app.a.t(this, "android.permission.GET_ACCOUNTS")) {
            Logger.getInstance().v(TAG, "showing rationale and requesting permission to access accounts");
            showMessageOKCancel(R.string.access_to_get_accounts_rationale, new SimpleSubscriber<GenericDialogs.EResponse>() { // from class: cm.aptoide.pt.permission.PermissionServiceActivity.1
                @Override // cm.aptoide.pt.utils.SimpleSubscriber, rx.f
                public void onNext(GenericDialogs.EResponse eResponse) {
                    super.onNext(eResponse);
                    if (eResponse == GenericDialogs.EResponse.YES) {
                        androidx.core.app.a.q(PermissionServiceActivity.this, new String[]{"android.permission.GET_ACCOUNTS"}, 62);
                    } else if (PermissionServiceActivity.this.toRunWhenAccessToAccountsIsDenied != null) {
                        PermissionServiceActivity.this.toRunWhenAccessToAccountsIsDenied.call();
                    }
                }
            });
        } else {
            androidx.core.app.a.q(this, new String[]{"android.permission.GET_ACCOUNTS"}, 62);
            Logger.getInstance().v(TAG, "requesting permission to access accounts");
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean z, rx.m.a aVar, rx.m.a aVar2) {
        requestAccessToExternalFileSystem(z, R.string.storage_access_permission_request_message, aVar, aVar2);
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean z, int i2, rx.m.a aVar, rx.m.a aVar2) {
        if (androidx.core.content.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            this.toRunWhenAccessToFileSystemIsGranted = aVar;
            this.toRunWhenAccessToFileSystemIsDenied = aVar2;
            if (!z && !androidx.core.app.a.t(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                androidx.core.app.a.q(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 61);
                Logger.getInstance().v(TAG, "requesting permission to access external storage");
                return;
            } else {
                Logger.getInstance().v(TAG, "showing rationale and requesting permission to access external storage");
                showMessageOKCancel(i2, new SimpleSubscriber<GenericDialogs.EResponse>() { // from class: cm.aptoide.pt.permission.PermissionServiceActivity.5
                    @Override // cm.aptoide.pt.utils.SimpleSubscriber, rx.f
                    public void onNext(GenericDialogs.EResponse eResponse) {
                        super.onNext(eResponse);
                        if (eResponse == GenericDialogs.EResponse.YES) {
                            androidx.core.app.a.q(PermissionServiceActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 61);
                        } else if (PermissionServiceActivity.this.toRunWhenAccessToFileSystemIsDenied != null) {
                            PermissionServiceActivity.this.toRunWhenAccessToFileSystemIsDenied.call();
                        }
                    }
                });
                return;
            }
        }
        Logger.getInstance().v(TAG, "already has permission to access external storage");
        if (aVar != null) {
            aVar.call();
        }
    }
}
