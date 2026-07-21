package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @KeepForSdk
    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo packageInfoB = b(context, str);
        if (packageInfoB == null || (applicationInfo = packageInfoB.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @KeepForSdk
    public static PackageInfo b(Context context, String str) {
        try {
            return Wrappers.a(context).e(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static boolean c() {
        return false;
    }
}
