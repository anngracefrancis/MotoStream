package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class DeviceProperties {
    private static Boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f12148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f12149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f12150d;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean a(Context context) {
        if (f12149c == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            f12149c = Boolean.valueOf(z);
        }
        return f12149c.booleanValue();
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean b(Context context) {
        return f(context);
    }

    @KeepForSdk
    public static boolean c() {
        int i2 = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return "user".equals(Build.TYPE);
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (a == null) {
            boolean z = false;
            if (PlatformVersion.g() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean e(Context context) {
        if (d(context) && !PlatformVersion.j()) {
            return true;
        }
        if (f(context)) {
            return !PlatformVersion.k() || PlatformVersion.n();
        }
        return false;
    }

    @TargetApi(21)
    public static boolean f(Context context) {
        if (f12148b == null) {
            boolean z = false;
            if (PlatformVersion.h() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            f12148b = Boolean.valueOf(z);
        }
        return f12148b.booleanValue();
    }

    public static boolean g(Context context) {
        if (f12150d == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            f12150d = Boolean.valueOf(z);
        }
        return f12150d.booleanValue();
    }
}
