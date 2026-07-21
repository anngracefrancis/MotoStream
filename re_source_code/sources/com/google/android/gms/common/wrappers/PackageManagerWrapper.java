package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class PackageManagerWrapper {
    protected final Context a;

    public PackageManagerWrapper(Context context) {
        this.a = context;
    }

    @KeepForSdk
    public int a(String str) {
        return this.a.checkCallingOrSelfPermission(str);
    }

    @KeepForSdk
    public int b(String str, String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    @KeepForSdk
    public ApplicationInfo c(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i2);
    }

    @KeepForSdk
    public CharSequence d(String str) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }

    @KeepForSdk
    public PackageInfo e(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i2);
    }

    @KeepForSdk
    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.a(this.a);
        }
        if (!PlatformVersion.k() || (nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean g(int i2, String str) {
        if (PlatformVersion.f()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.a.getSystemService("appops");
                if (appOpsManager == null) {
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                }
                appOpsManager.checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i2);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
