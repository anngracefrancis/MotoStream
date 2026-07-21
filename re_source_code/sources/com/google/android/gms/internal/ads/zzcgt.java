package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgt {
    public static PackageInfo a(Context context, ApplicationInfo applicationInfo) {
        try {
            return Wrappers.a(context).e(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
