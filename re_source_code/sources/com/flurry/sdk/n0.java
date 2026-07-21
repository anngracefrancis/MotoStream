package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    private static n0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10928d = String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", 328, 13, 0, 1, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);

    private n0() {
    }

    public static synchronized n0 a() {
        if (a == null) {
            a = new n0();
        }
        return a;
    }

    private static String c() {
        try {
            Context contextA = b0.a();
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            String str = packageInfo.versionName;
            if (str != null) {
                return str;
            }
            int i2 = packageInfo.versionCode;
            return i2 != 0 ? Integer.toString(i2) : "Unknown";
        } catch (Throwable th) {
            d1.d(6, "VersionProvider", HttpUrl.FRAGMENT_ENCODE_SET, th);
            return "Unknown";
        }
    }

    public final synchronized String b() {
        if (!TextUtils.isEmpty(this.f10926b)) {
            return this.f10926b;
        }
        if (!TextUtils.isEmpty(this.f10927c)) {
            return this.f10927c;
        }
        String strC = c();
        this.f10927c = strC;
        return strC;
    }
}
