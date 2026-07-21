package io.sentry.android.core;

import android.os.Build;
import io.sentry.s4;
import io.sentry.w1;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: BuildInfoProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class s0 {
    final w1 a;

    public s0(w1 w1Var) {
        this.a = (w1) io.sentry.util.q.c(w1Var, "The ILogger object is required.");
    }

    public String a() {
        return Build.TAGS;
    }

    public String b() {
        return Build.MANUFACTURER;
    }

    public String c() {
        return Build.MODEL;
    }

    public int d() {
        return Build.VERSION.SDK_INT;
    }

    public String e() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0093  */
    public Boolean f() {
        boolean z;
        try {
            if (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) {
                z = true;
            } else {
                String str = Build.FINGERPRINT;
                if (str.startsWith("generic") || str.startsWith("unknown")) {
                    z = true;
                } else {
                    String str2 = Build.HARDWARE;
                    if (str2.contains("goldfish") || str2.contains("ranchu")) {
                        z = true;
                    } else {
                        String str3 = Build.MODEL;
                        if (str3.contains("google_sdk") || str3.contains("Emulator") || str3.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
                            z = true;
                        } else {
                            String str4 = Build.PRODUCT;
                            if (str4.contains("sdk_google") || str4.contains("google_sdk") || str4.contains("sdk") || str4.contains("sdk_x86") || str4.contains("vbox86p") || str4.contains("emulator") || str4.contains("simulator")) {
                                z = true;
                            } else {
                                z = false;
                            }
                        }
                    }
                }
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            this.a.b(s4.ERROR, "Error checking whether application is running in an emulator.", th);
            return null;
        }
    }
}
