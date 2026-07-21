package com.google.android.gms.common.stats;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@Deprecated
public class WakeLockTracker {
    private static WakeLockTracker a = new WakeLockTracker();

    @KeepForSdk
    public static WakeLockTracker a() {
        return a;
    }

    @KeepForSdk
    public void b(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list) {
    }

    @KeepForSdk
    public void c(Context context, String str, int i2, String str2, String str3, String str4, int i3, List<String> list, long j2) {
    }
}
