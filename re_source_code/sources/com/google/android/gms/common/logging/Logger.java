package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class Logger {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GmsLogger f12086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12087d;

    @KeepForSdk
    public Logger(String str, String... strArr) {
        String string;
        if (strArr.length == 0) {
            string = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str2 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str2);
            }
            sb.append("] ");
            string = sb.toString();
        }
        this.f12085b = string;
        this.a = str;
        this.f12086c = new GmsLogger(str);
        int i2 = 2;
        while (i2 <= 7 && !Log.isLoggable(this.a, i2)) {
            i2++;
        }
        this.f12087d = i2;
    }

    @KeepForSdk
    public void a(String str, Object... objArr) {
        if (d(3)) {
            Log.d(this.a, c(str, objArr));
        }
    }

    @KeepForSdk
    public void b(String str, Object... objArr) {
        Log.e(this.a, c(str, objArr));
    }

    @KeepForSdk
    protected String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f12085b.concat(str);
    }

    @KeepForSdk
    public boolean d(int i2) {
        return this.f12087d <= i2;
    }
}
