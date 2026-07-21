package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class CrashUtils {
    private static final String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    @KeepForSdk
    public static boolean a(Context context, Throwable th) {
        try {
            Preconditions.k(context);
            Preconditions.k(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
