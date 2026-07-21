package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@Deprecated
public class StatsUtils {
    @KeepForSdk
    public static String a(PowerManager.WakeLock wakeLock, String str) {
        String strValueOf = String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock)));
        if (true == TextUtils.isEmpty(str)) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return String.valueOf(strValueOf).concat(String.valueOf(str));
    }
}
