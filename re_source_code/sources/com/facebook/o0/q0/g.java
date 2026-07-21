package com.facebook.o0.q0;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.facebook.a0;
import com.facebook.internal.p0;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppEventUtility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final g a = new g();

    private g() {
    }

    public static final void a() {
    }

    public static final void b() {
    }

    public static final String c(byte[] bArr) {
        kotlin.jvm.internal.m.f(bArr, "bytes");
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            i2++;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            kotlin.jvm.internal.m.e(str, "java.lang.String.format(format, *args)");
            stringBuffer.append(str);
        }
        String string = stringBuffer.toString();
        kotlin.jvm.internal.m.e(string, "sb.toString()");
        return string;
    }

    public static final String d() {
        a0 a0Var = a0.a;
        Context contextC = a0.c();
        try {
            String str = contextC.getPackageManager().getPackageInfo(contextC.getPackageName(), 0).versionName;
            kotlin.jvm.internal.m.e(str, "{\n      val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)\n      packageInfo.versionName\n    }");
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public static final View e(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006b  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    public static final boolean f() {
        String str = Build.FINGERPRINT;
        kotlin.jvm.internal.m.e(str, "FINGERPRINT");
        if (!u.E(str, "generic", false, 2, null)) {
            kotlin.jvm.internal.m.e(str, "FINGERPRINT");
            if (!u.E(str, "unknown", false, 2, null)) {
                String str2 = Build.MODEL;
                kotlin.jvm.internal.m.e(str2, "MODEL");
                if (!v.J(str2, "google_sdk", false, 2, null)) {
                    kotlin.jvm.internal.m.e(str2, "MODEL");
                    if (!v.J(str2, "Emulator", false, 2, null)) {
                        kotlin.jvm.internal.m.e(str2, "MODEL");
                        if (!v.J(str2, "Android SDK built for x86", false, 2, null)) {
                            String str3 = Build.MANUFACTURER;
                            kotlin.jvm.internal.m.e(str3, "MANUFACTURER");
                            if (!v.J(str3, "Genymotion", false, 2, null)) {
                                String str4 = Build.BRAND;
                                kotlin.jvm.internal.m.e(str4, "BRAND");
                                if (u.E(str4, "generic", false, 2, null)) {
                                    String str5 = Build.DEVICE;
                                    kotlin.jvm.internal.m.e(str5, "DEVICE");
                                    if (!u.E(str5, "generic", false, 2, null)) {
                                        if (kotlin.jvm.internal.m.a("google_sdk", Build.PRODUCT)) {
                                            return false;
                                        }
                                    }
                                } else if (kotlin.jvm.internal.m.a("google_sdk", Build.PRODUCT)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static final double g(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([.,]\\d+)*([.,]\\d+)?", 8).matcher(str);
            if (!matcher.find()) {
                return 0.0d;
            }
            String strGroup = matcher.group(0);
            p0 p0Var = p0.a;
            return NumberFormat.getNumberInstance(p0.y()).parse(strGroup).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }
}
