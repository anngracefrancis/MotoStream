package com.google.android.gms.common.util;

import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@KeepForSdk
public final class PlatformVersion {
    private PlatformVersion() {
    }

    @KeepForSdk
    public static boolean a() {
        return true;
    }

    @KeepForSdk
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 15;
    }

    @KeepForSdk
    public static boolean c() {
        return Build.VERSION.SDK_INT >= 16;
    }

    @KeepForSdk
    public static boolean d() {
        return Build.VERSION.SDK_INT >= 17;
    }

    @KeepForSdk
    public static boolean e() {
        return Build.VERSION.SDK_INT >= 18;
    }

    @KeepForSdk
    public static boolean f() {
        return Build.VERSION.SDK_INT >= 19;
    }

    @KeepForSdk
    public static boolean g() {
        return Build.VERSION.SDK_INT >= 20;
    }

    @KeepForSdk
    public static boolean h() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @KeepForSdk
    public static boolean i() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @KeepForSdk
    public static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @KeepForSdk
    public static boolean k() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @KeepForSdk
    public static boolean m() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @KeepForSdk
    public static boolean n() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @KeepForSdk
    public static boolean o() {
        return Build.VERSION.SDK_INT >= 31;
    }
}
